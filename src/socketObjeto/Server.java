package socketObjeto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Server {

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		int port = 6666;
		ServerSocket server = new ServerSocket(port);
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		Socket socket = null;
		Persona persona = null;
		System.out.println("Esperando conexion...");
		while (true) {
			socket = server.accept();
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());

			if (socket.isConnected()) {
				persona = new Persona("16109406E", "Liher", "Chamorro", format("11-07-2004"), 'M');
				oos.writeObject(persona);
			}

			if (null != (persona = (Persona) ois.readObject())) {
				System.out.println(persona);
				break;
			}
		}

		System.out.println("Conexion terminada");
		ois.close();
		oos.close();
		socket.close();
		server.close();
	}

	public static Date format(String text) {
		Date date = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

			date = formatter.parse(text);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}