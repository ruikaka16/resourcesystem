package com.buaa.project.client.panel;



import com.gwtext.client.widgets.Panel;
import java.util.Date; 
import com.google.gwt.i18n.client.DateTimeFormat;   
import com.google.gwt.i18n.client.NumberFormat;   
import com.gwtext.client.data.*;  
import com.gwtext.client.core.Function;   
import com.gwtext.client.core.Position;   

import com.gwtext.client.widgets.PaddedPanel;   
import com.gwtext.client.widgets.form.DateField;   
import com.gwtext.client.widgets.form.FieldSet;   
import com.gwtext.client.widgets.form.FormPanel;   
import com.gwtext.client.widgets.form.TextField;   
import com.gwtext.client.widgets.grid.*;   
import com.gwtext.client.widgets.grid.event.RowSelectionListenerAdapter;   
import com.gwtext.client.widgets.layout.ColumnLayout;   
import com.gwtext.client.widgets.layout.ColumnLayoutData;   
import com.gwtext.client.widgets.layout.FitLayout;

public class FormGridSample extends Panel{

	
    public static final NumberFormat nf = NumberFormat.getFormat("#,##0.00", "$");   
    public static final NumberFormat nfc = NumberFormat.getFormat("#,##0.00");   
    public static final DateTimeFormat dateFormatter = DateTimeFormat.getFormat("M/d/y");   
  
    public static BaseColumnConfig[] columns = new BaseColumnConfig[]{   
  
            new ColumnConfig("单位名称", "company", 160, true, null, "company")
  
 
    };   
  
  
    public static RecordDef recordDef = new RecordDef(   
            new FieldDef[]{   
                    new StringFieldDef("name"),   
                    new FloatFieldDef("price"),   
                    new FloatFieldDef("change"),   
                    new FloatFieldDef("pctChange"),   
                    new DateFieldDef("lastChanged", "n/j h:ia"),   
                    new StringFieldDef("symbol"),   
                    new StringFieldDef("industry")   
            }   
    );   
	
	public FormGridSample(){
		
		  
        this.setBorder(false);   
        //this.setPaddings(15); 
        
        final FormPanel formPanel = new FormPanel();   
        formPanel.setFrame(true);   
        formPanel.setLabelAlign(Position.LEFT);   
       // formPanel.setPaddings(5);   
        formPanel.setWidth(650);   
  
        Panel inner = new Panel();   
        inner.setLayout(new ColumnLayout());   
  
        Panel columnOne = new Panel();   
        columnOne.setLayout(new FitLayout());   
  
        SampleGrid sampleGrid = new SampleGrid();
        
        
          
  
   /*     final RowSelectionModel sm = new RowSelectionModel(true);   
        sm.addListener(new RowSelectionListenerAdapter() {   
            public void onRowSelect(RowSelectionModel sm, int rowIndex, Record record) {   
                formPanel.getForm().loadRecord(record);   
            }   
        });   
        gridPanel.setSelectionModel(sm);   
  
        //select the first row after a little delay so that the rows are rendered   
        gridPanel.doOnRender(new Function() {   
            public void execute() {   
                sm.selectFirstRow();   
            }   
        }, 10);  
        */ 
  
        columnOne.add(sampleGrid);   
        inner.add(columnOne, new ColumnLayoutData(0.4));   
  
        FieldSet fieldSet = new FieldSet();   
        fieldSet.setLabelWidth(90);   
        fieldSet.setTitle("法人单位详细信息");   
        fieldSet.setAutoHeight(true);   
        fieldSet.setBorder(false);   
  
        //the field names msut match the data field values from the Store   
        fieldSet.add(new TextField("单位名称", "name", 120));   
        fieldSet.add(new TextField("上级主管", "zhuguan", 120));   
        fieldSet.add(new TextField("单位通讯地址", "address", 120));   
        fieldSet.add(new DateField("所在单位地址", "suozaiaddress", 110));   
        inner.add(new PaddedPanel(fieldSet, 0, 10, 0, 0), new ColumnLayoutData(0.4));   
  
        formPanel.add(inner);   
        this.add(formPanel);   
  
        
		}
}
	
	
	
	
	
