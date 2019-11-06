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



public class purData {
   
   public static Connection conn = ConnectionDB.getConnection();
   static String quary,quary_SEQ, quary_commit;
   static PreparedStatement pstm = null;
   static ResultSet rs = null;
   

   public static Map<String, Serializable > purData = new HashMap<String, Serializable>();
   
   public static Map<String, Serializable > purDataSet;
   
   public static List<Map<String, Serializable>> purListData = new ArrayList<Map<String, Serializable>>();
   
   /* 고객번호가 있는 링크 리스트 구성 */
   public static void initpurData(String CORR_NUM, String PUR_DT, int TOT_PR) {
	   
	   purData.put("거래처번호", CORR_NUM);
	   purData.put("구매일자", PUR_DT);
	   purData.put("총금액", TOT_PR);

   }
   
   static void createpur() {
	   
		quary = "INSERT INTO PUR VALUES(SEQ_PUR_NUM.NEXTVAL,'"+ purData.get("거래처번호") + "', '"+ purData.get("구매일자") + "' ," + purData.get("총금액") + ")";
	    purListData.clear();
		quary_commit = "commit";
		
		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
		try {
			pstm = conn.prepareStatement(quary_commit);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

	}
   
    static List<Map<String, Serializable>> searchSEQ() {
	   
	   quary = "SELECT PUR_NUM FROM PUR ORDER BY PUR_NUM DESC";
	   
	   try {
		      
	         pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
	         rs = pstm.executeQuery();         
	         while(rs.next()){
	            
	            purDataSet = new HashMap<String, Serializable>();

	            purDataSet.put("PUR_NUM", rs.getString(1));
	            
	            //System.out.println(addrdataSet);
	            purListData.add(purDataSet);
	            
	            
	         } 
	         
	         
	      } catch (SQLException sqle) {
	         System.out.println("select문에서 예외 발생");
	         sqle.printStackTrace();
	      }
	   
	   quary = "commit";
	   
	   try {
	         pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
	         rs = pstm.executeQuery();    
	      } catch (SQLException sqle) {
	         System.out.println("select문에서 예외 발생");
	         sqle.printStackTrace();
	      }
	   return purListData;
	 }
   
   
   static void createSEQ(String PUR_NUM) {
		quary = "create SEQUENCE SEQ_PUR_BRKDWN_"+PUR_NUM+" START WITH 1 INCREMENT BY 1 MAXVALUE 1000000000";
		quary_commit = "commit";
		
		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
		try {
			pstm = conn.prepareStatement(quary_commit);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

	}
   
   
static List<Map<String, Serializable>> selectpur(String corr_num) {
      
      quary = "select * from pur where BUS_NUM ='" + corr_num +"'";
      
      purListData.clear();
      
      try {
      
         pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
         rs = pstm.executeQuery();         
         while(rs.next()){
            
            purDataSet = new HashMap<String, Serializable>();

            purDataSet.put("PUR_NUM", rs.getString(1)); 
            purDataSet.put("BUS_NUM", rs.getString(2));
            purDataSet.put("PUR_DT", rs.getString(3));
            purDataSet.put("TOT_PR", rs.getString(4));
            
            
            //System.out.println(addrdataSet);
            purListData.add(purDataSet);
            
            
         } 
         
         
      } catch (SQLException sqle) {
         System.out.println("select문에서 예외 발생");
         sqle.printStackTrace();
      }
      
      return purListData;
      
   }

}