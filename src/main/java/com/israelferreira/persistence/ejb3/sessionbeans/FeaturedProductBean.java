package com.israelferreira.persistence.ejb3.sessionbeans;

import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

import com.israelferreira.persistence.ejb3.entities.Product;

@Singleton
public class FeaturedProductBean {

	@EJB
	private ProductRepository productRepository;
	
	private Product featuredProduct;
	
	@Schedule(second = "*/5", minute="*", hour="*")
	public void changeFeaturedProduct() {
		Random generator = new Random();
		List<Product> products = this.productRepository.getProducts();
		if(!products.isEmpty()) {
			int i = generator.nextInt(products.size());
			this.featuredProduct = products.get(i);
		}		
	}

	public Product getFeaturedProduct() {
		return featuredProduct;
	}

	public void setFeaturedProduct(Product featuredProduct) {
		this.featuredProduct = featuredProduct;
	}
	
}
