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

import javax.swing.JOptionPane;

public class ImageData {

	public static Connection conn = ConnectionDB.getConnection();
	static String quary;
	static PreparedStatement pstm = null;
	static ResultSet rs = null;
	static int error;

	public static Map<String, Serializable> Imagedata = new HashMap<String, Serializable>();

	public static Map<String, Serializable> ImagedataSet;

	public static List<Map<String, Serializable>> ImageListData = new ArrayList<Map<String, Serializable>>();

	/* 고객번호가 있는 링크 리스트 구성 */
	public static void initImageData(String pro_NUM, String pro_CTGR_NUM, String pro_NM, String pro_EXP) {

	}

	/* 고객정보를 생성하는 질의어 */
	static void createImage(String Pro_num, String PRO_NM, String CLR, String SIZ, String SIZ_DET_INFO) {

		quary = "insert into pro values (SEQ_PRO_NUM.NEXTVAL, '" + Pro_num + "', '" + PRO_NM + "', '" + CLR + "', '"
				+ SIZ + "', '" + SIZ_DET_INFO + ")";

		System.out.println(quary);
		try {
			pstm = conn.prepareStatement(quary);
			pstm.executeQuery();
		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

	}

	static List<Map<String, Serializable>> selectImage(String fileName2) {

		quary = "select MODEL_IMG1, MODEL_IMG2 from model where MODEL_IMG1 = '" + fileName2 + "'";

		ImageListData.clear();

		try {
			System.out.println(quary);
			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ImagedataSet = new HashMap<String, Serializable>();

				ImagedataSet.put("MODEL_IMG1", rs.getString(1));
				ImagedataSet.put("MODEL_IMG2", rs.getString(2));

				ImageListData.add(ImagedataSet);
//            System.out.println(ImageListData);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return ImageListData;

	}

	static List<Map<String, Serializable>> selectNickname(String fileName2) {

		quary = "select MODEL_NICK from model where MODEL_IMG1 = '" + fileName2 + "'";

		ImageListData.clear();

		try {
			System.out.println(quary);
			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ImagedataSet = new HashMap<String, Serializable>();

				ImagedataSet.put("MODEL_NICK", rs.getString(1));

				ImageListData.add(ImagedataSet);
//            System.out.println(ImageListData);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return ImageListData;

	}

	static List<Map<String, Serializable>> selectCtgr(String fileName2) {

		quary = "select FIRST_CTGR, MODEL_NUM, MODEL_NM, model_img1 from model_ctgr "
				+ "join model on model.MODEL_CTGR_NUM = model_ctgr.MODEL_CTGR_NUM where MODEL_IMG1 = '" + fileName2
				+ "'";

		ImageListData.clear();

		try {
			System.out.println(quary);
			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ImagedataSet = new HashMap<String, Serializable>();

				ImagedataSet.put("FIRST_CTGR", rs.getString(1));

				ImageListData.add(ImagedataSet);
//            System.out.println(ImageListData);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return ImageListData;

	}

	static List<Map<String, Serializable>> selectSize(String fileName2) {

		quary = "select distinct SIZ from model " + "join pro on model.MODEL_NUM = pro.MODEL_NUM "
				+ "join pro_up_rec on PRO.PRO_NUM = PRO_UP_REC.PRO_NUM "
				+ "where APP_END_DT = '9999-12-31' and model_img1 = '" + fileName2 + "' order by SIZ asc";

		ImageListData.clear();

		try {
			System.out.println(quary);
			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ImagedataSet = new HashMap<String, Serializable>();

				ImagedataSet.put("SIZ", rs.getString(1));

				ImageListData.add(ImagedataSet);
//            System.out.println(ImageListData);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return ImageListData;

	}

	static List<Map<String, Serializable>> selectColor(String fileName2) {

		quary = "select CLR from model " + "join pro on model.MODEL_NUM = pro.MODEL_NUM "
				+ "join pro_up_rec on PRO.PRO_NUM = PRO_UP_REC.PRO_NUM "
				+ "where APP_END_DT = '9999-12-31' and model_img1 = '" + fileName2 + "' order by clr asc";

		ImageListData.clear();

		try {
			System.out.println(quary);
			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ImagedataSet = new HashMap<String, Serializable>();

				ImagedataSet.put("CLR", rs.getString(1));

				ImageListData.add(ImagedataSet);
//            System.out.println(ImageListData);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return ImageListData;

	}

	static List<Map<String, Serializable>> selectModelname(String fileName2) {

		quary = "select MODEL_NM from model where MODEL_IMG1 = '" + fileName2 + "'";

		ImageListData.clear();

		try {
			System.out.println(quary);
			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ImagedataSet = new HashMap<String, Serializable>();

				ImagedataSet.put("MODEL_NM", rs.getString(1));

				ImageListData.add(ImagedataSet);
//            System.out.println(ImageListData);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return ImageListData;

	}

	static List<Map<String, Serializable>> countBasicPrice(String filename) {

		quary = "select count(up) from model " + "join pro on model.MODEL_NUM = pro.MODEL_NUM "
				+ "join pro_up_rec on PRO.PRO_NUM = PRO_UP_REC.PRO_NUM "
				+ "where APP_END_DT = '9999-12-31' and model_img1 = '" + filename + "' order by up asc";

		ImageListData.clear();

		try {
			System.out.println(quary);
			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ImagedataSet = new HashMap<String, Serializable>();

				ImagedataSet.put("up", rs.getString(1));

				ImageListData.add(ImagedataSet);
//            System.out.println(ImageListData);
			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return ImageListData;

	}

	static List<Map<String, Serializable>> selectBasicPrice(String filename) {

		quary = "select PRO_NM, up from model " + "join pro on model.MODEL_NUM = pro.MODEL_NUM "
				+ "join pro_up_rec on PRO.PRO_NUM = PRO_UP_REC.PRO_NUM "
				+ "where APP_END_DT = '9999-12-31' and model_img1 = '" + filename + "' order by up asc";

		ImageListData.clear();

		try {
			System.out.println(quary);
			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ImagedataSet = new HashMap<String, Serializable>();

				ImagedataSet.put("PRO_NM", rs.getString(1));
				ImagedataSet.put("UP", rs.getString(2));

				ImageListData.add(ImagedataSet);
//            System.out.println(ImageListData);

				if (ImageListData.get(0).get("UP").toString() == null) {
					error = 1;
				}

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return ImageListData;

	}

	static List<Map<String, Serializable>> selectPrice(String ProName) {

		quary = "select PRO_NM, up from model " + "join pro on model.MODEL_NUM = pro.MODEL_NUM "
				+ "join pro_up_rec on PRO.PRO_NUM = PRO_UP_REC.PRO_NUM "
				+ "where APP_END_DT = '9999-12-31' and PRO_NM = '" + ProName + "'";

		ImageListData.clear();

		try {
			System.out.println(quary);
			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ImagedataSet = new HashMap<String, Serializable>();

				ImagedataSet.put("PRO_NM", rs.getString(1));
				ImagedataSet.put("UP", rs.getString(2));

				ImageListData.add(ImagedataSet);
//            System.out.println(ImageListData);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return ImageListData;

	}

	static List<Map<String, Serializable>> selectColor2(String selectSize) {

		quary = "select CLR from model " + "join pro on model.MODEL_NUM = pro.MODEL_NUM "
				+ "join pro_up_rec on PRO.PRO_NUM = PRO_UP_REC.PRO_NUM " + "where APP_END_DT = '9999-12-31' and siz = '"
				+ selectSize + "' order by clr asc";

		ImageListData.clear();

		try {
			System.out.println(quary);
			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ImagedataSet = new HashMap<String, Serializable>();

				ImagedataSet.put("CLR", rs.getString(1));

				ImageListData.add(ImagedataSet);
//                  System.out.println(ImageListData);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return ImageListData;

	}

	static List<Map<String, Serializable>> selectProNum(String proName) {

		quary = "select pro_num from pro where pro_nm = '" + proName + "'";

		ImageListData.clear();

		try {
			System.out.println(quary);
			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ImagedataSet = new HashMap<String, Serializable>();

				ImagedataSet.put("PRO_NUM", rs.getString(1));

				ImageListData.add(ImagedataSet);
//                  System.out.println(ImageListData);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return ImageListData;

	}

	static List<Map<String, Serializable>> registModel() {

		quary = "select MODEL_IMG1, MODEL_NICK from model " + "order by MODEL_IMG1 ASC";

		ImageListData.clear();

		try {
			System.out.println(quary);
			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ImagedataSet = new HashMap<String, Serializable>();

				ImagedataSet.put("MODEL_IMG1", rs.getString(1));
				ImagedataSet.put("MODEL_NICK", rs.getString(2));

				ImageListData.add(ImagedataSet);
//               System.out.println(ImageListData);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return ImageListData;

	}

	static List<Map<String, Serializable>> registModelType(String model_ctgr) {

		quary = "select MODEL_IMG1, MODEL_NICK from model " + "where MODEL_CTGR_NUM = " + model_ctgr
				+ " order by MODEL_IMG1 ASC";

		ImageListData.clear();

		try {
			System.out.println(quary);
			pstm = conn.prepareStatement(quary, rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
			rs = pstm.executeQuery();
			while (rs.next()) {

				ImagedataSet = new HashMap<String, Serializable>();

				ImagedataSet.put("MODEL_IMG1", rs.getString(1));
				ImagedataSet.put("MODEL_NICK", rs.getString(2));

				ImageListData.add(ImagedataSet);
//               System.out.println(ImageListData);

			}

		} catch (SQLException sqle) {
			System.out.println("select문에서 예외 발생");
			sqle.printStackTrace();
		}

		return ImageListData;

	}

}