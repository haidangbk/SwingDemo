package swing.splitPanes;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class SplitPanesDemo {
	JFrame f;

	public SplitPanesDemo() {
		f = new JFrame("Demo SplitPanes");
	}

	public void addControls() {
		Container con = f.getContentPane();
		JPanel pnLeft = new JPanel();
		JPanel pnRight = new JPanel();
		
		pnLeft.setPreferredSize(new Dimension(100, 0));
		
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnLeft,pnRight);
		sp.setOneTouchExpandable(true);
//		JSplitPane.HORIZONTAL_SPLIT  : chia ngang
//		JSplitPane.VER..._SPLIT		 : Chia dọc
		pnRight.setLayout(new BorderLayout());
		
		JPanel pnRight1 = new JPanel();
		JPanel pnRight2 = new JPanel();
		JSplitPane spRight = new JSplitPane(JSplitPane.VERTICAL_SPLIT,pnRight1,pnRight2);
		
		pnRight.add(spRight,BorderLayout.CENTER);
		
		con.add(sp);
	}

	public void addEvent() {

	}
	public void showWindow() {
		f.setSize(400,300);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		SplitPanesDemo sp = new SplitPanesDemo();
		sp.addControls();
		sp.showWindow();
	}
}
