package View;


import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.lang.Integer;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import Controller.List_update_book;
import Model.books;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Insets;
import java.awt.Label;

import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;



public class View_update_book extends JFrame {

	private JPanel contentPane;
	private JTextField update_BookIDField;
	private JTextField update_BookNameField;
	private JTextField update_CostField;
	private JTextField update_NumberField;
	private JTextField update_AuthorField;
	private JTextField update_YearField;
	private JTextField update_PublisherField;
	private JComboBox update_KobBox;

	/**
	 * Launch the application.
	 */
	public static void update_book_Screen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_update_book frame = new View_update_book();
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
	public View_update_book(){
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
		update_BookIDField = new JTextField();
		inputPanel.add(update_BookIDField, c);
		
		c.gridy = 1;
		update_BookNameField = new JTextField();
		inputPanel.add(update_BookNameField, c);
		
		c.gridy = 2;
		update_KobBox = new JComboBox();
		update_KobBox.setModel(new DefaultComboBoxModel(new String[] {"Sách Giáo trình", "Văn học Việt Nam", "Văn học nước ngoài", "Sách thiếu nhi", "Văn hóa xã hội", "Khoa học công nghệ", "Kinh tế", "Sách Self-help", "Lịch sử", "Tâm lý kỹ năng"}));
		inputPanel.add(update_KobBox,c);
		
		c.gridy = 3;
		update_AuthorField = new JTextField();
		inputPanel.add(update_AuthorField,c);
		
		c.gridy = 4;
		update_PublisherField = new JTextField();
		inputPanel.add(update_PublisherField,c);
		
		c.gridy = 5;
		update_YearField = new JTextField();
		inputPanel.add(update_YearField,c);
		
		c.gridy = 6;
		update_CostField = new JTextField();
		inputPanel.add(update_CostField,c);
		
		c.gridy = 7;
		update_NumberField = new JTextField();
		inputPanel.add(update_NumberField,c);
		
		contentPane.add(inputPanel,BorderLayout.CENTER);
		
		
		List_update_book action = new List_update_book(this);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		JButton addButton = new JButton("Cập nhật");
		addButton.addActionListener(action);
		
		buttonPanel.add(addButton);
		
		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.addActionListener(action);
		
		buttonPanel.add(btnNewButton);
		contentPane.add(buttonPanel,BorderLayout.SOUTH);
		

	}


	public JTextField getUpdate_BookIDField() {
		return update_BookIDField;
	}


	public void setUpdate_BookIDField(JTextField update_BookIDField) {
		this.update_BookIDField = update_BookIDField;
	}


	public JTextField getUpdate_BookNameField() {
		return update_BookNameField;
	}


	public void setUpdate_BookNameField(JTextField update_BookNameField) {
		this.update_BookNameField = update_BookNameField;
	}


	public JTextField getUpdate_CostField() {
		return update_CostField;
	}


	public void setUpdate_CostField(JTextField update_CostField) {
		this.update_CostField = update_CostField;
	}


	public JTextField getUpdate_NumberField() {
		return update_NumberField;
	}


	public void setUpdate_NumberField(JTextField update_NumberField) {
		this.update_NumberField = update_NumberField;
	}


	public JTextField getUpdate_AuthorField() {
		return update_AuthorField;
	}


	public void setUpdate_AuthorField(JTextField update_AuthorField) {
		this.update_AuthorField = update_AuthorField;
	}


	public JTextField getUpdate_YearField() {
		return update_YearField;
	}


	public void setUpdate_YearField(JTextField update_YearField) {
		this.update_YearField = update_YearField;
	}


	public JTextField getUpdate_PublisherField() {
		return update_PublisherField;
	}


	public void setUpdate_PublisherField(JTextField update_PublisherField) {
		this.update_PublisherField = update_PublisherField;
	}


	public JComboBox getUpdate_KobBox() {
		return update_KobBox;
	}


	public void setUpdate_KobBox(JComboBox update_KobBox) {
		this.update_KobBox = update_KobBox;
	}


	
	
	
	
	
	
	
}
