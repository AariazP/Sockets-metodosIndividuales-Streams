/*
*ESTE MÉTODO DEPURAR UN ARREGLO DE USUARIOS QUE SON DISTINTOS
*/

public static void depurarDistintos() {

	Stream<Usuario> usuarios = Stream   //CREO EL STREAM
           .of("Pato Guzman", "Paco Gonzalez", "Pepa Gutierrez", "Pepe Mena", //AÑADO LOS NOMBRES
                "Pepe Garcia", "Pato Guzman", "Pato Guzman")
            .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1])) // EL MÉTODO MAP PERMITE CREAR UN USUARIO A
		//PARTIR DEL DE LOS NOMBRES ANTERIORES. USANDO EL SPLIT PARA SEPARARLOS 
                .distinct(); // EL DISTINTC DEPURA LOS USUARIOS REPETIDO
        usuarios.forEach(System.out::println); // IMPRIMO LOS USUARIOS
}

