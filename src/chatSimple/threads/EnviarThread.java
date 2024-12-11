package chatSimple.threads;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EnviarThread extends Thread {

	PrintWriter out = null;
	Scanner teclado = null;

	Socket socket = null;

	public EnviarThread(Socket socket) throws IOException {
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter((socket.getOutputStream()))), true);

		teclado = new Scanner(System.in);
		this.socket = socket;
	}

	@Override
	public void run() {
		String input = new String();
		while (true) {
			input = teclado.nextLine();
			out.println(input);
			out.flush();
			if (input.equals("salir"))
				break;
		}
	}
}