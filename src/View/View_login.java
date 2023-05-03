package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Controller.List_signup;
import Model.login;
import data_access_object.login_data;

public class View_login extends JFrame{
	private login log_in;
	private JTextField jTextField_user_login;
	private JPasswordField jPasswordField_pass_login;
	

	public View_login() throws HeadlessException {
		this.log_in = new login();
		
		this.setup();
		
		this.setVisible(true);
		
		
	}
	
		public static void mainScreen() {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						View_login frame = new View_login();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	
	public void setup() {
		
		JPanel jPanel_Header = new JPanel();
		jPanel_Header.setLayout(new GridBagLayout());
		
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.insets = new Insets(50, 50, 60, 60);
		
		
		JLabel jLabel_Header = new JLabel("Đăng Nhập");
		jLabel_Header.setFont(new Font("Arial",Font.BOLD,40));
		jPanel_Header.add(jLabel_Header,constraints);
		
		this.add(BorderLayout.NORTH,jPanel_Header);
		
		JPanel jPanel_main = new JPanel();
		jPanel_main.setLayout(new GridBagLayout());
		
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 0 ;
		constraints.weightx = 0.3;
		constraints.insets = new Insets(10, 10, 10, 10);
		
		JLabel jLabel_user = new JLabel("username :");
		jLabel_user.setFont(new Font("arial",Font.BOLD,18));
		jPanel_main.add(jLabel_user, constraints);
		
		
		constraints.gridy = 1;
		JLabel jLabel_pass = new JLabel("password :");
		jLabel_pass.setFont(new Font("arial",Font.BOLD,18));
		jPanel_main.add(jLabel_pass, constraints);
		
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.weightx = 0.7;
		constraints.fill = GridBagConstraints.BOTH;
		
		jTextField_user_login = new JTextField();
		jPanel_main.add(jTextField_user_login, constraints);
		
		constraints.gridy = 1;
		jPasswordField_pass_login = new JPasswordField();
		jPanel_main.add(jPasswordField_pass_login, constraints);
		
		this.add(BorderLayout.CENTER,jPanel_main);
		
		
		JPanel jPanel_footer = new JPanel();
		jPanel_footer.setLayout(new GridBagLayout());
		
		constraints.gridx = 0;
		constraints.gridy = 0 ;
		//constraints.insets = new Insets(50, 50, 60, 60);
		constraints.anchor = GridBagConstraints.NORTH;
		
		List_signup action = new List_signup(this);
		JButton jButton_login = new JButton("Đăng nhập");
		jButton_login.setFont(new Font("arial",Font.BOLD,20));
		jButton_login.addActionListener(action);
		jPanel_footer.add(jButton_login, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		//constraints.insets = new Insets(50, 50, 60, 60);
		constraints.anchor = GridBagConstraints.NORTH;
		
		
		JButton jButton_sigup = new JButton("Tạo tài khoản !");
		jButton_sigup.setFont(new Font("arial",Font.BOLD,20));
		jButton_sigup.addActionListener(action);
		jPanel_footer.add(jButton_sigup, constraints);
		
		this.add(BorderLayout.SOUTH,jPanel_footer);
		
		
		this.setTitle("Đăng nhập");
		this.setSize(450, 700);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	

	

	
	public JTextField getjTextField_user_login() {
		return jTextField_user_login;
	}

	public void setjTextField_user_login(JTextField jTextField_user_login) {
		this.jTextField_user_login = jTextField_user_login;
	}

	public JPasswordField getjPasswordField_pass_login() {
		return jPasswordField_pass_login;
	}

	public void setjPasswordField_pass_login(JPasswordField jTextField_pass_login) {
		this.jPasswordField_pass_login = jTextField_pass_login;
	}
	
	public void mainSrceen() {
		new QLBSView();
		QLBSView.mainScreen();;
	}
	
	public void mainScreen_sigup() {
		new View_signup();
		View_signup.mainScreen();
	}
	
}
