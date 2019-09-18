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
			JOptionPane.showMessageDialog(null, "�Է��� ������ ��ġ�ϴ� ��й�ȣ�� �����ϴ�", "", JOptionPane.INFORMATION_MESSAGE);
			xId.setText("");
			xNm.setText("");
			xphoneNum.setText("");
			return;
		} else {
			getData2(FindData.findpwd2(id, name, phone));
			JOptionPane.showMessageDialog(null, "������ ��й�ȣ�� " + find_pwd2 + " �Դϴ�. �α��� �Ͻð� ��й�ȣ�� �����Ͻñ� �ٶ��ϴ�.", "",
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

		vFindId = new JLabel("��й�ȣ ã��");

		vId = new JLabel("���̵�");
		xId = new JTextField(20);

		vNm = new JLabel("�̸�");
		xNm = new JTextField(20);

		vphoneNum = new JLabel("�޴�����ȣ");
		xphoneNum = new JTextField(20);

		BtId = new JButton("ID ã��");
		BtId.addActionListener(this);
		BtPwd = new JButton("��й�ȣ ã��");
		BtPwd.addActionListener(this);

		BtLogin = new JButton("�α��� �ϱ�");
		BtLogin.setPreferredSize(new Dimension(205, 28));
		BtLogin.addActionListener(this);

		Find2View();
	}

	private void Find2View() {
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("ID ã��");

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
		// ���� ���� �� gridx, gridy���� 0

		gbc.gridwidth = w;
		gbc.gridheight = h;

		gbl.setConstraints(c, gbc); // ������Ʈ�� ������Ʈ ��ġ+ũ�� ������ ���� GridBagLayout�� ��ġ

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
