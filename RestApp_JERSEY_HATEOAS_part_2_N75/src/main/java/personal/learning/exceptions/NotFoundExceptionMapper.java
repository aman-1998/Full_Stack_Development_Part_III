package personal.learning.exceptions;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import personal.learning.error.ErrorPayload;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

	@Override
	public Response toResponse(NotFoundException exception) {
		ErrorPayload error = new ErrorPayload("Not found exception", 404);
		Response response = Response.status(Status.NOT_FOUND).entity(error).build();
		return response;
	}

}
