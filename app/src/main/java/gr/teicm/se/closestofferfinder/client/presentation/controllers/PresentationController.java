package gr.teicm.se.closestofferfinder.client.presentation.controllers;

import java.util.ArrayList;
import java.util.List;

import gr.teicm.se.closestofferfinder.client.logic.controllers.LogicController;
import gr.teicm.se.closestofferfinder.client.logic.parsers.dto.Offer;

import static org.bitbucket.dollar.Dollar.$;

/**
 * Created by dev23cc on 12/12/2014.
 */

public class PresentationController {
    protected LogicController controller;
    List<String> presentedOffers;
    public PresentationController() {
        List<Offer> offer = new ArrayList<Offer>();
        presentedOffers =new ArrayList<String>();
        controller= new LogicController();
        offer = controller.getOffer();
        initializeOffers(offer);
    }
    private void initializeOffers(List<Offer> offer) {
        for (Offer o: offer) presentedOffers.add("Offer Name: "+ o.getOfferName() + " Offer Description: " +o.getDescription() + " Offer Price:  " + o.getOfferPrice() + " € " + " Offer Discount: " + o.getOfferDiscount() + " % " + " Offer Location:" + o.getLatitude() + " " + o.getLatitude());
    }
    public String[] getOffers(){
        return($(getPresentedOffers()).toArray());
    }
    public List<String> getPresentedOffers() {
        return presentedOffers;
    }
}
