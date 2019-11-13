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

public class Od_brkdwn_Data {

	public static Connection conn = ConnectionDB.getConnection();
	static String quary, quary_commit;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;

	public static Map<String, Serializable> od_brkdwn_Data = new HashMap<String, Serializable>();

	public static Map<String, Serializable> od_brkdwn_DataSet;

	public static List<Map<String, Serializable>> od_brkdwnListData = new ArrayList<Map<String, Serializable>>();

	/* 고객번호가 있는 링크 리스트 구성 */
//	public static void initpur_brkdwn_Data(String PUR_NUM, String PRO_NUM, int PUR_QUANT, int PUR_UP, int PR) {
//
//		pur_brkdwn_Data.put("구매번호", PUR_NUM);
//		pur_brkdwn_Data.put("상품번호", PRO_NUM);
//		pur_brkdwn_Data.put("구매수량", PUR_QUANT);
//		pur_brkdwn_Data.put("구매단가", PUR_UP);
//		pur_brkdwn_Data.put("금액", PR);
//
//	}

//	static void createpur_brkdwn_Data() {
//		quary = "INSERT INTO PUR_BRKDWN VALUES('" + pur_brkdwn_Data.get("구매번호") + "', SEQ_PUR_BRKDWN_NUM.NEXTVAL ,"
//				+ " '" + pur_brkdwn_Data.get("상품번호") + "' ," + pur_brkdwn_Data.get("구매수량") + ", "
//				+ pur_brkdwn_Data.get("구매단가") + ", " + pur_brkdwn_Data.get("금액") + ")";
//
//		quary_commit = "commit";
//		try {
//			pstm = conn.prepareStatement(quary);
//			pstm.executeQuery();
//		} catch (SQLException sqle) {
//			System.out.println("select문에서 예외 발생");
//			sqle.printStackTrace();
//		}
//		try {
//			pstm = conn.prepareStatement(quary_commit);
//			pstm.executeQuery();
//		} catch (SQLException sqle) {
//			System.out.println("select문에서 예외 발생");
//			sqle.printStackTrace();
//		}
//
//	}

	static List<Map<String, Serializable>> selectOd_brkdwn_user(String od_num) {

		quary = "select OD_NUM, PRO_NM, QUANT, UP, PR from od_brkdwn join pro on od_brkdwn.pro_num = pro.pro_num "
				+ "where od_num = '"+od_num+"'";

		od_brkdwnListData.clear();

//		System.out.println(pur_num);
		try {

			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				od_brkdwn_Data = new HashMap<String, Serializable>();

				od_brkdwn_Data.put("OD_NUM", rs.getString(1));
				od_brkdwn_Data.put("PRO_NM", rs.getString(2));
				od_brkdwn_Data.put("QUANT", rs.getInt(3));
				od_brkdwn_Data.put("UP", rs.getInt(4));
				od_brkdwn_Data.put("PR", rs.getInt(5));

				// System.out.println(addrdataSet);
				od_brkdwnListData.add(od_brkdwn_Data);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return od_brkdwnListData;

	}
	
	static List<Map<String, Serializable>> selectOd_brkdwn_admin(String od_num) {

		quary = "select OD_NUM, PRO_NM, QUANT, UP, PR from od_brkdwn join pro on od_brkdwn.pro_num = pro.pro_num "
				+ "where od_num = '"+od_num+"'";

		od_brkdwnListData.clear();

//		System.out.println(pur_num);
		try {

			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				od_brkdwn_Data = new HashMap<String, Serializable>();

				od_brkdwn_Data.put("OD_NUM", rs.getString(1));
				od_brkdwn_Data.put("PRO_NM", rs.getString(2));
				od_brkdwn_Data.put("QUANT", rs.getInt(3));
				od_brkdwn_Data.put("UP", rs.getInt(4));
				od_brkdwn_Data.put("PR", rs.getInt(5));

				// System.out.println(addrdataSet);
				od_brkdwnListData.add(od_brkdwn_Data);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return od_brkdwnListData;

	}

}
