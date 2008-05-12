package com.buaa.project.client.panel;

import com.buaa.project.client.DatabaseService;
import com.buaa.project.client.DatabaseServiceAsync;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;


import com.gwtext.client.widgets.Panel;

import com.gwtext.client.widgets.layout.FitLayout;

public class Test extends Panel{
	
	public Test(){
		
		
        this.setBorder(false);
        this.setPaddings(15);
        this.setLayout(new FitLayout());
      // 
      //  Panel borderPanel = new Panel();
      //  borderPanel.setLayout(new BorderLayout());
       
      //  TabPanel centerPanel = new TabPanel();
      //  centerPanel.setDeferredRender(false);
      //  centerPanel.setActiveTab(0);
        
      //  final Panel centerPanelOne = new HTMLPanel();
	  //  centerPanelOne.setHtml("Loading...");
	   
	    DatabaseServiceAsync calService = DatabaseService.Util
		.getInstance();
	    
	    AsyncCallback cal = new AsyncCallback() {
	         
	    	public void onFailure(Throwable caught){
	             
	    		Window.alert("Fail to getting data"+caught.toString());
	         
	    	}
	          public void onSuccess(Object result){
	            
	        	  clear();
	          
	        	  setHtml(result.toString());
	        	  
	        	  
	          }
	         
	       };
	       
	       calService.getdata(cal);
	       // centerPanelOne.setTitle("Getdatatohere");
	       // centerPanelOne.setAutoScroll(true);
	       // centerPanelOne.setClosable(true);
	       // centerPanel.add(centerPanelOne);

	       // borderPanel.add(centerPanel, new BorderLayoutData(RegionPosition.CENTER));
	       //
	}

}
