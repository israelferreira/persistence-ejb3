package com.israelferreira.persistence.ejb3.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LoggingInterceptor {

	@AroundInvoke
	public Object interceptor(InvocationContext ic) throws Exception {
		
		/** This method shows using the console when a method is called **/
		// System.out.println("Calling the method: " + ic.getMethod());
		
		Object methodReturn = ic.proceed();
		
		/** This method shows using the console when a method has finished **/
		// System.out.println ("METHOD " + ic.getMethod() + " HAS FINISHED");
		
		return methodReturn;
	}
}
