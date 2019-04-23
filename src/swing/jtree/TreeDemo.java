package swing.jtree;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeDemo extends JFrame {
	public TreeDemo(String s) {
		super(s);
		addControls();
		showWindow();
	}
	
	public void addControls() {
		Container con = getContentPane();
		JPanel pn = new JPanel();
		pn.setLayout(new BorderLayout());
		DefaultMutableTreeNode taiLieu = new DefaultMutableTreeNode("tai lieu");
		DefaultMutableTreeNode java = new DefaultMutableTreeNode("java");
		taiLieu.add(java);
		JTree tree = new JTree(taiLieu);
		
		JScrollPane sp = new JScrollPane(tree,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pn.add(sp,BorderLayout.CENTER);
		con.add(pn);
	}
	
	public void showWindow() {
		this.setSize(400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new TreeDemo("JTree");
	}
}
