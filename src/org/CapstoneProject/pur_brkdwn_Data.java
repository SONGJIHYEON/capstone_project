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
   static String quary;
   static PreparedStatement pstm = null;
   static ResultSet rs = null;
   

   public static Map<String, Serializable > pur_brkdwn_Data = new HashMap<String, Serializable>();
   
   public static Map<String, Serializable > pur_brkdwn_DataSet;
   
   public static List<Map<String, Serializable>> pur_brkdwnListData = new ArrayList<Map<String, Serializable>>();
   
   /* 고객번호가 있는 링크 리스트 구성 */
   public static void initpur_brkdwn_Data(String PUR_NUM, String BRKDWN_NUM, String PRO_NUM, int PUR_QUANT, int PUR_UP, int PR) {

	   pur_brkdwn_Data.put("구매번호", PUR_NUM);
	   pur_brkdwn_Data.put("내역번호", BRKDWN_NUM);
	   pur_brkdwn_Data.put("상품번호", PRO_NUM);
	   pur_brkdwn_Data.put("구매수량", PUR_QUANT);
	   pur_brkdwn_Data.put("구매단가", PUR_UP);
	   pur_brkdwn_Data.put("금액", PR);

   }
   
   static void createpur_brkdwn_Data() {
		quary = "INSERT INTO PUR VALUES('"+ pur_brkdwn_Data.get("구매번호") + "','"+ pur_brkdwn_Data.get("내역번호") + "',"
				+ " '"+ pur_brkdwn_Data.get("상품번호") + "' ," + pur_brkdwn_Data.get("구매수량") + ", " + pur_brkdwn_Data.get("구매단가") + ", " + pur_brkdwn_Data.get("금액") + ")";
	
		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

	}
   
   
static List<Map<String, Serializable>> selectpur_brkdwn_Data () {
      
      quary = "select * from pur";
      
      pur_brkdwnListData.clear();
      
      try {
      
         pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
         rs = pstm.executeQuery();         
         while(rs.next()){
            
            pur_brkdwn_Data = new HashMap<String, Serializable>();

            pur_brkdwn_Data.put("PUR_NUM", rs.getString(1)); 
            pur_brkdwn_Data.put("BRKDWN_NUM", rs.getString(2));
            pur_brkdwn_Data.put("PRO_NUM", rs.getString(3));
            pur_brkdwn_Data.put("PUR_QUANT", rs.getInt(4));
            pur_brkdwn_Data.put("PUR_UP", rs.getInt(4));
            pur_brkdwn_Data.put("PR", rs.getInt(4));
            
            
            //System.out.println(addrdataSet);
            pur_brkdwnListData.add(pur_brkdwn_Data);
            
            
         } 
         
         
      } catch (SQLException sqle) {
         System.out.println("select문에서 예외 발생");
         sqle.printStackTrace();
      }
      
      return pur_brkdwnListData;
      
   }

}




