package personal.learning.services;

import java.util.List;

import personal.learning.dao.ProductDAO;
import personal.learning.entity.Product;

public class ProductService {

	ProductDAO dao = new ProductDAO();
	
	public List<Product> getProductsByBrandId(int brandId) {
		return dao.getProductsByBrandId(brandId);
	}

}
