package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickname;
	private Socket socket;
	private List<PrintWriter> printWriters;

	public ChatServerThread(Socket socket, List<PrintWriter> list) {
		this.socket = socket;
		this.printWriters = list;
	}

	@Override
	public void run() {
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			String msg = null;
			while ((msg = br.readLine()) != null) {
				System.out.println(msg);
				String[] tokens = msg.split(":");
				if (tokens[0].equals("join")) {
					join(tokens[1].trim(), pw);
				} else if (tokens[0].equals("chat")) {
					message(tokens[1].trim());
				} else if (tokens[0].equals("quit")) {
					quit(pw);
					break;
				}
			}

		} catch (SocketException e) {
			System.out.println("[ServerError] : " + e);
		} catch (IOException e) {
			System.out.println("[ServerError] : " + e);
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				System.out.println("[ServerError] : " + e);
			}
			printWriters.remove(this);
		}
	}

	public void broadcast(String message) {
			try {
				for (PrintWriter client : printWriters) {
					client.println(message);
				}
			} catch (Exception e) {
				System.out.println("[ServerError] : " + e);
		}
	}

	private void join(String nickname, PrintWriter user) {
		this.nickname = nickname;
		printWriters.add(user);
		log(nickname + "님이 입장하였습니다");
		user.println("입장: 확인");
		broadcast(nickname + "님이 입장하였습니다.");
	}

	private void message(String message) {
		log(nickname + " : " + message);
		System.out.println(nickname + " : " + message);
		broadcast(nickname + ": " + message);
	}

	private void quit(PrintWriter user) {
		broadcast(nickname + "님이 채팅방을 나갔어요.");
		log(nickname + "님이 퇴장하였습니다.");
		printWriters.remove(user);
	}

	private void log(String message) {
		System.out.println("[EchoServer#" + nickname + "]" + " " + message);
	}
}