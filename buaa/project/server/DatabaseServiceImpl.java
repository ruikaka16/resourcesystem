package com.buaa.project.server;

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import com.buaa.project.client.panel.Login;

import com.buaa.project.client.DatabaseService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gwtext.client.widgets.form.TextField;

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
		try {
			while (rs.next()) {

				i++;
				if (i > 0) {
					return true;
				} else {
					return false;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	
		return true;
	}

}
