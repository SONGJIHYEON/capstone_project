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

public class OrderData {

	public static Connection conn = ConnectionDB.getConnection();
	static String quary1, quary2;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;

	public static Map<String, Serializable> Orderdata = new HashMap<String, Serializable>();

	public static Map<String, Serializable> OrderdataSet;

	public static List<Map<String, Serializable>> OrderListData = new ArrayList<Map<String, Serializable>>();

	static ArrayList<String> odList = new ArrayList<>();

	/* 고객번호가 있는 링크 리스트 구성 */
//	public static void initMbgraData(String STdate) {
//
//		Mbgradata.put("시작일자", STdate);
//		prodata.put("모델분류번호", pro_CTGR_NUM);
//		prodata.put("모델이름", pro_NM);
//		prodata.put("모델상세정보", pro_EXP);
//		prodata.put("모델상세정보", pro_EXP);
//		prodata.put("모델상세정보", pro_EXP);
//	}

	/* 고객정보를 생성하는 질의어 */
	static void createOrder1(String cust_num, String od_price) {

		quary1 = "INSERT INTO od(OD_NUM, EMP_NUM, CUST_NUM, OD_DATE, OD_PR, OD_COND_TP) "
				+ "VALUES(concat(to_char(sysdate, 'yymmdd'), seq_order_num.nextval), '000000', '"+cust_num+"', "
						+ "TO_CHAR(SYSDATE, 'YYYYmmdd'), '"+od_price+"', '통장미입금')";

//		quary2

		try {
			pstm = conn.prepareStatement(quary1);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
//		try {
//			pstm = conn.prepareStatement(quary2);
//			pstm.executeQuery();
//		} catch (SQLException sqle) {
//			System.out.println("select문에서 예외 발생");
//			sqle.printStackTrace();
//		}

	}

	static void createOrder2(String cust_num, String od_price) {

		quary1 = "INSERT INTO od(OD_NUM, EMP_NUM, CUST_NUM, OD_DATE, OD_PR, OD_COND_TP) "
				+ "VALUES(concat(to_char(sysdate, 'yymmdd'), seq_order_num.nextval), '000000', '"+cust_num+"', "
				+ "TO_CHAR(SYSDATE, 'YYYYmmdd'), '"+od_price+"', '상품준비중')";

//		quary2 =

		try {
			pstm = conn.prepareStatement(quary1);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
//		try {
//			pstm = conn.prepareStatement(quary2);
//			pstm.executeQuery();
//		} catch (SQLException sqle) {
//			System.out.println("select문에서 예외 발생");
//			sqle.printStackTrace();
//		}

	}
	
	static void createOrder3(String oderNum) {
		odList = MemOrdPg.arList;
		
		for(int i = 0; i < odList.size() ; i = i + 4) {
			quary1 = "INSERT INTO od_brkdwn(OD_NUM, PRO_NUM, QUANT, UP, PR) "
					+ "VALUES('" + oderNum + "', '" + odList.get(i) + "', " + Double.valueOf(odList.get(i+1)) + ", "
							+ ""+ Double.valueOf(odList.get(i+2)) +", "+ Double.valueOf(odList.get(i+3)) +")";
			try {
				pstm = conn.prepareStatement(quary1);
				pstm.executeQuery();
			} catch (SQLException sqle) {
				System.out.println("select문에서 예외 발생");
				sqle.printStackTrace();
			}
		}
	}
	
	
	static List<Map<String, Serializable>> selectOd_Num() {

		quary1 = "select od_num from od order by OD_NUM desc";

		OrderListData.clear();

		try {
			System.out.println(quary1);
			pstm = conn.prepareStatement(quary1, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				OrderdataSet = new HashMap<String, Serializable>();

				OrderdataSet.put("od_num", rs.getString(1));

				OrderListData.add(OrderdataSet);
			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return OrderListData;

	}
	
	static List<Map<String, Serializable>> searchOd_list() {

		quary1 = "select OD_DATE, PRO_NM, QUANT, OD_PR, OD_COND_TP "
				+ "from od join od_brkdwn on od.od_num = od_brkdwn.od_num join pro on od_brkdwn.pro_num = pro.pro_num";

		OrderListData.clear();

		try {
			System.out.println(quary1);
			pstm = conn.prepareStatement(quary1, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				OrderdataSet = new HashMap<String, Serializable>();

				OrderdataSet.put("OD_DATE", rs.getString(1));
				OrderdataSet.put("PRO_NM", rs.getString(2));
				OrderdataSet.put("QUANT", rs.getString(3));
				OrderdataSet.put("OD_PR", rs.getString(4));
				OrderdataSet.put("OD_COND_TP", rs.getString(5));

				OrderListData.add(OrderdataSet);
			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return OrderListData;

	}

//
//	static List<Map<String, Serializable>> MbgraV() {

//		quary1 = "Select DISC_RT from gra_rec WHERE gra_tp = 'V' AND DISC_APP_END_DT = '9999-12-31'";

//		ProListData.clear();
//
//		try {
//			System.out.println(quary1);
//			pstm = conn.prepareStatement(quary1, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
//			rs = pstm.executeQuery();
//			while (rs.next()) {
//
//				MbgradataSet = new HashMap<String, Serializable>();
//
//				MbgradataSet.put("DISC_RT", rs.getString(1));
//
//				MbgraListData.add(MbgradataSet);
//			}
//
//		} catch (SQLException sqle) {
//			System.out.println("select문에서 예외 발생");
//			sqle.printStackTrace();
//		}
//
//		return MbgraListData;
//
//	}
//
//	static List<Map<String, Serializable>> MbgraF() {
//
//		quary1 = "Select DISC_RT from gra_rec WHERE gra_tp = 'F' AND DISC_APP_END_DT = '9999-12-31'";
//
////	ProListData.clear();
//
//		try {
//			System.out.println(quary1);
//			pstm = conn.prepareStatement(quary1, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
//			rs = pstm.executeQuery();
//			while (rs.next()) {
//
//				MbgradataSet = new HashMap<String, Serializable>();
//
//				MbgradataSet.put("DISC_RT", rs.getString(1));
//
//				MbgraListData.add(MbgradataSet);
//			}
//
//		} catch (SQLException sqle) {
//			System.out.println("select문에서 예외 발생");
//			sqle.printStackTrace();
//		}
//
//		return MbgraListData;
//
//	}
}