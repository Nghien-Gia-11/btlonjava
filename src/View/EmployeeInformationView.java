package View;


import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class EmployeeInformationView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeInformationView frame = new EmployeeInformationView();
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
	public EmployeeInformationView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel informationPanel = new JPanel();
		informationPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(10, 10, 10, 10);
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.3;
		informationPanel.add(new JLabel("Họ và tên:"), c);
		
		c.gridy = 1;
		informationPanel.add(new JLabel("Mã nhân viên:"), c);
		
		c.gridy = 2;
		informationPanel.add(new JLabel("Tuổi:"), c);
		
//		c.gridy = 3;
//		informationPanel.add(new JLabel("Chức vụ:"), c);
		
		c.gridy = 3;
		informationPanel.add(new Label("Số điện thoại:"),c);
	
//Thông tin nhân viên
		
		c.gridy = 0;
		c.gridx = 1;
		c.weightx = 0.7;
		c.fill = GridBagConstraints.BOTH;
		JLabel employeeName = new JLabel();
		
		c.gridy = 1;
		JLabel employeeID = new JLabel();
		informationPanel.add(employeeID,c);
		
		c.gridy = 2;
		JLabel employeeAge = new JLabel();
		informationPanel.add(employeeAge,c);
		
//		c.gridy = 3;
//		JLabel employeeRole = new JLabel();
//		informationPanel.add(employeeRole,c);
		
		c.gridy = 3;
		JLabel employeePhoneNumber = new JLabel();
		informationPanel.add(employeePhoneNumber,c);
				
		contentPane.add(informationPanel,BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		
		JButton closeButton = new JButton("Đóng");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(closeButton);
		        frame.dispose();
			}
		});
		
		buttonPanel.add(closeButton);
		contentPane.add(buttonPanel,BorderLayout.SOUTH);
	}

}
