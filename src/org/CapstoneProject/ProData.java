
  
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



public class ProData {
	
	public static Connection conn = ConnectionDB.getConnection();
	static String quary;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;
	

	public static Map<String, Serializable > Prodata = new HashMap<String, Serializable>();
	
	public static Map<String, Serializable > ProdataSet;
	
	public static List<Map<String, Serializable>> ProListData = new ArrayList<Map<String, Serializable>>();
	
	/* 고객번호가 있는 링크 리스트 구성 */
	public static void initProData(String pro_NUM, String pro_CTGR_NUM, String pro_NM, String pro_EXP) {

	}
	
		
	/* 고객정보를 생성하는 질의어 */
	static void createPro(String Pro_num, String PRO_NM, String CLR, String SIZ, String SIZ_DET_INFO) {
		
		
		quary = "insert into pro values (SEQ_PRO_NUM.NEXTVAL, '"+Pro_num+"', '" +PRO_NM+ "', '" +CLR+ "', '"+SIZ+"', '"+SIZ_DET_INFO+")";
		
		
		System.out.println(quary);
		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

	}
	
static List<Map<String, Serializable>> selectPro() {
		
		quary = "select *from pro order by PRO_NM asc";
		
		ProListData.clear();
		
		try {
		System.out.println(quary);
			pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();			
			while(rs.next()){
				
				ProdataSet = new HashMap<String, Serializable>();
				
				ProdataSet.put("Pro_NM", rs.getString(1)); 
				ProdataSet.put("Pro_NUM", rs.getString(3));
				ProdataSet.put("SIZ", rs.getString(5));
				ProdataSet.put("CLR", rs.getString(4));

//				ProdataSet.put("FIRST_CTGR", rs.getString(2)); 


				ProListData.add(ProdataSet);
//				System.out.println(ProListData);
				
			} 
			
			
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
		
		return ProListData;
		
	}
	
static List<Map<String, Serializable>> searchPro1(String search) {
		
		quary = "select *from pro where PRO_NM like '%" + search + "%'";
		
		ProListData.clear();
		
		try {
		System.out.println(quary);
			pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();			
			while(rs.next()){
				
				ProdataSet = new HashMap<String, Serializable>();
				
				ProdataSet.put("Pro_NM", rs.getString(1)); 
				ProdataSet.put("Pro_NUM", rs.getString(3));
				ProdataSet.put("SIZ", rs.getString(5));
				ProdataSet.put("CLR", rs.getString(4));

				
//				ProdataSet.put("FIRST_CTGR", rs.getString(2)); 


				ProListData.add(ProdataSet);
//				System.out.println(ProListData);
				
			} 
			
			
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
		
		return ProListData;
		
	}

static List<Map<String, Serializable>> searchPro2(String search) {
	
		quary = "select * from pro where siz like '%" + search + "%'";
	
		ProListData.clear();
	
		try {
			System.out.println(quary);
			pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();			
			while(rs.next()){
			
				ProdataSet = new HashMap<String, Serializable>();
			
				ProdataSet.put("Pro_NM", rs.getString(1)); 
				ProdataSet.put("Pro_NUM", rs.getString(3));
				ProdataSet.put("SIZ", rs.getString(5));
				ProdataSet.put("CLR", rs.getString(4));

				ProListData.add(ProdataSet);
//				System.out.println(ProListData);
			
			} 
		
		
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
		return ProListData;
	}

static List<Map<String, Serializable>> searchPro3(String search) {
	
		quary = "select *from pro where clr like '%" + search + "%'";
	
		ProListData.clear();
	
		try {
			System.out.println(quary);
			pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();			
			while(rs.next()){
			
				ProdataSet = new HashMap<String, Serializable>();
			
				ProdataSet.put("Pro_NM", rs.getString(1)); 
				ProdataSet.put("Pro_NUM", rs.getString(3));
				ProdataSet.put("SIZ", rs.getString(5));
				ProdataSet.put("CLR", rs.getString(4));

			
//			ProdataSet.put("FIRST_CTGR", rs.getString(2)); 


				ProListData.add(ProdataSet);
//			System.out.println(ProListData);
			
			} 
		
		
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
	
		return ProListData;
	
	}

	static List<Map<String, Serializable>> selectProMod() {
		
		quary = "select MODEL_NM, PRO_NM, CLR, SIZ, up from pro join model on pro.MODEL_NUM = model.MODEL_NUM "
				+ "full outer join pro_up_rec on pro.pro_num = pro_up_rec.pro_num "
				+ "where APP_END_DT = '9999-12-31' or up is null order by PRO_NM asc";
	
	ProListData.clear();
	
	try {
	System.out.println(quary);
		pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
		rs = pstm.executeQuery();			
		while(rs.next()){
			
			ProdataSet = new HashMap<String, Serializable>();
			
			ProdataSet.put("MODEL_NM", rs.getString(1)); 
			ProdataSet.put("PRO_NM", rs.getString(2));
			ProdataSet.put("CLR", rs.getString(3));
			ProdataSet.put("SIZ", rs.getString(4));
			ProdataSet.put("up", rs.getString(5));
	
	//			ProdataSet.put("FIRST_CTGR", rs.getString(2)); 
	
	
			ProListData.add(ProdataSet);
	//			System.out.println(ProListData);
			
		} 
		
		
	} catch (SQLException sqle) {
		System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
		
		return ProListData;
		
	}
}

