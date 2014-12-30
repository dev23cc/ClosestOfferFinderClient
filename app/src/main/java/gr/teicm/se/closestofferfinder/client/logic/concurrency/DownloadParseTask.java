package gr.teicm.se.closestofferfinder.client.logic.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import gr.teicm.se.closestofferfinder.client.logic.interfaces.IOffer;
import gr.teicm.se.closestofferfinder.client.logic.interfaces.IResource;
import gr.teicm.se.closestofferfinder.client.logic.model.ResourceTypeFactory;
import gr.teicm.se.closestofferfinder.client.logic.model.definitions.ClassType;
import gr.teicm.se.closestofferfinder.client.logic.parsers.RestTemplateParser;

import gr.teicm.se.closestofferfinder.client.logic.parsers.dto.Offer;
import gr.teicm.se.closestofferfinder.client.logic.webclients.HttpClient;

/**
 * Created by dev23cc on 26/12/2014.
 */
public class DownloadParseTask {
    private ExecutorService pool;
    HttpClient client;
    RestTemplateParser parser;
    FutureTask<IResource> downloadParseTask;
    private ClassType classType;
    public DownloadParseTask(ClassType classType) {
        this.classType=classType;
        pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        client = new HttpClient();
        parser = new RestTemplateParser(classType);
    }
    public List<? extends IResource> downloadJsonResource() {
        List<? extends IResource> resource = new ResourceTypeFactory(this.classType).getListInstance();
        pool.execute(downloadParseTask);
        while(true) if(downloadParseTask.isDone()) {
            shutdown();
            try {
                resource = downloadParseTask.get();
                return(resource);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
    public void shutdown() {
        pool.shutdown();
    }
}
