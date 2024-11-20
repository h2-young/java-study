package prob06;

import java.util.Random;
import java.util.Scanner;

public class Sol06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input;
		
		while(true) {
			
			/* 게임 작성 */

			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt(100) + 1;
			int cnt = 1;
			int min = 1;
			int max = 100;
			System.out.printf("수를 결정하였습니다. 맞추어 보세요:\n%d-%d\n", min, max);
			
			while (true) {
				System.out.printf("%d>>", cnt);
				input = scanner.nextInt();
				
				if (input >= min && input <= max) {
					if (input > correctNumber) {
						System.out.println("더 낮게");
						max = input - 1;
					} else if (input < correctNumber) {
						System.out.println("더 높게");
						min = input + 1;
					} else {
						System.out.println("맞췄습니다.");
						break;
					}
					System.out.printf("%d-%d\n", min, max);
					cnt ++;
				} else {
					System.out.println("입력값이 범위를 벗어났습니다. 다시 입력하세요.");
				}
			}
			
			//새 게임 여부 확인하기
			System.out.print("다시 하겠습니까(y/n)>>");
			String answer = scanner.next();
			if("y".equals(answer) == false) {
				break;
			}
		}
		
		scanner.close();
	}
}