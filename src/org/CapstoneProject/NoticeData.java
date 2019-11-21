
  
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

public class NoticeData {

	public static Connection conn = ConnectionDB.getConnection();
	static String quary, quary2;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;

	public static Map<String, Serializable> NoticeData = new HashMap<String, Serializable>();

	public static Map<String, Serializable> NoticeDataSet;

	public static List<Map<String, Serializable>> NoticeListData = new ArrayList<Map<String, Serializable>>();

	/* Notice게시글이 있는 링크 리스트 구성 */
	public static void initNoticeData( ) {

	}

	static void createN(String Title, String content, String writer ) {
		quary = "INSERT INTO POST_MSG VALUES (SEQ_NPOST_NUM.NEXTVAL, '공지사항', '"+Title+"', to_char(sysdate, 'yyyy-mm-dd'), '"+content+"', "
				+ " null, null, null, '"+writer+"' , null)";

		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

	}

	static void updateN(String Title, String content, String POST_NUM) {
		quary = "UPDATE POST_MSG " 
				+ "SET POST_MSG_TIT='"+Title+"',WRT_DATE=to_char(sysdate, 'yyyy-mm-dd'),POST_MSG_CON='"+content+"' "
				+ "WHERE POST_MSG_NUM='"+Title+"' ";
		
		quary2 = "commit";

		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
		
		try {
			pstm = conn.prepareStatement(quary2);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

	}
	
	static List<Map<String, Serializable>> selectNotice() {

		quary = " SELECT  POST_MSG_NUM, POST_MSG_TIT,WRITER_NM, WRT_DATE "
				+ "FROM  POST_MSG "
				+ "WHERE POST_BRD_TP = '공지사항' "
				+ "ORDER BY WRT_DATE ASC";

		NoticeListData.clear();

		try {

			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				NoticeDataSet = new HashMap<String, Serializable>();

				NoticeDataSet.put("POST_MSG_NUM", rs.getString(1));
				NoticeDataSet.put("POST_MSG_TIT", rs.getString(2));
				NoticeDataSet.put("WRITER_NM", rs.getString(3));
				NoticeDataSet.put("WRT_DATE", rs.getString(4));

				// System.out.println(addrdataSet);
				NoticeListData.add(NoticeDataSet);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return NoticeListData;

	}
	// Notice 상세정보
	static List<Map<String, Serializable>> searchNotice(String POST_NUM) {
			
			quary = "select POST_MSG_TIT, CUST_NM, WRT_DATE, POST_MSG_CON "
					+ "FROM  POST_MSG "
					+ "JOIN CUST ON POST_MSG.USER_NUM = CUST.CUST_NUM "
					+ "where POST_MSG_NUM = " + POST_NUM ;
			
			NoticeListData.clear();
			
			try {
			System.out.println(quary);
				pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
				rs = pstm.executeQuery();			
				while(rs.next()){
					
					NoticeDataSet = new HashMap<String, Serializable>();
					
					NoticeDataSet.put("POST_MSG_TIT", rs.getString(1)); 
					NoticeDataSet.put("CUST_NM", rs.getString(2));
					NoticeDataSet.put("WRT_DATE", rs.getString(3));
					NoticeDataSet.put("POST_MSG_CON", rs.getString(4));
	
					NoticeListData.add(NoticeDataSet);
					
				} 
				
				
			} catch (SQLException sqle) {
				System.out.println("select문에서 예외 발생");
				sqle.printStackTrace();
			}
			
			return NoticeListData;
			
		}
	
	static List<Map<String, Serializable>> infoN(String POST_NUM) {
		
		quary = "select POST_MSG_TIT, WRITER_NM, WRT_DATE, POST_MSG_CON "
				+ "FROM  POST_MSG "
				+ "where POST_BRD_TP = '공지사항' and POST_MSG_NUM = " + POST_NUM ;
		
		NoticeListData.clear();
		
		try {
		System.out.println(quary);
			pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();			
			while(rs.next()){
				
				NoticeDataSet = new HashMap<String, Serializable>();
				
				NoticeDataSet.put("POST_MSG_TIT", rs.getString(1)); 
				NoticeDataSet.put("WRITER_NM", rs.getString(2));
				NoticeDataSet.put("WRT_DATE", rs.getString(3));
				NoticeDataSet.put("POST_MSG_CON", rs.getString(4));

				NoticeListData.add(NoticeDataSet);
				
			} 
			
			
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
		
		return NoticeListData;
		
	}

	

}
