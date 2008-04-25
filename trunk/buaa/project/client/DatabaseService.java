package com.buaa.project.client;

import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface DatabaseService extends RemoteService {

	public static final String SERVICE_URI = "/databaseservice";

	public static class Util {

		public static DatabaseServiceAsync getInstance() {

			DatabaseServiceAsync instance = (DatabaseServiceAsync) GWT
					.create(DatabaseService.class);
			ServiceDefTarget target = (ServiceDefTarget) instance;
			target.setServiceEntryPoint(GWT.getModuleBaseURL() + SERVICE_URI);
			return instance;
		}
	}
	
	public void saveData(Map formData)throws Exception;
	//客户端与服务器端的接口，可以是任何类型的数据
    public boolean login(String username,String password) throws Exception;
	//public void login(Map formData)throws Exception;
  

}
