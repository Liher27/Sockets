package ej1;

import java.io.IOException;
import java.net.ServerSocket;

public class Servidor {

	public static void main(String[] args) {

		try {
			ServerSocket serverSocket = new ServerSocket(6666, 30000);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}