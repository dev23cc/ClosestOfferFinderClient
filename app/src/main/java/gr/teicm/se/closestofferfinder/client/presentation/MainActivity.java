package gr.teicm.se.closestofferfinder.client.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.*;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gr.teicm.se.closestofferfinder.client.logic.Controller;
import gr.teicm.se.closestofferfinder.client.logic.model.Offer;
import gr.teicm.se.closestofferfinder.client.logic.model.OffersWrapper;

import static org.bitbucket.dollar.Dollar.$;


public class MainActivity extends Activity {
    protected Controller controller;
    protected String name;
    protected OffersWrapper[] offers ;
    protected List<Offer> lst ;
    //  private View view;
  //  private Task clientTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        controller= new Controller();
        this.offers = new OffersWrapper[0];
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private void populateListView(){
        List<String> presentedOffers =new ArrayList<String>();
        ObjectMapper mapper= new ObjectMapper();
        try {
            this.offers = mapper.readValue(controller.getOfferName(), OffersWrapper[].class);
       } catch (IOException e) {
            e.printStackTrace();
        }
        String[] myItems= {name,"Second Offer","Third Offer"} ;
        List<OffersWrapper> wrappedOffers = new ArrayList<OffersWrapper>(Arrays.asList(offers));
        List<Offer> offers = new ArrayList<Offer>();
        for (OffersWrapper o: wrappedOffers) offers.add(o.getOffer());
        for (Offer o: offers) presentedOffers.add("Offer Name: "+ o.getOfferName() + " Offer Description: " +o.getDescription() + " Offer Price:  " + o.getOfferPrice() + " Offer Discount: " + o.getOfferDiscount() + "%" + " Offer Location:" + o.getLatitude() + " " + o.getLatitude());
        myItems = $(presentedOffers).toArray();
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

          /*  new GetFileTask().execute(
                    "http://83.212.101.78:8080/WSoffer/service/getVersionWsJSON"  );
            */
        }
        public void OnClickedTrackOffers(View view){
          //  new GetFileTask().execute(
          //          "http://83.212.101.78:8080/WSoffer/service/getAllOffersJSON"  );

         //   this.s = clientTask.downloadJsonResource();
         //   new GetFileTask().execute("http://83.212.101.78:8080/WSoffer/service/getOfferByIdJSON/3");
            name = controller.getOfferName();
            populateListView();


        }

}
