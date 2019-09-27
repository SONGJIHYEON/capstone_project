
package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class QnA_user extends JPanel implements ActionListener, MouseListener {

	static JPanel C_U = new JPanel();
	
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	   
	private JLabel vQnA;
	private JTextField Tsearch;

	private static String[] col1 = {"No", "유형", "제목", "작성자", "작성일"};  
	private String[] search = {"제목", "작성일"};                
	
	private static DefaultTableModel model1 = new DefaultTableModel(col1, 0){ 
		 public boolean isCellEditable(int row, int column){
			    return false;
			 }
			};
		         
	private JTable tQnA;
	private JScrollPane Scroll;
	
	private JButton  bWrite ,bSearch, bPrevious;
	private JComboBox<String> cbSearch;
	
	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints;
	
	static String POST_NUM;
	
	public QnA_user() {
		
		
		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints(); 
        
        vQnA = new JLabel("QnA");
        vQnA.setFont(new Font("휴먼매직체", Font.BOLD, 25));
        
        bWrite = new JButton("글쓰기");
        bWrite.setFocusPainted(false);
        bWrite.setForeground(Color.white);
        bWrite.setBackground(Color.black);
        bWrite.setPreferredSize(new Dimension(100,40));
        bWrite.addActionListener(this);
        bWrite.setFont(new Font("휴먼매직체", Font.BOLD, 22));
        
        bSearch = new JButton("검색");
        bSearch.setFocusPainted(false);
        bSearch.setBackground(Color.white);
        bSearch.setPreferredSize(new Dimension(80,40));
        bSearch.setFont(new Font("휴먼매직체", Font.BOLD , 22));
        
        bPrevious = new JButton("이전");
        bPrevious.setFocusPainted(false);
        bPrevious.setBackground(Color.white);
        bPrevious.setPreferredSize(new Dimension(80,40));
        bPrevious.addActionListener(this);
        bPrevious.setFont(new Font("휴먼매직체", Font.BOLD , 22));
        
        cbSearch = new JComboBox<String>(search);
        cbSearch.setFont(new Font("휴먼매직체", Font.PLAIN , 22));
        cbSearch.setPreferredSize(new Dimension(100,40));
        cbSearch.setBackground(Color.WHITE);
        
        Tsearch = new JTextField(15);
        Tsearch.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
        Tsearch.setPreferredSize(new Dimension(150,41));

		tQnA = new JTable(model1);
		tQnA.getColumnModel().getColumn(0).setPreferredWidth(100); 
		tQnA.getColumnModel().getColumn(1).setPreferredWidth(100);  
		tQnA.getColumnModel().getColumn(2).setPreferredWidth(600);
		tQnA.getColumnModel().getColumn(3).setPreferredWidth(100);
		tQnA.getColumnModel().getColumn(4).setPreferredWidth(100);
		tQnA.addMouseListener(this);
		Scroll = new JScrollPane(tQnA);
		Scroll.setPreferredSize(new Dimension(1000, 300));
		
		home_adminView();
	}
	
	private void home_adminView() {
		
		setLayout(gridbaglayout);
		

//		Home.setBorder(new LineBorder(new Color(0, 0, 0)));
//		Home.setHorizontalAlignment(SwingConstants.CENTER);
//		Home.setFont(new Font("휴먼매직체", Font.BOLD, 25));
//		Mn_Manage.setBorder(new LineBorder(new Color(0, 0, 0)));
//		Mn_Manage.setHorizontalAlignment(SwingConstants.CENTER);
//		Mn_Manage.setFont(new Font("휴먼매직체", Font.BOLD, 25));
//		Mn_Center.setBorder(new LineBorder(new Color(0, 0, 0)));
//		Mn_Center.setHorizontalAlignment(SwingConstants.CENTER);
//		Mn_Center.setFont(new Font("휴먼매직체", Font.BOLD, 25));
//		Mn_Basket.setBorder(new LineBorder(new Color(0, 0, 0)));
//		Mn_Basket.setHorizontalAlignment(SwingConstants.CENTER);
//		Mn_Basket.setFont(new Font("휴먼매직체", Font.BOLD, 25));
//		Mn_Mypage.setBorder(new LineBorder(new Color(0, 0, 0)));
//		Mn_Mypage.setHorizontalAlignment(SwingConstants.CENTER);
//		Mn_Mypage.setFont(new Font("휴먼매직체", Font.BOLD, 25));
//		Mn_Logout.setBorder(new LineBorder(new Color(0, 0, 0)));
//		Mn_Logout.setHorizontalAlignment(SwingConstants.CENTER);
//		Mn_Logout.setFont(new Font("휴먼매직체", Font.BOLD, 25));
		

		gridbagconstraints.anchor = GridBagConstraints.WEST;
		
		gridbagAdd(vQnA, 0, 0, 1, 1);
		gridbagAdd(cbSearch, 0, 1, 1, 1);
		gridbagAdd(Tsearch, 1, 1, 1, 1);
		gridbagAdd(bSearch, 2, 1, 1, 1);
		
	    gridbagAdd(Scroll, 0, 2, 3, 1);
	    
		gridbagconstraints.anchor = GridBagConstraints.CENTER;

		gridbagAdd(bPrevious, 0, 3, 3, 1);

		gridbagconstraints.anchor = GridBagConstraints.EAST;
		gridbagAdd(bWrite, 2, 1, 1, 1);

        getData(QnAData.selectQnA());
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
		new QnA_user();
	}
	
    static void getData(List<Map<String, Serializable>> QnAListData) {
    	  
    	model1.setNumRows(0);

	      for(int i=0; i < QnAListData.size(); i++) {
	    	  model1.addRow(new Object[] {
	               
	    			  QnAListData.get(i).get("POST_MSG_NUM"),
	    			  QnAListData.get(i).get("POST_MSG_TY"),
	    			  QnAListData.get(i).get("POST_MSG_TIT"),
	    			  QnAListData.get(i).get("WRITER_NM"),
	    			  QnAListData.get(i).get("WRT_DATE")

	         });
	      }


	   }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row;
		if(e.getSource() == tQnA) {
			row = tQnA.getSelectedRow();
			POST_NUM = "";
			POST_NUM += tQnA.getValueAt(row, 0);
		} 

		new QnA_view_user(new JFrame());
		
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
		if(e.getSource() == bPrevious) {
			
			Center_user.Q_U.removeAll();
			home_user.click = "Q";
			C_U = new Center_user();
			C_U.setBounds(0, 100, d.width, d.height - 100);
        	add(C_U);
        	repaint();
        	revalidate();
		} else	if(e.getSource() == bWrite) {
			
			new QnA_question_write(new JFrame());
		}
		
	}   
}	

