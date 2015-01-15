package gr.teicm.se.closestofferfinder.client.logic.parsers.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by dev23cc on 30/12/2014.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "category")
@JsonTypeName("category")
public class Category {
    public Category() {
        initializecategory();
    }
    private void initializecategory() {
        categoryId=0;
        catName ="";
    }
    public int getCategoryId() {
        return categoryId;
    }

    @JsonProperty("categoryId")
    private int categoryId;

    public String getCategoryName() {
        return catName;
    }

    @JsonProperty("catName")
    private String catName;
}
