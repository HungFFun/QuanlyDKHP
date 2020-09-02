package GiaodienGV;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import DAO.GiangvienDAO;
import DoituongData.Lichday;
import DoituongData.Thongtindangnhap;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.FlowLayout;

public class GV_Lichday extends JPanel {
	JTable tblT2,tblT3,tblT4,tblT5,tblT6;
	DefaultTableModel modelT2,modelT3,modelT4,modelT5,modelT6,modelT7;
	JScrollPane scrollT2,scrollT3,scrollT4,scrollT5,scrollT6;
	private String ma, ten;;
	private JPanel panel_chinh;
	private JPanel panel_Lichday;
	public GV_Lichday( Thongtindangnhap thongtindangnhap) {
		setLayout(null);
		
		panel_chinh = new JPanel();
		panel_chinh.setBackground(new Color(255, 250, 240));
		panel_chinh.setBounds(0, 0, 1009, 595);
		add(panel_chinh);
		panel_chinh.setLayout(null);
		
		panel_Lichday = new JPanel();
		panel_Lichday.setBackground(new Color(255, 255, 224));
		panel_Lichday.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Lichday.setBounds(126, 10, 759, 575);
		panel_chinh.add(panel_Lichday);
		panel_Lichday.setLayout(null);
		ma = thongtindangnhap.getMa();
		String[] tieudeThoikhoabieu = {"Mã lớp học", "Tên môn học","Số tín chỉ","Tiết học","Phòng học","Dẫy nhà","Ngày bắt đầu", "Ngày kết thúc"};
	
		
		JPanel panel_Thu2 = new JPanel();
		panel_Thu2.setBorder(new TitledBorder(null, "Th\u01B0 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Thu2.setBounds(10, 15, 739, 108);

		modelT2 = new DefaultTableModel(tieudeThoikhoabieu, 0);
		tblT2 = new JTable(modelT2);
		scrollT2 = new JScrollPane(tblT2);
		scrollT2.setBounds(10, 18, 719, 83);
		scrollT2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorterT2;
		sorterT2 = new TableRowSorter<TableModel>(tblT2.getModel());
		panel_Thu2.setLayout(null);
		panel_Thu2.add(scrollT2);
		panel_Lichday.add(panel_Thu2);

		JPanel panel_thu3 = new JPanel();
		panel_thu3.setBorder(new TitledBorder(null, "Th\u1EE9 3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_thu3.setBounds(10, 126, 739, 108);
		panel_thu3.setLayout(new BorderLayout());

		modelT3= new DefaultTableModel(tieudeThoikhoabieu, 0);
		tblT3 = new JTable(modelT3);
		tblT3.setShowHorizontalLines(false);
		tblT3.setShowVerticalLines(false);
		scrollT3 = new JScrollPane(tblT3);
		scrollT3.setBounds(10, 18, 719, 83);
		scrollT3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorterT3;
		sorterT3 = new TableRowSorter<TableModel>(tblT3.getModel());
		panel_thu3.add(scrollT3);
		panel_Lichday.add(panel_thu3);

		JPanel panel_thu4 = new JPanel();
		panel_thu4.setBorder(new TitledBorder(null, "Th\u1EE9 4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_thu4.setBounds(10, 239, 739, 108);
		panel_thu4.setLayout(new BorderLayout());

		modelT4= new DefaultTableModel(tieudeThoikhoabieu, 0);
		tblT4 = new JTable(modelT4);
		tblT4.setShowHorizontalLines(false);
		tblT4.setShowVerticalLines(false);
		scrollT4 = new JScrollPane(tblT4);
		scrollT4.setBounds(10, 18, 719, 83);
		scrollT4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorterT4;
		sorterT4 = new TableRowSorter<TableModel>(tblT3.getModel());
		panel_thu4.add(scrollT4);
		panel_Lichday.add(panel_thu4);

		JPanel panel_thu5 = new JPanel();
		panel_thu5.setBorder(new TitledBorder(null, "th\u1EE9 5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_thu5.setBounds(10, 352, 739, 108);
		panel_thu5.setLayout(new BorderLayout());


		modelT5= new DefaultTableModel(tieudeThoikhoabieu, 0);
		tblT5 = new JTable(modelT5);
		tblT5.setShowHorizontalLines(false);
		tblT5.setShowVerticalLines(false);
		scrollT5 = new JScrollPane(tblT5);
		scrollT5.setBounds(10, 18, 719, 83);
		scrollT5.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorterT5;
		sorterT5 = new TableRowSorter<TableModel>(tblT3.getModel());
		panel_thu5.add(scrollT5);
		panel_Lichday.add(panel_thu5);

		JPanel panel_thu6 = new JPanel();
		panel_thu6.setBorder(new TitledBorder(null, "Th\u1EE9 6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_thu6.setBounds(10, 463, 739, 108);
		panel_thu6.setLayout(new BorderLayout());

		modelT6= new DefaultTableModel(tieudeThoikhoabieu, 0);
		tblT6 = new JTable(modelT6);
		tblT6.setShowHorizontalLines(false);
		tblT6.setShowVerticalLines(false);
		scrollT6 = new JScrollPane(tblT6);
		scrollT6.setBounds(10, 18, 719, 83);
		scrollT6.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		TableRowSorter<TableModel> sorterT6;
		sorterT6 = new TableRowSorter<TableModel>(tblT3.getModel());
		panel_thu6.add(scrollT6);
		panel_Lichday.add(panel_thu6);
		Thu2();
		Thu3();
		Thu4();
		Thu5();
		Thu6();

	}
	
	public void Thu2() {
		String thu = "N'Thứ 2'";
		ArrayList<Lichday> lichday = new GiangvienDAO().getLichday(ma, thu);
		for(Lichday ld: lichday)
		{
			modelT2.addRow(new Object[] {
					ld.getMaLHP(),
					ld.getTenLHP(),
					ld.getSotinchi(),
					ld.getTietday(),
					ld.getPhonghoc(),
					ld.getDaynha(),
					ld.getNgayBatdau(),
					ld.getNgayKetthuc()
			});
		}
	}
	public void Thu3() {
		String thu = "N'Thứ 3'";
		ArrayList<Lichday> lichday = new GiangvienDAO().getLichday(ma, thu);
		for(Lichday ld: lichday)
		{
			modelT3.addRow(new Object[] {
					ld.getMaLHP(),
					ld.getTenLHP(),
					ld.getSotinchi(),
					ld.getTietday(),
					ld.getPhonghoc(),
					ld.getDaynha(),
					ld.getNgayBatdau(),
					ld.getNgayKetthuc()
			});
		}
	}
	public void Thu4() {
		String thu = "N'Thứ 4'";
		ArrayList<Lichday> lichday = new GiangvienDAO().getLichday(ma, thu);
		for(Lichday ld: lichday)
		{
			modelT4.addRow(new Object[] {
					ld.getMaLHP(),
					ld.getTenLHP(),
					ld.getSotinchi(),
					ld.getTietday(),
					ld.getPhonghoc(),
					ld.getDaynha(),
					ld.getNgayBatdau(),
					ld.getNgayKetthuc()
			});
		}
	}
	public void Thu5() {
		String thu = "N'Thứ 5'";
		ArrayList<Lichday> lichday = new GiangvienDAO().getLichday(ma, thu);
		for(Lichday ld: lichday)
		{
			modelT5.addRow(new Object[] {
					ld.getMaLHP(),
					ld.getTenLHP(),
					ld.getSotinchi(),
					ld.getTietday(),
					ld.getPhonghoc(),
					ld.getDaynha(),
					ld.getNgayBatdau(),
					ld.getNgayKetthuc()
			});
		}
	}
	public void Thu6() {
		String thu = "N'Thứ 6'";
		ArrayList<Lichday> lichday = new GiangvienDAO().getLichday(ma, thu);
		for(Lichday ld: lichday)
		{
			modelT6.addRow(new Object[] {
					ld.getMaLHP(),
					ld.getTenLHP(),
					ld.getSotinchi(),
					ld.getTietday(),
					ld.getPhonghoc(),
					ld.getDaynha(),
					ld.getNgayBatdau(),
					ld.getNgayKetthuc()
			});
		}
	}
}
