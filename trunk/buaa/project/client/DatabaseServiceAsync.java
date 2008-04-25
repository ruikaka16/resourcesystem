package com.buaa.project.client;

import java.util.Map;

import com.gwtext.client.widgets.form.Validator;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DatabaseServiceAsync {

	public void saveData(Map formData, AsyncCallback callback);
	//客户端与服务器端的接口，可以是任何类型的数据
    public void login(String username,String password, AsyncCallback callback);
	//public void login(Map formData)throws Exception;
    public void validate(String username, AsyncCallback callback);
  

}
