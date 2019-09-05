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



public class RegProData {
	
	public static Connection conn = ConnectionDB.getConnection();
	static String quary;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;
	

	public static Map<String, Serializable > prodata = new HashMap<String, Serializable>();
	
	public static Map<String, Serializable > prodataSet;
	
	public static List<Map<String, Serializable>> proListData = new ArrayList<Map<String, Serializable>>();
	
	/* 고객번호가 있는 링크 리스트 구성 */
	public static void initproData(String pro_NUM, String pro_CTGR_NUM, String pro_NM, String pro_EXP) {

		prodata.put("모델번호", pro_NUM);
		prodata.put("모델분류번호", pro_CTGR_NUM);
		prodata.put("모델이름", pro_NM);
		prodata.put("모델상세정보", pro_EXP);
		prodata.put("모델상세정보", pro_EXP);
		prodata.put("모델상세정보", pro_EXP);
	}
	
		
	/* 고객정보를 생성하는 질의어 */
	static void createpro(String model_num, String PRO_NM, String CLR, String SIZ, String SIZ_DET_INFO) {
		
		
		quary = "insert into pro values (SEQ_PRO_NUM.NEXTVAL, '"+model_num+"', '" +PRO_NM+ "', '" +CLR+ "', '"+SIZ+"', "
				+ "'"+SIZ_DET_INFO+"')";
		
		
		System.out.println(quary);
		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

	}
}



