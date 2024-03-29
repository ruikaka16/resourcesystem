package com.buaa.project.client.panel;


import com.buaa.project.client.DatabaseService;
import com.buaa.project.client.DatabaseServiceAsync;
import com.buaa.project.client.ResourceSystem;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.MessageBoxConfig;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.ToolbarItem;
import com.gwtext.client.widgets.WaitConfig;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.Field;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.event.TextFieldListenerAdapter;

public class Login extends Window {

	public Toolbar toolbar;
	TextField txtName;
	TextField txtPsw;
	ResourceSystem l = new ResourceSystem();
		
	public Login ()  {
		
		this.setTitle("身份验证");
		this.setWidth(475);
		this.setIconCls("eastPanel_1-icon");
		
		Image logo = new Image();
		logo.setUrl("image/logo2.jpg");
		logo.setVisible(true);
	

		toolbar = new Toolbar();
		toolbar.setWidth(475);
		
	    txtName = new TextField();
		txtName.setValue("");
		
		txtPsw = new TextField();
		txtPsw.setPassword(true);

		ToolbarButton bt1 = new ToolbarButton("登    陆");

        
		Image image = new Image();
		image.setUrl("image/user.gif");
	
		
			
		toolbar.addText("用户名");
		toolbar.addSpacer();
		toolbar.addItem(new ToolbarItem(new Image("image/user.gif").getElement()));
		toolbar.addSpacer();
		toolbar.addField(txtName);
		toolbar.addSpacer();
	
		
		toolbar.addText("密码");
		toolbar.addSpacer();
		toolbar.addItem(new ToolbarItem(new Image("image/mm.gif").getElement()));
		toolbar.addSpacer();
		toolbar.addField(txtPsw);
		toolbar.addSpacer();
		toolbar.addButton(bt1);
		toolbar.addSpacer();
	
		

		
		txtPsw.setPassword(true);

		bt1.addListener(new ButtonListenerAdapter() {


			public void onClick(final Button button, EventObject e) {

				String username = txtName.getText();
				String password = txtPsw.getText();
				DatabaseServiceAsync loginService = DatabaseService.Util
						.getInstance();
				
			

				// MessageBox.wait("正在登陆");

				MessageBox.show(new MessageBoxConfig() {
					{
						setMsg("正在登陆......");
						setProgressText("登陆中...");
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
							}
						};
						timer.schedule(100000);
					}
				});

				AsyncCallback cb_login = new AsyncCallback() {

					public void onFailure(Throwable arg0) {

					}

					public void onSuccess(Object result) {
					
						System.out.println(result.toString()+"********");
						Boolean ok = (Boolean) result;

						if (ok.booleanValue()) {
							
							MessageBox.alert("登陆成功!");
							close();
							final ExtElement  element1 = Ext.get("west");
							element1.unmask();
							
					DatabaseServiceAsync typeService = DatabaseService.Util.getInstance();
					
					AsyncCallback cb_type = new  AsyncCallback(){

						public void onFailure(Throwable arg0) {
							// TODO Auto-generated method stub
							
						}

						public void onSuccess(Object type) {
							// TODO Auto-generated method stub
							
							String id = (String)type;
							
							
							if(id.equals("1")){//1代表中心管理员
								
								Ext.get("treePanel1").mask("您没有权限！");
								Ext.get("treePanel2").mask("您没有权限！");
								Ext.get("treePanel3").mask("您没有权限！");
								Ext.get("treePanel4").mask("您没有权限！");
								Ext.get("treePanel5").mask("您没有权限！");
								Ext.get("treePanel6").mask("您没有权限！");
							
								
								
							}
							if(id.equals("2")){//2代表法人单位 
																
								Ext.get("treePanel1").mask("您没有权限！");
								Ext.get("treeNode2_1").mask();
							}
						}
						
					};
					typeService.userType(txtName.getText(), cb_type);

							
							final ExtElement element4 = Ext.get("logout");
							element4.setVisible(true);
	
							
						} else {
							MessageBox.alert("密码输入有误，请重新输入!");
							txtPsw.setValue("");
						}

					}

				};
				
			
				loginService.login(username, password, cb_login);
				
			}
			
			

		});
		
		
		
		txtName.addListener (new TextFieldListenerAdapter () {
		
			public void onChange (final Field field, final Object newVal, final Object oldVal) {

				
				final String username = txtName.getText();
				final DatabaseServiceAsync validatorService = DatabaseService.Util.getInstance();
				
				final AsyncCallback cb_validator = new AsyncCallback() {

					public void onFailure(Throwable arg0) {
						// TODO Auto-generated method stub

						}

					public void onSuccess(Object result) {
						
						Boolean ok = (Boolean) result;

						if (ok.booleanValue()) {
							
							//toolbar.addItem(new ToolbarItem(new Image("image/add.gif").getElement()));
						
							//MessageBox.alert("用户名验证成功!");
					
						} else {
							MessageBox.alert("该用户名不存在，请重新输入!");
							txtName.setValue("");
						}
					
					}
					
				};
				validatorService.validate(username, cb_validator);
				
			
				}
			});
		
		
		this.add(logo);
		this.add(toolbar);

	
		
	
		
	}

}
