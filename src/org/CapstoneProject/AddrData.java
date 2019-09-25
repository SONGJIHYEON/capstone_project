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
	
	/* ����ȣ�� �ִ� ��ũ ����Ʈ ���� */
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
//		custdata.put("�ּ�", sADDR);

	}
	
		
//	/* �������� �����ϴ� ���Ǿ� */
//	static void createCust() {
//		quary = "INSERT INTO CUST(CUST_NUM, CUST_NM, PH_NUM, ID, PWD, BD, ADDR, CUST_TP) VALUES(103,'" + custdata.get("����") + "','" + custdata.get("�޴�����ȣ") + "','"
//				+ custdata.get("���̵�") + "','" + custdata.get("��й�ȣ") + "','" + custdata.get("�������") + "','" + custdata.get("�ּ�") + "','1')";
//	System.out.println(quary);
//		try {
//			pstm = conn.prepareStatement(quary);
//			pstm.executeQuery();
//		} catch (SQLException sqle) {
//			System.out.println("select������ ���� �߻�");
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
			System.out.println("select������ ���� �߻�");
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
//			custdataSet.put("��й�ȣ", rs.getString(6));
//			custdataSet.put("�������", rs.getString(7));
//			custdataSet.put("�ּ�", rs.getString(8));
//			custdataSet.put("�����", rs.getString(9));
//			custdataSet.put("��������Ʈ", rs.getString(10));
//			custdataSet.put("���ν�����", rs.getString(11));
//			custdataSet.put("����������", rs.getString(12));
			
//			System.out.println(addrdataSet);
			addrListData.add(addrdataSet);
			
			
		} 
		
		
	} catch (SQLException sqle) {
		System.out.println("select������ ���� �߻�");
		sqle.printStackTrace();
	}
	
	return addrListData;
	}
}





