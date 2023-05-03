package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.QLBSView;

public class List_reset implements ActionListener{
	private QLBSView view;
	
	
	
	public List_reset(QLBSView view) {
		this.view = view;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String acString = e.getActionCommand();
		if (acString.equals("Reset")) {
			this.view.reset_Information_book();
		}
		if (acString.equals("Đăng xuất")) {
			this.view.Screen_login();
			this.view.dispose();
		}
		
	}
	
}
