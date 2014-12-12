package gr.teicm.se.closestofferfinder.client.logic.controllers;

import java.util.ArrayList;
import java.util.List;

import gr.teicm.se.closestofferfinder.client.logic.interfaces.IRequest;
import gr.teicm.se.closestofferfinder.client.logic.model.definitions.WebServiceDetails;
import gr.teicm.se.closestofferfinder.client.logic.parsers.dto.Offer;
import gr.teicm.se.closestofferfinder.client.logic.requests.RequestFactory;

/**
 * Created by dev23cc on 21/11/2014.
 */
public class LogicController {
    List<Offer> offer;
    IRequest offersRequest;
    public LogicController() {
        offer = new ArrayList<Offer>();
        offersRequest = new RequestFactory().getInstance(WebServiceDetails.GET_ALL_OFFERS_JSON);
        offer =offersRequest.getOffers();
    }
    public List<Offer> getOffer() {
        return(offer);
    }
}
