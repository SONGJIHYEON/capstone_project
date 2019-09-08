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
   
   /* ����ȣ�� �ִ� ��ũ ����Ʈ ���� */
   public static void initcorrData(String BUS_NUM, String BUS_NM, String REP_NM, String BUS_TEL,
		   String ADDR) {

	   corrData.put("�ŷ�ó��ȣ", BUS_NUM);
	   corrData.put("�ŷ�ó��", BUS_NM);
	   corrData.put("��ǥ��", REP_NM);
	   corrData.put("����ó", BUS_TEL);
	   corrData.put("�ּ�", ADDR);
	   

   }
   
   static void createcorr() {
		quary = "INSERT INTO CORR VALUES('"+ corrData.get("�ŷ�ó��ȣ") + "','" + corrData.get("�ŷ�ó��") + "','" + corrData.get("��ǥ��") + "','" + corrData.get("����ó") + "','" + corrData.get("�ּ�") + "')";
	
		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select������ ���� �߻�");
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
         System.out.println("select������ ���� �߻�");
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
//      System.out.println("select������ ���� �߻�");
//      sqle.printStackTrace();
//   }
//   
//   return corrListData;
//   
//}
}




