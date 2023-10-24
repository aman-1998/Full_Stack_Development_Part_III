package personal.learning.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import personal.learning.model.dao.ProductDAO;
import personal.learning.model.entity.Product;

public class ProductService {

	@Autowired
	private ProductDAO productRepo;
	
	public List<Product> getProductsByBrandId(int brandId) {
		return productRepo.getProductsByBrandId(brandId);
	}

	public List<Product> getProductsByBrandIdAndCategory(int brandId, String category) {
		return productRepo.getProductsByBrandIdAndCategory(brandId, category);
	}

}
