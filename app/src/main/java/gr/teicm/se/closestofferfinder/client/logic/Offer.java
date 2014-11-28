package gr.teicm.se.closestofferfinder.client.logic;

import gr.teicm.se.closestofferfinder.client.logic.interfaces.IOffer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by user on 25/11/2014.
 */

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Offer implements IOffer {
    @JsonProperty("id")
    int id;
    @JsonProperty("compId")
    int compId;
    @JsonProperty("catId")
    int catId;
    @JsonProperty("offerName")
    String offerName;
    @JsonProperty("descr")
    String descr;
    @JsonProperty("disc")
    double disc;
    @JsonProperty("price")
    double price;
    public Offer() {
/*        id=0;
        compId=0;
        catId=0;
        offerName="";
        descr="";
        disc=0;
        price=0;*/
    }
    @Override
    public int getOfferId() {
        return id;
    }

    @Override
    public int getCategoryId() {
        return catId;
    }

    @Override
    public int getCompanyId() {
        return compId;
    }

    @Override
    public String getOfferName() {
        return offerName;
    }

    @Override
    public String getDescription() {
        return descr;
    }

    @Override
    public double getOfferPrice() {
        return price;
    }

    @Override
    public double getOfferDiscount() {
        return disc;
    }

    @Override
    public double getLatitude() {
        return 0;
    }

    @Override
    public double getLongtitude() {
        return 0;
    }

    @Override
    public double getRadius() {
        return 0;
    }
}
