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



public class look_addr {
   
   public static Connection conn = ConnectionDB.getConnection();
   static String quary;
   static PreparedStatement pstm = null;
   static ResultSet rs = null;
   

   public static Map<String, Serializable > custdata = new HashMap<String, Serializable>();
   
   public static Map<String, Serializable > custdataSet;
   
   public static List<Map<String, Serializable>> custListData = new ArrayList<Map<String, Serializable>>();
   
   /* ����ȣ�� �ִ� ��ũ ����Ʈ ���� */
   public static void initCustData(String SNO, String NAME, String DET, String ADDR,
         String TEL) {
//      String sNM, sNUM, sID, sPWD, sBD, sADDR;
      custdata.put("A", SNO);
      custdata.put("A", NAME);
      custdata.put("A", DET);
      custdata.put("A", ADDR);
      custdata.put("A", TEL);
//      custdata.put("�ּ�", sADDR);

   }
   
      
   /* �������� �����ϴ� ���Ǿ� */
   static void createCust
   
   () {
      quary = "INSERT INTO CUST(CUST_NUM, CUST_NM, PH_NUM, ID, PWD, BD, ADDR, CUST_TP) VALUES(103,'" + custdata.get("����") + "','" + custdata.get("�޴�����ȣ") + "','"
            + custdata.get("���̵�") + "','" + custdata.get("��й�ȣ") + "','" + custdata.get("�������") + "','" + custdata.get("�ּ�") + "','1')";
   System.out.println(quary);
      try {
         pstm = conn.prepareStatement(quary);
         pstm.executeQuery();
      } catch (SQLException sqle) {
         System.out.println("select������ ���� �߻�");
         sqle.printStackTrace();
      }

   }
   
   
static List<Map<String, Serializable>> selectCust() {
      
      quary = "select * from STUDENT_DB";
      
//      custListData.clear();
      
      try {
      
         pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
         rs = pstm.executeQuery();         
         
         while(rs.next()){
            
            custdataSet = new HashMap<String, Serializable>();
            
            custdataSet.put("SNO", rs.getString(1)); 
            custdataSet.put("NAME", rs.getString(2));
            custdataSet.put("DET", rs.getString(3));
            custdataSet.put("ADDR", rs.getString(4));
            custdataSet.put("TEL", rs.getString(5));
//            custdataSet.put("��й�ȣ", rs.getString(6));
//            custdataSet.put("�������", rs.getString(7));
//            custdataSet.put("�ּ�", rs.getString(8));
//            custdataSet.put("�����", rs.getString(9));
//            custdataSet.put("��������Ʈ", rs.getString(10));
//            custdataSet.put("���ν�����", rs.getString(11));
//            custdataSet.put("����������", rs.getString(12));
            
            System.out.println(custdataSet);
            custListData.add(custdataSet);
            
            
         } 
         
         
      } catch (SQLException sqle) {
         System.out.println("select������ ���� �߻�");
         sqle.printStackTrace();
      }
      
      return custListData;
      
   }
}


//CustData