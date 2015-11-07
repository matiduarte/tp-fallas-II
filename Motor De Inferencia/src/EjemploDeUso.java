import java.io.File;
import java.io.FileNotFoundException;



import java.io.IOException;
import java.util.ArrayList;

import frame.Frame;
import frame.ParserFrame;


public class EjemploDeUso{

public static void main(String [ ] args) throws IOException{
	
	/*EncadenamientoHaciaAtras encaAtras = 
			new EncadenamientoHaciaAtras("r", "p=>q;q=>r;p;q");
	EncadenamientoHaciaAdelante encAdelante = 
			new EncadenamientoHaciaAdelante("s", "p=>q;q=>r;r=>s;p;q;r");
	
	System.out.println(encAdelante.execute());
	System.out.println(encaAtras.execute());
	*/
	
	ParserFrame parser = null;
	try {
		parser = new ParserFrame("../ArhcivosFrames/");
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	ArrayList<Frame> listOfFrame = parser.loadFrames();
	for (Frame f: listOfFrame){
		f.print();
		System.out.println("---");
	}
	
}

}