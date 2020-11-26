package src.data;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import src.model.Price;

public class RestaurantQuery extends Query {
	public RestaurantQuery(String location, 
			int radius, 
			String categories, 
			double reviewScore, 
			List<Price> prices, 
			boolean currentlyOpen, 
			boolean handicap, 
			boolean reservations, 
			boolean hotAndNew, 
			boolean neutralBathroom) throws MalformedURLException, URISyntaxException{
		URLBuilder  urlBuilder = new URLBuilder(Query.queryHost, Query.queryProtocol);
		urlBuilder.addFolder("v3");
		urlBuilder.addFolder("businesses");
		urlBuilder.addFolder("search");
		urlBuilder.addParameter("location", location);
		urlBuilder.addParameter("radius", Integer.toString(radius));
		urlBuilder.addParameter("open_now", Boolean.toString(currentlyOpen));
		String pricesCommaSeperated = prices.stream()
                .map(price -> price.value)
                .collect(Collectors.joining(","));
		urlBuilder.addParameter("price", pricesCommaSeperated);
		StringBuilder attributes = new StringBuilder();
		attributes.append(handicap);
		attributes.append(",");
		attributes.append(reservations);
		attributes.append(",");
		attributes.append(hotAndNew);
		attributes.append(",");
		attributes.append(neutralBathroom);
		urlBuilder.addParameter("attributes", attributes.toString());
		super.setQueryURL(urlBuilder.getURL());
	}
}
