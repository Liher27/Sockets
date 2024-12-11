package chatSimple;

import java.io.IOException;
import java.net.Socket;

import chatSimple.threads.EnviarThread;
import chatSimple.threads.RecibirThread;

public class Cliente {

	private static final String ip = "localhost";
	private static final int port = 6667;

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Socket socket = null;

		socket = new Socket(ip, port);

		System.out.println("Conectado con el servidor!...");

		new RecibirThread(socket).start();

		new EnviarThread(socket).start();
	}
}