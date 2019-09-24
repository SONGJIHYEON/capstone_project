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



public class pur_brkdwn_Data {
   
   public static Connection conn = ConnectionDB.getConnection();
   static String quary, quary_commit;
   static PreparedStatement pstm = null;
   static ResultSet rs = null;
   

   public static Map<String, Serializable > pur_brkdwn_Data = new HashMap<String, Serializable>();
   
   public static Map<String, Serializable > pur_brkdwn_DataSet;
   
   public static List<Map<String, Serializable>> pur_brkdwnListData = new ArrayList<Map<String, Serializable>>();
   
   /* ����ȣ�� �ִ� ��ũ ����Ʈ ���� */
   public static void initpur_brkdwn_Data(String PUR_NUM, String PRO_NUM, int PUR_QUANT, int PUR_UP, int PR) {

      pur_brkdwn_Data.put("���Ź�ȣ", PUR_NUM);
      pur_brkdwn_Data.put("��ǰ��ȣ", PRO_NUM);
      pur_brkdwn_Data.put("���ż���", PUR_QUANT);
      pur_brkdwn_Data.put("���Ŵܰ�", PUR_UP);
      pur_brkdwn_Data.put("�ݾ�", PR);

   }
   
   static void createpur_brkdwn_Data() {
      quary = "INSERT INTO PUR_BRKDWN VALUES('"+ pur_brkdwn_Data.get("���Ź�ȣ") + "', SEQ_PUR_BRKDWN_NUM.NEXTVAL ,"
            + " '"+ pur_brkdwn_Data.get("��ǰ��ȣ") + "' ," + pur_brkdwn_Data.get("���ż���") + ", " + pur_brkdwn_Data.get("���Ŵܰ�") + ", " + pur_brkdwn_Data.get("�ݾ�") + ")";
   
      quary_commit = "commit";
      try {
         pstm = conn.prepareStatement(quary);
         pstm.executeQuery();
      } catch (SQLException sqle) {
         System.out.println("select������ ���� �߻�");
         sqle.printStackTrace();
      }
      try {
         pstm = conn.prepareStatement(quary_commit);
         pstm.executeQuery();
      } catch (SQLException sqle) {
         System.out.println("select������ ���� �߻�");
         sqle.printStackTrace();
      }


   }

   
   
static List<Map<String, Serializable>> selectpur_brkdwn_Data (String pur_num) {
      
      quary = "SELECT BRKDWN_NUM, PRO_NM, PUR_QUANT, PUR_UP, PR "
            + "FROM  pur_brkdwn JOIN pro ON pur_brkdwn.PRO_NUM = pro.PRO_NUM WHERE pur_num = " + pur_num;
      
      pur_brkdwnListData.clear();
      
      System.out.println(pur_num);
      try {
      
         pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
         rs = pstm.executeQuery();         
         while(rs.next()){
            
            pur_brkdwn_Data = new HashMap<String, Serializable>();

            pur_brkdwn_Data.put("BRKDWN_NUM", rs.getString(1));
            pur_brkdwn_Data.put("PRO_NM", rs.getString(2));
            pur_brkdwn_Data.put("PUR_QUANT", rs.getInt(3));
            pur_brkdwn_Data.put("PUR_UP", rs.getInt(4));
            pur_brkdwn_Data.put("PR", rs.getInt(5));
            
            
            //System.out.println(addrdataSet);
            pur_brkdwnListData.add(pur_brkdwn_Data);
            
            
         } 
         
         
      } catch (SQLException sqle) {
         System.out.println("select������ ���� �߻�");
         sqle.printStackTrace();
      }
      
      return pur_brkdwnListData;
      
   }

}



