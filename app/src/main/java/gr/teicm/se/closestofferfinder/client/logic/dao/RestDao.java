package gr.teicm.se.closestofferfinder.client.logic.dao;



import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by user on 21/11/2014.
 */
public class RestDao  {
    RestDao() {
        String str = "http://83.212.101.78:8080/WSoffer/service/getAllOffersJSON";
        int timeout=0;
        try {
        URL webServiceUrl = new URL(str);
         try {
                HttpURLConnection httpClient = (HttpURLConnection) webServiceUrl.openConnection();
                httpClient.setRequestMethod("GET");
                httpClient.setRequestProperty("Content-length", "0");
                httpClient.setUseCaches(false);
                httpClient.setAllowUserInteraction(false);
                httpClient.setConnectTimeout(timeout);
                httpClient.connect();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //    HttpClient client = HttpClientBuilder.create().build();
    // http://83.212.101.78:8080/WSoffer/service/getAllOffersXML
    // http://83.212.101.78:8080/WSoffer/service/getAllOffersJSON
        } catch (MalformedURLException ex) {

        }
    }

}
