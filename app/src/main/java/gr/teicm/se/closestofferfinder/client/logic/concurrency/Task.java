package gr.teicm.se.closestofferfinder.client.logic.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import gr.teicm.se.closestofferfinder.client.logic.WebClients.HttpClient;

/**
 * Created by dev23cc on 5/12/2014.
 */
public class Task {
    private ExecutorService pool;
    HttpClient client ;
    FutureTask<String> httpFutureTask ;

    public Task() {
        pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        client = new HttpClient();
        httpFutureTask = new FutureTask<String>(client);
    }
    public String downloadJsonResource() {
        String jsonFile = " ";
        pool.execute(httpFutureTask);
        while(true) if(httpFutureTask.isDone()) {
            shutdown();
            try {
                jsonFile = httpFutureTask.get();
                return(jsonFile);
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

/*    public String foo() {
        Future<String> future = (Future<String>) pool.submit(new Runnable() {
            @Override
            public void run() {
                // put your code here
            }
        });
        return null;
    }
    public void bar() {
        pool.submit(new Runnable() {
            @Override
            public void run() {
                // put your code here
            }
        });
    }*/
}
