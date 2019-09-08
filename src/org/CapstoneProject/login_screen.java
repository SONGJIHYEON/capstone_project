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
              
   private String[] div = {"������", "����"};      // �α��� ����
         
   private JButton Login, cancel2, cancel3, cancel4;      
   private JComboBox<String> cbEmpClass;      
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag���̾ƿ��� ������Ʈ�� ��ġ�� ����ִ� ����
         
   public login_screen() {      
         
         
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         
         
         vLogin = new JLabel("LOGIN");
         
         vLogtext = new JLabel("ȸ������ �Ͻø� �پ��� ������ �������� �� �ֽ��ϴ�.");
         
         xIdfield = new JTextField(15);
         xPwfield = new JTextField(15);
         vQuestion1 = new JLabel("���� ȸ���� �ƴϽŰ���?");
         vQuestion2 = new JLabel("���̵� ��й�ȣ�� �����̳���?");
         vQuestion3 = new JLabel("��ȸ������ �̿��Ͻðڽ��ϱ�?");
        
         cbEmpClass = new JComboBox<String>(div);
         
         Login = new JButton("�α���");
//         regist.addActionListener(this);
//         cancel.addActionListener(this);
         cancel2 = new JButton("ȸ������");
         cancel3 = new JButton("ID/PW ã��");
         cancel4 = new JButton("��ȸ�� ����");
         
         
//         getDeptData(EmpData.selectDept());
//         getSvpData(EmpData.selectSpv());
         EmpRegisterView();
      }   
         
   private void EmpRegisterView() {      
         
         setTitle("�α���ȭ��");
         
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
            //���� ���� �� gridx, gridy���� 0    
         
         gridbagconstraints.gridwidth  = w;
         gridbagconstraints.gridheight = h;
              
               
          gridbaglayout.setConstraints(c, gridbagconstraints); //������Ʈ�� ������Ʈ ��ġ+ũ�� ������ ���� GridBagLayout�� ��ġ   
         
         add(c);   
         
         }   
         
      public static void main(String[] args) {   
         new login_screen();
      }   
         
}