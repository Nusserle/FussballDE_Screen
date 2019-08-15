package screener;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("serial")
public class ScreenView extends JFrame {

	private JLabel labelVereinsspielplan;
	private JTextField fieldVereinsspielplan;
	
	private JLabel labelFilename;
	private JTextField fieldFilename; 
	private JLabel labelOutput;
	private JTextField fieldOutput;

	public JButton buttonDurchsuchen;
	public JButton buttonStart;

	private String output_path = Paths.get(".").toAbsolutePath().normalize().toString();

	public ScreenView() {
		JPanel panel = new JPanel();
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		setTitle("FUSSBALL.DE Screen Capture");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.setLayout(new FlowLayout());
		setSize(500, 400);
		
		initComponents();
		panel.add(labelVereinsspielplan);
		panel.add(fieldVereinsspielplan);

		panel.add(labelFilename);
		panel.add(fieldFilename);
		panel.add(labelOutput);
		panel.add(fieldOutput);

		panel.add(buttonDurchsuchen);
		panel.add(buttonStart);
		
		this.add(panel);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void initComponents() {
		labelVereinsspielplan = new JLabel("Vereins-URL");
		fieldVereinsspielplan = new JTextField(25);
		labelFilename = new JLabel("Dateiname");
		fieldFilename = new JTextField(10);
		labelOutput = new JLabel("Ausgabe-Pfad");
		fieldOutput = new JTextField(35);
		fieldOutput.setText(output_path);

		buttonDurchsuchen = new JButton("Durchsuchen");
		buttonStart = new JButton("Start");
	}
	
	public String getOutputPath() {
		return fieldOutput.getText();
	}
	
	public void setOutputPath(String path) {
		fieldOutput.setText(path);
	}
	
	public String getVereinsURL() {
		return fieldVereinsspielplan.getText();
	}
	
	public String getFilename() {
		return fieldFilename.getText();
	}
	
	
	public void addDurchsuchenListener(ActionListener listenerForDurchsuchenButton) {
		buttonDurchsuchen.addActionListener(listenerForDurchsuchenButton);
	}
	
	public void addStartListener(ActionListener listenerForStartButton) {
		buttonStart.addActionListener(listenerForStartButton);
	}
	
	public void displayErrorMesssage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	
}
