package com.perisic.peripherals;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.bson.Document;

import com.perisic.questionnaire.QuestionSet;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Canvas;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import java.awt.Toolkit;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class UserHome extends JFrame {

	private QuestionSet questionnaire = new QuestionSet();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private int val = 0;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup1 = new ButtonGroup();
	private final ButtonGroup buttonGroup2 = new ButtonGroup();
	private final ButtonGroup buttonGroup3 = new ButtonGroup();
	private final ButtonGroup buttonGroup4 = new ButtonGroup();
	private final ButtonGroup buttonGroup5 = new ButtonGroup();
	private final ButtonGroup buttonGroup6 = new ButtonGroup();
	private final ButtonGroup buttonGroup7 = new ButtonGroup();
	private final ButtonGroup buttonGroup8 = new ButtonGroup();
	private final ButtonGroup buttonGroup9 = new ButtonGroup();
	private final ButtonGroup buttonGroup10 = new ButtonGroup();
	private static ArrayList<ArrayList<String>> questionList;
	private ArrayList<Document> answeList;
	Login login = new Login();
	public String  finalSurveyAnalyData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {


			public void run() {
				try {
					QuestionSet questionnaire = new QuestionSet();
					questionnaire.getBasicQuestions();
					questionList = questionnaire.reportAnswers();

					UserHome frame = new UserHome();
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
	 * @throws RemoteException 
	 */
	public UserHome() throws RemoteException {

		try {

			QuestionSet questionnaire = new QuestionSet();
			questionList = questionnaire.reportAnswers();

		} catch (Exception e) {
			// TODO: handle exception
		}

		setIconImage(Toolkit.getDefaultToolkit().getImage(UserHome.class.getResource("/Images/PQ.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1036, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(232, 241, 248));

		// JPanel panel = new JPanel();
		// panel.setBackground(new Color(51, 59, 78));
		// panel.setBounds(0, 57, 216, 621);
		// contentPane.add(panel);

		// JMenuItem mntmNewMenuItem = new JMenuItem("Dashboard");
		// mntmNewMenuItem.setBounds(0, 0, 216, 59);
		// mntmNewMenuItem.setBackground(new Color(91, 98, 113));
		// mntmNewMenuItem.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		// mntmNewMenuItem.setIconTextGap(10);
		// mntmNewMenuItem.setBorder(null);
		// mntmNewMenuItem.setIcon(new
		// ImageIcon(UserHome.class.getResource("/Images/home.png")));
		// panel.setLayout(null);
		// mntmNewMenuItem.setForeground(Color.WHITE);
		// panel.add(mntmNewMenuItem);

		// JMenuItem mntmStudentQuiz = new JMenuItem("Quiz Portal");
		// mntmStudentQuiz.setBounds(0, 60, 216, 59);
		// mntmStudentQuiz.setBackground(new Color(51, 59, 78));
		// mntmStudentQuiz.setIcon(new
		// ImageIcon(UserHome.class.getResource("/Images/quiz.png")));
		// mntmStudentQuiz.setIconTextGap(10);
		// mntmStudentQuiz.setForeground(Color.WHITE);
		// mntmStudentQuiz.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		// mntmStudentQuiz.setBorder(null);
		// panel.add(mntmStudentQuiz);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 169));
		panel_1.setBounds(0, 0, 216, 57);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblPathQuiz = new JLabel("PATH QUIZ");
		lblPathQuiz.setBounds(27, 16, 148, 30);
		lblPathQuiz.setForeground(Color.WHITE);
		lblPathQuiz.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		panel_1.add(lblPathQuiz);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(215, 0, 852, 57);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lbluser = new JLabel("Hi " + login.firstname);
		lbluser.setBounds(500, 1, 250, 50);
		lbluser.setForeground(new Color(0,128,128));
		lbluser.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		panel_2.add(lbluser);
		
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
				Login frame = new Login();
				frame.setUndecorated(true);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				UserHome.this.dispose();
			}
		});
		btn_exit.setIcon(new ImageIcon(Login.class.getResource("/Images/close.png")));
		btn_exit.setBounds(770, -12, 50, 50);
		panel_2.add(btn_exit);

		JPanel panel_Quiz = new JPanel();
		panel_Quiz.setBackground(Color.WHITE);
		panel_Quiz.setBounds(12, 81, 1008, 570);

		Panel panel_Quiz3 = new Panel();
		panel_Quiz3.setBackground(Color.WHITE);
		panel_Quiz3.setBounds(12, 81, 1008, 570);
		
		JLabel label_topBar03 = new JLabel("");
		label_topBar03.setForeground(new Color(0, 191, 169));
		label_topBar03.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		panel_Quiz3.add(label_topBar03);
		
		JTextArea  textArea = new JTextArea();
		textArea.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
	    textArea.setWrapStyleWord(true);
	    textArea.setLineWrap(true);
	    textArea.setOpaque(false);
	    textArea.setEditable(false);
	    textArea.setFocusable(false);
	    textArea.setBackground(UIManager.getColor("Label.background"));
	    textArea.setBorder(UIManager.getBorder("Label.border"));
		panel_Quiz3.add(textArea);
		GroupLayout gl_panel_Quiz3 = new GroupLayout(panel_Quiz3);
		gl_panel_Quiz3.setHorizontalGroup(
			gl_panel_Quiz3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Quiz3.createSequentialGroup()
					.addGroup(gl_panel_Quiz3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_Quiz3.createSequentialGroup()
							.addGap(4)
							.addComponent(label_topBar03))
						.addGroup(gl_panel_Quiz3.createSequentialGroup()
							.addGap(50)
							.addComponent(textArea)))
					.addContainerGap(504, Short.MAX_VALUE))
		);
		gl_panel_Quiz3.setVerticalGroup(
			gl_panel_Quiz3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Quiz3.createSequentialGroup()
					.addGap(8)
					.addComponent(label_topBar03)
					.addGap(50)
					.addComponent(textArea)
					.addContainerGap(429, Short.MAX_VALUE))
		);
		panel_Quiz3.setLayout(gl_panel_Quiz3);
		
		Panel panel_Quiz2 = new Panel();
		panel_Quiz2.setBackground(Color.WHITE);
		panel_Quiz2.setBounds(12, 81, 1008, 570);

		JLabel label_1 = new JLabel("");
		label_1.setForeground(new Color(0, 191, 169));
		label_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
		panel_Quiz2.add(label_1);

		JLabel lblNewLabel_3 = new JLabel("This is your quection form. Please fill it out with somthing awesome!");
		lblNewLabel_3.setForeground(new Color(51, 51, 51));
		lblNewLabel_3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(UserHome.class.getResource("/Images/six.png")));

		JLabel lblNewLabel_4 = new JLabel(questionList.get(1).get(6));
		lblNewLabel_4.setForeground(new Color(51, 51, 51));
		lblNewLabel_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));

		JRadioButton rdbtnAsk = new JRadioButton("Ask People");
		rdbtnAsk.setActionCommand("Ask People");
		buttonGroup6.add(rdbtnAsk);
		rdbtnAsk.setForeground(new Color(153, 153, 153));
		rdbtnAsk.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		rdbtnAsk.setBackground(Color.WHITE);

		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Search for It");
		rdbtnNewRadioButton_3.setActionCommand("Search for It");
		buttonGroup6.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setForeground(new Color(153, 153, 153));
		rdbtnNewRadioButton_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		rdbtnNewRadioButton_3.setBackground(Color.WHITE);

		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Reaserch");
		rdbtnNewRadioButton_4.setActionCommand("Reaserch");
		buttonGroup6.add(rdbtnNewRadioButton_4);
		rdbtnNewRadioButton_4.setForeground(new Color(153, 153, 153));
		rdbtnNewRadioButton_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		rdbtnNewRadioButton_4.setBackground(Color.WHITE);

		JLabel label_5 = new JLabel("");

		JButton btnPrv = new JButton("Prvious");
		
		JLabel lblDoYouLike = new JLabel(questionList.get(1).get(7));
		lblDoYouLike.setForeground(new Color(51, 51, 51));
		lblDoYouLike.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		
		JRadioButton rdbtnYes_1 = new JRadioButton("Yes");
		rdbtnYes_1.setActionCommand("Yes");
		buttonGroup7.add(rdbtnYes_1);
		rdbtnYes_1.setForeground(new Color(153, 153, 153));
		rdbtnYes_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		rdbtnYes_1.setBackground(Color.WHITE);
		
		JRadioButton rdbtnNo_1 = new JRadioButton("No");
		rdbtnNo_1.setActionCommand("No");
		buttonGroup7.add(rdbtnNo_1);
		rdbtnNo_1.setForeground(new Color(153, 153, 153));
		rdbtnNo_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		rdbtnNo_1.setBackground(Color.WHITE);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(UserHome.class.getResource("/Images/seven.png")));
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(UserHome.class.getResource("/Images/eight.png")));
		
		JLabel lblIfTheresA = new JLabel(questionList.get(1).get(8));
		lblIfTheresA.setForeground(new Color(51, 51, 51));
		lblIfTheresA.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		
		JRadioButton rdbtnTakeIt = new JRadioButton("Take it");
		rdbtnTakeIt.setActionCommand("Take it");
		buttonGroup8.add(rdbtnTakeIt);
		rdbtnTakeIt.setForeground(new Color(153, 153, 153));
		rdbtnTakeIt.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		rdbtnTakeIt.setBackground(Color.WHITE);
		
		JRadioButton rdbtnLeveIt = new JRadioButton("Leave it");
		rdbtnLeveIt.setActionCommand("Leave it");
		buttonGroup8.add(rdbtnLeveIt);
		rdbtnLeveIt.setForeground(new Color(153, 153, 153));
		rdbtnLeveIt.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		rdbtnLeveIt.setBackground(Color.WHITE);
		
		JLabel lblIfThereIs = new JLabel(questionList.get(1).get(9));
		lblIfThereIs.setForeground(new Color(51, 51, 51));
		lblIfThereIs.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		
		JRadioButton rdbtnCareer = new JRadioButton("Career");
		rdbtnCareer.setActionCommand("Career");
		buttonGroup9.add(rdbtnCareer);
		rdbtnCareer.setForeground(new Color(153, 153, 153));
		rdbtnCareer.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		rdbtnCareer.setBackground(Color.WHITE);
		
		JRadioButton rdbtnMoney = new JRadioButton("Money");
		rdbtnMoney.setActionCommand("Money");
		buttonGroup9.add(rdbtnMoney);
		rdbtnMoney.setForeground(new Color(153, 153, 153));
		rdbtnMoney.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		rdbtnMoney.setBackground(Color.WHITE);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(UserHome.class.getResource("/Images/nine.png")));
		
		JButton btnNext_1 = new JButton("Next");
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(UserHome.class.getResource("/Images/ten.png")));
		
		JLabel lblInADarkroom = new JLabel(questionList.get(1).get(11));
		lblInADarkroom.setForeground(new Color(51, 51, 51));
		lblInADarkroom.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		
		JRadioButton rdbtnTheNewspaper = new JRadioButton("The Newspaper");
		rdbtnTheNewspaper.setActionCommand("The Newspaper");
		buttonGroup10.add(rdbtnTheNewspaper);
		rdbtnTheNewspaper.setForeground(new Color(153, 153, 153));
		rdbtnTheNewspaper.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		rdbtnTheNewspaper.setBackground(Color.WHITE);
		
		JRadioButton rdbtnTheLamp = new JRadioButton("The Lamp");
		rdbtnTheLamp.setActionCommand("The Lamp");
		buttonGroup10.add(rdbtnTheLamp);
		rdbtnTheLamp.setForeground(new Color(153, 153, 153));
		rdbtnTheLamp.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		rdbtnTheLamp.setBackground(Color.WHITE);
		
		JRadioButton rdbtnTheCandle = new JRadioButton("The Candle");
		rdbtnTheCandle.setActionCommand("The Candle");
		buttonGroup10.add(rdbtnTheCandle);
		rdbtnTheCandle.setForeground(new Color(153, 153, 153));
		rdbtnTheCandle.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		rdbtnTheCandle.setBackground(Color.WHITE);
		
		JRadioButton rdbtnTheMatch = new JRadioButton("The Match");
		rdbtnTheMatch.setActionCommand("The Match");
		buttonGroup10.add(rdbtnTheMatch);
		rdbtnTheMatch.setForeground(new Color(153, 153, 153));
		rdbtnTheMatch.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		rdbtnTheMatch.setBackground(Color.WHITE);

		GroupLayout gl_panel_Quiz2 = new GroupLayout(panel_Quiz2);
		gl_panel_Quiz2.setHorizontalGroup(
			gl_panel_Quiz2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Quiz2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_Quiz2.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3)
						.addComponent(label_5))
					.addGap(16)
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(529, Short.MAX_VALUE))
				.addGroup(gl_panel_Quiz2.createSequentialGroup()
					.addComponent(label_1)
					.addContainerGap(1008, Short.MAX_VALUE))
				.addGroup(gl_panel_Quiz2.createSequentialGroup()
					.addGap(75)
					.addComponent(rdbtnAsk)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnNewRadioButton_3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnNewRadioButton_4)
					.addContainerGap(608, Short.MAX_VALUE))
				.addGroup(gl_panel_Quiz2.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(lblDoYouLike, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(558, Short.MAX_VALUE))
				.addGroup(gl_panel_Quiz2.createSequentialGroup()
					.addGap(79)
					.addComponent(rdbtnYes_1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(rdbtnNo_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(703, Short.MAX_VALUE))
				.addGroup(gl_panel_Quiz2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_Quiz2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_Quiz2.createSequentialGroup()
							.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addComponent(lblIfThereIs, GroupLayout.PREFERRED_SIZE, 710, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_Quiz2.createSequentialGroup()
							.addGap(73)
							.addComponent(rdbtnCareer, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(rdbtnMoney, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(248, Short.MAX_VALUE))
				.addGroup(gl_panel_Quiz2.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblInADarkroom, GroupLayout.PREFERRED_SIZE, 898, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(58, Short.MAX_VALUE))
				.addGroup(gl_panel_Quiz2.createSequentialGroup()
					.addGap(89)
					.addComponent(rdbtnTheNewspaper, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnTheLamp, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnTheCandle, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnTheMatch, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(437, Short.MAX_VALUE))
				.addGroup(gl_panel_Quiz2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_Quiz2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_Quiz2.createSequentialGroup()
							.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addComponent(lblIfTheresA, GroupLayout.PREFERRED_SIZE, 710, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_Quiz2.createSequentialGroup()
							.addGap(73)
							.addComponent(rdbtnTakeIt, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(rdbtnLeveIt, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(248, Short.MAX_VALUE))
				.addGroup(gl_panel_Quiz2.createSequentialGroup()
					.addGap(65)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 634, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(309, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_Quiz2.createSequentialGroup()
					.addContainerGap(826, Short.MAX_VALUE)
					.addComponent(btnPrv)
					.addGap(18)
					.addComponent(btnNext_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(30))
		);
		gl_panel_Quiz2.setVerticalGroup(
			gl_panel_Quiz2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Quiz2.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_1)
					.addGap(26)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_Quiz2.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_3)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_Quiz2.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnAsk)
						.addComponent(rdbtnNewRadioButton_3)
						.addComponent(rdbtnNewRadioButton_4))
					.addGap(18)
					.addGroup(gl_panel_Quiz2.createParallelGroup(Alignment.LEADING)
						.addComponent(label_5)
						.addGroup(gl_panel_Quiz2.createSequentialGroup()
							.addGroup(gl_panel_Quiz2.createParallelGroup(Alignment.LEADING)
								.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_Quiz2.createSequentialGroup()
									.addGap(5)
									.addComponent(lblDoYouLike, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_Quiz2.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnYes_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnNo_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_Quiz2.createParallelGroup(Alignment.LEADING)
								.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_Quiz2.createSequentialGroup()
									.addGap(5)
									.addComponent(lblIfTheresA, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
							.addGap(7)
							.addGroup(gl_panel_Quiz2.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnTakeIt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnLeveIt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_Quiz2.createParallelGroup(Alignment.LEADING)
								.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_Quiz2.createSequentialGroup()
									.addGap(5)
									.addComponent(lblIfThereIs, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
							.addGap(7)
							.addGroup(gl_panel_Quiz2.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnCareer, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnMoney, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(8)
							.addGroup(gl_panel_Quiz2.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblInADarkroom, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_Quiz2.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnTheNewspaper, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_Quiz2.createParallelGroup(Alignment.BASELINE)
									.addComponent(rdbtnTheLamp, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addComponent(rdbtnTheCandle, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
								.addComponent(rdbtnTheMatch, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
					.addGap(36)
					.addGroup(gl_panel_Quiz2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPrv)
						.addComponent(btnNext_1))
					.addGap(89))
		);
		panel_Quiz2.setLayout(gl_panel_Quiz2);

		System.out.println("ispaticipated is :: " + Login.ispaticipated );
		if(Login.ispaticipated == false) {
			contentPane.add(panel_Quiz);
		} else {
			contentPane.add(panel_Quiz3);
			String val = questionnaire.finalSurveyAnaly(Login.username);
			System.out.println("val is ::" + val);
			if(val.contentEquals("freelancer")) {
				panel_Quiz.setVisible(false);
				panel_Quiz2.setVisible(false);
				finalSurveyAnalyData = "Thank you for joining with the Path-Quiz service. We've been reviewing the answers to our questions. We think you're good at self-employment. We're also recommending that you to do freelancing. ";
				textArea.setText(finalSurveyAnalyData);
				label_topBar03.setIcon(new ImageIcon(UserHome.class.getResource("/Images/top_bar_03.png")));
				contentPane.add(panel_Quiz3);
				panel_Quiz3.setVisible(true);
			} else if(val.contentEquals("social")) {
				panel_Quiz.setVisible(false);
				panel_Quiz2.setVisible(false);
				finalSurveyAnalyData = "Thank you for joining with the Path-Quiz service. We've been reviewing the answers to our questions. We think you're good at socialist-employment. We're also recommending that you to do social related works. ";
				textArea.setText(finalSurveyAnalyData);
				label_topBar03.setIcon(new ImageIcon(UserHome.class.getResource("/Images/top_bar_03.png")));
				contentPane.add(panel_Quiz3);
				panel_Quiz3.setVisible(true);							
			}
		}
		
		
		Canvas canvas = new Canvas();
		canvas.setForeground(Color.BLACK);
		canvas.setBackground(new Color(0, 191, 169));

		for (int i = 0; i < 1; i++) {

			JLabel lblNewLabel = new JLabel(questionList.get(1).get(2));
			lblNewLabel.setForeground(new Color(51, 51, 51));
			lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));

			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(UserHome.class.getResource("/Images/one.png")));

			textField = new JTextField();
			textField.setBackground(new Color(222, 255, 249));
			textField.setBorder(new EmptyBorder(5, 5, 5, 5));
			textField.setColumns(10);

			JLabel lblAreYouWorking_1 = new JLabel(questionList.get(1).get(0));
			lblAreYouWorking_1.setForeground(new Color(51, 51, 51));
			lblAreYouWorking_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));

			JLabel label_2 = new JLabel("");
			label_2.setIcon(new ImageIcon(UserHome.class.getResource("/Images/two.png")));

			JLabel lblWhatIsYour = new JLabel(questionList.get(1).get(3));
			lblWhatIsYour.setForeground(new Color(51, 51, 51));
			lblWhatIsYour.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));

			JLabel label_4 = new JLabel("");
			label_4.setIcon(new ImageIcon(UserHome.class.getResource("/Images/three.png")));

			JLabel lblAreYouWorking = new JLabel(questionList.get(1).get(4));
			lblAreYouWorking.setForeground(new Color(51, 51, 51));
			lblAreYouWorking.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));

			JLabel label_6 = new JLabel("");
			label_6.setIcon(new ImageIcon(UserHome.class.getResource("/Images/four.png")));

			JRadioButton rdbtnYes = new JRadioButton("Yes");
			rdbtnYes.setActionCommand("Yes");
			buttonGroup1.add(rdbtnYes);
			rdbtnYes.setForeground(new Color(153, 153, 153));
			rdbtnYes.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
			rdbtnYes.setBackground(Color.WHITE);

			JRadioButton rdbtnNo = new JRadioButton("No");
			rdbtnNo.setActionCommand("No");
			buttonGroup1.add(rdbtnNo);
			rdbtnNo.setForeground(new Color(153, 153, 153));
			rdbtnNo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
			rdbtnNo.setBackground(Color.WHITE);

			JLabel Bar_01 = new JLabel("");
			Bar_01.setIcon(new ImageIcon(UserHome.class.getResource("/Images/top_bar_01.png")));
			Bar_01.setForeground(new Color(0, 191, 169));
			Bar_01.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));

			JLabel lblNewLabel_2 = new JLabel("This is your quection form. Please fill it out with somthing awesome!");
			lblNewLabel_2.setForeground(new Color(51, 51, 51));
			lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));

			JRadioButton rdbtnAl = new JRadioButton("A/L");
			rdbtnAl.setActionCommand("A/L");
			buttonGroup2.add(rdbtnAl);
			rdbtnAl.setForeground(new Color(153, 153, 153));
			rdbtnAl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
			rdbtnAl.setBackground(Color.WHITE);

			JRadioButton rdbtnOl = new JRadioButton("O/L");
			rdbtnOl.setActionCommand("O/L");
			buttonGroup2.add(rdbtnOl);
			rdbtnOl.setForeground(new Color(153, 153, 153));
			rdbtnOl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
			rdbtnOl.setBackground(Color.WHITE);

			JRadioButton rdbtnHnd = new JRadioButton("HND");
			rdbtnHnd.setActionCommand("HND");
			buttonGroup2.add(rdbtnHnd);
			rdbtnHnd.setForeground(new Color(153, 153, 153));
			rdbtnHnd.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
			rdbtnHnd.setBackground(Color.WHITE);

			JRadioButton rdbtnDiploma = new JRadioButton("Diploma");
			rdbtnDiploma.setActionCommand("Diploma");
			buttonGroup2.add(rdbtnDiploma);
			rdbtnDiploma.setForeground(new Color(153, 153, 153));
			rdbtnDiploma.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
			rdbtnDiploma.setBackground(Color.WHITE);

			JRadioButton rdbtnDegree = new JRadioButton("Digree");
			rdbtnDegree.setActionCommand("Digree");
			buttonGroup2.add(rdbtnDegree);
			rdbtnDegree.setForeground(new Color(153, 153, 153));
			rdbtnDegree.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
			rdbtnDegree.setBackground(Color.WHITE);

			JLabel lblWhatKindOf = new JLabel(questionList.get(1).get(1));
			lblWhatKindOf.setForeground(new Color(51, 51, 51));
			lblWhatKindOf.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
			lblWhatKindOf.setVisible(false);

			JRadioButton rdbtnSocial = new JRadioButton("Social");
			rdbtnSocial.setActionCommand("Social");
			buttonGroup3.add(rdbtnSocial);
			rdbtnSocial.setForeground(new Color(153, 153, 153));
			rdbtnSocial.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
			rdbtnSocial.setBackground(Color.WHITE);
			rdbtnSocial.setVisible(false);

			JRadioButton rdbtnFreelance = new JRadioButton("Freelance");
			rdbtnFreelance.setActionCommand("Freelance");
			buttonGroup3.add(rdbtnFreelance);
			rdbtnFreelance.setForeground(new Color(153, 153, 153));
			rdbtnFreelance.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
			rdbtnFreelance.setBackground(Color.WHITE);
			rdbtnFreelance.setVisible(false);

			JRadioButton rdbtnSkip = new JRadioButton("Skip");
			rdbtnSkip.setActionCommand("Skip");
			buttonGroup3.add(rdbtnSkip);
			rdbtnSkip.setForeground(new Color(153, 153, 153));
			rdbtnSkip.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
			rdbtnSkip.setBackground(Color.WHITE);
			rdbtnSkip.setVisible(false);

			JLabel lblWhatIsYour_1 = new JLabel(questionList.get(1).get(10));
			lblWhatIsYour_1.setForeground(new Color(51, 51, 51));
			lblWhatIsYour_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
			lblWhatIsYour_1.setVisible(false);

			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBorder(new EmptyBorder(5, 5, 5, 5));
			textField_1.setBackground(new Color(222, 255, 249));
			textField_1.setVisible(false);

			// JScrollPane scrollPane = new JScrollPane(panel_Quiz,
			// JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			// JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			// scrollPane.setEnabled(true);
			// scrollPane.setBounds(236, 81, 784, 570);
			// scrollPane.getViewport().setBackground(Color.WHITE);
			// panel_Quiz.setAutoscrolls(true);

			JRadioButton rdbtnPoor = new JRadioButton("Poor");
			rdbtnPoor.setActionCommand("Poor");
			buttonGroup4.add(rdbtnPoor);
			rdbtnPoor.setForeground(new Color(153, 153, 153));
			rdbtnPoor.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
			rdbtnPoor.setBackground(Color.WHITE);

			JRadioButton rdbtnNewRadioButton = new JRadioButton("Good");
			rdbtnNewRadioButton.setActionCommand("Good");
			buttonGroup4.add(rdbtnNewRadioButton);
			rdbtnNewRadioButton.setForeground(new Color(153, 153, 153));
			rdbtnNewRadioButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
			rdbtnNewRadioButton.setBackground(Color.WHITE);

			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Very Good");
			rdbtnNewRadioButton_1.setActionCommand("Very Good");
			buttonGroup4.add(rdbtnNewRadioButton_1);
			rdbtnNewRadioButton_1.setForeground(new Color(153, 153, 153));
			rdbtnNewRadioButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
			rdbtnNewRadioButton_1.setBackground(Color.WHITE);

			JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Excelent");
			rdbtnNewRadioButton_2.setActionCommand("Excelent");
			buttonGroup4.add(rdbtnNewRadioButton_2);
			rdbtnNewRadioButton_2.setForeground(new Color(153, 153, 153));
			rdbtnNewRadioButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
			rdbtnNewRadioButton_2.setBackground(Color.WHITE);

			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(UserHome.class.getResource("/Images/five.png")));

			JLabel lblHowYouIntracting = new JLabel(questionList.get(1).get(5));
			lblHowYouIntracting.setForeground(new Color(51, 51, 51));
			lblHowYouIntracting.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));

			JRadioButton rdbtnPoor_1 = new JRadioButton("Poor");
			rdbtnPoor_1.setActionCommand("Poor");
			buttonGroup5.add(rdbtnPoor_1);
			rdbtnPoor_1.setForeground(new Color(153, 153, 153));
			rdbtnPoor_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
			rdbtnPoor_1.setBackground(Color.WHITE);

			JRadioButton rdbtnGood = new JRadioButton("Good");
			rdbtnGood.setActionCommand("Good");
			buttonGroup5.add(rdbtnGood);
			rdbtnGood.setForeground(new Color(153, 153, 153));
			rdbtnGood.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
			rdbtnGood.setBackground(Color.WHITE);

			JRadioButton rdbtnVeryGood = new JRadioButton("Very Good");
			rdbtnVeryGood.setActionCommand("Very Good");
			buttonGroup5.add(rdbtnVeryGood);
			rdbtnVeryGood.setForeground(new Color(153, 153, 153));
			rdbtnVeryGood.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
			rdbtnVeryGood.setBackground(Color.WHITE);

			JRadioButton rdbtnExcelent = new JRadioButton("Excelent");
			rdbtnExcelent.setActionCommand("Excelent");
			buttonGroup5.add(rdbtnExcelent);
			rdbtnExcelent.setForeground(new Color(153, 153, 153));
			rdbtnExcelent.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
			rdbtnExcelent.setBackground(Color.WHITE);

			JButton btnNext = new JButton("Next");
			GroupLayout gl_panel_Quiz = new GroupLayout(panel_Quiz);
			gl_panel_Quiz.setHorizontalGroup(gl_panel_Quiz.createParallelGroup(Alignment.LEADING)
					.addComponent(Bar_01, GroupLayout.PREFERRED_SIZE, 1012, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_Quiz.createSequentialGroup().addGap(65).addComponent(lblNewLabel_2,
							GroupLayout.PREFERRED_SIZE, 634, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_Quiz.createSequentialGroup().addGap(26)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_Quiz.createSequentialGroup().addGap(59).addComponent(textField,
							GroupLayout.PREFERRED_SIZE, 708, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_Quiz.createSequentialGroup().addGap(26)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblAreYouWorking_1, GroupLayout.PREFERRED_SIZE, 400,
									GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_Quiz.createSequentialGroup().addGap(59)
							.addComponent(rdbtnYes, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(rdbtnNo, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_Quiz.createSequentialGroup().addGap(59)
							.addComponent(rdbtnSocial, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(rdbtnFreelance, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addComponent(rdbtnSkip, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_Quiz.createSequentialGroup().addGap(59).addComponent(textField_1,
							GroupLayout.PREFERRED_SIZE, 708, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_Quiz.createSequentialGroup().addGap(26)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblWhatIsYour, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_Quiz.createSequentialGroup().addGap(59)
							.addComponent(rdbtnOl, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE).addGap(4)
							.addComponent(rdbtnAl, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE).addGap(2)
							.addComponent(rdbtnDiploma, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(rdbtnHnd, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(rdbtnDegree, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_Quiz.createSequentialGroup().addGap(26)
							.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblAreYouWorking,
									GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_Quiz.createSequentialGroup().addGap(59).addComponent(rdbtnPoor).addGap(2)
							.addComponent(rdbtnNewRadioButton).addComponent(rdbtnNewRadioButton_1).addGap(2)
							.addComponent(rdbtnNewRadioButton_2))
					.addGroup(gl_panel_Quiz.createSequentialGroup().addGap(26).addComponent(lblNewLabel_1).addGap(14)
							.addComponent(lblHowYouIntracting, GroupLayout.PREFERRED_SIZE, 250,
									GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_Quiz.createSequentialGroup().addGap(64).addComponent(rdbtnPoor_1).addGap(4)
							.addComponent(rdbtnGood).addGap(4).addComponent(rdbtnVeryGood).addComponent(rdbtnExcelent)
							.addGap(510).addComponent(btnNext))
					.addGroup(gl_panel_Quiz.createSequentialGroup().addGap(59).addComponent(lblWhatKindOf,
							GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_Quiz.createSequentialGroup().addGap(59).addComponent(lblWhatIsYour_1,
							GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)));
			gl_panel_Quiz.setVerticalGroup(gl_panel_Quiz.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_Quiz.createSequentialGroup().addGap(11)
							.addComponent(Bar_01, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE).addGap(12)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addGroup(gl_panel_Quiz.createParallelGroup(Alignment.LEADING)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panel_Quiz.createSequentialGroup().addGap(1).addComponent(lblNewLabel,
											GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
							.addGap(6)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addGroup(gl_panel_Quiz.createParallelGroup(Alignment.LEADING)
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panel_Quiz
											.createSequentialGroup().addGap(1).addComponent(lblAreYouWorking_1,
													GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
							.addGap(7)
							.addGroup(gl_panel_Quiz.createParallelGroup(Alignment.LEADING)
									.addComponent(rdbtnYes, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
									.addComponent(rdbtnNo, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblWhatKindOf, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addGroup(gl_panel_Quiz.createParallelGroup(Alignment.LEADING)
									.addComponent(rdbtnSocial, GroupLayout.PREFERRED_SIZE, 23,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(rdbtnFreelance, GroupLayout.PREFERRED_SIZE, 23,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(rdbtnSkip, GroupLayout.PREFERRED_SIZE, 23,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblWhatIsYour_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addGroup(gl_panel_Quiz.createParallelGroup(Alignment.LEADING)
									.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panel_Quiz.createSequentialGroup().addGap(1).addComponent(
											lblWhatIsYour, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
							.addGap(7)
							.addGroup(gl_panel_Quiz.createParallelGroup(Alignment.LEADING)
									.addComponent(rdbtnOl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
									.addComponent(rdbtnAl, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
									.addComponent(rdbtnDiploma, GroupLayout.PREFERRED_SIZE, 23,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(rdbtnHnd, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panel_Quiz.createSequentialGroup().addGap(2).addComponent(rdbtnDegree,
											GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
							.addGap(2)
							.addGroup(gl_panel_Quiz.createParallelGroup(Alignment.LEADING)
									.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panel_Quiz
											.createSequentialGroup().addGap(1).addComponent(lblAreYouWorking,
													GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
							.addGap(7)
							.addGroup(gl_panel_Quiz.createParallelGroup(Alignment.LEADING).addComponent(rdbtnPoor)
									.addComponent(rdbtnNewRadioButton).addComponent(rdbtnNewRadioButton_1)
									.addComponent(rdbtnNewRadioButton_2))
							.addGap(4)
							.addGroup(gl_panel_Quiz.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_1)
									.addComponent(lblHowYouIntracting, GroupLayout.PREFERRED_SIZE, 26,
											GroupLayout.PREFERRED_SIZE))
							.addGap(8)
							.addGroup(gl_panel_Quiz.createParallelGroup(Alignment.LEADING).addComponent(rdbtnPoor_1)
									.addComponent(rdbtnGood).addComponent(rdbtnVeryGood).addComponent(rdbtnExcelent)
									.addGroup(gl_panel_Quiz.createSequentialGroup().addGap(9).addComponent(btnNext)))));
			panel_Quiz.setLayout(gl_panel_Quiz);
			panel_Quiz.add(lblNewLabel_2);
			panel_Quiz.add(label);
			panel_Quiz.add(lblNewLabel);
			panel_Quiz.add(textField);
			panel_Quiz.add(label_2);
			panel_Quiz.add(lblAreYouWorking_1);
			panel_Quiz.add(rdbtnYes);
			panel_Quiz.add(rdbtnNo);
			panel_Quiz.add(lblWhatKindOf);
			panel_Quiz.add(rdbtnSocial);
			panel_Quiz.add(rdbtnFreelance);
			panel_Quiz.add(rdbtnSkip);
			panel_Quiz.add(lblWhatIsYour_1);
			panel_Quiz.add(textField_1);
			panel_Quiz.add(label_4);
			panel_Quiz.add(lblWhatIsYour);
			panel_Quiz.add(rdbtnOl);
			panel_Quiz.add(rdbtnAl);
			panel_Quiz.add(rdbtnDiploma);
			panel_Quiz.add(rdbtnHnd);
			panel_Quiz.add(rdbtnDegree);
			panel_Quiz.add(label_6);
			panel_Quiz.add(lblAreYouWorking);
			panel_Quiz.add(rdbtnPoor);
			panel_Quiz.add(rdbtnNewRadioButton);
			panel_Quiz.add(rdbtnNewRadioButton_1);
			panel_Quiz.add(rdbtnNewRadioButton_2);
			panel_Quiz.add(lblNewLabel_1);
			panel_Quiz.add(lblHowYouIntracting);
			panel_Quiz.add(rdbtnPoor_1);
			panel_Quiz.add(rdbtnGood);
			panel_Quiz.add(rdbtnVeryGood);
			panel_Quiz.add(rdbtnExcelent);
			panel_Quiz.add(btnNext);
			panel_Quiz.add(Bar_01);
			panel_1.setBackground(new Color(0, 191, 169));

			rdbtnYes.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					lblWhatKindOf.setVisible(true);
					rdbtnSocial.setVisible(true);
					rdbtnFreelance.setVisible(true);
					rdbtnSkip.setVisible(true);
				}
			});

			rdbtnSkip.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					lblWhatIsYour_1.setVisible(true);
					textField_1.setVisible(true);
				}
			});

			rdbtnNo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblWhatIsYour_1.setVisible(false);
					textField_1.setVisible(false);
					lblWhatKindOf.setVisible(false);
					rdbtnSocial.setVisible(false);
					rdbtnFreelance.setVisible(false);
					rdbtnSkip.setVisible(false);
				}
			});

			rdbtnFreelance.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblWhatIsYour_1.setVisible(false);
					textField_1.setVisible(false);
				}
			});

			rdbtnSocial.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblWhatIsYour_1.setVisible(false);
					textField_1.setVisible(false);
				}
			});

		    
			btnNext.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					val = 2;					
					panel_Quiz.setVisible(false);
					panel_Quiz3.setVisible(false);
					label_1.setIcon(new ImageIcon(UserHome.class.getResource("/Images/top_bar_02.png")));
					contentPane.add(panel_Quiz2);
					panel_Quiz2.setVisible(true);
				}
			});

			btnPrv.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					panel_Quiz2.setVisible(false);
					panel_Quiz3.setVisible(false);
					panel_Quiz.setVisible(true);
				}
			});
			

			btnNext_1.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					try {
						System.out.println("User data:: "+ textField.getText());
						questionnaire.submitAnswer(1,textField.getText(),login.userId,0);
						questionnaire.submitAnswer(1,buttonGroup1.getSelection().getActionCommand(),login.userId,1);
						if(buttonGroup1.getSelection().getActionCommand() == "Yes") {
							questionnaire.submitAnswer(1,buttonGroup3.getSelection().getActionCommand(),login.userId,2);
							if(buttonGroup3.getSelection().getActionCommand() == "Skip") {
								questionnaire.submitAnswer(1,textField_1.getText(),login.userId,10);
							}
						}
						questionnaire.submitAnswer(1,buttonGroup2.getSelection().getActionCommand(),login.userId,3);
						questionnaire.submitAnswer(1,buttonGroup4.getSelection().getActionCommand(),login.userId,4);
						questionnaire.submitAnswer(1,buttonGroup5.getSelection().getActionCommand(),login.userId,5);
						questionnaire.submitAnswer(1,buttonGroup6.getSelection().getActionCommand(),login.userId,6);
						questionnaire.submitAnswer(1,buttonGroup7.getSelection().getActionCommand(),login.userId,7);
						questionnaire.submitAnswer(1,buttonGroup8.getSelection().getActionCommand(),login.userId,8);
						questionnaire.submitAnswer(1,buttonGroup9.getSelection().getActionCommand(),login.userId,9);
						questionnaire.submitAnswer(1,buttonGroup10.getSelection().getActionCommand(),login.userId,11);
						
						String val = questionnaire.finalSurveyAnaly(Login.username);
						System.out.println("val is ::" + val);
						if(val.contentEquals("freelancer")) {
							panel_Quiz.setVisible(false);
							panel_Quiz2.setVisible(false);
							finalSurveyAnalyData = "Thank you for joining with the Path-Quiz service. We've been reviewing the answers to our questions. We think you're good at self-employment. We're also recommending that you to do freelancing. ";
							textArea.setText(finalSurveyAnalyData);
							label_topBar03.setIcon(new ImageIcon(UserHome.class.getResource("/Images/top_bar_03.png")));
							contentPane.add(panel_Quiz3);
							panel_Quiz3.setVisible(true);
						} else if(val.contentEquals("social")) {
							panel_Quiz.setVisible(false);
							panel_Quiz2.setVisible(false);
							finalSurveyAnalyData = "Thank you for joining with the Path-Quiz service. We've been reviewing the answers to our questions. We think you're good at socialist-employment. We're also recommending that you to do social related works. ";
							textArea.setText(finalSurveyAnalyData);
							label_topBar03.setIcon(new ImageIcon(UserHome.class.getResource("/Images/top_bar_03.png")));
							contentPane.add(panel_Quiz3);
							panel_Quiz3.setVisible(true);							
						}

					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						System.out.println(e);
						JOptionPane.showMessageDialog(null, "Please enter all details in this form.");
					}				
				}
			});
		}
	}
}
