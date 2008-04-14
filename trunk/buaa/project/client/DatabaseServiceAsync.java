package com.buaa.project.client;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtext.client.widgets.form.TextField;

public interface DatabaseServiceAsync {

	public void saveData(Map formData, AsyncCallback callback);
	

	public void login(String id_txtLoginname, AsyncCallback callback);
	


}
