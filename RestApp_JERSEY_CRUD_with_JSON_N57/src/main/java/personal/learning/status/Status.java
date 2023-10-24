package personal.learning.status;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Status {
	
	String message;

	public Status(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
