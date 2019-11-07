
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

public class ProPriceData {

	public static Connection conn = ConnectionDB.getConnection();
	static String quary, quary1, quary2;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;

	public static Map<String, Serializable> ProPricedata = new HashMap<String, Serializable>();

	public static Map<String, Serializable> ProPricedataSet;

	public static List<Map<String, Serializable>> ProPriceListData = new ArrayList<Map<String, Serializable>>();

	/* 고객번호가 있는 링크 리스트 구성 */
	public static void initProPriceData(String pro_NUM, String pro_CTGR_NUM, String pro_NM, String pro_EXP) {

//		prodata.put("모델번호", pro_NUM);
//		prodata.put("모델분류번호", pro_CTGR_NUM);
//		prodata.put("모델이름", pro_NM);
//		prodata.put("모델상세정보", pro_EXP);
//		prodata.put("모델상세정보", pro_EXP);
//		prodata.put("모델상세정보", pro_EXP);
	}

	/* 고객정보를 생성하는 질의어 */
	static void createProPrice(String pro_num, String modstdate, String modendate, String modprice, String proname2) {

		quary1 = "update (select * from pro JOIN PRO_UP_REC ON PRO.PRO_NUM = PRO_UP_REC.PRO_NUM where pro_nm = '"
				+ proname2 + "')" + "SET APP_END_DT = to_char(sysdate-1, 'YYYYMMDD') WHERE APP_END_DT = '9999-12-31'";

		quary2 = "insert into pro_up_rec values ('" + pro_num + "', to_char(sysdate, 'YYYYMMDD') , to_date('"
				+ modendate + "', 'YYYY-MM-DD'), " + " '" + modprice + "', '0', '0')";

		try {
			pstm = conn.prepareStatement(quary1);
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

	static List<Map<String, Serializable>> ProPrice(String proname) {

		quary1 = "select pro_nm, up, APP_ST_DT, APP_END_DT from pro full outer join pro_up_rec on pro.pro_num = pro_up_rec.pro_num"
				+ " where PRO_NM = '" + proname + "'";

		ProPriceListData.clear();

		try {
			System.out.println(quary1);
			pstm = conn.prepareStatement(quary1, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ProPricedataSet = new HashMap<String, Serializable>();

				ProPricedataSet.put("PRO_NM", rs.getString(1));
				ProPricedataSet.put("UP", rs.getString(2));
				ProPricedataSet.put("APP_ST_DT", rs.getString(3));
				ProPricedataSet.put("APP_END_DT", rs.getString(4));

				ProPriceListData.add(ProPricedataSet);
//			System.out.println(ProPriceListData);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return ProPriceListData;

	}

	static List<Map<String, Serializable>> selectPro_up_rec() {

		quary = "select PRO_NM, siz, clr, APP_ST_DT, APP_END_DT, UP from pro join pro_up_rec on pro.pro_num = pro_up_rec.pro_num";

		ProPriceListData.clear();

		try {

			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ProPricedataSet = new HashMap<String, Serializable>();

				ProPricedataSet.put("PRO_NM", rs.getString(1));
				ProPricedataSet.put("SIZ", rs.getString(2));
				ProPricedataSet.put("CLR", rs.getString(3));
				ProPricedataSet.put("APP_ST_DT", rs.getString(4));
				ProPricedataSet.put("APP_END_DT", rs.getString(5));
				ProPricedataSet.put("UP", rs.getString(6));

				// System.out.println(addrdataSet);
				ProPriceListData.add(ProPricedataSet);
			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return ProPriceListData;

	}
	
	static List<Map<String, Serializable>> searchPro_up_rec1(String search) {

		quary = "select PRO_NM, siz, clr, APP_ST_DT, APP_END_DT, UP from pro join pro_up_rec on pro.pro_num = pro_up_rec.pro_num "
				+ "where pro_nm '%"+ search + "%' ";

		ProPriceListData.clear();

		try {

			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ProPricedataSet = new HashMap<String, Serializable>();

				ProPricedataSet.put("PRO_NM", rs.getString(1));
				ProPricedataSet.put("SIZ", rs.getString(2));
				ProPricedataSet.put("clr", rs.getString(3));
				ProPricedataSet.put("APP_ST_DT", rs.getString(4));
				ProPricedataSet.put("APP_END_DT", rs.getString(5));
				ProPricedataSet.put("UP", rs.getString(6));

				// System.out.println(addrdataSet);
				ProPriceListData.add(ProPricedataSet);
			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return ProPriceListData;

	}
	
	static List<Map<String, Serializable>> searchPro_up_rec2(String search) {

		quary = "select PRO_NM, siz, clr, APP_ST_DT, APP_END_DT, UP from pro join pro_up_rec on pro.pro_num = pro_up_rec.pro_num"
				+ "where up like '%" + search + "%'";

		ProPriceListData.clear();

		try {

			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ProPricedataSet = new HashMap<String, Serializable>();

				ProPricedataSet.put("PRO_NM", rs.getString(1));
				ProPricedataSet.put("SIZ", rs.getString(2));
				ProPricedataSet.put("clr", rs.getString(3));
				ProPricedataSet.put("APP_ST_DT", rs.getString(4));
				ProPricedataSet.put("APP_END_DT", rs.getString(5));
				ProPricedataSet.put("UP", rs.getString(6));

				// System.out.println(addrdataSet);
				ProPriceListData.add(ProPricedataSet);
			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return ProPriceListData;

	}
}
