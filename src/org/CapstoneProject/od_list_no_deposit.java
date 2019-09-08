package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class od_list_no_deposit extends JPanel implements ActionListener, MouseListener {

   private JLabel no_deposit;
   private JTextField  Tsearch;

   private String[] col1 = {"No", "�ֹ���ȣ", "�ֹ��ڸ�", "�ֹ��ݾ�", "�ֹ��Ͻ�", "�ԱݿϷ�"};  
   private String[] search = {"�ֹ���ȣ", "�ֹ��ڸ�","�ֹ��Ͻ�"};

   private DefaultTableModel model1 = new DefaultTableModel(col1, 0);  
         
   private JTable od_info;      
   private JScrollPane scrollpane1;      
         
   private JButton bus_man,pro_man,od_man,mb_man,emp_man,Bsearch,reset;      
   private JComboBox<String> cbSearch;      
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag���̾ƿ��� ������Ʈ�� ��ġ�� ����ִ� ����
         
   public od_list_no_deposit() {      
         
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         
         no_deposit = new JLabel("�ֹ�����(���Ա�)");
         no_deposit.setPreferredSize(new Dimension(200,28));
        
         cbSearch = new JComboBox<String>(search);
         cbSearch.setPreferredSize(new Dimension(200,28));
         
         Tsearch = new JTextField();
         Tsearch.setPreferredSize(new Dimension(200,28));
         od_info = new JTable(model1);
//         eDept.addMouseListener(new JTableMouseListener());
         scrollpane1 = new JScrollPane(od_info);
         
         scrollpane1.setPreferredSize(new Dimension(1000, 300));
     
         Bsearch = new JButton("�˻�");
         Bsearch.setPreferredSize(new Dimension(100,28));
         reset = new JButton("�ʱ�ȭ");
         reset.setPreferredSize(new Dimension(100,28));
         
//         getDeptData(EmpData.selectDept());
//         getSvpData(EmpData.selectSpv());
//         setExtendedState(MAXIMIZED_BOTH);
         EmpRegisterView();
      }   
         
   private void EmpRegisterView() {      
         
//         setTitle("�ֹ�����(������Ա�)");
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;
//         gridbagconstraints.ipadx = 7;
//         
//         gridbagconstraints.weightx=1.0;
//         gridbagconstraints.weighty=1.0;
         
         setLayout(gridbaglayout);
         gridbagconstraints.anchor = GridBagConstraints.CENTER;
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;
         gridbagAdd(no_deposit, 1, 1, 1, 1);
         gridbagAdd(cbSearch, 1, 2, 1, 1);
         gridbagAdd(Tsearch, 2, 2, 1, 1);
         gridbagAdd(Bsearch, 3, 2, 1, 1);
         gridbagconstraints.anchor = GridBagConstraints.EAST;
         gridbagAdd(reset, 3, 2, 1, 1);
     
         gridbagAdd(scrollpane1, 1, 3, 5, 5);


//         setResizable(true);
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
         JPanel p = new od_list_no_deposit();
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
		
	}   
         
}