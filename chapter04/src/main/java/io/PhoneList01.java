package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

public class PhoneList01 {

	public static void main(String[] args) {
		BufferedReader br = null;
		
		try {
			File file = new File("./phone.txt");
			if(!file.exists()) {
				System.out.println("File Not Found");
				return;
			}
		
			System.out.println("== 파일정보 ==");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "bytes");	
			System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));
			
			System.out.println("== 전화번호 ==");
			
			// 1. 기반스트림
			FileInputStream fis = new FileInputStream(file);
			
			// 2. 보조스트림1
			InputStreamReader isr = new InputStreamReader(fis);
			
			// 3. 보조스트림2
			br = new BufferedReader(isr);
			
			// 4. 처리
			String line = null;
			while((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line,"\t "); // '\t'과 ' '로 분리하라는 뜻
				
				int idx = 0;
				while(st.hasMoreElements()) {
					String token = st.nextToken();
					
					if(idx == 0) {
						System.out.print(token + ":");
					} else if(idx == 3) {
						System.out.println(token);
						idx = 0;
					} else {
						System.out.print(token + "-");
					}
					
					idx++;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
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
