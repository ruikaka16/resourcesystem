package com.buaa.project.client.panel;

import java.util.Iterator;
import java.util.List;



import com.buaa.project.client.DatabaseService;
import com.buaa.project.client.DatabaseServiceAsync;
import com.buaa.project.client.data.BeanDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;

public class LoadDataPanel extends Panel{
	 

	
	public LoadDataPanel(){
		  
		
		 this.setBorder(true);   
		 this.setPaddings(15);  
		 this.setWidth(300);
		
		  final Panel panel  = new Panel();
		  panel.setBorder(false);   
		  panel.setPaddings(15);  
		  panel.setWidth(300);
	 	  
	      final GridPanel grid = new GridPanel();
	      
	      BeanDTO dto = new BeanDTO();
	      
	      final RecordDef recordDef = new RecordDef(   
	                new FieldDef[]{   
	                        new StringFieldDef("name"),   
	                        new StringFieldDef("psw")  
                      
	                }   
	        );   

	      
	      final ColumnModel columnModel = new ColumnModel(new ColumnConfig[]{   
	                new ColumnConfig("name", "name", 100, true),   
	                new ColumnConfig("psw", "psw", 75, true)
	                  
	        });   
      
	      DatabaseServiceAsync loadService = DatabaseService.Util
			.getInstance();
	      
	      AsyncCallback cb_load = new AsyncCallback() {

			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				
			}

			public void onSuccess(Object response) {
	         
				 Store store = grid.getStore();
				 store.load();
				 
				 grid.setStore(store);   
			     grid.setColumnModel(columnModel);   
			     grid.setWidth(545);   
			     grid.setHeight(430);
			     grid.setFrame(true);   
			     grid.stripeRows(true);   
			     panel.add(grid);
			     if (store == null) {
		                return;
		         }

		         List data = (List)response;
		         for (Iterator it = data.iterator(); it.hasNext();) {
		                BeanDTO bean = (BeanDTO)it.next();
		                // recordDef is the record definition
		                store.add(recordDef.createRecord(bean.toObjectArray()));
		         }
		         store.commitChanges();
			}
	    	  
	      };
	      loadService.loadData(dto.name, dto.psw, cb_load);
	      this.add(panel);
	}
	

}
