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



public class corrData {
   
   public static Connection conn = ConnectionDB.getConnection();
   static String quary;
   static PreparedStatement pstm = null;
   static ResultSet rs = null;
   

   public static Map<String, Serializable > corrData = new HashMap<String, Serializable>();
   
   public static Map<String, Serializable > corrDataSet;
   
   public static List<Map<String, Serializable>> corrListData = new ArrayList<Map<String, Serializable>>();
   
   /* 고객번호가 있는 링크 리스트 구성 */
   public static void initcorrData(String BUS_NUM, String BUS_NM, String REP_NM, String BUS_TEL,
		   String ADDR) {

	   corrData.put("거래처번호", BUS_NUM);
	   corrData.put("거래처명", BUS_NM);
	   corrData.put("대표명", REP_NM);
	   corrData.put("연락처", BUS_TEL);
	   corrData.put("주소", ADDR);
	   

   }
   
   static void createcorr() {
		quary = "INSERT INTO CORR VALUES('"+ corrData.get("거래처번호") + "','" + corrData.get("거래처명") + "','" + corrData.get("대표명") + "','" + corrData.get("연락처") + "','" + corrData.get("주소") + "')";
	
		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

	}
   
   
static List<Map<String, Serializable>> selectcorr() {
      
      quary = "select * from CORR";
      
      corrListData.clear();
      
      try {
      
         pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
         rs = pstm.executeQuery();         
         while(rs.next()){
            
            corrDataSet = new HashMap<String, Serializable>();

            corrDataSet.put("BUS_NUM", rs.getString(1)); 
            corrDataSet.put("BUS_NM", rs.getString(2));
            corrDataSet.put("REP_NM", rs.getString(3));
            corrDataSet.put("BUS_TEL", rs.getString(4));
            corrDataSet.put("ADDR", rs.getString(5));
            
            
            //System.out.println(addrdataSet);
            corrListData.add(corrDataSet);
            
            
         } 
         
         
      } catch (SQLException sqle) {
         System.out.println("select문에서 예외 발생");
         sqle.printStackTrace();
      }
      
      return corrListData;
      
   }
//static List<Map<String, Serializable>> SearchAddr(String search) {
//   
//   quary = "select * from zipcode where addr like '%"+search+"%'";
//   
//   corrListData.clear();
//   
//   try {
//   
//      pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
//      rs = pstm.executeQuery();         
//      while(rs.next()){
//         
//         corrDataSet = new HashMap<String, Serializable>();
//
//         corrDataSet.put("ZIPCODE", rs.getString(1)); 
//         corrDataSet.put("SEQ", rs.getString(2));
//         corrDataSet.put("SIDO", rs.getString(3));
//         corrDataSet.put("GUGUN", rs.getString(4));
//         corrDataSet.put("DONG", rs.getString(5));
//         
//         //System.out.println(addrdataSet);
//         corrListData.add(corrDataSet);
//         
//         
//      } 
//      
//      
//   } catch (SQLException sqle) {
//      System.out.println("select문에서 예외 발생");
//      sqle.printStackTrace();
//   }
//   
//   return corrListData;
//   
//}
}




