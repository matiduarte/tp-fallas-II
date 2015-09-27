import encadenamiento.hacia.adelante.EncadenamientoHaciaAdelante;
import encadenamiento.hacia.atras.*;;

public class EjemploDeUso{

public static void main(String [ ] args){
	
	EncadenamientoHaciaAtras encaAtras = 
			new EncadenamientoHaciaAtras("r", "p=>q;q=>r;p;q");
	EncadenamientoHaciaAdelante encAdelante = 
			new EncadenamientoHaciaAdelante("s", "p=>q;q=>r;r=>s;p;q;r");
	
	System.out.println(encAdelante.execute());
	System.out.println(encaAtras.execute());
}

}