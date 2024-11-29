package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("주소를 입력하세요 >>> ");
			
			String address = sc.nextLine();
			
			InetAddress[] InetAddresses = InetAddress.getAllByName(address);
			
			for(InetAddress inetAddress : InetAddresses) {
				System.out.println(inetAddress);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}