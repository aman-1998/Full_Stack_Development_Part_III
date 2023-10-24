package personal.learning.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import personal.learning.configuration.DBConfiguration;
import personal.learning.model.entity.Brand;
import personal.learning.model.entity.Product;
import personal.learning.services.ProductService;

@Controller
@RequestMapping("/showroom/brand")
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfiguration.class);
	ProductService productService = context.getBean("pService", ProductService.class);
	
	@RequestMapping(value = "/{brandId}/products", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Product> getProductsByBrand(@PathVariable("brandId") int brandId, 
											@RequestParam("category") String category,
											@RequestParam("size") int size) {
		
		List<Product> productList = new ArrayList<Product>();
		
		if(category != null ) {
			productList = productService.getProductsByBrandIdAndCategory(brandId, category);
		} else {
			logger.info("When Product.category is null then fetch products of every category for brand_id = " + brandId);
			productList = productService.getProductsByBrandId(brandId);
		}
		
		for(Product product: productList) {
			Brand brand = product.getBrand();
			Link selfLink = WebMvcLinkBuilder.linkTo(BrandController.class).slash(brand.getBrandId()).withSelfRel();
			
			Link productLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class)
					    						.getProductsByBrand(brand.getBrandId(), category, size))
     			    							.withRel("product");
			
			List<Link> listOflinks = new ArrayList<Link>();
			listOflinks.add(selfLink);
			listOflinks.add(productLink);
			brand.setListOflinks(listOflinks);
		}
		
		if(size == 0 || size > productList.size()) { //size = 0 means full size
			logger.info("When size is 0 then return full size");
			return productList;
		} else {
			return productList.subList(0, size);
		}
	}	
}
