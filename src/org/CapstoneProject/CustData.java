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

	/* ����ȣ�� �ִ� ��ũ ����Ʈ ���� */
	public static void initCustData(String ID, String PWD, String CUST_NM, String BD, String PH_NUM, String ADDR,
			String newstring) {

		custdata.put("���̵�", ID);
		custdata.put("��й�ȣ", PWD);
		custdata.put("�̸�", CUST_NM);
		custdata.put("�������", BD);
		custdata.put("�޴�����ȣ", PH_NUM);
		custdata.put("�ּ�", ADDR);
		custdata.put("��������������", newstring);
//		custdata.put("A", TEL);
//		custdata.put("A", TEL);
//		custdata.put("�ּ�", scust);

	}

	/* �������� �����ϴ� ���Ǿ� */
	static void createCust() {
		quary = "INSERT INTO CUST(CUST_NUM, CUST_NM, PH_NUM, CUST_TP, ID, PWD, BD, ADDR, MB_GRA, POSS_PNT, DISC_APP_ST_DT, DISC_APP_END_DT) "
				+ "VALUES(SEQ_CUST_NUM.NEXTVAL, '" + custdata.get("�̸�") + "', '" + custdata.get("�޴�����ȣ") + "', 'ȸ��', '"
				+ custdata.get("���̵�") + "', " + " '" + custdata.get("��й�ȣ") + "', to_date('" + custdata.get("�������")
				+ "', 'YYYY-MM-DD'), '" + custdata.get("�ּ�") + "', 'F', 0, " + " to_date('" + custdata.get("��������������")
				+ "', 'YYYY-MM-DD'), to_date('9999-12-31', 'YYYY-MM-DD'))";
		
		custListData.clear();

		System.out.println(quary);
		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select������ ���� �߻�");
			sqle.printStackTrace();
		}

	}

	static List<Map<String, Serializable>> selectcust() {

		quary = "select * from zipcode";

		custListData.clear();

		try {

			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				custdataSet = new HashMap<String, Serializable>();

				custdataSet.put("ZIPCODE", rs.getString(1));
				custdataSet.put("SEQ", rs.getString(2));
				custdataSet.put("SIDO", rs.getString(3));
				custdataSet.put("GUGUN", rs.getString(4));
				custdataSet.put("DONG", rs.getString(5));
				custdataSet.put("RI", rs.getString(6));
				custdataSet.put("BUNJI", rs.getString(7));
				custdataSet.put("BLDG", rs.getString(8));
				custdataSet.put("ADDR", rs.getString(9));
//				custdataSet.put("��й�ȣ", rs.getString(6));
//				custdataSet.put("�������", rs.getString(7));
//				custdataSet.put("�ּ�", rs.getString(8));
//				custdataSet.put("�����", rs.getString(9));
//				custdataSet.put("��������Ʈ", rs.getString(10));
//				custdataSet.put("���ν�����", rs.getString(11));
//				custdataSet.put("����������", rs.getString(12));

				// System.out.println(custdataSet);
				custListData.add(custdataSet);

			}

		} catch (SQLException sqle) {
			System.out.println("select������ ���� �߻�");
			sqle.printStackTrace();
		}

		return custListData;

	}

	static void initCustData2(String NONNM, String NONPH) {

		custdata.put("�̸�", NONNM);
		custdata.put("�޴�����ȣ", NONPH);

	}

	/* �������� �����ϴ� ���Ǿ� */
	static void createCust2() {
		quary = "INSERT INTO CUST(CUST_NUM, CUST_NM, PH_NUM, CUST_TP, ID, PWD, BD, ADDR, MB_GRA, POSS_PNT, DISC_APP_ST_DT, DISC_APP_END_DT) "
				+ "VALUES(SEQ_CUST_NUM.NEXTVAL, '" + custdata.get("�̸�") + "', '" + custdata.get("�޴�����ȣ")
				+ "', '��ȸ��', '', '', '', '', '', '', '', '')";

		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select������ ���� �߻�");
			sqle.printStackTrace();
		}

	}
	
	static void changeCust(String PWD, String BD, String PH_NUM, String ADDR, String ID) {
		quary = "update cust set PH_NUM = " + PH_NUM + ", PWD = " + PWD + ", BD = to_date('" + BD + "', 'YYYY-MM-DD'), "
				+ "ADDR = '" + ADDR +"' where id = '" + ID +"'";

		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select������ ���� �߻�");
			sqle.printStackTrace();
		}

	}
}
