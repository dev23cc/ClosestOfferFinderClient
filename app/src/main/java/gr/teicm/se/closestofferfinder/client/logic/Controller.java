package gr.teicm.se.closestofferfinder.client.logic;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import gr.teicm.se.closestofferfinder.client.logic.dao.RestDao;
import gr.teicm.se.closestofferfinder.client.logic.dao.WebServiceDao;
import gr.teicm.se.closestofferfinder.client.logic.interfaces.IOffer;

/**
 * Created by user on 21/11/2014.
 */
public class Controller {
    RestDao dao;
    String offer;
    public void Controller() {

            dao = new RestDao();
          //  offer = dao.getResult();



        //  offer=dao.getOffer();
    }
    public String hasBody() {
      //  if(dao.hasBody())  return("Yes");
      //  if(!dao.hasBody()) return("No");
        return("Nothing");
    }
    public Offer getOffer() {
        return(null);
    }
    public String getName() {
        try {
        if (dao.getResult()==null) offer="isnull";
            else offer=dao.getResult();
        } catch(NullPointerException e) {
            offer="nullstr";
        }
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        Future<Response> f = asyncHttpClient.prepareGet("http://83.212.101.78:8080/WSoffer/service/getOffersByStoreJSON/0").execute();
        Response r = null;
        try {
            r = f.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            offer=r.getResponseBody();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return(offer);
    }
 public String getOfferName() {
    String s = "Troller";
     try {
        s =dao.getWSFile();

     } catch (Exception e) {
         e.printStackTrace();
         e.getMessage();
         return(s);
     }
     return(s);
 }

}
