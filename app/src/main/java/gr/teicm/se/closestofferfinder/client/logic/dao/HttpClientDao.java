package gr.teicm.se.closestofferfinder.client.logic.dao;



import gr.teicm.se.closestofferfinder.client.logic.interfaces.IDao;
import gr.teicm.se.closestofferfinder.client.logic.interfaces.IOffer;
import gr.teicm.se.closestofferfinder.client.logic.interfaces.IRequest;
import com.ning.http.client.*;
import java.util.concurrent.Future;
/**
 * Created by dev23cc on 21/11/2014.
 */
public class HttpClientDao implements IDao {
    public String result;
    public HttpClientDao()  {
        result="null";

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
    public String getOffers() {
        return(result);
    }


}