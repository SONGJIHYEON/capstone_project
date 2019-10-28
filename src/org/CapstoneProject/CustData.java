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

public class CustData {

	public static Connection conn = ConnectionDB.getConnection();
	static String quary;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;

	public static Map<String, Serializable> custdata = new HashMap<String, Serializable>();

	public static Map<String, Serializable> custdataSet;

	public static List<Map<String, Serializable>> custListData = new ArrayList<Map<String, Serializable>>();

	/* 고객번호가 있는 링크 리스트 구성 */
	public static void initCustData(String ID, String PWD, String CUST_NM, String BD, String PH_NUM, String ADDR) {

		custdata.put("아이디", ID);
		custdata.put("비밀번호", PWD);
		custdata.put("이름", CUST_NM);
		custdata.put("생년월일", BD);
		custdata.put("휴대폰번호", PH_NUM);
		custdata.put("주소", ADDR);
//		custdata.put("할인율시작일자", newstring);
//		custdata.put("A", TEL);
//		custdata.put("A", TEL);
//		custdata.put("주소", scust);

	}

	/* 고객정보를 생성하는 질의어 */
	static void createCust() {
		quary = "INSERT INTO CUST(CUST_NUM, CUST_NM, PH_NUM, CUST_TP, ID, PWD, BD, POSS_PNT, ADDR, GRA_TP) "
				+ "VALUES(SEQ_CUST_NUM.NEXTVAL, '" + custdata.get("이름") + "', '" + custdata.get("휴대폰번호") + "', '회원', '"
				+ custdata.get("아이디") + "', " + " '" + custdata.get("비밀번호") + "', to_date('" + custdata.get("생년월일")
				+ "', 'YYYY-MM-DD'), 0, '" + custdata.get("주소") + "', 'F')";
		
		custListData.clear();

		System.out.println(quary);
		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

	}


	static void initCustData2(String NONNM, String NONPH) {

		custdata.put("이름", NONNM);
		custdata.put("휴대폰번호", NONPH);

	}

	/* 고객정보를 생성하는 질의어 */
	static void createCust2() {
		quary = "INSERT INTO CUST(CUST_NUM, CUST_NM, PH_NUM, CUST_TP, ID, PWD, BD, ADDR, MB_GRA, POSS_PNT, DISC_APP_ST_DT, DISC_APP_END_DT) "
				+ "VALUES(SEQ_CUST_NUM.NEXTVAL, '" + custdata.get("이름") + "', '" + custdata.get("휴대폰번호")
				+ "', '비회원', '', '', '', '', '', '', '', '')";

		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

	}
	
	static void changeCust(String PWD, String BD, String PH_NUM, String ADDR, String ID) {
		quary = "update cust set PH_NUM = " + PH_NUM + ", PWD = '" + PWD + "', BD = to_date('" + BD + "', 'YYYY-MM-DD'), "
				+ "ADDR = '" + ADDR +"' where id = '" + ID +"'";

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

		quary = "select ID, CUST_NM, PH_NUM, ADDR, MB_GRA, POSS_PNT from cust where CUST_TP = '회원' ";

		custListData.clear();

		try {

			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				custdataSet = new HashMap<String, Serializable>();

				custdataSet.put("ID", rs.getString(1));
				custdataSet.put("CUST_NM", rs.getString(2));
				custdataSet.put("PH_NUM", rs.getString(3));
				custdataSet.put("ADDR", rs.getString(4));
				custdataSet.put("MB_GRA", rs.getString(5));
				custdataSet.put("POSS_PNT", rs.getString(6));

				// System.out.println(addrdataSet);
				custListData.add(custdataSet);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return custListData;

	}
	
	static List<Map<String, Serializable>> searchCust1(String search) {

		quary = "select ID, CUST_NM, PH_NUM, ADDR, MB_GRA, POSS_PNT from cust where CUST_TP = '회원' and ID like '%" + search + "%' ";

		custListData.clear();

		try {

			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				custdataSet = new HashMap<String, Serializable>();

				custdataSet.put("ID", rs.getString(1));
				custdataSet.put("CUST_NM", rs.getString(2));
				custdataSet.put("PH_NUM", rs.getString(3));
				custdataSet.put("ADDR", rs.getString(4));
				custdataSet.put("MB_GRA", rs.getString(5));
				custdataSet.put("POSS_PNT", rs.getString(6));

				// System.out.println(addrdataSet);
				custListData.add(custdataSet);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return custListData;

	}
	
	static List<Map<String, Serializable>> searchCust2(String search) {

		quary = "select ID, CUST_NM, PH_NUM, ADDR, MB_GRA, POSS_PNT from cust where CUST_TP = '회원' and CUST_NM like '%" + search + "%'";

		custListData.clear();

		try {

			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				custdataSet = new HashMap<String, Serializable>();

				custdataSet.put("ID", rs.getString(1));
				custdataSet.put("CUST_NM", rs.getString(2));
				custdataSet.put("PH_NUM", rs.getString(3));
				custdataSet.put("ADDR", rs.getString(4));
				custdataSet.put("MB_GRA", rs.getString(5));
				custdataSet.put("POSS_PNT", rs.getString(6));

				// System.out.println(addrdataSet);
				custListData.add(custdataSet);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return custListData;

	}
	
	static List<Map<String, Serializable>>searchCust3(String search) {

		quary = "select ID, CUST_NM, PH_NUM, ADDR, MB_GRA, POSS_PNT from cust where CUST_TP = '회원' and MB_GRA like '%" + search + "%'";

		custListData.clear();

		try {

			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				custdataSet = new HashMap<String, Serializable>();

				custdataSet.put("ID", rs.getString(1));
				custdataSet.put("CUST_NM", rs.getString(2));
				custdataSet.put("PH_NUM", rs.getString(3));
				custdataSet.put("ADDR", rs.getString(4));
				custdataSet.put("MB_GRA", rs.getString(5));
				custdataSet.put("POSS_PNT", rs.getString(6));

				// System.out.println(addrdataSet);
				custListData.add(custdataSet);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return custListData;

	}
	
	static List<Map<String, Serializable>>selectCustGra(String user_id) {

		quary = "SELECT DISC_RT FROM CUST JOIN GRA_REC ON CUST.GRA_TP = GRA_REC.GRA_TP WHERE ID = '" + user_id + "' and DISC_APP_END_DT = '9999-12-31'";

		custListData.clear();

		try {

			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				custdataSet = new HashMap<String, Serializable>();

				custdataSet.put("DISC_RT", rs.getString(1));
				// System.out.println(addrdataSet);
				custListData.add(custdataSet);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return custListData;

	}
}
