package com.project.springboot.onlinestore.Entity;

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
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="vendor")
@NamedQuery(name="VendorDetails.byLnoEmail", query="from Vendor where email= :eMail")
public class Vendor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vendor_id")
	private int vendorId;
	
	@Column(name="vendor_name")
	private String vendorName;
	
	@Column(name="vendor_location")
	private String vendorLocation;
	
	@Column(name="license_number")
	private String licenseNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobile_number")
	private String mobNo;
	
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY ,cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE })
	@JoinTable(name="product_vendor",
				joinColumns = @JoinColumn(name="vendor_id"),
				inverseJoinColumns = @JoinColumn(name="product_id")			
			)
	private List<Product> products;


	public Vendor(String vendorName, String vendorLocation, String licenseNumber, String email, String mobNo,
			List<Product> products) {
		super();
		this.vendorName = vendorName;
		this.vendorLocation = vendorLocation;
		this.licenseNumber = licenseNumber;
		this.email = email;
		this.mobNo = mobNo;
		this.products = products;
	}
	
	public Vendor() {}


	public String getVendorName() {
		return vendorName;
	}


	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}


	public String getVendorLocation() {
		return vendorLocation;
	}


	public void setVendorLocation(String vendorLocation) {
		this.vendorLocation = vendorLocation;
	}


	public String getLicenseNumber() {
		return licenseNumber;
	}


	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobNo() {
		return mobNo;
	}


	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}

	
	
	
	
}
