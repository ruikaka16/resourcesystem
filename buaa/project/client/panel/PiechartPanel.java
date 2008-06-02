package com.buaa.project.client.panel;

import com.gwtext.client.data.ArrayReader;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.IntegerFieldDef;
import com.gwtext.client.data.MemoryProxy;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.*;
import com.gwtext.client.widgets.chart.yui.PieChart;
import com.gwtext.client.widgets.form.NumberField;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.grid.CellMetadata;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.EditorGridPanel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.Renderer;
import com.gwtext.client.widgets.grid.event.EditorGridListenerAdapter;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.client.widgets.layout.VerticalLayout;

public class PiechartPanel extends Panel {

	public PiechartPanel() {
		this.setTitle("统计饼状图");
		this.setAutoScroll(true);
		this.setLayout(new VerticalLayout(5));
		this.setClosable(true);
		this.setAutoShow(true);
		this.setBodyBorder(false);
		
	   
		this.setIconCls("pieChart-icon");
		
		MemoryProxy proxy_1 = new MemoryProxy(getData_1());   
        RecordDef recordDef_1 = new RecordDef(   
                new FieldDef[]{   
                        new StringFieldDef("status"),   
                        new IntegerFieldDef("count"),   
                        new StringFieldDef("color")   
                }   
        );   
        
        ArrayReader reader_1 = new ArrayReader(recordDef_1);   
        final Store store_1 = new Store(proxy_1, reader_1);   
        store_1.load();   
        
        final PieChart chart = new PieChart();   
        //chart.setTitle("饼状图");   
        chart.setWMode("transparent");   
        chart.setStore(store_1);   
        chart.setDataField("count");   
        chart.setCategoryField("status");   
        
        chart.setExpressInstall("js/yui/assets/expressinstall.swf");   
        chart.setWidth(500);   
        chart.setHeight(360); 
        chart.setBodyBorder(false);
        
        
       
      
        ColumnConfig statusConfig = new ColumnConfig("提交和通过状态", "status", 100, true);   
        TextField textField = new TextField();   
        textField.setSelectOnFocus(true);   
        //responseConfig.setEditor(new GridEditor(textField));   
  
        NumberField numberField = new NumberField();   
        numberField.setSelectOnFocus(true);   
  
        ColumnConfig countConfig = new ColumnConfig("相应数值", "count", 130, true);   
        //countConfig.setEditor(new GridEditor(numberField));   
  
        ColumnConfig colorConfig = new ColumnConfig("所示颜色", "color", 60, true);   
        colorConfig.setRenderer(new Renderer() {   
            public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {   
                cellMetadata.setHtmlAttribute("style=\"background:" + value + ";\"");   
                return "";   
            }   
        });    
  
        ColumnModel columnModel_1 = new ColumnModel(new ColumnConfig[]{   
        		statusConfig,   
                countConfig,   
                colorConfig   
        });   
  
        EditorGridPanel grid_1 = new EditorGridPanel();   
        grid_1.setStore(store_1);   
        grid_1.setClicksToEdit(1);   
        grid_1.setColumnModel(columnModel_1);   
        grid_1.setWidth(300);   
  
        grid_1.addEditorGridListener(new EditorGridListenerAdapter() {   
            public void onAfterEdit(GridPanel grid, Record record, String field, Object newValue, Object oldValue, int rowIndex, int colIndex) {   
                store_1.commitChanges();   
                chart.refresh();   
            }   
        });   
        
        this.add(chart);
        this.add(grid_1);
  
	}
	
	private static Object[][] getData_1() {   
	    return new Object[][]{   
	            new Object[]{"已提交单位", new Integer(247), "#00b8bf"},   
	            new Object[]{"已通过单位", new Double(238), "#8dd5e7"},   
	            new Object[]{"未提交单位", new Double(505), "#c0fff6"},   
	            new Object[]{"退回单位", new Double(231), "#ffa928"}
  
	    };   
	}   

}