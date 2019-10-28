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



public class CheckId {
	
	public static Connection conn = ConnectionDB.getConnection();
	static String quary;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;
	

	public static Map<String, Serializable > iddata = new HashMap<String, Serializable>();
	
	public static Map<String, Serializable > iddataSet;
	
	public static List<Map<String, Serializable>> idListData = new ArrayList<Map<String, Serializable>>();
	
	/* 고객번호가 있는 링크 리스트 구성 */
	public static void initCustData(String sid) {

		iddata.put("아이디", sid);
//		addrdata.put("A", NAME);
	}
//	
	
	static List<Map<String, Serializable>> selectid() {
			
			quary = "select count(id) from cust where id = '"+iddata.get("아이디")+"'";
	
			idListData.clear();
			
			try {
			
				pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
				rs = pstm.executeQuery();
	
				while(rs.next()){
					
					iddataSet = new HashMap<String, Serializable>();
					
					iddataSet.put("ID", rs.getString(1)); 
	//				addrdataSet.put("SEQ", rs.getString(2));
				
					
	//				System.out.println(iddataSet);
					idListData.add(iddataSet);
					
					
				} 
				
			} catch (SQLException sqle) {
				System.out.println("select문에서 예외 발생");
				sqle.printStackTrace();
			}
			
			return idListData;
			
		}
	
	static List<Map<String, Serializable>> selectlogin1(String sid, String pwd) {
		
		quary = "select ID, PWD, CUST_NUM, CUST_NM, POSS_PNT, cust.GRA_TP, DISC_RT, ADDR, PH_NUM, BD from cust "
				+ "join gra_rec on cust.gra_tp = gra_rec.gra_tp where ID = '" + sid + "'";
		idListData.clear();
	
		try {
		
			pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
	
				while(rs.next()){
				iddataSet = new HashMap<String, Serializable>();
				
				iddataSet.put("ID", rs.getString(1)); 
				iddataSet.put("PWD", rs.getString(2)); 
				iddataSet.put("CUST_NUM", rs.getString(3)); 
				iddataSet.put("CUST_NM", rs.getString(4)); 
				iddataSet.put("POSS_PNT", rs.getString(5)); 
				iddataSet.put("GRA_TP", rs.getString(6)); 
				iddataSet.put("DISC_RT", rs.getString(7));
				iddataSet.put("ADDR", rs.getString(8)); 
				iddataSet.put("PH_NUM", rs.getString(9));
				iddataSet.put("BD", rs.getString(10));



	//			addrdataSet.put("SEQ", rs.getString(2));
	
				System.out.println(iddataSet);
				idListData.add(iddataSet);
				}
			
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
		
		return idListData;
		}
	
	static List<Map<String, Serializable>> selectlogin2(String sid2, String pwd2) {
		
		quary = "select id, pwd, emp_num, emp_nm, appc_dt from emp where ID ='"+sid2+"'";
		idListData.clear();
	
		try {
		
			pstm = conn.prepareStatement(quary,  rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
	
				while(rs.next()){
				iddataSet = new HashMap<String, Serializable>();
				
				iddataSet.put("ID", rs.getString(1)); 
				iddataSet.put("PWD", rs.getString(2)); 
				iddataSet.put("emp_num", rs.getString(3)); 
				iddataSet.put("emp_nm", rs.getString(4)); 
				iddataSet.put("appc_dt", rs.getString(5)); 
	//			addrdataSet.put("SEQ", rs.getString(2));
	
	//			System.out.println(iddataSet);
				idListData.add(iddataSet);
				}
			
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}
		
		return idListData;
		}
}