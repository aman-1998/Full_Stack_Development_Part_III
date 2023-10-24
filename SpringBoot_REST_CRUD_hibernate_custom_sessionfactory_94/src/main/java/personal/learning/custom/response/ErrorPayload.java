package personal.learning.custom.response;

import org.springframework.http.HttpStatus;

public class ErrorPayload {
	
	private String errorMessage;
	private HttpStatus status;
	
	public ErrorPayload(String errorMessage, HttpStatus status) {
		this.errorMessage = errorMessage;
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
}
