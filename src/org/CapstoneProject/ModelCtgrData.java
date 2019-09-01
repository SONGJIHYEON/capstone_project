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
	
	/* 고객번호가 있는 링크 리스트 구성 */
	public static void initModelCtgrData(int ModelCtgrNum, String FIRST_CTGR, String TOP_CLOTH_CTGR, String BOT_CLOTH_CTGR, 
			String OUTER_CTGR, String SHIR_CTGR, String SHOOSE_CTGR) {

		ModelCtgrdata.put("모델분류번호", ModelCtgrNum);
		ModelCtgrdata.put("1차분류", FIRST_CTGR);
		ModelCtgrdata.put("상의분류", TOP_CLOTH_CTGR);
		ModelCtgrdata.put("하의분류", BOT_CLOTH_CTGR);
		ModelCtgrdata.put("아우터분류", OUTER_CTGR);
		ModelCtgrdata.put("셔츠분류", SHIR_CTGR);
		ModelCtgrdata.put("신발분류", SHOOSE_CTGR);
//		custdata.put("A", TEL);
//		custdata.put("A", TEL);
//		custdata.put("A", TEL);
//		custdata.put("주소", scust);

	}
	
		
	/* 고객정보를 생성하는 질의어 */
	static void createModelCtgr() {
		
		
		quary = "insert into model_ctgr (MODEL_CTGR_NUM,FIRST_CTGR,TOP_CLOTH_CTGR,BOT_CLOTH_CTGR,OUTER_CTGR,SHIR_CTGR,SHOOSE_CTGR) "
				+ "values ('"+ModelCtgrdata.get("모델분류번호")+"', '" + ModelCtgrdata.get("1차분류") + "', '" + ModelCtgrdata.get("상의분류") + "',"
						+ " "+ModelCtgrdata.get("하의분류")+", "+ModelCtgrdata.get("아우터분류")+", "+ModelCtgrdata.get("셔츠분류")+", "+ModelCtgrdata.get("신발분류")+")";
		
		
		System.out.println(quary);
		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
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
//			System.out.println("select문에서 예외 발생");
//			sqle.printStackTrace();
//		}
//		
//		return ModelCtgrListData;
//		
//	}
}



