package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Cust_info extends JPanel  implements ActionListener {

   Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
   
   JLabel CUST_NM, CUST_RT, CUST_PT, hello, rtinfo, ptinfo, GoodDay, end1, end2;
   JButton Blogout;

   GridBagLayout gridbaglayout;
   GridBagConstraints gridbagconstraints; // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할

   
   public Cust_info() {
      gridbaglayout = new GridBagLayout();
      gridbagconstraints = new GridBagConstraints();

      CUST_NM = new JLabel(Login.user_nm); //김기범 --> Login.user_nm
      CUST_NM.setFont(new Font("휴먼매직체", Font.BOLD, 25));
      CUST_RT = new JLabel(Login.user_grade); //3% --> Login.user_disc_rt
      CUST_RT.setFont(new Font("휴먼매직체", Font.BOLD, 25));
      CUST_PT = new JLabel(Login.user_point); //3000 --> Login.user_point
      CUST_PT.setFont(new Font("휴먼매직체", Font.BOLD, 25));
      
      hello = new JLabel(" 고객님 반갑습니다.");
      hello.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
      rtinfo = new JLabel("회원님의 현재 할인등급은 ");
      rtinfo.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
      ptinfo = new JLabel("회원님의 현재 보유포인트는 ");
      ptinfo.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
      GoodDay = new JLabel("좋은하루 되세요.");
      GoodDay.setFont(new Font("휴먼매직체", Font.BOLD, 20));
      
      end1 = new JLabel(" 입니다.");
      end1.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
      end2 = new JLabel("원 입니다.");
      end2.setFont(new Font("휴먼매직체", Font.PLAIN, 15));
      
      Blogout = new JButton("로그아웃");
      Blogout.setPreferredSize(new Dimension(100, 30));
      Blogout.setBackground(Color.lightGray);
      Blogout.addActionListener(this);
      
      Cust_infoView();
   }

   private void Cust_infoView() {

      setLayout(gridbaglayout);
      
      gridbagconstraints.anchor = GridBagConstraints.WEST;
      
      gridbagAdd(hello, 1, 0, 1, 1);
      gridbagAdd(end1, 2, 1, 1, 1);
      gridbagAdd(end2, 2, 2, 1, 1);
      
      gridbagconstraints.anchor = GridBagConstraints.CENTER;
      
      gridbagAdd(CUST_NM, 0, 0, 1, 1);
      gridbagAdd(CUST_RT, 1, 1, 1, 1);
      gridbagAdd(CUST_PT, 1, 2, 1, 1);
      gridbagAdd(GoodDay, 0, 3, 3, 1);
      gridbagAdd(Blogout, 0, 4, 3, 1);
      
      gridbagconstraints.anchor = GridBagConstraints.EAST;
      
      gridbagAdd(rtinfo, 0, 1, 1, 1);
      gridbagAdd(ptinfo, 0, 2, 1, 1);
      
      setSize(d.width / 4,(d.height - 600) / 2);
//      getRootPane().setBackground(Color.white);
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
      new Cust_info();
   }
	public void dispose() {
		JFrame parent = (JFrame) this.getTopLevelAncestor();
		parent.dispose();
	}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource() == Blogout) {
		dispose();
		new Login_screen();
	}
}

   
}