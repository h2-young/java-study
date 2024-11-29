package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	public static final int PORT = 60000;

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
			// 2. 바인딩(binding)
			//	  Socket에 InetSocketAddress[InetAddress(IP Address) + port]를 바인딩한다.
			//	  IP Address: 0.0.0.0: 특정 호스트 IP를 바인딩하지 않는다.
			//	  port number : 50000
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("starts...[port:" + PORT + "]");
			
			// 3. accept
			Socket socket = serverSocket.accept(); // blocking
			
			try {
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocketAddress.getPort();
				log("[server] connected by client[" + remoteHostAddress + ":" + remotePort + "]");
				
				// 4. IO Stream 받아오기
				InputStream is = socket.getInputStream();
				
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				// 5. 데이터 읽기
				while(true) {
					String data = br.readLine();
					if(data == null) {
						log("[server] closed by client");
						break;
					}
					log("[server] receive:" + data);
					
					// 6. 데이터 쓰기
					pw.println(data);
				}
			} catch (SocketException e) {
				log("[[server] Socket Exception" + e);
			} catch (IOException e) {
				log("error:" + e);
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
			
		} catch (IOException e) {
			log("[server] error: + e");
		} finally {
			try {
				if(serverSocket != null && serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void log(String message) {
		System.out.println("[Echo Server] " + message);
	}
}