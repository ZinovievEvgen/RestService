package helback.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Pointcut("execution(* helback.*.*.*(..))")
    public void methodExecuting() {
    }

    @AfterReturning(value = "methodExecuting()", returning = "returningValue")
    public void recordSuccessfulExecution(JoinPoint joinPoint, Object returningValue) {
        if (returningValue != null) {
            logger.info("Успешно выполнен метод: " + joinPoint.getSignature().getName()
                    + "  класса: " + joinPoint.getSourceLocation().getWithinType().getName()
                    + " с результатом выполнения: " + returningValue);
        } else {
            logger.info("Успешно выполнен метод: " + joinPoint.getSignature().getName()
                    + "  класса: " + joinPoint.getSourceLocation().getWithinType().getName());
        }
    }

    @AfterThrowing(value = "methodExecuting()", throwing = "exception")
    public void recordFailedExecution(JoinPoint joinPoint, Exception exception) {
        logger.warning("Метод:" + joinPoint.getSignature().getName()
                + " класса: " + joinPoint.getSourceLocation().getWithinType().getName()
                + " был аварийно завершен с исключением: " + exception);
    }
}
