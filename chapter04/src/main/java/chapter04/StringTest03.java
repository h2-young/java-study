package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
//		String s1 = "Hello " + "World " + "Java" + 21; // => new StringBuilder("Hello ").append("World ").append("java").append(21).toString();
		
		String s1 = new StringBuffer("Hello ")
				.append("World ")
				.append("Java")
				.append(21)
				.toString();
		
		System.out.println(s1);
		
		String s2 = "";
		for (int i = 0; i < 1000000; i++) {
//			s2 = s2 + "h";
//			s2 = new StringBuffer(s2).append("h").toString();
		}
		
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < 1000000; i++) {
			sb.append("h");
		}
		
//		String s3 = sb.toString();
		
		// String method들
		String s4 = "abcABCabcAbc";
//		System.out.println(s4.senlgh());
		System.out.println(s4.charAt(2));
		System.out.println(s4.indexOf("abc"));
//		System.out.println(s4.indexOf(abc), 7);
//		System.out.println(s4.subString(3));
		System.out.println(s4.substring(3, 5));
		
		String s5 = "      ab      cd    ";
		
//		String[] tockens2= s6.split(" ");
////		for S()s
//		t9=======================================================
//				System.out.println("---" + s5.trim() + ""---);
		
	}

}