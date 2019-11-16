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

public class ReviewData {

	public static Connection conn = ConnectionDB.getConnection();
	static String quary;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;

	public static Map<String, Serializable> ReviewData = new HashMap<String, Serializable>();

	public static Map<String, Serializable> ReviewDataSet;

	public static List<Map<String, Serializable>> ReviewListData = new ArrayList<Map<String, Serializable>>();

	/* Review게시글이 있는 링크 리스트 구성 */
	public static void initReviewData( ) {

	}

	static void createR(String Title, String content, String od_num, String pro_num, String writer, String point ) {
		quary = "INSERT INTO POST_MSG VALUES (SEQ_RPOST_NUM.NEXTVAL, '상품후기', '"+Title+"', to_char(sysdate, 'yyyy-mm-dd'), '"+content+"', "
				+ "  null, '"+od_num+"', '"+pro_num+"', '"+writer+"', '"+point+"')";

		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

	}
	
	static List<Map<String, Serializable>> searchpronum()  {
		quary = "select pro_num from pro where pro_nm = '"+Review_write.pro_nm+"'";
		ReviewListData.clear();
		
		try {
			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ReviewDataSet = new HashMap<String, Serializable>();
				ReviewDataSet.put("pro_num", rs.getString(1));
				ReviewListData.add(ReviewDataSet);
			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
		return ReviewListData;
	}
	
	
	static List<Map<String, Serializable>> selectReview() {

		quary = " SELECT  POST_MSG_NUM, POST_MSG_TY, POST_MSG_TIT, WRITER_NM, WRT_DATE "
				+ "FROM  POST_MSG "
				+ "WHERE POST_BRD_TP = '상품후기' "
				+ "ORDER BY WRT_DATE ASC, POST_MSG_NUM ASC";

		ReviewListData.clear();

		try {

			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ReviewDataSet = new HashMap<String, Serializable>();

				ReviewDataSet.put("POST_MSG_NUM", rs.getString(1));
				ReviewDataSet.put("POST_MSG_TY", rs.getString(2));
				ReviewDataSet.put("POST_MSG_TIT", rs.getString(3));
				ReviewDataSet.put("WRITER_NM", rs.getString(4));
				ReviewDataSet.put("WRT_DATE", rs.getString(5));

				// System.out.println(addrdataSet);
				ReviewListData.add(ReviewDataSet);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return ReviewListData;

	}
	// Review 상세정보
	static List<Map<String, Serializable>> searchReview(String POST_NUM) {
			
			quary = "select POST_MSG_TIT, WRITER_NM, WRT_DATE, POST_MSG_CON "
					+ "FROM  POST_MSG "
					+ "where POST_MSG_NUM = '"+POST_NUM+"'";
			
			ReviewListData.clear();
			
			try {
			System.out.println(quary);
				pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
				rs = pstm.executeQuery();			
				while(rs.next()){
					
					ReviewDataSet = new HashMap<String, Serializable>();
					
					ReviewDataSet.put("POST_MSG_TIT", rs.getString(1)); 
					ReviewDataSet.put("CUST_NM", rs.getString(2));
					ReviewDataSet.put("WRT_DATE", rs.getString(3));
					ReviewDataSet.put("POST_MSG_CON", rs.getString(4));
	
					ReviewListData.add(ReviewDataSet);
					
				} 
				
				
			} catch (SQLException sqle) {
				System.out.println("select문에서 예외 발생");
				sqle.printStackTrace();
			}
			
			return ReviewListData;
			
		}
	
	static List<Map<String, Serializable>> infoR(String POST_NUM) {
		
		quary = "select POST_MSG_TIT, WRITER_NM, WRT_DATE, POST_MSG_CON , PRO_REVIEW, PRO_NM "
				+ "FROM  POST_MSG, PRO "
				+ "where POST_MSG.PRO_NUM = PRO.PRO_NUM and "
				+ "POST_BRD_TP = '상품후기' and POST_MSG_NUM = " + POST_NUM ;
		
		ReviewListData.clear();
		
		try {
		System.out.println(quary);
			pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();			
			while(rs.next()){
				
				ReviewDataSet = new HashMap<String, Serializable>();
				
				ReviewDataSet.put("POST_MSG_TIT", rs.getString(1)); 
				ReviewDataSet.put("WRITER_NM", rs.getString(2)); 
				ReviewDataSet.put("WRT_DATE", rs.getString(3));
				ReviewDataSet.put("POST_MSG_CON", rs.getString(4));
				ReviewDataSet.put("PRO_REVIEW", rs.getString(5));
				ReviewDataSet.put("PRO_NM", rs.getString(6));

				ReviewListData.add(ReviewDataSet);
				
			} 
			
			
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
		
		return ReviewListData;
		
	}

	

}