package javaBasic;

import java.io.File;

public class Topic_16_System_Property {
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	
	// Window/ MAC/ Linux
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles";
	
		

}
