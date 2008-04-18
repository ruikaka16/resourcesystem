package com.buaa.project.server;

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import com.buaa.project.client.DatabaseService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class DatabaseServiceImpl extends RemoteServiceServlet implements DatabaseService {

	public void saveData(Map formData) throws Exception {
		
		
		Class.forName("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql://localhost:3306/test" ;
		Connection conn= DriverManager.getConnection(url,"root","rui"); 

		StringBuffer sqlQuery = new StringBuffer("insert into test(id,psw,email)");
		sqlQuery.append("values(?,?,?)");
		PreparedStatement stmt = conn.prepareStatement(sqlQuery.toString());
	   
		 stmt.setString(1, URLDecoder.decode(formData.get("username").toString(),"UTF-8"));
		 stmt.setString(2, URLDecoder.decode(formData.get("password").toString(),"UTF-8"));
		 stmt.setString(3, URLDecoder.decode(formData.get("email").toString(),"UTF-8"));
		 
		 stmt.execute();
		 
		 conn.close();    
	     stmt.close(); 
	   //  System.out.println("connection close");
	}

	public void login(String id_txtLoginname) throws Exception {
	
		Class.forName("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql://localhost:3306/test" ;
		Connection conn= DriverManager.getConnection(url,"root","rui"); 
		
		String sql = "select * from test where id = '" +
		id_txtLoginname + "'";
		
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		
		 int i = 0;
		while(rs.next()){
			
			i++;
		}
		
	}

}