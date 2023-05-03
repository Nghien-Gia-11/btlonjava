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

import Controller.List_signup;
import Model.login;
import data_access_object.login_data;

public class View_signup extends JFrame{
	private login log_in;
	private JTextField jTextField_user;
	private JPasswordField jPasswordField_pass;
	private JPasswordField jPasswordField_re_pass;
	



	public View_signup() throws HeadlessException {
		this.log_in = new login();
		
		this.setup();
		
		this.setVisible(true);
		
		
	}
	
	
	public static void mainScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_signup frame = new View_signup();
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
		
		
		JLabel jLabel_Header = new JLabel("Đăng Ký");
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
		
		constraints.gridy = 2;
		JLabel jLabel_re_pass = new JLabel("re-password :");
		jLabel_re_pass.setFont(new Font("arial",Font.BOLD,18));
		jPanel_main.add(jLabel_re_pass, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.weightx = 0.7;
		constraints.fill = GridBagConstraints.BOTH;
		
		jTextField_user = new JTextField();
		jPanel_main.add(jTextField_user, constraints);
		
		constraints.gridy = 1;
		jPasswordField_pass = new JPasswordField();
		jPanel_main.add(jPasswordField_pass, constraints);
		
		constraints.gridy = 2;
		jPasswordField_re_pass = new JPasswordField();
		jPanel_main.add(jPasswordField_re_pass, constraints);
		
		this.add(BorderLayout.CENTER,jPanel_main);
		
		
		JPanel jPanel_footer = new JPanel();
		jPanel_footer.setLayout(new GridBagLayout());
		
		constraints.gridx = 0;
		constraints.gridy = 0 ;
		constraints.insets = new Insets(50, 50, 60, 60);
		constraints.anchor = GridBagConstraints.NORTH;
		
		List_signup action = new List_signup(this);
		JButton jButton_sign_up = new JButton("Đăng Ký");
		jButton_sign_up.setFont(new Font("arial",Font.BOLD,20));
		jButton_sign_up.addActionListener(action);
		jPanel_footer.add(jButton_sign_up, constraints);
		
		
		this.add(BorderLayout.SOUTH,jPanel_footer);
		
		
		this.setTitle("Đăng ký");
		this.setSize(450, 700);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	

	
	
	public JTextField getjTextField_user() {
		return jTextField_user;
	}

	public void setjTextField_user(JTextField jTextField_user) {
		this.jTextField_user = jTextField_user;
	}

	public JPasswordField getjPasswordField_pass() {
		return jPasswordField_pass;
	}

	public void setjPasswordField_pass(JPasswordField jTextField_pass) {
		this.jPasswordField_pass = jTextField_pass;
	}

	public JPasswordField getjPasswordField_re_pass() {
		return jPasswordField_re_pass;
	}

	public void setjPasswordField_re_pass(JPasswordField jTextField_re_pass) {
		this.jPasswordField_re_pass = jTextField_re_pass;
	}
	
	public void mainSrceen_login() {
		new View_login();
		//View_login.mainScreen();
	}
	
	
}
