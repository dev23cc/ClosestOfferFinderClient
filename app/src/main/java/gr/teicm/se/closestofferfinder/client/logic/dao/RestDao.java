package gr.teicm.se.closestofferfinder.client.logic.dao;



import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.params.BasicHttpParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import gr.teicm.se.closestofferfinder.client.logic.interfaces.IDao;
import gr.teicm.se.closestofferfinder.client.logic.interfaces.IOffer;
import gr.teicm.se.closestofferfinder.client.logic.interfaces.IRequest;

/**
 * Created by user on 21/11/2014.
 */
public class RestDao implements IDao {
    public static String result;
    public RestDao()  {


    }
    private String getWSFile() throws Exception {
        BufferedReader in = null;
        String jsonFile =null;
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            HttpClient client = new DefaultHttpClient();
            URI webService = new URI("http://83.212.101.78:8080/WSoffer/service/getOffersByStoreJSON/0");
            HttpGet request = new HttpGet();
            request.setURI(webService);
            HttpResponse response = client.execute(request);
            in = new BufferedReader( new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer("");
            String line ="";
            String newLine = System.getProperty("line.separator");
            while((line = in.readLine()) !=null) {
                sb.append(line + newLine);
            }
            in.close();
            jsonFile = sb.toString();
            return jsonFile;
        } catch (Exception e) {
            e.getMessage();
        }
        return jsonFile;
    }
    public static String getResult() {
       // if (result!=null)  result="notnull";
      //  if (result==null) result = "Sorry! Null";
        return(new WServiceContact.execute(this));

    }

    @Override
    public IRequest getRequest() {
        return null;
    }

    @Override
    public IOffer getOffer() {
        return(null);
    }
    protected class WServiceContact extends AsyncTask<Void, Void,String> {
        public  String doInBackground(Void...arg0) {
            BufferedReader in = null;
            String jsonFile=null;
            try {
                HttpClient client = new DefaultHttpClient();
                URI webService = new URI("http://83.212.101.78:8080/WSoffer/service/getOffersByStoreJSON/0");
                HttpGet request = new HttpGet();
                request.setURI(webService);
                HttpResponse response = client.execute(request);
                in = new BufferedReader( new InputStreamReader(response.getEntity().getContent()));
                StringBuffer sb = new StringBuffer("");
                String line ="";
                String newLine = System.getProperty("line.separator");
                while((line = in.readLine()) !=null) {
                    sb.append(line + newLine);
                }
                in.close();
                jsonFile = sb.toString();
                return jsonFile;
            } catch (Exception e) {
                e.getMessage();
            }
            return jsonFile;
        }

    }
}