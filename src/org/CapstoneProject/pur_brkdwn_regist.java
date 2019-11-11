package org.CapstoneProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import org.CapstoneProject.corr_look.TableCell;

public class pur_brkdwn_regist extends Dialog implements ActionListener, MouseListener {

	private JLabel Lpur_dt, Lpro_nm, Lpur_quant, Lpur_up, Lpr, Lcorr_nm, Ltot_pr;
	private JTextField Tcorr_nm, Tpur_dt, Ttot_pr, Tpro_nm, Tpur_quant, Tpur_up, Tpr;

	private JButton Bregist, Bcancel, Bprosearch, Bcorrsearch, Badd, Bdelete;

	private static String[] col1 = { "상품번호", "상품명", "구매수량", "구매단가", "금액", "" };
	private static DefaultTableModel model1 = new DefaultTableModel(col1, 0);
	private JTable pur_list;
	private JScrollPane scrollpane1;

	private JComboBox<String> cbSearch;

	String pro_num;
	static String pur_num, S_pur_dt, S_tot_pr, corr_num;
	int rows = 0, delete_rows;
	static int tot_pr2, MAX_SIZE = 500;

	String pro_num2[] = new String[MAX_SIZE];
	int pur_quant[] = new int[MAX_SIZE];
	int pur_up[] = new int[MAX_SIZE];
	int tot_pr[] = new int[MAX_SIZE];

	GridBagLayout gridbaglayout;
	GridBagConstraints gridbagconstraints; // gridbag레이아웃에 컴포넌트의 위치를 잡아주는 역할

	public pur_brkdwn_regist(JFrame fr) {
		super(fr, "", true);
		gridbaglayout = new GridBagLayout();
		gridbagconstraints = new GridBagConstraints();

		// 구매내역테이블
		pur_list = new JTable(model1);
		pur_list.getColumnModel().getColumn(5).setCellRenderer(new TableCell());
		pur_list.getColumnModel().getColumn(5).setCellEditor(new TableCell());
		scrollpane1 = new JScrollPane(pur_list);
		scrollpane1.setPreferredSize(new Dimension(400, 300));

		// 구매내역
		Lcorr_nm = new JLabel("거래처명");
		Lcorr_nm.setPreferredSize(new Dimension(100, 30));
		Lpur_dt = new JLabel("구매일자");
		Lpur_dt.setPreferredSize(new Dimension(100, 30));
		Lpro_nm = new JLabel("상품명");
		Lpro_nm.setPreferredSize(new Dimension(100, 30));
		Lpur_quant = new JLabel("구매수량");
		Lpur_quant.setPreferredSize(new Dimension(100, 30));
		Lpur_up = new JLabel("구매단가");
		Lpur_up.setPreferredSize(new Dimension(100, 30));
		Lpr = new JLabel("금액");
		Lpr.setPreferredSize(new Dimension(100, 30));
		Ltot_pr = new JLabel("총 구매액");
		Ltot_pr.setPreferredSize(new Dimension(100, 30));

		// 구매내역 입력
		Tcorr_nm = new JTextField(18);
		Tcorr_nm.setPreferredSize(new Dimension(100, 30));
		Tcorr_nm.setEnabled(false);
		Tpur_dt = new JTextField(18);
		Tpur_dt.setPreferredSize(new Dimension(100, 30));
		Tpro_nm = new JTextField(18);
		Tpro_nm.setEnabled(false);
		Tpro_nm.setPreferredSize(new Dimension(100, 30));
		Tpur_quant = new JTextField(18);
		Tpur_quant.setPreferredSize(new Dimension(100, 30));
		Tpur_up = new JTextField(18);
		Tpur_up.setPreferredSize(new Dimension(100, 30));
		Tpr = new JTextField(18);
		Tpr.addMouseListener(this);
		Tpr.setPreferredSize(new Dimension(100, 30));
		Ttot_pr = new JTextField(18);
		Ttot_pr.addMouseListener(this);
		Ttot_pr.setPreferredSize(new Dimension(100, 30));

		Bregist = new JButton("등록");
		Bregist.addActionListener(this);
		Bregist.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		Bregist.setBackground(Color.WHITE);

		Bcancel = new JButton("취소");
		Bcancel.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		Bcancel.setBackground(Color.WHITE);
		Bcancel.addActionListener(this);

		Bcorrsearch = new JButton("거래처검색");
		Bcorrsearch.addActionListener(this);
		Bcorrsearch.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		Bcorrsearch.setFocusPainted(false);
		Bcorrsearch.setBackground(Color.WHITE);

		Bprosearch = new JButton("상품검색");
		Bprosearch.addActionListener(this);
		Bprosearch.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		Bprosearch.setFocusPainted(false);
		Bprosearch.setBackground(Color.WHITE);

		Badd = new JButton("상품추가");
		Badd.addActionListener(this);
		Badd.setFont(new Font("휴먼매직체", Font.PLAIN, 20));
		Badd.setFocusPainted(false);
		Badd.setBackground(Color.WHITE);

		EmpRegisterView();
	}

	private void EmpRegisterView() {

		setTitle("구매내역등록");

		gridbagconstraints.anchor = GridBagConstraints.WEST;
//         gridbagconstraints.ipadx = 7;
//         
//         gridbagconstraints.weightx=1.0;
//         gridbagconstraints.weighty=1.0;
		gridbagAdd(Bregist, 1, 10, 1, 1);

		setLayout(gridbaglayout);
		gridbagconstraints.anchor = GridBagConstraints.CENTER;


		// 구매내역
		gridbagAdd(Lcorr_nm, 0, 0, 1, 1);
		gridbagAdd(Lpur_dt, 0, 1, 1, 1);
		gridbagAdd(Lpro_nm, 0, 2, 1, 1);
		gridbagAdd(Lpur_quant, 0, 3, 1, 1);
		gridbagAdd(Lpur_up, 0, 4, 1, 1);
		gridbagAdd(Lpr, 0, 5, 1, 1);
		gridbagAdd(Ltot_pr, 0, 8, 1, 1);

		// 구매내역
		gridbagAdd(Tcorr_nm, 1, 0, 1, 1);
		gridbagAdd(Tpur_dt, 1, 1, 1, 1);
		gridbagAdd(Tpro_nm, 1, 2, 1, 1);
		gridbagAdd(Tpur_quant, 1, 3, 1, 1);
		gridbagAdd(Tpur_up, 1, 4, 1, 1);
		gridbagAdd(Tpr, 1, 5, 1, 1);
		gridbagAdd(Ttot_pr, 1, 8, 1, 1);

		gridbagAdd(Bcorrsearch, 2, 0, 1, 1);
		gridbagAdd(Bprosearch, 2, 2, 1, 1);
		gridbagAdd(Badd, 1, 6, 1, 1);
		gridbagAdd(scrollpane1, 0, 7, 3, 1);

		gridbagconstraints.anchor = GridBagConstraints.EAST;
		gridbagAdd(Bcancel, 1, 10, 1, 1);

		pack();
		setResizable(true);
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
		new pur_brkdwn_regist(new JFrame());
	}

	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

		public TableCell() {
			// TODO Auto-generated constructor stub
			Bdelete = new JButton("삭제");
			Bdelete.setFocusPainted(false);
			Bdelete.setBackground(Color.WHITE);

			Bdelete.addActionListener(e -> {
				delete_rows = pur_list.getSelectedRow();
				if (delete_rows >= -1 && delete_rows < pur_list.getRowCount()) {
					tot_pr2 -= Integer.parseInt((String) pur_list.getValueAt(delete_rows, 4));
					model1.removeRow(delete_rows);
					Ttot_pr.setText(Integer.toString(tot_pr2));
					rows--;
				}
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
			return Bdelete;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			// TODO Auto-generated method stub
			return Bdelete;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Bcancel) {
			dispose();
		} else if (e.getSource() == Bregist) {

			int result = JOptionPane.showConfirmDialog(null, "해당 구매내역를 등록하시겠습니까?", "구매내역 등록 확인",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (result == 0) {
				// 변수에 콤보박스 값 저장
				S_pur_dt = Tpur_dt.getText();
				pur_regist.regist_pur();
				pur_num = pur_regist.pur_num;
				for (int i = 0; i < pur_list.getRowCount(); i++) {
					System.out.println(pur_list.getRowCount());
					pro_num2[i] = (String) pur_list.getValueAt(i, 0);
					pur_quant[i] = Integer.parseInt((String) pur_list.getValueAt(i, 2));
					pur_up[i] = Integer.parseInt((String) pur_list.getValueAt(i, 3));
					tot_pr[i] = Integer.parseInt((String) pur_list.getValueAt(i, 4));
				}

				if (pur_list.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "상품이 추가되지 않았습니다.", "오류", JOptionPane.ERROR_MESSAGE);
				} else {
					System.out.println(pur_num);
					for (int i = 0; i < pur_list.getRowCount(); i++) {
						pur_brkdwn_Data.initpur_brkdwn_Data(pur_num, pro_num2[i], pur_quant[i], pur_up[i], tot_pr[i]);
						pur_brkdwn_Data.createpur_brkdwn_Data();
					}
					JOptionPane.showMessageDialog(null, "구매내역이 등록되었습니다.", "구매내역 등록", JOptionPane.INFORMATION_MESSAGE);
					Tcorr_nm.setText("");
					Tpur_dt.setText("");
					Tpro_nm.setText("");
					Tpur_quant.setText("");
					Tpur_up.setText("");
					Tpr.setText("");
					Ttot_pr.setText("");
					DefaultTableModel model = (DefaultTableModel) pur_list.getModel();
					model.setNumRows(0);

					pur_brkdwn_list.getData(pur_brkdwn_Data.selectpur_brkdwn_Data(pur_num));
				}
			} else if (result == 1) {
				JOptionPane.getRootFrame().dispose();
			}
		} else if (e.getSource() == Bprosearch) {
			ProSearch p = new ProSearch(new JFrame());
			pro_num = "";
			pro_num += p.PRO_NUM;
			Tpro_nm.setText(p.PRO_NM);
		} else if (e.getSource() == Bcorrsearch) {
			corr_search c = new corr_search(new JFrame());
			Tcorr_nm.setText(c.CORR_NM);
			corr_num = c.CORR_NUM;
		} else if (e.getSource() == Badd) {
			if (Tpro_nm.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "입력되지 않은 항목이 있습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			} else if (Tpur_quant.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "입력되지 않은 항목이 있습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			} else if (Tpur_up.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "입력되지 않은 항목이 있습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			} else if (Tpr.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "입력되지 않은 항목이 있습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			} else {
				model1.setNumRows(rows);
				model1.addRow(new Object[] { pro_num, Tpro_nm.getText(), Tpur_quant.getText(), Tpur_up.getText(),
						Tpr.getText() });
				tot_pr2 += Integer.parseInt(Tpr.getText());
				Ttot_pr.setText(Integer.toString(tot_pr2));
				rows++;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Tpr) {
			int quant, pro_up;
			quant = Integer.parseInt(Tpur_quant.getText());
			pro_up = Integer.parseInt(Tpur_up.getText());
			Tpr.setText(Integer.toString(quant * pro_up));
		}

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