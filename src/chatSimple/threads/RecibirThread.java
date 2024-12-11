package chatSimple.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class RecibirThread extends Thread {

	BufferedReader lectorMensaje = null;
	Socket socket = null;

	public RecibirThread(Socket socket) throws IOException {
		this.socket = socket;
		lectorMensaje = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	@Override
	public void run() {
		String mensaje = "";
		while (true) {
			try {
				mensaje = lectorMensaje.readLine();
				if (mensaje.equals("salir"))
					break;
				System.out.println(mensaje);
			} catch (Exception e) {
				System.out.println("Se ha cortado la conexion");
			}
		}
	}
}