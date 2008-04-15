package com.buaa.project.client;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DatabaseServiceAsync {

	public void saveData(Map formData, AsyncCallback callback);
	
	public void login(String txtLoginname, AsyncCallback callback);
	


}
