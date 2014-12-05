package gr.teicm.se.closestofferfinder.client.presentation;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.*;
import com.fasterxml.jackson.databind.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gr.teicm.se.closestofferfinder.client.logic.Controller;
import gr.teicm.se.closestofferfinder.client.logic.Offer;
import gr.teicm.se.closestofferfinder.client.logic.interfaces.Store;


public class MainActivity extends Activity {
    protected Controller controller;
    protected String name;
    protected Offer offer;
    private View view;

    private class GetFileTask extends AsyncTask<String, Void, String> {
     protected String doInBackground(String... urls) {
         return getFile(urls[0]);
     }

     protected void onPostExecute(String result) {
         String version;
         List<Offer> off = new ArrayList<Offer>();
         Offer myOffer = new Offer();
         JSONObject obj = new JSONObject();
         JSONObject offobj = new JSONObject();
         RestTemplate restTemplate= new RestTemplate();
         //   Offer offer;
         try {
                version = response;
             URL jsonURL = new URL("http://83.212.101.78:8080/WSoffer/service/getOfferByIdJSON/3");
          //   JSONArray arr = new JSONArray("{\"offer\":{\"id\":3,\"compId\":2,\"catId\":1,\"offerName\":\"σοκολάτες\",\"descr\":\"20% φθηνότερα\",\"disc\":20,\"price\":1.5}}");
             obj = new JSONObject(result);
             offobj = obj.getJSONObject("offer");
             String ofname = offobj.getString("offerName");
             if(ofname == null) ofname="empty";
           //  for (int i=0; i arr.length(); i++) off.add();
             ObjectMapper mapper= new ObjectMapper();
            Store store ;
             store = mapper.readValue(result, Store.class);
            offer = store.getOffer()   ;
             ofname = offer.getOfferName() +" "+ offer.getDescription() ;
             name = ofname;
          //   offer = restTemplate.getForObject("http://83.212.101.78:8080/WSoffer/service/getOfferByIdJSON/3", Offer.class);
           //  offer = store.getOffer()   ;
           //  ofname = offer.getOfferName() +" "+ offer.getDescription() ;
          //   String file ="[{\"offer\":{\"id\":1,\"compId\":0,\"catId\":0,\"offerName\":\"Α\",\"descr\":\"Προσφορά 1\",\"disc\":0,\"price\":100}}]";
         //    ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            //List<Offer> reslt = mapper.readValue(result, mapper.getTypeFactory().constructCollectionType(List.class, Offer.class));
         //    List<Offer> reslt = Arrays.asList(mapper.readValue(result, Offer[].class));
           //// Offer[] offers=  mapper.readValue(file, Offer[].class);
           //  Offer firstOffer = offers[0];
           //  JsonNode obj = mapper.readTree(file);
           // JsonNode node = obj.get("offerName");

           //  name = reslt.get(1).getOfferName();
            // name = offers[0].getOfferName();
             //   JSONArray  array = reslt.getJSONArray("offer");
           //  name = array.getJSONObject(1).getString("offerName");
             /*for(int i=0; i<reslt.length(); i++) {
            name = reslt.getJSONObject(i).getString("descr");
             }*/
            // name=description;
            // name = result;
                MainActivity.this.populateListView();
             Toast.makeText(getBaseContext(),
                     ofname,
                     Toast.LENGTH_SHORT).show();
           //  ObjectMapper mapper = new ObjectMapper();
          //   Offer[] myoffer = mapper.readValue(result, Offer[].class);
         } catch (Exception e) {
             Log.d("ReadOfferJSONFeedTask", e.getLocalizedMessage());
         }
     }
 }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // controller= new Controller();
    //    name= controller.hasBody();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public  String getFile(String url) {
        BufferedReader in = null;
        String jsonFile=null;
        try {
            HttpClient client = new DefaultHttpClient();
      //      URI webService = new URI("http://83.212.101.78:8080/WSoffer/service/getOffersByStoreJSON/0");
            HttpGet request = new HttpGet(url);
   //         request.setURI(webService);
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            InputStream inputStream = entity.getContent();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream));
   //         in = new BufferedReader( new InputStreamReader(response.getEntity().getContent()));
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
    private void populateListView(){
       // name = controller.getOfferName();
      //  name=controller.getName();
/*        Thread httpClient = new Thread(){
            String jsonFile=getFile();
            //if(jsonFile == null) name="rnull";


        };
        httpClient.start();*/
        if(name==null) name ="null";

        String[] myItems= {name,"Second Offer","Third Offer"} ;

        //     ArrayAdapter<String> adapter = new ArrayAdapter<String> (this,R.layout.offer,myItems) ;
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this,R.layout.offer,myItems) ;
        ListView list = (ListView) findViewById(R.id.MyOffers) ;

        // create the grid item mapping

        list.setAdapter(adapter) ;

    }
    public void OnClickedClientVersion(View view) {
        Toast.makeText(getBaseContext(),
                "Client Version 0.0.1",
                Toast.LENGTH_SHORT).show();
    }
        public void OnClickedWSVersion(View view) {

            new GetFileTask().execute(
                    "http://83.212.101.78:8080/WSoffer/service/getVersionWsJSON"  );

        }
        public void OnClickedTrackOffers(View view){
          //  new GetFileTask().execute(
          //          "http://83.212.101.78:8080/WSoffer/service/getAllOffersJSON"  );

            new GetFileTask().execute("http://83.212.101.78:8080/WSoffer/service/getOfferByIdJSON/3");
            populateListView();

        }

}
