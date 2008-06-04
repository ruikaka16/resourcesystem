package com.buaa.project.client;





import java.util.Date;
import java.util.List;

import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.gwtext.client.widgets.form.Validator;

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
    public boolean validate(String username)throws Exception;
  
    public void saveLargeDevice(Map formData)throws Exception;
    
    public boolean addDevice(String name, String id)throws Exception;
  
    public boolean addFaren(String name, String zhuguan,String address,String suozaiaddress
    		,String xingzhi,String id,String id_1,String jigouid,String xzzgbm,String zipcode,String dwwz
    		,String dwsx,String hymc,String xkmc)throws Exception;
   
    public String getNewsContent(String N_TITLE)throws Exception;
    
    public List getdata()throws Exception;
    
    public boolean addNews(String NI_TITLE, String N_AUTHOR,String N_CONTENT,String N_TIME)throws Exception;
    

    public List autoComplete() throws Exception;
    
    public List getFaren(String name)throws Exception;
    
    public List getFarenList()throws Exception;
    
    public boolean deleteFaren(String name)throws Exception;
    
    public String userType(String name)throws Exception;
    
}
