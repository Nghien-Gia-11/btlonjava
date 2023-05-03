package Main;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.UIManager;

import Model.login;
import View.View_login;
import View.View_signup;
import data_access_object.login_data;

public class test_login {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new View_login();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
	