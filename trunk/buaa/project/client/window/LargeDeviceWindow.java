package com.buaa.project.client.window;

import com.buaa.project.client.DatabaseService;
import com.buaa.project.client.DatabaseServiceAsync;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.DatePicker;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.FieldSet;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.VType;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.gwtext.client.widgets.layout.ColumnLayout;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.layout.FormLayout;
import com.gwtext.client.widgets.layout.RowLayoutData;



public class LargeDeviceWindow extends Window{
	
   public  LargeDeviceWindow(){
	
	   this.setBorder(true);
	   this.setPaddings(15);
	   this.setHeight(600);
	   this.setWidth(800);
	   this.setMaximizable(true);
	   this.setResizable(true);
	   this.setDraggable(true);
	   this.setTitle("大型科学仪器设备（设施）");
	   
	   
	   final DatePicker datePicker = new DatePicker();
	   
	   FieldSet fieldSet1 = new FieldSet("设备基本信息");
	   fieldSet1.setCollapsible(true);
	   fieldSet1.setFrame(true);
	   
	   Panel firstPanel = new Panel();
	   firstPanel.setLayout(new ColumnLayout());
	   firstPanel.setBorder(false);
	   firstPanel.setFrame(true);
	   
	   Panel firstColumn = new Panel();
	   firstColumn.setLayout(new FormLayout());
	   firstColumn.setBorder(false);
	   
	   Panel secondColumn = new Panel();
	   secondColumn.setLayout(new FormLayout());
	   secondColumn.setBorder(false);
	   
	   TextField id_device = new TextField("设备统一编号","id_device");
	   TextField id_company = new TextField("所在单位编号","id_company");
	   TextField id_sort = new TextField("设备分类编号","id_sort");
	   TextField name_chn = new TextField("中文名称","name_chn");
	   TextField name_forn = new TextField("英文名称","name_forn");
	   TextField type = new TextField("型号规格","type");
	   TextField merchn = new TextField("生产制造厂商","merchn");
	   
	   firstColumn.add(id_device,new AnchorLayoutData("80%"));
	   firstColumn.add(id_sort,new AnchorLayoutData("80%"));
	   firstColumn.add(name_forn,new AnchorLayoutData("80%"));
	   firstColumn.add(merchn,new AnchorLayoutData("80%"));
	   
	   ComboBox getMethord = new ComboBox("获取方式");
		final Store store = new SimpleStore(new String[]{"type", "methord"}, getMethord());
		store.load();  
		getMethord.setAllowBlank(false);
		getMethord.setStore(store);
		getMethord.setSelectOnFocus(true);
		getMethord.setMinChars(1);
		getMethord.setDisplayField("methord"); 
		getMethord.setMode(ComboBox.LOCAL);
		getMethord.setTriggerAction(ComboBox.ALL);
		getMethord.setEmptyText("选择获取方式");
		getMethord.setTypeAhead(true);
		getMethord.setSelectOnFocus(true);
		getMethord.setWidth(100);
		getMethord.setHideTrigger(false);
	   
	   secondColumn.add(id_company,new AnchorLayoutData("80%"));
	   secondColumn.add(name_chn,new AnchorLayoutData("80%"));
	   secondColumn.add(type,new AnchorLayoutData("80%"));
	   secondColumn.add(getMethord,new AnchorLayoutData("80%"));
	   
	   firstPanel.add(firstColumn,new ColumnLayoutData(0.5));
	   firstPanel.add(secondColumn,new ColumnLayoutData(0.5));
	   
	   fieldSet1.add(firstPanel);
//************************************************************   
	   FieldSet fieldSet2 = new FieldSet("设备所属信息");
	   fieldSet2.setCollapsible(true);
	   fieldSet2.setFrame(true);
	   
	   Panel secPanel = new Panel();
	   secPanel.setLayout(new ColumnLayout());
	   secPanel.setBorder(false);
	   secPanel.setFrame(true);
	   
	   Panel firstColumn_2 = new Panel();
	   firstColumn_2.setLayout(new FormLayout());
	   firstColumn_2.setBorder(false);
	   
	   Panel secColumn_2 = new Panel();
	   secColumn_2.setLayout(new FormLayout());
	   secColumn_2.setBorder(false);
	   
	   TextField company_belong = new TextField("所属法人单位","company_belong");
	   TextField department_belong = new TextField("所属部门","department_belong");
	   TextField contact_person = new TextField("联系人","contact_person");
	   TextField telephone = new TextField("联系电话","telephone");
	   TextField email = new TextField("E-mail地址","email");
	   
	  
	   email.setVtype(VType.EMAIL);
	    
	   firstColumn_2.add(company_belong,new AnchorLayoutData("80%"));
	   firstColumn_2.add(contact_person,new AnchorLayoutData("80%"));
	   firstColumn_2.add(email,new AnchorLayoutData("80%"));
	   
	   secColumn_2.add(department_belong,new AnchorLayoutData("80%"));
	   secColumn_2.add(telephone,new AnchorLayoutData("80%"));
	   
	   secPanel.add(firstColumn_2,new ColumnLayoutData(0.5));
	   secPanel.add(secColumn_2,new ColumnLayoutData(0.5));
	   
	   fieldSet2.add(secPanel);
//***************************************************************	   
	   
	   
	   
	   
	   final FormPanel frm_largeDevice = new FormPanel();
	   frm_largeDevice.setBorder(false);
	   frm_largeDevice.setLabelAlign(Position.LEFT);
	   frm_largeDevice.setFrame(true);
	  
	   
	   final TextField name = new TextField("仪器名称","nameLarge",200);
	   final TextField id = new TextField("型号","idLarge",200);
	  // DateField time = new DateField("出生年月", "timeLarge",200);

	   
	   Button save = new Button("保存");
	   save.addListener(new ButtonListenerAdapter(){
		  
		   public void onClick(final Button button,EventObject e){
			   
			   DatabaseServiceAsync service = DatabaseService.Util
				.getInstance();
			   
			   AsyncCallback cb_adDevice = new AsyncCallback() {

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
		   
               service.addDevice(name.getText(), id.getText(), cb_adDevice);
			}

		});
	//   time.addListener(new TextFieldListenerAdapter() {
	//		public void onEnable(Component component) {
	//			datePicker.show();
	//		}
	//	});
	   
	   
	   
	   frm_largeDevice.add(name);
	   frm_largeDevice.add(id);
	//   frm_largeDevice.add(time);
	   frm_largeDevice.add(save);
	   
	  // this.add(frm_largeDevice);
	   this.add(fieldSet1);
	   this.add(fieldSet2);
	   

   
   
  
   }

private static String[][] getMethord() {
	// TODO Auto-generated method stub
	return new String[][]{
			new String[]{"A","购置"},
			new String[]{"B","研制"},
			new String[]{"C","赠送"},
			new String[]{"D","其他"}
	};
}
}
