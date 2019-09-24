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

public class QnAData {

	public static Connection conn = ConnectionDB.getConnection();
	static String quary;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;

	public static Map<String, Serializable> QnAData = new HashMap<String, Serializable>();

	public static Map<String, Serializable> QnADataSet;

	public static List<Map<String, Serializable>> QnAListData = new ArrayList<Map<String, Serializable>>();

	/* QnA게시글이 있는 링크 리스트 구성 */
	public static void initQnAData( ) {

	}

	static void createQ(String Title, String content, String writer ) {
		quary = "INSERT INTO POST_MSG VALUES (SEQ_QPOST_NUM.NEXTVAL, 'QnA', '"+Title+"', to_char(sysdate, 'yyyy-mm-dd'), '"+content+"', "
				+ "  '문의', null, null, '"+writer+"')";

		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

	}

	static void createA(String POST_NUM, String Title, String content, String writer ) {
		quary = "INSERT INTO POST_MSG VALUES ('"+POST_NUM+"', 'QnA', '"+Title+"', to_char(sysdate, 'yyyy-mm-dd'), '"+content+"', "
				+ "  '문의', null, null, '"+writer+"')";
		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

	}
	
	static List<Map<String, Serializable>> selectQnA() {

		quary = " SELECT  POST_MSG_NUM, POST_MSG_TY, POST_MSG_TIT, WRITER_NM, WRT_DATE "
				+ "FROM  POST_MSG "
				+ "WHERE POST_BRD_TP = 'QnA' "
				+ "ORDER BY WRT_DATE ASC, POST_MSG_NUM ASC";

		QnAListData.clear();

		try {

			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				QnADataSet = new HashMap<String, Serializable>();

				QnADataSet.put("POST_MSG_NUM", rs.getString(1));
				QnADataSet.put("POST_MSG_TY", rs.getString(2));
				QnADataSet.put("POST_MSG_TIT", rs.getString(3));
				QnADataSet.put("WRITER_NM", rs.getString(4));
				QnADataSet.put("WRT_DATE", rs.getString(5));

				// System.out.println(addrdataSet);
				QnAListData.add(QnADataSet);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return QnAListData;

	}
	// QnA 상세정보
	static List<Map<String, Serializable>> searchQnA(String POST_NUM) {
			
			quary = "select POST_MSG_TIT, WRITER_NM, WRT_DATE, POST_MSG_CON "
					+ "FROM  POST_MSG "
					+ "where POST_MSG_NUM = '"+POST_NUM+"'";
			
			QnAListData.clear();
			
			try {
			System.out.println(quary);
				pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
				rs = pstm.executeQuery();			
				while(rs.next()){
					
					QnADataSet = new HashMap<String, Serializable>();
					
					QnADataSet.put("POST_MSG_TIT", rs.getString(1)); 
					QnADataSet.put("CUST_NM", rs.getString(2));
					QnADataSet.put("WRT_DATE", rs.getString(3));
					QnADataSet.put("POST_MSG_CON", rs.getString(4));
	
					QnAListData.add(QnADataSet);
					
				} 
				
				
			} catch (SQLException sqle) {
				System.out.println("select문에서 예외 발생");
				sqle.printStackTrace();
			}
			
			return QnAListData;
			
		}
	
	static List<Map<String, Serializable>> infoQ(String POST_NUM) {
		
		quary = "select POST_MSG_TIT, WRITER_NM, WRT_DATE, POST_MSG_CON "
				+ "FROM  POST_MSG "
				+ "where POST_MSG_NUM = '"+POST_NUM+"'";
		
		QnAListData.clear();
		
		try {
		System.out.println(quary);
			pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();			
			while(rs.next()){
				
				QnADataSet = new HashMap<String, Serializable>();
				
				QnADataSet.put("POST_MSG_TIT", rs.getString(1)); 
				QnADataSet.put("WRITER_NM", rs.getString(2));
				QnADataSet.put("WRT_DATE", rs.getString(3));
				QnADataSet.put("POST_MSG_CON", rs.getString(4));

				QnAListData.add(QnADataSet);
				
			} 
			
			
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
		
		return QnAListData;
		
	}

	

}