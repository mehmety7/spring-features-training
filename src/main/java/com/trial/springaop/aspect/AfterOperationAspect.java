package com.trial.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AfterOperationAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @After(value = "execution(* com.trial.springaop.service.*.*(..))")
    public void after(JoinPoint joinPoint) {
        logger.info("{} operation is executed", joinPoint);
    }

    @AfterReturning(value = "execution(* com.trial.springaop.service.*.*(..))",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("{} operation returned with value {}", joinPoint, result);
    }

    @AfterThrowing(value = "execution(* com.trial.springaop.service.*.*(..))",
            throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        logger.info("{} operation thrown {}", joinPoint, ex);
    }
}
