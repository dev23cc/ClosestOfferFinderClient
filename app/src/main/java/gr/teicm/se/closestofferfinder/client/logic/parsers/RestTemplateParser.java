package gr.teicm.se.closestofferfinder.client.logic.parsers;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gr.teicm.se.closestofferfinder.client.logic.interfaces.IOffer;
import gr.teicm.se.closestofferfinder.client.logic.model.OffersWrapper;
import gr.teicm.se.closestofferfinder.client.logic.model.definitions.ClassType;
import gr.teicm.se.closestofferfinder.client.logic.parsers.dto.Offer;
import gr.teicm.se.closestofferfinder.client.logic.webservicenames.WebServiceName;

/**
 * Created by dev23cc on 29/12/2014.
 */
public class RestTemplateParser {
    List<Offer> offers;
    RestTemplate restTemplate;
    public List<Offer> getOffers() {
        return offers;
    }

    private RestTemplateParser() {
    }
    public  RestTemplateParser(ClassType classType) {
        restTemplate = new RestTemplate();
        offers = new ArrayList<Offer>();
        if(classType == ClassType.OFFER) offers = parseOffer();
    }
    private List<Offer> parseOffer() {
        OffersWrapper[] wrappedOffersArray = new OffersWrapper[0];
        try {
            wrappedOffersArray = restTemplate.getForObject(new WebServiceName().createFullWSUrl(), OffersWrapper[].class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<OffersWrapper> wrappedOffers = new ArrayList<OffersWrapper>(Arrays.asList(wrappedOffersArray));
        List<Offer> offers = new ArrayList<Offer>();
        for (OffersWrapper offerWrapper: wrappedOffers) offers.add(offerWrapper.getOffer());
        return(offers);
    }
}
