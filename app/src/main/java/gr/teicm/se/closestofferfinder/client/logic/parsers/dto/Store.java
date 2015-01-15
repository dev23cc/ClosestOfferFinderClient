package gr.teicm.se.closestofferfinder.client.logic.parsers.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import gr.teicm.se.closestofferfinder.client.logic.interfaces.IOffer;
import gr.teicm.se.closestofferfinder.client.logic.interfaces.IStore;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "STORE")
public class Store implements IStore{
    @JsonProperty("storeId")
    int storeId;
    @JsonProperty("storeName")
    String storeName;
    @JsonProperty("director")
    String director;
    @JsonProperty("address")
    String address;
    @JsonProperty("city")
    String city;
    @JsonProperty("latitude")
    double latitude;
    @JsonProperty("longitude")
    double longitude;
    public Store() {
        initializeStore();
    }
    private void initializeStore(){
        storeId=0;
        storeName="";
        director="";
        address="";
        city="";
        longitude=0;
        latitude=0;
    }

    @Override
    public int getStoreId() {
        return storeId;
    }

    @Override
    public String getStoreName() {
        return storeName;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getDirectorName() {
        return director;
    }

    @Override
    public String getStoreCity() {
        return city;
    }

    @Override
    public double getLatitude() {
        return latitude;
    }

    @Override
    public double getLongtitude() {
        return longitude;
    }
}
