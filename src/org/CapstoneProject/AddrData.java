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



public class AddrData {
	
	public static Connection conn = ConnectionDB.getConnection();
	static String quary;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;
	

	public static Map<String, Serializable > addrdata = new HashMap<String, Serializable>();
	
	public static Map<String, Serializable > addrdataSet;
	
	public static List<Map<String, Serializable>> addrListData = new ArrayList<Map<String, Serializable>>();
	
	/* 고객번호가 있는 링크 리스트 구성 */
	public static void initCustData(String ZIPCODE, String SEQ, String SIDO, String GUGUN, String DONG, String RI, String BUNJI,
			String BLDG, String ADDR) {

//		addrdata.put("A", ZIPCODE);
//		addrdata.put("A", NAME);
//		addrdata.put("A", DET);
//		addrdata.put("A", ADDR);
//		addrdata.put("A", TEL);
//		addrdata.put("A", TEL);
//		addrdata.put("A", TEL);
//		addrdata.put("A", TEL);
//		addrdata.put("A", TEL);
//		custdata.put("주소", sADDR);

	}
	
		
//	/* 고객정보를 생성하는 질의어 */
//	static void createCust() {
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
	
	
static List<Map<String, Serializable>> selectAddr() {
		
		quary = "select * from zipcode";
		
//		custListData.clear();
		
		try {
		
			pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();			
			while(rs.next()){
				
				addrdataSet = new HashMap<String, Serializable>();

				addrdataSet.put("ZIPCODE", rs.getString(1)); 
				addrdataSet.put("SEQ", rs.getString(2));
				addrdataSet.put("SIDO", rs.getString(3));
				addrdataSet.put("GUGUN", rs.getString(4));
				addrdataSet.put("DONG", rs.getString(5));
				addrdataSet.put("RI", rs.getString(6));
				addrdataSet.put("BUNJI", rs.getString(7));
				addrdataSet.put("BLDG", rs.getString(8));
				addrdataSet.put("ADDR", rs.getString(9));
				
				//System.out.println(addrdataSet);
				addrListData.add(addrdataSet);
				
				
			} 
			
			
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
		
		return addrListData;
		
	}
static List<Map<String, Serializable>> SearchAddr(String search) {
	
	quary = "select * from zipcode where addr like '%" + search + "%'";
	
	addrListData.clear();
	
	try {
	
		pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
		rs = pstm.executeQuery();			
		while(rs.next()){
			
			addrdataSet = new HashMap<String, Serializable>();

			addrdataSet.put("ZIPCODE", rs.getString(1)); 
			addrdataSet.put("SEQ", rs.getString(2));
			addrdataSet.put("SIDO", rs.getString(3));
			addrdataSet.put("GUGUN", rs.getString(4));
			addrdataSet.put("DONG", rs.getString(5));
			addrdataSet.put("RI", rs.getString(6));
			addrdataSet.put("BUNJI", rs.getString(7));
			addrdataSet.put("BLDG", rs.getString(8));
			addrdataSet.put("ADDR", rs.getString(9));
//			custdataSet.put("비밀번호", rs.getString(6));
//			custdataSet.put("생년월일", rs.getString(7));
//			custdataSet.put("주소", rs.getString(8));
//			custdataSet.put("고객등급", rs.getString(9));
//			custdataSet.put("보유포인트", rs.getString(10));
//			custdataSet.put("할인시작일", rs.getString(11));
//			custdataSet.put("할인종료일", rs.getString(12));
			
//			System.out.println(addrdataSet);
			addrListData.add(addrdataSet);
			
			
		} 
		
		
	} catch (SQLException sqle) {
		System.out.println("select문에서 예외 발생");
		sqle.printStackTrace();
	}
	
	return addrListData;
	}
}





