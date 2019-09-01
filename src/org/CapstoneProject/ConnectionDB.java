package org.CapstoneProject;

/** 
DB�����ϱ� 
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 �⺻���� DB�� �����ϴ� Ŭ������ jdbc����̹��� ���Ͽ� �ڹٿ� DB�� �����ϰ� DB�� ������ �����Ѵ�
 */

public class ConnectionDB {
	private static final String URL="jdbc:oracle:thin:@localhost:1521:XE";	// �����ϴ� DB�� �ּ�����
	private static final String USER="shop";	//�����ϴ� DB�� ��������
	private static final String PASSWORD = "1234"; // �����ϴ� DB������ �н���������
	
	private static Connection conn = null;	//jdbc�� ���� �ڹٿ� DB�� �������ִ� Ŭ���� ��ü
	
	static {
		// jdbc����̹��� ���Ͽ� �����ϰ����ϴ� DB�� �ּ�, ����, ��й�ȣ ������ �Ѱ��־� DB�� ����
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
