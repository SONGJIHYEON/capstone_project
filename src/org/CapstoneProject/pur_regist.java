package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class pur_regist extends Dialog implements ActionListener {

	private JLabel pur_regist, Lcorr_nm, Lpur_dt, Ltot_pr;
	private JTextField Tcorr_nm;
	private static JTextField Tpur_dt;
	private static JTextField Ttot_pr;
	private static String[] col1 = { "마지막번호" };
	private static DefaultTableModel model1 = new DefaultTableModel(col1, 0);
	private static JTable pur_info;

	private JButton Bregist, Bcancel;

	static String corr_num;
	String corr_nm;
	static String pur_num;
	static String pur_dt;
	static int tot_pr;

	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints; // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할

	public pur_regist(JFrame fr) {
		super(fr, "", true);
		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();

		pur_info = new JTable(model1);

		pur_regist = new JLabel("구매등록");
		pur_regist.setPreferredSize(new Dimension(100, 30));
		Lcorr_nm = new JLabel("거래처명");
		Lcorr_nm.setPreferredSize(new Dimension(100, 30));
		Lpur_dt = new JLabel("구매일자");
		Lpur_dt.setPreferredSize(new Dimension(100, 30));
		Ltot_pr = new JLabel("총금액");
		Ltot_pr.setPreferredSize(new Dimension(100, 30));

		Tcorr_nm = new JTextField(18);
		Tcorr_nm.setText(corr_look.corr_nm);
		Tcorr_nm.setEnabled(false);
		Tcorr_nm.setPreferredSize(new Dimension(100, 30));
		Tpur_dt = new JTextField(18);
		Tpur_dt.setPreferredSize(new Dimension(100, 30));
		Ttot_pr = new JTextField(18);
		Ttot_pr.setPreferredSize(new Dimension(100, 30));

		Bregist = new JButton("등록");
		Bregist.addActionListener(this);
		Bregist.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		Bregist.setBackground(Color.WHITE);

		Bcancel = new JButton("취소");
		Bcancel.addActionListener(this);
		Bcancel.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
		Bcancel.setBackground(Color.WHITE);

//         getDeptData(EmpData.selectDept());
//         getSvpData(EmpData.selectSpv());
//         setExtendedState(MAXIMIZED_BOTH);
		EmpRegisterView();
	}

	private void EmpRegisterView() {

		setTitle("구매등록");

		gridbagconstraints.anchor = GridBagConstraints.WEST;
//         gridbagconstraints.ipadx = 7;
//         
//         gridbagconstraints.weightx=1.0;
//         gridbagconstraints.weighty=1.0;

		setLayout(gridbaglayout);
		gridbagconstraints.anchor = GridBagConstraints.CENTER;
//         gridbagAdd(bus_man, 1, 0, 1, 1);
//         gridbagAdd(pro_man, 2, 0, 1, 1);
//         gridbagAdd(od_man, 3, 0, 1, 1);
//         gridbagAdd(mb_man, 4, 0, 1, 1);
//         gridbagAdd(emp_man, 5, 0, 1, 1);
		gridbagAdd(Bregist, 0, 5, 1, 1);
		gridbagAdd(Bcancel, 1, 5, 1, 1);
		gridbagAdd(pur_regist, 0, 0, 2, 1);

		gridbagconstraints.anchor = GridBagConstraints.WEST;
//       gridbagAdd(pur_regist, 0, 2, 1, 1);
//       gridbagAdd(pur_lookup, 0, 1, 1, 1);

		gridbagAdd(Lcorr_nm, 0, 1, 1, 1);
		gridbagAdd(Lpur_dt, 0, 3, 1, 1);
		gridbagAdd(Ltot_pr, 0, 4, 1, 1);

		gridbagAdd(Tcorr_nm, 1, 1, 1, 1);
		gridbagAdd(Tpur_dt, 1, 3, 1, 1);
		gridbagAdd(Ttot_pr, 1, 4, 1, 1);

		gridbagconstraints.anchor = GridBagConstraints.EAST;

		pack();
		setResizable(true);
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

	public static void regist_pur() {
		pur_dt = pur_brkdwn_regist.S_pur_dt;
		tot_pr = pur_brkdwn_regist.tot_pr2;
		corr_num = pur_brkdwn_regist.corr_num;
		
		purData.initpurData(corr_num, pur_dt, tot_pr);
		purData.createpur();
		
		getData(purData.searchSEQ());
		System.out.println(pur_num);
	}

	public static void main(String[] args) {
		new pur_regist(new JFrame());
	}

	static void getData(List<Map<String, Serializable>> purListData) {
		pur_num = (String) purListData.get(0).get("PUR_NUM");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Bcancel) {
			dispose();
		} else if (e.getSource() == Bregist) {

			int result = JOptionPane.showConfirmDialog(null, "해당 구매를 등록하시겠습니까?", "구매 등록 확인", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (result == 0) {
				// 변수에 콤보박스 값 저장
				corr_num = corr_look.corr_num;
				corr_nm = Tcorr_nm.getText();
				pur_dt = pur_brkdwn_regist.S_pur_dt;
				tot_pr = Integer.parseInt(Ttot_pr.getText());

				if (pur_dt.equals("") || tot_pr == 0) {
					JOptionPane.showMessageDialog(null, "입력되지 않은 항목이 있습니다.", "오류", JOptionPane.ERROR_MESSAGE);
				} else {

					purData.initpurData(corr_num, pur_dt, tot_pr);
					purData.createpur();

					getData(purData.searchSEQ());
					pur_num = "";
					pur_num += (String) pur_info.getValueAt(0, 0);

					JOptionPane.showMessageDialog(null, "구매가 등록되었습니다.", "구매 등록", JOptionPane.INFORMATION_MESSAGE);
					Tpur_dt.setText("");
					Ttot_pr.setText("");
					pur_list.getData(purData.selectpur(corr_look.corr_num));
					dispose();
				}
			} else if (result == 1) {
				JOptionPane.getRootFrame().dispose();
			}

		}
	}
}