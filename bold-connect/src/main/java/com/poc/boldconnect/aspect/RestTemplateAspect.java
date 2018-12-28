package com.poc.boldconnect.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestTemplateAspect {

    @Pointcut("execution(public * org.springframework.web.client.RestTemplate.execute(..)")
    public void weaveExecute(){

        System.err.println("ResT Template PointCut Invoked for Execute");

    } @Pointcut("this(public * org.springframework.web.client.RestTemplate.")
    public void weaveRest(){

        System.err.println("ResT Template PointCut Invoked");

    }
}
