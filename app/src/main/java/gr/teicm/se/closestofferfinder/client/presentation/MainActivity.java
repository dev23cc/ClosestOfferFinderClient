package gr.teicm.se.closestofferfinder.client.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gr.teicm.se.closestofferfinder.client.logic.Controller;
import gr.teicm.se.closestofferfinder.client.logic.model.Offer;

import static org.bitbucket.dollar.Dollar.$;


public class MainActivity extends Activity {
    protected Controller controller;
    protected List<Offer> lst ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        lst = new ArrayList<Offer>();
        controller= new Controller();
        lst = controller.getOffers();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private void populateListView(){
        List<String> presentedOffers =new ArrayList<String>();
        for (Offer o: lst) presentedOffers.add("Offer Name: "+ o.getOfferName() + " Offer Description: " +o.getDescription() + " Offer Price:  " + o.getOfferPrice() + " Offer Discount: " + o.getOfferDiscount() + "%" + " Offer Location:" + o.getLatitude() + " " + o.getLatitude());
        String[] myItems= {"First Offer","Second Offer","Third Offer"} ;
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

        }
        public void OnClickedTrackOffers(View view){
            populateListView();
        }

}
