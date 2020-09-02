package GiaodienSV;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import DAO.SinhvienDAO;
import DoituongData.Thoikhoabieu;
import DoituongData.Thongtindangnhap;

public class SV_XemlicHoc extends JPanel {
	
	
	
	private JPanel panel_Chinh;
	private JPanel panel_TKB;
	JTable tblT2,tblT3,tblT4,tblT5,tblT6;
	DefaultTableModel modelT2,modelT3,modelT4,modelT5,modelT6,modelT7;
	JScrollPane scrollT2,scrollT3,scrollT4,scrollT5,scrollT6;
	
	private String ma, ten;
	private JPanel panel_Thu6;


	public SV_XemlicHoc(Thongtindangnhap thongtindangnhap) {
		setLayout(null);
		ma = thongtindangnhap.getMa();
	
		panel_Chinh = new JPanel();
		panel_Chinh.setBackground(new Color(255, 255, 240));
		panel_Chinh.setBounds(0, 0, 1001, 615);
		add(panel_Chinh);
		panel_Chinh.setLayout(null);
		
		panel_TKB = new JPanel();
		panel_TKB.setBackground(new Color(255, 255, 224));
		panel_TKB.setLayout(null);
		panel_TKB.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_TKB.setBounds(157, 10, 707, 595);
		panel_Chinh.add(panel_TKB);
		
		JPanel panel_Thu2 = new JPanel();
		panel_Thu2.setBorder(new TitledBorder(null, "Th\u01B0 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Thu2.setBounds(10, 14, 690, 119);
		
		String[] tieudeThoikhoabieu = {"Mã môn học", "Tên môn học","tiết học","Phòng học","Giảng viên"};
		//String[] tieudeThu = {"", "", " ","","",""};


		modelT2 = new DefaultTableModel(tieudeThoikhoabieu, 0);
		tblT2 = new JTable(modelT2);
		scrollT2 = new JScrollPane(tblT2);
		scrollT2.setBounds(10, 18, 670, 91);
		scrollT2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorterT2;
		sorterT2 = new TableRowSorter<TableModel>(tblT2.getModel());
		panel_Thu2.setLayout(null);
		panel_Thu2.add(scrollT2);
	
		panel_TKB.add(panel_Thu2);
		
		JPanel panel_Thu3 = new JPanel();
		panel_Thu3.setBorder(new TitledBorder(null, "Th\u1EE9 3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Thu3.setLayout(null);
		panel_Thu3.setBounds(10, 135, 690, 108);
		
		modelT3= new DefaultTableModel(tieudeThoikhoabieu, 0);
		tblT3 = new JTable(modelT3);
		tblT3.setShowHorizontalLines(false);
		tblT3.setShowVerticalLines(false);
		scrollT3 = new JScrollPane(tblT3);
		scrollT3.setBounds(10, 18, 670, 80);
		scrollT3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorterT3;
		sorterT3 = new TableRowSorter<TableModel>(tblT3.getModel());
		panel_Thu3.add(scrollT3);
		panel_TKB.add(panel_Thu3);
		
		JPanel panel_Thu4 = new JPanel();
		panel_Thu4.setBorder(new TitledBorder(null, "Th\u1EE9 4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Thu4.setLayout(null);
		panel_Thu4.setBounds(10, 245, 690, 119);
		
		modelT4= new DefaultTableModel(tieudeThoikhoabieu, 0);
		tblT4 = new JTable(modelT4);
		tblT4.setShowHorizontalLines(false);
		tblT4.setShowVerticalLines(false);
		scrollT4 = new JScrollPane(tblT4);
		scrollT4.setBounds(10, 21, 670, 88);
		scrollT4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorterT4;
		sorterT4 = new TableRowSorter<TableModel>(tblT3.getModel());
		panel_Thu4.add(scrollT4);
		panel_TKB.add(panel_Thu4);
		
		JPanel panel_Thu5 = new JPanel();
		panel_Thu5.setBorder(new TitledBorder(null, "th\u1EE9 5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Thu5.setBounds(10, 367, 690, 108);
		panel_Thu5.setLayout(null);
		
		modelT5= new DefaultTableModel(tieudeThoikhoabieu, 0);
		tblT5 = new JTable(modelT5);
		tblT5.setShowHorizontalLines(false);
		tblT5.setShowVerticalLines(false);
		scrollT5 = new JScrollPane(tblT5);
		scrollT5.setBounds(10, 18, 670, 79);
		scrollT5.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorterT5;
		sorterT5 = new TableRowSorter<TableModel>(tblT3.getModel());
		panel_Thu5.add(scrollT5);
		panel_TKB.add(panel_Thu5);
		
		panel_Thu6 = new JPanel();
		panel_Thu6.setBorder(new TitledBorder(null, "Th\u1EE9 6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Thu6.setBounds(10, 479, 690, 105);
		panel_Thu6.setLayout(null);
		
		modelT6= new DefaultTableModel(tieudeThoikhoabieu, 0);
		tblT6 = new JTable(modelT6);
		tblT6.setShowHorizontalLines(false);
		tblT6.setShowVerticalLines(false);
		scrollT6 = new JScrollPane(tblT6);
		scrollT6.setBounds(10, 18, 670, 80);
		scrollT6.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorterT6;
		sorterT6 = new TableRowSorter<TableModel>(tblT3.getModel());
		panel_Thu6.add(scrollT6);
		panel_TKB.add(panel_Thu6);
		
		Thu2();Thu3();Thu4();Thu5();Thu6();
	}
	
	public void Thu2() {
		String thu = "N'Thứ 2'";
		ArrayList<Thoikhoabieu> listMonhoctrongngay= new SinhvienDAO().getThoikhoabieu(ma, thu);
		for(Thoikhoabieu tkb: listMonhoctrongngay)
		{
			modelT2.addRow(new Object[] {
					tkb.getMaHP(),
					tkb.getTenmonhoc(),
					tkb.getTiethoc(),
					tkb.getPhonghoc(),
					tkb.getGiangvien()
			});
		}
	}
	public void Thu3() {
		String thu = "N'Thứ 3'";
		ArrayList<Thoikhoabieu> listMonhoctrongngay= new SinhvienDAO().getThoikhoabieu(ma, thu);
		for(Thoikhoabieu tkb: listMonhoctrongngay)
		{
			modelT3.addRow(new Object[] {
					tkb.getMaHP(),
					tkb.getTenmonhoc(),
					tkb.getTiethoc(),
					tkb.getPhonghoc(),
					tkb.getGiangvien()
				
			
			});
		}
	}
	public void Thu4() {
		String thu = "N'Thứ 4'";
		ArrayList<Thoikhoabieu> listMonhoctrongngay= new SinhvienDAO().getThoikhoabieu(ma, thu);
		for(Thoikhoabieu tkb: listMonhoctrongngay)
		{
			modelT4.addRow(new Object[] {
					tkb.getMaHP(),
					tkb.getTenmonhoc(),
					tkb.getTiethoc(),
					tkb.getPhonghoc(),
					tkb.getGiangvien()
				
			
			});
		}
	}
	public void Thu5() {
		String thu = "N'Thứ 5'";
		ArrayList<Thoikhoabieu> listMonhoctrongngay= new SinhvienDAO().getThoikhoabieu(ma, thu);
		for(Thoikhoabieu tkb: listMonhoctrongngay)
		{
			modelT5.addRow(new Object[] {
					tkb.getMaHP(),
					tkb.getTenmonhoc(),
					tkb.getTiethoc(),
					tkb.getPhonghoc(),
					tkb.getGiangvien()
				
			
			});
		}
	}
	public void Thu6() {
		String thu = "N'Thứ 6'";
		ArrayList<Thoikhoabieu> listMonhoctrongngay= new SinhvienDAO().getThoikhoabieu(ma, thu);
		for(Thoikhoabieu tkb: listMonhoctrongngay)
		{
			modelT6.addRow(new Object[] {
					tkb.getMaHP(),
					tkb.getTenmonhoc(),
					tkb.getTiethoc(),
					tkb.getPhonghoc(),
					tkb.getGiangvien()
				
			
			});
		}
	}
}
