package chapter03;

public class StudentTest02 {

	public static void main(String[] args) {
		Student s1 = new Student();
		
		Person p1 = s1; // up 캐스팅(암시적, implicity)
		Student s2 = (Student)p1; //down 캐스팅(명시적, explicity)
	}

}
