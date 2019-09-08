package org.CapstoneProject;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class login_screen extends JFrame {

   private JLabel vLogin,vLogtext, vQuestion1, vQuestion2, vQuestion3;
         
   private JTextField xIdfield, xPwfield; 
              
   private String[] div = {"관리자", "유지"};      // 로그인 유형
         
   private JButton Login, cancel2, cancel3, cancel4;      
   private JComboBox<String> cbEmpClass;      
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할
         
   public login_screen() {      
         
         
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         
         
         vLogin = new JLabel("LOGIN");
         
         vLogtext = new JLabel("회원가입 하시면 다양한 혜택을 제공받을 수 있습니다.");
         
         xIdfield = new JTextField(15);
         xPwfield = new JTextField(15);
         vQuestion1 = new JLabel("아직 회원이 아니신가요?");
         vQuestion2 = new JLabel("아이디 비밀번호를 잊으셨나요?");
         vQuestion3 = new JLabel("비회원으로 이용하시겠습니까?");
        
         cbEmpClass = new JComboBox<String>(div);
         
         Login = new JButton("로그인");
//         regist.addActionListener(this);
//         cancel.addActionListener(this);
         cancel2 = new JButton("회원가입");
         cancel3 = new JButton("ID/PW 찾기");
         cancel4 = new JButton("비회원 접속");
         
         
//         getDeptData(EmpData.selectDept());
//         getSvpData(EmpData.selectSpv());
         EmpRegisterView();
      }   
         
   private void EmpRegisterView() {      
         
         setTitle("로그인화면");
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;
         gridbagconstraints.ipadx = 7;
         
         gridbagconstraints.weightx=1.0;
         gridbagconstraints.weighty=1.0;
         
         setLayout(gridbaglayout);
         gridbagconstraints.anchor = GridBagConstraints.CENTER;
         gridbagAdd(vLogin, 0, 0, 1, 1);
         gridbagAdd(vLogtext, 0, 1, 1, 1);
         gridbagconstraints.anchor = GridBagConstraints.WEST;
         gridbagAdd(xIdfield, 0, 3, 1, 1);
         gridbagAdd(xPwfield, 0, 4, 1, 1);
         gridbagAdd(cbEmpClass, 0, 2, 1, 1);
         gridbagconstraints.anchor = GridBagConstraints.EAST;
         gridbagAdd(Login, 0, 2, 2, 4);
         gridbagAdd(cancel2, 0, 5, 1, 1);
         gridbagAdd(cancel3, 0, 6, 1, 1);
         gridbagAdd(cancel4, 0, 7, 1, 1);
         gridbagconstraints.anchor = GridBagConstraints.WEST;
         gridbagAdd(vQuestion1, 0, 5, 1, 1);
         gridbagAdd(vQuestion2, 0, 6, 1, 1);
         gridbagAdd(vQuestion3, 0, 7, 1, 1);
         
         pack();
         setResizable(true);
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
         new login_screen();
      }   
         
}