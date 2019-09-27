package org.CapstoneProject;

/** 
DB연결하기 
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 기본적인 DB를 연결하는 클래스로 jdbc드라이버를 통하여 자바와 DB를 연결하고 DB의 계정을 접속한다
 */

public class ConnectionDB {
	private static final String URL="jdbc:oracle:thin:@localhost:1521:XE";	// 연결하는 DB의 주소정보
	private static final String USER="shop";	//연결하는 DB의 계정정보
	private static final String PASSWORD = "1234"; // 연결하는 DB계정의 패스워드정보
	
	private static Connection conn = null;	//jdbc를 통해 자바와 DB를 연결해주는 클래스 객체
	
	static {
		// jdbc드라이버를 통하여 연결하고자하는 DB의 주소, 계정, 비밀번호 정보를 넘겨주어 DB에 접속
		try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 conn = DriverManager.getConnection(URL, USER, PASSWORD);
		}catch(ClassNotFoundException e){
			 e.printStackTrace();
		}catch(SQLException e) {
			 e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		return conn; 
		}
	
	public static void main(String[] args) {
	
		
	}
	
}