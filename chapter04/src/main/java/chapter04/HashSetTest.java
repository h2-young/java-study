package chapter04;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<Rect> set = new HashSet<>(); // Rect 타입만 저장하는 Set
		
		Rect r1 = new Rect(10, 20);
		Rect r2 = new Rect(10, 20);
		Rect r3 = new Rect(4, 50);
		
		set.add(r1);
		set.add(r2);
		set.add(r3);
		
		for(Rect r : set) { // set에 들어있는 원소를 순차적으로 접근?
			System.out.println(r);
		}
	}

}
