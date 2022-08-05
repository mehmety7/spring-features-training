package com.trial.springaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
@Slf4j
public class AfterOperationAspect {

    @Before(value = "execution(* com.trial.springaop.service.*.*(..))")
    public void before(JoinPoint joinPoint) {
        log.info("{} operation will execute", joinPoint.getStaticPart().toString().replace("execution(", ""));
    }

    @AfterReturning(value = "execution(* com.trial.springaop.service.*.*(..))",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        log.info("{} operation returned with value {}", joinPoint.getStaticPart().toString().replace("execution(", ""), result);
    }

    @After(value = "execution(* com.trial.springaop.service.*.*(..))")
    public void after(JoinPoint joinPoint) {
        log.info("{} operation is executed", joinPoint.getStaticPart().toString().replace("execution(", ""));
    }

    @AfterThrowing(value = "execution(* com.trial.springaop.service.*.*(..))",
            throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        log.info("{} operation thrown {}", joinPoint.getStaticPart().toString().replace("execution(", ""), ex);
    }
}
