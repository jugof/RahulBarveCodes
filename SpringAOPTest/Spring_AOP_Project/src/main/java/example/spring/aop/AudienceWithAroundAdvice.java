package example.spring.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AudienceWithAroundAdvice {
	@Pointcut("execution (* example.spring.aop.*.perform(..))")
	private void myPointCut() {}
	
	private void takeSeats() {
		System.out.println("Please take your seats from Around Advice");
	}
	
	private void turnOffMobile() {
		System.out.println("Please turn OFF your mobile from Around Advice");
	}
	
	private void clap() {
		System.out.println("Clap clap clap from Around Advice");
	}
	
	private void demandForRefund() {
		System.out.println("Please give me my money back from Around Advice");
	}
	
	private void leave() {
		System.out.println("Bye, leaving now from Around Advice");
	}
	
	@Around("myPointCut()")
	public void monitorPerformance(ProceedingJoinPoint joinPointRef) {
		try {
			takeSeats();
			turnOffMobile();
			//Call target bean's method: perform()
			joinPointRef.proceed();
			clap();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			demandForRefund();
		}
		leave();		
	}
}
