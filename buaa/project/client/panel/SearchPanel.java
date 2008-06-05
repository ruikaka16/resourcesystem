package com.buaa.project.client.panel;




import java.util.Iterator;
import java.util.List;

import com.buaa.project.client.DatabaseService;
import com.buaa.project.client.DatabaseServiceAsync;
import com.buaa.project.client.data.BeanNewsDTO;
import com.buaa.project.client.data.BeanFarenDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.HorizontalLayout;

public class SearchPanel extends Panel {

	
	ComboBox cb;
	Store store;
    public SearchPanel() {
       // Panel panel = new Panel();
        this.setBorder(false);
        this.setTitle("法人单位信息");
        
        
        final Store store = new SimpleStore("username", new Object[]{});  
        store.load();   
  
        final ComboBox cb = new ComboBox("单位名称");   
        cb.setMinChars(1);
        
        cb.setFieldLabel("法人单位名称");   
        cb.setStore(store);   
        cb.setDisplayField("username");   
        cb.setMode(ComboBox.LOCAL);   
        cb.setEmptyText("请输入单位名称");   
        cb.setLoadingText("搜索中");   

        cb.setTypeAhead(true);   
        cb.setSelectOnFocus(true);   
        cb.setWidth(200);   
        //do not show drop fown icon   
        cb.setHideTrigger(true);  
        
        
        final RecordDef recordDef = new RecordDef(new FieldDef[]{new StringFieldDef("username")});

  
        FormPanel form1 = new FormPanel();  
        form1.setLabelWidth(80);   
        form1.setBorder(false); 
        form1.setFrame(true);
        form1.add(cb);   
        this.add(form1);   
		DatabaseServiceAsync autoCompleteService = DatabaseService.Util.getInstance();
		AsyncCallback cb_autoComplete = new AsyncCallback() {

			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				
			}

			public void onSuccess(Object result) {
				
				List data = (List) result;
				Iterator it = data.iterator();
		
				while (it.hasNext()) {
					
					final BeanFarenDTO bean = (BeanFarenDTO) it.next();
					//System.out.println(bean.getName()+"****");
					store.add(recordDef.createRecord(bean.toObjectArray()));
				}
				store.commitChanges();
			}
			
		};
		
		autoCompleteService.autoComplete(cb_autoComplete);	
    }

}

 

	
	 
