package com.buaa.project.client.window;

import com.buaa.project.client.DatabaseService;
import com.buaa.project.client.DatabaseServiceAsync;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.FieldSet;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.VType;
import com.gwtext.client.widgets.form.ComboBox.Mode;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.gwtext.client.widgets.layout.ColumnLayout;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.layout.FormLayout;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.client.widgets.layout.RowLayout;
import com.gwtext.client.widgets.layout.RowLayoutData;

public class FarenWindow extends Window{
	
	public FarenWindow(){
		
	    
		   this.setBorder(true);
		   this.setPaddings(10);
		   this.setHeight(600);
		   this.setWidth(800);
		   this.setMaximizable(true);
		   this.setResizable(true);
		   this.setDraggable(true);
		   this.setTitle("法人单位概况");
		   this.setFrame(true);


		FieldSet formPanel_tn_3121_1 = new FieldSet("法人单位基本信息");
		formPanel_tn_3121_1.setCollapsible(true);
		formPanel_tn_3121_1.setFrame(true);
		
		FieldSet formPanel_tn_3121_2 = new FieldSet();
		formPanel_tn_3121_2.setAutoHeight(true);
		formPanel_tn_3121_2.setCollapsible(true);
		formPanel_tn_3121_2.setTitle("从事和服务的国民经济行业");

	
		FieldSet formPanel_tn_3121_3 = new FieldSet();
		formPanel_tn_3121_3.setTitle("主要科学领域");
		formPanel_tn_3121_3.setCollapsible(true);
	

		Panel firstPanel = new Panel();
		firstPanel.setLayout(new ColumnLayout());
		firstPanel.setBorder(false);
		firstPanel.setFrame(true);

		Panel secPanel = new Panel();
		secPanel.setLayout(new ColumnLayout());
		secPanel.setBorder(false);
		secPanel.setFrame(true);
	

		Panel thirdPanel = new Panel();
		thirdPanel.setLayout(new ColumnLayout());
		thirdPanel.setBorder(false);
		thirdPanel.setFrame(true);

		Panel firstColumn = new Panel();
		firstColumn.setLayout(new FormLayout());
		firstColumn.setBorder(false);

		Panel firstColumn_first = new Panel();
		firstColumn_first.setLayout(new FormLayout());
		firstColumn_first.setBorder(false);

		Panel firstColumn_sec = new Panel();
		firstColumn_sec.setLayout(new FormLayout());
		firstColumn_sec.setBorder(false);

		Panel firstColumn_third = new Panel();
		firstColumn_third.setLayout(new FormLayout());
		firstColumn_third.setBorder(false);

		Panel columnOnePanel = new Panel();
		columnOnePanel.setLayout(new FormLayout());

		Panel columnOnePanel_sec = new Panel();
		columnOnePanel_sec.setLayout(new FormLayout());

		Panel columnOnePanel_third = new Panel();
		columnOnePanel_third.setLayout(new FormLayout());

		
		
		final TextField name = new TextField("单位全称", "name");
		final TextField zhuguan = new TextField("上一级主管单位", "company");
		final TextField address = new TextField("单位通讯地址", "address");
		final TextField suozaiaddress = new TextField("所在单位地址", "suozaiaddress");
		final TextField xingzhi = new TextField("法人性质", "xingzhi");
		
		name.setAllowBlank(false);
		
		zhuguan.setAllowBlank(false);
		
		address.setAllowBlank(false);
		suozaiaddress.setAllowBlank(false);
		xingzhi.setAllowBlank(false);
		
		firstColumn_first.add(name,new AnchorLayoutData("80%"));
		firstColumn_first.add(zhuguan,new AnchorLayoutData("80%"));
		firstColumn_first.add(address,new AnchorLayoutData("80%"));
		firstColumn_first.add(suozaiaddress,new AnchorLayoutData("80%"));
		firstColumn_first.add(xingzhi,new AnchorLayoutData("80%"));
		
		
		firstPanel.add(firstColumn_first, new ColumnLayoutData(0.5));
		
		final TextField id = new TextField("序号", "id");
		id.setAllowBlank(false); 
		id.setRegex("^\\d*$");
		id.setRegexText("只能输入数字类型！");
		
		firstColumn_sec.add(id,new AnchorLayoutData("80%"));
		
	
		secPanel.add(firstColumn_sec, new ColumnLayoutData(0.5));
		
		final TextField id_1 = new TextField("序号", "id");
		
		id_1.setAllowBlank(false); 
		id_1.setRegex("^\\d*$");
		id_1.setRegexText("只能输入数字类型！");
		
		firstColumn_third.add(id_1,new AnchorLayoutData("80%"));
		thirdPanel.add(firstColumn_third, new ColumnLayoutData(0.5));

		Panel secondColumn_first = new Panel();
		secondColumn_first.setLayout(new FormLayout());
		secondColumn_first.setBorder(false);

		Panel secondColumn_sec = new Panel();
		secondColumn_sec.setLayout(new FormLayout());
		secondColumn_sec.setBorder(false);

		Panel secondColumn_third = new Panel();
		secondColumn_third.setLayout(new FormLayout());
		secondColumn_third.setBorder(false);

		
		final TextField jigouid = new TextField("组织机构代码", "last");
		final TextField xzzgbm = new TextField("行政主管部门", "xzzgbm");
		final TextField zipcode = new TextField("邮政编码", "zipcode");
		final TextField dwwz = new TextField("单位网址", "dwwz");
	//	final TextField dwsx = new TextField("单位属性", "dwsx");
	
		 final Store store = new SimpleStore(new String[]{"type", "name"}, getStates());   
	        store.load();   
		
		final ComboBox cb_dwsx = new ComboBox("单位属性");
		cb_dwsx.setStore(store);
		cb_dwsx.setDisplayField("name");
		cb_dwsx.setSelectOnFocus(true);
		cb_dwsx.setMinChars(1);
		cb_dwsx.setMode(ComboBox.LOCAL);
		cb_dwsx.setTriggerAction(ComboBox.ALL);
		cb_dwsx.setEmptyText("选择属性类型");
		cb_dwsx.setTypeAhead(true);
		cb_dwsx.setSelectOnFocus(true);
		cb_dwsx.setWidth(100);
		cb_dwsx.setHideTrigger(false);
		
		
		jigouid.setAllowBlank(false);
		jigouid.setRegex("^[a-zA-Z]*$");
		jigouid.setRegexText("只允许输入字母");
		
		xzzgbm.setAllowBlank(false); 
		
		zipcode.setAllowBlank(false); 
		zipcode.setMaxLength(5);
		zipcode.setMinLength(5);
		zipcode.setRegex("^\\d*$");
		zipcode.setRegexText("只能输入数字类型！");
		
		dwwz.setAllowBlank(false); 
		dwwz.setVtype(VType.URL);
		
	//	dwsx.setAllowBlank(false); 
		
		secondColumn_first.add(jigouid,new AnchorLayoutData("80%"));
		secondColumn_first.add(xzzgbm,new AnchorLayoutData("80%"));
		secondColumn_first.add(zipcode,new AnchorLayoutData("80%"));
		secondColumn_first.add(dwwz,new AnchorLayoutData("80%"));
		secondColumn_first.add(cb_dwsx,new AnchorLayoutData("80%"));
		
		firstPanel.add(secondColumn_first, new ColumnLayoutData(0.5));

		final TextField hymc = new TextField("行业名称", "hymc");	
		secondColumn_sec.add(hymc,new AnchorLayoutData("80%"));
		
		hymc.setAllowBlank(false); 
		
		secPanel.add(secondColumn_sec, new ColumnLayoutData(0.5));
		final TextField xkmc = new TextField("学科名称", "xkmc");	
		
		xkmc.setAllowBlank(false);
		secondColumn_third.add(xkmc,new AnchorLayoutData("80%"));
		thirdPanel.add(secondColumn_third, new ColumnLayoutData(0.5));

		// add first panel as first column with 50% of the width

		formPanel_tn_3121_1.add(firstPanel);
		formPanel_tn_3121_2.add(secPanel);
		formPanel_tn_3121_3.add(thirdPanel);
		
	
		
		this.add(formPanel_tn_3121_1, new RowLayoutData(160));
		this.add(formPanel_tn_3121_2, new RowLayoutData(60));
		this.add(formPanel_tn_3121_3, new RowLayoutData(60));
	//	wr.add(formPanel_tn_3121_1, new RowLayoutData(160));
	//	wr.add(formPanel_tn_3121_2, new RowLayoutData(60));
	//	wr.add(formPanel_tn_3121_3, new RowLayoutData(60));
	
	//	this.add(wr);
		
		final Panel btPanel = new Panel();
	//	btPanel.setFrame(true);
		btPanel.setLayout(new HorizontalLayout(10));
		Button save = new Button("保存");
		//btPanel.addButton(save);
		Button close = new Button("关闭");
		//btPanel.addButton(close);
		
		close.addListener(new ButtonListenerAdapter(){
			
			public void onClick(Button button,EventObject e){

				close();
			}
		});
		
		save.addListener(new ButtonListenerAdapter(){
			
			public void onClick(Button button,EventObject e){
				
				  DatabaseServiceAsync service = DatabaseService.Util
					.getInstance();
				   
				   AsyncCallback cb_addFaren = new AsyncCallback() {

					public void onFailure(Throwable arg0) {
						// TODO Auto-generated method stub
						
					}

					public void onSuccess(Object result) {
						// TODO Auto-generated method stub
						Boolean ok = (Boolean) result;
						if (ok.booleanValue()) {
							
							MessageBox.alert("保存成功!");
							close();
						}
						else
							MessageBox.alert("失败!");
						
					}
					   
				   };
			   
	               service.addFaren(name.getText(), zhuguan.getText(), address.getText(), suozaiaddress.getText(), xingzhi.getText(), id.getText(), id_1.getText(), jigouid.getText(), xzzgbm.getText(), zipcode.getText(), dwwz.getText(), cb_dwsx.getText(), hymc.getText(), xkmc.getText(), cb_addFaren);
			}
		});
		this.addButton(save);
		this.addButton(close);
		}

	
		 private static String[][] getStates() {   
		        return new String[][]{   
		                new String[]{"A", "国有企业"},   
		                new String[]{"B", "私有企业"},   
		                new String[]{"C", "国有控股企业"}
		           
		        };
		 }
	

}
