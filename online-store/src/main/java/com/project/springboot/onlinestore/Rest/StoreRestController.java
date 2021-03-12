package com.project.springboot.onlinestore.Rest;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.springboot.onlinestore.Entity.Orders;
import com.project.springboot.onlinestore.Entity.Product;
import com.project.springboot.onlinestore.Entity.UserCredentials;
import com.project.springboot.onlinestore.Entity.Users;
import com.project.springboot.onlinestore.Entity.Vendor;
import com.project.springboot.onlinestore.Service.ProductService;
import com.project.springboot.onlinestore.Service.UsersService;
import com.project.springboot.onlinestore.Service.VendorService;

import org.apache.commons.io.IOUtils;
import java.io.InputStream;

@RestController
@RequestMapping("/api")
public class StoreRestController {

	private UsersService userService;
	private VendorService vendorService;
	private ProductService productService;

	@Autowired
	public StoreRestController(UsersService userService, VendorService vendorService, ProductService productService) {

		this.userService = userService;
		this.vendorService = vendorService;
		this.productService = productService;
	}

	/*
	 * @PostConstruct public void FirstMethod() {
	 * 
	 * Users user=new Users(); user.setFirstName("Sudipto");
	 * user.setLastName("Roy"); user.setHouseNo("MB-136");
	 * user.setMobNo("7044527754"); user.setPin("700102");
	 * 
	 * }
	 */

	@GetMapping("/users")
	public List<Users> findAll() {
		System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSS");
		return userService.findAll();
	}

	@PostMapping("/users/addNew")
	public void addNewUser(@RequestBody Users user) {

		user.setFirstName("Sudipto");
		user.setLastName("Roy");
		user.setHouseNo("MB-136");
		user.setMobNo("888888");
		user.setPin("999999");

		UserCredentials ucred = new UserCredentials();

		ucred.setBlocked("N");
		ucred.setLoginName("SR12341");
		ucred.setPassword("10001");

		user.setUserCredentials(ucred);

		/*
		 * Product product=new Product(); product.setBuyPrice(200);
		 * product.setProductCategory("vegetables"); product.setQuantityInStock(20);
		 * product.setProductDescription("Potato");
		 * 
		 * List<Product> products=new ArrayList<Product>(); products.add(product);
		 */

		Orders order = new Orders();
		/* order.setProducts(products); */
		order.setQuantity(100);
		order.setStatus("IN PROGRESS");

		Orders order1 = new Orders();
		/* order.setProducts(products); */
		order1.setQuantity(5000);
		order1.setStatus("COMPLETED");

		/*
		 * user.add(order); user.add(order1);
		 * 
		 * userService.save(order); userService.save(order1);
		 */
		// return null;
	}

	// registering a new user
	@PostMapping("/users/register")
	@CrossOrigin(origins = "http://localhost:4200")
	public Users registerNewUser(@RequestBody Users user) {

		/*
		 * user.setFirstName("Pradip"); user.setLastName("Roy");
		 * user.setHouseNo("MB-136"); user.setMobNo("9330950091");
		 * user.setPin("700102"); user.setEmail("pradip.roy.004@gmail.com");
		 * user.setLocality("Mahish Bathan"); user.setState("West Bengal");
		 * 
		 * UserCredentials ucred=new UserCredentials();
		 * 
		 * ucred.setBlocked("N"); ucred.setLoginName("PR1234");
		 * ucred.setPassword("Pradip##123"); ucred.setBlockedUntil(null);
		 * ucred.setFailedAttempts(0); ucred.setLastFailedLogin(null);
		 * ucred.setBlocked("No"); Date date=new Date();
		 * ucred.setLastSuccessfulLogin(date);
		 * 
		 * user.setUserCredentials(ucred);
		 */

		UserCredentials ucred = user.getUserCredentials();
		Date date = new Date();
		System.out.println("Date is " + date);
		ucred.setLastSuccessfulLogin(date);
		user.setUserCredentials(ucred);

		userService.save(user);
		return user;
	}

	// Adding new product and linking the vendor with it
	@PostMapping("/product/newProduct/{vendor_id}")
	public void addNewProduct(@RequestBody Product product, @PathVariable("vendor_id") int vendor_id) {

		/*
		 * product.setProductCategory("Vegetables"); product.setBuyPrice(100);
		 * product.setProductDescription("Potato from Rajasthan");
		 * product.setProductName("Potato"); product.setQuantityInStock(40);
		 * product.setSellPrice(120);
		 */

		product.setVendor(vendorService.findById(vendor_id));
		productService.save(product);

	}

	// Adding new vendor
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/vendor/newVendor")
	public Vendor addNewVendor(@RequestBody Vendor vendor) {

		vendorService.save(vendor);
		return vendor;

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/vendor/getVendorDetails/{licenseNumber}/{email}")
	public List<Vendor> getVendorDetails(@PathVariable String licenseNumber, @PathVariable String email) {

		System.out.println("ABCD");

		return vendorService.findVendor(licenseNumber, email);

	}

	 //Add a new product getting the vendor license number as input
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/product/newProductUsingLicenseNumber/{lNumber}")
	public void addNewProductUsingLicenseNumber(@RequestBody Product product, @PathVariable("lNumber") String lNumber) {

		
		product.setVendor(vendorService.findByLicenseNumber(lNumber));
		productService.save(product);

	}
	
	
	//Add a new order 
	
	
	//
	
	//get image
	
	@GetMapping(value = "/get-image", produces = MediaType.IMAGE_JPEG_VALUE )
	public @ResponseBody byte[] getImageWithMediaType() throws IOException {
	    InputStream in = getClass().getResourceAsStream("/image/fresh-vegetables-fruits.jpg");    
	    return IOUtils.toByteArray(in);
	}
	
	

}
