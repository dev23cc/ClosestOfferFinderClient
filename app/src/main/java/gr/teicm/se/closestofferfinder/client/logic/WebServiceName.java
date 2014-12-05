package gr.teicm.se.closestofferfinder.client.logic;

/**
 * Created by user on 5/12/2014.
 */
public class WebServiceName {
    public String createFullWSUrl() {
        // http://83.212.101.78:8080/WSoffer/service/getVersionWsJSON
        return(protocol + ":" +  "//" + WSIp + ":" + WSPort + "/" + WebApplicationName  + "/" + "service" + "" );

    }
    public String getWSIp() {
        return WSIp;
    }

    private void setWSIp() {
        this.WSIp = "83.212.101.78";
    }

    public String getWebApplicationName() {
        return WebApplicationName;
    }

    private void setWebApplicationName() {
        WebApplicationName = "WSoffer";
    }

    public String getWebMethodName() {
        return WebMethodName;
    }

    private void setWebMethodName(String webMethodName) {
        WebMethodName = webMethodName;
    }
    public String getWSPort() {
        return WSPort;
    }

    private void setWSPort() {
        this.WSPort = "8080";
    }

    private void setProtocol() {
        this.protocol = "http";
    }

    private String protocol;
    private String WSIp;
    private String WSPort;
    private String WebApplicationName;
    private String WebMethodName;


}

