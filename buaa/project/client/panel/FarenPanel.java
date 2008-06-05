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
import com.gwtext.client.data.Record;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.FieldSet;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.VType;
import com.gwtext.client.widgets.form.event.ComboBoxListener;
import com.gwtext.client.widgets.form.event.ComboBoxListenerAdapter;
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
		   this.setPaddings(5);
		   this.setHeight(600);
		   this.setWidth(800);
		   this.setClosable(true);
		   this.setFrame(true);
		   this.setAutoScroll(true);
		  

		   
		   Panel wr = new Panel();
		   wr.setLayout(new RowLayout());
		   
		   
		   
		//this.setTitle("法人单位概况");
		
		// wrapperPanel.setBodyStyle("border-style:dotted;border-color:blue;");
		FieldSet searchPanel = new FieldSet("法人单位检索");
		searchPanel.setPaddings(5);
		searchPanel.setCollapsible(true);
		searchPanel.setFrame(true);
		
		   
		FieldSet formPanel_tn_3121_1 = new FieldSet("法人单位信息查询");
		formPanel_tn_3121_1.setPaddings(5);
		formPanel_tn_3121_1.setFrame(true);
		formPanel_tn_3121_1.setCollapsible(true);
		//formPanel_tn_3121_1.setHeight(300);
		// formPanel_tn_3121.setLayout(new RowLayout());
		FieldSet formPanel_tn_3121_2 = new FieldSet("从事和服务的国民经济行业");
		formPanel_tn_3121_2.setPaddings(5);
		formPanel_tn_3121_2.setFrame(true);
		formPanel_tn_3121_2.setAutoHeight(true);
		formPanel_tn_3121_2.setCollapsible(true);
		formPanel_tn_3121_2.setTitle("从事和服务的国民经济行业");

		FieldSet formPanel_tn_3121_3 = new FieldSet("主要科学领域");
		formPanel_tn_3121_3.setPaddings(5);
		formPanel_tn_3121_3.setFrame(true);
		formPanel_tn_3121_3.setAutoHeight(true);
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

		
		
		final TextField name = new TextField("单位全称", "name",200);
		final TextField zhuguan = new TextField("上一级主管单位", "company",200);
		final TextField address = new TextField("单位通讯地址", "address",200);
		final TextField suozaiaddress = new TextField("所在单位地址", "suozaiaddress",200);
		final TextField xingzhi = new TextField("法人性质", "xingzhi",200);
		
		
		firstColumn_first.add(name,new AnchorLayoutData("80%"));
		firstColumn_first.add(zhuguan,new AnchorLayoutData("80%"));
		firstColumn_first.add(address,new AnchorLayoutData("80%"));
		firstColumn_first.add(suozaiaddress,new AnchorLayoutData("80%"));
		firstColumn_first.add(xingzhi,new AnchorLayoutData("80%"));
		
		
		firstPanel.add(firstColumn_first, new ColumnLayoutData(0.5));
		
		final TextField id = new TextField("序号", "id",200);

		
		firstColumn_sec.add(id,new AnchorLayoutData("80%"));
		
	
		secPanel.add(firstColumn_sec, new ColumnLayoutData(0.5));
		
		final TextField id_1 = new TextField("序号", "id",200);
		

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

		
		final TextField jigouid = new TextField("组织机构代码", "last",200);
		final TextField xzzgbm = new TextField("行政主管部门", "xzzgbm",200);
		final TextField zipcode = new TextField("邮政编码", "zipcode",200);
		final TextField dwwz = new TextField("单位网址", "dwwz",200);
		final TextField dwsx = new TextField("单位属性", "dwsx",200);
		
		
		secondColumn_first.add(jigouid,new AnchorLayoutData("80%"));
		secondColumn_first.add(xzzgbm,new AnchorLayoutData("80%"));
		secondColumn_first.add(zipcode,new AnchorLayoutData("80%"));
		secondColumn_first.add(dwwz,new AnchorLayoutData("80%"));
		secondColumn_first.add(dwsx,new AnchorLayoutData("80%"));
		
		firstPanel.add(secondColumn_first, new ColumnLayoutData(0.5));

		final TextField hymc = new TextField("行业名称", "hymc",200);	
		secondColumn_sec.add(hymc,new AnchorLayoutData("80%"));
		
		
		secPanel.add(secondColumn_sec, new ColumnLayoutData(0.5));
		final TextField xkmc = new TextField("学科名称", "xkmc",200);	
		
	
		secondColumn_third.add(xkmc,new AnchorLayoutData("80%"));
		thirdPanel.add(secondColumn_third, new ColumnLayoutData(0.5));

		// add first panel as first column with 50% of the width

		formPanel_tn_3121_1.add(firstPanel);
		formPanel_tn_3121_2.add(secPanel);
		formPanel_tn_3121_3.add(thirdPanel);
		
	
		
	     
	
	        
	        
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
			
	
		
			this.add(searchPanel,new RowLayoutData(60));
			this.add(formPanel_tn_3121_1, new RowLayoutData(160));
			this.add(formPanel_tn_3121_2, new RowLayoutData(60));
			this.add(formPanel_tn_3121_3, new RowLayoutData(60));
	
		cb.addListener(new ComboBoxListenerAdapter(){
			
			public void onSelect(ComboBox comboBox, Record record, int index){
				
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
							name.setValue(bean.getUserid());
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
			};
		});
	

		
	}

}
