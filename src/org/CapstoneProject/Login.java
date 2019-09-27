package org.CapstoneProject;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Login extends JFrame implements ActionListener, MouseListener{   
	
	ArrayList ar = new ArrayList();
	
	private JLabel vLabel1, vLabel2, vLabel3, vLabel4, vLabel5, vId, vPwd;   
	private JTextField xEmpName, xEmpPhone, xhEmpRegist, xEmpHireDate, xDeptName, xEmpSal, xSpvName, xEmpAnin, xEmpComm, xId, xPwd;      
	   
	private String[] col1 = {"부서명", "부서위치"};      
	private String[] col2 = {"부서명", "성명"};      
	private String[] div = {"유저", "관리자"}; // 사원구분 콤보박스의 목록
	         
	private DefaultTableModel model1 = new DefaultTableModel(col1, 0);      
	private DefaultTableModel model2 = new DefaultTableModel(col2, 0);      
	   
       
	private JTable eDept, eSpv;      
	private JScrollPane scrollpane1, scrollpane2;      
	         
	private JButton BtLogin, BtRegMb, BtFind, Btnonmember;      
	private JComboBox<String> cbSel;    
	
	static String admin_num, admin_nm, admin_appc_dt, admin_id, user_num, user_nm, user_id, user_grade, user_disc_rt, user_point;
	
	String sid, sid2, pwd, pwd2, id;
	         
	GridBagLayout gridbaglayout;      
	GridBagConstraints gridbagconstraints;      // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할
	
	private void getData(List<Map<String, Serializable>> idListData) {
		 HashMap<Serializable, Serializable> id = new HashMap<Serializable, Serializable>();	

		 ArrayList ar = new ArrayList();
		 
		 for(int i = 0; i<idListData.size(); i++) {
			 
		 id.put(idListData.get(i).get("ID"),
				idListData.get(i).get("PWD"));	 
		 }

		 if(!id.containsKey(sid)) {
			 JOptionPane.showMessageDialog(null, "등록되지 않은 ID입니다", "", JOptionPane.ERROR_MESSAGE);
			 xId.setText("");
			 xPwd.setText("");
			 sid = "";
			 pwd = "";
		 }else {
			 if(!id.get(sid).equals(pwd)) {
				 JOptionPane.showMessageDialog(null, "입력하신 ID와 비밀번호가 일치하지 않습니다", "", JOptionPane.ERROR_MESSAGE);
				 xId.setText("");
				 xPwd.setText("");
				 sid = "";
				 pwd = "";
			 }else {
				 JOptionPane.showMessageDialog(null, "로그인 되었습니다", "", JOptionPane.INFORMATION_MESSAGE);
				 user_id = "";
				 user_id += idListData.get(0).get("ID");
				 user_num = "";
				 user_num += idListData.get(0).get("CUST_NUM");
				 user_nm = "";
				 user_nm += idListData.get(0).get("CUST_NM");
				 user_grade = "";
				 user_grade += idListData.get(0).get("MB_GRA");
				 user_disc_rt = "";
				 user_disc_rt += idListData.get(0).get("DISC_RT");
				 user_point = "";
				 user_point += idListData.get(0).get("POSS_PNT");
				 dispose();
				 JFrame user_main = new home_user();
			 	}
		 	}
		 }
	
	private void getData2(List<Map<String, Serializable>> idListData) {
		 HashMap<Serializable, Serializable> id = new HashMap<Serializable, Serializable>();	

		 ArrayList ar = new ArrayList();
		 
		 for(int i = 0; i<idListData.size(); i++) {
			 
		 id.put(idListData.get(i).get("ID"),
				idListData.get(i).get("PWD"));	 
		 }

		 if(!id.containsKey(sid2)) {
			 JOptionPane.showMessageDialog(null, "등록되지 않은 ID입니다", "", JOptionPane.ERROR_MESSAGE);
			 xId.setText("");
			 xPwd.setText("");
			 sid2 = "";
			 pwd2 = "";
		 }else {
			 if(!id.get(sid2).equals(pwd2)) {
				 JOptionPane.showMessageDialog(null, "입력하신 ID와 비밀번호가 일치하지 않습니다", "", JOptionPane.ERROR_MESSAGE);
				 xId.setText("");
				 xPwd.setText("");
				 sid2 = "";
				 pwd2 = "";
			 }else {
				 JOptionPane.showMessageDialog(null, "로그인 되었습니다", "", JOptionPane.INFORMATION_MESSAGE);
				 admin_id = "";
				 admin_id += idListData.get(0).get("ID");
				 admin_num = "";
				 admin_num += idListData.get(0).get("emp_num");
				 admin_nm = "";
				 admin_nm += idListData.get(0).get("emp_nm");
				 admin_appc_dt = "";
				 admin_appc_dt += idListData.get(0).get("appc_dt");
				 dispose();
				 JFrame admin_main = new manager_main();
			 	}
		 	}
		 }	 
	         
	public Login() {
		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();       
	         
	    vLabel1 = new JLabel("Login");
	    vLabel1.setFont(new Font("휴먼매직체", Font.BOLD, 25));     
	    vLabel2 = new JLabel("회원가입 하시면 다양한 혜택을 제공받을 수 있습니다.");
	    vLabel2.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
	         
	    cbSel = new JComboBox<String>(div);
	    cbSel.setFont(new Font("휴먼매직체", Font.BOLD , 16));
	    cbSel.setBackground(Color.WHITE);
	    cbSel.setPreferredSize(new Dimension(153, 25));

        xId = new JTextField(15);
        xPwd = new JPasswordField(15);
       	                  
        vLabel3 = new JLabel("아직 회원이 아니신가요?");
        vLabel3.setFont(new Font("휴먼매직체", Font.PLAIN, 17));
        vLabel4 = new JLabel("아이디/비밀번호를 잊으셨나요?");
        vLabel4.setFont(new Font("휴먼매직체", Font.PLAIN, 17));
        vLabel5= new JLabel("비회원으로 이용하겠습니까?");
        vLabel5.setFont(new Font("휴먼매직체", Font.PLAIN, 17));
	         
	         
        BtLogin = new JButton("로그인");
        BtLogin.setPreferredSize(new Dimension(120, 30));
        BtLogin.setFocusPainted(false);
        BtLogin.setBackground(Color.white);
        BtLogin.setFont(new Font("휴먼매직체", Font.PLAIN , 17));
        BtLogin.addActionListener(this);
        
        BtRegMb = new JButton("회원가입");
        BtRegMb.setPreferredSize(new Dimension(120, 30));
        BtRegMb.addActionListener(this);
        BtRegMb.setFocusPainted(false);
        BtRegMb.setBackground(Color.white);
        BtRegMb.setFont(new Font("휴먼매직체", Font.PLAIN , 17));
        
        BtFind = new JButton("ID/PW 찾기");
        BtFind.setPreferredSize(new Dimension(120, 30));
        BtFind.addActionListener(this);
        BtFind.setFocusPainted(false);
        BtFind.setBackground(Color.white);
        BtFind.setFont(new Font("휴먼매직체", Font.PLAIN , 17));
        
        Btnonmember = new JButton("비회원 접속");
        Btnonmember.setPreferredSize(new Dimension(120, 30));
        Btnonmember.addActionListener(this);
        Btnonmember.setFocusPainted(false);
        Btnonmember.setBackground(Color.white);
        Btnonmember.setFont(new Font("휴먼매직체", Font.PLAIN , 17));
//	         getDeptData(EmpData.selectDept());
//	         getSvpData(EmpData.selectSpv());
        
        
        LoginView();
      }    
	         
	private void LoginView() {
		setTitle("Login 화면");
	         
	    gridbagconstraints.anchor = GridBagConstraints.WEST;
//	    gridbagconstraints.ipadx = 7;
//	    
//	    gridbagconstraints.weightx=1.0;
//      gridbagconstraints.weighty=1.0;
         
        setLayout(gridbaglayout);       
        gridbagconstraints.anchor = GridBagConstraints.CENTER;
	        
        gridbagAdd(vLabel1, 0, 0, 2, 1);
        gridbagAdd(vLabel2, 0, 1, 2, 1);
        
        gridbagAdd(cbSel, 0, 2, 3, 1);
        gridbagAdd(xId, 0, 3, 2, 1);
        gridbagAdd(xPwd, 0, 4, 2, 1);
        gridbagAdd(BtLogin, 3, 3, 2, 2);      
        gridbagAdd(vLabel3, 0, 5, 2, 1);
        gridbagAdd(vLabel4, 0, 6, 2, 1);
        gridbagAdd(vLabel5, 0, 7, 2, 1);
       
       

        gridbagconstraints.anchor = GridBagConstraints.CENTER;    
        gridbagAdd(BtRegMb, 3, 5, 1, 1);
        gridbagAdd(BtFind, 3, 6, 1, 1);
        gridbagAdd(Btnonmember, 3, 7, 1, 1);
        
        setExtendedState(MAXIMIZED_BOTH);
//        pack();
	    setVisible(true);
	}
	private void gridbagAdd(Component c, int x, int y, int w, int h) {   
		gridbagconstraints.gridx = x;
        gridbagconstraints.gridy = y; 
	            //가장 왼쪽 위 gridx, gridy값은 0    
	         
        gridbagconstraints.gridwidth  = w;
        gridbagconstraints.gridheight = h;
	               
        gridbaglayout.setConstraints(c, gridbagconstraints); //컴포넌트를 컴포넌트 위치+크기 정보에 따라 GridBagLayout에 배치   
	         
        add(c);   
	         
     }   
	public static void main(String[] args) {   
		new Login();
    	 }   
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == BtRegMb) {
			RegMember r = new RegMember(new JFrame());

		} else if(e.getSource() == BtFind) {
			Find f = new Find(new JFrame());
		} else if(e.getSource() == Btnonmember) {
			Nonmember n = new Nonmember(new JFrame());
		}if(cbSel.getSelectedItem() == "유저") {
			if(e.getSource() == BtLogin) {
			sid = "";
			pwd = "";
			sid = xId.getText();
			pwd = xPwd.getText();			
			getData(CheckId.selectlogin1(sid, pwd));
			
			}
		}if(cbSel.getSelectedItem() == "관리자") {
			if(e.getSource() == BtLogin) {
				sid2 = "";
				pwd2 = "";
				sid2 = xId.getText();
				pwd2 = xPwd.getText();
				getData2(CheckId.selectlogin2(sid2, pwd2));
			}
		}
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
}