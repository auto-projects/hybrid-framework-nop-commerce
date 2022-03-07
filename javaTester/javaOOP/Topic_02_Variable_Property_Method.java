package javaOOP;

public class Topic_02_Variable_Property_Method {
	// Access Modifier
	// Data Type
	// Variable name
	// Variable value
	private String studentName = "Auto Coder"; // Biến toàn cục (Global variable)
	
	// Static variable
	public static String studenAddress = "HCM";
	private static String studentPhone = "012360022";
	
	// Final variable: KHÔNG cho phép gán lại/ KHÔNG override lại
	// Cố định dữ liệu không được phép thay đổi trong quá trình chạy
	final String country = "VN";
	
	// Static final variable: hằng số (constant)
	// Nó không được ghi đè
	// Có thể truy cập rộng rãi cho tất cả các instance/ thread
	static final float PI_NUMBER = 3.14123123f;
	
	// Access modifier: default
	int studentID = 10005;

	public static void main(String[] args) {
		// Local variable - biến cục bộ: hàm
		String studentName = "Auto Coder";
		
		if (studentName.startsWith("Auto")) {
			// Local variable - biến cục bộ: block code
			int number = 100;
		}
	}
	
	// Constructor
	public Topic_02_Variable_Property_Method() {
		// Local variable - biến cục bộ: constructor
		String studentName = "Auto Coder";
		
		if (this.studentName.startsWith("Auto")) {
			
		}
	}
	
	// Hàm (Method) - non static
	public void display() {
		// Local variable - biến cục bộ: hàm/ block code/ constructor
		String studentName = "Auto Coder";
	}

}
