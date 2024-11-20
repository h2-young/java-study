package prob04;
public class Sol04 {

	public static void main(String[] args) {
		char[] c1 = reverse("Hello World");
		printCharArray(c1);
		
		char[] c2 = reverse("Java Programming!");
		printCharArray(c2);
	}
	
	public static char[] reverse(String str) {
		char[] c = new char[str.length()];
		
		for (int i = 0; i < str.length(); i ++) {
			c[i] = str.charAt(str.length()- i - 1);
		}
		
		return c;
	}

	public static void printCharArray(char[] array){
		System.out.println(array);
	}
}