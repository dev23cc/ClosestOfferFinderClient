package gr.teicm.se.closestofferfinder.client.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import gr.teicm.se.closestofferfinder.client.logic.Controller;


public class MainActivity extends Activity {
    protected Controller controller;
    protected String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        controller= new Controller();
        name = controller.getOfferName();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void populateListView(){

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
