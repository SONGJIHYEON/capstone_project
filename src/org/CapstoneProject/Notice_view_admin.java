package org.CapstoneProject;

import java.awt.BorderLayout;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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

public class Notice_view_admin extends Dialog implements ActionListener, MouseListener {

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	private JLabel vTitle, vContent, vSpace1, vSpace2, vWriter, vDate;
	private JTextField tTitle, tWriter, tDate;
	private JTextArea tContent;
	private JScrollPane Scroll;

	private JButton bModi, bClose;

	static String POST_NUM;
	String sTitle, sWriter, sDate, sContent;

	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints;

	public Notice_view_admin(JFrame fr) {

		super(fr, "", true);

		getData(NoticeData.infoN(Notice_admin.POST_NUM));

		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();

		POST_NUM = Notice_admin.POST_NUM;

		vTitle = new JLabel("제목");
		vTitle.setHorizontalAlignment(JLabel.CENTER);
		vTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		vTitle.setPreferredSize(new Dimension(100, 40));

		vContent = new JLabel("내용");
		vContent.setHorizontalAlignment(JLabel.CENTER);
		vContent.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		vContent.setPreferredSize(new Dimension(100, 40));

		vWriter = new JLabel("작성자");
		vWriter.setHorizontalAlignment(JLabel.CENTER);
		vWriter.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		vWriter.setPreferredSize(new Dimension(100, 40));

		vDate = new JLabel("작성일");
		vDate.setHorizontalAlignment(JLabel.CENTER);
		vDate.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		vDate.setPreferredSize(new Dimension(100, 40));

		vSpace1 = new JLabel("");
		vSpace1.setPreferredSize(new Dimension(100, 20));
		vSpace2 = new JLabel("");
		vSpace2.setPreferredSize(new Dimension(100, 20));

		tTitle = new JTextField(20);
		tTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		tWriter = new JTextField(5);
		tWriter.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		tDate = new JTextField(9);
		tDate.setFont(new Font("맑은 고딕", Font.PLAIN, 20));

		tContent = new JTextArea(15, 20);
		tContent.setLineWrap(true);
		tContent.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		Scroll = new JScrollPane(tContent);

		bModi = new JButton("수정");
		bModi.addActionListener(this);
		bModi.setFocusPainted(false);
		bModi.setBackground(Color.white);
		bModi.setPreferredSize(new Dimension(80, 30));
		bModi.setFont(new Font("맑은 고딕", Font.BOLD, 17));

		bClose = new JButton("닫기");
		bClose.addActionListener(this);
		bClose.setFocusPainted(false);
		bClose.setBackground(Color.white);
		bClose.setPreferredSize(new Dimension(80, 30));
		bClose.setFont(new Font("맑은 고딕", Font.BOLD, 17));

		tTitle.setEnabled(false);
		tWriter.setEnabled(false);
		tDate.setEnabled(false);
		tContent.setEnabled(false);

		tTitle.setBorder(new LineBorder(Color.black));
		tWriter.setBorder(new LineBorder(Color.black));
		tDate.setBorder(new LineBorder(Color.black));
		tContent.setBorder(new LineBorder(Color.black));
		bModi.setBorder(new LineBorder(Color.black));
		bClose.setBorder(new LineBorder(Color.black));
		
		System.out.println(sWriter);

		tTitle.setText(sTitle);
		tWriter.setText(sWriter);
		tDate.setText(sDate);
		tContent.setText(sContent);

		tTitle.setForeground(Color.BLACK);
		tWriter.setForeground(Color.BLACK);
		tDate.setForeground(Color.BLACK);
		tContent.setForeground(Color.BLACK);

		home_adminView();
	}

	private void home_adminView() {

		setTitle("공지사항 보기");

		setLayout(gridbaglayout);

		gridbagconstraints.anchor = GridBagConstraints.WEST;

		gridbagAdd(vTitle, 0, 0, 1, 1);
		gridbagAdd(tTitle, 1, 0, 3, 1);
		gridbagAdd(vWriter, 0, 2, 1, 1);
		gridbagAdd(tWriter, 1, 2, 1, 1);
		gridbagAdd(vDate, 2, 2, 1, 1);
		gridbagAdd(tDate, 3, 2, 1, 1);
		gridbagAdd(vContent, 0, 4, 1, 1);
		gridbagAdd(Scroll, 1, 4, 3, 1);
		gridbagAdd(bModi, 1, 5, 1, 1);

		gridbagconstraints.anchor = GridBagConstraints.CENTER;
		gridbagAdd(vSpace1, 0, 1, 1, 1);
		gridbagAdd(vSpace2, 0, 3, 1, 1);

		gridbagconstraints.anchor = GridBagConstraints.EAST;
		gridbagAdd(bClose, 3, 5, 1, 1);
		
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
		new Notice_view_admin(new JFrame());
	}

	private void getData(List<Map<String, Serializable>> NoticeListData) {

		sTitle = (String) NoticeListData.get(0).get("POST_MSG_TIT");
		sWriter = (String) NoticeListData.get(0).get("WRITER_NM");
		String sDate2 = (String) NoticeListData.get(0).get("WRT_DATE");
		sContent = (String) NoticeListData.get(0).get("POST_MSG_CON");

		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(sDate2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
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
		if (e.getSource() == bClose) {
			dispose();
		} else if (e.getSource() == bModi) {
			dispose();
			new Notice_modi(new JFrame());
		}

	}
}
