package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PhoneList02 {

	public static void main(String[] args) {
		Scanner sc = null;
		
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
			
			sc = new Scanner(file);
			
			// 4. 처리
			while(sc.hasNextLine()) {
				String name = sc.next();
				String phone01 = sc.next();
				String phone02 = sc.next();
				String phone03 = sc.next();
				
				System.out.println(name + ":" + phone01 + "-" + phone02 + "-" + phone03);
			}
		} catch (IOException e) { 
			System.out.println("error:" + e);
		} finally {
			sc.close();
		}
	}

}
