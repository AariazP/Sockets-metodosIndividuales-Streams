
public class EjemploStream {

    public static void main(String[] args) {
	
	//CREACIÓN DE UN STREAM A PARTIR DE DATOS QUEMADOS
        Stream<String> nombres = Stream.of("Pato", "Paco", "Pepa", "Pepe");
        nombres.forEach(System.out::println);
	
	//CREACION DE UN STREAM A PARTIR DE UN ARREGLO
        String[] arr = {"Pato", "Paco", "Pepa", "Pepe"};
        Stream<String> nombres = Arrays.stream(arr);
        nombres.forEach(System.out::println);
	
	//CREACION DE UN STREAM AÑADIENDO DATOS
        Stream<String> nombres = Stream.<String>builder()
                .add("Pato")
                .add("paco")
                .add("pepa")
                .add("pepe")
                .build();
        nombres.forEach(System.out::println);
	
	//CREAR UN STREAM A PARTIR DE UNA LISTA
        List<String> lista = new ArrayList<>();
        lista.add("Pato");
        lista.add("Paco");
        lista.add("Pepe");
        lista.add("Pepa");

        Stream<String> nombres = lista.stream();
        nombres.forEach(System.out::println);

        lista.stream().forEach(System.out::println);

    }
}
