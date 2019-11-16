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
import java.util.Calendar;
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

public class Review_view extends Dialog implements ActionListener, MouseListener {
	
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	   
	private JLabel vTitle, vContent, vSpace1, vSpace2, vWriter, vDate, vPronm, vReviewPoint, ReviewPoint;
	private JTextField tTitle, tWriter, tDate, tPronm;
	private JTextArea tContent;
	private JScrollPane Scroll;
	
	private JButton  bClose;
	
	String sTitle, sWriter, sDate, sContent, sPronm, sReviewPoint;
	
	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints;
	
	public Review_view(JFrame fr) {
		
        super(fr, "", true);
        
		getData(ReviewData.infoR(Review_user.POST_NUM));
		
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
		ReviewPoint = new JLabel(sReviewPoint);
		vPronm.setFont(new Font("휴먼매직체", Font.BOLD, 20));
		vPronm.setPreferredSize(new Dimension(100, 40));
		vSpace1 = new JLabel("");
		vSpace1.setPreferredSize(new Dimension(100, 20));
		vSpace2 = new JLabel("");
		vSpace2.setPreferredSize(new Dimension(100, 20));

		tTitle = new JTextField(20);
		tTitle.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		tWriter = new JTextField(6);
		tWriter.setHorizontalAlignment(JTextField.CENTER);
		tWriter.setFont(new Font("휴먼매직체", Font.PLAIN, 20));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
		String strToday = sdf.format(c1.getTime());

		tDate = new JTextField(7);
		tDate.setHorizontalAlignment(JTextField.CENTER);
		tDate.setFont(new Font("휴먼매직체", Font.PLAIN, 20));

		tPronm = new JTextField(6);
		tPronm.setHorizontalAlignment(JTextField.CENTER);
		tPronm.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		tPronm.setPreferredSize(new Dimension(200, 25));

		tContent = new JTextArea(15, 20);
		tContent.setLineWrap(true);
		tContent.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		Scroll = new JScrollPane(tContent);

		tTitle.setBorder(new LineBorder(Color.black));
		tWriter.setBorder(new LineBorder(Color.black));
		tDate.setBorder(new LineBorder(Color.black));
		tContent.setBorder(new LineBorder(Color.black));
		tPronm.setBorder(new LineBorder(Color.black));

		tTitle.setOpaque(false);
		tWriter.setOpaque(false);
		tDate.setOpaque(false);
		tPronm.setOpaque(false);
		tContent.setOpaque(false);
		
		bClose = new JButton("닫기");
		bClose.addActionListener(this);
		bClose.setFocusPainted(false);
		bClose.setBackground(Color.white);
		bClose.setPreferredSize(new Dimension(80,30));
		bClose.setFont(new Font("휴먼매직체", Font.BOLD , 17));

		tTitle.setEnabled(false);
		tWriter.setEnabled(false);
		tDate.setEnabled(false);
		tContent.setEnabled(false);
		tPronm.setEnabled(false);
		
		tTitle.setText(sTitle);
		tWriter.setText(sWriter);
		tDate.setText(sDate);
		tContent.setText(sContent);
		tPronm.setText(sPronm);
		
		tTitle.setForeground(Color.BLACK);
		tWriter.setForeground(Color.BLACK);
		tDate.setForeground(Color.BLACK);
		tContent.setForeground(Color.BLACK);
		
		tTitle.setBorder(new LineBorder(Color.black));
		tWriter.setBorder(new LineBorder(Color.black));
		tDate.setBorder(new LineBorder(Color.black));
		tContent.setBorder(new LineBorder(Color.black));
		bClose.setBorder(new LineBorder(Color.black));

		home_adminView();
	}
	
	private void home_adminView() {

		setTitle("상품후기");
		
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

		gridbagAdd(bClose, 0, 6, 4, 1);
	    
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
		new Review_view(new JFrame());
	}
	
	private void getData(List<Map<String, Serializable>> ReviewListData) {
		
		Date date = null;

		sTitle = (String) ReviewListData.get(0).get("POST_MSG_TIT");
		sWriter = (String) ReviewListData.get(0).get("WRITER_NM");
		String s2Date = (String) ReviewListData.get(0).get("WRT_DATE");
		sContent = (String) ReviewListData.get(0).get("POST_MSG_CON");
		sReviewPoint = (String) ReviewListData.get(0).get("PRO_REVIEW");
		sPronm = (String) ReviewListData.get(0).get("PRO_NM");
		
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(s2Date);
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
		if(e.getSource() == bClose) {
			dispose();
		}
		
	}   
}	