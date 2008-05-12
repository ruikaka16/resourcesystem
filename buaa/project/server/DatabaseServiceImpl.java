package com.buaa.project.server;

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.Date;
import java.util.Map;


import com.buaa.project.client.DatabaseService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;


public class DatabaseServiceImpl extends RemoteServiceServlet implements
		DatabaseService {

	private Object conn;

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

		String sql = "select *  from test where id='" + username
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
		String sql = "select *  from test where id='" + username + "'";
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

	public boolean loadData(String name, String  psw) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		Connection conn = DriverManager.getConnection(url, "root", "rui");
		String cmd  = "select '"+ name+"'and '"+psw+"' from test";
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

	public String getdata(){
	      return "i wanna go instantly to centerPanel";
	   }

	public boolean addNews(String N_TITLE, String N_AUTHOR, String N_CONTENT) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		Connection conn = DriverManager.getConnection(url, "root", "rui");
		String cmd = "insert into news(N_TITLE,N_AUTHOR,N_CONTENT) values('" +N_TITLE + "','" +N_AUTHOR+ "','" +N_CONTENT+ "')";
		Statement stmt = conn.createStatement();
	     stmt.executeUpdate(cmd);
		return true;
	}


}
