package gr.teicm.se.closestofferfinder.client.presentation.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import gr.teicm.se.closestofferfinder.client.presentation.R;
import gr.teicm.se.closestofferfinder.client.presentation.controllers.PresentationController;


public class MainActivity extends Activity {
    protected PresentationController presentationController;
    String[] offers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initialize();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    private void initialize() {
        presentationController = new PresentationController();
        offers = presentationController.getOffers();
    }
    private void populateListView(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this,R.layout.offer,offers) ;
        ListView list = (ListView) findViewById(R.id.MyOffers) ;
        // create the grid item mapping
        list.setAdapter(adapter);
    }
    public void OnClickedClientVersion(View view) {
        Toast.makeText(getBaseContext(),
                "Client Version 0.0.5",
                Toast.LENGTH_SHORT).show();
    }

    public void OnButtonClickedMyLocation(View v) {

        startActivity(new Intent(MainActivity.this,LocationAwarenessActivity.class)) ;


    }
    public void OnClickedWSVersion(View view) {

    }
    public void OnClickedTrackOffers(View view){
            populateListView();
        }

}
