package gr.teicm.se.closestofferfinder.client.logic.webservicenames;

/**
 * Created by user on 8/12/2014.
 */
public enum WebServiceDetails {
    WEBSERVICE_IP {
        @Override
        public String toString() {
            return("83.212.101.78");
        }
    },
    WEBSERVICE_PORT {
        @Override
        public String toString() {
            return("8080");
        }
    },
    WEBSERVICE_PROTOCOL {
        @Override
        public String toString() {
            return ("http");
        }
    },
    WEBAPPLICATION_NAME {
        @Override
        public String toString() {
            return ("WSoffer");
        }
    },
    GET_ALL_OFFERS_JSON {
        @Override
        public String toString() {
            return ("getAllOffersJSON");
        }
    }
}
