package personal.learning.model;

import java.util.List;

public class Brand {
	private String brandName;
	private int brandId;
	private List<Link> links;
	
	public Brand() {}

	public Brand(String brandName) {
		this.brandName = brandName;
	}

	public Brand(String brandName, int brandId) {
		this.brandName = brandName;
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
}
