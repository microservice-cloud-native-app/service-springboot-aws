package com.poc.boldconnect.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class RestTemplateAspect {

    private static Logger LOG = LoggerFactory.getLogger(RestTemplateAspect.class);

    @Pointcut("execution(public * org.springframework.web.client.RestOperations.*(..))")
    public void weaveExecute() {

    }


    @Around("weaveExecute()")
    public Object aroundWeave(ProceedingJoinPoint pjp) throws Throwable { // NOSONAR - Edge case not fully supported by Sonar, dependency throws Throwable
        MethodSignature sig = (MethodSignature) pjp.getSignature();
        Object[] args = pjp.getArgs();
        //Put the url here
        LOG.error("args {}", args);
        args[0] = "http://sequence-diagram-dev.cfapps-gt1-dev.nam.nsroot.net/demo.html";

        LOG.info("sig " + sig.getMethod());
        LOG.error("args {}", args);

        return pjp.proceed(args);

    }
}
