package com.tongtong.JavaSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private static final String HOST = "127.0.0.1";
    private static final int PORT = 8080;
    private static final int SLEEP_TIME = 5000;
    public static void main(String[] args) {
		for(int i=0;i<2;i++) {
			client(i);
		}
	}
    private static void sleep() {
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	public static void client(final int i) {
		final Socket socket;
		try {
			 socket=new Socket(HOST,PORT);
			 new Thread(new Runnable() {
					public void run() {
						String msg="hello world"+"\t"+i;
						
						for(int i=0;i<10;i++) {
							try {
								OutputStream outputstream=socket.getOutputStream();
								 System.out.println("客户端发送数据: " + msg+"\t"+i);
								outputstream.write(msg.getBytes());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							sleep();
						}
						
					}
				}).start();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
     
}
