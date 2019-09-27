package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class mb_gra extends JFrame implements ActionListener {

   private JLabel  mb_gra, gra_s, gra_v, gra_f ;
   
   private JTextField  Tgra_s, Tgra_v, Tgra_f;
   
   private JButton BmodifyS,BmodifyV,BmodifyF; 
   
   String Smodrate;
   
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할
         
   public mb_gra() {      
         
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         
         mb_gra = new JLabel("등급관리");
         mb_gra.setPreferredSize(new Dimension(100,28));
         gra_s = new JLabel("S등급");
         gra_s.setPreferredSize(new Dimension(100,28));
         gra_v = new JLabel("V등급");
         gra_v.setPreferredSize(new Dimension(100,28));
         gra_f = new JLabel("F등급");
         gra_f.setPreferredSize(new Dimension(100,28));
         
         Tgra_s = new JTextField(5);
         Tgra_s.setPreferredSize(new Dimension(100,28));
         Tgra_v = new JTextField(5);
         Tgra_v.setPreferredSize(new Dimension(100,28));
         Tgra_f = new JTextField(5);
         Tgra_f.setPreferredSize(new Dimension(100,28));
         
        
         BmodifyS = new JButton("수정");
         BmodifyS.setPreferredSize(new Dimension(100,28));
         BmodifyV = new JButton("수정");
         BmodifyV.setPreferredSize(new Dimension(100,28));
         BmodifyF = new JButton("수정");
         BmodifyF.setPreferredSize(new Dimension(100,28));

         BmodifyS.addActionListener(this);
         BmodifyV.addActionListener(this);
         BmodifyF.addActionListener(this);
         
         
         
         EmpRegisterView();
      }   
         
   private void EmpRegisterView() {  
	   
	   	 setLayout(gridbaglayout);
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;
//         gridbagconstraints.ipadx = 7;
//         
//         gridbagconstraints.weightx=1.0;
//         gridbagconstraints.weighty=1.0;
         
         gridbagconstraints.anchor = GridBagConstraints.CENTER;
         
         gridbagAdd(mb_gra, 1, 1, 1, 1);
         
         gridbagAdd(gra_s, 1, 2, 1, 1);
         gridbagAdd(gra_v, 1, 3, 1, 1);
         gridbagAdd(gra_f, 1, 4, 1, 1);
         
         gridbagAdd(Tgra_s, 2, 2, 1, 1);
         gridbagAdd(Tgra_v, 2, 3, 1, 1);
         gridbagAdd(Tgra_f, 2, 4, 1, 1);
         
         gridbagAdd(BmodifyS, 3, 2, 1, 1);
         gridbagAdd(BmodifyV, 3, 3, 1, 1);
         gridbagAdd(BmodifyF, 3, 4, 1, 1);
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;
         
         gridbagconstraints.anchor = GridBagConstraints.EAST;

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
         new mb_gra();
      }

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == BmodifyS){
			Smodrate = Tgra_s.getText();
			double modrate = Double.parseDouble(Smodrate);
			MbgraData.createMbgraS(modrate);
			
			Tgra_s.setText("");
			
		}else if(e.getSource() == BmodifyV){
			Smodrate = Tgra_v.getText();
			double modrate = Double.parseDouble(Smodrate);
			MbgraData.createMbgraV(modrate);
			
			Tgra_v.setText("");
			
		}else if(e.getSource() == BmodifyF){
			Smodrate = Tgra_f.getText();
			double modrate = Double.parseDouble(Smodrate);
			MbgraData.createMbgraF(modrate);
			
			Tgra_f.setText("");
			
		}
		
	}   
      
         
}