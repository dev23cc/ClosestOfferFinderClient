package gr.teicm.se.closestofferfinder.client.logic.interfaces;

/**
 * Created by dev23cc on 21/11/2014.
 */
public interface IOffer {
    int getOfferId();
    int getCategoryId();
    int getCompanyId();
    String getOfferName();
    String getDescription();
    double getOfferPrice();
    double getOfferDiscount();
    double getLatitude();
    double getLongtitude();
    double getRadius();
}

