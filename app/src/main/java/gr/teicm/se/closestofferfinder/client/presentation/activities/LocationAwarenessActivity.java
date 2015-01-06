package gr.teicm.se.closestofferfinder.client.presentation.activities;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import gr.teicm.se.closestofferfinder.client.presentation.R;

public class LocationAwarenessActivity extends ActionBarActivity {

    TextView textLat ;
    TextView textLong ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_awareness);

        textLat= (TextView)findViewById(R.id.textLat) ;
        textLong= (TextView)findViewById(R.id.textLong) ;

        LocationManager lm= (LocationManager)getSystemService(Context.LOCATION_SERVICE) ;
        LocationListener ll= new mylocationlistener() ;
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,ll) ;

    }

    class mylocationlistener implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {

            if(location!=null)
            {
                double pLong= location.getLongitude() ;
                double pLat= location.getLatitude() ;

                textLat.setText(Double.toString(pLat)) ;
                textLong.setText(Double.toString(pLong)) ;

            }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }


}
