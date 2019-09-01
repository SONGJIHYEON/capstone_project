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



public class ModelData {
	
	public static Connection conn = ConnectionDB.getConnection();
	static String quary;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;
	

	public static Map<String, Serializable > Modeldata = new HashMap<String, Serializable>();
	
	public static Map<String, Serializable > ModeldataSet;
	
	public static List<Map<String, Serializable>> ModelListData = new ArrayList<Map<String, Serializable>>();
	
	/* 고객번호가 있는 링크 리스트 구성 */
	public static void initModelData(String MODEL_NUM, String MODEL_CTGR_NUM, String MODEL_NM, String MODEL_EXP) {

		Modeldata.put("모델번호", MODEL_NUM);
		Modeldata.put("모델분류번호", MODEL_CTGR_NUM);
		Modeldata.put("모델이름", MODEL_NM);
		Modeldata.put("모델상세정보", MODEL_EXP);
	}
	
		
	/* 고객정보를 생성하는 질의어 */
	static void createModel() {
		
		
		quary = "insert into model values ('"+Modeldata.get("모델번호")+"', '" + Modeldata.get("모델분류번호") + "', '" + Modeldata.get("모델이름") + "', "
				+ " '"+Modeldata.get("모델상세정보")+"')";
		
		
		System.out.println(quary);
		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

	}
	
static List<Map<String, Serializable>> searchModel(String search) {
		
		quary = "SELECT MODEL_NM, MODEL_NUM, FIRST_CTGR, TOP_CLOTH_CTGR, BOT_CLOTH_CTGR, OUTER_CTGR, SHIR_CTGR, SHOOSE_CTGR FROM  MODEL "
				+ "full OUTER JOIN MODEL_CTGR ON Model.MODEL_CTGR_NUM = Model_CTGR.MODEL_CTGR_NUM where MODEL_NM like '%" + search + "%'";
		
		ModelListData.clear();
		
		try {
		System.out.println(quary);
			pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();			
			while(rs.next()){
				
				ModeldataSet = new HashMap<String, Serializable>();
				
				ModeldataSet.put("MODEL_NM", rs.getString(1)); 
				ModeldataSet.put("MODEL_NUM", rs.getString(2)); 
				ModeldataSet.put("FIRST_CTGR", rs.getString(3)); 
				ModeldataSet.put("TOP_CLOTH_CTGR", rs.getString(4)); 
				ModeldataSet.put("BOT_CLOTH_CTGR", rs.getString(5)); 
				ModeldataSet.put("OUTER_CTGR", rs.getString(6)); 
				ModeldataSet.put("SHIR_CTGR", rs.getString(7)); 
				ModeldataSet.put("SHOOSE_CTGR", rs.getString(8)); 
				
//				ModeldataSet.put("FIRST_CTGR", rs.getString(2)); 


				ModelListData.add(ModeldataSet);
//				System.out.println(ModelListData);
				
			} 
			
			
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
		
		return ModelListData;
		
	}

static List<Map<String, Serializable>> searchModel1(String search) {
	
	quary = "SELECT MODEL_NM, MODEL_NUM, FIRST_CTGR, TOP_CLOTH_CTGR, BOT_CLOTH_CTGR, OUTER_CTGR, SHIR_CTGR, SHOOSE_CTGR FROM  MODEL "
			+ "full OUTER JOIN MODEL_CTGR ON Model.MODEL_CTGR_NUM = Model_CTGR.MODEL_CTGR_NUM where FIRST_CTGR like '%" + search + "%'";
	
	ModelListData.clear(); 
	
	try {
	System.out.println(quary);
		pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
		rs = pstm.executeQuery();			
		while(rs.next()){
			
			ModeldataSet = new HashMap<String, Serializable>();
			
			ModeldataSet.put("MODEL_NM", rs.getString(1)); 
			ModeldataSet.put("MODEL_NUM", rs.getString(2)); 
			ModeldataSet.put("FIRST_CTGR", rs.getString(3)); 
			ModeldataSet.put("TOP_CLOTH_CTGR", rs.getString(4)); 
			ModeldataSet.put("BOT_CLOTH_CTGR", rs.getString(5)); 
			ModeldataSet.put("OUTER_CTGR", rs.getString(6)); 
			ModeldataSet.put("SHIR_CTGR", rs.getString(7)); 
			ModeldataSet.put("SHOOSE_CTGR", rs.getString(8)); 
			
//			ModeldataSet.put("FIRST_CTGR", rs.getString(2)); 


			ModelListData.add(ModeldataSet);
//			System.out.println(ModelListData);
			
		} 
		
		
	} catch (SQLException sqle) {
		System.out.println("select문에서 예외 발생");
		sqle.printStackTrace();
	}
	
	return ModelListData;
	
}
	
static List<Map<String, Serializable>> selectModel() {
		
		quary = "SELECT MODEL_NM, MODEL_NUM, FIRST_CTGR, TOP_CLOTH_CTGR, BOT_CLOTH_CTGR, OUTER_CTGR, SHIR_CTGR, SHOOSE_CTGR"
				+ " FROM  MODEL full OUTER JOIN MODEL_CTGR ON Model.MODEL_CTGR_NUM = Model_CTGR.MODEL_CTGR_NUM";
		ModelListData.clear();
		
		try {
		
			pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();			
			while(rs.next()){
				
				ModeldataSet = new HashMap<String, Serializable>();
				
				ModeldataSet.put("MODEL_NM", rs.getString(1)); 
				ModeldataSet.put("MODEL_NUM", rs.getString(2)); 
				ModeldataSet.put("FIRST_CTGR", rs.getString(3)); 
				ModeldataSet.put("TOP_CLOTH_CTGR", rs.getString(4)); 
				ModeldataSet.put("BOT_CLOTH_CTGR", rs.getString(5)); 
				ModeldataSet.put("OUTER_CTGR", rs.getString(6)); 
				ModeldataSet.put("SHIR_CTGR", rs.getString(7)); 
				ModeldataSet.put("SHOOSE_CTGR", rs.getString(8)); 
				
//				ModeldataSet.put("FIRST_CTGR", rs.getString(2)); 


				ModelListData.add(ModeldataSet);
//				System.out.println(ModelListData);
				
			} 
			
			
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
		
		return ModelListData;
		
	}
	
	
static List<Map<String, Serializable>> selectModelNum1(String a, String b) {
		
		quary = "select MODEL_CTGR_NUM from model_ctgr where FIRST_CTGR = '" + a +"' and TOP_CLOTH_CTGR = '"+ b +"' ";
		ModelListData.clear();
		
		try {
		
			pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();			
			while(rs.next()){
				
				ModeldataSet = new HashMap<String, Serializable>();
				
				ModeldataSet.put("MODEL_CTGR_NUM", rs.getString(1)); 
//				ModeldataSet.put("FIRST_CTGR", rs.getString(2)); 


				ModelListData.add(ModeldataSet);
				System.out.println(ModelListData);
				
			} 
			
			
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
		
		return ModelListData;
		
	}

static List<Map<String, Serializable>> selectModelNum2(String a, String b) {
	
	quary = "select MODEL_CTGR_NUM from model_ctgr where FIRST_CTGR = '" + a +"' and BOT_CLOTH_CTGR = '"+ b +"' ";
	
	ModelListData.clear();
	
	try {
	
		pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
		rs = pstm.executeQuery();
		while(rs.next()){	
			ModeldataSet = new HashMap<String, Serializable>();
			
			ModeldataSet.put("MODEL_CTGR_NUM", rs.getString(1)); 

//			ModeldataSet.put("ADDR", rs.getString(9));

//			System.out.println(rs.getString(2));
			ModelListData.add(ModeldataSet);
			System.out.println(ModelListData);
			
		} 
		
		
	} catch (SQLException sqle) {
		System.out.println("select문에서 예외 발생");
		sqle.printStackTrace();
	}
	
	return ModelListData;
	
}

static List<Map<String, Serializable>> selectModelNum3(String a, String b) {
	
	quary = "select MODEL_CTGR_NUM from model_ctgr where FIRST_CTGR = '" + a +"' and OUTER_CTGR = '"+ b +"' ";
	
	ModelListData.clear();
	
	try {
	
		pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
		rs = pstm.executeQuery();			
		while(rs.next()){
			
			ModeldataSet = new HashMap<String, Serializable>();
			
			ModeldataSet.put("MODEL_CTGR_NUM", rs.getString(1)); 

//			ModeldataSet.put("ADDR", rs.getString(9));

//			System.out.println(rs.getString(2));
			ModelListData.add(ModeldataSet);
//			System.out.println(ModelListData);
			
		} 
		
		
	} catch (SQLException sqle) {
		System.out.println("select문에서 예외 발생");
		sqle.printStackTrace();
	}
	
	return ModelListData;
	
}

static List<Map<String, Serializable>> selectModelNum4(String a, String b) {
	
	quary = "select MODEL_CTGR_NUM from model_ctgr where FIRST_CTGR = '" + a +"' and SHIR_CTGR = '"+ b +"' ";
	
	ModelListData.clear();
	
	try {
	
		pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
		rs = pstm.executeQuery();			
		while(rs.next()){
			
			ModeldataSet = new HashMap<String, Serializable>();
			
			ModeldataSet.put("MODEL_CTGR_NUM", rs.getString(1)); 

//			ModeldataSet.put("ADDR", rs.getString(9));

//			System.out.println(rs.getString(2));
			ModelListData.add(ModeldataSet);
//			System.out.println(ModelListData);
			
		} 
		
		
	} catch (SQLException sqle) {
		System.out.println("select문에서 예외 발생");
		sqle.printStackTrace();
	}
	
	return ModelListData;
	
}

static List<Map<String, Serializable>> selectModelNum5(String a, String b) {
	
	quary = "select MODEL_CTGR_NUM from model_ctgr where FIRST_CTGR = '" + a +"' and SHOOSE_CTGR = '"+ b +"' ";
	
	ModelListData.clear();
	
	try {
	
		pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
		rs = pstm.executeQuery();			
		while(rs.next()){
			
			ModeldataSet = new HashMap<String, Serializable>();
			
			ModeldataSet.put("MODEL_CTGR_NUM", rs.getString(1)); 

//			ModeldataSet.put("ADDR", rs.getString(9));

//			System.out.println(rs.getString(2));
			ModelListData.add(ModeldataSet);
//			System.out.println(ModelListData);
			
		} 
		
		
	} catch (SQLException sqle) {
		System.out.println("select문에서 예외 발생");
		sqle.printStackTrace();
	}
	
	return ModelListData;
	}
}



