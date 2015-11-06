import java.io.File;
import java.io.FileNotFoundException;



import frame.Frame;
import frame.ParserFrame;


public class EjemploDeUso{

public static void main(String [ ] args){
	
	/*EncadenamientoHaciaAtras encaAtras = 
			new EncadenamientoHaciaAtras("r", "p=>q;q=>r;p;q");
	EncadenamientoHaciaAdelante encAdelante = 
			new EncadenamientoHaciaAdelante("s", "p=>q;q=>r;r=>s;p;q;r");
	
	System.out.println(encAdelante.execute());
	System.out.println(encaAtras.execute());
	*/
	
	ParserFrame parser = null;
	try {
		parser = new ParserFrame("ejemplo.yml");
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	Frame frame = parser.createFrame();
	frame.print();
	
}

}