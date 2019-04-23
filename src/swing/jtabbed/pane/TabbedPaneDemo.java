package swing.jtabbed.pane;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedPaneDemo {
	JFrame f;
	JTabbedPane jTabbedPane;
	public TabbedPaneDemo() {
		f = new JFrame("JTabbedPane");
		addControls();
		addEvents();
		showWindow();
	}
	
	public void addControls() {
		Container con = f.getContentPane();
		jTabbedPane = new JTabbedPane();
		con.add(jTabbedPane);
		JPanel tab1 = new JPanel();
		JPanel tab2 = new JPanel();
		JPanel tab3 = new JPanel();
		jTabbedPane.add(tab1,"Tab 1");
		jTabbedPane.add(tab2,"Tab 2");
		jTabbedPane.add(tab3,"Tab 3");
		
		tab1.setBackground(Color.RED);
		tab2.setBackground(Color.BLUE);
		tab3.setBackground(Color.GREEN);
	}
	public void addEvents() {
		
	}
	public void showWindow() {
		f.setSize(400, 300);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new TabbedPaneDemo();
	}
}
