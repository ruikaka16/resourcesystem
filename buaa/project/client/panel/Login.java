package com.buaa.project.client.panel;


import com.buaa.project.client.DatabaseService;
import com.buaa.project.client.DatabaseServiceAsync;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;

public class Login extends FormPanel implements AsyncCallback{
	

	
	public Login(){
		
		this.setBorder(true);
		this.setFrame(true);
		final TextField txtName = new TextField("用户名","username",100);
		final TextField txtPsw = new TextField("密码","psw",100);
		txtPsw.setPassword(true);
		
		this.add(txtName);
		this.add(txtPsw);
		
		Button btLogin = new Button("登陆");
		
		final AsyncCallback cb = this;
		
		btLogin.addListener(new ButtonListenerAdapter(){
			
			public void onClick(final Button button, EventObject e){
				
				final DatabaseServiceAsync loginService =DatabaseService.Util.getInstance();
				
				String name = txtName.getText();
				String psw = txtPsw.getText();
				
				loginService.login(name, psw, cb);	 
					 MessageBox.wait("正在登陆");
				}

			
			
				
			
		});
        
		this.add(btLogin);
		
	}

	public void onFailure(Throwable arg0) {
		MessageBox.hide();
		System.out.println("login failer");
		Login.this.hide();
		MessageBox.alert("登陆失败");
		
	}

	public void onSuccess(Object arg0) {
		System.out.println("login sucess");
		Login.this.hide();
		
	}

}
