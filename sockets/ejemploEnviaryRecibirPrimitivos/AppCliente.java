package sockets.ejemploEnviaryRecibirPrimitivos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.xml.ws.handler.MessageContext.Scope;

import interfaces.centroImpresion.FaltaPapelException;

public class AppCliente {
	
	
	String host;
	int puerto;
	Socket socketComunicacion;
	
	DataOutputStream flujoSalida;
	DataInputStream flujoEntrada;
	int contador = 0;
	
	public AppCliente(String host, int puerto) {
		this.puerto = puerto;
		this.host = host;
	}

	
	
	public void iniciarCliente() {

		try 
		{
			
			while(contador != 10)
			{
				crearConexion();

				flujoEntrada = new DataInputStream(socketComunicacion.getInputStream());
				flujoSalida = new DataOutputStream(socketComunicacion.getOutputStream());
				
				//Se leen los datos que vienen desde el servidor
				recibirDatosPrimitivos();

				//Se van a enviar datos hacia el servidor
				enviarDatosPrimitivos();
				
				
				flujoSalida.close();
				flujoEntrada.close();

				socketComunicacion.close();
				contador++;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Fin de la conexión
	}
	
	
	

	private void recibirDatosPrimitivos()throws IOException {

//		flujoEntrada = new DataInputStream(socketComunicacion.getInputStream());

		//Se lee un entero y un String que nos envía el servidor, 
		//escribiendo el resultado en pantalla 
		System.out.println("Dato Recibido desde el servidor " + flujoEntrada.readInt());
		System.out.println ("Dato Recibido desde el servidor " + flujoEntrada.readUTF());
	}



	public void enviarDatosPrimitivos()throws IOException {

//		flujoSalida = new DataOutputStream(socketComunicacion.getOutputStream());

		//Se enviarán dos mensajes
		for (int i = 0; i < 5; i++)
		{
			//Se escribe en el servidor usando su flujo de datos
			flujoSalida.writeUTF("Este es el mensaje numero " + (i+1) + "\n");
		}
		

	}

	public void crearConexion()throws IOException {
		socketComunicacion = new Socket(host, puerto);
		System.out.println ("conectado");
	}

}
