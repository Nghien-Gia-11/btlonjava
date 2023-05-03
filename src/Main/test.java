package Main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    private static int count;
    
    public test(){
        // Khởi tạo số đếm từ 1
        count = 1;
    }
    
    public static String generateInvoiceNumber() {
        // Lấy ngày tháng năm hiện tại
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateString = dateFormat.format(now);
        
        // Tạo mã hóa đơn bằng cộng ngày tháng năm và số đếm
        String invoiceNumber = dateString + "-" + count;
        
        // Tăng số đếm lên 1
        count++;
        
        return invoiceNumber;
    }
    
    public static void main(String[] args) {
    	test test1 = new test();
    	for (int i = 0; i < 10; i++) {
    		
    		System.out.println(test1.generateInvoiceNumber());
		}
	}
}