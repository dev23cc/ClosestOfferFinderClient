package gr.teicm.se.closestofferfinder.client.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import gr.teicm.se.closestofferfinder.client.logic.Controller;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private void populateListView(){

        String[] myItems= {"First Offer","Second Offer","Third Offer"} ;

        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this,R.layout.offer,myItems) ;
        ListView list = (ListView) findViewById(R.id.MyOffers) ;
        list.setAdapter(adapter) ;

    }


        public void OnClickedTrackOffers(View view){

            populateListView() ;

        }

}
