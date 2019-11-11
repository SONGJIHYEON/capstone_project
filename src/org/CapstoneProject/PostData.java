
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

public class PostData {

	public static Connection conn = ConnectionDB.getConnection();
	static String quary;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;

	public static Map<String, Serializable> PostData = new HashMap<String, Serializable>();

	public static Map<String, Serializable> PostDataSet;

	public static List<Map<String, Serializable>> PostListData = new ArrayList<Map<String, Serializable>>();

	/* QnA게시글이 있는 링크 리스트 구성 */
	public static void initQnAData() {

	}

	static List<Map<String, Serializable>> selectPost(String user_id) {

		quary = "select POST_BRD_TP, POST_MSG_TIT, POST_MSG_TY, WRT_DATE from post_msg "
				+ "join cust on post_msg.writer_nm = cust.cust_nm where id = '" + user_id + "'";

		PostListData.clear();

		try {

			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				PostDataSet = new HashMap<String, Serializable>();

				PostDataSet.put("POST_BRD_TP", rs.getString(1));
				PostDataSet.put("POST_MSG_TIT", rs.getString(2));
				PostDataSet.put("POST_MSG_TY", rs.getString(3));
				PostDataSet.put("WRT_DATE", rs.getString(4));
//				PostDataSet.put("WRT_DATE", rs.getString(5));

				// System.out.println(addrdataSet);
				PostListData.add(PostDataSet);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return PostListData;

	}

	// QnA 상세정보
//	static List<Map<String, Serializable>> searchQnA(String POST_NUM) {
//
//		quary = "select POST_MSG_TIT, WRITER_NM, WRT_DATE, POST_MSG_CON " + "FROM  POST_MSG " + "where POST_MSG_NUM = '"
//				+ POST_NUM + "'";
//
//		QnAListData.clear();
//
//		try {
//			System.out.println(quary);
//			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
//			rs = pstm.executeQuery();
//			while (rs.next()) {
//
//				QnADataSet = new HashMap<String, Serializable>();
//
//				QnADataSet.put("POST_MSG_TIT", rs.getString(1));
//				QnADataSet.put("CUST_NM", rs.getString(2));
//				QnADataSet.put("WRT_DATE", rs.getString(3));
//				QnADataSet.put("POST_MSG_CON", rs.getString(4));
//
//				QnAListData.add(QnADataSet);
//
//			}
//
//		} catch (SQLException sqle) {
//			System.out.println("select문에서 예외 발생");
//			sqle.printStackTrace();
//		}
//
//		return QnAListData;
//
//	}

//	static List<Map<String, Serializable>> infoQ(String POST_NUM) {
//
//		quary = "select POST_MSG_TIT, WRITER_NM, WRT_DATE, POST_MSG_CON FROM  POST_MSG " + "where POST_MSG_NUM = '"
//				+ POST_NUM + "'";
//
//		QnAListData.clear();
//
//		try {
//			System.out.println(quary);
//			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
//			rs = pstm.executeQuery();
//			while (rs.next()) {
//
//				QnADataSet = new HashMap<String, Serializable>();
//
//				QnADataSet.put("POST_MSG_TIT", rs.getString(1));
//				QnADataSet.put("WRITER_NM", rs.getString(2));
//				QnADataSet.put("WRT_DATE", rs.getString(3));
//				QnADataSet.put("POST_MSG_CON", rs.getString(4));
//
//				QnAListData.add(QnADataSet);
//
//			}
//
//		} catch (SQLException sqle) {
//			System.out.println("select문에서 예외 발생");
//			sqle.printStackTrace();
//		}
//
//		return QnAListData;
//
//	}
}