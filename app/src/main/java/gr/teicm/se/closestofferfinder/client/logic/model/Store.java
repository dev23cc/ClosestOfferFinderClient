package gr.teicm.se.closestofferfinder.client.logic.model;

import gr.teicm.se.closestofferfinder.client.logic.parsers.dto.Offer;

/**
 * Created by dev23cc on 5/12/2014.
 */
public class Store {
    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Offer getOffer() {
        return offer;
    }

    protected Offer offer;
}
