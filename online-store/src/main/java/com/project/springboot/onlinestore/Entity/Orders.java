package com.project.springboot.onlinestore.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="orders")
public class Orders {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_number")
	private int orderNumber;
	
	@Column(name="quantity_ordered")
	private int quantity;
	
	@Column(name="order_date")
	private Date orderDate;
	
	@Column(name="status")
	private String status;
	
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE })
	@JoinColumn(name="user_id")
	private Users user;
	
	@ManyToMany(fetch = FetchType.LAZY ,cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE })
	@JoinTable(name="order_product",
				joinColumns = @JoinColumn(name="order_number"),
				inverseJoinColumns = @JoinColumn(name="product_id")			
			)
	private List<Product> products;

	public Orders() {}
	
	public Orders(int quantity, Date orderDate, String status, Users user, List<Product> products) {
		super();
		this.quantity = quantity;
		this.orderDate = orderDate;
		this.status = status;
		this.user = user;
		this.products = products;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	
	
	
	
	

}
