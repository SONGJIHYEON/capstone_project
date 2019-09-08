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
   
   /* 고객번호가 있는 링크 리스트 구성 */
   public static void initCustData(String SNO, String NAME, String DET, String ADDR,
         String TEL) {
//      String sNM, sNUM, sID, sPWD, sBD, sADDR;
      custdata.put("A", SNO);
      custdata.put("A", NAME);
      custdata.put("A", DET);
      custdata.put("A", ADDR);
      custdata.put("A", TEL);
//      custdata.put("주소", sADDR);

   }
   
      
   /* 고객정보를 생성하는 질의어 */
   static void createCust
   
   () {
      quary = "INSERT INTO CUST(CUST_NUM, CUST_NM, PH_NUM, ID, PWD, BD, ADDR, CUST_TP) VALUES(103,'" + custdata.get("고객명") + "','" + custdata.get("휴대폰번호") + "','"
            + custdata.get("아이디") + "','" + custdata.get("비밀번호") + "','" + custdata.get("생년월일") + "','" + custdata.get("주소") + "','1')";
   System.out.println(quary);
      try {
         pstm = conn.prepareStatement(quary);
         pstm.executeQuery();
      } catch (SQLException sqle) {
         System.out.println("select문에서 예외 발생");
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
//            custdataSet.put("비밀번호", rs.getString(6));
//            custdataSet.put("생년월일", rs.getString(7));
//            custdataSet.put("주소", rs.getString(8));
//            custdataSet.put("고객등급", rs.getString(9));
//            custdataSet.put("보유포인트", rs.getString(10));
//            custdataSet.put("할인시작일", rs.getString(11));
//            custdataSet.put("할인종료일", rs.getString(12));
            
            System.out.println(custdataSet);
            custListData.add(custdataSet);
            
            
         } 
         
         
      } catch (SQLException sqle) {
         System.out.println("select문에서 예외 발생");
         sqle.printStackTrace();
      }
      
      return custListData;
      
   }
}


//CustData