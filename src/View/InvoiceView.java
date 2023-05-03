package View;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import Model.bill;
import data_access_object.bill_data;
import data_access_object.books_data;


import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;

public class InvoiceView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable Invoicetable;
	private JTextField invoiceIDField;
	private JTextField invoiceDateField;
	private DetailView detailView;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								InvoiceView frame = new InvoiceView();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InvoiceView() {
		//List_invoice invoiceAction = new List_invoice(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("LỊCH SỬ HÓA ĐƠN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		Invoicetable = new JTable();
		Invoicetable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Th\u1EDDi gian", "M\u00E3 h\u00F3a \u0111\u01A1n", "\u0110\u01A1n gi\u00E1"
			}
		));
		JScrollPane scrollPane = new JScrollPane(Invoicetable);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		toolBar.add(lblNewLabel_1);
		
		invoiceIDField = new JTextField();
		toolBar.add(invoiceIDField);
		invoiceIDField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Thời gian");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		toolBar.add(lblNewLabel_2);
		
		invoiceDateField = new JTextField();
		toolBar.add(invoiceDateField);
		invoiceDateField.setColumns(10);
		
		JButton searchButton = new JButton("Tìm kiếm");
		searchButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		searchButton.setBackground(new Color(192, 192, 192));
		toolBar.add(searchButton);
		
		JButton detailButton = new JButton("Chi tiết");
		detailButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		detailButton.setBackground(new Color(192, 192, 192));
		toolBar.add(detailButton);
		detailButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DetailView detailView = new DetailView();
				detailView.displayDetailscreen();
			}
		});
		
		JButton displayButton = new JButton("Hiển thị");
		displayButton.setBackground(new Color(192, 192, 192));
		displayButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		//displayButton.addActionListener(invoiceAction);
		toolBar.add(displayButton);
		//detailButton.addActionListener(invoiceAction);
	}
	
	public JTextField getInvoiceIDField() {
		return invoiceIDField;
	}

	public void setInvoiceIDField(JTextField invoiceIDField) {
		this.invoiceIDField = invoiceIDField;
	}

	public JTextField getInvoiceDateField() {
		return invoiceDateField;
	}

	public void setInvoiceDateField(JTextField invoiceDateField) {
		this.invoiceDateField = invoiceDateField;
	}

	public void displayInvoiceList() {
		DefaultTableModel model = (DefaultTableModel) Invoicetable.getModel();
		ArrayList<bill> list = bill_data.getInstance().selectAll();
		for(bill a:list) {
			model.addRow(new Object[] {
					a.getDate(),
					a.getId_out(),
					a.getTotal_bill()
			});
			
		}
	}

	
	
	
}
