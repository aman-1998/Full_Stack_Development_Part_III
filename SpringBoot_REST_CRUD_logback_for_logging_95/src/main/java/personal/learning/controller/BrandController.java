package personal.learning.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import personal.learning.configuration.DBConfiguration;
import personal.learning.custom.response.ErrorPayload;
import personal.learning.custom.response.SuccessPayload;
import personal.learning.model.entity.Brand;
import personal.learning.services.BrandService;

@Controller
@RequestMapping("/showroom/brand")
public class BrandController extends RepresentationModel<BrandController> {
	
	private static final Logger logger = LoggerFactory.getLogger(BrandController.class);
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfiguration.class);
	BrandService brandService = context.getBean("bService", BrandService.class);

	@RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity getBrands() {
		List<Brand> brandList = brandService.getAllBrands();
		
		for(Brand brand : brandList) {
			Link selfLink = WebMvcLinkBuilder.linkTo(BrandController.class).slash(brand.getBrandId()).withSelfRel();
			List<Link> listOflinks = new ArrayList<Link>();
			listOflinks.add(selfLink);
			brand.setListOflinks(listOflinks);
		}
		return ResponseEntity.status(HttpStatus.OK).body(brandList);
	}
	
	@RequestMapping(value = "/{brandId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity getBrand(@PathVariable("brandId") int brandId) {
		Brand brand = brandService.getBrand(brandId);
		Link selfLink = WebMvcLinkBuilder.linkTo(BrandController.class).slash(brand.getBrandId()).withSelfRel();
		
		Link productLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class)
                 						    .getProductsByBrand(brand.getBrandId(), null, 0))
                             			    .withRel("product");
		
		List<Link> listOflinks = new ArrayList<Link>();
		listOflinks.add(selfLink);
		listOflinks.add(productLink);
		brand.setListOflinks(listOflinks);
		return ResponseEntity.ok().body(brand);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity createBrand(@RequestBody Brand brand) {
		boolean isCreated = brandService.createBrand(brand);
		Link location = WebMvcLinkBuilder.linkTo(BrandController.class).slash(brand.getBrandId()).withSelfRel();
		if(!isCreated) {
			
			ErrorPayload errorPayload = new ErrorPayload("Creation of brand is unsuccessful", HttpStatus.UNPROCESSABLE_ENTITY);
			logger.error("Brand with brand id ["+ brand.getBrandId() +"] is not created");
			return ResponseEntity.status(422).body(errorPayload);
		}
		SuccessPayload successPayload = new SuccessPayload("Brand is created successfully", HttpStatus.CREATED);
		//return ResponseEntity.status(HttpStatus.CREATED).body("Brand is created successfully");
		return ResponseEntity.created(location.toUri()).body(successPayload);
	}
	
	@RequestMapping(value = "/{brandId}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity updateBrand(@PathVariable("brandId") int brandId, @RequestBody Brand brand) {
		boolean isUpdated = brandService.updateBrand(brandId, brand);
		if(!isUpdated) {
			ErrorPayload errorPayload = new ErrorPayload("Brand with brand id ["+ brandId +"] is not updated", HttpStatus.NOT_FOUND);
			logger.error("Brand with brand id ["+ brandId +"] is not updated");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorPayload);
		}
		SuccessPayload successPayload = new SuccessPayload("Brand with brand id ["+ brandId +"] is updated successfully", HttpStatus.OK);
		return ResponseEntity.ok(successPayload);
	}
	
	@RequestMapping(value = "/{brandId}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity deleteBrand(@PathVariable("brandId") int brandId) {
		boolean isDeleted = brandService.deleteBrand(brandId);
		if(!isDeleted) {
			ErrorPayload errorPayload = new ErrorPayload("Brand with brand id ["+ brandId +"] is not deleted", HttpStatus.NOT_FOUND);
			logger.error("Brand with brand id ["+ brandId + "] is not deleted");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorPayload);
		}
		SuccessPayload successPayload = new SuccessPayload("Brand with brand id ["+ brandId +"] is deleted successfully", HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body(successPayload);
	}
}
