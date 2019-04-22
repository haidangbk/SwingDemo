package swing.info;

public class CheckInfo implements Runnable {

	@Override
	public void run() {
		while (true) {
			String name = InfomationDemo.txtName.getText();
			if(name == null || name.isEmpty()) {
				InfomationDemo.btnOk.setEnabled(false);
			}
			else {
				InfomationDemo.btnOk.setEnabled(true);
			}
		}
	}

}
