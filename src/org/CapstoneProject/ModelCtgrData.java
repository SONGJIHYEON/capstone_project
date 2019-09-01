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



public class ModelCtgrData {
	
	public static Connection conn = ConnectionDB.getConnection();
	static String quary;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;
	

	public static Map<String, Serializable > ModelCtgrdata = new HashMap<String, Serializable>();
	
	public static Map<String, Serializable > ModelCtgrdataSet;
	
	public static List<Map<String, Serializable>> ModelCtgrListData = new ArrayList<Map<String, Serializable>>();
	
	/* ����ȣ�� �ִ� ��ũ ����Ʈ ���� */
	public static void initModelCtgrData(int ModelCtgrNum, String FIRST_CTGR, String TOP_CLOTH_CTGR, String BOT_CLOTH_CTGR, 
			String OUTER_CTGR, String SHIR_CTGR, String SHOOSE_CTGR) {

		ModelCtgrdata.put("�𵨺з���ȣ", ModelCtgrNum);
		ModelCtgrdata.put("1���з�", FIRST_CTGR);
		ModelCtgrdata.put("���Ǻз�", TOP_CLOTH_CTGR);
		ModelCtgrdata.put("���Ǻз�", BOT_CLOTH_CTGR);
		ModelCtgrdata.put("�ƿ��ͺз�", OUTER_CTGR);
		ModelCtgrdata.put("�����з�", SHIR_CTGR);
		ModelCtgrdata.put("�Źߺз�", SHOOSE_CTGR);
//		custdata.put("A", TEL);
//		custdata.put("A", TEL);
//		custdata.put("A", TEL);
//		custdata.put("�ּ�", scust);

	}
	
		
	/* �������� �����ϴ� ���Ǿ� */
	static void createModelCtgr() {
		
		
		quary = "insert into model_ctgr (MODEL_CTGR_NUM,FIRST_CTGR,TOP_CLOTH_CTGR,BOT_CLOTH_CTGR,OUTER_CTGR,SHIR_CTGR,SHOOSE_CTGR) "
				+ "values ('"+ModelCtgrdata.get("�𵨺з���ȣ")+"', '" + ModelCtgrdata.get("1���з�") + "', '" + ModelCtgrdata.get("���Ǻз�") + "',"
						+ " "+ModelCtgrdata.get("���Ǻз�")+", "+ModelCtgrdata.get("�ƿ��ͺз�")+", "+ModelCtgrdata.get("�����з�")+", "+ModelCtgrdata.get("�Źߺз�")+")";
		
		
		System.out.println(quary);
		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select������ ���� �߻�");
			sqle.printStackTrace();
		}

	}
	
	
//static List<Map<String, Serializable>> selectModelCtgr() {
//		
//		quary = "select * from zipcode";
//		
//		custListData.clear();
//		
//		try {
//		
//			pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
//			rs = pstm.executeQuery();			
//			while(rs.next()){
//				
//				ModelCtgrdataSet = new HashMap<String, Serializable>();
//
//				ModelCtgrdataSet.put("ZIPCODE", rs.getString(1)); 
//				ModelCtgrdataSet.put("SEQ", rs.getString(2));
//				ModelCtgrdataSet.put("SIDO", rs.getString(3));
//				ModelCtgrdataSet.put("GUGUN", rs.getString(4));
//				ModelCtgrdataSet.put("DONG", rs.getString(5));
//				ModelCtgrdataSet.put("RI", rs.getString(6));
//				ModelCtgrdataSet.put("BUNJI", rs.getString(7));
//				ModelCtgrdataSet.put("BLDG", rs.getString(8));
//				ModelCtgrdataSet.put("ADDR", rs.getString(9));

//				
//				System.out.println(custdataSet);
//				ModelCtgrListData.add(ModelCtgrdataSet);
//				
//				
//			} 
//			
//			
//		} catch (SQLException sqle) {
//			System.out.println("select������ ���� �߻�");
//			sqle.printStackTrace();
//		}
//		
//		return ModelCtgrListData;
//		
//	}
}



