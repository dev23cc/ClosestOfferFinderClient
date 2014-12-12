package gr.teicm.se.closestofferfinder.client.logic.dao;

import org.springframework.web.client.RestTemplate;

import gr.teicm.se.closestofferfinder.client.logic.interfaces.IDao;

/**
 * Created by dev23cc on 25/11/2014.
 */
public class WebServiceDao implements IDao {
    RestTemplate restTemplate;
    //   Offer offer;
    String response;
 //   Boolean body;
    public WebServiceDao(){
        response = "Pre";
        //   this.body=false;
        //  restTemplate = new RestTemplate();
        //      offer = new Offer();
        //   offer = restTemplate.getForObject("http://83.212.101.78:8080/WSoffer/service/getOffersByStoreJSON/0", Offer.class); ResponseEntity<String>
        // restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        try {
            //  response = restTemplate.getForObject("https://data.sparkfun.com/streams/dZ4EVmE8yGCRGx5XRX1W.json", String.class);
        } catch(Exception e) {
            this.response="ception";

        }
        if(response==null || response.isEmpty()) response="Empty";

    }
    public String getResp() {
        response="response";
        return (response);

    }

    public Boolean hasBody() {return null;}

    @Override
    public String getOffers() {
        return null;
    }
}
