package com.buaa.project.client.panel;


import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.HttpProxy;
import com.gwtext.client.data.IntegerFieldDef;
import com.gwtext.client.data.JsonReader;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;


public class DataLoad extends Panel{
	
	public DataLoad(){
       
		

        this.setBorder(false);   
        this.setPaddings(10);  
        this.setWidth(560);
        this.setFrame(true);
        
		HttpProxy dataProxy = new HttpProxy("data/countries.json");   
        final RecordDef recordDef = new RecordDef(new FieldDef[]{   
                new StringFieldDef("abbr", "abbr"),   
                new StringFieldDef("name", "name"),   
                new IntegerFieldDef("area", "area"),   
                new IntegerFieldDef("population", "population"),   
        });   
        JsonReader reader = new JsonReader(recordDef);   
        reader.setRoot("data");   
        reader.setTotalProperty("totalCount");   
  
        final Store store = new Store(dataProxy, reader, true);   
        store.load();   
  
        ColumnModel columnModel = new ColumnModel(new ColumnConfig[]{   
                new ColumnConfig("Abbreviation", "abbr", 100, true,null),   
                new ColumnConfig("Country", "name", 75, true,null),   
                new ColumnConfig("Area", "area", 75, true),   
                new ColumnConfig("Population", "population", 75, true)   
        });   
  
        GridPanel grid = new GridPanel();   
        grid.setStore(store);   
        grid.setColumnModel(columnModel);   
        grid.setWidth(550);   
        grid.setHeight(430);   
        grid.setTitle("Json Grid");   
        grid.setFrame(true);   
        grid.stripeRows(true);   
        grid.setIconCls("grid-icon");   
        this.add(grid);   
        
  


    }   
  
}  