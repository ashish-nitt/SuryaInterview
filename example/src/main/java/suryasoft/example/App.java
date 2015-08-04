package suryasoft.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MyWebServiceClient jc = new MyJerseyClient();
        MyWebServiceClient hc = new MyHttpClient(); 
        String emailID= "ashish_nitt@yahoo.co.in";
        System.out.println("Using jersey client");
        jc.getStatus(jc.getUUIDEmailIDJson(emailID));
        System.out.println("Using http client");
        hc.getStatus(jc.getUUIDEmailIDJson(emailID));
    }
}
