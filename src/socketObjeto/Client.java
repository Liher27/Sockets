package socketObjeto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		InetAddress host = null;
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		Scanner teclado = new Scanner(System.in);
		host = InetAddress.getLocalHost();

		socket = new Socket(host.getHostName(), 6666);

		if (socket.isConnected()) {
			System.out.println("Conexión realizada con el servidor");
			oos = new ObjectOutputStream(socket.getOutputStream());

			ois = new ObjectInputStream(socket.getInputStream());

			Persona persona = (Persona) ois.readObject();
			System.out.println("Persona recibida del servidor: " + persona.toString());

			System.out.println("Elige el nuevo NIE de la persona: ");
			String newNif = teclado.nextLine();

			System.out.println("Elige un nuevo nombre de la persona: ");
			String newName = teclado.nextLine();

			if (null != newNif)
				persona.setNif(newNif);
			if (null != newName)
				persona.setNombre(newName);

			oos.writeObject(persona);
		}
		teclado.close();
		oos.close();
		ois.close();
		socket.close();
	}
}