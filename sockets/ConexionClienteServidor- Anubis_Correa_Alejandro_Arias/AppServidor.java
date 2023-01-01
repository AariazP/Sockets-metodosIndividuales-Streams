package sockets.ejemploEnviaryRecibirObjetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServidor {
	

	int puerto = 8081;
	ServerSocket server;
	
	Socket socketComunicacion;

	ObjectInputStream flujoEntradaObjeto;
	//posibles objetos a recibir
	private Cliente cliente1;
	private Cliente cliente2;

	public AppServidor() {}
	
	public void iniciarServidor() {
		//inicializo los clientes cuando se crean
		cliente1 = new Cliente("usuario1", "contrasenia1");
		cliente2 = new Cliente("usuario2", "contrasenia2");
		
		try {
            // Se crea un socket servidor atendiendo a un determinado puerto.
			server = new ServerSocket(puerto);
			
	        System.out.println ("Esperando cliente");
	        socketComunicacion = server.accept();

			// Se crea un flujo de entrada para leer los objetos que envía el cliente.

			flujoEntradaObjeto = new ObjectInputStream(socketComunicacion.getInputStream());

			recibirObjeto();

			flujoEntradaObjeto.close();

			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que permite recibir los objetos enviados desde el cliente
	 * y se recibe en nuevo hilo
	 */
	private void recibirObjeto()throws IOException, ClassNotFoundException {
		//creo un hilo al vuelo
		new Thread(() -> {
			//recibo el objeto
			Cliente cliente;
			try {
				cliente = (Cliente) flujoEntradaObjeto.readObject();
			} catch (IOException | ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
			//comparo el objeto recibido con los clientes que tengo en el servidor
			//compruebo si el objeto recibido es igual a alguno de los clientes
			if(cliente.equals(cliente1)) {
				System.out.println("El cliente 1 se ha conectado");
			}else if(cliente.equals(cliente2)) {
				System.out.println("El cliente 2 se ha conectado");
			}else {
				System.out.println("El cliente no se ha conectado");
			}

		}).start();


	}

}
