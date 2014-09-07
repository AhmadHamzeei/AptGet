import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class AptGetWindow extends JFrame {
	private JTextArea textArea;
	private JButton updateButton;
	private JProgressBar progressBar;
	
	public AptGetWindow(final AptGetProcess appProcess) {
		super("AptGet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
		
		updateButton = new JButton("Update Software List");
		add(updateButton, BorderLayout.NORTH);
		updateButton.addActionListener(		
			new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					appProcess.execute();
				}
			}
		);
		
		textArea = new JTextArea();
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		
		progressBar = new JProgressBar(0, 100);
		add(progressBar, BorderLayout.SOUTH);
		
	}
	
	public JTextArea getTextArea() {
		return textArea;
	}
	
	public JProgressBar getProgressBar() {
		return progressBar;
	}

}
