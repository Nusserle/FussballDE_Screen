package screener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

public class ScreenController {
	private ScreenView view;
	private WebScraper scrap;

	public ScreenController(ScreenView view, WebScraper scrap) {
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
				String vereinspielplanURL = view.getVereinsURL();
				String output_path = view.getOutputPath();
				String mannschaft = view.getFilename();
				try {
					scrap.getVereinsspielplan(vereinspielplanURL, mannschaft, output_path);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}

		}
	}
}
