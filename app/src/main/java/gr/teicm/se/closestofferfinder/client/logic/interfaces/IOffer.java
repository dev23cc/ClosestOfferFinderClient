package gr.teicm.se.closestofferfinder.client.logic.interfaces;

/**
 * Created by user on 21/11/2014.
 */
public interface IOffer extends IRequest{
    void getOfferName(String name);
    void getOfferDescription(String text);
}
