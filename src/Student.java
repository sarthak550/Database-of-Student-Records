
public class Student implements Student_{
	String full_name;
	String last_name;
	String hostel;
	String department;
	String cgpa;
	
	public Student(String full_name,String last_name,String hostel,String department,String cgpa) {
		this.full_name = full_name;
		this.last_name = last_name;
		this.hostel = hostel;
		this.department = department;
		this.cgpa = cgpa;
	}
	public String fname() {
		return full_name;
	}

	public String lname() {
		return last_name;
	}

	public String hostel() {
		return hostel;
	}

	public String department() {
		return department;
	}

	public String cgpa() {
		return cgpa;
	}

}
