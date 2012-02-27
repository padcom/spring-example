package org.example.spring.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.JoinPoint;

@Aspect
public class ExampleAspect {
	// a Pointcut definition to be re-used later on in @Before and other advices
	@Pointcut("execution(* org.example.spring.services.Printer.print(String)) && args(data)")
	// pointcut definition (name and parameter list)
	protected void printActionExecutePointcut(String data) {}

	@Before("printActionExecutePointcut(data)")
	public void before(String data) {
		System.out.println("ExampleAspect.before() - " + data);
	}

	@After("printActionExecutePointcut(data)")
	public void after(String data) {
		System.out.println("ExampleAspect.after() - " + data);
	}

	// Pointcuts aren't necessary if we don't want them. We can specify the expression directly
	@Before("execution(* org.example.spring.services.Formatter.*(..)) && args(format,..)")
	public void beforeFormat(String format) {
		System.out.println("ExampleAspect.beforeFormat() - " + format);
	}

	// Around advices are most powerful as they allow one to skip the invocation completely
	// and provide the Before and After functionality at once
	@Around("execution(* org.example.spring.services..*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		try {
			System.out.println("ExampleAspect.around() - begin");
			return pjp.proceed();
		} finally {
			System.out.println("ExampleAspect.around() - end");
		}
	}

	// If you want to know the thing that's being executed define JoinPoint as first parameter
	@Before("execution(* org.example.spring.services.Action.execute(..)) && args(data,..)")
	public void beforeAction(JoinPoint joinPoint, String data) {
		System.out.println("ExampleAspect.beforeAction - " + joinPoint + " / data: " + data);
		System.out.println("ExampleAspect.beforeAction - " + joinPoint.getTarget());
		System.out.println("ExampleAspect.beforeAction - " + joinPoint.getTarget().getClass());
	}
}
