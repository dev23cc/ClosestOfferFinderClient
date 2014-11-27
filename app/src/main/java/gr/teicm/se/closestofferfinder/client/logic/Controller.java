package gr.teicm.se.closestofferfinder.client.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gr.teicm.se.closestofferfinder.client.logic.dao.RestDao;
import gr.teicm.se.closestofferfinder.client.logic.dao.WebServiceDao;
import gr.teicm.se.closestofferfinder.client.logic.interfaces.IOffer;

/**
 * Created by user on 21/11/2014.
 */
public class Controller {
    RestDao dao;
    String offer;
    public void Controller() {

            dao = new RestDao();
          //  offer = dao.getResult();



        //  offer=dao.getOffer();
    }
    public String hasBody() {
      //  if(dao.hasBody())  return("Yes");
      //  if(!dao.hasBody()) return("No");
        return("Nothing");
    }
    public Offer getOffer() {
        return(null);
    }
    public String getName() {
        try {
        if (dao.getResult()==null) offer="isnull";
            else offer=dao.getResult();
        } catch(NullPointerException e) {
            offer="nullstr";
        }
        return(offer);
    }
 public String getOfferName() {
    String s = "Troller";
     try {
      //   s =dao.getWSFile();

     } catch (Exception e) {
         e.printStackTrace();
         e.getMessage();
         return(s);
     }
     return(s);
 }

}
