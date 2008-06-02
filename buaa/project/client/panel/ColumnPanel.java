package com.buaa.project.client.panel;

import com.gwtext.client.core.GenericConfig;
import com.gwtext.client.data.ArrayReader;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.IntegerFieldDef;
import com.gwtext.client.data.MemoryProxy;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Viewport;
import com.gwtext.client.widgets.chart.yui.ColumnChart;
import com.gwtext.client.widgets.chart.yui.SeriesDefY;
import com.gwtext.client.widgets.form.NumberField;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.EditorGridPanel;
import com.gwtext.client.widgets.grid.GridEditor;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.event.EditorGridListenerAdapter;
import com.gwtext.client.widgets.layout.VerticalLayout;

public class ColumnPanel extends Panel{

	public ColumnPanel(){
		
 
       this.setPaddings(15);   
       this.setTitle("柱状状图");
       this.setIconCls("columnChart-icon");
       this.setAutoScroll(true);
       
       MemoryProxy proxy = new MemoryProxy(getData());   
       RecordDef recordDef = new RecordDef(   
               new FieldDef[]{   
                       new StringFieldDef("month"),   
                       new IntegerFieldDef("submit"),   
                       new IntegerFieldDef("passed") ,
                       new IntegerFieldDef("no_submit"),
                       new IntegerFieldDef("return") ,
               }   
       );   
 
       ArrayReader reader = new ArrayReader(recordDef);   
       final Store store = new Store(proxy, reader);   
       store.load();   
 
       GenericConfig submitStyle = new GenericConfig();   
       submitStyle.setProperty("image", "images/tube.png");   
       submitStyle.setProperty("mode", "no-repeat");   
       submitStyle.setProperty("color", "0x2e434d");   
       submitStyle.setProperty("size", 20);   
 
       GenericConfig passedStyle = new GenericConfig();   
       passedStyle.setProperty("image", "images/tube.png");   
       passedStyle.setProperty("mode", "no-repeat");   
       passedStyle.setProperty("color", "0xc2d81e");   
       passedStyle.setProperty("size", 20);   
       
       GenericConfig no_submitStyle = new GenericConfig();   
       no_submitStyle.setProperty("image", "images/tube.png");   
       no_submitStyle.setProperty("mode", "no-repeat");   
       no_submitStyle.setProperty("color", "#00b8bf");   
       no_submitStyle.setProperty("size", 20); 
       
       GenericConfig returnStyle = new GenericConfig();   
       returnStyle.setProperty("image", "images/tube.png");   
       returnStyle.setProperty("mode", "no-repeat");   
       returnStyle.setProperty("color", "#8dd5e7");   
       returnStyle.setProperty("size", 20); 
 
       SeriesDefY[] seriesDef = new SeriesDefY[]{   
               new SeriesDefY("已提交单位", "submit", submitStyle),   
               new SeriesDefY("已通过单位", "passed", passedStyle),
               new SeriesDefY("未提交单位", "no_submit", no_submitStyle), 
               new SeriesDefY("退回单位", "return", returnStyle),
       };   
 
 
       final ColumnChart chart = new ColumnChart();   
       chart.setWMode("transparent");   
       chart.setStore(store);   
       chart.setSeries(seriesDef);   
       chart.setXField("month");   
 
       chart.setExpressInstall("js/yui/assets/expressinstall.swf");   
       chart.setWidth(500);   
       chart.setHeight(400);   
 
       this.add(chart);   
 
       ColumnConfig monthConfig = new ColumnConfig("月份", "month", 60, true);   
       monthConfig.setId("monthCol");   
       TextField textField = new TextField();   
       textField.setSelectOnFocus(true);   
       monthConfig.setEditor(new GridEditor(textField));   
 
       NumberField numberField = new NumberField();   
       numberField.setSelectOnFocus(true);   
 
       NumberField numberField2 = new NumberField();   
       numberField2.setSelectOnFocus(true);   
       
       NumberField numberField3 = new NumberField();   
       numberField2.setSelectOnFocus(true);  
       
       NumberField numberField4 = new NumberField();   
       numberField2.setSelectOnFocus(true); 
 
       ColumnConfig submitConfig = new ColumnConfig("已提交单位", "submit", 100, true);   
       submitConfig.setEditor(new GridEditor(numberField));   
 
       ColumnConfig passedConfig = new ColumnConfig("已通过单位", "passed", 100, true);   
       passedConfig.setEditor(new GridEditor(numberField2));  
       
       ColumnConfig no_submitConfig = new ColumnConfig("未提交单位", "no_submit", 100, true);   
       no_submitConfig.setEditor(new GridEditor(numberField3));
       
       ColumnConfig returnConfig = new ColumnConfig("退回单位", "return", 100, true);   
       returnConfig.setEditor(new GridEditor(numberField4));
 
       ColumnModel columnModel = new ColumnModel(new ColumnConfig[]{   
               monthConfig,  
               submitConfig,
               no_submitConfig,   
               passedConfig,
               returnConfig   
       });   
 
       EditorGridPanel grid = new EditorGridPanel();   
       grid.setStore(store);   
       grid.setClicksToEdit(1);   
       grid.setColumnModel(columnModel);   
       grid.setWidth(500);   
       grid.setAutoExpandColumn("monthCol");   
 
       grid.addEditorGridListener(new EditorGridListenerAdapter() {   
           public void onAfterEdit(GridPanel grid, Record record, String field, Object newValue, Object oldValue, int rowIndex, int colIndex) {   
               store.commitChanges();   
               chart.refresh();   
           }   
       });   
 
       this.add(grid);   
      // Viewport viewport = new Viewport(this);   
	}
	
	private static Object[][] getData() {   
        return new Object[][]{   
                new Object[]{"十月", new Integer(1354), new Integer(1442), new Integer(1000), new Integer(800)},   
                new Object[]{"十一月", new Integer(1326), new Integer(1496), new Integer(1442), new Integer(1000)},   
                new Object[]{"十二月", new Integer(1292), new Integer(1582), new Integer(200), new Integer(699)},   
                new Object[]{"一月", new Integer(1387), new Integer(1597), new Integer(1603), new Integer(1603)},   
                new Object[]{"二月", new Integer(1376), new Integer(1603), new Integer(1000), new Integer(2000)}   
        };   
    }   

}
