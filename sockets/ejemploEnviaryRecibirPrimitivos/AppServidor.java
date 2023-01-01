package sockets.ejemploEnviaryRecibirPrimitivos;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServidor {
	
	
	String host = "localhost";
	int puerto = 8081;
	ServerSocket server;
	
	Socket socketComunicacion;
	
	DataOutputStream flujoSalida;
	DataInputStream flujoEntrada;
	BufferedReader entrada;
	
	String mensajeCliente;
	
	public AppServidor() {
		// TODO Auto-generated constructor stub
	}
	
	public void iniciarServidor() {
		
		
		try {
			// Se crea un socket servidor atendiendo a un determinado puerto.
			server = new ServerSocket(puerto);

			while(true)
			{
				System.out.println ("Esperando cliente");
				socketComunicacion = server.accept();

				//Se envian datos al cliente

				flujoSalida = new DataOutputStream(socketComunicacion.getOutputStream());
				flujoEntrada = new DataInputStream(socketComunicacion.getInputStream());
				entrada = new BufferedReader(new InputStreamReader(socketComunicacion.getInputStream()));


				enviarDatosPrimitivos();

				//Se leen los datos que vienen desde el cliente
				recibirDatosPrimitivos();


				flujoEntrada.close();
				flujoSalida.close();

				// Se cierra el socket con el cliente.
				// La llamada anterior a setSoLinger() hará
				// que estos cierres esperen a que el cliente retire los datos.
				socketComunicacion.close();

				// Se cierra el socket encargado de aceptar clientes. Ya no
				// queremos más.
				//		            server.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	private void enviarDatosPrimitivos()throws IOException {

		flujoSalida.writeInt(2020);
		System.out.println ("Enviado 2020");

		flujoSalida.writeUTF ("Hola");
		System.out.println ("Enviado Hola");
	}
	
	private void recibirDatosPrimitivos()throws IOException {
		
//		flujoEntrada = new DataInputStream(socketComunicacion.getInputStream());
		//Se obtiene el flujo entrante desde el cliente
		
		while((mensajeCliente = entrada.readLine()) != null) //Mientras haya mensajes desde el cliente
		{
			//Se muestra por pantalla el mensaje recibido
			System.out.println(mensajeCliente);
		}
		
		System.out.println("aca");
		//Se lee un entero y un String que nos envía el servidor, 
		//escribiendo el resultado en pantalla 
//		System.out.println ("Dato Recibido desde el cliente" + flujoEntrada.readUTF());
	}
	
	

}
