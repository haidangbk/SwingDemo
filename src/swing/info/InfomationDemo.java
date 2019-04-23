package swing.info;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class InfomationDemo {
	JFrame f;
	static JButton btnOk;
	static JTextField txtName;
	JTextArea txtAddress;
	JCheckBox cb1;
	JCheckBox cb2;
	JRadioButton rb1;
	JRadioButton rb2;

	public InfomationDemo() {
		f = new JFrame("Information");
	}

	public void showWindow() {
		f.setSize(400, 300);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	public void addControls() {
		Container con = f.getContentPane();
		JPanel pnAll = new JPanel();
		pnAll.setLayout(new BoxLayout(pnAll, BoxLayout.Y_AXIS));
//		panel name, address
		JPanel pnInfo = new JPanel();
		pnInfo.setLayout(new BoxLayout(pnInfo, BoxLayout.Y_AXIS));

		JPanel pnName = new JPanel();
		pnName.setLayout(new FlowLayout());
		JLabel lbName = new JLabel("Name: ");
		txtName = new JTextField(20);
		
		pnName.add(lbName);
		pnName.add(txtName);
		pnInfo.add(pnName);

		JPanel pnAddress = new JPanel();
		pnAddress.setLayout(new FlowLayout());
		JLabel lbAddress = new JLabel("Address: ");
		txtAddress = new JTextArea(5, 20);
//		Auto xuá»‘ng dÃ²ng khi háº¿t cá»™t cho 
		txtAddress.setLineWrap(true);
		txtAddress.setWrapStyleWord(true);
		JScrollPane sp = new JScrollPane(txtAddress,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnAddress.add(lbAddress);
		pnAddress.add(sp);
	

		lbName.setPreferredSize(lbAddress.getPreferredSize());

		Border borderInfo = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleBorderInfo = BorderFactory.createTitledBorder("Info: ");
		titleBorderInfo.setTitleColor(Color.RED);
		titleBorderInfo.setBorder(borderInfo);
		titleBorderInfo.setTitleJustification(titleBorderInfo.RIGHT);

		pnInfo.add(pnAddress);
		pnInfo.setBorder(titleBorderInfo);

//		panel bonus info
		JPanel pnBonus = new JPanel();
		pnBonus.setLayout(new GridLayout(1, 2));

		JPanel pnHobby = new JPanel();
		pnHobby.setLayout(new BoxLayout(pnHobby, BoxLayout.Y_AXIS));
		cb1 = new JCheckBox("Xem film");
		cb2 = new JCheckBox("Nghe nhạc");

		Border borderHobby = BorderFactory.createLineBorder(Color.GREEN);
		TitledBorder titleBorderHobby = BorderFactory.createTitledBorder("Hobby: ");
		titleBorderHobby.setTitleColor(Color.BLUE);
		titleBorderHobby.setBorder(borderHobby);

		pnHobby.add(cb1);
		pnHobby.add(cb2);
		pnHobby.setBorder(titleBorderHobby);

		JPanel pnGender = new JPanel();
		pnGender.setLayout(new BoxLayout(pnGender, BoxLayout.Y_AXIS));
		rb1 = new JRadioButton("Nam");
		rb2 = new JRadioButton("Nữ");
		rb1.setSelected(true);
		ButtonGroup group = new ButtonGroup();

		Border borderGender = BorderFactory.createLineBorder(Color.GREEN);
		TitledBorder titleborderGender = BorderFactory.createTitledBorder("Gender: ");
		titleborderGender.setTitleColor(Color.BLUE);
		titleborderGender.setBorder(borderGender);

		group.add(rb1);
		group.add(rb2);
		pnGender.add(rb1);
		pnGender.add(rb2);
		pnGender.setBorder(titleborderGender);

		pnBonus.add(pnHobby);
		pnBonus.add(pnGender);
//		panel Button Show Info

		JPanel pnOk = new JPanel();
		pnOk.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnOk = new JButton("Show");
		btnOk.setBackground(Color.WHITE);
		btnOk.setForeground(Color.RED);
		btnOk.setEnabled(false);
		pnOk.add(btnOk);

//		panel All
		pnAll.add(pnInfo);
		pnAll.add(pnBonus);
		pnAll.add(pnOk);
		con.add(pnAll);
	}

	public void addEvent() {
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showInfo();
			}
		});
	}

	public void showInfo() {
		String name = txtName.getText().trim();
		String address = txtAddress.getText().trim();
		String hobby = "";
		if (cb1.isSelected()) {
			hobby += cb1.getText() + ", ";
		}
		if (cb2.isSelected()) {
			hobby += cb2.getText();
		}
		String gender;
		if (rb1.isSelected()) {
			gender = rb1.getText();
		} else {
			gender = rb2.getText();
		}

		JOptionPane.showMessageDialog(f,
				"Name: " + name + "\n" + "Address: " + address + "\n" + "Hobby: " + hobby + "\n" + "Gender: " + gender);
	}

	public static void main(String[] args) {
		InfomationDemo ifDemo = new InfomationDemo();
		ifDemo.addControls();
		ifDemo.addEvent();
		ifDemo.showWindow();
		
		CheckInfo checkInfo = new CheckInfo();
		Thread t = new Thread(checkInfo);
		t.start();
	}

}
