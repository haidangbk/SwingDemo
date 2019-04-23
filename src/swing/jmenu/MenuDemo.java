package swing.jmenu;

import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class MenuDemo {
	JFrame f;
	JMenuBar menuBar; // nơi chứa các JMenu
	JMenu menuFile; // nới chứa các menu item
	JMenu menuEdit;
	JMenu menuHelp;
	
	JMenuItem menuFileNew;
	JMenuItem menuFileOpen;
	JMenuItem menuFileExit;
	

	public MenuDemo() {
		f = new JFrame();
		addControls();
		addEvents();
		showWindow();
	}

	public void showWindow() {
		f.setSize(400, 300);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	public void addControls() {
		menuBar = new JMenuBar();
		f.setJMenuBar(menuBar);
//		MenuFile
		menuFile = new JMenu("File");
		menuFileNew = new JMenuItem("New");
		menuFileOpen = new JMenuItem("Open");
		menuFileExit = new JMenuItem("Exit");
		menuFile.add(menuFileNew);
		menuFile.add(menuFileOpen);
		menuFile.addSeparator();
		menuFile.add(menuFileExit);
		
		menuFileNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_DOWN_MASK));
		menuFileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_DOWN_MASK));
		
		menuEdit = new JMenu("Edit");
		menuHelp = new JMenu("Help");
		
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuHelp);
	}

	public void addEvents() {
		menuFileNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane op = new JOptionPane();
				op.showMessageDialog(f, "New File");
				
			}
		});
		
		menuFileOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane op = new JOptionPane();
				op.showMessageDialog(f, "Open File");
				
			}
		});
	}
	public static void main(String[] args) {
		new MenuDemo();
	}
}
