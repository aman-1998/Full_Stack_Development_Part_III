package personal.learning.resources;

import javax.servlet.ServletContext;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class FrontPageResource {
	
	@Context
	private UriInfo uriInfo;
	
	@Context
	private ServletContext servletContext;
	
	//private HttpHeaders httpHeader;
	
	@GET
	public String frontUI(@HeaderParam("headerAttribute") String headerAttribute,
						@CookieParam("_xsrf") String cookieAttribute) {
		return "HeaderAttribute: "+headerAttribute+" | xsrf: "+cookieAttribute;
	}
	
	@GET
	@Path("/testUriInfo")
	public String testingUriInfo() {
		return "Absolute path: " + uriInfo.getAbsolutePath().toString();
	}
	
	@GET
	@Path("/testServletContext")
	public String testingServletContext() {
		return "Context Path: " + servletContext.getContextPath();
	}
	
	@GET
	@Path("/testHttpHeaders")
	public String testingHttpHeaders(@Context HttpHeaders headers) {
		return "Headers: " + headers.getRequestHeaders().keySet().toString();
	}
}
