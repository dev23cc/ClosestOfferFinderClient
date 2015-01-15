package gr.teicm.se.closestofferfinder.client.test;

import junit.framework.TestCase;

import java.util.List;

import gr.teicm.se.closestofferfinder.client.logic.controllers.LogicController;
import gr.teicm.se.closestofferfinder.client.logic.parsers.dto.Offer;

/**
 * Created by Mephisto on 15/1/2015.
 */
public class LogicControllerTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testLogicController(){

        List<Offer> result= LogicController.getOffers() ;
        assertFalse(result != null) ;

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
