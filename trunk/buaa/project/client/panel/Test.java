package com.buaa.project.client.panel;

import java.util.Iterator;
import java.util.List;

import com.buaa.project.client.DatabaseService;
import com.buaa.project.client.DatabaseServiceAsync;
import com.buaa.project.client.data.BeanDTO;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;


import com.gwtext.client.data.ArrayReader;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.Panel;

import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.layout.FitLayout;

public class Test extends Panel{
	
	public Test(){
		
		
        this.setBorder(false);
        this.setPaddings(15);
        
        final Panel panel  = new Panel();
		  panel.setBorder(false);   
		  panel.setWidth(555);
		 
	 	  
	      final GridPanel grid = new GridPanel();
	     
	      
	      final RecordDef recordDef = new RecordDef(   
	                new FieldDef[]{   
	                        new StringFieldDef("id"),   
	                        new StringFieldDef("psw")  
                    
	                }   
	        );   

	      
	      final ColumnModel columnModel = new ColumnModel(new ColumnConfig[]{   
	                new ColumnConfig("id", "id", 100, true),   
	                new ColumnConfig("psw", "psw", 75, true)
	                  
	        });   
    
       // this.setLayout(new FitLayout());
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
	    
	    AsyncCallback cb_getData = new AsyncCallback() {
	         
	    	public void onFailure(Throwable caught){
	             
	    		//Window.alert("Fail to getting data"+caught.toString());
	         
	    	}
	          public void onSuccess(Object result){
	            
	        	  
	        	  ArrayReader reader = new ArrayReader(recordDef);   
					
					
					// Store store = grid.getStore();
					 Store store = new Store(reader);
					 store.load();
					 
					 grid.setTitle("load test");
					 grid.setStore(store);   
				     grid.setColumnModel(columnModel);   
				     grid.setWidth(500);   
				     grid.setHeight(430);
				     grid.setFrame(true);   
				     grid.stripeRows(true);   
				     panel.add(grid);
				     if (store == null) {
			                return;
			         }

			       List data = (List)result;
			       for (Iterator it = data.iterator(); it.hasNext();) {
			    	   BeanDTO bean = (BeanDTO)it.next();
			    	   store.add(recordDef.createRecord(bean.toObjectArray()));
			       }
			       store.commitChanges();
	        	 // System.out.println(result);
	          
	        	        	  
	          }
	         
	       };
	       calService.getdata(cb_getData);
	       this.add(panel);
	       // centerPanelOne.setTitle("Getdatatohere");
	       // centerPanelOne.setAutoScroll(true);
	       // centerPanelOne.setClosable(true);
	       // centerPanel.add(centerPanelOne);

	       // borderPanel.add(centerPanel, new BorderLayoutData(RegionPosition.CENTER));
	       //
	}

}
