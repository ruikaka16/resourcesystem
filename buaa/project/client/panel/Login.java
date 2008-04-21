package com.buaa.project.client.panel;


import com.buaa.project.client.DatabaseService;
import com.buaa.project.client.DatabaseServiceAsync;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;

public class Login extends FormPanel{
	
	public Login(){
		
		this.setBorder(true);
		this.setFrame(true);
		final TextField txtName = new TextField("用户名","username",100);
		final TextField txtPsw = new TextField("密码","psw",100);
		txtPsw.setPassword(true);
		
		this.add(txtName);
		this.add(txtPsw);
		
		Button btLogin = new Button("登陆");
		
		
		btLogin.addListener(new ButtonListenerAdapter(){
			
			public void onClick(final Button button, EventObject e){
				
				final DatabaseServiceAsync loginService =DatabaseService.Util.getInstance();
				
				   AsyncCallback cb = new AsyncCallback(){
				
				  

					public void onFailure(Throwable arg0) {
						
						MessageBox.alert("登陆失败");
					}

					public void onSuccess(Object rs) {
						
						Boolean bool = (Boolean) rs;
						if(bool.booleanValue() == true){
							
							Login.this.hide();

						}								
					}				
				  };
					  
				  System.out.println("test");
				  loginService.login(txtName.getText(), txtPsw.getText(), cb);
			
			}
			
				
			
		});
        
		this.add(btLogin);
		
	}

}
