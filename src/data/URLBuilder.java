package src.data;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class URLBuilder {
    private StringBuilder folders;
    private StringBuilder params;
    private String protocol;
    private String host;

    public URLBuilder(String host,String conn){
    	this.folders = new StringBuilder();
        this.params = new StringBuilder();
        this.host = host;
        this.protocol = conn;
    }

    public void addFolder(String folder) {
    	this.folders.append("/");
    	this.folders.append(folder);
    }

    public void addParameter(String parameter, String value) {
        if(this.params.toString().length() > 0){this.params.append("&");}
        this.params.append(parameter);
        this.params.append("=");
        this.params.append(value);
    }

    public URL getURL() throws URISyntaxException, MalformedURLException {
        URI uri = new URI(this.protocol, this.host, this.folders.toString(),
        		this.params.toString(), null);
        return uri.toURL();
    }
}
