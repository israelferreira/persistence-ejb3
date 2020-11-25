package com.israelferreira.persistence.ejb3.interceptors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import com.israelferreira.persistence.ejb3.entities.Product;

public class CensorshipInterceptor implements Serializable {	
	
	private static final long serialVersionUID = 1L;
		
	private List<String> forbiddenWords = new ArrayList<String>();
	
	 public CensorshipInterceptor() {
		 this.forbiddenWords.add("github");
		 this.forbiddenWords.add("java");
		 this.forbiddenWords.add("ejb");
	}
	
	 @AroundInvoke
	 public Object interceptador(InvocationContext ic) throws Exception {
		 Object[] parameters = ic.getParameters();
		 Product product = (Product)parameters[0];
	
		 for (String forbiddenWord : this.forbiddenWords) {
			String originalText = product.getName();
			String censoredText = originalText.replaceAll(forbiddenWord, "!CENSURADO!");
			product.setName(censoredText);
		 }
		 
		 return ic.proceed();
	 }
	
}
