package config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class DBConnection {

	public static Connection getConnection() { //Connection
        Context initContext;
        try {
            initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
            Connection conn = ds.getConnection();
            System.out.println("DB연결성공");
           return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) {//Disconnection
	    try {
	        conn.close();
	        stmt.close();
	        rs.close();
	        System.out.println("DB연결 해제");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public static void close(Connection conn, Statement stmt) {
	    try {
	        conn.close();
	        stmt.close();
	        System.out.println("DB연결 해제");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}//클래스 마지막
