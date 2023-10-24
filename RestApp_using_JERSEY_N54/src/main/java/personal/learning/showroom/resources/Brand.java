package personal.learning.showroom.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/showroom")
public class Brand {

	@GET
	@Path("/getBrands")
	@Produces(MediaType.TEXT_PLAIN)
	public String getBrands() {
		return "List of all brands of car";
	}
	
	@POST
	@Path("/setBrand")
	@Produces(MediaType.TEXT_PLAIN)
	public String setBrand() {
		return "Add a new brand";
	}
	
	@PUT
	@Path("/updateBrand/{brandId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateBrand(@PathParam("brandId") int brandId) {
		return "Update the brand with id = " + brandId;
	}
	
	@DELETE
	@Path("/deleteBrand/{brandId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteBrand(@PathParam("brandId") int brandId) {
		return "Delete the brand with id = " + brandId;
	}
}
