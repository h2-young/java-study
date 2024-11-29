package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {
	public static final int PORT = 9999;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		List<PrintWriter> userList = Collections.synchronizedList(new ArrayList<>());
		try {
			serverSocket = new ServerSocket();

			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			System.out.println("[SERVER] start [port : " + PORT + "]");

			while (true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, userList).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}