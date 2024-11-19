package prob03;

import java.util.Scanner;

public class Sol03 {
	
	public static void main(String[] args) {

		/* 코드 작성 */
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("수를 입력 하세요 : ");
			int num = scanner.nextInt();
			
			int cnt = 0;
			int sum = 0;
			
			if (num < 0) {
				break;
			}
			
			if (num % 2 == 0) {
				cnt = num / 2;
				
				for (int i = 1; i <= cnt; i ++) {
					sum += 2 * i;
				}
			} else {
				cnt = (num + 1) / 2;
				
				for (int i = 1; i <= cnt; i++) {
					sum += 2 * i - 1;
				}
			}
			System.out.printf("결과값: %d\n", sum);
		}
	}
}
