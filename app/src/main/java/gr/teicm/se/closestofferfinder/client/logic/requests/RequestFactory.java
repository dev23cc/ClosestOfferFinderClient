package gr.teicm.se.closestofferfinder.client.logic.requests;

import gr.teicm.se.closestofferfinder.client.logic.interfaces.IRequest;
import gr.teicm.se.closestofferfinder.client.logic.webservicenames.WebServiceDetails;

/**
 * Created by dev23cc on 9/12/2014.
 */
public class RequestFactory {
    public IRequest getInstance(WebServiceDetails requestedMethod) {
        IRequest request;
        if(requestedMethod == WebServiceDetails.GET_ALL_OFFERS_JSON) request = new OffersRequest();
        else request = new ClosestOffersRequest();
        return(request);
    }
}
