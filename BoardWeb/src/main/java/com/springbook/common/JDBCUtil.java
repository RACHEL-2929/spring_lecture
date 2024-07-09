package com.springbook.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	
	public static Connection getConnection(){
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				return DriverManager.getConnection
						("jdbc:oracle:thin:@localhost:1521:XE","spring","1234");
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return null;
	}
	
	//insert,update,delete
	public static void close(PreparedStatement stmt, Connection conn) {
		if(stmt != null) {//포트가 열려있다면 
			try {
				stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				stmt = null;
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
	}
	
	//select
	public static void close(ResultSet rs,PreparedStatement stmt, Connection conn) {
		
		if(rs != null) {//포트가 열려있다면 
			try {
				rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				rs = null;
			}
		}
		
		
		if(stmt != null) {//포트가 열려있다면 
			try {
				stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				stmt = null;
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
	}
	
}
