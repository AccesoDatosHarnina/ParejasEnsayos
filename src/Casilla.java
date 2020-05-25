import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class Casilla extends JPanel {

	/**
	 * Create the panel.
	 */
	public Casilla(String nombre) {
		setLayout(new BorderLayout(0, 0));
		JButton btnNewButton = new JButton(nombre);
		JProgressBar progressBar = new JProgressBar();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cuando tenemos una clase que hereda
//				new MySwingWorker(btnNewButton,progressBar).execute();
				new SwingWorker<Object, Integer>() {

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
							setProgress(progress);
							progressBar.setValue(getProgress());							
						}
						setProgress(0);
						btnNewButton.setText("");
						return null;
					}
					protected void done() {
						progressBar.setValue(getProgress());
					};
				}.execute();
			}
		});
		add(btnNewButton);

		add(progressBar, BorderLayout.SOUTH);
	}

}
