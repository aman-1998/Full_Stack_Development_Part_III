package personal.learning.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

@Path("/testClient")
public class ClientBuilding {
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		Client client = ClientBuilder.newClient();
		String response = client.target("http://localhost:8080/RestApp_JERSEY_HATEOAS_part_4_N77/showroom/brand/42")
								.request(MediaType.APPLICATION_JSON)
								.get(String.class);
		return response;
	}
}
