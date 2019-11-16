package org.CapstoneProject;

import java.awt.BorderLayout;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Review_write extends Dialog implements ActionListener, MouseListener {

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	private JLabel vTitle, vContent, vSpace1, vSpace2, vWriter, vDate, vPronm, vReviewPoint;
	private JTextField tTitle, tWriter, tDate, tPronm;
	private JTextArea tContent;
	private JScrollPane Scroll;
	private JComboBox<String> ReviewPoint;

	private String[] SReviewPoint = { "5", "4", "3", "2", "1" };
	private JButton bRegist, bCancel;

	JPanel pButton;
	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints;

	static String pro_num, pro_nm;

	public Review_write(JFrame fr) {

		super(fr, "", true);

		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();

		vTitle = new JLabel("제목");
		vTitle.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		vTitle.setPreferredSize(new Dimension(100, 40));
		vContent = new JLabel("내용");
		vContent.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		vContent.setPreferredSize(new Dimension(100, 40));
		vWriter = new JLabel("작성자");
		vWriter.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		vWriter.setPreferredSize(new Dimension(100, 40));
		vDate = new JLabel("작성일");
		vDate.setHorizontalAlignment(JLabel.CENTER);
		vDate.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		vDate.setPreferredSize(new Dimension(100, 40));
		vReviewPoint = new JLabel("평점");
		vReviewPoint.setHorizontalAlignment(JLabel.CENTER);
		vReviewPoint.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		vReviewPoint.setPreferredSize(new Dimension(100, 40));
		vPronm = new JLabel("후기상품");
		vPronm.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		vPronm.setPreferredSize(new Dimension(100, 40));

		vSpace1 = new JLabel("");
		vSpace1.setPreferredSize(new Dimension(100, 20));
		vSpace2 = new JLabel("");
		vSpace2.setPreferredSize(new Dimension(100, 20));

		tTitle = new JTextField(20);
		tTitle.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		tWriter = new JTextField(6);
		tWriter.setText(Login.user_nm);
		tWriter.setHorizontalAlignment(JTextField.CENTER);
		tWriter.setFont(new Font("휴먼매직체", Font.PLAIN, 20));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
		String strToday = sdf.format(c1.getTime());

		tDate = new JTextField(7);
		tDate.setText(strToday);
		tDate.setHorizontalAlignment(JTextField.CENTER);
		tDate.setFont(new Font("휴먼매직체", Font.PLAIN, 20));

		tPronm = new JTextField(6);
		tPronm.setHorizontalAlignment(JTextField.CENTER);
		tPronm.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		tPronm.setPreferredSize(new Dimension(200, 25));
		tPronm.setText(Od_brkdwn_user.pro_num);

		tContent = new JTextArea(15, 20);
		tContent.setLineWrap(true);
		tContent.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		Scroll = new JScrollPane(tContent);

		bRegist = new JButton("등록");
		bRegist.addActionListener(this);
		bRegist.setFocusPainted(false);
		bRegist.setBackground(Color.white);
		bRegist.setPreferredSize(new Dimension(80, 30));
		bRegist.setFont(new Font("휴먼매직체", Font.BOLD, 17));

		bCancel = new JButton("취소");
		bCancel.addActionListener(this);
		bCancel.setFocusPainted(false);
		bCancel.setBackground(Color.white);
		bCancel.setPreferredSize(new Dimension(80, 30));
		bCancel.setFont(new Font("휴먼매직체", Font.BOLD, 17));

		pButton = new JPanel();
		pButton.add(bRegist);
		pButton.add(bCancel);

		ReviewPoint = new JComboBox<String>(SReviewPoint);
		ReviewPoint.setPreferredSize(new Dimension(120, 20));
		ReviewPoint.addActionListener(this);

		tTitle.setBorder(new LineBorder(Color.black));
		tWriter.setBorder(new LineBorder(Color.black));
		tDate.setBorder(new LineBorder(Color.black));
		tContent.setBorder(new LineBorder(Color.black));
		tPronm.setBorder(new LineBorder(Color.black));
		bRegist.setBorder(new LineBorder(Color.black));
		bCancel.setBorder(new LineBorder(Color.black));

		tTitle.setOpaque(false);
		tWriter.setOpaque(false);
		tDate.setOpaque(false);
		tPronm.setOpaque(false);
		tContent.setOpaque(false);

		Review_writeView();
	}

	private void Review_writeView() {

		setTitle("후기글쓰기");

		setLayout(gridbaglayout);

		gridbagconstraints.anchor = GridBagConstraints.WEST;
		gridbagAdd(vTitle, 0, 0, 1, 1);
		gridbagAdd(tTitle, 1, 0, 3, 1);

		gridbagAdd(vWriter, 0, 2, 1, 1);
		gridbagAdd(tWriter, 1, 2, 1, 1);
		gridbagAdd(vDate, 2, 2, 1, 1);
		gridbagAdd(tDate, 3, 2, 1, 1);

		gridbagAdd(vPronm, 0, 3, 1, 1);
		gridbagAdd(tPronm, 1, 3, 1, 1);
		gridbagAdd(vReviewPoint, 2, 3, 1, 1);
		gridbagAdd(ReviewPoint, 3, 3, 1, 1);

		gridbagAdd(vContent, 0, 5, 1, 1);
		gridbagAdd(Scroll, 1, 5, 3, 1);

		gridbagconstraints.anchor = GridBagConstraints.CENTER;
		gridbagAdd(vSpace1, 0, 1, 1, 1);
		gridbagAdd(vSpace2, 0, 3, 1, 1);

		gridbagconstraints.anchor = GridBagConstraints.EAST;
		gridbagAdd(pButton, 0, 6, 3, 1);

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
		new Review_write(new JFrame());
	}

	static void getData(List<Map<String, Serializable>> ReviewListData) {
		pro_num = (String) ReviewListData.get(0).get("pro_num");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == bCancel) {
			dispose();
		} else if (e.getSource() == bRegist) {
			String writer = Login.user_nm;
			String point;
			String od_num = Od_brkdwn_user.od_num;
			pro_nm = tPronm.getText();
		    getData(ReviewData.searchpronum());
			System.out.println(pro_num);
			int result = JOptionPane.showConfirmDialog(null, "후기를 등록하시겠습니까?", "후기 등록 확인", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (result == 0) {
				if (tTitle.getText().equals(null) || tContent.getText().equals(null)) {
					JOptionPane.showMessageDialog(null, "미입력 항목이 있습니다.", "항목 미입력", JOptionPane.ERROR_MESSAGE);
				} else {
					point = ReviewPoint.getSelectedItem().toString();
					ReviewData.createR(tTitle.getText(), tContent.getText(), od_num, pro_num, writer, point);
					JOptionPane.showMessageDialog(null, "후기가 등록되었습니다.", "후기 등록", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
			} else {
				JOptionPane.getRootFrame().dispose();
			}

		}

	}
}
