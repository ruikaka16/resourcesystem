package com.buaa.project.client.panel;


import java.util.Iterator;
import java.util.List;

import com.buaa.project.client.DatabaseService;
import com.buaa.project.client.DatabaseServiceAsync;
import com.buaa.project.client.data.BeanDTO;
import com.buaa.project.client.data.BeanFarenDTO;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.data.*;

import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.PaddedPanel;
import com.gwtext.client.widgets.Panel;

import com.gwtext.client.widgets.form.DateField;
import com.gwtext.client.widgets.form.FieldSet;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.client.widgets.grid.event.GridCellListener;
import com.gwtext.client.widgets.grid.event.GridCellListenerAdapter;
import com.gwtext.client.widgets.layout.ColumnLayout;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;


public class SampleGrid extends FormPanel {

	private static final NumberFormat nf = NumberFormat.getFormat("#,##0.00",
			"$");

	private static final NumberFormat nfc = NumberFormat.getFormat("#,##0.00");

	private static final DateTimeFormat dateFormatter = DateTimeFormat
			.getFormat("M/d/y");

	private MemoryProxy proxy;
	
	private String name_faren;

/*	private static BaseColumnConfig[] columns = new BaseColumnConfig[] {

	new ColumnConfig("单位名称", "name", 300, true, null, "name")

	// new ColumnConfig("Price", "price", 35, true, new Renderer() {
	// public String render(Object value, CellMetadata cellMetadata, Record
	// record,
	// int rowIndex, int colNum, Store store) {
	// return nf.format(((Number) value).doubleValue());
	// }
	// }),

	// new ColumnConfig("Change", "change", 45, true, new Renderer() {
	// public String render(Object value, CellMetadata cellMetadata, Record
	// record,
	// int rowIndex, int colNum, Store store) {
	// float val = ((Float) value).floatValue();
	// String valString = nfc.format(val);
	// if (val < 0) {
	// return "<span style='color:red;'>" + valString + "</span>";
	// } else {
	// return valString;
	// }
	// }
	// }, "change"),

	// new ColumnConfig("% Change", "pctChange", 65, true, null, "pctChange"),

	// new ColumnConfig("Last Updated", "lastChanged", 65, true, new Renderer()
	// {
	// public String render(Object value, CellMetadata cellMetadata, Record
	// record,
	// int rowIndex, int colNum, Store store) {
	// Date date = (Date) value;
	// return dateFormatter.format(date);
	// }
	// }),
	// new ColumnConfig("Industry", "industry", 60, true)
	};*/

	

	private Object[][] getObj(Object response) {
		List data = (List) response;

		Iterator it = data.iterator();
		int i = data.size();
		int j = 0;
		Object[][] b = new Object[i][];
		while (it.hasNext()) {
			final BeanFarenDTO bean = (BeanFarenDTO) it.next();
			Object[] a = bean.toObjectArray();
			b[j++] = a;

		}

		return b;
	}

	public SampleGrid() {

		this.setWidth(650);
		this.setBorder(false);
		this.setFrame(true);   
	    this.setLabelAlign(Position.LEFT); 

		final GridPanel grid = new GridPanel();

		final Panel panel = new Panel();
		panel.setBorder(false);
		
		
		BaseColumnConfig[] columns = new BaseColumnConfig[] {

			new ColumnConfig("单位名称", "name", 200, true, null, "name")
			};
		
		final RecordDef recordDef = new RecordDef(
				new FieldDef[] { new StringFieldDef("name")
				});

		final ColumnModel columnModel = new ColumnModel(columns);
		

	
		 FieldSet fieldSet = new FieldSet();   
	        fieldSet.setLabelWidth(95);   
	        fieldSet.setTitle("法人单位详细信息");   
	        fieldSet.setAutoHeight(true);   
	        fieldSet.setBorder(false);   
	  
	        final TextField name = new TextField("单位全称", "name", 120);
			final TextField zhuguan = new TextField("上级主管单位", "company", 120);
			final TextField address = new TextField("单位通讯地址", "address", 120);
			final TextField suozaiaddress = new TextField("所在单位地址", "suozaiaddress", 120);
			final TextField xingzhi = new TextField("法人性质", "xingzhi", 120);
	        //the field names msut match the data field values from the Store   
	        fieldSet.add(name);   
	        fieldSet.add(zhuguan);   
	        fieldSet.add(address);   
	        fieldSet.add(suozaiaddress); 
	        fieldSet.add(xingzhi); 

		final DatabaseServiceAsync loadFarenList = DatabaseService.Util
				.getInstance();
		final AsyncCallback cb_loadFarenList = new AsyncCallback() {

			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub

			}

			public void onSuccess(Object response) {
				// TODO Auto-generated method stub

				proxy = new MemoryProxy(getObj(response));

				ArrayReader reader = new ArrayReader(recordDef);

				Store store = new Store(proxy, reader, true);

				store.load();

				grid.setStore(store);

				grid.setColumnModel(columnModel);

				grid.setFrame(true);
				grid.stripeRows(true);
				grid.setWidth(200);
				GridView view = new GridView();
				view.setForceFit(true);
				grid.setView(view);
				panel.add(grid);
				panel.doLayout();

				if (store == null) {
					return;
				}

				List data = (List) response;

				Iterator it = data.iterator();

				while (it.hasNext()) {

					final BeanDTO bean = (BeanDTO) it.next();
					Object[] a = bean.toObjectArray();
					Object[][] b = new Object[][] { a };
					//store.add(recordDef.createRecord(bean.toObjectArray()));

				}

				store.commitChanges();

			}

		};
		loadFarenList.getFarenList(cb_loadFarenList);
		
		grid.addGridCellListener(new GridCellListenerAdapter(){
			
			public void onCellClick(GridPanel grid, int rowIndex, int title,
					EventObject e){
				
				Record[] records = grid.getSelectionModel().getSelections();
				name_faren = "";
				for (int i = 0; i < records.length; ++i) {
					Record record = records[i];

					name_faren += record.getAsString("name");

				}
				MessageBox.alert(name_faren);
				
				DatabaseServiceAsync getFarenContentService = DatabaseService.Util
				.getInstance();
				
				AsyncCallback cb_getFarenContent = new AsyncCallback() {

					public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				
					}

					public void onSuccess(Object response) {
				// TODO Auto-generated method stub
						
						List data = (List)response;
						Iterator it = data.iterator();
						while(it.hasNext()){
							
							BeanFarenDTO bean = (BeanFarenDTO)it.next();
							name.setValue(bean.getName());
							address.setValue(bean.getAddrress());
							xingzhi.setValue(bean.getXingzhi());
							suozaiaddress.setValue(bean.getSuozaiaddress());
							zhuguan.setValue(bean.getZhuguan());
						}
				
				
					}
				
			
				};
				getFarenContentService.getFaren(name_faren, cb_getFarenContent);
				
			}
			
				
			
	});
		
	        
	  
	        Panel inner = new Panel();   
	        inner.setLayout(new ColumnLayout());     
	        Panel columnOne = new Panel();   
	        columnOne.setLayout(new FitLayout());   


	        columnOne.add(panel);   
	        inner.add(columnOne, new ColumnLayoutData(0.4));   
 
	        inner.add(new PaddedPanel(fieldSet, 0, 10, 0, 0), new ColumnLayoutData(0.4)); 
		
		this.add(inner);

	}
	

}
