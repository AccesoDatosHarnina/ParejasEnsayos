import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class MySwingWorker extends SwingWorker {

	private JButton btnNewButton;
	private JProgressBar progressBar;



	public MySwingWorker(JButton btnNewButton, JProgressBar progressBar) {
		super();
		this.btnNewButton = btnNewButton;
		this.progressBar = progressBar;
	}



	@Override
	protected Object doInBackground() throws Exception {
		btnNewButton.setText("A");
		int progress = 0;
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(150);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			progress+=10;
			progressBar.setValue(progress);
			
		}
		btnNewButton.setText("");
		return null;
	}

}
