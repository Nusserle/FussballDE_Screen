package screener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JFileChooser;

public class ScreenController {
	public static Logger log;
	private ScreenView view;
	private WebScraper scrap;

	public ScreenController(ScreenView view, WebScraper scrap) throws SecurityException, IOException {
		log = Logger.getLogger("logger");
		// createLog();
		this.view = view;
		this.scrap = scrap;

		this.view.addDurchsuchenListener(new ButtonListener());
		this.view.addStartListener(new ButtonListener());
	}

	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == view.buttonDurchsuchen) {
				JFileChooser f = new JFileChooser();
				f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnSaveDialog = f.showSaveDialog(null);
				if (returnSaveDialog == JFileChooser.APPROVE_OPTION) {
					view.setOutputPath(String.valueOf(f.getSelectedFile()));
				}
			}
			if (e.getSource() == view.buttonStart) {
				log.log(Level.INFO, "Start Button pressed");
				String vereinspielplanURL = view.getVereinsURL();
				String output_path = view.getOutputPath();
				String mannschaft = view.getFilename();
				try {
					 scrap.getVereinsspielplan(vereinspielplanURL, mannschaft);
				} catch (InterruptedException e1) {
					log.log(Level.SEVERE, "getVereinsspielplan failed", e1);
					e1.printStackTrace();
				}
				log.log(Level.INFO, "Done");
			}

		}
	}
	
//	public void createLog() throws SecurityException, IOException {
//		FileHandler fh = new FileHandler("logs/error.log", 10000000, 20);
//		fh.setFormatter(new SimpleFormatter());
//		log.addHandler(fh);
//	}
}
