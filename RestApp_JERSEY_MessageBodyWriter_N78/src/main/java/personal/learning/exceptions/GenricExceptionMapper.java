package personal.learning.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import personal.learning.error.ErrorPayload;

@Provider
public class GenricExceptionMapper implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception exception) {
		ErrorPayload error = new ErrorPayload("Internal server error", 500);
		Response response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(error).build();
		return response;
	}
}
