package com.buaa.project.client.panel;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.buaa.project.client.DatabaseService;
import com.buaa.project.client.DatabaseServiceAsync;
import com.buaa.project.client.data.BeanDTO;
import com.buaa.project.client.data.BeanFarenDTO;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.Position;
import com.gwtext.client.data.*;

import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.MessageBoxConfig;
import com.gwtext.client.widgets.PaddedPanel;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.WaitConfig;
import com.gwtext.client.widgets.Window;

import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.event.PanelListenerAdapter;
import com.gwtext.client.widgets.form.DateField;
import com.gwtext.client.widgets.form.FieldSet;
import com.gwtext.client.widgets.form.Form;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.VType;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.client.widgets.grid.event.GridCellListener;
import com.gwtext.client.widgets.grid.event.GridCellListenerAdapter;
import com.gwtext.client.widgets.layout.ColumnLayout;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.client.widgets.menu.Menu;


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

	
		this.setBorder(false);
		this.setFrame(true);   
	    this.setLabelAlign(Position.LEFT); 
	    this.setTitle("单位基本信息");
	    this.setIconCls("list-icon");
	    this.setClosable(true);
	    


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
	        fieldSet.setBorder(true);  
	        fieldSet.setCollapsible(true);
	        
	     final FieldSet fieldSetList = new FieldSet();
	     fieldSetList.setTitle("法人单位列表");
	     fieldSetList.setBorder(true);
	     fieldSetList.setHeight(400);
	    
	  
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
	        
	    
	       // fieldSet.addButton(bt);


	     

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
				grid.setBorder(false);
				grid.setAutoExpandColumn("name");
				grid.setWidth(200);
				
				
				grid.setAutoScroll(true);
				grid.setAutoHeight(true);
				GridView view = new GridView();
				view.setForceFit(true);
				grid.setView(view);
				fieldSetList.add(grid);
				fieldSetList.doLayout();

				if (store == null) {
					return;
				}

				List data = (List) response;

				Iterator it = data.iterator();

				while (it.hasNext()) {

					final BeanDTO bean = (BeanDTO) it.next();
					Object[] a = bean.toObjectArray();
					Object[][] b = new Object[][] { a };
					store.add(recordDef.createRecord(bean.toObjectArray()));

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
				//MessageBox.alert(name_faren);
				
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
		
		
			
			Toolbar toolbar = new Toolbar();
			ToolbarButton delete = new ToolbarButton("删除");
			ToolbarButton update = new ToolbarButton("修改");
			ToolbarButton add = new ToolbarButton("添加");
			
			toolbar.addButton(add);
			toolbar.addSpacer();
			toolbar.addButton(update);
			toolbar.addSpacer();
			toolbar.addButton(delete);
			toolbar.addSpacer();
	        
			Panel wholePanel = new Panel();
			wholePanel.setBodyBorder(true);
			
			Panel bottomPanel = new Panel();
			bottomPanel.setBodyBorder(false);
			bottomPanel.add(toolbar);
			
			delete.addListener( new ButtonListenerAdapter() {   
		    	   
		    	     public void onClick(Button button, EventObject e) {   
		               
		    	    	 
		    	    	 MessageBox.alert(name.getText());
		    	    	 DatabaseServiceAsync deleteFaren_service = DatabaseService.Util.getInstance();
		    	    	 
		    	    
		    	    	 
		    	    	 AsyncCallback cb_deleteFaren = new AsyncCallback(){

		    	    		 
		    	    		 
							public void onFailure(Throwable arg0) {
								// TODO Auto-generated method stub
								
							}

							public void onSuccess(Object result) {
								 
								
								Boolean ok = (Boolean)result;
								
								if(ok.booleanValue()){
									
									MessageBox.alert("ok");
									
								}
								else
									MessageBox.alert("删除失败！");
								
								
							}

		    	    		
		    	    	 };
		    	    	 
		    	    	 
		    	    	 deleteFaren_service.deleteFaren(name.getText(), cb_deleteFaren);
		    	    	 
		            }   
		        });   
			
			
			
	        Panel inner = new Panel();   
	        inner.setLayout(new ColumnLayout());     
	        Panel columnOne = new Panel();  
	        columnOne.setHeight(400);
	        columnOne.setLayout(new FitLayout());   


	        columnOne.add(fieldSetList);   
	        inner.add(columnOne, new ColumnLayoutData(0.4));   
 
	        inner.add(new PaddedPanel(fieldSet, 0, 10, 0, 0), new ColumnLayoutData(0.5)); 
		    wholePanel.add(inner);
		    wholePanel.add(toolbar);
			//delete.setWidth("40px");
		    
			final Window window = new Window();
			window.setTitle("添加法人单位");
			window.setIconCls("paste-icon");
			window.setResizable(true);
			window.setLayout(new FitLayout());
			window.setWidth(400);
			window.setHeight(100);
			window.setModal(false);
			window.setAutoHeight(false);
			window.setIconCls("window-icon");
		

			final FormPanel frm = new FormPanel();

			frm.setPaddings(20);
			//frm.setTitle("用户信息");
			frm.setWidth(300);
			frm.setFrame(true);

			final TextField  txtUsername = new TextField("用户名", "username");
			txtUsername.setId("name");
			final TextField txtPassword = new TextField("密码", "password");
			

			txtUsername.setRegex("^[a-zA-Z]*$");
			txtUsername.setRegexText("只允许输入字母");
			txtUsername.setAllowBlank(false);

			txtPassword.setPassword(true);
			txtPassword.setRegex("^[a-zA-Z]*$");
			txtPassword.setRegexText("只允许输入字母");
			txtPassword.setAllowBlank(false);

			

		

			frm.add(txtUsername);
			frm.add(txtPassword);
		
	        
		
			Button btSave = new Button("保存");
			btSave.setId("save");
			btSave.addListener(new ButtonListenerAdapter() {
				public void onClick(final Button button, EventObject e) {
					
					
					TextField txtUsername1 = (TextField)frm.getComponent(0);
					System.out.println(txtUsername1.getText());
					
					DatabaseServiceAsync service = DatabaseService.Util
					.getInstance();
					
					final AsyncCallback callback = new AsyncCallback(){

						public void onFailure(Throwable arg0) {
							// TODO Auto-generated method stub
							MessageBox.alert("保存失败");
						}

						public void onSuccess(Object arg0) {
							// TODO Auto-generated method stub
							MessageBox.show(new MessageBoxConfig() {
								{
									setMsg("正在保存, 请等待...");
									setProgressText("保存中...");
									setWidth(300);
									setWait(true);
									setWaitConfig(new WaitConfig() {
										{
											setInterval(200);
										}
									});
									setAnimEl(button.getId());

									Timer timer = new Timer() {
										public void run() {
											MessageBox.hide();
											// System.out.println("Done, Your fake data
											// was saved!");
										}
									};
									timer.schedule(8000);
								}
							});
								
							window.close();
							MessageBox.alert("保存成功");
						}
						
					};
					service.saveData(getFormDataAsMap(frm.getForm()), callback);
					
					
				//	String item = frm.getId(name);
					
					//item.
					
				//	 txtUsername2 = (TextField)frmf.getId();
					
					/*TextField txtUsername2 = (TextField)frm.getComponent(3);
					System.out.println(txtUsername2.getText());
					
					TextField txtUsername3 = (TextField)frm.getComponent(5);
					System.out.println(txtUsername3.getText());*/
					
					
				//	if (frm.getForm().isValid()) {

				//		
				//		Map formData = getFormDataAsMap(frm.getForm());

						

					
				//	} else {

				//		MessageBox.alert("输入有误", "请重新输入!");
				//	}

				}

			});

			Button btCancel = new Button("取消");
			btCancel.addListener(new ButtonListenerAdapter() {
				public void onClick(final Button button, EventObject e) {
					MessageBox.alert("取消", "重新输入");
					txtPassword.setValue("");
					txtUsername.setValue("");
				}

			});

			add.addListener( new ButtonListenerAdapter() {
				public void onClick(Button button, EventObject e) {

					final ExtElement element = Ext.get("main-panel");
					window.show();

	                     element.mask();
		
				window.addListener(new PanelListenerAdapter(){
					
					public void onClose(Panel panel){
						
						element.unmask();
					}
				});
				}

			});

			frm.addButton(btSave);
			frm.addButton(btCancel);
			window.add(frm);
	        
		this.add(wholePanel);

	}
	public Map getFormDataAsMap(Form form) {
		// 用户名=rui&密码=rui
		String formvalues = form.getValues();
        
		
		System.out.println("\n");
		
		Map formData = new HashMap();

		String[] nameValuePairs = formvalues.split("&");
		for (int i = 0; i < nameValuePairs.length; ++i) {
			String[] oneItem = nameValuePairs[i].split("=");

			formData.put(oneItem[0], oneItem[1]);
			//System.out.println(formData.get(oneItem[1]));
		}
          
		return formData;
	}
	

}
