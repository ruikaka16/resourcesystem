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
  
    private static BaseColumnConfig[] columns = new BaseColumnConfig[]{   
  
            new ColumnConfig("Company", "company", 160, true, null, "company"),   
  
            new ColumnConfig("Price", "price", 35, true, new Renderer() {   
                public String render(Object value, CellMetadata cellMetadata, Record record,   
                                            int rowIndex, int colNum, Store store) {   
                    return nf.format(((Number) value).doubleValue());   
                }   
            }),   
  
            new ColumnConfig("Change", "change", 45, true, new Renderer() {   
                public String render(Object value, CellMetadata cellMetadata, Record record,   
                                            int rowIndex, int colNum, Store store) {   
                    float val = ((Float) value).floatValue();   
                    String valString = nfc.format(val);   
                    if (val < 0) {   
                        return "<span style='color:red;'>" + valString + "</span>";   
                    } else {   
                        return valString;   
                    }   
                }   
            }, "change"),   
  
            new ColumnConfig("% Change", "pctChange", 65, true, null, "pctChange"),   
  
            new ColumnConfig("Last Updated", "lastChanged", 65, true, new Renderer() {   
                public String render(Object value, CellMetadata cellMetadata, Record record,   
                                            int rowIndex, int colNum, Store store) {   
                    Date date = (Date) value;   
                    return dateFormatter.format(date);   
                }   
            }),   
            new ColumnConfig("Industry", "industry", 60, true)   
    };   
  
  
    private static RecordDef recordDef = new RecordDef(   
            new FieldDef[]{   
                    new StringFieldDef("company"),   
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
        this.setPaddings(15); 
        
        final FormPanel formPanel = new FormPanel();   
        formPanel.setFrame(true);   
        formPanel.setLabelAlign(Position.LEFT);   
        formPanel.setPaddings(5);   
        formPanel.setWidth(650);   
  
        Panel inner = new Panel();   
        inner.setLayout(new ColumnLayout());   
  
        Panel columnOne = new Panel();   
        columnOne.setLayout(new FitLayout());   
  
        GridPanel gridPanel = new GridPanel();   
        gridPanel.setHeight(300);   
        gridPanel.setTitle("Company Data");   
  
        final RowSelectionModel sm = new RowSelectionModel(true);   
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
  
        columnOne.add(gridPanel);   
        inner.add(columnOne, new ColumnLayoutData(0.6));   
  
        FieldSet fieldSet = new FieldSet();   
        fieldSet.setLabelWidth(90);   
        fieldSet.setTitle("Company Details");   
        fieldSet.setAutoHeight(true);   
        fieldSet.setBorder(false);   
  
        //the field names msut match the data field values from the Store   
        fieldSet.add(new TextField("Name", "company", 120));   
        fieldSet.add(new TextField("Price", "price", 120));   
        fieldSet.add(new TextField("% Change", "pctChange", 120));   
        fieldSet.add(new DateField("Last Updated", "lastChanged", 120));   
        inner.add(new PaddedPanel(fieldSet, 0, 10, 0, 0), new ColumnLayoutData(0.4));   
  
        formPanel.add(inner);   
        this.add(formPanel);   
  
        
		}
	
	
	 class SampleGrid extends GridPanel {   
		   
		
	  
	  
	    public SampleGrid() {   
	  
	        Object[][] data = getCompanyDataSmall();   
	        MemoryProxy proxy = new MemoryProxy(data);   
	  
	        ArrayReader reader = new ArrayReader(recordDef);   
	        Store store = new Store(proxy, reader);   
	        store.load();   
	        setStore(store);   
	  
	        ColumnModel columnModel = new ColumnModel(columns);   
	        setColumnModel(columnModel);   
	  
	        setFrame(true);   
	        setStripeRows(true);   
	        setAutoExpandColumn("company");   
	    }   
	  
	    private Object[][] getCompanyDataSmall() {   
	        return new Object[][]{   
	                new Object[]{"3m Co", new Double(71.72), new Double(0.02),   
	                        new Double(0.03), "9/1 12:00am", "MMM", "Manufacturing"},   
	                new Object[]{"Alcoa Inc", new Double(29.01), new Double(0.42),   
	                        new Double(1.47), "9/1 12:00am", "AA", "Manufacturing"},   
	                new Object[]{"Altria Group Inc", new Double(83.81), new Double(0.28),   
	                        new Double(0.34), "9/1 12:00am", "MO", "Manufacturing"},   
	                new Object[]{"American Express Company", new Double(52.55), new Double(0.01),   
	                        new Double(0.02), "9/1 12:00am", "AXP", "Finance"},   
	                new Object[]{"American International Group, Inc.", new Double(64.13), new Double(0.31),   
	                        new Double(0.49), "9/1 12:00am", "AIG", "Services"},   
	                new Object[]{"AT&T Inc.", new Double(31.61), new Double(-0.48),   
	                        new Double(-1.54), "9/1 12:00am", "T", "Services"},   
	                new Object[]{"Boeing Co.", new Double(75.43), new Double(0.53),   
	                        new Double(0.71), "9/1 12:00am", "BA", "Manufacturing"},   
	                new Object[]{"Caterpillar Inc.", new Double(67.27), new Double(0.92),   
	                        new Double(1.39), "9/1 12:00am", "CAT", "Services"},   
	                new Object[]{"Citigroup, Inc.", new Double(49.37), new Double(0.02),   
	                        new Double(0.04), "9/1 12:00am", "C", "Finance"},   
	 
	        new Object[]{"E.I. du Pont de Nemours and Company", new Double(40.48), new Double(0.51),   
	                        new Double(1.28), "9/1 12:00am", "DD", "Manufacturing"}   
	        };   
	      
	}

}

	}
	
	
