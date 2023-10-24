package personal.learning.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import personal.learning.entity.Product;
import personal.learning.services.ProductService;

public class ProductResource {
	
	ProductService productService = new ProductService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductsByBrand(@PathParam("brandId") int brandId, 
											@QueryParam("category") String category,
											@QueryParam("size") int size) {
		
		List<Product> productList = new ArrayList<Product>();
		
		if(category != null ) {
			productList = productService.getProductsByBrandIdAndCategory(brandId, category);
			
		} else {
			productList = productService.getProductsByBrandId(brandId);
		}
		
		if(size == 0 || size > productList.size()) { //size = 0 means full size
			return productList;
		} else {
			return productList.subList(0, size);
		}
	}	
}
