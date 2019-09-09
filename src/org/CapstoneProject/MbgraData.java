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
	

	public static Map<String, Serializable > Mbgradata = new HashMap<String, Serializable>();
	
	public static Map<String, Serializable > MbgradataSet;
	
	public static List<Map<String, Serializable>> MbgraListData = new ArrayList<Map<String, Serializable>>();
	
	/* ����ȣ�� �ִ� ��ũ ����Ʈ ���� */
	public static void initMbgraData(String STdate) {

		Mbgradata.put("��������", STdate);
//		prodata.put("�𵨺з���ȣ", pro_CTGR_NUM);
//		prodata.put("���̸�", pro_NM);
//		prodata.put("�𵨻�����", pro_EXP);
//		prodata.put("�𵨻�����", pro_EXP);
//		prodata.put("�𵨻�����", pro_EXP);
	}
	
		
	/* �������� �����ϴ� ���Ǿ� */
	static void createMbgraS(double modrate) {
			
			quary1 = "update mb_gra SET DISC_APP_END_DT = to_char(sysdate-1, 'YYYYMMDD') WHERE gra_tp = 'S' AND DISC_APP_END_DT = '9999-12-31'";
			
			quary2 = "insert into mb_gra values ('S', to_char(sysdate, 'YYYYMMDD') , '9999-12-31', "
					+ " " + modrate + ")";
			
			try {
				pstm = conn.prepareStatement(quary1);
				pstm.executeQuery();
			} catch (SQLException sqle) {
				System.out.println("select������ ���� �߻�");
				sqle.printStackTrace();
			}
			try {
				pstm = conn.prepareStatement(quary2);
				pstm.executeQuery();
			} catch (SQLException sqle) {
				System.out.println("select������ ���� �߻�");
				sqle.printStackTrace();
			}
		
		}
		
	static void createMbgraV(double modrate) {
			
			quary1 = "update mb_gra SET DISC_APP_END_DT = to_char(sysdate-1, 'YYYYMMDD') WHERE gra_tp = 'V' AND DISC_APP_END_DT = '9999-12-31'";
			
			quary2 = "insert into mb_gra values ('V', to_char(sysdate, 'YYYYMMDD') , '9999-12-31', "
					+ " '" + modrate + "')";
			
			try {
				pstm = conn.prepareStatement(quary1);
				pstm.executeQuery();
			} catch (SQLException sqle) {
				System.out.println("select������ ���� �߻�");
				sqle.printStackTrace();
			}
			try {
				pstm = conn.prepareStatement(quary2);
				pstm.executeQuery();
			} catch (SQLException sqle) {
				System.out.println("select������ ���� �߻�");
				sqle.printStackTrace();
			}
		
		}
	
	static void createMbgraF(double modrate) {
		
		quary1 = "update mb_gra SET DISC_APP_END_DT = to_char(sysdate-1, 'YYYYMMDD') WHERE gra_tp = 'F' AND DISC_APP_END_DT = '9999-12-31'";
		
		quary2 = "insert into mb_gra values ('F', to_char(sysdate, 'YYYYMMDD') , '9999-12-31', "
				+ " '" + modrate + "')";
		
		try {
			pstm = conn.prepareStatement(quary1);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select������ ���� �߻�");
			sqle.printStackTrace();
		}
		try {
			pstm = conn.prepareStatement(quary2);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select������ ���� �߻�");
			sqle.printStackTrace();
		}
	
	}
	
	static List<Map<String, Serializable>> Mbgra() {
		
		quary1 = "Select DISC_APP_ST_DT from mb_gra WHERE gra_tp = 'F' AND DISC_APP_END_DT = '9999-12-31'";
	
//		ProListData.clear();
	
		try {
			System.out.println(quary1);
			pstm = conn.prepareStatement(quary1,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();			
			while(rs.next()){
			
				MbgradataSet = new HashMap<String, Serializable>();
			
				MbgradataSet.put("DISC_APP_ST_DT", rs.getString(1));
				
				MbgraListData.add(MbgradataSet);
			} 
		
		
		} catch (SQLException sqle) {
			System.out.println("select������ ���� �߻�");
			sqle.printStackTrace();
		}
	
		return MbgraListData;
	
	}
}



