package gr.teicm.se.closestofferfinder.client.logic.requests;

import java.util.ArrayList;
import java.util.List;

import gr.teicm.se.closestofferfinder.client.logic.dao.HttpClientDao;
import gr.teicm.se.closestofferfinder.client.logic.interfaces.IRequest;
import gr.teicm.se.closestofferfinder.client.logic.parsers.dto.Offer;
import gr.teicm.se.closestofferfinder.client.logic.parsers.Parser;
import gr.teicm.se.closestofferfinder.client.logic.model.definitions.ClassType;

/**
 * Created by dev23cc on 9/12/2014.
 */
public class OffersRequest implements IRequest {
    private String offerData;
    private HttpClientDao dao;
    private List<Offer> offers;
    private Parser offerParser;
    public OffersRequest() {
        offers = new ArrayList<Offer>();
        dao = new HttpClientDao();
        offerData = dao.getOffers();
        offerParser = new Parser(offerData, ClassType.OFFER);
        offers = offerParser.getOffers();


    }

    @Override
    public List<Offer> getOffers() {
        return offers;
    }
}
