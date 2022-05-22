package utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {

public static Connection getMySQLConnection() {

	String hostName = "localhost";
	String dbName = "automationfc";
	String userName = "root";
	String password = "Abc@1234";
	return getMySQLConnection(hostName, dbName, userName, password);
}
private static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) {
	Connection conn = null;
	try {
	// Khai báo class Driver cho MySQL
		// Việc này cần thiết với Java 5
		// Java 6 tự động tìm kiếm Driver thích hợp - không bắt buộc cần dòng này
		// Class.forName("com.mysql.jdbc.Driver");
		// Cấu trúc URL Connection dành cho MySQL
		// Ví dụ: jdbc:mysql://localhost:3306/aytomationfc
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		conn = DriverManager.getConnection(connectionURL, userName, password);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return conn;
	}
}

