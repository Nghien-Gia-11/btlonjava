package View;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.lang.Integer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.List_insert_book;
import Controller.List_update_number_book;
import Model.books;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class View_update_number_book extends JFrame {

	private JPanel contentPane;
	private JTextField update_number_BookIDField;
	private JTextField update_number_BookNameField;
	private JTextField update_number_NumberField;

	/**
	 * Launch the application.
	 */
	public static void update_number_book_Screen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_update_number_book frame = new View_update_number_book();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the frame.
	 */
	public View_update_number_book(){
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Thêm sách");
		this.setResizable(false);
		this.setSize(400, 700);
		setBounds(100, 100, 313, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		JPanel jPanel_header = new JPanel();
		jPanel_header.setLayout(new GridBagLayout());
		
		c.insets = new Insets(20, 50, 50, 50);
		
		
		
		JLabel lblNewLabel = new JLabel("CHỈNH SỬA SÁCH");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 427, 33);
		
		jPanel_header.add(lblNewLabel,c);
		
		contentPane.add(jPanel_header, BorderLayout.NORTH);
		
		
		
		
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridBagLayout());
		
		
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(10, 10, 10, 10);
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.3;
		inputPanel.add(new JLabel("Mã sách:"), c);
		
		c.gridy = 1;
		inputPanel.add(new JLabel("Tên sách:"), c);
		
		c.gridy = 2;
		inputPanel.add(new Label("Số lượng thêm :"),c);
		
		c.gridy = 0;
		c.gridx = 1;
		c.weightx = 0.7;
		c.fill = GridBagConstraints.BOTH;
		update_number_BookIDField = new JTextField();
		inputPanel.add(update_number_BookIDField, c);
		
		c.gridy = 1;
		update_number_BookNameField = new JTextField();
		inputPanel.add(update_number_BookNameField, c);
		
		
		c.gridy = 2;
		update_number_NumberField = new JTextField();
		inputPanel.add(update_number_NumberField,c);
		
		contentPane.add(inputPanel,BorderLayout.CENTER);
		
		
		List_update_number_book action = new List_update_number_book(this);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		JButton addButton = new JButton("Thêm");
		addButton.addActionListener(action);
		
		buttonPanel.add(addButton);
		
		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.addActionListener(action);
		
		buttonPanel.add(btnNewButton);
		contentPane.add(buttonPanel,BorderLayout.SOUTH);
		

	}


	public JTextField getUpdate_number_BookIDField() {
		return update_number_BookIDField;
	}


	public void setUpdate_number_BookIDField(JTextField update_number_BookIDField) {
		this.update_number_BookIDField = update_number_BookIDField;
	}


	public JTextField getUpdate_number_BookNameField() {
		return update_number_BookNameField;
	}


	public void setUpdate_number_BookNameField(JTextField update_number_BookNameField) {
		this.update_number_BookNameField = update_number_BookNameField;
	}


	public JTextField getUpdate_number_NumberField() {
		return update_number_NumberField;
	}


	public void setUpdate_number_NumberField(JTextField update_number_NumberField) {
		this.update_number_NumberField = update_number_NumberField;
	}


	
	
	
}
