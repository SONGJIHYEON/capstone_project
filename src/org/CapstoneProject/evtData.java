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



public class evtData {
   
   public static Connection conn = ConnectionDB.getConnection();
   static String quary;
   static PreparedStatement pstm = null;
   static ResultSet rs = null;
   

   public static Map<String, Serializable > evtData = new HashMap<String, Serializable>();
   
   public static Map<String, Serializable > evtDataSet;
   
   public static List<Map<String, Serializable>> evtListData = new ArrayList<Map<String, Serializable>>();
   
   /* ����ȣ�� �ִ� ��ũ ����Ʈ ���� */
   public static void initevtData(String evt_NO, String evt_tp, String evt_st_dt, String evt_fn_dt, String evt_gift, int evt_point, int evt_sale) {

	   evtData.put("�̺�Ʈ��ȣ", evt_NO);
	   evtData.put("�̺�Ʈ����", evt_tp);
	   evtData.put("�̺�Ʈ��������", evt_st_dt);
	   evtData.put("�̺�Ʈ��������", evt_fn_dt);
	   evtData.put("������", evt_gift);
	   evtData.put("��������Ʈ", evt_point);
	   evtData.put("������", evt_sale);
	   
	   
   }
   
   static void createevt() {
		quary = "INSERT INTO evt VALUES('"+ evtData.get("�̺�Ʈ��ȣ") + "','" + evtData.get("�̺�Ʈ����") + "','" + evtData.get("�̺�Ʈ��������") + "','" + evtData.get("�̺�Ʈ��������") + "','" + evtData.get("������") + "'," + evtData.get("��������Ʈ") + "," + evtData.get("������") + ")";
	
		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select������ ���� �߻�");
			sqle.printStackTrace();
		}

	}
   
   
static List<Map<String, Serializable>> selectevt() {
      
      quary = "select * from evt";
      
      evtListData.clear();
      
      try {
      
         pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
         rs = pstm.executeQuery();         
         while(rs.next()){
            
            evtDataSet = new HashMap<String, Serializable>();

            evtDataSet.put("evt_NO", rs.getString(1)); 
            evtDataSet.put("evt_tp", rs.getString(2));
            evtDataSet.put("evt_st_dt", rs.getString(3));
            evtDataSet.put("evt_fn_dt", rs.getString(4));
            evtDataSet.put("evt_gift", rs.getString(5));
            evtDataSet.put("evt_point", rs.getInt(6));
            evtDataSet.put("evt_sale", rs.getInt(7));
            
            //System.out.println(addrdataSet);
            evtListData.add(evtDataSet);
            
            
         } 
         
         
      } catch (SQLException sqle) {
         System.out.println("select������ ���� �߻�");
         sqle.printStackTrace();
      }
      
      return evtListData;
      
   }
//static List<Map<String, Serializable>> SearchAddr(String search) {
//   
//   quary = "select * from zipcode where addr like '%"+search+"%'";
//   
//   evtListData.clear();
//   
//   try {
//   
//      pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
//      rs = pstm.executeQuery();         
//      while(rs.next()){
//         
//         evtDataSet = new HashMap<String, Serializable>();
//
//         evtDataSet.put("ZIPCODE", rs.getString(1)); 
//         evtDataSet.put("SEQ", rs.getString(2));
//         evtDataSet.put("SIDO", rs.getString(3));
//         evtDataSet.put("GUGUN", rs.getString(4));
//         evtDataSet.put("DONG", rs.getString(5));
//         
//         //System.out.println(addrdataSet);
//         evtListData.add(evtDataSet);
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
//   return evtListData;
//   
//}
}




