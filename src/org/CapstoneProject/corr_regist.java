package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class corr_regist extends Dialog implements ActionListener {

	private JLabel vMemAddr1, vMemAddr2, vMemAddr3, corr_regist2, Lcorr_nm, Lcorr_prnm, Lcorr_ph, Lcorr_addr, back_img;
	private JTextField xMemAddr1, xMemAddr2, xMemAddr3, Tcorr_nm, Tcorr_prnm, Tcorr_ph, Tcorr_addr;

	private JButton BtSearchAddr, Bregist, Bcancel;

	String bus_num, bus_nm, rep_nm, bus_tel, addr;

	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints; // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할

	public corr_regist(JFrame fr) {
		super(fr, "", true);
		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();

		corr_regist2 = new JLabel("거래처등록");
		corr_regist2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		corr_regist2.setHorizontalAlignment(JLabel.CENTER);
		corr_regist2.setPreferredSize(new Dimension(100, 30));

		Lcorr_nm = new JLabel("업체명");
		Lcorr_nm.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		Lcorr_nm.setHorizontalAlignment(JLabel.CENTER);
		Lcorr_nm.setPreferredSize(new Dimension(100, 30));
		Lcorr_prnm = new JLabel("대표명");
		Lcorr_prnm.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		Lcorr_prnm.setHorizontalAlignment(JLabel.CENTER);
		Lcorr_prnm.setPreferredSize(new Dimension(100, 30));
		Lcorr_ph = new JLabel("연락처");
		Lcorr_ph.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		Lcorr_ph.setHorizontalAlignment(JLabel.CENTER);
		Lcorr_ph.setPreferredSize(new Dimension(100, 30));
		Lcorr_addr = new JLabel("주소");
		Lcorr_addr.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		Lcorr_addr.setHorizontalAlignment(JLabel.CENTER);
		Lcorr_addr.setPreferredSize(new Dimension(100, 30));

		Tcorr_nm = new JTextField(18);
		Tcorr_nm.setPreferredSize(new Dimension(100, 30));
//		Tcorr_nm.setHorizontalAlignment(SwingConstants.CENTER);
		Tcorr_prnm = new JTextField(18);
		Tcorr_prnm.setPreferredSize(new Dimension(100, 30));
		Tcorr_ph = new JTextField(18);
		Tcorr_ph.setPreferredSize(new Dimension(100, 30));
		Tcorr_addr = new JTextField(18);
		Tcorr_addr.setPreferredSize(new Dimension(100, 30));

		vMemAddr1 = new JLabel("주소");
		vMemAddr1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		vMemAddr1.setHorizontalAlignment(JLabel.CENTER);
		vMemAddr1.setPreferredSize(new Dimension(100, 30));
		xMemAddr1 = new JTextField(18);
		xMemAddr1.setPreferredSize(new Dimension(100, 30));

		BtSearchAddr = new JButton("우편번호 검색");
		BtSearchAddr.setBackground(Color.WHITE);
		BtSearchAddr.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		BtSearchAddr.setPreferredSize(new Dimension(150, 30));
		BtSearchAddr.addActionListener(this);

		vMemAddr2 = new JLabel("기본주소");
		vMemAddr2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		vMemAddr2.setHorizontalAlignment(JLabel.CENTER);
		vMemAddr2.setPreferredSize(new Dimension(100, 30));
		vMemAddr3 = new JLabel("상세주소");
		vMemAddr3.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		vMemAddr3.setHorizontalAlignment(JLabel.CENTER);
		vMemAddr3.setPreferredSize(new Dimension(100, 30));
		xMemAddr2 = new JTextField(18);
		xMemAddr2.setPreferredSize(new Dimension(100, 30));
		xMemAddr3 = new JTextField(18);
		xMemAddr3.setPreferredSize(new Dimension(100, 30));

		Bregist = new JButton("등록");
		Bregist.setBackground(Color.WHITE);
		Bregist.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		Bregist.setPreferredSize(new Dimension(80, 30));
		Bregist.addActionListener(this);

		Bcancel = new JButton("취소");
		Bcancel.setBackground(Color.WHITE);
		Bcancel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		Bcancel.setPreferredSize(new Dimension(80, 30));
		Bcancel.addActionListener(this);
		
//		back_img = new JLabel("");
//		back_img = manager_main.img_back;
//		back_img.setSize(600, 400);
//		back_img.setBounds(0, 0, 300, 400);
//		back_img.setOpaque(false);

		EmpRegisterView();
	}

	private void EmpRegisterView() {

		gridbagconstraints.anchor = GridBagConstraints.WEST;
//         gridbagconstraints.ipadx = 7;
//         
//         gridbagconstraints.weightx=1.0;
//         gridbagconstraints.weighty=1.0;

		setLayout(gridbaglayout);
		gridbagAdd(Bregist, 2, 9, 1, 1);
		
		gridbagconstraints.anchor = GridBagConstraints.CENTER;

		gridbagAdd(corr_regist2, 1, 1, 1, 1);
		gridbagAdd(Lcorr_nm, 1, 3, 1, 1);
		gridbagAdd(Lcorr_prnm, 1, 4, 1, 1);
		gridbagAdd(Lcorr_ph, 1, 5, 1, 1);
		gridbagAdd(vMemAddr1, 1, 6, 1, 1);
		gridbagAdd(vMemAddr2, 1, 7, 1, 1);
		gridbagAdd(vMemAddr3, 1, 8, 1, 1);

		gridbagAdd(Tcorr_nm, 2, 3, 1, 1);
		gridbagAdd(Tcorr_prnm, 2, 4, 1, 1);
		gridbagAdd(Tcorr_ph, 2, 5, 1, 1);
		gridbagAdd(xMemAddr1, 2, 6, 1, 1);
		gridbagAdd(xMemAddr2, 2, 7, 1, 1);
		gridbagAdd(xMemAddr3, 2, 8, 1, 1);

		gridbagAdd(BtSearchAddr, 3, 6, 1, 1);
//		gridbagAdd(back_img, 0, 0, 4, 10);

		gridbagconstraints.anchor = GridBagConstraints.EAST;
		gridbagAdd(Bcancel, 2, 9, 1, 1);

		pack();
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

	public static void main(String[] args) {
		new corr_regist(new JFrame());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Bregist) {

			int result = JOptionPane.showConfirmDialog(null, "해당 거래처를 등록하시겠습니까?", "거래처 등록 확인",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (result == 0) {
				// 변수에 콤보박스 값 저장
				bus_nm = Tcorr_nm.getText();
				rep_nm = Tcorr_prnm.getText();
				bus_tel = Tcorr_ph.getText();
				addr = xMemAddr2.getText() + " " + xMemAddr3.getText();

				if (bus_nm.equals("") || rep_nm.equals("") || bus_tel.equals("") || addr.equals("")) {
					JOptionPane.showMessageDialog(null, "입력되지 않은 항목이 있습니다.", "오류", JOptionPane.ERROR_MESSAGE);
				} else {

					corrData.initcorrData(bus_nm, rep_nm, bus_tel, addr);
					corrData.createcorr();
					JOptionPane.showMessageDialog(null, "거래처가 등록되었습니다.", "거래처 등록", JOptionPane.INFORMATION_MESSAGE);
					Tcorr_nm.setText("");
					Tcorr_prnm.setText("");
					Tcorr_ph.setText("");
					Tcorr_addr.setText("");
					xMemAddr1.setText("");
					xMemAddr2.setText("");
					xMemAddr3.setText("");
					
				}

			} else if (result == 1) {
				JOptionPane.getRootFrame().dispose();
			}
		} else if (e.getSource() == BtSearchAddr) {
			Address s = new Address(new JFrame());
			xMemAddr1.setText(s.zipcode);
			xMemAddr2.setText(s.addr);
		} else if (e.getSource() == Bcancel) {
			dispose();
		}
	}
}