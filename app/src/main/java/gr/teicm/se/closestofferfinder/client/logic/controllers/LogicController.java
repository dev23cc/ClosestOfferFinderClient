package gr.teicm.se.closestofferfinder.client.logic.controllers;

import java.util.ArrayList;
import java.util.List;

import gr.teicm.se.closestofferfinder.client.logic.concurrency.Task;
import gr.teicm.se.closestofferfinder.client.logic.dao.HttpClientDao;
import gr.teicm.se.closestofferfinder.client.logic.interfaces.IRequest;
import gr.teicm.se.closestofferfinder.client.logic.parsers.dto.Offer;
import gr.teicm.se.closestofferfinder.client.logic.requests.RequestFactory;
import gr.teicm.se.closestofferfinder.client.logic.model.definitions.WebServiceDetails;

/**
 * Created by dev23cc on 21/11/2014.
 */
public class LogicController {
    List<Offer> offers;
    IRequest offersRequest;
    public LogicController() {
        offers = new ArrayList<Offer>();
        offersRequest = new RequestFactory().getInstance(WebServiceDetails.GET_ALL_OFFERS_JSON);
        offers=offersRequest.getOffers();
    }
    public List<Offer> getOffers() {
        return(offers);
    }
}
