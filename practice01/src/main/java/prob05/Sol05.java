package prob05;

public class Sol05 {
	public static void main(String[] args) {

		/* 코드 작성 */
		boolean flag = false;
		int cnt = 0;
		
		for (int i = 1; i <= 100; i++) {
			String str = Integer.toString(i);
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
					if (flag == false) {
						System.out.print(str + " ");
					}
					System.out.print("짝");
					cnt += 1;
					flag = true;
				}
			}
			if (flag == true) {
				System.out.print("\n");
				flag = false;
			}
		}

	}
}
