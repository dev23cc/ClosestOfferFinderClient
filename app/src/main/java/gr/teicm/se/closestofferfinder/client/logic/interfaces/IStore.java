package gr.teicm.se.closestofferfinder.client.logic.interfaces;

/**
 * Created by dev23cc on 30/12/2014.
 */
public interface IStore {
    int getStoreId();
    String getStoreName();
    String getAddress();
    String getDirectorName();
    String getStoreCity();
    double getLatitude();
    double getLongtitude();
}
