package prob06;

public class Sub {
	int a;
	int b;
	
	void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public void calculate() {
		System.out.println(">> " + (this.a - this.b));
	}
}
