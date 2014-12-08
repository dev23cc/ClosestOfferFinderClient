package gr.teicm.se.closestofferfinder.client.logic;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import gr.teicm.se.closestofferfinder.client.logic.concurrency.Task;
import gr.teicm.se.closestofferfinder.client.logic.dao.RestClientDao;
import gr.teicm.se.closestofferfinder.client.logic.model.Offer;

/**
 * Created by dev23cc on 21/11/2014.
 */
public class Controller {
    RestClientDao dao;
    protected Task clientTask;
    String offer;
    public Controller() {
        clientTask = new Task();
        downloadResource();
    }
    public void downloadResource() {
        offer = clientTask.downloadJsonResource();
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

     if (this.offer == null) this.offer="nnsull";
     return(this.offer);
 }

}
