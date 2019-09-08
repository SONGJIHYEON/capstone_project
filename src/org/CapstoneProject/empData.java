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



public class empData {
   
   public static Connection conn = ConnectionDB.getConnection();
   static String quary;
   static PreparedStatement pstm = null;
   static ResultSet rs = null;
   

   public static Map<String, Serializable > empData = new HashMap<String, Serializable>();
   
   public static Map<String, Serializable > empDataSet;
   
   public static List<Map<String, Serializable>> empListData = new ArrayList<Map<String, Serializable>>();
   
   /* ����ȣ�� �ִ� ��ũ ����Ʈ ���� */
   public static void initempData(String EMP_NO, String EMP_NM, String EMP_DT, String EMP_PH_NUM,
		   String EMP_TP, String EMP_ADDR, String REG_TP, String REG_ID, String REG_PW) {

	   empData.put("�����ȣ", EMP_NO);
	   empData.put("�����", EMP_NM);
	   empData.put("�Ի�����", EMP_DT);
	   empData.put("�޴�����ȣ", EMP_PH_NUM);
	   empData.put("����ּ�", EMP_ADDR);
	   empData.put("�������", EMP_TP);
	   empData.put("����������", REG_TP);
	   empData.put("���ID", REG_ID);
	   empData.put("�ʱ��й�ȣ", REG_PW);
	   
   }
   
   static void createemp() {
		quary = "INSERT INTO emp VALUES('"+ empData.get("�����ȣ") + "','" + empData.get("�����") + "','" + empData.get("�Ի�����") + "','" + empData.get("�޴�����ȣ") + "' ,'" + empData.get("����ּ�") + "', '" + empData.get("�������") + "', '" + empData.get("����������") + "', '" + empData.get("���ID") + "', '" + empData.get("�ʱ��й�ȣ") + "')";
	
		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select������ ���� �߻�");
			sqle.printStackTrace();
		}

	}
   
   
static List<Map<String, Serializable>> selectemp() {
      
      quary = "select * from emp";
      
      empListData.clear();
      
      try {
      
         pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
         rs = pstm.executeQuery();         
         while(rs.next()){
            
            empDataSet = new HashMap<String, Serializable>();

            empDataSet.put("EMP_NO", rs.getString(1)); 
            empDataSet.put("EMP_NM", rs.getString(2));
            empDataSet.put("EMP_DT", rs.getString(3));
            empDataSet.put("EMP_PH_NUM", rs.getString(4));
            empDataSet.put("EMP_ADDR", rs.getString(5));
            empDataSet.put("EMP_TP", rs.getString(6));
            empDataSet.put("REG_TP", rs.getString(7));
            empDataSet.put("REG_ID", rs.getString(8));
            empDataSet.put("REG_PW", rs.getString(9));
            
            //System.out.println(addrdataSet);
            empListData.add(empDataSet);
            
            
         } 
         
         
      } catch (SQLException sqle) {
         System.out.println("select������ ���� �߻�");
         sqle.printStackTrace();
      }
      
      return empListData;
      
   }
//static List<Map<String, Serializable>> SearchAddr(String search) {
//   
//   quary = "select * from zipcode where addr like '%"+search+"%'";
//   
//   empListData.clear();
//   
//   try {
//   
//      pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
//      rs = pstm.executeQuery();         
//      while(rs.next()){
//         
//         empDataSet = new HashMap<String, Serializable>();
//
//         empDataSet.put("ZIPCODE", rs.getString(1)); 
//         empDataSet.put("SEQ", rs.getString(2));
//         empDataSet.put("SIDO", rs.getString(3));
//         empDataSet.put("GUGUN", rs.getString(4));
//         empDataSet.put("DONG", rs.getString(5));
//         
//         //System.out.println(addrdataSet);
//         empListData.add(empDataSet);
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
//   return empListData;
//   
//}
}




