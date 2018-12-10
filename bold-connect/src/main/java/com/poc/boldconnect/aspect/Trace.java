package com.poc.boldconnect.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;



@Aspect
@Component
@Profile({"dev1","dev2","dev3","default"})
public class Trace {
    private static Logger LOG = LoggerFactory.getLogger(Trace.class);


    public class ProceedingJoinPointResponse {
        private Map<String, String> headers = new HashMap<String, String>();
        private Method method = null;
        private Object request = null;
        private Object response = null;
        private Map<String, Object> requestParams = new HashMap<>();
        private Map<String, Object> pathVariables = new HashMap<>();
    }

    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object weave(ProceedingJoinPoint jp) throws Throwable { // NOSONAR - Edge case not fully supported by Sonar, dependency throws Throwable
        ProceedingJoinPointResponse pJPResponse = null;
        pJPResponse = work(jp);
        logMethod(pJPResponse);
        logRequest(pJPResponse);
        Object response = jp.proceed();
        logResponse(response);
        return response;
    }

    private ProceedingJoinPointResponse work(ProceedingJoinPoint pjp) {
        ProceedingJoinPointResponse pJPResponse = new ProceedingJoinPointResponse();
        MethodSignature sig = (MethodSignature) pjp.getSignature();
        pJPResponse.method = sig.getMethod();
        Object[] argValues = pjp.getArgs();

        final Annotation[][] paramAnnotations = pJPResponse.method.getParameterAnnotations();
        for (int i = 0; i < paramAnnotations.length; i++) {
            for (Annotation a : paramAnnotations[i]) {
                if (a instanceof org.springframework.web.bind.annotation.RequestHeader) {
                    pJPResponse.headers.put(((org.springframework.web.bind.annotation.RequestHeader) a)
                            .value(), (String) argValues[i]);
                }
                if (a instanceof org.springframework.web.bind.annotation.RequestBody) {
                    pJPResponse.request = argValues[i];
                }
                if (a instanceof org.springframework.web.bind.annotation.RequestParam) {
                    pJPResponse.requestParams.put(((RequestParam) a).name(), argValues[i]);
                }
                if (a instanceof org.springframework.web.bind.annotation.PathVariable) {
                    pJPResponse.pathVariables.put(((PathVariable) a).value(), argValues[i]);
                }
            }
        }
        return pJPResponse;
    }

    private String logHeaders(ProceedingJoinPointResponse pJPResponse) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Request headers :: ");
        pJPResponse.headers.forEach((k, v) -> stringBuffer.append(k + " : " + v + "|"));
        return stringBuffer.toString();
    }

    private String logParams(ProceedingJoinPointResponse pJPResponse) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Request params :: ");
        pJPResponse.requestParams.forEach((k, v) -> stringBuffer.append(k + " : " + v + "|"));
        return stringBuffer.toString();
    }

    private String logPathVariables(ProceedingJoinPointResponse pJPResponse) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Path  variables :: ");
        pJPResponse.pathVariables.forEach((k, v) -> stringBuffer.append("/" + v + "|"));
        return stringBuffer.toString();
    }

    private void logRequest(ProceedingJoinPointResponse pJPResponse) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Request :: " + pJPResponse.request + " || " + logHeaders(pJPResponse) + " || " + logParams(pJPResponse) + " || " + logPathVariables(pJPResponse));
        LOG.debug(stringBuffer.toString());

    }

    private void logMethod(ProceedingJoinPointResponse pJPResponse) {
        LOG.info("Method :: " + pJPResponse.method.getName());
    }


    private void logResponse(Object response) {
        LOG.debug("Response :: " + response);
    }
}
