package gr.teicm.se.closestofferfinder.client.logic;

import gr.teicm.se.closestofferfinder.client.logic.concurrency.Task;
import gr.teicm.se.closestofferfinder.client.logic.dao.HttpClientDao;
import gr.teicm.se.closestofferfinder.client.logic.model.Offer;

/**
 * Created by dev23cc on 21/11/2014.
 */
public class Controller {
    HttpClientDao dao;
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

 public String getOfferName() {

     if (this.offer == null) this.offer="nnsull";
     return(this.offer);
 }

}
