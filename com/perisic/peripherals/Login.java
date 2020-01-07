package com.perisic.peripherals;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import org.bson.Document;
import org.json.simple.JSONObject;

import com.perisic.questionnaire.QuestionSet;
import com.sun.awt.AWTUtilities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.beans.PropertyChangeEvent;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.BoxLayout;

public class Login extends JFrame {

	private QuestionSet questionnaire = new QuestionSet();
	private JPanel contentPane;
	private JTextField txt_username;
	private JTextField txt_password;
	private String userName;
	private String password;
	private int val = 0;
	private String errorMsg = null;
	public static int userId;
	public static String username;
	public static String firstname;
	public static String ispaticipated;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setUndecorated(true);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Images/PQ.png")));
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 344, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setFocusable(true);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 345, 469);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel btn_exit = new JLabel("");
		btn_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_exit.setBackground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn_exit.setBackground(Color.RED);
			}
		});
		btn_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Login.this.dispose();
			}
		});
		btn_exit.setIcon(new ImageIcon(Login.class.getResource("/Images/close.png")));
		btn_exit.setBounds(315, 2, 46, 25);
		panel.add(btn_exit);

		JLabel lblSignIn = new JLabel("Sign In");
		lblSignIn.setForeground(Color.WHITE);
		lblSignIn.setFont(new Font("Arial Unicode MS", Font.BOLD, 20));
		lblSignIn.setBounds(130, 82, 91, 25);
		panel.add(lblSignIn);

		JLabel label_aviator = new JLabel("");
		label_aviator.setIcon(new ImageIcon(Login.class.getResource("/Images/user.png")));
		label_aviator.setBounds(133, 11, 64, 71);
		panel.add(label_aviator);

		JLabel lbl_SignInPanel = new JLabel("");
		lbl_SignInPanel.setIcon(new ImageIcon(Login.class.getResource("/Images/topBar.png")));
		lbl_SignInPanel.setBounds(0, -197, 438, 424);
		panel.add(lbl_SignInPanel);

		JLabel lbl_username = new JLabel("Username");
		lbl_username.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_username.setBounds(19, 239, 72, 25);
		panel.add(lbl_username);

		JLabel lbl_Password = new JLabel("Password");
		lbl_Password.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_Password.setBounds(19, 301, 72, 25);
		panel.add(lbl_Password);

		txt_username = new JTextField();
		txt_username.setBackground(SystemColor.menu);
		txt_username.setBounds(105, 228, 210, 34);
		txt_username.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(txt_username);
		txt_username.setColumns(10);

		txt_password = new JPasswordField();
		txt_password.setBackground(SystemColor.menu);
		txt_password.setColumns(10);
		txt_password.setBounds(105, 292, 210, 34);
		txt_password.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(txt_password);

		JLabel lblSignIn_2 = new JLabel("Sign In");
		lblSignIn_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblSignIn_2.setForeground(Color.WHITE);
		lblSignIn_2.setBounds(185, 384, 57, 25);
		panel.add(lblSignIn_2);

		JLabel error_username = new JLabel("");
		error_username.setForeground(Color.RED);
		error_username.setBackground(Color.RED);
		error_username.setBounds(105, 273, 159, 14);
		panel.add(error_username);

		JLabel error_password = new JLabel("");
		error_password.setForeground(Color.RED);
		error_password.setBounds(105, 337, 156, 14);
		panel.add(error_password);

		JLabel label_error = new JLabel("");
		label_error.setForeground(Color.RED);
		label_error.setBackground(Color.RED);
		label_error.setBounds(19, 213, 296, 14);
		panel.add(label_error);

		JLabel btn_SignIn = new JLabel("");
		btn_SignIn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

				label_error.setText("");
				userName = txt_username.getText();
				password = txt_password.getText();
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

				if (userName == null || userName.equals("") || password == null || password.equals("")) {
					if (userName == null || userName.isEmpty()) {
						errorMsg = "Please enter username";
						error_username.setText(errorMsg);
						error_username.setVisible(true);
					}
					if (password == null || password.isEmpty()) {
						errorMsg = "Please enter password";
						error_password.setText(errorMsg);
						error_password.setVisible(true);
					}
				} else if (userName != null) {
//					f.setVisible(true);
					try {
//						f.setVisible(true);
						ArrayList<Document> loginData = questionnaire.getSurveyAccess(userName, password);
//						f.setVisible(true); superuser
						System.out.println("LOGIN : " + loginData.get(0).getBoolean("superuser"));
//						f.setVisible(true);
						if (loginData != null) {
							if (loginData.get(0).getBoolean("superuser") == true) {
								userId = Integer.parseInt(loginData.get(0).getString("userid"));
								firstname = loginData.get(0).getString("firstname").toUpperCase();
								username = loginData.get(0).getString("email");
								ispaticipated = loginData.get(0).getString("ispaticipated");
								AdminHome adminHome = new AdminHome(null);
								adminHome.setUndecorated(true);
								adminHome.setVisible(true);
								adminHome.setLocationRelativeTo(null);
								Login.this.dispose();
							} else {
								userId = Integer.parseInt(loginData.get(0).getString("userid"));
								firstname = loginData.get(0).getString("firstname").toUpperCase();
								username = loginData.get(0).getString("email");
								ispaticipated = loginData.get(0).getString("ispaticipated");
								UserHome userHome = new UserHome();
								userHome.setUndecorated(true);
								userHome.setVisible(true);
								userHome.setLocationRelativeTo(null);
								Login.this.dispose();
							}
						} else {
							errorMsg = "Username or Password is incorrect.";
							label_error.setText(errorMsg);
							label_error.setVisible(true);
//							f.setVisible(false);

						}
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
						System.out.println("rasika lakshan");
						errorMsg = "The password or username that you've entered is incorrect.";
						label_error.setText(errorMsg);
						label_error.setVisible(true);
					}
				}
			}
		});

		txt_username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				error_username.setVisible(false);
			}
		});

		txt_password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				error_password.setVisible(false);
			}
		});

		btn_SignIn.setForeground(Color.BLACK);
		btn_SignIn.setIcon(new ImageIcon(Login.class.getResource("/Images/signinBtn.png")));
		btn_SignIn.setBounds(130, 373, 166, 50);
		panel.add(btn_SignIn);

		JSeparator separator = new JSeparator();
		separator.setBounds(105, 263, 210, 2);
		panel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(105, 326, 210, 2);
		panel.add(separator_1);

	}
}
