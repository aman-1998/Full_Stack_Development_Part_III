package personal.learning.model;

public class Link {
	private String path;
	private String rel;
	
	public Link() {}

	public Link(String path, String rel) {
		this.path = path;
		this.rel = rel;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}
	
}
