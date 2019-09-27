package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Find extends JFrame implements ActionListener {
	private JLabel vFindId, vNm, vPhoneNum;
	private JTextField xNm, xPhoneNum;
	private JButton BtId, BtPwd, BtLogin;
//   private JComboBox<String> CbEmail;

	String phone, name, phone2, name2, find_id, find_id2;
	int intfind_id;

	GridBagLayout gbl;
	GridBagConstraints gbc;

	private void getData(List<Map<String, Serializable>> findListData) {
		find_id = "";
		find_id += findListData.get(0).get("COUNT(ID)");
		intfind_id = Integer.parseInt(find_id);
		
		if (intfind_id == 0) {
			JOptionPane.showMessageDialog(null, "입력한 정보와 일치하는 ID가 없습니다", "", JOptionPane.INFORMATION_MESSAGE);
			xNm.setText("");
			xPhoneNum.setText("");
			return;
		} else {
			getData2(FindData.findid2(name, phone));
			JOptionPane.showMessageDialog(null, "고객님의 ID는 " + find_id2 + " 입니다.", "", JOptionPane.INFORMATION_MESSAGE);
			xNm.setText("");
			xPhoneNum.setText("");
			return;

		}
	}
	
	private void getData2(List<Map<String, Serializable>> findListData) {

		find_id2 = "";
		find_id2 += findListData.get(0).get("ID");
			
	}

	public Find(JFrame fr) {
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();

		vFindId = new JLabel("아이디 찾기");

		vNm = new JLabel("이름");
		xNm = new JTextField(20);

		vPhoneNum = new JLabel("휴대폰번호");
		xPhoneNum = new JTextField(20);

		BtId = new JButton("ID 찾기");
		BtId.addActionListener(this);
		BtPwd = new JButton("비밀번호 찾기");
		BtPwd.addActionListener(this);
		
		BtLogin = new JButton("로그인 하기");
		BtLogin.setPreferredSize(new Dimension(205, 28));
		BtLogin.addActionListener(this);

		FindView();
	}

	private void FindView() {
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("ID 찾기");

		setLayout(gbl);

		gridbagAdd(vFindId, 1, 0, 2, 1);
		gridbagAdd(vNm, 0, 1, 1, 1);
		gridbagAdd(xNm, 1, 1, 2, 1);
		gridbagAdd(vPhoneNum, 0, 2, 1, 1);
		gridbagAdd(xPhoneNum, 1, 2, 2, 1);

		gbc.anchor = GridBagConstraints.CENTER;

		gbc.anchor = GridBagConstraints.EAST;
		gridbagAdd(BtId, 1, 3, 1, 1);
		gridbagAdd(BtPwd, 2, 3, 1, 1);
		gridbagAdd(BtLogin, 1, 4, 2, 1);

		setVisible(true);
	}

	private void gridbagAdd(Component c, int x, int y, int w, int h) {

		gbc.gridx = x;
		gbc.gridy = y;
		// 가장 왼쪽 위 gridx, gridy값은 0

		gbc.gridwidth = w;
		gbc.gridheight = h;

		gbl.setConstraints(c, gbc); // 컴포넌트를 컴포넌트 위치+크기 정보에 따라 GridBagLayout에 배치

		add(c);

	}

	public static void main(String[] args) {
		new Find(new JFrame());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BtId) {
			name = "";
			name = xNm.getText();
			phone = "";
			phone = xPhoneNum.getText();
			getData(FindData.findid(name, phone));

		}
		if (e.getSource() == BtPwd) {
			new Find2(new JFrame());
			dispose();
		}
		if(e.getSource() == BtLogin) {
			new Login();
		}

	}
}