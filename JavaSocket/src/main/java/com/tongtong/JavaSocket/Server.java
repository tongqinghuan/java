package com.tongtong.JavaSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket server;
	public Server(int port) {
		try {
			this.server=new ServerSocket(port);
			System.out.println("The server started!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("The server failed to start!");
			e.printStackTrace();
		}
	}
	public void start() {
		new Thread(new Runnable() {
			public void run() {
				doStart();
			}
		}).start();
	}
	public void doStart() {
		try {
			Socket socket=server.accept();
			new ClientHandler(socket).start();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
