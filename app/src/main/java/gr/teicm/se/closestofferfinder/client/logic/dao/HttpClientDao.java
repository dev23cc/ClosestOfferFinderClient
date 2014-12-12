package gr.teicm.se.closestofferfinder.client.logic.dao;



import gr.teicm.se.closestofferfinder.client.logic.concurrency.Task;
import gr.teicm.se.closestofferfinder.client.logic.interfaces.IDao;

/**
 * Created by dev23cc on 21/11/2014.
 */
public class HttpClientDao implements IDao {
    public String resource;
    protected Task clientTask;
    public HttpClientDao()  {
        clientTask = new Task();
        downloadResource();
    }
    public void downloadResource() {
        resource = clientTask.downloadJsonResource();
    }
    @Override
    public String getOffers() {
        return(resource);
    }


}