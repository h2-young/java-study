package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class EchoClient {
	private static final String SERVER_IP = "192.168.0.11";
	
	public static void main(String[] args) {
		Socket socket = null;
		Scanner sc = null;
		
		try {
			sc = new Scanner(System.in);
			
			// 1. 소켓 생성
			socket = new Socket();
			
			// 2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, 60000));
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true) {
				System.out.print(">>");
				String line = sc.nextLine();
				
				if("exit".equals(line)) {
					break;
				}
				
				pw.println(line);
				String data = br.readLine();
				
				if (data == null) {
					log("closed by server");
					break;
				}
				System.out.println("<<" + data);
			} 
		} catch (SocketException e) {
			log("Socket Exception" + e);
		} catch (IOException e) {
			log("[client] error:" + e);
		} finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void log(String message) {
		System.out.println("[Echo client] "+ message);
	}

}
