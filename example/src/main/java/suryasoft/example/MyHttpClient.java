package suryasoft.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class MyHttpClient implements MyWebServiceClient {

	public String getUUIDEmailIDJson(String emailID) {
		try{
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet request = new HttpGet("http://surya-interview.appspot.com/message");
			request.addHeader("X-Surya-Email-Id", emailID);
			HttpResponse response = httpClient.execute(request);
			return response.getEntity().getContent().toString();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return "";
	}

	public String getStatus(String str) {
		try{
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost request = new HttpPost("http://surya-interview.appspot.com/message");
			
			StringEntity entity = new StringEntity(str);
			entity.setContentType("application/json");
			request.setEntity(entity);
			
			HttpResponse response = httpClient.execute(request);
			BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));
			String output = br.readLine();
			System.out.println(output);
			return output;
		}
		catch(Exception e){
			System.out.println(e);
		}
		return "";
	}
}
