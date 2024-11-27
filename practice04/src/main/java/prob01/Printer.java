package prob01;

public class Printer {
//	public void println(int number) {
//		System.out.println(number);
//	}
//	
//	public void println(boolean flag) {
//		System.out.println(flag);
//	}
//	
//	public void println(double realNumber) {
//		System.out.println(realNumber);
//	}
//	
//	public void println(String text) {
//		System.out.println(text);
//	}
	
	public <T> void println(T t) {
		System.out.println(t);
	}
	
	public <T> void println(T... ts) {
		for(T t: ts) {
			System.out.println(t + " ");
		}
		
		System.out.println("\n");
	}

	public int sum(Integer... nums) {
		int s = 0;
		for(Integer n: nums) {
			s += n;
		}
		return s;
	}
}