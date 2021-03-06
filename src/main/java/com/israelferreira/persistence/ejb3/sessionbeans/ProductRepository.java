package com.israelferreira.persistence.ejb3.sessionbeans;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.israelferreira.persistence.ejb3.entities.Product;
import com.israelferreira.persistence.ejb3.interceptors.CensorshipInterceptor;

@Stateless
public class ProductRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Resource
	private SessionContext context;
	
	@Interceptors({CensorshipInterceptor.class})
	public void add(Product product) {
		this.manager.persist(product);

		if(product.getPrice() < 0) {
			this.context.setRollbackOnly();
		}
	}
	
	public List<Product> getProducts() {
		TypedQuery<Product> query = this.manager.createQuery(
			"select x from Product x", Product.class);
		
		return query.getResultList();
	}
		
}
