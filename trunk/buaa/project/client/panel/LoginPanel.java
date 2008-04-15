package com.buaa.project.client.panel;


import java.util.Map;

import com.buaa.project.client.DatabaseService;
import com.buaa.project.client.DatabaseServiceAsync;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.SuggestOracle.Callback;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.core.TextAlign;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.FieldSet;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.gwtext.client.widgets.layout.ColumnLayout;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.layout.FormLayout;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.client.widgets.layout.VerticalLayout;


public class LoginPanel extends FormPanel implements AsyncCallback {
	
	//protected static final AsyncCallback callback = null;

	public LoginPanel(){
		
		
		
	 	this.setFrame(true);
		this.setWidth(200);
		this.setLabelWidth(75);
		this.setIconCls("loginPanel-icon");
		
		final ComboBox cb = new ComboBox();
		
		cb.setForceSelection(true);
		cb.setMinChars(1);
		cb.setFieldLabel("用户类型");
		//cb.setStore(store);
		cb.setDisplayField("state");
		cb.setMode(ComboBox.LOCAL);
		cb.setTriggerAction(ComboBox.ALL);
		cb.setEmptyText("选择类型");
		cb.setLoadingText("Searching...");
		cb.setTypeAhead(true);
		cb.setSelectOnFocus(true);
		cb.setWidth(100);
		cb.setHideTrigger(false);
		
		this.add(cb);

		final TextField txtLoginname = new TextField("用户名", "txtLoginname", 100);
		txtLoginname.setAllowBlank(false);
		this.add(txtLoginname);

		final TextField txtLoginpsw = new TextField("密码", "txtLoginpsw", 100);
		txtLoginpsw.setPassword(true);
		this.add(txtLoginpsw);
		
		final AsyncCallback callback = null;
       
		//System.out.println("1*******************");
	
		final Button btLogin = new Button("登陆");
		btLogin.setIconCls("btLogin-icon");
		btLogin.addListener(new ButtonListenerAdapter(){
			

		//	final  AsyncCallback callback = this;
		// 

			public void onClick(Button button,EventObject e){
				
				//	String id_txtLoginname = txtLoginname.getText();
			if(txtLoginname.isValid()){	
				
				DatabaseServiceAsync service = DatabaseService.Util
				.getInstance();
				String id_txtLoginname = txtLoginname.getText();
				   //System.out.println("2*******************");
	        	service.login(id_txtLoginname, callback);
			
				System.out.println(id_txtLoginname);
			}
			}
		});
		
		

		
		Button cancel = new Button("取消");
        cancel.addListener(new ButtonListenerAdapter(){
        	public void onClick(Button button,EventObject e){
        		if(txtLoginname.getText().length()!=0){
        		txtLoginname.clearInvalid();
        		}
        	}
        });
		this.addButton(btLogin);
		this.addButton(cancel);

		

	}
	
	public void onSuccess(Object arg0) {
		MessageBox.hide();
		System.out.println("login suess");
		MessageBox.alert("成功");

	}


	public void onFailure(Throwable arg0) {
		// TODO Auto-generated method stub
		MessageBox.hide();
		System.out.println("loginfailer");
		MessageBox.alert("失败");
	}

}
