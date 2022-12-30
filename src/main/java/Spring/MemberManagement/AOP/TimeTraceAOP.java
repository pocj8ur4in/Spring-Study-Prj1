package Spring.MemberManagement.AOP;

import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
public class TimeTraceAOP {
    public Object execute(MethodInvocationProceedingJoinPoint JP) throws Throwable{
        long start = System.currentTimeMillis();

        System.out.println("시작: " + JP.toString());

        try {
            return JP.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;

            System.out.println("종료: " + JP.toString() + " " + timeMs + "ms");
        }
    }
}
