package prob06;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print(">> ");
			String expression = scanner.nextLine();
			
			if("quit".equals(expression)) {
				break;
			}
			
			String[] tokens = expression.split(" ");
			
			if(tokens.length != 3) {
				System.out.println(">> 알 수 없는 식입니다.");
				continue;
			}
			
			int lValue = Integer.parseInt(tokens[0]);
			int rValue = Integer.parseInt(tokens[2]);
			
			switch(tokens[1]) {
				case "+": {
					Add cal = new Add();
					cal.setValue(lValue, rValue);
					cal.calculate();
					break;
				}
				case "-" : {
					Sub cal = new Sub();
					cal.setValue(lValue, rValue);
					cal.calculate();
					break;
				}
				case "*" : {
					Mul cal = new Mul();
					cal.setValue(lValue, rValue);
					cal.calculate();
					break;					
				}
				case "/" : {
					Div cal = new Div();
					cal.setValue(lValue, rValue);
					cal.calculate();
					break;
				}
				default :  {
					System.out.println(">> 알 수 없는 연산입니다.");
				}
			}
		}
		
		scanner.close();
	}

}
