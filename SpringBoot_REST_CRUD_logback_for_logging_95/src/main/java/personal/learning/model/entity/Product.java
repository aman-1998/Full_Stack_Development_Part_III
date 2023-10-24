package personal.learning.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity(name = "PRODUCT")
@Table(name = "PRODUCT")
public class Product {
	
	@Id
	@Column(name="PRODUCT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
	@SequenceGenerator(name = "product_generator", sequenceName = "PRODUCT_SEQUENCE", allocationSize = 1)
	private int productId;
	
//	@Column(name="BRAND_ID")
//	private int brandId;
	
	@ManyToOne(targetEntity = Brand.class)
	@JoinColumn(name = "BRAND_ID")
	private Brand brand;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="CATEGORY")
	private String category;
	
	public Product(int productId, Brand brand, String productName, String category) {
		this.productId = productId;
		this.brand = brand;
		this.productName = productName;
		this.category = category;
	}
	
	public Product() {
		productId = 0;
		this.brand = new Brand();
		this.productName = "###";
		category = "###";
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
}
