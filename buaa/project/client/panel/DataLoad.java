package com.buaa.project.client.panel;


import com.google.gwt.user.client.ui.Frame;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.HttpProxy;
import com.gwtext.client.data.IntegerFieldDef;
import com.gwtext.client.data.JsonReader;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.ToolTip;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.event.GridCellListener;
import com.gwtext.client.widgets.grid.event.GridCellListenerAdapter;


public class DataLoad extends Panel{
	
	String name;
	String website;
	
	public String bodyStyle = "text-align:center;padding:5px 0;"
		+ "border:1px dotted #99bbe8;background:#dfe8f6;"
		+ "color:#15428b;cursor:default;margin:10px;"
		+ "font:bold 11px tahoma,arial,sans-serif;";
	public DataLoad(){

        this.setBorder(false);   
        this.setWidth(220);
        
      
        
		HttpProxy dataProxy = new HttpProxy("data/countries.json");   
        final RecordDef recordDef = new RecordDef(new FieldDef[]{   
                new StringFieldDef("name", "name"),   
                new StringFieldDef("website", "website")  
  
        });   
        JsonReader reader = new JsonReader(recordDef);   
        reader.setRoot("data");   
        reader.setTotalProperty("totalCount");   
  
        final Store store = new Store(dataProxy, reader, true);   
        store.load();   
  
        ColumnModel columnModel = new ColumnModel(new ColumnConfig[]{   
                new ColumnConfig("单位名称", "name", 198, true,null),   
                new ColumnConfig("单位网址", "website", 1, true,null) 
              
        });   
  
        GridPanel grid = new GridPanel();   
        grid.setStore(store);   
        grid.setColumnModel(columnModel);   
        grid.setWidth(200);   
        grid.setAutoHeight(true);   
       // grid.setTitle("Json Grid");   
       // grid.setFrame(true);   
        grid.stripeRows(true);  
        grid.setBodyBorder(false);
        grid.setIconCls("grid-icon");  
        grid.setHideColumnHeader(true);
        
    //  tip.setHtml("点击浏览该网页");
        ToolTip tip = new ToolTip();
        tip.setHtml("点击浏览该网页");
        tip.setWidth(120);
        tip.setBodyStyle(bodyStyle);
        tip.setTrackMouse(true);
        tip.applyTo(grid);
        
        

        grid.addGridCellListener(new GridCellListenerAdapter(){
        	
        	public void onCellClick(GridPanel grid, int rowIndex, int title,
					EventObject e) {
        		
        		Record[] records = grid.getSelectionModel().getSelections();
				name = "";
				website = "";
				for (int i = 0; i < records.length; ++i) {
					Record record = records[i];

					website += record.getAsString("website");
					name += record.getAsString("name");
					

				}
				//MessageBox.alert(name);
				//System.out.println(name);
				
				Frame google = new Frame(website);
				google.setHeight("600px");
				google.setWidth("800px");
				
			
				
				final Window webWin = new Window();
				
				webWin.setWidth(800);
				webWin.setHeight(600);
				//webWin.setMaximizable(true);
				//webWin.setMinimizable(true);

				
				
				webWin.setTitle(name+"官方网站");
				webWin.add(google);
				webWin.setIconCls("westPanel-icon");
	
				
				webWin.show();
				
				

        	}
        });
        
  
        
     this.add(grid);   
    
        
        
        

    }   
  
}  