package gr.teicm.se.closestofferfinder.client.logic.location;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import gr.teicm.se.closestofferfinder.client.logic.model.Coordinates;

/**
 * Created by dev23cc on 15/1/2015.
 */
public class Location {
    public Coordinates getCoordinates() {
        return coordinates;
    }
    private final Context context;
    private Coordinates coordinates;
    public Location(Context context) {
        coordinates = new Coordinates();
        this.context = context;
        getGPSCoordinates();

    }
    private void getGPSCoordinates() {

        LocationManager lm= (LocationManager)this.context.getSystemService(Context.LOCATION_SERVICE) ;
        LocationListener ll= new mylocationlistener() ;
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,ll);
    }
    class mylocationlistener implements LocationListener {

        @Override
        public void onLocationChanged(android.location.Location location) {
            if(location!=null) {
                coordinates.setLongitude(location.getLongitude());
                coordinates.setLatidude(location.getLatitude());
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
