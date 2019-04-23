package swing.filechoose;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FileChooseDemo {
	JFrame f;
	JButton btnChoose;
	JTextArea txt;

	public FileChooseDemo() {
		f = new JFrame("Demo FileChoose");
		addControls();
		addEvents();
		showWindow();
	}

	private void showWindow() {
		// TODO Auto-generated method stub
		f.setSize(400, 300);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	private void addEvents() {
		btnChoose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int val = chooser.showOpenDialog(null);
				if (val == JFileChooser.APPROVE_OPTION) {
					try {
						File file = chooser.getSelectedFile();
						FileInputStream fis = new FileInputStream(file);
						InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
						BufferedReader br = new BufferedReader(isr);
						String line = br.readLine();
						StringBuilder builder = new StringBuilder();
						while (line != null) {
							builder.append(line);
							line = br.readLine();
						}
						br.close();
						txt.setText(builder.toString());
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}

			}
		});
	}

	private void addControls() {
		Container con = f.getContentPane();
		JPanel pn = new JPanel();
		pn.setLayout(new BoxLayout(pn, BoxLayout.Y_AXIS));
		JScrollPane sp = new JScrollPane(pn,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		btnChoose = new JButton("Chọn File");
		txt = new JTextArea();
		txt.setLineWrap(true);
		txt.setWrapStyleWord(true);
		pn.add(btnChoose);
		pn.add(txt);
		con.add(sp);

	}

	public static void main(String[] args) {
		new FileChooseDemo();
	}

}
