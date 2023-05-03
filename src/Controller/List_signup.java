package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Database.databaseUtil;
import Main.test_signup;
import Model.login;
import View.QLBSView;
import View.View_login;
import View.View_signup;
import data_access_object.login_data;
import View.QLBSView;

public class List_signup implements ActionListener{

	private View_signup view_signup;
	private View_login view_login;
	
	public List_signup(View_signup view_signup) {
		this.view_signup = view_signup;
	}
	
	public List_signup(View_login view_login) {
		this.view_login = view_login;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		
		
		
		boolean check = true;
		

		
		if (ac.equals("Đăng Ký")) {
			ArrayList<login>  list = new ArrayList<>();
			
			list = login_data.getInstance().selectAll();
			for (login log_in : list) {
				if (this.view_signup.getjTextField_user().getText().equals(log_in.getUsername())) {
					check = false;
					JOptionPane.showMessageDialog(view_signup,
							"tài khoản đã tồn tại ! ",
							"Error",
							JOptionPane.ERROR_MESSAGE
							);
				}
			}
			
			if (this.view_signup.getjTextField_user().getText().equals("")) {
				check = false;
				JOptionPane.showMessageDialog(view_signup,
						"không được bỏ trống! ",
						"Error",
						JOptionPane.ERROR_MESSAGE
						);
				return;
			}
			if (String.valueOf(this.view_signup.getjPasswordField_pass().getPassword()).equals("")) {
				check = false;
				JOptionPane.showMessageDialog(view_signup,
						"không được bỏ trống! ",
						"Error",
						JOptionPane.ERROR_MESSAGE
						);
				return;
			}
			if (String.valueOf(this.view_signup.getjPasswordField_re_pass().getPassword()).equals("")) {
				check = false;
				JOptionPane.showMessageDialog(view_signup,
						"không được bỏ trống! ",
						"Error",
						JOptionPane.ERROR_MESSAGE
						);
				return;
			}
			int checkpass = String.valueOf(this.view_signup.getjPasswordField_pass().getPassword()).compareTo(String.valueOf(this.view_signup.getjPasswordField_re_pass().getPassword()));
			if (checkpass > 0 || checkpass < 0) {
				check = false;
				JOptionPane.showMessageDialog(view_signup,
						"mật khẩu không trùng khớp ! ",
						"Error",
						JOptionPane.ERROR_MESSAGE
						);
				return;
			}
			if (check == true ) {
				String user = this.view_signup.getjTextField_user().getText();
				String pass = String.valueOf(this.view_signup.getjPasswordField_re_pass().getPassword());
				
				login login1 = new login(user, pass);
				
				login_data.getInstance().insert(login1);
				JOptionPane.showMessageDialog(view_signup,
						"đăng ký thành công ! ",
						"",
						JOptionPane.INFORMATION_MESSAGE
						);
				this.view_signup.mainSrceen_login();
				this.view_signup.dispose();
			}
		}
		
		boolean check_acc = false;
		boolean check_pass = false;
		if (ac.equals("Đăng nhập")) {
			ArrayList<login>  list = new ArrayList<>();
			
			list = login_data.getInstance().selectAll();
			for (login log_in : list) {
				if (this.view_login.getjTextField_user_login().getText().compareTo(log_in.getUsername()) == 0 ) {
					check_acc = true;
				}
				
			}
			for (login login : list) {
				if (String.valueOf(this.view_login.getjPasswordField_pass_login().getPassword()).compareTo(login.getPassword()) == 0 ) {
					check_pass = true;
			}
			}
			
			if (check_acc == false ) {
				JOptionPane.showMessageDialog(view_login,
						"tài khoản không tồn tại ! ",
						"Error",
						JOptionPane.ERROR_MESSAGE
						);
				return;
			}
			
			if (check_pass == false ) {
				JOptionPane.showMessageDialog(view_login,
						"mật khẩu không đúng ! ",
						"Error",
						JOptionPane.ERROR_MESSAGE
						);
				return;
			}
			if (check_pass == true  && check_acc == true) {
				JOptionPane.showMessageDialog(view_login,
						"đăng nhập thành công ! ",
						"",
						JOptionPane.INFORMATION_MESSAGE
						
						);
				this.view_login.mainSrceen();
				this.view_login.dispose();
			}
			}
		if (ac.equals("Tạo tài khoản !")) {
			this.view_signup.mainScreen();
			this.view_login.dispose();
		}
	}

}
