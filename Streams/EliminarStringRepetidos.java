/*
*MÉTODO QUE DEVUELVE UN STREAM DE NOMBRES
*QUE USA EL MÉTODO DISTINTIC PARA ELIMINAR LOS ELEMENTOS REPETIDOS

*/

public static void eliminarStringRepetido() {

	//CREO EL STREAM DE NOMBRES Y LE APLICO EL MÉTODO DISTINTC
        Stream<String> nombres =  Stream.of("Pato Guzman", "Paco Gonzalez", "Pepa Gutierrez", "Pepe Mena",
                        "Pepe Garcia", "Paco Gonzalez", "Paco Gonzalez", "Paco Gonzalez")
                .distinct();//DEPURO LOS DISTINTOS
	//IMPRIMO EL STREAM 
        nombres.forEach(System.out::println);
}


