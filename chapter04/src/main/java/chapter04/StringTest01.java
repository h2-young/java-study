package chapter04;

public class StringTest01 {

	public static void main(String[] args) {
		// "c:\temp"
		System.out.println("c:\temp");
		System.out.println("c:\\temp");
		
		
		/* \t : tab
		 * \r : carriage return
		 * \n : new line 
		 * \b : beep */
		
		// " => \ 뒤에 " 붙이기
		System.out.println("\"hello\"");
		
		// ' => \ 뒤에 ' 붙이기
		char c = '\'';
		System.out.print(c);
		
	}

}
