package personal.learning.services;

import java.util.List;

import personal.learning.model.dao.ProductDAO;
import personal.learning.model.entity.Product;

public class ProductService {

	ProductDAO dao = new ProductDAO();
	
	public List<Product> getProductsByBrandId(int brandId) {
		return dao.getProductsByBrandId(brandId);
	}

	public List<Product> getProductsByBrandIdAndCategory(int brandId, String category) {
		return dao.getProductsByBrandIdAndCategory(brandId, category);
	}

}
