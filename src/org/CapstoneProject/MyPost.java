package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.MouseEvent;

public class MyPost extends JFrame implements ActionListener {

	private JLabel vPost;

	private JTextField Tsearch;

	private String[] col1 = {"게시판구분 ", "게시글제목 ", "상품명", "유형", "작성일시"};
	private String[] search = {"제목", "작성일자" };
	
	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);

	private JTable post_info;
	private JScrollPane scrollpane1;

	private JButton Bsearch, BtCancel, BtConfirm;

	private JComboBox<String> cbSearch;

	private ArrayList<String> ar = new ArrayList<String>();
	String user_id;
	int close;

	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints; // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할.

	public MyPost() {
//		super(fr, "", true);
		user_id = Login.user_id;
		
		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();
		
		vPost = new JLabel("게시글 관리");
		vPost.setFont(new Font("휴먼매직체", Font.BOLD, 20));

		Tsearch = new JTextField(15);
		Tsearch.addActionListener(this);
		Tsearch.setPreferredSize(new Dimension(100, 30));
		
		cbSearch = new JComboBox<String>(search);
		cbSearch.setPreferredSize(new Dimension(80, 30));

		post_info = new JTable(model1);
		scrollpane1 = new JScrollPane(post_info);
		scrollpane1.setPreferredSize(new Dimension(600, 150));

		Bsearch = new JButton("검색");
		Bsearch.addActionListener(this);
		Bsearch.setPreferredSize(new Dimension(80, 30));

//		BtCancel = new JButton("닫기");
//		BtCancel.addActionListener(this);
//		BtConfirm = new JButton("확인");
//		BtConfirm.addActionListener(this);

		getData(PostData.selectPost(user_id));
//         getSvpData(EmpData.selectSpv());

		addressView();
	}

	private void getData(List<Map<String, Serializable>> addrListData) {
		
		for (int i = 0; i < addrListData.size(); i++) {
			ar.add(addrListData.get(i).get("WRT_DATE").toString());
			
//			String oldstring = ex_st_date;
			
			Date date = null;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(ar.get(i));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
			String new_wrt_date = new SimpleDateFormat("yyyy-MM-dd").format(date);
			
			model1.addRow(new Object[] {

					addrListData.get(i).get("POST_BRD_TP"),
					addrListData.get(i).get("POST_MSG_TIT"),
					addrListData.get(i).get("POST_MSG_TY"), 
					new_wrt_date,
			});
		}
	}

	private void addressView() {
//		setTitle("주소검색");

		gridbagconstraints.anchor = GridBagConstraints.WEST;
		gridbagAdd(vPost, 0, 0, 1, 1);
		
//         gridbagconstraints.ipadx = 7;        
//         gridbagconstraints.weightx=1.0;
//         gridbagconstraints.weighty=1.0;

		setLayout(gridbaglayout);
		gridbagconstraints.anchor = GridBagConstraints.CENTER;
		
		gridbagAdd(cbSearch, 0, 1, 1, 1);
		gridbagAdd(Tsearch, 1, 1, 1, 1);
		gridbagAdd(scrollpane1, 0, 2, 3, 3);

		gridbagconstraints.anchor = GridBagConstraints.WEST;

		gridbagAdd(Bsearch, 2, 1, 1, 1);

		gridbagconstraints.anchor = GridBagConstraints.EAST;

//		pack();
//         setResizable(false);
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
		new MyPost();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Bsearch) {
			String search = Tsearch.getText();
			if (cbSearch.getSelectedItem() == "상품명") {
//				model1.setRowCount(0);
//				getData(empData.searchEmp1(search));
			}
//				else if (cbSearch.getSelectedItem() == "휴대폰번호") {
//				model1.setRowCount(0);
//				getData(empData.searchEmp2(search));
//			}
		}if(e.getSource() == BtCancel) {
//			dispose();
		}

	}
}