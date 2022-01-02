package javaBasic;

public class Topic_05_Reference_Casting {
	public String studentName;
	
	public String getStudentName() {
		return studentName;
		
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public void showStudentName() {
		System.out.println("Student name = " + studentName);
	}
	
	public static void main(String[] args) {
		Topic_05_Reference_Casting firstStudent = new Topic_05_Reference_Casting();
			
		Topic_05_Reference_Casting secondStudent = new Topic_05_Reference_Casting();
		
		firstStudent.setStudentName("Yuna Thuy Lieu");
		secondStudent.setStudentName("Chut Dao");
		
		firstStudent.showStudentName();
		secondStudent.showStudentName();
		
		// Ep Kieu
		firstStudent = secondStudent;
		
		firstStudent.showStudentName();
		secondStudent.showStudentName();
		
		secondStudent.setStudentName("MomMy");
		
		firstStudent.showStudentName();
		secondStudent.showStudentName();
		
		
	}
}
