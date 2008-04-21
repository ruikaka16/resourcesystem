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



public class MainMapPanel extends Panel{
		
	public MapPanel mapPanel; 
	public TextField addressField;
	public ToolbarButton refreshMapButton;
	
	public MainMapPanel(){
		
		mapPanel = new GoogleMap();
		mapPanel.setTitle("Google Maps");
		mapPanel.setWidth(400);
		mapPanel.setHeight(400);
		mapPanel.addLargeControls();
		
		//LatLonPoint myPoint = new LatLonPoint(51.387745, -0.50914);
		//mapPanel.setCenterAndZoom(myPoint, 14);

	}

	public void addLargeControls(){
		
		final MainMapPanel thisModule = this;
		
		addressField = new TextField();
		addressField.setValue("Bei Jing");
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
	
	public void addMapControls()
	{
		final MainMapPanel thisModule = this;
		
		addressField = new TextField();
		addressField.setValue("Bei Jing");
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

}-*/;


	public void renderMap(JavaScriptObject jsObj)
		{
			double lat = Double.parseDouble(JavaScriptObjectHelper.getAttribute(jsObj, "lat"));
			double lon = Double.parseDouble(JavaScriptObjectHelper.getAttribute(jsObj, "lon"));
				
			LatLonPoint latLonPoint = new LatLonPoint(lat, lon);
			mapPanel.setCenterAndZoom(latLonPoint, 12);
			mapPanel.addMarker(new Marker(latLonPoint));
		}
}
