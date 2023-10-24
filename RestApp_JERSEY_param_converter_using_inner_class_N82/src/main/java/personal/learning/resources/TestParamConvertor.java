package personal.learning.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import personal.learning.model.entity.Currency;

@Path("/testParamConvertor")
public class TestParamConvertor {
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test(@QueryParam("code") Currency currency) {
		return "The currency is "+ currency;
	}
}
