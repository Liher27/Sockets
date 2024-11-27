package ej1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		try {
			InetAddress host = Inet4Address.getLocalHost();

			Socket socket = new Socket(host, 6666);

			OutputStream oS = socket.getOutputStream();

			InputStream iS = socket.getInputStream();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}