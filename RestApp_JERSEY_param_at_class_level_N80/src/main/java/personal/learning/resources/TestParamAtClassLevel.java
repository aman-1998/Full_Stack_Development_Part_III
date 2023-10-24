package personal.learning.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/testParamAtClassLevel/{z}")
public class TestParamAtClassLevel {
	
//	@GET
//	@Path("/test/{y}")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String test(@QueryParam("x") int x, @PathParam("y") int y) {
//		return "The value of x is "+ x +" and y is "+ y;
//	}
	
	@QueryParam("x") int x;
	@PathParam("z") int z;
	
	@GET
	@Path("/test/{y}")
	@Produces(MediaType.TEXT_PLAIN)
	public String test(@PathParam("y") int y) {
		return "The value of x is "+ x +", y is "+ y
				+ " and z is "+ z;
	}
}
