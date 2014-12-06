package gr.teicm.se.closestofferfinder.client.logic.dao;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

import gr.teicm.se.closestofferfinder.client.logic.Offer;
import gr.teicm.se.closestofferfinder.client.logic.interfaces.IDao;
import gr.teicm.se.closestofferfinder.client.logic.interfaces.IOffer;
import gr.teicm.se.closestofferfinder.client.logic.interfaces.IRequest;

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
    @Override
    public IRequest getRequest() {
        return null;
    }
    @Override
    public Offer getOffer() {
        return null;
    }
    public Boolean hasBody() {return null;}
}
