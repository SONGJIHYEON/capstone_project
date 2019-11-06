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

public class MbgraData {

	public static Connection conn = ConnectionDB.getConnection();
	static String quary1, quary2;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;

	public static Map<String, Serializable> Mbgradata = new HashMap<String, Serializable>();

	public static Map<String, Serializable> MbgradataSet;

	public static List<Map<String, Serializable>> MbgraListData = new ArrayList<Map<String, Serializable>>();

	/* 고객번호가 있는 링크 리스트 구성 */
	public static void initMbgraData(String STdate) {

		Mbgradata.put("시작일자", STdate);
//		prodata.put("모델분류번호", pro_CTGR_NUM);
//		prodata.put("모델이름", pro_NM);
//		prodata.put("모델상세정보", pro_EXP);
//		prodata.put("모델상세정보", pro_EXP);
//		prodata.put("모델상세정보", pro_EXP);
	}

	/* 고객정보를 생성하는 질의어 */
	static void createMbgraS(double modrate) {

		quary1 = "update gra_rec SET DISC_APP_END_DT = TO_CHAR(SYSDATE-1, 'YYYY-MM-DD') WHERE gra_tp = 'S' AND DISC_APP_END_DT = '9999-12-31'";

		quary2 = "insert into gra_rec values ('S', TO_CHAR(SYSDATE, 'YYYY-MM-DD') , '9999-12-31', " + " " + modrate	+ ")";

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

	static void createMbgraV(double modrate) {

		quary1 = "update gra_rec SET DISC_APP_END_DT = TO_CHAR(SYSDATE-1, 'YYYY-MM-DD') WHERE gra_tp = 'V' AND DISC_APP_END_DT = '9999-12-31'";

		quary2 = "insert into gra_rec values ('V', TO_CHAR(SYSDATE, 'YYYY-MM-DD') , '9999-12-31', " + " '" + modrate+ "')";

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

	static void createMbgraF(double modrate) {

		quary1 = "update gra_rec SET DISC_APP_END_DT = TO_CHAR(SYSDATE-1, 'YYYY-MM-DD') WHERE gra_tp = 'F' AND DISC_APP_END_DT = '9999-12-31'";

		quary2 = "insert into gra_rec values ('F', TO_CHAR(SYSDATE, 'YYYY-MM-DD') , '9999-12-31', " + " '" + modrate + "')";

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

	static List<Map<String, Serializable>> MbgraS() {

		quary1 = "Select DISC_RT from gra_rec WHERE gra_tp = 'S' AND DISC_APP_END_DT = '9999-12-31'";

//		ProListData.clear();

		try {
			System.out.println(quary1);
			pstm = conn.prepareStatement(quary1, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				MbgradataSet = new HashMap<String, Serializable>();

				MbgradataSet.put("DISC_RT", rs.getString(1));

				MbgraListData.add(MbgradataSet);
			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return MbgraListData;

	}

	static List<Map<String, Serializable>> MbgraV() {

		quary1 = "Select DISC_RT from gra_rec WHERE gra_tp = 'V' AND DISC_APP_END_DT = '9999-12-31'";

//		ProListData.clear();

		try {
			System.out.println(quary1);
			pstm = conn.prepareStatement(quary1, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				MbgradataSet = new HashMap<String, Serializable>();

				MbgradataSet.put("DISC_RT", rs.getString(1));

				MbgraListData.add(MbgradataSet);
			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return MbgraListData;

	}

	static List<Map<String, Serializable>> MbgraF() {

		quary1 = "Select DISC_RT from gra_rec WHERE gra_tp = 'F' AND DISC_APP_END_DT = '9999-12-31'";

//	ProListData.clear();

		try {
			System.out.println(quary1);
			pstm = conn.prepareStatement(quary1, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				MbgradataSet = new HashMap<String, Serializable>();

				MbgradataSet.put("DISC_RT", rs.getString(1));

				MbgraListData.add(MbgradataSet);
			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return MbgraListData;

	}
}