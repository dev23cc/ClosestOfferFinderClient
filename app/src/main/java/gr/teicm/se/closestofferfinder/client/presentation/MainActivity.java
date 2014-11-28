package gr.teicm.se.closestofferfinder.client.presentation;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import gr.teicm.se.closestofferfinder.client.logic.Controller;
import gr.teicm.se.closestofferfinder.client.logic.Offer;


public class MainActivity extends Activity {
    protected Controller controller;
    protected String name;
 //   protected Offer offer;
 private class GetFileTask extends AsyncTask<String, Void, String> {
     protected String doInBackground(String... urls) {
         return getFile(urls[0]);
     }

     protected void onPostExecute(String result) {
         try {


             Toast.makeText(getBaseContext(),
                     result,
                     Toast.LENGTH_SHORT).show();
             name=result;
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
        new GetFileTask().execute(
                "http://83.212.101.78:8080/WSoffer/service/getOffersByStoreJSON/0"  );
        String[] myItems= {name,"Second Offer","Third Offer"} ;

        //     ArrayAdapter<String> adapter = new ArrayAdapter<String> (this,R.layout.offer,myItems) ;
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this,R.layout.offer,myItems) ;
        ListView list = (ListView) findViewById(R.id.MyOffers) ;

        // create the grid item mapping

        list.setAdapter(adapter) ;

    }


        public void OnClickedTrackOffers(View view){

            populateListView();

        }

}
