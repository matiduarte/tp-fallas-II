import encadenamiento.hacia.atras.*;;

public class EjemploDeUso{

public static void main(String [ ] args){
	EncadenamientoHaciaAtras encaAtras = new EncadenamientoHaciaAtras("r", "p=>q;q=>r;p;q");
	System.out.println(encaAtras.execute());
}

}