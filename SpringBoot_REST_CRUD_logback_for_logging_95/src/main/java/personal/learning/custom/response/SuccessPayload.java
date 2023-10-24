package personal.learning.custom.response;

import org.springframework.http.HttpStatus;

public class SuccessPayload {
	private String successMessage;
	private HttpStatus status;
	
	public SuccessPayload(String successMessage, HttpStatus status) {
		this.successMessage = successMessage;
		this.status = status;
	}

	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
