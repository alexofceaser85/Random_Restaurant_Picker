package src.data;

import java.net.URI;
import java.net.URL;

import src.error_messages.ErrorMessages;

/**
 * Builds the URL for the api query
 *
 * @author Furichous Jones IV
 * @version Fall 2020
 */
public class URLBuilder {
    private StringBuilder folders;
    private StringBuilder params;
    private String protocol;
    private String host;

    /**
     * The constructor for the URLBuilder class
     * 
     * @precondition 
     * 		host != null
     * 		host.isBlank() == false
     * 		protocol != null
     * 		protocol.isBlack == false
     * @postcondition 
     * 		this.folders == StringBuilder()
     * 		this.params == StringBuilder()
     * 		this.host == host
     * 		this.protocol == protocol
     * 
     * @param host the host of the API
     * @param protocol the network protocol to access the API
     */
    public URLBuilder(String host, String protocol) {
    	if (host == null) {
			throw new IllegalArgumentException(ErrorMessages.HOST_SHOULD_NOT_BE_NULL);
		}
		if (host.isBlank()) {
			throw new IllegalArgumentException(ErrorMessages.HOST_SHOULD_NOT_BE_BLANK);
		}
		if (protocol == null) {
			throw new IllegalArgumentException(ErrorMessages.PROTOCOL_SHOULD_NOT_BE_NULL);
		}
		if (protocol.isBlank()) {
			throw new IllegalArgumentException(ErrorMessages.PROTOCOL_SHOULD_NOT_BE_BLANK);
		}
    	this.folders = new StringBuilder();
        this.params = new StringBuilder();
        this.host = host;
        this.protocol = protocol;
    }

    /**
     * Adds a folder
     * 
     * @precondition
     * 		folder != null
     * 		folder.isBlank() == false
     * 
     * @postcondition none
     *
     * @param folder the folder to append to
     */
    public void addFolder(String folder) {
    	if (folder == null) {
			throw new IllegalArgumentException(ErrorMessages.FOLDER_SHOULD_NOT_BE_NULL);
		}
		if (folder.isBlank()) {
			throw new IllegalArgumentException(ErrorMessages.FOLDER_SHOULD_NOT_BE_BLANK);
		}
    	this.folders.append("/");
    	this.folders.append(folder);
    }

    /**
     * adds a parameter to the query string for the API
     * 
     * @precondition
     * 		parameter != null
     * 		parameter.isBlank() == false
     * 		value != null
     * 		value.isBlank() == false
     * 
     * @postcondition none
     *
     * @param parameter the parameter to add to the query string
     * @param value the value of the parameter
     */
    public void addParameter(String parameter, String value) {
    	if (parameter == null) {
			throw new IllegalArgumentException(ErrorMessages.PARAMETER_SHOULD_NOT_BE_NULL);
		}
		if (parameter.isBlank()) {
			throw new IllegalArgumentException(ErrorMessages.PARAMETER_SHOULD_NOT_BE_BLANK);
		}
		if (value == null) {
			throw new IllegalArgumentException(ErrorMessages.VALUE_SHOULD_NOT_BE_NULL);
		}
		if (value.isBlank()) {
			throw new IllegalArgumentException(ErrorMessages.VALUE_SHOULD_NOT_BE_BLANK);
		}
        if (this.params.length() > 0) {
        	this.params.append("&");
        }
        this.params.append(parameter);
        this.params.append("=");
        this.params.append(value);
    }

    /**
     * Gets the query URL
     * 
     * @precondition none
     * @postcondition none
     *
     * @return the query URL
     */
    public URL getURL() {
    	String paramsEntry = this.params.toString();
    	String foldersEntry = this.folders.toString();
        try {
        	URI uri = new URI(this.protocol, this.host, foldersEntry.isBlank() ? null : foldersEntry,
					paramsEntry.isBlank() ? null : paramsEntry, null);
			return uri.toURL();
		} catch (Exception e) {
			return null;
		}
    }
}
