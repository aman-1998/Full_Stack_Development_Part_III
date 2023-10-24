package personal.learning.resources;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/testSingleton")
@Singleton
public class TestSingleton {
	
	private int x = 0;
	
//	@GET
//	@Path("/test")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Name test() {
//		return new Name("Aman", "Mishra");
//	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "The value of x is "+ (++x);
	}
}
