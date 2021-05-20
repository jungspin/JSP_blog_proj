package com.cos.db;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConn {
	
	public static Connection dbConn() {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			Connection conn = ds.getConnection();
			
			System.out.println("DB연결성공");
			return conn; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("DB연결실패");
		return null;
		
	}
}
