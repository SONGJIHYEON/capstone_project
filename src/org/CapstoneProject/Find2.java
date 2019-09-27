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

public class Find2 extends JFrame implements ActionListener {
	private JLabel vFindId, vNm, vphoneNum, vId;
	private JTextField xNm, xphoneNum, xId;
	private JButton BtId, BtPwd, BtLogin;
//	private JComboBox<String> CbEmail;

	String id, name, phone, find_pwd, find_pwd2;
	int intfind_pwd;

	GridBagLayout gbl;
	GridBagConstraints gbc;

	private void getData(List<Map<String, Serializable>> findListData) {
		find_pwd = "";
		find_pwd += findListData.get(0).get("COUNT(PWD)");
		intfind_pwd = Integer.parseInt(find_pwd);

		if (intfind_pwd == 0) {
			JOptionPane.showMessageDialog(null, "입력한 정보와 일치하는 비밀번호가 없습니다", "", JOptionPane.INFORMATION_MESSAGE);
			xId.setText("");
			xNm.setText("");
			xphoneNum.setText("");
			return;
		} else {
			getData2(FindData.findpwd2(id, name, phone));
			JOptionPane.showMessageDialog(null, "고객님의 비밀번호는 " + find_pwd2 + " 입니다. 로그인 하시고 비밀번호를 변경하시길 바랍니다.", "",
					JOptionPane.INFORMATION_MESSAGE);
			xId.setText("");
			xNm.setText("");
			xphoneNum.setText("");
			return;

		}
	}

	private void getData2(List<Map<String, Serializable>> findListData) {

		find_pwd2 = "";
		find_pwd2 += findListData.get(0).get("PWD");

	}

	public Find2(JFrame fr) {
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();

		vFindId = new JLabel("비밀번호 찾기");

		vId = new JLabel("아이디");
		xId = new JTextField(20);

		vNm = new JLabel("이름");
		xNm = new JTextField(20);

		vphoneNum = new JLabel("휴대폰번호");
		xphoneNum = new JTextField(20);

		BtId = new JButton("ID 찾기");
		BtId.addActionListener(this);
		BtPwd = new JButton("비밀번호 찾기");
		BtPwd.addActionListener(this);

		BtLogin = new JButton("로그인 하기");
		BtLogin.setPreferredSize(new Dimension(205, 28));
		BtLogin.addActionListener(this);

		Find2View();
	}

	private void Find2View() {
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("ID 찾기");

		setLayout(gbl);

		gridbagAdd(vFindId, 1, 0, 2, 1);
		gridbagAdd(vId, 0, 1, 1, 1);
		gridbagAdd(xId, 1, 1, 2, 1);
		gridbagAdd(vNm, 0, 2, 1, 1);
		gridbagAdd(xNm, 1, 2, 2, 1);
		gridbagAdd(vphoneNum, 0, 3, 1, 1);
		gridbagAdd(xphoneNum, 1, 3, 2, 1);

		gbc.anchor = GridBagConstraints.WEST;

		gbc.anchor = GridBagConstraints.EAST;
		gridbagAdd(BtId, 1, 4, 1, 1);
		gridbagAdd(BtPwd, 2, 4, 1, 1);
		gridbagAdd(BtLogin, 1, 5, 2, 1);

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
		new Find2(new JFrame());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == BtId) {
			new Find(new JFrame());
			dispose();
		}
		if(e.getSource() == BtPwd) {
			id = "";
			id = xId.getText();
			name = "";
			name = xNm.getText();
			phone = "";
			phone = xphoneNum.getText();
			getData(FindData.findpwd(id, name, phone));
		}
		if(e.getSource() == BtLogin) {
			new Login();
		}
	}
		
}