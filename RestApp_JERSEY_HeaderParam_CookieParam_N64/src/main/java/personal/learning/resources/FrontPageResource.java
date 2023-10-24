package personal.learning.resources;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class FrontPageResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String frontUI(@HeaderParam("headerAttribute") String headerAttribute,
						@CookieParam("_xsrf") String cookieAttribute) {
		return "HeaderAttribute: "+headerAttribute+" | xsrf: "+cookieAttribute;
	}
}
