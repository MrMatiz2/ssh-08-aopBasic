package com.example.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* com.example.services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().getName();
        Object [] args = joinPoint.getArgs();

        logger.info("Method "+ methodName +
                " with parameters " + Arrays.asList(args) +
                " will execute");

        //Comment comment = new Comment();
        //comment.setAuthor("Claudia");
        //comment.setText("Another example text");
        //Object [] newArguments = {comment}

        //Se puede llamar al método interceptado cambiando los parámetros
        //Object returnedByMethod = joinPoint.proceed(newArguments);

        Object returnedByMethod = joinPoint.proceed();

        logger.info("Method executed and returned " + returnedByMethod);

        return returnedByMethod;
        //Se puede cambiar lo retornado por el método interceptado
        //return "FAILED"
    }
}
