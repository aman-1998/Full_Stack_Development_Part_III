package personal.learning.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import personal.learning.entity.Product;
import personal.learning.services.ProductService;

@Path("/showroom")
public class ProductResource {
	
	ProductService productService = new ProductService();
	
	@GET
	@Path("/brand/{brandId}/products")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductsByBrand(@PathParam("brandId") int brandId) {
		return productService.getProductsByBrandId(brandId);
	}	
}
