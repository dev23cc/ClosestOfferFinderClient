package gr.teicm.se.closestofferfinder.client.logic.webclients;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

import gr.teicm.se.closestofferfinder.client.logic.webservicenames.WebServiceName;

/**
 * Created by dev23cc on 5/12/2014.
 */
public class HttpClient implements Callable<String> {
    String response;
    public HttpClient() {
        response="null";
        response = getFile(new WebServiceName().createFullWSUrl());
    }

    public  String getFile(String url) {
        BufferedReader in = null;
        String jsonFile=null;
        try {
            org.apache.http.client.HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            InputStream inputStream = entity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer sb = new StringBuffer("");
            String line ="";
            String newLine = System.getProperty("line.separator");
            while((line = reader.readLine()) !=null) {
                sb.append(line + newLine);
            }
            inputStream.close();
            jsonFile = sb.toString();
            return jsonFile;
        } catch (Exception e) {
            e.getMessage();
        }
        return jsonFile;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        return(getFile(new WebServiceName().createFullWSUrl()));
    }
}
