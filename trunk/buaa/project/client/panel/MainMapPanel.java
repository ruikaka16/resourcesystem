package com.buaa.project.client.panel;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.map.GoogleMap;
import com.gwtext.client.widgets.map.LatLonPoint;
import com.gwtext.client.widgets.map.MapPanel;
import com.gwtext.client.widgets.map.Marker;
import com.buaa.project.client.panel.MainMapPanel;




public class MainMapPanel extends Panel{
    
	public MapPanel mapPanel; 
	TextField addressField;
	ToolbarButton refreshMapButton;
	
	public MainMapPanel() {
		createMapPanel();
		addMapControls();
		setTitle("Google Maps");
		add(mapPanel);
	}
	
	private void createMapPanel()
	{
		mapPanel = new GoogleMap();
		mapPanel.setTitle("Center Panel");
	//	mapPanel.setHeight(400);
	//	mapPanel.setWidth(400);
		mapPanel.addLargeControls();
	}
 	
	private void addMapControls()
	{
		final MainMapPanel thisModule = this;
		
		addressField = new TextField();
		addressField.setValue("beijing");
		refreshMapButton = new ToolbarButton("Refresh map", new ButtonListenerAdapter() {
			public void onClick(Button button, EventObject e) {
				String address = addressField.getText();
				if (!address.trim().equals(""))
					updateMap(address, JavaScriptObjectHelper.createObject(), thisModule);
			}
		});
		
		Toolbar toolbar = new Toolbar();
		toolbar.addText("Enter an address: ");
		toolbar.addField(addressField);
		toolbar.addSpacer();
		toolbar.addButton(refreshMapButton);
		
		mapPanel.setTopToolbar(toolbar);
	}
	
	public native void updateMap(String locationAddress, JavaScriptObject llp, MainMapPanel thisModule) /*-{
		var geo = new $wnd.GClientGeocoder();
		
		geo.getLocations(locationAddress, 
			function(response) 
			{
				if (!response || response.Status.code != 200) 
				{
	   				alert("Unable to geocode that address");
				} 
				else 
	      		{
		    		var place = response.Placemark[0];
		    		llp.lat = place.Point.coordinates[1];
		    		llp.lon = place.Point.coordinates[0];
		    		thisModule.@com.maharana.gwtextmaps.client.MainMapPanel::renderMap(Lcom/google/gwt/core/client/JavaScriptObject;)(llp);
	      		}
      		}
      	);
	}-*/;
	
	
	public void renderMap(JavaScriptObject jsObj)
	{
		double lat = Double.parseDouble(JavaScriptObjectHelper.getAttribute(jsObj, "lat"));
		double lon = Double.parseDouble(JavaScriptObjectHelper.getAttribute(jsObj, "lon"));
		
		LatLonPoint latLonPoint = new LatLonPoint(lat, lon);
		mapPanel.setCenterAndZoom(latLonPoint, 8);
		mapPanel.addMarker(new Marker(latLonPoint));
	}
}