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
	


}
