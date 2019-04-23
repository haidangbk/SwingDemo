package swing.jtable;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableDemo {
	JFrame f;
	DefaultTableModel dtm;
	JTable tb;

	public TableDemo() {
		f = new JFrame("JTable");
		addControls();
		addEvent();
		showWindow();

	}

	public void addControls() {
		Container con = f.getContentPane();
		JPanel pnLeft = new JPanel();
		JPanel pnRight = new JPanel();

		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnLeft, pnRight);
		con.add(sp);

		dtm = new DefaultTableModel();
		dtm.addColumn("Mã");
		dtm.addColumn("ten");
		dtm.addColumn("địa chỉ");

		String arr[] = {"20146180","Đăng","Thái Bình"};
		dtm.addRow(arr);
		
		tb = new JTable(dtm);
		JScrollPane spTable = new JScrollPane(tb,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnLeft.setPreferredSize(new Dimension(300,0));
		pnLeft.setLayout(new BorderLayout());
		pnLeft.add(spTable, BorderLayout.CENTER);
		
	}

	public void addEvent() {

	}

	public void showWindow() {
		f.setSize(400, 300);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new TableDemo();
	}
}
