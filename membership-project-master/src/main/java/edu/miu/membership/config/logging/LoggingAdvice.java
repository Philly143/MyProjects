package edu.miu.membership.config.logging;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAdvice {

    private ObjectMapper mapper = new ObjectMapper();

    Logger logger = LogManager.getLogger(LoggingAdvice.class);

    @Pointcut(value  ="execution(* *.*.*(..)))")
    public void getPointCut() {

    }

    @Around("getPointCut()")
    public Object logging(ProceedingJoinPoint jp) throws Throwable {
        String className = jp.getSignature().getDeclaringTypeName();
        String methodName = jp.getSignature().getName();
        logger.info("Enter to class -> "+ className+", In method -> " + methodName + "()" + " with Arguments :"
                + mapper.writeValueAsString(jp.getArgs()));
        Object args = jp.proceed();
        logger.info(methodName + " invoked, Return -> " + mapper.writeValueAsString(args));
        return args;
    }
}
