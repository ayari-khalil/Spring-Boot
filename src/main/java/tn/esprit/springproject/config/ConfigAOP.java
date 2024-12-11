package tn.esprit.springproject.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ConfigAOP {
 /*   @Before("execution(* tn.esprit.springproject.services.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name =joinPoint.getSignature().getName();
        log.info("bienvenu dans le service : " + name);
    }

    @Around("execution(* tn.esprit.springproject.services.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        Long start = System.currentTimeMillis();
        log.info("Around 1");
        Object obj = pjp.proceed();

        log.info("Around 2");
        Long elapsedTime=System.currentTimeMillis() -start;

        log.info("Methodexecutiontime" + elapsedTime + " milliseconds..");
        return obj;
    }
*/
    @AfterReturning("execution(* tn.esprit.springproject.services.*.*(..))")
    public void displayWelcomeMessage(JoinPoint joinPoint) {
        String name =joinPoint.getSignature().getName();
        log.info("bienvenu TWIN2 : " + name);
    }
}
