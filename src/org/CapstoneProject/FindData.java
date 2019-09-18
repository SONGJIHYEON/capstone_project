package org.CapstoneProject;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class FindData {
	
	public static Connection conn = ConnectionDB.getConnection();
	static String quary;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;
	

	public static Map<String, Serializable > finddata = new HashMap<String, Serializable>();
	
	public static Map<String, Serializable > finddataSet;
	
	public static List<Map<String, Serializable>> findListData = new ArrayList<Map<String, Serializable>>();
	
	/* ����ȣ�� �ִ� ��ũ ����Ʈ ���� */
	public static void initCustData(String sid) {

		finddata.put("���̵�", sid);
//		addrdata.put("A", NAME);
	}
//	
	
	static List<Map<String, Serializable>> findid(String name, String phone ) {
			
			quary = "select count(id) from cust where CUST_TP = 'ȸ��' and cust_nm = '" + name + "' and PH_NUM = "+ phone +"";
	
			findListData.clear();
			
			try {
			
				pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
				rs = pstm.executeQuery();
	
				while(rs.next()){
					
					finddataSet = new HashMap<String, Serializable>();
					
					finddataSet.put("COUNT(ID)", rs.getString(1)); 
			
					
	//				System.out.println(finddataSet);
					findListData.add(finddataSet);
					
					
				} 
				
			} catch (SQLException sqle) {
				System.out.println("select������ ���� �߻�");
				sqle.printStackTrace();
			}
			
			return findListData;
			
		}
	
	static List<Map<String, Serializable>> findid2(String name, String phone ) {
		
		quary = "select id from cust where CUST_TP = 'ȸ��' and cust_nm = '" + name + "' and PH_NUM = "+ phone +"";

		findListData.clear();
		
		try {
		
			pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();

			while(rs.next()){
				
				finddataSet = new HashMap<String, Serializable>();
				
				finddataSet.put("ID", rs.getString(1)); 
		
				
//				System.out.println(finddataSet);
				findListData.add(finddataSet);
				
				
			} 
			
		} catch (SQLException sqle) {
			System.out.println("select������ ���� �߻�");
			sqle.printStackTrace();
		}
		
		return findListData;
		
	}
	
	static List<Map<String, Serializable>> findpwd(String id, String name, String phone ) {
		
		quary = "select count(pwd) from cust where CUST_TP = 'ȸ��' and id = '" + id + "' and cust_nm = '" + name + "' and "
				+ "PH_NUM = "+ phone +"";

		findListData.clear();
		
		try {
		
			pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();

			while(rs.next()){
				
				finddataSet = new HashMap<String, Serializable>();
				
				finddataSet.put("COUNT(PWD)", rs.getString(1)); 
		
				
//				System.out.println(finddataSet);
				findListData.add(finddataSet);
				
				
			} 
			
		} catch (SQLException sqle) {
			System.out.println("select������ ���� �߻�");
			sqle.printStackTrace();
		}
		
		return findListData;
		
	}
	
static List<Map<String, Serializable>> findpwd2(String id, String name, String phone ) {
		
		quary = "select pwd from cust where CUST_TP = 'ȸ��' and id = '" + id + "' and cust_nm = '" + name + "' and "
				+ "PH_NUM = "+ phone +"";

		findListData.clear();
		
		try {
		
			pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();

			while(rs.next()){
				
				finddataSet = new HashMap<String, Serializable>();
				
				finddataSet.put("PWD", rs.getString(1)); 
		
				
//				System.out.println(finddataSet);
				findListData.add(finddataSet);
				
				
			} 
			
		} catch (SQLException sqle) {
			System.out.println("select������ ���� �߻�");
			sqle.printStackTrace();
		}
		
		return findListData;
		
	}
}
	




