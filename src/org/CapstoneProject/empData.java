 
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

public class empData {

	public static Connection conn = ConnectionDB.getConnection();
	static String quary;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;

	public static Map<String, Serializable> empData = new HashMap<String, Serializable>();

	public static Map<String, Serializable> empDataSet;

	public static List<Map<String, Serializable>> empListData = new ArrayList<Map<String, Serializable>>();

	/* 고객번호가 있는 링크 리스트 구성 */
	public static void initempData(String EMP_NUM, String EMP_NM, String EMP_DT, String EMP_PH_NUM, String EMP_TP,
			String EMP_ADDR, String REG_TP, String REG_ID, String REG_PW) {

		empData.put("사원번호", EMP_NUM);
		empData.put("사원명", EMP_NM);
		empData.put("사원주소", EMP_ADDR);
		empData.put("휴대폰번호", EMP_PH_NUM);
		empData.put("입사일자", EMP_DT);
		empData.put("사원구분", EMP_TP);
		empData.put("정규직구분", REG_TP);
		empData.put("사원ID", REG_ID);
		empData.put("초기비밀번호", REG_PW);

	}

	static void createemp() {
		quary = "INSERT INTO emp VALUES('" + empData.get("사원번호") + "', '" + empData.get("사원명") + "', '"
				+ empData.get("사원주소") + "', " + " '" + empData.get("휴대폰번호") + "' , to_date('" + empData.get("입사일자")
				+ "', 'YYYY-MM-DD'), '" + empData.get("사원구분") + "', " + "  '" + empData.get("사원ID") + "', '"
				+ empData.get("정규직구분") + "', '" + empData.get("초기비밀번호") + "')";

		System.out.println(quary);

		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

	}

	static List<Map<String, Serializable>> selectid(String sid) {

		quary = "select count(id) from emp where id = '" + sid + "'";

		empListData.clear();

		try {

			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();

			while (rs.next()) {

				empDataSet = new HashMap<String, Serializable>();

				empDataSet.put("ID", rs.getString(1));
//				addrdataSet.put("SEQ", rs.getString(2));

//				System.out.println(iddataSet);
				empListData.add(empDataSet);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return empListData;

	}
	
	static List<Map<String, Serializable>> selectEmp() {

		quary = "select EMP_NUM, EMP_NM, PH_NUM, APPC_DT, REG_WRKR_TP from emp";

		empListData.clear();

		try {

			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				empDataSet = new HashMap<String, Serializable>();

				empDataSet.put("EMP_NUM", rs.getString(1));
				empDataSet.put("EMP_NM", rs.getString(2));
				empDataSet.put("PH_NUM", rs.getString(3));
				empDataSet.put("APPC_DT", rs.getString(4));
				empDataSet.put("REG_WRKR_TP", rs.getString(5));

				// System.out.println(addrdataSet);
				empListData.add(empDataSet);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return empListData;

	}

	static List<Map<String, Serializable>> searchEmp1(String search) {

		quary = "select *from emp where EMP_NM like '%" + search + "%'";

		empListData.clear();

		try {

			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();

			while (rs.next()) {

				empDataSet = new HashMap<String, Serializable>();

				empDataSet.put("EMP_NUM", rs.getString(1));
				empDataSet.put("EMP_NM", rs.getString(2));
				empDataSet.put("PH_NUM", rs.getString(4));
				empDataSet.put("APPC_DT", rs.getString(5));
				empDataSet.put("REG_WRKR_TP", rs.getString(8));

//				System.out.println(iddataSet);
				empListData.add(empDataSet);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return empListData;

	}
	
	static List<Map<String, Serializable>> searchEmp2(String search) {

		quary = "select *from emp where PH_NUM like '%" + search + "%'";

		empListData.clear();

		try {

			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();

			while (rs.next()) {

				empDataSet = new HashMap<String, Serializable>();

				empDataSet.put("EMP_NUM", rs.getString(1));
				empDataSet.put("EMP_NM", rs.getString(2));
				empDataSet.put("PH_NUM", rs.getString(4));
				empDataSet.put("APPC_DT", rs.getString(5));
				empDataSet.put("REG_WRKR_TP", rs.getString(8));

//				System.out.println(iddataSet);
				empListData.add(empDataSet);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return empListData;

	}
}

