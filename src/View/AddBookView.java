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


public class AddBookView extends JFrame {

	private JPanel contentPane;
	private JTextField addBookIDField;
	private JTextField addBookNameField;
	private JTextField addCostField;
	private JTextField addNumberField;
	private JTextField addAuthorField;
	private JTextField addYearField;
	private JTextField addPublisherField;
	private JComboBox addKobBox;
	private QLBSView view;

	/**
	 * Launch the application.
	 */
	public static void AddBookScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookView frame = new AddBookView();
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
	public AddBookView() {
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
		
		
		
		JLabel lblNewLabel = new JLabel("THÊM SÁCH");
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
		inputPanel.add(new JLabel("Thể loại:"), c);
		
		c.gridy = 3;
		inputPanel.add(new JLabel("Tác giả:"), c);
		
		c.gridy = 4;
		inputPanel.add(new Label("Nhà XB:"),c);
		
		c.gridy = 5;
		inputPanel.add(new Label("Năm XB:"),c);
		
		c.gridy = 6;
		inputPanel.add(new Label("Giá:"),c);
		
		c.gridy = 7;
		inputPanel.add(new Label("Số lượng"),c);
		
		c.gridy = 0;
		c.gridx = 1;
		c.weightx = 0.7;
		c.fill = GridBagConstraints.BOTH;
		addBookIDField = new JTextField();
		inputPanel.add(addBookIDField, c);
		
		c.gridy = 1;
		addBookNameField = new JTextField();
		inputPanel.add(addBookNameField, c);
		
		c.gridy = 2;
		addKobBox = new JComboBox();
		addKobBox.setModel(new DefaultComboBoxModel(new String[] {"Sách Giáo trình", "Văn học Việt Nam", "Văn học nước ngoài", "Sách thiếu nhi", "Văn hóa xã hội", "Khoa học công nghệ", "Kinh tế", "Sách Self-help", "Lịch sử", "Tâm lý kỹ năng"}));
		inputPanel.add(addKobBox,c);
		
		c.gridy = 3;
		addAuthorField = new JTextField();
		inputPanel.add(addAuthorField,c);
		
		c.gridy = 4;
		addPublisherField = new JTextField();
		inputPanel.add(addPublisherField,c);
		
		c.gridy = 5;
		addYearField = new JTextField();
		inputPanel.add(addYearField,c);
		
		c.gridy = 6;
		addCostField = new JTextField();
		inputPanel.add(addCostField,c);
		
		c.gridy = 7;
		addNumberField = new JTextField();
		inputPanel.add(addNumberField,c);
		
		contentPane.add(inputPanel,BorderLayout.CENTER);
		
		
		List_insert_book action = new List_insert_book(this);
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


	public JTextField getAddBookIDField() {
		return addBookIDField;
	}

	public void setAddBookIDField(JTextField addBookIDField) {
		this.addBookIDField = addBookIDField;
	}

	public JTextField getAddBookNameField() {
		return addBookNameField;
	}

	public void setAddBookNameField(JTextField addBookNameField) {
		this.addBookNameField = addBookNameField;
	}

	public JTextField getAddCostField() {
		return addCostField;
	}

	public void setAddCostField(JTextField addCostField) {
		this.addCostField = addCostField;
	}

	public JTextField getAddNumberField() {
		return addNumberField;
	}

	public void setAddNumberField(JTextField addNumberField) {
		this.addNumberField = addNumberField;
	}

	public JTextField getAddAuthorField() {
		return addAuthorField;
	}

	public void setAddAuthorField(JTextField addAuthorField) {
		this.addAuthorField = addAuthorField;
	}

	public JTextField getAddYearField() {
		return addYearField;
	}

	public void setAddYearField(JTextField addYearField) {
		this.addYearField = addYearField;
	}

	public JTextField getAddPublisherField() {
		return addPublisherField;
	}

	public void setAddPublisherField(JTextField addPublisherField) {
		this.addPublisherField = addPublisherField;
	}

	public JComboBox getAddKobBox() {
		return addKobBox;
	}

	public void setAddKobBox(JComboBox addKobBox) {
		this.addKobBox = addKobBox;
	}

	
	
	
	
	
	
	
	
}
