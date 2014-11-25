package gr.teicm.se.closestofferfinder.client.logic.interfaces;

/**
 * Created by user on 21/11/2014.
 */
public interface IOffer extends IRequest{
    int getOfferId();
    int getCategoryId();
    int getCompanyId();
    String getOfferName();
    String getDescription();
    double getOfferPrice();
    double getOfferDiscount();
}

