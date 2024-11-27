package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardTest {

	public static void main(String[] args) {
		BufferedReader br = null; // try문과 finally문의 블럭이 달라서 위에 선언
		try {
			// 1. 기반스트림(표준입력, stdin, System.in)
			
			// 2. 보조스트림(byte|byte|byte -> char 바꿔줌)
			InputStreamReader isr = new InputStreamReader(System.in, "utf-8"); // 생성할 때 기반스트림 넣어줘야한다.
			
			// 3. 보조스트림(char1|char2|char3|\n -> "char1char2char3"
			br = new BufferedReader(isr);
			
			String line = null;
			while((line = br.readLine()) != null) {
				if("quit".equals(line)) {
					break;
				}
				
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
