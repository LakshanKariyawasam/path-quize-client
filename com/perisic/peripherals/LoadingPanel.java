package com.perisic.peripherals;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Insets;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.awt.AWTUtilities;

public class LoadingPanel extends JPanel {
	/**
	 * Create the panel.
	 */
	public JPanel LoadingPanel() {

		JPanel panel = new JPanel();
		BoxLayout layoutMgr = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
		panel.setLayout(layoutMgr);
		ImageIcon imageIcon = new ImageIcon((getClass().getResource("/Images/spiner.gif")));
//		JButton button = new JButton();
//		button.setBorderPainted(false);
//		button.setBorder(null);
//		button.setFocusable(false);
//		button.setMargin(new Insets(0, 0, 0, 0));
//		button.setContentAreaFilled(false);
//		button.setIcon(imageIcon);
		JLabel myLabel = new JLabel(imageIcon);
//		JLabel label = new JLabel("Loading...", JLabel.CENTER);
//		panel.add(button);
//		panel.add(label);
		panel.add(myLabel);
//		panel.setOpaque(false);
		return panel;
	}

	public static void main(String[] args) throws MalformedURLException {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame f = new JFrame("Window");
				f.setUndecorated(true);
				f.setBounds(100, 100, 344, 450);
				f.setLocationRelativeTo(null);
				AWTUtilities.setWindowOpacity(f, 0.1f);
				f.setOpacity(0.8f);
				LoadingPanel imagePanel = new LoadingPanel();
				JPanel jp = null;
				try {
					jp = imagePanel.LoadingPanel();
				} catch (Exception ex) {
					Logger.getLogger(LoadingPanel.class.getName()).log(Level.SEVERE, null, ex);
				}
				f.setContentPane(jp);
				f.setBackground(new Color(0, 0, 0, 0)); // <-- THIS CAUSES FLICKERING
//	                f.pack();
				f.setVisible(true);
			}
		});
	}
}
