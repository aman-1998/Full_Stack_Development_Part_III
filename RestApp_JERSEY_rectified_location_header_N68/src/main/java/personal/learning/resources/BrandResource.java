package personal.learning.resources;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import personal.learning.entity.Brand;
import personal.learning.services.BrandService;

@Path("/showroom/brand")
public class BrandResource {

	BrandService brandService = new BrandService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBrands() {
		return Response.ok(brandService.getAllBrands()).build();
	}
	
	@GET
	@Path("/{brandId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBrand(@PathParam("brandId") int brandId) {
		return Response.ok().entity(brandService.getBrand(brandId)).build();
	}
	
	@Path("/{brandId}/products")
	public ProductResource getProductsByBrandDelegation() {
		return new ProductResource();
	}	
	
//	@POST
//	@Path("/createBrand")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.TEXT_PLAIN)
//	public Response createBrand(Brand brand) {
//		boolean isCreated = brandService.createBrand(brand);
//		if(!isCreated) {
//			return Response.status(Status.EXPECTATION_FAILED).entity("Creation of brand is unsuccessful").build();
//		}
//		return Response.status(Status.CREATED).entity("Brand is created successfully").build();
//	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response createBrand(Brand brand, @Context UriInfo uriInfo) {
		boolean isCreated = brandService.createBrand(brand);
		String resourceURL = uriInfo.getAbsolutePath().toString() + "/" + brand.getBrandId();
		URI location = URI.create(resourceURL);
		if(!isCreated) {
			return Response.status(422).entity("Creation of brand is unsuccessful").build();
		}
		return Response.created(location).entity("Brand is created successfully").build();
	}
	
	@PUT
	@Path("/{brandId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateBrand(@PathParam("brandId") int brandId, Brand brand) {
		boolean isUpdated = brandService.updateBrand(brandId, brand);
		if(!isUpdated) {
			return Response.status(Status.NOT_FOUND).entity("Brand with brand id ["+ brandId +"] is not updated").build();
		}
		return Response.status(Status.OK).entity("Brand with brand id ["+ brandId +"] is updated successfully").build();
	}
	
	@DELETE
	@Path("/{brandId}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteBrand(@PathParam("brandId") int brandId) {
		boolean isDeleted = brandService.deleteBrand(brandId);
		if(!isDeleted) {
			return Response.status(Status.NOT_FOUND).entity("Brand with brand id ["+ brandId +"] is not deleted").build();
		}
		return Response.status(Status.OK).entity("Brand with brand id ["+ brandId +"] is deleted successfully").build();
	}
}
