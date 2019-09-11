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

public class evt_look extends JPanel implements ActionListener {

   private JLabel evt_lookup;

   private JTextField Tsearch;

   private String[] col1 = { "�̺�Ʈ����", "��������", "��������", "�ش�𵨸�", "������", "����Ʈ" };
   private String[] search = { "�̺�Ʈ����", "�̺�Ʈ���𵨸�" };

   private DefaultTableModel model1 = new DefaultTableModel(col1, 0);

   private JTable evt_info;
   private JScrollPane scrollpane1;

   private JButton Bsearch, Breset, jb;

   private JComboBox<String> cbSearch;

   String model_nm;

   GridBagLayout gridbaglayout;
   GridBagConstraints gridbagconstraints; // gridbag���̾ƿ��� ������Ʈ�� ��ġ�� ����ִ� ����

   public evt_look() {

      gridbaglayout = new GridBagLayout();
      gridbagconstraints = new GridBagConstraints();

      evt_lookup = new JLabel("�̺�Ʈ ��ȸ");
      evt_lookup.setPreferredSize(new Dimension(100, 30));

      Tsearch = new JTextField(18);
      Tsearch.setPreferredSize(new Dimension(100, 30));

      cbSearch = new JComboBox<String>(search);
      cbSearch.setPreferredSize(new Dimension(200, 28));

      evt_info = new JTable(model1);
      scrollpane1 = new JScrollPane(evt_info);
      scrollpane1.setPreferredSize(new Dimension(1000, 300));

      Bsearch = new JButton("�˻�");
      Bsearch.addActionListener(this);
      Bsearch.setPreferredSize(new Dimension(200, 28));
//         Breset = new JButton("�ʱ�ȭ");
//         Breset.setPreferredSize(new Dimension(200,28));

//         evt_info.getColumnModel().getColumns(4).setCellRenderer(new TableCell());
//         evt_info.getColumnModel().getColumn(4).setCellEditor(new TableCell());
      evtRegisterView();
   }

   private void getData(List<Map<String, Serializable>> evtListData) {

      for (int i = 0; i < evtListData.size(); i++) {
         model1.addRow(new Object[] {

               evtListData.get(i).get("EVT_TP"), 
               evtListData.get(i).get("EVT_ST_DT"),
               evtListData.get(i).get("EVT_END_DT"), 
               evtListData.get(i).get("model_nm"),
               evtListData.get(i).get("DISC_RT"), 
               evtListData.get(i).get("ADD_PNT")

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
//         gridbagAdd(Breset, 4, 2, 1, 1);

//         setResizable(true);
      setVisible(true);
   }

   private void gridbagAdd(Component c, int x, int y, int w, int h) {

      gridbagconstraints.gridx = x;
      gridbagconstraints.gridy = y;
      // ���� ���� �� gridx, gridy���� 0

      gridbagconstraints.gridwidth = w;
      gridbagconstraints.gridheight = h;

      gridbaglayout.setConstraints(c, gridbagconstraints); // ������Ʈ�� ������Ʈ ��ġ+ũ�� ������ ���� GridBagLayout�� ��ġ

      add(c);

   }

   public static void main(String[] args) {
      new evt_look();
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == Bsearch) {
         String search = Tsearch.getText();
         if(cbSearch.getSelectedItem() == "�̺�Ʈ����") {
            model1.setRowCount(0);
            getData(evtData.selectevt1(search));
         }else if(cbSearch.getSelectedItem() == "�̺�Ʈ���𵨸�") {
            model1.setRowCount(0);
            getData(evtData.selectevt2(search));
         }
         getData(evtData.selectevt());
      }

   }

}