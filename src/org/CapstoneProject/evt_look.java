package org.CapstoneProject;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

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

public class evt_look extends JPanel implements ActionListener{

   private JLabel  evt_lookup;      
         
   private JTextField  Tsearch;      
         
   private String[] col1 = {"이벤트번호", "이벤트구분", "시작일자", "종료일자", "해당모델"};  
   private String[] search = {"이벤트번호", "이벤트구분"};       
   
   private DefaultTableModel model1 = new DefaultTableModel(col1, 0);
   
   private JTable evt_info;
   private JScrollPane scrollpane1;
         
   private JButton Bsearch,Breset,jb; 
   
   private JComboBox<String> cbSearch;      
         
   GridBagLayout gridbaglayout;      
   GridBagConstraints gridbagconstraints;      // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할
         
   public evt_look() {      
         
         gridbaglayout = new GridBagLayout();
         gridbagconstraints = new GridBagConstraints();
         
         
         evt_lookup = new JLabel("이벤트 조회");
         evt_lookup.setPreferredSize(new Dimension(100,30));
         
         Tsearch = new JTextField(18);
         Tsearch.setPreferredSize(new Dimension(100,30));
         
         cbSearch = new JComboBox<String>(search);
         cbSearch.setPreferredSize(new Dimension(200,28));
         
         evt_info = new JTable(model1);
         scrollpane1 = new JScrollPane(evt_info);
         scrollpane1.setPreferredSize(new Dimension(1000, 300));
         
         Bsearch = new JButton("검색");
         Bsearch.setPreferredSize(new Dimension(200,28));
         Breset = new JButton("초기화");
         Breset.setPreferredSize(new Dimension(200,28));

         evt_info.getColumnModel().getColumn(4).setCellRenderer(new TableCell());
         evt_info.getColumnModel().getColumn(4).setCellEditor(new TableCell());
         
         evtRegisterView();
      }   
   
   private void getData(List<Map<String, Serializable>> corrListData) {

	      for(int i=0; i < corrListData.size(); i++) {
	         model1.addRow(new Object[] {
	               
	               corrListData.get(i).get("evt_NO"),
	               corrListData.get(i).get("evt_tp"),
	               corrListData.get(i).get("evt_st_dt"),
	               corrListData.get(i).get("evt_fn_dt")

	         });
	      }


	   }
         
   private void evtRegisterView() {      
         
         gridbagconstraints.anchor = GridBagConstraints.WEST;
         
         setLayout(gridbaglayout);
         gridbagconstraints.anchor = GridBagConstraints.CENTER;
         
         gridbagAdd(scrollpane1, 1, 3, 5, 5);
         gridbagconstraints.anchor = GridBagConstraints.WEST;
         gridbagAdd(Tsearch, 2, 2, 1, 1);
         gridbagAdd(cbSearch, 1, 2, 1, 1);
         gridbagAdd(evt_lookup, 1, 1, 1, 1);
         gridbagAdd(Bsearch, 3, 2, 1, 1);
         
         gridbagconstraints.anchor = GridBagConstraints.EAST;
         gridbagAdd(Breset, 4, 2, 1, 1);

//         setResizable(true);
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
         new evt_look();
      }
      
      class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{
          
          public TableCell() {
              // TODO Auto-generated constructor stub
              jb = new JButton("모델조회");
              jb.addActionListener(e -> {
      			pur_list s = new pur_list(new JFrame());
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
              return jb;
          }
          @Override
          public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                  int column) {
              // TODO Auto-generated method stub
              return jb;
          }
           
      }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}   
         
}