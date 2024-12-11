package chatSimple;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import chatSimple.threads.EnviarThread;
import chatSimple.threads.RecibirThread;

public class Servidor {

	private static final int port = 6667;

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		ServerSocket server = new ServerSocket(port);
		Socket socket = null;
		System.out.println("server");
		socket = server.accept();

		boolean writing = true;

		new RecibirThread(socket, writing).start();

		new EnviarThread(socket, writing).start();

		server.close();
	}
}