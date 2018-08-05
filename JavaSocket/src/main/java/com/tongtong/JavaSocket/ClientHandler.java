package com.tongtong.JavaSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientHandler {
	public static final int MAX_DATA_LEN = 1024;
	private Socket socket;
	public ClientHandler(Socket socket) {
		this.socket=socket;
	}
	public void start() {
		new Thread(new Runnable() {
			public void run() {
				doStart();
			}
		}).start();
	}
	public void doStart() {
		byte[] data=new byte[MAX_DATA_LEN];
		int len;
		try {
			InputStream inputstream=socket.getInputStream();
			while((len=inputstream.read(data))!=-1) {
				String res=new String(data,0,len);
				System.out.println("message from client:"+res);
				OutputStream outputstream=socket.getOutputStream();
				outputstream.write(data);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
