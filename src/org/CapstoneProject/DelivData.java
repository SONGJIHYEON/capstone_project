
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

public class DelivData {

	public static Connection conn = ConnectionDB.getConnection();
	static String quary;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;

	public static Map<String, Serializable> delivdata = new HashMap<String, Serializable>();

	public static Map<String, Serializable> delivdataSet;

	public static List<Map<String, Serializable>> delivListData = new ArrayList<Map<String, Serializable>>();

	/* 고객번호가 있는 링크 리스트 구성 */
	public static void initModelData(String MODEL_NUM, String MODEL_CTGR_NUM, String MODEL_NM, String MODEL_EXP,
			String MODEL_NICK, String REP_MODEL_IMG, String DET_MODEL_IMG) {

//		Modeldata.put("모델번호", MODEL_NUM);
//		Modeldata.put("모델분류번호", MODEL_CTGR_NUM);
//		Modeldata.put("모델이름", MODEL_NM);
//		Modeldata.put("모델상세정보", MODEL_EXP);
//		Modeldata.put("모델별칭", MODEL_NICK);
//		Modeldata.put("대표이미지", REP_MODEL_IMG);
//		Modeldata.put("상세이미지", DET_MODEL_IMG);
	}

	/* 고객정보를 생성하는 질의어 */
	static void createDeliv(String sDeliv_num, String Od_num, String sDeliv_date, String sDeliv_cond, String sDeliv_type) {

		quary = "INSERT INTO DELIV(INV_NUM, OD_NUM, DELIV_DATE, DELIV_COND_TP, DELIV_TP) "
				+ "VALUES('"+sDeliv_num+"', '"+ Od_num+"', '"+sDeliv_date+"', '"+sDeliv_cond+"', '"+sDeliv_type+"' );";

		System.out.println(quary);
		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

	}

	static List<Map<String, Serializable>> selectDeliv() {

		quary = "SELECT MODEL_NM, MODEL_NUM, FIRST_CTGR, TOP_CLOTH_CTGR, BOT_CLOTH_CTGR, OUTER_CTGR, SHIR_CTGR, SHOOSE_CTGR "
				+ "FROM  MODEL JOIN MODEL_CTGR ON Model.MODEL_CTGR_NUM = Model_CTGR.MODEL_CTGR_NUM order by MODEL_NM";

		delivListData.clear();

		try {

			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				delivdataSet = new HashMap<String, Serializable>();

				delivdataSet.put("deliv_NM", rs.getString(1));
				delivdataSet.put("MODEL_NUM", rs.getString(2));
				delivdataSet.put("FIRST_CTGR", rs.getString(3));
				delivdataSet.put("TOP_CLOTH_CTGR", rs.getString(4));
				delivdataSet.put("BOT_CLOTH_CTGR", rs.getString(5));
				delivdataSet.put("OUTER_CTGR", rs.getString(6));
				delivdataSet.put("SHIR_CTGR", rs.getString(7));
				delivdataSet.put("SHOOSE_CTGR", rs.getString(8));

//            ModeldataSet.put("FIRST_CTGR", rs.getString(2)); 

				delivListData.add(delivdataSet);
//            System.out.println(delivListData);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return delivListData;

	}

}
