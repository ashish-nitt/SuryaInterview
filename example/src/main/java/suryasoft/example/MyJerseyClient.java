package suryasoft.example;

import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MyJerseyClient implements MyWebServiceClient{
	public String getUUIDEmailIDJson(String emailID) {
		try{
		Client client = Client.create();
		WebResource webResource = client.resource("http://surya-interview.appspot.com/message");
		WebResource.Builder webResourceBuilder = webResource.header("X-Surya-Email-Id", emailID);
		ClientResponse response = webResourceBuilder.accept("application/json").get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			//throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		String output = response.getEntity(String.class);
		System.out.println(output);
		return output;
		}
		catch(Exception e){
			System.out.println(e);
		}
		return "";
	}
	
	public String getStatus(String str) {
		try{
		Client client = Client.create();
		WebResource webResource = client.resource("http://surya-interview.appspot.com/message");
		String response = webResource.post(String.class, str);
		
		System.out.println(response);
		return response;
		}
		catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
}
