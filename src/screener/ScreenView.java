package screener;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("serial")
public class ScreenView extends JFrame implements ActionListener {

	private JLabel labelVereinspielplan;
	private JTextField fieldVereinspielplan;

	private JLabel labelOutput;
	private JTextField fieldOutput;

	private JButton button;

	private String output_path = Paths.get(".").toAbsolutePath().normalize().toString();

	public ScreenView() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		setTitle("FUSSBALL.DE Screen Capture");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		setSize(500, 400);

		initComponents();
		add(labelVereinspielplan);
		add(fieldVereinspielplan);

		add(labelOutput);
		add(fieldOutput);

		add(button);

		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void initComponents() {
		labelVereinspielplan = new JLabel("Vereins-URL");
		fieldVereinspielplan = new JTextField(25);

		labelOutput = new JLabel("Ausgabe-Pfad");
		fieldOutput = new JTextField(35);
		fieldOutput.setText(output_path);

		button = new JButton("Durchsuchen");
		button.addActionListener(this);

	}
	
	public void addButtonListener(ActionListener listenForButton) {
		button.addActionListener(listenerForButton);
	}
	
}
