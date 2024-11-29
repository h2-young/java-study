package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;

		try {
			// 1. 소켓 생성하기
			socket = new Socket();
			
			// 2. 소켓 연결하기
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			scanner = new Scanner(System.in);

			System.out.println("닉네임을 입력하세요>>");
			String nickname = scanner.nextLine();
			pw.println("join:" + nickname);

			String confirm = br.readLine();
	
			if (confirm.equals("입장: 확인")) {
				System.out.println("채팅방에 입장했어요.");
	
			}

			new ChatClientThread(socket).start();

			while (true) {
				String msg = scanner.nextLine();
				if (msg.toLowerCase().equals("quit")) {
					pw.println("quit");
					break;
				}
				if (msg.equals("") == false) {
					pw.println("chat:" + msg);
				}
				if (scanner.hasNextLine() == false) {
					continue;
				}
			}

		} catch (ConnectException e) {
			System.out.println("[ClientError] : " + e);
		} catch (IOException e) {
			System.out.println("[ClientError] : " + e);
		} finally {
			try {
				if (scanner != null) {
					scanner.close();
				}
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				System.out.println("[ClientError] : " + e);
			}
		}
	}
}