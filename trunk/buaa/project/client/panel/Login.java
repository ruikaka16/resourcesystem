package com.buaa.project.client.panel;


import com.buaa.project.client.DatabaseService;
import com.buaa.project.client.DatabaseServiceAsync;
import com.buaa.project.client.LoginTest;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Container;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.MessageBoxConfig;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.ToolbarItem;
import com.gwtext.client.widgets.WaitConfig;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.Form;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.HorizontalLayout;

public class Login extends Window {

	public Toolbar toolbar;
	TextField txtName;
	TextField txtPsw;
	LoginTest l = new LoginTest();
	
	public Login() {


		
		this.setTitle("身份验证");
		this.setWidth(495);
		this.setIconCls("eastPanel_1-icon");
	
		Image logo = new Image();
		logo.setUrl("image/logo1.jpg");
		logo.setVisible(true);
	

		toolbar = new Toolbar();
		toolbar.setWidth(480);
		

	    txtName = new TextField();
		txtName.setValue("");
		
		txtPsw = new TextField();
		txtPsw.setPassword(true);

		ToolbarButton bt1 = new ToolbarButton("登    陆");
		ToolbarButton bt2 = new ToolbarButton("忘记密码");
		ToolbarButton bt3 = new ToolbarButton("验证");
        
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
		toolbar.addButton(bt2);
		toolbar.addSpacer();
		toolbar.addButton(bt3);
		
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
								System.out.println("欢迎您访问!");
								
							}
						};
						timer.schedule(100000);
					}
				});

				AsyncCallback cb_login = new AsyncCallback() {

					public void onFailure(Throwable arg0) {

					}

					public void onSuccess(Object result) {
					
						Boolean ok = (Boolean) result;

						if (ok.booleanValue()) {
							
							MessageBox.alert("登陆成功!");
							close();
							System.out.println(l.westPanel.getId());
							l.westPanel.getEl().unmask();
							
						} else {
							MessageBox.alert("用户名或密码不正确!");
						}

					}

				};
				
			
				loginService.login(username, password, cb_login);
				
			}
			
			

		});
		
		bt3.addListener(new ButtonListenerAdapter(){
			
			public void onClick(final Button button, EventObject e){
				final String username = txtName.getText();
				final DatabaseServiceAsync validatorService = DatabaseService.Util.getInstance();
				
				final AsyncCallback cb_validator = new AsyncCallback() {

					public void onFailure(Throwable arg0) {
						// TODO Auto-generated method stub
						
						
					}

					public void onSuccess(Object result) {
						// TODO Auto-generated method stub
						Boolean ok = (Boolean) result;

						if (ok.booleanValue()) {
							
							MessageBox.alert("验证成功!");
					
						} else {
							MessageBox.alert("该用户名不存在!");
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
