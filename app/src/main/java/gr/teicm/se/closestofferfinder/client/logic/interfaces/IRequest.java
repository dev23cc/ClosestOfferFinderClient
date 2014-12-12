package gr.teicm.se.closestofferfinder.client.logic.interfaces;

import java.util.List;

import gr.teicm.se.closestofferfinder.client.logic.parsers.dto.Offer;

/**
 * Created by dev23cc on 21/11/2014.
 */
/* A request represents  a */
public interface IRequest {
    List<Offer> getOffers();

}
