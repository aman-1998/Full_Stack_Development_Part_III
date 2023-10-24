package personal.learning.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import personal.learning.model.dao.ProductDAO;
import personal.learning.model.entity.Product;

@Service
public class ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	private ProductDAO productRepo;
	
	public List<Product> getProductsByBrandId(int brandId) {
		List<Product> productList =  productRepo.getProductsByBrandId(brandId);
		if(productList.isEmpty()) {
			logger.warn("Product with brand_id["+brandId+"] doesn't exist");
		}
		return productList;
	}

	public List<Product> getProductsByBrandIdAndCategory(int brandId, String category) {
		List<Product> productList = productRepo.getProductsByBrandIdAndCategory(brandId, category);
		if(productList.isEmpty()) {
			logger.warn("Product with brand_id["+brandId+"] and category["+category+"] doesn't exist");
		}
		return productList;
	}

}
