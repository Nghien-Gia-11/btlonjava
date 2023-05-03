package View;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.List_insert_bill;
import Controller.List_insert_book;
import Controller.List_reset;
import Controller.List_search_book;
import Model.books;
import data_access_object.books_data;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JToolBar;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.GridBagLayout;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

public class QLBSView extends JFrame {

	private JPanel contentPane;
	private JTable informationTable;
	private JTable billTable;
	private JTextField insert_idBookField;
	private JTextField insert_numberBookField;
	private JTextField insert_costBookField;
	private JTextField searchBookNameField;
	private JTextField searchAuthorField;
	private JLabel totalPriceLable;
	private JLabel change_money;
	private JLabel changeLable;
	private AddBookView addBookView;
	private JLabel totalLable;

	/**
	 * Launch the application.
	 */
	public static void mainScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLBSView frame = new QLBSView();
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
	public QLBSView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1297, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		//Tạo thanh công cụ
		
		JMenuBar jMenuBar = new JMenuBar();
		contentPane.add(jMenuBar, BorderLayout.NORTH);
		List_reset action = new List_reset(this);
		
		JButton reset_button = new JButton("Reset");
		reset_button.addActionListener(action);
		jMenuBar.add(reset_button);
		
		
		JButton addBookBtn = new JButton("Thêm sách");
		addBookBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddBookView abv = new AddBookView();
				abv.AddBookScreen();
			}
		});
		jMenuBar.add(addBookBtn);
		
		JMenu jMenu_edit = new JMenu("Chỉnh sửa");
		
		
		JMenuItem jMenu_editBook = new JMenuItem("Chỉnh sửa sách");
		
		JMenuItem jMenu_edit_update = new JMenuItem("Cập nhật số lượng sách");
		
		JMenuItem jMenu_edit_updateCost= new JMenuItem("Cập nhật giá sách");
		
		jMenu_edit.add(jMenu_editBook);
		jMenu_edit.add(jMenu_edit_updateCost);
		jMenu_edit.add(jMenu_edit_update);
		
		jMenuBar.add(jMenu_edit);
		
		
		
		
		jMenu_editBook.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						View_update_book abv = new View_update_book();
						abv.update_book_Screen();
					}
				});
		
		jMenu_edit_update.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						View_update_number_book abv = new View_update_number_book();
						abv.update_number_book_Screen();
					}
				});

		jMenu_edit_updateCost.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						View_update_cost_book abv = new View_update_cost_book();
						abv.update_cost_book_Screen();
					}
				});
		jMenuBar.add(jMenu_edit);
		
		JButton jButton_exit = new JButton("Đăng xuất");
		jMenuBar.add(jButton_exit);
		jButton_exit.addActionListener(action);
		
		//Tạo màn hình chính
		JPanel centrePanel = new JPanel();
		contentPane.add(centrePanel, BorderLayout.CENTER);
		
		
		//Tạo màn hình hiển thị sản phẩm
		JPanel informationPanel = new JPanel();
		int x= informationPanel.getWidth();
		int y = informationPanel.getHeight();
		centrePanel.setLayout(new GridLayout(0, 2, 0, 0));
		informationPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		centrePanel.add(informationPanel);
		informationPanel.setLayout(new GridBagLayout());
		//informationPanel.setLayout(new MigLayout("", "[627px]", "[591px]"));
		
		//Bảng hiển thị sản phẩm
		GridBagConstraints inf = new GridBagConstraints();
		informationTable = new JTable();
		
		informationTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id s\u00E1ch", "T\u00EAn s\u00E1ch", "T\u00EAn t\u00E1c gi\u1EA3", "Nh\u00E0 xu\u1EA5t b\u1EA3n", "Th\u1EC3 lo\u1EA1i", "N\u0103m xu\u1EA5t b\u1EA3n", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1"
			}
		) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(informationTable);
		inf.gridx = 0;
		inf.gridy = 0;
		inf.weightx = 1;
		inf.weighty = 1;
		inf.fill = GridBagConstraints.BOTH;
		//informationPanel.add(scrollPane, "cell 0 0,grow");
		//informationPanel.add(scrollPane, "cell 0 0");
		informationPanel.add(scrollPane,inf);
		
		//Màn hình hóa đơn
		JPanel billPanel = new JPanel();
		centrePanel.add(billPanel);
		billPanel.setLayout(new GridBagLayout());
		GridBagConstraints product = new GridBagConstraints();
		GridBagConstraints input = new GridBagConstraints();
		
		//Bảng hiện đơn hàng
		JPanel billTablePanel = new JPanel();
		billTablePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		billPanel.add(billTablePanel);
		//billTablePanel.setLayout(new MigLayout("", "[627px]", "[290px]"));
		billTablePanel.setLayout(new GridBagLayout());
		GridBagConstraints bill = new GridBagConstraints();
		
		billTable = new JTable();
		JScrollPane scrollPane_1 = new JScrollPane(billTable);
		//billTablePanel.add(scrollPane_1, "cell 0 0,grow");
		bill.gridx = 0;
		bill.gridy = 0;
		bill.weightx = 1;
		bill.weighty = 1;
		bill.fill = GridBagConstraints.BOTH;
		billTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					 "M\u00E3 s\u00E1ch", "T\u00EAn s\u00E1ch", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1","Tên tác giả","Thành tiền"
				}
			));
		
		
		
		
		
		
		
		
		//Thêm billTable vào billPanel
		billTablePanel.add(scrollPane_1,bill);
		product.gridx = 0;
		product.gridy = 0;
		product.weightx = 1;
		product.weighty = 1;
		product.fill = GridBagConstraints.BOTH;
		billPanel.add(billTablePanel,product);
		
		//Thêm inputPanel vào billPanel
		JPanel InputPanel = new JPanel();
		InputPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		input.gridx = 0;
		input.gridy = 1;
		input.weightx = 1;
		input.weighty = 0.1;
		input.fill = GridBagConstraints.BOTH;
		billPanel.add(InputPanel,input);
		//billPanel.add(InputPanel);
		InputPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel insertBillPanel = new JPanel();
		insertBillPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		InputPanel.add(insertBillPanel);
		insertBillPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Chi tiết sản phẩm");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		insertBillPanel.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel insertBillFormPanel = new JPanel();
		insertBillPanel.add(insertBillFormPanel, BorderLayout.CENTER);
		insertBillFormPanel.setLayout(new MigLayout("", "[82px][184px]", "[25px][25px][23px][25px][25px][25px][23px]"));
		
		
		
		
		
		
		
		
		//Tạo form nhập xuất hóa đơn
		JLabel lblNewLabel_2 = new JLabel("Nhập mã sách");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		insertBillFormPanel.add(lblNewLabel_2, "cell 0 0,grow");
		
		insert_idBookField = new JTextField();
		insertBillFormPanel.add(insert_idBookField, "cell 1 0,growx,aligny center");
		insert_idBookField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nhập số lượng");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		insertBillFormPanel.add(lblNewLabel_3, "cell 0 1,grow");
		
		insert_numberBookField = new JTextField();
		insertBillFormPanel.add(insert_numberBookField, "cell 1 1,growx,aligny center");
		insert_numberBookField.setColumns(10);
		
		List_insert_bill action_insert_bill = new List_insert_bill(this);
		
		JButton insertBillButton = new JButton("Nhập");
		insertBillFormPanel.add(insertBillButton, "cell 1 2,alignx right,aligny top");
		insertBillButton.addActionListener(action_insert_bill);
		
		JLabel lblNewLabel_4 = new JLabel("Tổng tiền");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		insertBillFormPanel.add(lblNewLabel_4, "cell 0 3,grow");
		
		totalPriceLable = new JLabel("");
		totalPriceLable.setFont(new Font("Tahoma", Font.BOLD, 12));
		insertBillFormPanel.add(totalPriceLable, "cell 1 3,grow");
		
		JLabel lblNewLabel_6 = new JLabel("Tiền khách trả");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		insertBillFormPanel.add(lblNewLabel_6, "cell 0 4,grow");
		
		insert_costBookField = new JTextField();
		insertBillFormPanel.add(insert_costBookField, "cell 1 4,growx,aligny center");
		insert_costBookField.setColumns(10);
		
		change_money = new JLabel("Tiền thừa ");
		change_money.setFont(new Font("Tahoma", Font.PLAIN, 12));
		insertBillFormPanel.add(change_money, "cell 0 5,grow");
		
		changeLable = new JLabel("");
		changeLable.setFont(new Font("Tahoma", Font.BOLD, 12));
		insertBillFormPanel.add(changeLable, "cell 1 5,grow");
		
		
		JButton outBillButton = new JButton("Xuất");
		insertBillFormPanel.add(outBillButton, "cell 1 6,alignx right,aligny top");
		outBillButton.addActionListener(action_insert_bill);
		
		JPanel searchpanel = new JPanel();
		searchpanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		InputPanel.add(searchpanel);
		searchpanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm sản phẩm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		searchpanel.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JPanel SearchBookFormPanel = new JPanel();
		searchpanel.add(SearchBookFormPanel, BorderLayout.CENTER);
		SearchBookFormPanel.setLayout(new MigLayout("", "[76px][4px][22px][10px][20px][4px][108px]", "[22px][22px][21px][28px]"));
		
		
		
		
		
		
		
		
		
		
		
		
		//Tạo form tìm kiếm sách
		JLabel lblNewLabel_5 = new JLabel("Nhập tên sách");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		SearchBookFormPanel.add(lblNewLabel_5, "cell 0 0,alignx left,growy");
		
		searchBookNameField = new JTextField();
		SearchBookFormPanel.add(searchBookNameField, "cell 2 0 3 1,growx,aligny center");
		searchBookNameField.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Nhập tác giả");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		SearchBookFormPanel.add(lblNewLabel_8, "cell 0 1,alignx left,growy");
		
		searchAuthorField = new JTextField();
		SearchBookFormPanel.add(searchAuthorField, "cell 2 1 3 1,growx,aligny center");
		searchAuthorField.setColumns(10);
		
		List_search_book action_search = new List_search_book(this);
		JButton searchButton = new JButton("Tìm kiếm");
		SearchBookFormPanel.add(searchButton, "cell 6 2,alignx left,aligny top");
		searchButton.addActionListener(action_search);
		
		JLabel lable = new JLabel("Doanh thu:");	
		lable.setFont(new Font("Tahoma", Font.BOLD, 16));
		SearchBookFormPanel.add(lable, "cell 0 3 3 1,grow");
		
		totalLable = new JLabel("");
		SearchBookFormPanel.add(totalLable, "cell 4 3 3 1,grow");
		this.setLocationRelativeTo(null);
		
	}
	
	
	
	
	public void reset_Information_book() {
		DefaultTableModel model = (DefaultTableModel) informationTable.getModel();
		ArrayList<books> list = books_data.getInstance().selectAll();
		
		model.setRowCount(0);
		
		for(books a:list) {
			model.addRow(new Object[] {
					a.getIdBook(),
					a.getNameBook(),
					a.getAuthorBook(),
					a.getPublisher(),
					a.getTypeBook(),
					a.getYearPublisher(),
					a.getNumber(),
					a.getCost()
			});
		}
	}
	
	
	public JTable getBillTable() {
		return billTable;
	}

	public void setBillTable(JTable billTable) {
		this.billTable = billTable;
	}

	public JTextField getInsert_idBookField() {
		return insert_idBookField;
	}

	public void setInsert_idBookField(JTextField insert_idBookField) {
		this.insert_idBookField = insert_idBookField;
	}

	public JTextField getInsert_numberBookField() {
		return insert_numberBookField;
	}

	public void setInsert_numberBookField(JTextField insert_numberBookField) {
		this.insert_numberBookField = insert_numberBookField;
	}

	public JTextField getInsert_costBookField() {
		return insert_costBookField;
	}

	public void setInsert_costBookField(JTextField insert_costBookField) {
		this.insert_costBookField = insert_costBookField;
	}

	public JTextField getSearchBookNameField() {
		return searchBookNameField;
	}

	public void setSearchBookNameField(JTextField searchBookNameField) {
		this.searchBookNameField = searchBookNameField;
	}

	public JTextField getSearchAuthorField() {
		return searchAuthorField;
	}

	public void setSearchAuthorField(JTextField searchAuthorField) {
		this.searchAuthorField = searchAuthorField;
	}

	public JLabel getTotalPriceLable() {
		return totalPriceLable;
	}

	public void setTotalPriceLable(JLabel totalPriceLable) {
		this.totalPriceLable = totalPriceLable;
	}

	public JLabel getChange_money() {
		return change_money;
	}

	public void setChange_money(JLabel change_money) {
		this.change_money = change_money;
	}

	public JTable getInformationTable() {
		return informationTable;
	}

	public void setInformationTable(JTable informationTable) {
		this.informationTable = informationTable;
	}

	public JLabel getChangeLable() {
		return changeLable;
	}
	
	
	public JLabel getTotalLable() {
		return totalLable;
	}

	public void setTotalLable(JLabel totalLable) {
		this.totalLable = totalLable;
	}

	public void setChangeLable(JLabel changeLable) {
		this.changeLable = changeLable;
	}
	
	public void Screen_login() {
		new View_login();
		
	}
}
