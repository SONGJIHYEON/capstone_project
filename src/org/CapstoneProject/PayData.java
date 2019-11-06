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

public class PayData {

	public static Connection conn = ConnectionDB.getConnection();
	static String quary1, quary2;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;

	public static Map<String, Serializable> Paydata = new HashMap<String, Serializable>();

	public static Map<String, Serializable> PaydataSet;

	public static List<Map<String, Serializable>> PayListData = new ArrayList<Map<String, Serializable>>();

	/* 고객번호가 있는 링크 리스트 구성 */
//	public static void initPayData(String STdate) {
//
//		Paydata.put("시작일자", STdate);
//		prodata.put("모델분류번호", pro_CTGR_NUM);
//		prodata.put("모델이름", pro_NM);
//		prodata.put("모델상세정보", pro_EXP);
//		prodata.put("모델상세정보", pro_EXP);
//		prodata.put("모델상세정보", pro_EXP);
//	}

	/* 고객정보를 생성하는 질의어 */
	static void createPay(String orderNum, String price) {

		quary1 = "INSERT INTO PAY(PAY_NUM, OD_NUM, PAY_TOT_PR, PAY_DATE) "
				+ "VALUES(SEQ_PAY_NUM.NEXTVAL, '"+orderNum+"', '"+price+"', TO_CHAR(SYSDATE, 'YYYYMMDD'))";


		try {
			pstm = conn.prepareStatement(quary1);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
	}
	
	static void createPayBrkdwn1(String payNum, double od_price, double used_point) {

		quary1 = "INSERT INTO PAY_BRKDWN(PAY_NUM, PAY_MNS, PAY_PR, BK_NM, ACC_HD, ACC_NUM, CARD_COM, CARD_NUM) "
				+ "VALUES('"+payNum+"', '계좌이체', "+od_price+", '', '', '', '', '')";
		
		quary2 = "INSERT INTO PAY_BRKDWN(PAY_NUM, PAY_MNS, PAY_PR, BK_NM, ACC_HD, ACC_NUM, CARD_COM, CARD_NUM) "
				+ "VALUES('"+payNum+"', '적립금', "+used_point+", '', '', '', '', '')";


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
	
	static void createPayBrkdwn2(String payNum, double price) {

		quary1 = "INSERT INTO PAY_BRKDWN(PAY_NUM, PAY_MNS, PAY_PR, BK_NM, ACC_HD, ACC_NUM, CARD_COM, CARD_NUM) "
				+ "VALUES('"+payNum+"', '계좌이체', "+price+", '', '', '', '', '')";


		try {
			pstm = conn.prepareStatement(quary1);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
	}
	
	static void createPayBrkdwn3(String payNum, double od_price, double used_point) {

		quary1 = "INSERT INTO PAY_BRKDWN(PAY_NUM, PAY_MNS, PAY_PR, BK_NM, ACC_HD, ACC_NUM, CARD_COM, CARD_NUM) "
				+ "VALUES('"+payNum+"', '신용카드', "+od_price+", '', '', '', '', '')";
		
		quary2 = "INSERT INTO PAY_BRKDWN(PAY_NUM, PAY_MNS, PAY_PR, BK_NM, ACC_HD, ACC_NUM, CARD_COM, CARD_NUM) "
				+ "VALUES('"+payNum+"', '적립금', "+used_point+", '', '', '', '', '')";


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
	
	static void createPayBrkdwn4(String payNum, double price) {

		quary1 = "INSERT INTO PAY_BRKDWN(PAY_NUM, PAY_MNS, PAY_PR, BK_NM, ACC_HD, ACC_NUM, CARD_COM, CARD_NUM) "
				+ "VALUES('"+payNum+"', '신용카드', "+price+", '', '', '', '', '')";


		try {
			pstm = conn.prepareStatement(quary1);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
	}
	
	static List<Map<String, Serializable>> selectPay_Num() {

		quary1 = "select pay_num from pay order by PAY_NUM desc";

		PayListData.clear();

		try {
			System.out.println(quary1);
			pstm = conn.prepareStatement(quary1, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				PaydataSet = new HashMap<String, Serializable>();

				PaydataSet.put("pay_num", rs.getString(1));

				PayListData.add(PaydataSet);
			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return PayListData;

	}
}