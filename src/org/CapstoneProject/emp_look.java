package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class emp_look extends JPanel implements ActionListener{

   private JLabel  emp_lookup, Lemp_no, Lemp_nm,  Lemp_dt, Lemp_ph_num, Lemp_tp, Lemp_addr;      
         
   private JTextField  Tsearch;      
         
   private String[] col1 = {"No", "�����ȣ", "�����", "�޴�����ȣ", "�Ի���", "�������"};  
   private String[] search = {"�����ȣ", "�����"};       
   
   private DefaultTableModel model1 = new DefaultTableModel(col1, 0);
   
   private JTable emp_info;
   private JScrollPane scrollpane1;
         
   private JButton jb,Bsearch,Breset; 
   
   private JComboBox<String> cbSearch;      
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag���̾ƿ��� ������Ʈ�� ��ġ�� ����ִ� ����
         
   public emp_look() {      
         
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         
         
         emp_lookup = new JLabel("�����ȸ");
         emp_lookup.setPreferredSize(new Dimension(100,30));
         Lemp_no = new JLabel("�����ȣ");
         Lemp_no.setPreferredSize(new Dimension(100,30));
         Lemp_nm = new JLabel("�����");
         Lemp_nm.setPreferredSize(new Dimension(100,30));
         Lemp_dt = new JLabel("�Ի�����");
         Lemp_dt.setPreferredSize(new Dimension(100,30));
         Lemp_ph_num = new JLabel("�޴��� ��ȣ");
         Lemp_ph_num.setPreferredSize(new Dimension(100,30));
         Lemp_addr = new JLabel("�ּ�");
         Lemp_addr.setPreferredSize(new Dimension(100,30));
         Lemp_tp = new JLabel("�������");
         Lemp_tp.setPreferredSize(new Dimension(100,30));
         
         Tsearch = new JTextField(18);
         Tsearch.setPreferredSize(new Dimension(100,30));
         
         cbSearch = new JComboBox<String>(search);
         cbSearch.setPreferredSize(new Dimension(200,28));
         
         emp_info = new JTable(model1);
         scrollpane1 = new JScrollPane(emp_info);
         scrollpane1.setPreferredSize(new Dimension(1000, 300));
         
         Bsearch = new JButton("�˻�");
         Bsearch.setPreferredSize(new Dimension(200,28));
         Breset = new JButton("�ʱ�ȭ");
         Breset.setPreferredSize(new Dimension(200,28));
         
//         getDeptData(EmpData.selectDept());
//         getSvpData(EmpData.selectSpv());
//         setExtendedState(MAXIMIZED_BOTH);
         EmpRegisterView();
      }   
         
   private void EmpRegisterView() {      
         
//         setTitle("�����ȸ");
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;
//         gridbagconstraints.ipadx = 7;
//         
//         gridbagconstraints.weightx=1.0;
//         gridbagconstraints.weighty=1.0;
         
         setLayout(gridbaglayout);
         gridbagconstraints.anchor = GridBagConstraints.CENTER;
         
         gridbagAdd(scrollpane1, 1, 3, 5, 5);
         gridbagconstraints.anchor = GridBagConstraints.WEST;
         gridbagAdd(Tsearch, 2, 2, 1, 1);
         gridbagAdd(cbSearch, 1, 2, 1, 1);
         gridbagAdd(emp_lookup, 1, 1, 1, 1);
         gridbagAdd(Bsearch, 3, 2, 1, 1);
         
         gridbagconstraints.anchor = GridBagConstraints.EAST;
         gridbagAdd(Breset, 4, 2, 1, 1);

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
      
      class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{
          
          public TableCell() {
              // TODO Auto-generated constructor stub
              jb = new JButton("����");
              jb.addActionListener(e -> {
            	  emp_re s = new emp_re(new JFrame());
              });
           
          }

		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			// TODO Auto-generated method stub
			return null;
		}
      }
      
         
      public static void main(String[] args) {   
         new emp_look();
      }
      
      

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
         
}
