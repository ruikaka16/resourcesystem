package com.buaa.project.client;





import java.util.Date;
import java.util.List;

import java.util.Map;

import com.gwtext.client.widgets.form.Validator;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DatabaseServiceAsync {

	public void saveData(Map formData, AsyncCallback callback);
	//客户端与服务器端的接口，可以是任何类型的数据
    public void login(String username,String password, AsyncCallback callback);
	//public void login(Map formData)throws Exception;
    public void validate(String username, AsyncCallback callback);
  
    public void saveLargeDevice(Map formData, AsyncCallback callback);
    
    public void addDevice(String name, String id, AsyncCallback callback);
  
    public void addFaren(String name, String zhuguan,String address,String suozaiaddress
    		,String xingzhi,String id,String id_1,String jigouid,String xzzgbm,String zipcode,String dwwz
    		,String dwsx,String hymc,String xkmc, AsyncCallback callback);
   
    public void getNewsContent(String N_TITLE, AsyncCallback callback);
    
    public void getdata(AsyncCallback callback);
    
    public void addNews(String NI_TITLE, String N_AUTHOR,String N_CONTENT,String N_TIME, AsyncCallback callback);
    

    public void autoComplete(AsyncCallback callback);
    
    public void getFaren(String name, AsyncCallback callback);
    
}
