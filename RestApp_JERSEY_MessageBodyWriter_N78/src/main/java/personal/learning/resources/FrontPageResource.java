package personal.learning.resources;

import javax.servlet.ServletContext;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import personal.learning.error.ErrorPayload;

@Path("/")
public class FrontPageResource {
	
	@Context
	private UriInfo uriInfo;
	
	@Context
	private ServletContext servletContext;
	
	//private HttpHeaders httpHeader;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String frontUI() {
		return "Hello JAX-RS";
	}
	
	@GET
	@Path("/testHeaderAndCookie")
	@Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
	public Response testingHeaderAndCookieParam(@HeaderParam("headerAttribute") String headerAttribute,
						@CookieParam("_xsrf") String cookieAttribute) {
		if(headerAttribute == null) {
			throw new NotFoundException();
		}
		return Response.status(200).entity("HeaderAttribute: "+headerAttribute+" | xsrf: "+cookieAttribute).build();
	}
	
//	@GET
//	@Path("/testHeaderAndCookie")
//	public String testingHeaderAndCookieParam(@HeaderParam("headerAttribute") String headerAttribute,
//						@CookieParam("_xsrf") String cookieAttribute) {
//		if(headerAttribute == null) {
//	   	    Response response = Response.status(Status.NOT_FOUND).entity("No header is set with name \'headerAttribute\'").build();
//			throw new WebApplicationException(response);
//		}
//		return "HeaderAttribute: "+headerAttribute+" | xsrf: "+cookieAttribute;
//	}
	
	@GET
	@Path("/testUriInfo")
	@Produces(MediaType.TEXT_PLAIN)
	public String testingUriInfo() {
		return "Absolute path: " + uriInfo.getAbsolutePath().toString();
	}
	
	@GET
	@Path("/testServletContext")
	@Produces(MediaType.TEXT_PLAIN)
	public String testingServletContext() {
		return "Context Path: " + servletContext.getContextPath();
	}
	
	@GET
	@Path("/testHttpHeaders")
	@Produces(MediaType.TEXT_PLAIN)
	public String testingHttpHeaders(@Context HttpHeaders headers) {
		return "Headers: " + headers.getRequestHeaders().keySet().toString();
	}
}
