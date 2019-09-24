package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.CapstoneProject.Nonmember.RandomId;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class emp_re extends JFrame implements ActionListener {

	private JLabel mb_regist, mb_lookup, mb_regist2, Lemp_no, Lemp_nm, Lemp_dt, Lemp_ph_num, Lemp_tp, Lemp_addr,
			Lemp_addr1, Lemp_addr2, Lreg_tp, Lreg_id, Lreg_pw;

	private JTextField Temp_no, Temp_nm, Temp_dt, Temp_ph_num, Temp_addr, Temp_addr1, Temp_addr2, Treg_id, Treg_pw;

	private String[] emp_tp = { "정규직", "계약직" };
	private String[] reg_tp = { "스타일리스트", "웹디자이너", "포토그래퍼", "물류관리담당", "고객센터담당" };
	private String[] empty = { "" };

	private JButton Bregist, Bcancel, BtSearchAddr, BtCheckId, Bemp_num;

	private JComboBox<String> CBemp_tp, CBreg_tp;

	String EMP_NO, EMP_NM, EMP_DT, EMP_PH_NUM, EMP_TP, EMP_ADDR, REG_TP, REG_ID, REG_PW, sid, sid2, EMP_NUM;

	int close, intid;

	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints; // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할

	private void getData(List<Map<String, Serializable>> empListData) {

		sid2 = "";
		sid2 += empListData.get(0).get("ID").toString();

		intid = Integer.parseInt(sid2);

		if (intid == 0) {
			JOptionPane.showMessageDialog(null, "사용가능한 아이디 입니다", "", JOptionPane.INFORMATION_MESSAGE);
			return;
		} else
			JOptionPane.showMessageDialog(null, "중복된 아이디 입니다", "", JOptionPane.INFORMATION_MESSAGE);
		Treg_id.setText("");
		return;
	}

	public emp_re(JFrame fr) {
//	     super(fr, "", true);

		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();

		mb_regist2 = new JLabel("사원등록");
		mb_regist2.setPreferredSize(new Dimension(200, 28));

		Lemp_no = new JLabel("사원번호");
		Lemp_no.setPreferredSize(new Dimension(100, 30));
		Lemp_nm = new JLabel("사원명");
		Lemp_nm.setPreferredSize(new Dimension(100, 30));
		Lemp_dt = new JLabel("입사일자(8자)");
		Lemp_dt.setPreferredSize(new Dimension(100, 30));
		Lemp_ph_num = new JLabel("휴대폰 번호");
		Lemp_ph_num.setPreferredSize(new Dimension(100, 30));
		Lemp_tp = new JLabel("사원구분");
		Lemp_tp.setPreferredSize(new Dimension(100, 30));
		Lemp_addr = new JLabel("주소");
		Lemp_addr.setPreferredSize(new Dimension(100, 30));
		Lemp_addr1 = new JLabel("기본주소");
		Lemp_addr1.setFont(new Font("serif", Font.PLAIN, 12));
		Lemp_addr2 = new JLabel("상세주소");
		Lemp_addr2.setFont(new Font("serif", Font.PLAIN, 12));
		Lreg_tp = new JLabel("정규직 구분");
		Lreg_tp.setPreferredSize(new Dimension(100, 30));
		Lreg_id = new JLabel("아이디");
		Lreg_id.setPreferredSize(new Dimension(100, 30));
		Lreg_pw = new JLabel("초기 비밀번호");
		Lreg_pw.setPreferredSize(new Dimension(100, 30));

		CBemp_tp = new JComboBox<String>(emp_tp);
		CBemp_tp.setPreferredSize(new Dimension(100, 30));
		CBemp_tp.addActionListener(this);
		CBreg_tp = new JComboBox<String>(reg_tp);
		CBreg_tp.setPreferredSize(new Dimension(100, 30));

		Temp_no = new JTextField(22);
		Temp_no.setPreferredSize(new Dimension(100, 30));
		Temp_nm = new JTextField(22);
		Temp_nm.setPreferredSize(new Dimension(100, 30));
		Temp_dt = new JTextField(22);
		Temp_dt.setPreferredSize(new Dimension(100, 30));
		Temp_ph_num = new JTextField(22);
		Temp_ph_num.setPreferredSize(new Dimension(100, 30));
		Temp_addr = new JTextField(22);
		Temp_addr.setPreferredSize(new Dimension(100, 30));
		Temp_addr1 = new JTextField(22);
		Temp_addr1.setPreferredSize(new Dimension(100, 30));
		Temp_addr2 = new JTextField(22);
		Temp_addr2.setPreferredSize(new Dimension(100, 30));
		Treg_id = new JTextField(22);
		Treg_id.setText("");
		Treg_id.setPreferredSize(new Dimension(100, 30));
		Treg_pw = new JTextField(22);
		Treg_pw.setPreferredSize(new Dimension(100, 30));

		Bemp_num = new JButton("사원번호 생성");
		Bemp_num.addActionListener(this);
		Bregist = new JButton("등록");
		Bregist.setPreferredSize(new Dimension(100, 28));
		Bregist.addActionListener(this);
		Bcancel = new JButton("취소");
		Bcancel.setPreferredSize(new Dimension(100, 28));
		Bcancel.addActionListener(this);
		BtSearchAddr = new JButton("우편번호 검색");
		BtSearchAddr.addActionListener(this);
		BtCheckId = new JButton("중복검사");
		BtCheckId.addActionListener(this);

		CBreg_tp.setEnabled(true);
		CBreg_tp.setVisible(true);
		EmpRegisterView();

	}

	private void EmpRegisterView() {

		gridbagconstraints.anchor = GridBagConstraints.WEST;
//         gridbagconstraints.ipadx = 7;
//         
//         gridbagconstraints.weightx=1.0;
//         gridbagconstraints.weighty=1.0;

		setLayout(gridbaglayout);
		gridbagconstraints.anchor = GridBagConstraints.CENTER;

		gridbagconstraints.anchor = GridBagConstraints.WEST;

		gridbagAdd(mb_regist2, 1, 1, 1, 1);
		gridbagAdd(Lemp_no, 1, 2, 1, 1);
		gridbagAdd(Lemp_nm, 1, 3, 1, 1);
		gridbagAdd(Lemp_dt, 1, 4, 1, 1);
		gridbagAdd(Lemp_ph_num, 1, 5, 1, 1);
		gridbagAdd(Lemp_addr, 1, 6, 1, 1);
		gridbagAdd(Lemp_tp, 1, 9, 1, 1);
		gridbagAdd(Lreg_tp, 1, 10, 1, 1);
		gridbagAdd(Lreg_id, 1, 11, 1, 1);
		gridbagAdd(Lreg_pw, 1, 12, 1, 1);
		gridbagAdd(Temp_no, 2, 2, 1, 1);
		gridbagAdd(Bemp_num, 3, 2, 1, 1);
		gridbagAdd(Temp_nm, 2, 3, 1, 1);
		gridbagAdd(Temp_dt, 2, 4, 1, 1);
		gridbagAdd(Temp_ph_num, 2, 5, 1, 1);
		gridbagAdd(Temp_addr, 2, 6, 1, 1);
		gridbagAdd(Temp_addr1, 2, 7, 1, 1);
		gridbagAdd(Temp_addr2, 2, 8, 1, 1);
		gridbagAdd(BtSearchAddr, 3, 6, 1, 1);
		gridbagAdd(Lemp_addr1, 3, 7, 1, 1);
		gridbagAdd(Lemp_addr2, 3, 8, 1, 1);

		gridbagAdd(CBemp_tp, 2, 9, 1, 1);
		gridbagAdd(CBreg_tp, 2, 10, 1, 1);

		gridbagAdd(Treg_id, 2, 11, 1, 1);
		gridbagAdd(BtCheckId, 3, 11, 1, 1);
		gridbagAdd(Treg_pw, 2, 12, 1, 1);

		gridbagAdd(Bregist, 2, 13, 1, 1);

		gridbagconstraints.anchor = GridBagConstraints.EAST;
		gridbagAdd(Bcancel, 2, 13, 1, 1);

		setVisible(true);
	}

	private void gridbagAdd(Component c, int x, int y, int w, int h) {

		gridbagconstraints.gridx = x;
		gridbagconstraints.gridy = y;
		// 가장 왼쪽 위 gridx, gridy값은 0

		gridbagconstraints.gridwidth = w;
		gridbagconstraints.gridheight = h;

		gridbaglayout.setConstraints(c, gridbagconstraints); // 컴포넌트를 컴포넌트 위치+크기 정보에 따라 GridBagLayout에 배치

		add(c);

	}
	
	public class RandomId {
		Random r = new Random();
		int x = (r.nextInt(900000)+100000);
	}

	public static void main(String[] args) {
		new emp_re(new JFrame());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Bemp_num) {
			RandomId rid = new RandomId();
			JOptionPane.showMessageDialog(null, "사원번호는 " + rid.x + " 입니다");
			String x = Integer.toString(rid.x);
			Temp_no.setText(x);			
		}		
		if (e.getSource() == CBemp_tp) {
			if (CBemp_tp.getSelectedItem() == "정규직") {
				BtCheckId.setEnabled(true);
				BtCheckId.setVisible(true);
				CBreg_tp.setEnabled(true);
				CBreg_tp.setVisible(true);
				Lreg_tp.setVisible(true);
				Lreg_id.setVisible(true);
				Lreg_pw.setVisible(true);
				Treg_id.setVisible(true);
				Treg_pw.setVisible(true);
			} else if (CBemp_tp.getSelectedItem() == "계약직") {
//				CBreg_tp = new JComboBox<String>(empty);		
				BtCheckId.setEnabled(false);
				BtCheckId.setVisible(false);
				CBreg_tp.setEnabled(false);
				CBreg_tp.setVisible(false);
				Lreg_tp.setVisible(false);
				Lreg_id.setVisible(false);
				Lreg_pw.setVisible(false);
				Treg_id.setVisible(false);
				Treg_pw.setVisible(false);
			}
		} else if (e.getSource() == Bregist) {

			int result = JOptionPane.showConfirmDialog(null, "해당 사원 정보를 등록하시겠습니까?", "사원 등록 확인",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (result == 0) {
				// 변수에 콤보박스 값 저장

				EMP_NUM = Temp_no.getText();
				EMP_NM = Temp_nm.getText();
				EMP_DT = Temp_dt.getText();
				EMP_PH_NUM = Temp_ph_num.getText();
				EMP_TP = (String) CBemp_tp.getSelectedItem();
				EMP_ADDR = Temp_addr1.getText() + Temp_addr2.getText();
				REG_TP = (String) CBreg_tp.getSelectedItem();
				if (EMP_TP == "계약직") {
					REG_TP = "";
				}
				REG_ID = Treg_id.getText();
				REG_PW = Treg_pw.getText();
				if (EMP_NUM.equals("") || EMP_NM.equals("") || EMP_DT.equals("") || EMP_ADDR.equals("") || EMP_PH_NUM.equals("")
						|| EMP_TP.equals("")) {
					JOptionPane.showMessageDialog(null, "입력되지 않은 항목이 있습니다.", "오류", JOptionPane.ERROR_MESSAGE);
				} else {
					empData.initempData(EMP_NUM, EMP_NM, EMP_DT, EMP_PH_NUM, EMP_TP, EMP_ADDR, REG_TP, REG_ID, REG_PW);
					empData.createemp();
					JOptionPane.showMessageDialog(null, "사원이 등록되었습니다.", "사원 등록", JOptionPane.WARNING_MESSAGE);
							Temp_no.setText("");
							Temp_nm.setText("");
							Temp_dt.setText("");
							Temp_ph_num.setText("");
							Temp_addr.setText("");
							Treg_id.setText("");
							Treg_pw.setText("");
					dispose();
				}
			} else if (result == 1) {
				JOptionPane.getRootFrame().dispose();
			}
		} else if (e.getSource() == Bcancel) {

		}
		if (e.getSource() == BtSearchAddr) {
			Address s = new Address(new JFrame());
			Temp_addr.setText(s.zipcode);
			Temp_addr1.setText(s.addr);
		}
		if (e.getSource() == BtCheckId) {
			sid = "";
			sid += Treg_id.getText();
			System.out.println(sid);
			if (sid.equals("")) {
				JOptionPane.showMessageDialog(null, "ID를 입력해 주세요.", "ID미입력", JOptionPane.WARNING_MESSAGE);
			} else {
				getData(empData.selectid(sid));
			}
		}

	}
}