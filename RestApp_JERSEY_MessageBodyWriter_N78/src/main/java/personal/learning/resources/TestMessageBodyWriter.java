package personal.learning.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import personal.learning.model.entity.Brand;

@Path("/testMsgBdyWriter")
public class TestMessageBodyWriter {
	
//	@GET
//	@Path("/test")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Name test() {
//		return new Name("Aman", "Mishra");
//	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public Name test() {
		return new Name("Aman", "Mishra");
	}
}
