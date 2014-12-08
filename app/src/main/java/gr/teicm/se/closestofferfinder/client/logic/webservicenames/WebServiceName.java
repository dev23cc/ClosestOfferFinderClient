package gr.teicm.se.closestofferfinder.client.logic.webservicenames;

/**
 * Created by dev23cc on 5/12/2014.
 */
public class WebServiceName {
    public WebServiceName() {
        setMethods();
    }
    public void setMethods() {
        setProtocol();
        setWSIp();
        setWSPort();
        setWebApplicationName();
        setWebMethodName();
    }
    public String createFullWSUrl() {
        // http://83.212.101.78:8080/WSoffer/service/getVersionWsJSON
      //  return ("http://graph.facebook.com/pivotalsoftware");
        return(protocol + ":" +  "//" + wsIp + ":" + wsPort + "/" + webApplicationName + "/" + "service" + "/" + webMethodName );
    }
    public String getWsIp() {
        return wsIp;
    }

    private void setWSIp() {
        this.wsIp = "83.212.101.78";
    }

    public String getWebApplicationName() {
        return webApplicationName;
    }

    private void setWebApplicationName() {
        webApplicationName = "WSoffer";
    }

    public String getWebMethodName() {
        return webMethodName;
    }

    private void setWebMethodName() {
        webMethodName = "getAllOffersJSON";
    }
    public String getWsPort() {
        return wsPort;
    }

    private void setWSPort() {
        this.wsPort = "8080";
    }

    private void setProtocol() {
        this.protocol = "http";
    }

    private String protocol;
    private String wsIp;
    private String wsPort;
    private String webApplicationName;
    private String webMethodName;


}

