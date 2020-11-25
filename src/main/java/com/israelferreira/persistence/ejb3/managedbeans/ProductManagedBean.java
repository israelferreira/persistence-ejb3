package com.israelferreira.persistence.ejb3.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.israelferreira.persistence.ejb3.entities.Product;
import com.israelferreira.persistence.ejb3.sessionbeans.FeaturedProductBean;
import com.israelferreira.persistence.ejb3.sessionbeans.ProductRepository;

@Named
@ViewScoped
public class ProductManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ProductRepository repository;
	
	@EJB
	private FeaturedProductBean featuredProductBean;
	
	private Product product = new Product();
	
	private List<Product> productsCache;
	
	public void add() {
		this.repository.add(this.product);
		this.product = new Product();
		this.productsCache = null;
	}
		
	public List<Product> getProducts() {
		if (this.productsCache == null) {
			this.productsCache = this.repository.getProducts();
		}
		return this.productsCache;
	}

	public Product getFeaturedProduct() {
		return this.featuredProductBean.getFeaturedProduct();
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
