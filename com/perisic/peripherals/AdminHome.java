package com.perisic.peripherals;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTable;

import java.awt.Panel;
import java.awt.Button;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Canvas;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.ScrollPane;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.FlowLayout;
//import net.miginfocom.swing.MigLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.bson.Document;

import com.perisic.questionnaire.Answers;
import com.perisic.questionnaire.QuestionSet;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import sun.rmi.runtime.Log;

import javax.swing.ListSelectionModel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AdminHome extends JFrame {

	private JPanel contentPane;
	private int val = 0;
	private ArrayList<Document> userData;
	Login login = new Login();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			private ArrayList<ArrayList<String>> value;
			private ArrayList<Document> valueUser;
			
			public void run() {
				try {


					
//					this.valueUser = questionnaire.getUserList();

					AdminHome frame = new AdminHome(this.value);
//					frame.setUndecorated(true);
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
	 * @throws RemoteException 
	 */
	public AdminHome(ArrayList<ArrayList<String>> value) throws RemoteException {
		
		QuestionSet questionnaire = new QuestionSet();
		questionnaire.getBasicQuestions();
		value = questionnaire.reportAnswers();
		userData = questionnaire.UserDetails();

//		String val
//		
		System.out.println("quection set 001::::: " + this.userData);

//		value = questionnaire.reportAnswers();

		// headers for the table
		String[] columns = new String[] { "Id", "Quection", "Answer Type", "Status", "" };
		DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < value.get(i).size(); j++) {
				Object[] data = new Object[] { j + 1, value.get(1).get(j), value.get(0).get(j), value.get(2).get(j),
						"Edit" };
				tableModel.addRow(data);
			}
		}

		String[] columns_user = new String[] { "ID", "Email", "First Name", "Last Name", "Status", "Super User", "" };
		DefaultTableModel tableModel_user = new DefaultTableModel(columns_user, 0);
		for (int i = 0; i < userData.size(); i++) {
				Object[] data = new Object[] { userData.get(i).getString("userid"), userData.get(i).getString("email"), userData.get(i).getString("firstname"), userData.get(i).getString("lastname"),userData.get(i).getBoolean("activeuser"),userData.get(i).getBoolean("superuser"),
						"Edit" };
				tableModel_user.addRow(data);
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminHome.class.getResource("/Images/PQ.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1036, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(232, 241, 248));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 59, 78));
		panel.setBounds(0, 57, 216, 621);
		contentPane.add(panel);
		panel.setLayout(null);

		JMenuItem mntmNewMenuItem = new JMenuItem("Dashboard");
		mntmNewMenuItem.setBackground(new Color(91, 98, 113));
		mntmNewMenuItem.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		mntmNewMenuItem.setIconTextGap(10);
		mntmNewMenuItem.setBorder(null);
		mntmNewMenuItem.setIcon(new ImageIcon(UserHome.class.getResource("/Images/home.png")));
		mntmNewMenuItem.setForeground(Color.WHITE);
		mntmNewMenuItem.setBounds(0, 0, 216, 59);
		panel.add(mntmNewMenuItem);

		JMenuItem mntmStudentQuiz = new JMenuItem("User Maintenance");
		mntmStudentQuiz.setBackground(new Color(51, 59, 78));
		mntmStudentQuiz.setIcon(new ImageIcon(AdminHome.class.getResource("/Images/user_ Maintenance.png")));
		mntmStudentQuiz.setIconTextGap(10);
		mntmStudentQuiz.setForeground(Color.WHITE);
		mntmStudentQuiz.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		mntmStudentQuiz.setBorder(null);
		mntmStudentQuiz.setBounds(0, 60, 216, 59);
		panel.add(mntmStudentQuiz);

		JMenuItem mntmQuizMaintenance = new JMenuItem("Quiz Maintenance");
		mntmQuizMaintenance.setIcon(new ImageIcon(AdminHome.class.getResource("/Images/question_ Maintenance.png")));
		mntmQuizMaintenance.setIconTextGap(10);
		mntmQuizMaintenance.setForeground(Color.WHITE);
		mntmQuizMaintenance.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		mntmQuizMaintenance.setBorder(null);
		mntmQuizMaintenance.setBackground(new Color(51, 59, 78));
		mntmQuizMaintenance.setBounds(0, 120, 216, 59);
		panel.add(mntmQuizMaintenance);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 169));
		panel_1.setBounds(0, 0, 216, 57);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel label = new JLabel("PATH QUIZ");
		label.setBounds(27, 16, 148, 30);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		panel_1.add(label);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(215, 0, 852, 57);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		Label label_1 = new Label("X");
		label_1.setBounds(781, 10, -29, 22);
		panel_2.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login frame = new Login();
				frame.setUndecorated(true);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				AdminHome.this.dispose();
			}
		});
		label_2.setIcon(new ImageIcon(AdminHome.class.getResource("/Images/close.png")));
		label_2.setBounds(775, 10, 46, 25);
		panel_2.add(label_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
//		contentPane.add(panel_4);
		panel_4.setBounds(236, 81, 784, 570);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setForeground(Color.BLACK);
		
//		JButton btnAddNewQuestion = new JButton("Add New Question");
//		btnAddNewQuestion.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				
//				Integer lbl_id;
//				String lbl_question = null;
//				String lbl_Status = null;
//				
//				final String[] status = { "Active", "Inactive" };
//				final String[] answer_type = { "RANGE" , "SINGLEOPT" , "JOB" , "EDULVL" , "USEROPT" , "CHOICE" , "CHOICE2" , "LOGICAL", "RATING" };
//				Boolean statusVal;
//
//				JTextField questionField = new JTextField(1);
//				questionField.setText(lbl_question);
//				JComboBox<String> statusList = new JComboBox<>(status);
//				statusList.setSelectedIndex(0);
//				JComboBox<String> answerTypeList = new JComboBox<>(answer_type);
//				answerTypeList.setSelectedIndex(0);
//		
//				JPanel myPanel = new JPanel(new GridLayout(10, 7));
//				myPanel.add(new JLabel("Question"));
//				myPanel.add(questionField);
//				myPanel.add(Box.createHorizontalStrut(15)); // a spacer
//				myPanel.add(new JLabel("Status"));
//				myPanel.add(statusList);
//				myPanel.add(Box.createHorizontalStrut(15)); // a spacer
//				myPanel.add(new JLabel("Answer Type"));
//				myPanel.add(answerTypeList);
//				
//				if(statusList.getSelectedItem().equals("Active")) {
//					statusVal = true;
//				} else {
//					statusVal = false;
//				}
//
//
//				Integer val;
//				int result = JOptionPane.showConfirmDialog(null, myPanel, "Add Question Panel", JOptionPane.OK_CANCEL_OPTION,
//						JOptionPane.PLAIN_MESSAGE);
//				if (result == JOptionPane.OK_OPTION) {
//					QuestionSet questionnaire = new QuestionSet();
//					val = questionnaire.addQuestionToSurvey(questionField.getText(), answerTypeList.getSelectedItem().toString(), statusVal);
//					if(val == 1) {
//						System.out.println("HI");
//					}
//				}
//			}
//		});
//		btnAddNewQuestion.setBackground(SystemColor.activeCaption);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(26)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
					.addContainerGap())
		);

		JTable table = new JTable(tableModel);
		table.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
		table.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JTextField()));
		table.getColumnModel().getColumn(0).setPreferredWidth(3);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);

		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.getTableHeader().setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		panel_5.setLayout(new BorderLayout(0, 0));
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setForeground(SystemColor.controlDkShadow);

		// add the table to the frame
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_5.add(scrollPane);
		panel_4.setLayout(gl_panel_4);

		Canvas canvas = new Canvas();
		canvas.setBackground(new Color(0, 191, 169));
		canvas.setBounds(236, 81, 784, 14);
		contentPane.add(canvas);


		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
//		contentPane.add(panel_6);
		panel_6.setBounds(236, 81, 784, 570);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setForeground(Color.BLACK);
		
		JButton btnAddNewUser = new JButton("Add New User");
		btnAddNewUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Integer lbl_id;
				String lbl_question = null;
				String lbl_Status = null;
				
				final String[] status = { "Active", "Inactive" };
				Boolean statusVal;
				Boolean superUserVal;

				JTextField email = new JTextField(1);
				JTextField firstnameField = new JTextField(1);
				JTextField lastnameField = new JTextField(1);
				JComboBox<String> superUserList = new JComboBox<>(status);
				superUserList.setSelectedIndex(0);
				
				JPanel myPanel = new JPanel(new GridLayout(15, 20));
				myPanel.add(new JLabel("Email (User Name)"));
				myPanel.add(email);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel("First Name"));
				myPanel.add(firstnameField);
				myPanel.add(Box.createHorizontalStrut(15)); // a spacer
				myPanel.add(new JLabel("Last Name"));
				myPanel.add(lastnameField);
				myPanel.add(Box.createHorizontalStrut(15)); 
				myPanel.add(new JLabel("Super User"));
				myPanel.add(superUserList); 
				
				
				if(superUserList.getSelectedItem().equals("Active")) {
					superUserVal = true;
				} else {
					superUserVal = false;
				}


				int val_user = 0;
				int result = JOptionPane.showConfirmDialog(null, myPanel, "Add User Panel", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					QuestionSet questionnaire = new QuestionSet();
					try {
						System.out.println("Login.username is :: " + Login.username);
						System.out.println("email.getText() is :: " + email.getText());
						System.out.println("firstnameField.getText() is :: " + firstnameField.getText());
						System.out.println("lastnameField.getText() is :: " + lastnameField.getText());
						System.out.println("superUserVal is :: " + superUserVal);
						val_user = questionnaire.createPaneUser(Login.username, email.getText(), firstnameField.getText(), lastnameField.getText(), superUserVal);
						questionnaire.UserDetails();
						if(val_user == 1) {
							System.out.println("HI");
						}
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});
		btnAddNewUser.setBackground(SystemColor.activeCaption);
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_6.createSequentialGroup()
							.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel_6.createSequentialGroup()
							.addComponent(btnAddNewUser)
							.addGap(29))))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(26)
					.addComponent(btnAddNewUser)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
					.addContainerGap())
		);

		JTable usrTable = new JTable(tableModel_user);
		usrTable.getColumnModel().getColumn(6).setCellRenderer(new ButtonRendererUser());
		usrTable.getColumnModel().getColumn(6).setCellEditor(new ButtonEditorUser(new JTextField()));
		usrTable.getColumnModel().getColumn(0).setPreferredWidth(3);
		usrTable.getColumnModel().getColumn(1).setPreferredWidth(250);

		usrTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		usrTable.getTableHeader().setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		panel_7.setLayout(new BorderLayout(0, 0));
		usrTable.setFont(new Font("Arial", Font.PLAIN, 14));
		usrTable.setForeground(SystemColor.controlDkShadow);

		// add the usrTable to the frame
		JScrollPane scrollPane_user = new JScrollPane(usrTable);
		scrollPane_user.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_7.add(scrollPane_user);
		panel_6.setLayout(gl_panel_6);

		Canvas canvas_user = new Canvas();
		canvas_user.setBackground(new Color(0, 191, 169));
		canvas_user.setBounds(236, 81, 784, 14);
		contentPane.add(canvas_user);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(236, 81, 784, 570);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnGetChartDetails = new JButton("Get Chart Details");
		btnGetChartDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Dashboard d = new Dashboard();
				d.main(null);
			}
		});
		btnGetChartDetails.setBounds(45, 63, 140, 23);
		panel_3.add(btnGetChartDetails);

//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setBounds(10, -248, 784, 570);
//		lblNewLabel.setIcon(new ImageIcon(AdminHome.class.getResource("/Images/bar.png")));
//		panel_3.add(lblNewLabel);

//		JLabel label_3 = new JLabel("");
//		label_3.setIcon(new ImageIcon(AdminHome.class.getResource("/Images/output-onlinepngtools (1).png")));
//		label_3.setBounds(68, 24, 628, 423);
//		panel_3.add(label_3);

//		JScrollPane  scrollPane = new JScrollPane (panel_3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		scrollPane.setEnabled(true);
//		scrollPane.setBounds(0, 0, 784, 570);
//		scrollPane.getViewport().setBackground(Color.WHITE);
//		panel_3.setAutoscrolls(true);

		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mntmNewMenuItem.setBackground(new Color(91, 98, 113));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (val == 0 || val == 2 || val == 3) {
					mntmNewMenuItem.setBackground(new Color(51, 59, 78));
				}

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				val = 1;
				mntmNewMenuItem.setBackground(new Color(91, 98, 113));
				mntmStudentQuiz.setBackground(new Color(51, 59, 78));
				mntmQuizMaintenance.setBackground(new Color(51, 59, 78));
				panel_4.setVisible(false);
				panel_6.setVisible(false);
				panel_3.setVisible(true);
			}
		});

		mntmStudentQuiz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mntmStudentQuiz.setBackground(new Color(91, 98, 113));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (val == 0 || val == 1 || val == 3) {
					mntmStudentQuiz.setBackground(new Color(51, 59, 78));
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				val = 2;
				mntmStudentQuiz.setBackground(new Color(91, 98, 113));
				mntmNewMenuItem.setBackground(new Color(51, 59, 78));
				mntmQuizMaintenance.setBackground(new Color(51, 59, 78));
				panel_4.setVisible(false);
				panel_3.setVisible(false);
				contentPane.add(panel_6);
				panel_6.setVisible(true);
			}
		});

		mntmQuizMaintenance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mntmQuizMaintenance.setBackground(new Color(91, 98, 113));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (val == 0 || val == 1 || val == 2) {
					mntmQuizMaintenance.setBackground(new Color(51, 59, 78));
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				val = 3;
				mntmQuizMaintenance.setBackground(new Color(91, 98, 113));
				mntmNewMenuItem.setBackground(new Color(51, 59, 78));
				mntmStudentQuiz.setBackground(new Color(51, 59, 78));
				panel_3.setVisible(false);
				panel_6.setVisible(false);
				contentPane.add(panel_4);
				panel_4.setVisible(true);
			}
		});
	}
}

//BUTTON RENDERER CLASS
class ButtonRenderer extends JButton implements TableCellRenderer {

//CONSTRUCTOR
	public ButtonRenderer() {
		// SET BUTTON PROPERTIES
		setOpaque(true);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected, boolean focused, int row,
			int col) {

		// SET PASSED OBJECT AS BUTTON TEXT
		setText((obj == null) ? "" : obj.toString());

		return this;
	}

}

//BUTTON RENDERER CLASS
class ButtonRendererUser extends JButton implements TableCellRenderer {

//CONSTRUCTOR
	public ButtonRendererUser() {
		// SET BUTTON PROPERTIES
		setOpaque(true);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected, boolean focused, int row,
			int col) {

		// SET PASSED OBJECT AS BUTTON TEXT
		setText((obj == null) ? "" : obj.toString());

		return this;
	}

}

//BUTTON EDITOR CLASS
class ButtonEditor extends DefaultCellEditor {
	protected JButton btn;
	private Integer lbl_id;
	private String lbl_question;
	private String lbl_Status;
	private Boolean clicked;

	public ButtonEditor(JTextField txt) {
		super(txt);

		btn = new JButton();
		btn.setOpaque(true);

		// WHEN BUTTON IS CLICKED
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				fireEditingStopped();
			}
		});
	}

	// OVERRIDE A COUPLE OF METHODS
	@Override
	public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected, int row, int col) {

		// SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
		lbl_id = Integer.parseInt(table.getValueAt(row, 0).toString())-1;
		lbl_question = table.getValueAt(row, 1).toString();
		lbl_Status = table.getValueAt(row, 3).toString();
	

		btn.setText(obj.toString());
		clicked = true;
		return btn;
	}

//IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
	@Override
	public Object getCellEditorValue() {

		if (clicked) {

			final String[] status = { "Active", "Inactive" };
			Boolean statusVal;

			JTextField questionField = new JTextField(1);
			questionField.setText(lbl_question);
			JComboBox<String> statusList = new JComboBox<>(status);
			statusList.setSelectedItem(lbl_Status);

			JPanel myPanel = new JPanel(new GridLayout(8, 5));
			myPanel.add(new JLabel("Question"));
			myPanel.add(questionField);
			myPanel.add(Box.createHorizontalStrut(15)); // a spacer
			myPanel.add(new JLabel("Status"));
			myPanel.add(statusList);
			
			if(statusList.getSelectedItem().equals("Active")) {
				statusVal = true;
			} else {
				statusVal = false;
			}

			Integer val;
			int result = JOptionPane.showConfirmDialog(null, myPanel, "Update Question Panel", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE);
			if (result == JOptionPane.OK_OPTION) {
				try {
					QuestionSet questionnaire = new QuestionSet();
					val = questionnaire.updateQuestionPane(questionField.getText(), lbl_id, statusVal);
					questionnaire.getBasicQuestions();
					
					if(val == 1) {
						System.out.println("HI");
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		// SET IT TO FALSE NOW THAT ITS CLICKED
		clicked = false;
		return new String("Edit");
	}

	@Override
	public boolean stopCellEditing() {

		// SET CLICKED TO FALSE FIRST
		clicked = false;
		return super.stopCellEditing();
	}

	@Override
	protected void fireEditingStopped() {
		// TODO Auto-generated method stub
		super.fireEditingStopped();
	}
}

//BUTTON EDITOR CLASS
class ButtonEditorUser extends DefaultCellEditor {
	protected JButton btn;
	private Integer lbl_id;
	private String lbl_username;
	private String lbl_firstname;
	private String lbl_lastname;
	private String lbl_Status;
	private String lbl_superUserStatus;
	private Boolean clicked;
	private Boolean isPasswordReset;

	public ButtonEditorUser(JTextField txt) {
		super(txt);

		btn = new JButton();
		btn.setOpaque(true);

		// WHEN BUTTON IS CLICKED
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				fireEditingStopped();
			}
		});
	}

	// OVERRIDE A COUPLE OF METHODS
	@Override
	public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected, int row, int col) {

		// SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
		lbl_id = Integer.parseInt(table.getValueAt(row, 0).toString())-1;
		lbl_username = table.getValueAt(row, 1).toString();
		lbl_firstname = table.getValueAt(row, 2).toString();
		lbl_lastname = table.getValueAt(row, 3).toString();
		lbl_Status = table.getValueAt(row, 4).toString();
		lbl_superUserStatus = table.getValueAt(row, 5).toString();
		

		btn.setText(obj.toString());
		clicked = true;
		return btn;
	}

//IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
	@Override
	public Object getCellEditorValue() {

		if (clicked) {

			final String[] status = { "true", "false" };
			Boolean statusVal;
			Boolean superUserStatusVal;
			
			JTextField firstnameField = new JTextField(1);
			firstnameField.setText(lbl_firstname);
			JTextField lastnameField = new JTextField(1);
			lastnameField.setText(lbl_lastname);
			JComboBox<String> statusList = new JComboBox<>(status);
			statusList.setSelectedItem(lbl_Status);
			JComboBox<String> superUserStatusList = new JComboBox<>(status);
			superUserStatusList.setSelectedItem(lbl_superUserStatus);

			JPanel myPanel = new JPanel(new GridLayout(15, 5));
			myPanel.add(new JLabel("First Name"));
			myPanel.add(firstnameField);
			myPanel.add(Box.createHorizontalStrut(15));
			myPanel.add(new JLabel("Last Name"));
			myPanel.add(lastnameField);
			myPanel.add(Box.createHorizontalStrut(15));
			myPanel.add(new JLabel("Status"));
			myPanel.add(statusList);
			myPanel.add(Box.createHorizontalStrut(15));
			myPanel.add(new JLabel("Super User"));
			myPanel.add(superUserStatusList);
			myPanel.add(Box.createHorizontalStrut(15));
			JCheckBox resetPassword = new JCheckBox("Reset Password");
			myPanel.add(resetPassword);  
			
			if(statusList.getSelectedItem().equals("Active")) {
				statusVal = true;
			} else {
				statusVal = false;
			}
			
			if(superUserStatusList.getSelectedItem().equals("Active")) {
				superUserStatusVal = true;
			} else {
				superUserStatusVal = false;
			}

			if(resetPassword.isSelected()) {
				isPasswordReset = true;
			} else {
				isPasswordReset = false;
			}
			
			Integer val;
			int result = JOptionPane.showConfirmDialog(null, myPanel, "Update User Panel", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE);
			if (result == JOptionPane.OK_OPTION) {
				QuestionSet questionnaire = new QuestionSet();
				try {
					val = questionnaire.updatePaneUser(Login.username, lbl_username, firstnameField.getText(), lastnameField.getText(), superUserStatusVal, isPasswordReset, statusVal);
					if(val == 1) {
						System.out.println("HI");
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		}
		// SET IT TO FALSE NOW THAT ITS CLICKED
		clicked = false;
		return new String("Edit");
	}

	@Override
	public boolean stopCellEditing() {

		// SET CLICKED TO FALSE FIRST
		clicked = false;
		return super.stopCellEditing();
	}

	@Override
	protected void fireEditingStopped() {
		// TODO Auto-generated method stub
		super.fireEditingStopped();
	}
}
