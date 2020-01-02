package cl.vtr.http;




import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import cl.vtr.model.Customer;
import cl.vtr.util.Utils;

public class RestClient {
	
	private static Client client = ClientBuilder.newClient();
	WebTarget webTarget; 
	WebTarget customerWebTarget;
	Invocation.Builder invocationBuilder;
	
	

	//Response response = target.request().get();

	public Response doPut(Customer customer) {
		
		webTarget = client.target("http://192.168.56.49:9100/CRMService/");
		StringBuffer url= new StringBuffer();
		url.append("Customers/");
		url.append(customer.getId());
		customerWebTarget= webTarget.path(url.toString());
		Response response  = customerWebTarget.request(MediaType.APPLICATION_XML).put(Entity.entity(Utils.generateXMLInput(customer), MediaType.APPLICATION_XML));
	
		System.out.println("Url:::" + url);
        String xmlContent = Utils.generateXMLInput(customer);
        System.out.println( xmlContent );
     //   invocationBuilder.put(entity, responseType)
		//Response response  = invocationBuilder.put(Entity.entity(Utils.generateXMLInput(customer), MediaType.APPLICATION_JSON));

		return response;
		
				
	}
	
/*	public ClientResponse doPut(Customer customer) {
		

		Client client = Client.create();
		StringBuffer url= new StringBuffer();
		url.append("http://192.168.56.49:9100/CRMService/Customers/");
		url.append(customer.getId());
		WebResource webResource = client.resource(url.toString());
        String xmlContent = Utils.generateXMLInput(customer);
		ClientResponse response = webResource.type("application/xml").post(ClientResponse.class, xmlContent);

		return response;
		
				
	}
	*/
	
}
