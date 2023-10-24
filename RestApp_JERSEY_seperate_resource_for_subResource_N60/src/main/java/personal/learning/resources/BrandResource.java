package personal.learning.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import personal.learning.entity.Brand;
import personal.learning.entity.Product;
import personal.learning.services.BrandService;
import personal.learning.services.ProductService;

@Path("/showroom")
public class BrandResource {

	BrandService brandService = new BrandService();
	
	@GET
	@Path("/brands")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Brand> getBrands() {
		return brandService.getAllBrands();
	}
	
	@GET
	@Path("/brand/{brandId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Brand getBrand(@PathParam("brandId") int brandId) {
		return brandService.getBrand(brandId);
	}
	
	@POST
	@Path("/createBrand")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String createBrand(Brand brand) {
		boolean isCreated = brandService.createBrand(brand);
		if(!isCreated) {
			return "creation is unsuccessful";
		}
		return "Created successfully";
	}
	
	@PUT
	@Path("/updateBrand/{brandId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateBrand(@PathParam("brandId") int brandId, Brand brand) {
		boolean isUpdated = brandService.updateBrand(brandId, brand);
		if(!isUpdated) {
			return "Updation is unsuccessful";
		}
		return "Updated successfully";
	}
	
	@DELETE
	@Path("/deleteBrand/{brandId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteBrand(@PathParam("brandId") int brandId) {
		boolean isDeleted = brandService.deleteBrand(brandId);
		if(!isDeleted) {
			return "Deletion is unsuccessful";
		}
		return "Deleted successfully";
	}
}
