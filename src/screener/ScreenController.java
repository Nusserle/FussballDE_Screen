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

		this.view.addButtonListener(new ButtonListener());
	}

	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == view.button) {

				JFileChooser f = new JFileChooser();
				f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnSaveDialog = f.showSaveDialog(null);
				if (returnSaveDialog == JFileChooser.APPROVE_OPTION) {
					fieldOutput.setText(String.valueOf(f.getSelectedFile()));
				}
				String vereinspielplanURL = fieldVereinspielplan.getText();

				System.out.println(vereinspielplanURL);
			}

		}
	}
}
