package gr.teicm.se.closestofferfinder.client.logic.model;

import java.util.ArrayList;
import java.util.List;

import gr.teicm.se.closestofferfinder.client.logic.interfaces.IOffer;
import gr.teicm.se.closestofferfinder.client.logic.interfaces.IResource;
import gr.teicm.se.closestofferfinder.client.logic.model.definitions.ClassType;
import gr.teicm.se.closestofferfinder.client.logic.parsers.dto.Offer;

/**
 * Created by dev23cc on 29/12/2014.
 */
public class ResourceTypeFactory {
    List<? extends IResource> resource;
    public ResourceTypeFactory(ClassType classType) {
        resource = new ArrayList<>();
        resource = resourceTypeFactory(classType);
    }
    private List<? extends IResource> resourceTypeFactory(ClassType resourceType) {
        switch (resourceType) {
            case OFFER: {
                resource = new ArrayList<IOffer>();
                ((List<IOffer>) resource).add(new Offer());
                return (resource);
            }
        }
        return(null);
    }
    public List<? extends IResource> getListInstance() {
        return(resource);
    }
}
