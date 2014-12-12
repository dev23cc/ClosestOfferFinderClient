package gr.teicm.se.closestofferfinder.client.logic.parsers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gr.teicm.se.closestofferfinder.client.logic.parsers.dto.Offer;
import gr.teicm.se.closestofferfinder.client.logic.model.OffersWrapper;
import gr.teicm.se.closestofferfinder.client.logic.model.definitions.ClassType;

/**
 * Created by dev23cc on 11/12/2014.
 */
public class Parser {
    public List<Offer> getOffers() {
        return offers;
    }
    List<Offer> offers;
    private Parser() {
    }
    public  Parser(String data, ClassType classType) {
        offers = new ArrayList<Offer>();
        if(classType == ClassType.OFFER) offers = parseOffer(data);
    }
    private List<Offer> parseOffer(String data) {
        OffersWrapper[] wrappedOffersArray = new OffersWrapper[0];
        ObjectMapper mapper= new ObjectMapper();
        try {
                wrappedOffersArray = mapper.readValue(data, OffersWrapper[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<OffersWrapper> wrappedOffers = new ArrayList<OffersWrapper>(Arrays.asList(wrappedOffersArray));
        List<Offer> offers = new ArrayList<Offer>();
        for (OffersWrapper offerWrapper: wrappedOffers) offers.add(offerWrapper.getOffer());
        return(offers);
    }
}
