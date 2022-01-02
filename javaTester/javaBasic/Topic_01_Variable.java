package javaBasic;

public class Topic_01_Variable {
	static int studentNumber;
	static boolean statusValue;
	static final String BROWSER_NAME ="Chrome"; // constant
	static int studentPrice;
	
	String studentName = "Auto FC";
	
	public static void main(String[] args) {
		int studentPrice = 5;
		
		System.out.println(studentPrice);
		
		System.out.println(studentNumber);
		System.out.println(statusValue);
		
		Topic_01_Variable topic =  new Topic_01_Variable();
		
		System.out.println(topic.studentName);
		
	}
	//Getter: getCurrentUrl/ getTitle/ getText/ getAttribute/ getCssValue/ getSize/ getLocation/ getPosition/ ...
	public String getStudentNumber() {
		return this.studentName;
	}
	// Setter: click/ sendKey/ clear/ select/ back/ forward/ refresh/ get/ ...
	public void  setStudentName(String stdName) {
		this.studentName = stdName;
	}
}
