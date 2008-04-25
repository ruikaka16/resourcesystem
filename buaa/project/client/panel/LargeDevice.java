package com.buaa.project.client.panel;

import java.util.HashMap;
import java.util.Map;

import com.buaa.project.client.DatabaseService;
import com.buaa.project.client.DatabaseServiceAsync;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.DatePicker;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.MessageBoxConfig;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.WaitConfig;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.DateField;
import com.gwtext.client.widgets.form.Form;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.event.TextFieldListenerAdapter;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.client.widgets.layout.VerticalLayout;

public class LargeDevice extends Window implements AsyncCallback{
	
   public  LargeDevice(){
	
	   this.setBorder(true);
	   this.setPaddings(15);
	   this.setHeight(600);
	   this.setWidth(800);
	   this.setMaximizable(true);
	   this.setResizable(true);
	   this.setDraggable(true);
	   this.setTitle("大型科学仪器设备（设施）");
	   
	   
	   final DatePicker datePicker = new DatePicker();
	   
	   
	   final FormPanel frm_largeDevice = new FormPanel();
	   frm_largeDevice.setBorder(false);
	   frm_largeDevice.setLabelAlign(Position.LEFT);
	   frm_largeDevice.setFrame(true);
	  
	   
	   TextField name = new TextField("仪器名称","nameLarge",200);
	   TextField id = new TextField("型号","idLarge",200);
	   DateField time = new DateField("出生年月", "timeLarge",200);

		final AsyncCallback callback = this;
	   
	   Button save = new Button("保存");
	   save.addListener(new ButtonListenerAdapter(){
		  
		   public void onClick(final Button button,EventObject e){
			   
			   if (frm_largeDevice.getForm().isValid()) {

					DatabaseServiceAsync service = DatabaseService.Util
							.getInstance();
					Map formData = getFormDataAsMap(frm_largeDevice.getForm());

					service.saveData(formData, callback);

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
				} else {

					MessageBox.alert("输入有误", "请重新输入!");
				}

			}

		});
	   time.addListener(new TextFieldListenerAdapter() {
			public void onEnable(Component component) {
				datePicker.show();
			}
		});
	   
	   
	   
	   frm_largeDevice.add(name);
	   frm_largeDevice.add(id);
	   frm_largeDevice.add(time);
	   frm_largeDevice.add(save);
	   
	   this.add(frm_largeDevice);
	   

   }
   
   public Map getFormDataAsMap(Form form) {
		// 用户名=rui&密码=rui
		String formvalues = form.getValues();
       
		MessageBox.alert(form.getValues()); 
		//System.out.println(form.getValues());
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

public void onFailure(Throwable arg0) {
	// TODO Auto-generated method stub
	MessageBox.hide();
	System.out.println(" data save failer!");
	MessageBox.alert("保存失败");
}

public void onSuccess(Object arg0) {
	// TODO Auto-generated method stub
	MessageBox.hide();
	System.out.println(" data  saved!");
	MessageBox.alert("保存成功");
}


}
