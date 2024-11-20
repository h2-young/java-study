package prob02;

import java.util.Scanner;
import java.util.Arrays;

public class Sol02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[5];
		double sum = 0;

		/* 코드 작성 */
		System.out.println("5개의 숫자를 입력하세요.");
		
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = scanner.nextInt();
		}
		
		double avg = Arrays.stream(intArray).average().orElse(0);
		
		System.out.printf("평균은 %.1f 입니다.", avg);
		
		scanner.close();
	}
}
