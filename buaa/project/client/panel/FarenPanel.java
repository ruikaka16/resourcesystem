package com.buaa.project.client.panel;

import java.util.Iterator;
import java.util.List;

import com.buaa.project.client.DatabaseService;
import com.buaa.project.client.DatabaseServiceAsync;
import com.buaa.project.client.data.BeanFarenDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
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
import com.gwtext.client.widgets.form.VType;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.gwtext.client.widgets.layout.ColumnLayout;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.layout.FormLayout;
import com.gwtext.client.widgets.layout.RowLayout;
import com.gwtext.client.widgets.layout.RowLayoutData;

public class FarenPanel extends Panel{
	
	ComboBox cb;
	Store store;
	public FarenPanel(){
		
		this.setBorder(true);
		   this.setPaddings(0);
		   this.setHeight(600);
		   this.setWidth(800);
		   this.setDraggable(true);
		   this.setClosable(true);
		   this.setTitle("法人单位信息查询");

		   
		   Panel wr = new Panel();
		   wr.setLayout(new RowLayout());
		   
		//this.setTitle("法人单位概况");
		
		// wrapperPanel.setBodyStyle("border-style:dotted;border-color:blue;");

		FormPanel formPanel_tn_3121_1 = new FormPanel();
		formPanel_tn_3121_1.setPaddings(5);
		formPanel_tn_3121_1.setFrame(true);
		formPanel_tn_3121_1.setLabelAlign(Position.LEFT);
		formPanel_tn_3121_1.setHeight(300);
		// formPanel_tn_3121.setLayout(new RowLayout());
		FormPanel formPanel_tn_3121_2 = new FormPanel();
		formPanel_tn_3121_2.setPaddings(5);
		formPanel_tn_3121_2.setFrame(true);
		formPanel_tn_3121_2.setLabelAlign(Position.LEFT);
		formPanel_tn_3121_2.setAutoHeight(true);
		formPanel_tn_3121_2.setTitle("从事和服务的国民经济行业");

		FormPanel formPanel_tn_3121_3 = new FormPanel();
		formPanel_tn_3121_3.setPaddings(5);
		formPanel_tn_3121_3.setFrame(true);
		formPanel_tn_3121_3.setLabelAlign(Position.LEFT);
		formPanel_tn_3121_3.setAutoHeight(true);
		formPanel_tn_3121_3.setTitle("主要科学领域");

		Panel firstPanel = new Panel();
		firstPanel.setLayout(new ColumnLayout());
		firstPanel.setBorder(false);

		Panel secPanel = new Panel();
		secPanel.setLayout(new ColumnLayout());
		secPanel.setBorder(false);

		Panel thirdPanel = new Panel();
		thirdPanel.setLayout(new ColumnLayout());
		thirdPanel.setBorder(false);

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
		name.setRegex("^[a-zA-Z]*$");
		name.setRegexText("只允许输入字母");
		
		zhuguan.setAllowBlank(false);
		zhuguan.setRegex("^[a-zA-Z]*$");
		zhuguan.setRegexText("只允许输入字母");
		
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
		final TextField dwsx = new TextField("单位属性", "dwsx");
		
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
		
		dwsx.setAllowBlank(false); 
		
		secondColumn_first.add(jigouid,new AnchorLayoutData("80%"));
		secondColumn_first.add(xzzgbm,new AnchorLayoutData("80%"));
		secondColumn_first.add(zipcode,new AnchorLayoutData("80%"));
		secondColumn_first.add(dwwz,new AnchorLayoutData("80%"));
		secondColumn_first.add(dwsx,new AnchorLayoutData("80%"));
		
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
		
	
		
	     
		Panel searchPanel = new Panel();
		searchPanel.setBorder(false);
		searchPanel.setTitle("法人单位信息");
	        
	        
	        final Store store = new SimpleStore("name", new Object[]{});  
	        store.load();   
	  
	        final ComboBox cb = new ComboBox("单位名称");   
	        cb.setMinChars(1);
	        
	        cb.setFieldLabel("法人单位名称");   
	        cb.setStore(store);   
	        cb.setDisplayField("name");   
	        cb.setMode(ComboBox.LOCAL);   
	        cb.setEmptyText("请输入单位名称");   
	        cb.setLoadingText("搜索中");   

	        cb.setTypeAhead(true);   
	        cb.setSelectOnFocus(true);   
	        cb.setWidth(200);   
	        //do not show drop fown icon   
	        cb.setHideTrigger(true);  
	        
	        
	        final RecordDef recordDef = new RecordDef(new FieldDef[]{new StringFieldDef("name")});

	  
	        FormPanel form1 = new FormPanel();  
	        form1.setLabelWidth(80);   
	        form1.setBorder(false); 
	        form1.setFrame(true);
	        form1.add(cb);   
	        searchPanel.add(form1);   
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
		
		
	//	this.add(formPanel_tn_3121_1, new RowLayoutData(160));
	//	this.add(formPanel_tn_3121_2, new RowLayoutData(60));
	//	this.add(formPanel_tn_3121_3, new RowLayoutData(60));
		
		wr.add(searchPanel,new RowLayoutData(60));
		wr.add(formPanel_tn_3121_1, new RowLayoutData(160));
		wr.add(formPanel_tn_3121_2, new RowLayoutData(60));
		wr.add(formPanel_tn_3121_3, new RowLayoutData(60));
	

		
		Button bt = new Button("查询");
		bt.addListener(new ButtonListenerAdapter(){
			
			public void onClick(Button button,EventObject e){
				MessageBox.alert(cb.getText());
				DatabaseServiceAsync loadFaren  =DatabaseService.Util.getInstance();
				
				AsyncCallback cb_getFarenInfo = new AsyncCallback() {

					public void onFailure(Throwable arg0) {
						// TODO Auto-generated method stub
						
					}

					public void onSuccess(Object result) {
						// TODO Auto-generated method stub
						
						List data = (List)result;
						Iterator it = data.iterator();
						while(it.hasNext()){
							
							BeanFarenDTO bean = (BeanFarenDTO)it.next();
							
							address.setValue(bean.getAddrress());
							xingzhi.setValue(bean.getXingzhi());
							name.setValue(bean.getName());
							zhuguan.setValue(bean.getZhuguan());
							zipcode.setValue(bean.getZipcode());
							hymc.setValue(bean.getHymc());
							xkmc.setValue(bean.getXkmc());
							jigouid.setValue(bean.getJigouid());
							id.setValue(bean.getId());
							id_1.setValue(bean.getId_1());
							suozaiaddress.setValue(bean.getSuozaiaddress());
							dwwz.setValue(bean.getDwwz());
							dwsx.setValue(bean.getDwsx());
							xzzgbm.setValue(bean.getXzzgbm());
						
						}
					}
					
				};
				loadFaren.getFaren(cb.getText(), cb_getFarenInfo);
			
			}
		});
		
		
		
		wr.addButton(bt);
		
		this.add(wr);
		
	}

}
