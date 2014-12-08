package gr.teicm.se.closestofferfinder.client.logic.dao;



import gr.teicm.se.closestofferfinder.client.logic.interfaces.IDao;
import gr.teicm.se.closestofferfinder.client.logic.interfaces.IOffer;
import gr.teicm.se.closestofferfinder.client.logic.interfaces.IRequest;
import com.ning.http.client.*;
import java.util.concurrent.Future;
/**
 * Created by dev23cc on 21/11/2014.
 */
public class RestClientDao implements IDao {
    public static String result;
    //WServiceContact wscnt;
    public RestClientDao()  {


    }
    public String getWSFile() throws Exception {
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        Future<Response> f = asyncHttpClient.prepareGet("http://83.212.101.78:8080/WSoffer/service/getOffersByStoreJSON/0").execute();
        Response r = f.get();
        return(r.getResponseBody());
    }
    public  String getResult() {
       // if (result!=null)  result="notnull";
      //  if (result==null) result = "Sorry! Null";
        return(" ");

    }

    @Override
    public IRequest getRequest() {
        return null;
    }

    @Override
    public IOffer getOffer() {
        return(null);
    }

  //  @Override
    public String setResponse(String result) {
   //     new WServiceContact.execute(this);
        return("");
    }


}