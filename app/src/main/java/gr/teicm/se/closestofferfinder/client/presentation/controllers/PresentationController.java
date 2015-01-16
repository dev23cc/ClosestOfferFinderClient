package gr.teicm.se.closestofferfinder.client.presentation.controllers;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import gr.teicm.se.closestofferfinder.client.logic.controllers.LogicController;
import gr.teicm.se.closestofferfinder.client.logic.location.Location;
import gr.teicm.se.closestofferfinder.client.logic.model.Coordinates;
import gr.teicm.se.closestofferfinder.client.logic.parsers.dto.Offer;

import static org.bitbucket.dollar.Dollar.$;

/**
 * Created by dev23cc on 12/12/2014.
 */

public class PresentationController {
    private Coordinates coordinates;
   // private Location location;
    public void setContext(Context context){
        this.context = context;
      //  Location location;
       // location = new Location(context);
       // coordinates = location.getCoordinates();
       // this.location = "Latidude:" + "s " + Double.valueOf( (coordinates.getLatidude())).toString() + " "+ "Longitude:" + " " + Double.valueOf( (coordinates.getLongitude())).toString();
    }
    private Context context;
    protected LogicController controller;
    List<String> presentedOffers;
    private String location;
    public PresentationController() {
        coordinates = new Coordinates();
        location = new String();
        List<Offer> offer = new ArrayList<Offer>();
        presentedOffers =new ArrayList<String>();
        controller= new LogicController();
        offer = controller.getOffers();
        initializeOffers(offer);
    }
    private void initializeOffers(List<Offer> offer) {
        for (Offer o: offer) presentedOffers.add("Offer Name: "+ o.getOfferName() + " Offer Description: " +o.getDescription() + " Offer Price:  " + o.getOfferPrice() + " € " + " Offer Discount: " + o.getOfferDiscount() + " % ");
       // presentedOffers.add(location);
    }
    public String[] getOffers(){
      //  location="null";
      //  presentedOffers.add(location);
/*        try {
            this.coordinates = location.getCoordinates();
        } catch (NullPointerException e) {

        }*/

      //  presentedOffers.add("Latidude:" + " " + Double.valueOf( (coordinates.getLatidude())).toString() + " "+ "Longitude:" + " " + Double.valueOf( (coordinates.getLongitude())).toString()) ;
        //presentedOffers.add("41.093152");
        return($(getPresentedOffers()).toArray());
    }
    public List<String> getPresentedOffers() {
        return presentedOffers;
    }
}
