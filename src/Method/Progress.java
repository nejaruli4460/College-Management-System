package Method;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Progress extends JPanel {

	/**
	 * Create the panel.
	 */
	public Progress() {
	setLayout(null);
			
	JProgressBar progressBar = new JProgressBar(0,100);
	add(progressBar);
	progressBar.setStringPainted(true);
	progressBar.setBounds(59, 5, 195, 17);
	Thread t=new Thread(new Runnable(){
		int i=0;
		public void run() {
			
			// TODO Auto-generated method stub
			while(i<=100) {
				progressBar.setValue(i);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
				}
				i=i+1;
				
				
			}
		}

	});
	
	t.start();

}

}
