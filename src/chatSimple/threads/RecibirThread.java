package chatSimple.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class RecibirThread extends Thread {

	BufferedReader lectorMensaje = null;
	Socket socket = null;
	boolean writing = false;

	public RecibirThread(Socket socket, boolean writing) throws IOException {
		this.socket = socket;
		lectorMensaje = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		this.writing = writing;
	}

	@Override
	public void run() {
		String mensaje = "";
		while (writing) {
			try {
				mensaje = lectorMensaje.readLine();
				if (mensaje != null) {
					if (mensaje.equals("salir")) {
						writing = false;
						socket.close();
					}
					System.out.println(mensaje);
				} else {
					writing = false;
					socket.close();
				}

			} catch (Exception e) {
				System.out.println("Se ha cortado la conexion");
			}
		}
		System.out.println("Fin de la conversacion Recibir");
	}
}