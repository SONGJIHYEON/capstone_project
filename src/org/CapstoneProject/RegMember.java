package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class RegMember extends Dialog implements ActionListener, MouseListener {
	private JLabel vMemId, vMemPw1, vMemPw2, vMemName, vMemBirth, vMemPhone, vMemEmail, vMemAddr1, vMemAddr2, vMemAddr3,
			vGol, vRegMember, vSpace;
	private JTextField xMemId, xMemName, xMemBirth, xMemPhone, xMemEmail1, xMemEmail2, xMemAddr1, xMemAddr2, xMemAddr3;
	private JPasswordField xMemPw1, xMemPw2;
	private String[] div = { "naver.com", "hanmail.com", "nate.com", "gmail.com", "직접입력" };
//      private String[] col1 = {"부서명", "부서위치"};      
//      private String[] col2 = {"부서명", "성명"};      
//      private String[] div = {"정규직", "임시직", "계약직"};      // 사원구분 콤보박스의 목록

//      private DefaultTableModel model1 = new DefaultTableModel(col1, 0);      
//      private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      

//      private JTable eDept, eSpv;      
//      private JScrollPane scrollpane1, scrollpane2;      

	private JButton BtCheckId, BtSearchAddr, BtRegist, BtCancel;
	private JComboBox CbEmail;

	JPanel Bt = new JPanel();

	String sid, sid2, ID, CUST_NM, PH_NUM, ADDR, BD, PWD, STdate;
//   static String STdate;
	int intid = 0;
	int check;
	GridBagLayout gbl;
	GridBagConstraints gbc;

	private void getData1(List<Map<String, Serializable>> idListData) {

		sid2 = "";
		sid2 += idListData.get(0).get("ID").toString();

		intid = Integer.parseInt(sid2);

		if (intid == 0) {
			JOptionPane.showMessageDialog(null, "사용가능한 아이디 입니다", "", JOptionPane.INFORMATION_MESSAGE);
			return;
		} else
			JOptionPane.showMessageDialog(null, "중복된 아이디 입니다", "", JOptionPane.INFORMATION_MESSAGE);
		xMemId.setText("");
		return;
	}

	public void getData2(List<Map<String, Serializable>> MbgraListData) {

//      SimpleDateFormat spdate = new SimpleDateFormat("yyyy-MM-dd");
//
//      STdate = "";
//      STdate += MbgraListData.get(0).get("DISC_APP_ST_DT");
//
//      String oldstring = STdate;
//      Date date = null;
//      try {
//         date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(oldstring);
//      } catch (ParseException e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//      }
//      String newstring = new SimpleDateFormat("yyyy-MM-dd").format(date);
//      System.out.println(newstring);

		CustData.initCustData(ID, PWD, CUST_NM, BD, PH_NUM, ADDR);
		CustData.createCust();
	}

	public RegMember(JFrame fr) {
		super(fr, "", true);

		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();

		vRegMember = new JLabel("회원가입");

		vMemId = new JLabel("아이디");
		vMemId.setPreferredSize(new Dimension(120, 40));
		vMemId.setHorizontalAlignment(JLabel.CENTER);
		vMemId.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		xMemId = new JTextField(22);
		xMemId.setPreferredSize(new Dimension(120, 30));

		BtCheckId = new JButton("중복확인");
		BtCheckId.addActionListener(this);
		BtCheckId.setPreferredSize(new Dimension(120, 30));
		BtCheckId.setFocusPainted(false);
		BtCheckId.setBackground(Color.white);

		BtCheckId.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		vMemPw1 = new JLabel("비밀번호");
		vMemPw1.setPreferredSize(new Dimension(120, 40));
		vMemPw1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		vMemPw1.setHorizontalAlignment(JLabel.CENTER);

		xMemPw1 = new JPasswordField(22);
		xMemPw1.setPreferredSize(new Dimension(120, 30));

		vMemPw2 = new JLabel("비밀번호 확인");
		vMemPw2.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		xMemPw2 = new JPasswordField(22);
		xMemPw2.setPreferredSize(new Dimension(120, 30));

		vMemName = new JLabel("이름");
		vMemName.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		vMemName.setHorizontalAlignment(JLabel.CENTER);
		vMemName.setPreferredSize(new Dimension(120, 40));

		xMemName = new JTextField(22);
		xMemName.setPreferredSize(new Dimension(120, 30));

		vMemBirth = new JLabel("생년월일");
		vMemBirth.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		vMemBirth.setHorizontalAlignment(JLabel.CENTER);
		vMemBirth.setPreferredSize(new Dimension(120, 40));

		xMemBirth = new JTextField(22);
		xMemBirth.setPreferredSize(new Dimension(120, 30));

		xMemBirth.setText("YYYYMMDD");
		xMemBirth.addMouseListener(this);

		vMemPhone = new JLabel("휴대폰 번호");
		vMemPhone.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		vMemPhone.setHorizontalAlignment(JLabel.CENTER);
		vMemPhone.setPreferredSize(new Dimension(120, 40));

		xMemPhone = new JTextField(22);
		xMemPhone.setPreferredSize(new Dimension(120, 30));

//      vMemEmail = new JLabel("이메일");
//      vMemEmail.setFont(new Font("맑은 고딕", Font.BOLD, 15));
//      vMemEmail.setHorizontalAlignment(JLabel.CENTER);
//      vMemEmail.setPreferredSize(new Dimension(120, 45));

//      vGol = new JLabel("@");
//      xMemEmail1 = new JTextField(10);
//      xMemEmail2 = new JTextField(10);
//      CbEmail = new JComboBox<String>(div);
//      CbEmail.addActionListener(this);

		vMemAddr1 = new JLabel("우편번호");
		vMemAddr1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		vMemAddr1.setHorizontalAlignment(JLabel.CENTER);
		vMemAddr1.setPreferredSize(new Dimension(120, 40));

		xMemAddr1 = new JTextField(22);
		xMemAddr1.setPreferredSize(new Dimension(120, 30));

		BtSearchAddr = new JButton("주소검색");
		BtSearchAddr.addActionListener(this);
		BtSearchAddr.setPreferredSize(new Dimension(120, 30));
		BtSearchAddr.setFocusPainted(false);
		BtSearchAddr.setBackground(Color.white);
		BtSearchAddr.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		vMemAddr2 = new JLabel("기본주소");
		vMemAddr2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		vMemAddr2.setHorizontalAlignment(JLabel.CENTER);
		vMemAddr2.setPreferredSize(new Dimension(120, 20));

		xMemAddr2 = new JTextField(22);
		xMemAddr2.setPreferredSize(new Dimension(120, 30));

		vMemAddr3 = new JLabel("상세주소");
		vMemAddr3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		vMemAddr3.setHorizontalAlignment(JLabel.CENTER);
		vMemAddr3.setPreferredSize(new Dimension(120, 20));

		xMemAddr3 = new JTextField(22);
		xMemAddr3.setPreferredSize(new Dimension(120, 30));

		BtRegist = new JButton("가입");
		BtRegist.addActionListener(this);
		BtRegist.setPreferredSize(new Dimension(65, 25));
		BtRegist.setFocusPainted(false);
		BtRegist.setBackground(Color.white);
		BtRegist.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		BtCancel = new JButton("취소");
		BtCancel.addActionListener(this);
		BtCancel.setPreferredSize(new Dimension(65, 25));
		BtCancel.setFocusPainted(false);
		BtCancel.setBackground(Color.white);
		BtCancel.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		Bt.add(BtRegist);
		Bt.add(BtCancel);

		RegMemberView();
	}

	private void RegMemberView() {

		setTitle("회원가입");

		setLayout(gbl);

		gbc.anchor = GridBagConstraints.CENTER;
		gridbagAdd(vMemId, 0, 0, 1, 1);
		gridbagAdd(xMemId, 1, 0, 3, 1);
		gridbagAdd(BtCheckId, 4, 0, 1, 1);
		gridbagAdd(vMemPw1, 0, 1, 1, 1);
		gridbagAdd(xMemPw1, 1, 1, 3, 1);
		gridbagAdd(vMemPw2, 0, 2, 1, 1);
		gridbagAdd(xMemPw2, 1, 2, 3, 1);
		gridbagAdd(vMemName, 0, 3, 1, 1);
		gridbagAdd(xMemName, 1, 3, 3, 1);
		gridbagAdd(vMemBirth, 0, 4, 1, 1);
		gridbagAdd(xMemBirth, 1, 4, 3, 1);
		gridbagAdd(vMemPhone, 0, 5, 1, 1);
//       gridbagAdd(vMemEmail, 0, 6, 1, 1);
		gridbagAdd(xMemPhone, 1, 5, 3, 1);
//       gridbagAdd(CbEmail, 4, 6, 1, 1);
		gridbagAdd(vMemAddr1, 0, 6, 1, 1);
		gridbagAdd(xMemAddr1, 1, 6, 3, 1);
		gridbagAdd(BtSearchAddr, 4, 6, 1, 1);
		gridbagAdd(vMemAddr2, 0, 7, 1, 1);
		gridbagAdd(vMemAddr3, 0, 8, 1, 1);
		gridbagAdd(xMemAddr2, 1, 7, 3, 1);
		gridbagAdd(xMemAddr3, 1, 8, 3, 1);
//       gridbagAdd(vGol, 2, 6, 1, 1);

		gbc.anchor = GridBagConstraints.WEST;
//       gridbagAdd(xMemEmail1, 1, 6, 1, 1);
		gridbagAdd(BtRegist, 1, 10, 1, 1);
		gbc.anchor = GridBagConstraints.EAST;
		gridbagAdd(BtCancel, 3, 10, 1, 1);
//       gridbagAdd(xMemEmail2, 3, 6, 1, 1);

		gbc.anchor = GridBagConstraints.CENTER;

//       gridbagAdd(scrollpane1, 0, 11, 2, 1);
//       gridbagAdd(scrollpane2, 2, 11, 2, 1);
//       gridbagAdd(regist, 0, 12, 1, 1);
//       gridbagAdd(cancel, 2, 12, 1, 1);
		
		pack();
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
		new RegMember(new JFrame());

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BtCheckId) {
			sid = "";
			sid += xMemId.getText();
			if (sid.equals("")) {
				JOptionPane.showMessageDialog(null, "ID를 입력해 주세요.", "ID미입력", JOptionPane.WARNING_MESSAGE);
			} else {
				CheckId.initCustData(sid);
				getData1(CheckId.selectid());
			}

		}

		String pw1 = new String(xMemPw1.getPassword());
		String pw2 = new String(xMemPw2.getPassword());
		System.out.println(xMemAddr2.getText() + " " + xMemAddr3.getText());
		if (e.getSource() == BtRegist) {
			if (!(pw1.equals(pw2))) {
				JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다", "오류", JOptionPane.ERROR_MESSAGE);
				return;
			} else
				check = JOptionPane.showConfirmDialog(null, "회원가입 하시겠습니까?", "등록 확인", JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
			if (check == 0) {
				ID = "";
				ID = xMemId.getText();
				PWD = "";
				PWD = new String(xMemPw1.getPassword());
				CUST_NM = "";
				CUST_NM = xMemName.getText();
				BD = "";
				BD = xMemBirth.getText();
				PH_NUM = "";
				PH_NUM = xMemPhone.getText();
				ADDR = "";
				ADDR = xMemAddr2.getText() + " " + xMemAddr3.getText();
				if (ID.equals("") || PWD.equals("") || CUST_NM.equals("") || BD.equals("") || PH_NUM.equals("")
						|| ADDR.equals("")) {
					JOptionPane.showMessageDialog(null, "입력되지 않은 항목이 있습니다.", "오류", JOptionPane.ERROR_MESSAGE);
				} else {
//               getData2(MbgraData.Mbgra());
					CustData.initCustData(ID, PWD, CUST_NM, BD, PH_NUM, ADDR);
					CustData.createCust();
					JOptionPane.showMessageDialog(null, "회원으로 가입되었습니다", "", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
			} else
				return;
		} else if (e.getSource() == BtSearchAddr) {
			Address s = new Address(new JFrame());
			xMemAddr1.setText(s.zipcode);
			xMemAddr2.setText(s.addr);
		} else if (e.getSource() == BtCancel) {
			dispose();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == xMemBirth) {
			xMemBirth.setText("");
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}