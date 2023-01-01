package sockets.ejemploEnviaryRecibirObjetos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class AppCliente {
	
	
	String host;
	int puerto;
	Socket socketComunicacion;

	ObjectOutputStream flujoSalidaObjeto;
	
	public AppCliente(String host, int puerto) {
		this.puerto = puerto;
		this.host = host;
	}
	public void iniciarCliente() {

		try {
			crearConexion();
			flujoSalidaObjeto = new ObjectOutputStream(socketComunicacion.getOutputStream());
			//Envío de objeto CLIENTE
			enviarObjeto();
			//CIERRO EL FLUJO DE SALIDA
			flujoSalidaObjeto.close();
			//CIERRO EL SOCKET
			socketComunicacion.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que crea la conexion con el servidor
	 * @throws IOException lanzamos la excepcion
	 */
	public void crearConexion()throws IOException {
		socketComunicacion = new Socket(host, puerto);
		System.out.println ("conectado");
	}

	/**
	 * Metodo que envía un objeto al servidor
	 * @throws IOException lanzada por el flujo de salida
	 */
	private void enviarObjeto()throws IOException {
		Cliente cliente = new Cliente("usuario", "contrasenia1");
		System.out.println("Se envío el cliente: " + cliente);
		flujoSalidaObjeto.writeObject(cliente);
	}


}
