package com.buaa.project.server;


import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import java.util.Map;


import com.buaa.project.client.DatabaseService;
import com.buaa.project.client.data.BeanDTO;
import com.buaa.project.client.data.BeanFarenDTO;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;


public class DatabaseServiceImpl extends RemoteServiceServlet implements
		DatabaseService {



	public void saveData(Map formData) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		Connection conn = DriverManager.getConnection(url, "root", "rui");

		StringBuffer sqlQuery = new StringBuffer(
				"insert into test(id,psw,email)");
		sqlQuery.append("values(?,?,?)");
		PreparedStatement ps = conn.prepareStatement(sqlQuery.toString());

		ps.setString(1, URLDecoder.decode(formData.get("username").toString(),
				"UTF-8"));
		ps.setString(2, URLDecoder.decode(formData.get("password").toString(),
				"UTF-8"));
		ps.setString(3, URLDecoder.decode(formData.get("email").toString(),
				"UTF-8"));

		ps.execute();
		conn.close();
		ps.close();
		// System.out.println("connection close");
	}

	public boolean login(String username, String password) throws Exception {

		// public boolean login(Map formData)throws Exception{

		System.out.println(username);
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		Connection conn = DriverManager.getConnection(url, "root", "rui");

		String sql = "select *  from user where id='" + username
				+ "'and psw = '" + password + "'";

		System.out.println(username);

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		if (rs.next())
			return true;
		else
			return false;

	}

	public boolean validate(String username) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		Connection conn = DriverManager.getConnection(url, "root", "rui");
		String sql = "select *  from user where id='" + username + "'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		int i = 0;
		
			while (rs.next()) 

				i++;
				if (i > 0) 
					return true;
				 else 
					return false;

	
	}

	public void saveLargeDevice(Map formData) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		Connection conn = DriverManager.getConnection(url, "root", "rui");

	}

	public boolean addDevice(String name, String id) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		Connection conn = DriverManager.getConnection(url, "root", "rui");
		
		 String cmd = "insert into largedevice(name,id) values('" +name + "','" + id + "')";
		 Statement stmt = conn.createStatement();
	     stmt.executeUpdate(cmd);
	     
		return true;
	}

	public boolean addFaren(String name, String zhuguan, String address, String suozaiaddress, String xingzhi, String id, String id_1, String jigouid, String xzzgbm, String zipcode, String dwwz, String dwsx, String hymc, String xkmc) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		Connection conn = DriverManager.getConnection(url, "root", "rui");
		String cmd = "insert into faren(name,zhuguan,address,suozaiaddress,xingzhi,id,id_1,jigouid,xzzgbm,zipcode, dwwz,dwsx,hymc,xkmc) values('" +name + "','" + zhuguan + "','" + address + "','" + suozaiaddress + "'," +
				"'" + xingzhi + "','" + id + "','" + id_1 + "','" + jigouid + "','" + xzzgbm + "','" + zipcode + "','" + dwwz + "','" + dwsx + "','" + hymc + "','" + xkmc + "')";
		 Statement stmt = conn.createStatement();
	     stmt.executeUpdate(cmd);
		return true;
	}

	public boolean loadData() throws Exception {
	
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		Connection conn = DriverManager.getConnection(url, "root", "rui");
		String cmd  = "select * from user ";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(cmd);
		int i=0;
	    while(rs.next())
	    	i++;
	    if (i > 0) 
			return true;
		 else 
			return false;
		
	}

	public List getdata(){
		try {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		Connection conn = DriverManager.getConnection(url, "root", "rui");
		String cmd  = "select * from news order by N_ID desc";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(cmd);
	  //  return "fsdfsfsaffafdsa";
		
		
		List userInfo = new ArrayList(); 
		while(rs.next()){
			BeanDTO bean  = new BeanDTO();
			bean.setN_TITLE(rs.getString("N_TITLE"));
			bean.setN_AUTHOR(rs.getString("N_AUTHOR"));
			bean.setN_TIME(rs.getString("N_TIME"));
			bean.setN_ID(rs.getString("N_ID"));
			userInfo.add(bean);
			
		}
	
		return userInfo;
		

	}
		catch (Exception ex) {
		      ex.printStackTrace();
		    }
		return null;
	   }

	public boolean addNews(String N_TITLE, String N_AUTHOR, String N_CONTENT,String N_TIME) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		Connection conn = DriverManager.getConnection(url, "root", "rui");
		String cmd = "insert into news(N_TITLE,N_AUTHOR,N_CONTENT,N_TIME) values('" +N_TITLE + "','" +N_AUTHOR+ "','" +N_CONTENT+ "','" +N_TIME+ "')";
		Statement stmt = conn.createStatement();
	     stmt.executeUpdate(cmd);
		return true;
	}

	public String getNewsContent(String N_TITLE) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			Connection conn = DriverManager.getConnection(url, "root", "rui");
		      String cmd =
		          "select N_CONTENT from news where N_TITLE = '"+ N_TITLE +"'";
		     Statement stmt = conn.createStatement();
		     ResultSet rs = stmt.executeQuery(cmd);
		     
		     while(rs.next()){
		    	 
		    	
		    	String newstitle = rs.getString("N_CONTENT");
		    	System.out.println(newstitle); 
		    	return newstitle;
		    	
		     }
		    
		      
		    }
		catch (Exception ex) {
		      ex.printStackTrace();
		    }

		    return null;
		  }

	public List autoComplete() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			Connection conn = DriverManager.getConnection(url, "root", "rui");
		      String cmd =
		          "select name from faren ";
		     Statement stmt = conn.createStatement();
		     ResultSet rs = stmt.executeQuery(cmd);
		     List faren = new ArrayList(); 
		     while(rs.next()){	
		    	 BeanFarenDTO b = new BeanFarenDTO();
		    	 b.setName(rs.getString("name"));
		    	 faren.add(b);
		    	 

		     } 
		    
		     return faren;

		    }
		catch (Exception ex) {
		      ex.printStackTrace();
		    }
		    return null;
		  }

	public List getFaren(String name) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			Connection conn = DriverManager.getConnection(url, "root", "rui");
		      String cmd =
		          "select * from faren where name = '"+ name +"' ";
		     Statement stmt = conn.createStatement();
		     ResultSet rs = stmt.executeQuery(cmd);
		     List faren = new ArrayList(); 
		     while(rs.next()){	
		    	 BeanFarenDTO b = new BeanFarenDTO();
		    	 b.setName(rs.getString("name"));
		    	 b.setAddress(rs.getString("address"));
		    	 b.setDwsz(rs.getString("dwwz"));
		    	 b.setDwsz(rs.getString("dwsx"));
		    	 b.setHymc(rs.getString("hymc"));
		    	 b.setId(rs.getString("id"));
		    	 b.setId_1(rs.getString("id_1"));
		    	 b.setJigouid(rs.getString("jigouid"));
		    	 b.setXingzhi(rs.getString("xingzhi"));
		    	 b.setXkmc(rs.getString("xkmc"));
		    	 b.setXzzgbm(rs.getString("xzzgbm"));
		    	 b.setZhuguan(rs.getString("zhuguan"));
		    	 b.setZipcode(rs.getString("zipcode"));
		    	 b.setSuoziaddress(rs.getString("suozaiaddress"));
		    	 faren.add(b);
		     } 
		    
		     return faren;

		    }
		catch (Exception ex) {
		      ex.printStackTrace();
		    }
		    return null;
		  }

	public List getFarenList() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			Connection conn = DriverManager.getConnection(url, "root", "rui");
		      String cmd =
		          "select * from faren ";
		     Statement stmt = conn.createStatement();
		     ResultSet rs = stmt.executeQuery(cmd);
		     List faren = new ArrayList(); 
		     while(rs.next()){	
		    	 BeanFarenDTO b = new BeanFarenDTO();
		    	 b.setName(rs.getString("name"));
		    	 b.setAddress(rs.getString("address"));
		    	 b.setDwsz(rs.getString("dwwz"));
		    	 b.setDwsz(rs.getString("dwsx"));
		    	 b.setHymc(rs.getString("hymc"));
		    	 b.setId(rs.getString("id"));
		    	 b.setId_1(rs.getString("id_1"));
		    	 b.setJigouid(rs.getString("jigouid"));
		    	 b.setXingzhi(rs.getString("xingzhi"));
		    	 b.setXkmc(rs.getString("xkmc"));
		    	 b.setXzzgbm(rs.getString("xzzgbm"));
		    	 b.setZhuguan(rs.getString("zhuguan"));
		    	 b.setZipcode(rs.getString("zipcode"));
		    	 b.setSuoziaddress(rs.getString("suozaiaddress"));
		    	 faren.add(b);
		     } 
		    
		     return faren;
    }
		catch (Exception ex) {
		      ex.printStackTrace();
		    }
		    return null;
		  }

	public boolean deleteFaren(String name) throws Exception {
		

		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		Connection conn = DriverManager.getConnection(url, "root", "rui");
	      String cmd = "delete from faren where name='" + name + "'" ;
	    Statement stmt = conn.createStatement();
	    stmt.executeUpdate(cmd);
	    return true;
		
	}
	
		
}

	



	

