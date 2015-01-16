package gr.teicm.se.closestofferfinder.client.logic.model;

/**
 * Created by dev23cc on 15/1/2015.
 */
public class Coordinates {
    private double longitude;
    private double latidude;
    public Coordinates() {
        this.longitude = 0.0;
        this.latidude = 0.0;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatidude(double latidude) {
        this.latidude = latidude;
    }

    public double getLatidude() {
        return latidude;
    }

    public double getLongitude() {
        return longitude;
    }
}
