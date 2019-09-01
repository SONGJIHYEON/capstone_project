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



public class CheckId {
	
	public static Connection conn = ConnectionDB.getConnection();
	static String quary;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;
	

	public static Map<String, Serializable > iddata = new HashMap<String, Serializable>();
	
	public static Map<String, Serializable > iddataSet;
	
	public static List<Map<String, Serializable>> idListData = new ArrayList<Map<String, Serializable>>();
	
	/* 고객번호가 있는 링크 리스트 구성 */
	public static void initCustData(String sid) {

		iddata.put("아이디", sid);
//		addrdata.put("A", NAME);
	}
//	
//	public static void initCustData2(String sid, String pwd) {
//
//		iddata.put("아이디", sid);
//		iddata.put("비밀번호", pwd);
//	}
//	
		
//	/* 고객정보를 생성하는 질의어 */
//	static void createCust
//	
//	() {
//		quary = "INSERT INTO CUST(CUST_NUM, CUST_NM, PH_NUM, ID, PWD, BD, ADDR, CUST_TP) VALUES(103,'" + custdata.get("고객명") + "','" + custdata.get("휴대폰번호") + "','"
//				+ custdata.get("아이디") + "','" + custdata.get("비밀번호") + "','" + custdata.get("생년월일") + "','" + custdata.get("주소") + "','1')";
//	System.out.println(quary);
//		try {
//			pstm = conn.prepareStatement(quary);
//			pstm.executeQuery();
//		} catch (SQLException sqle) {
//			System.out.println("select문에서 예외 발생");
//			sqle.printStackTrace();
//		}
//
//	}
	
	
static List<Map<String, Serializable>> selectid() {
		
		quary = "select count(id) from cust where id = '"+iddata.get("아이디")+"'";

//		idListData.clear();
		
		try {
		
			pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();

			while(rs.next()){
				
				iddataSet = new HashMap<String, Serializable>();
				
				iddataSet.put("ID", rs.getString(1)); 
//				addrdataSet.put("SEQ", rs.getString(2));
			
				
				System.out.println(iddataSet);
				idListData.add(iddataSet);
				
				
			} 
			
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
		
		return idListData;
		
	}

static List<Map<String, Serializable>> selectlogin(String sid, String pwd) {
	
	quary = "select id, pwd from cust";
//	idListData.clear();

	try {
	
		pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
		rs = pstm.executeQuery();

			while(rs.next()){
			iddataSet = new HashMap<String, Serializable>();
			
			iddataSet.put("ID", rs.getString(1)); 
			iddataSet.put("PWD", rs.getString(2)); 
//			addrdataSet.put("SEQ", rs.getString(2));
//			addrdataSet.put("SIDO", rs.getString(3));
//			addrdataSet.put("GUGUN", rs.getString(4));
	
			
			System.out.println(iddataSet);
			idListData.add(iddataSet);
			}
		
	} catch (SQLException sqle) {
		System.out.println("select문에서 예외 발생");
		sqle.printStackTrace();
	}
	
	return idListData;
	}
}



