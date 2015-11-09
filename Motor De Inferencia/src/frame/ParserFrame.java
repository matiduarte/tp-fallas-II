package frame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.yaml.snakeyaml.Yaml;

public class ParserFrame {

	private Frame frame;
	private File folder;
	
	public ParserFrame(String path) throws FileNotFoundException{
		
		this.folder = new File(path);
	}
	
	private ArrayList<Object> ReadFiles(){
		
		Yaml yaml = new Yaml();
		ArrayList<Object> listOfObjects = new ArrayList<Object>();
		File[] listOfFiles = this.folder.listFiles();
				
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	InputStream input = null;
				try {
					input = new FileInputStream(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
		    	Object object = yaml.load(input);
		    	listOfObjects.add(object);
		    }
		}
	
		return listOfObjects;
	}
	
	public ArrayList<Frame> loadFrames(){
		
		ArrayList<Object> listOfObjects = this.ReadFiles();
		ArrayList<Frame> listOfFrames = new ArrayList<Frame>();
		for (Object object : listOfObjects){
			
			HashMap<String,ArrayList<String>> frameAux = 
			(HashMap<String, ArrayList<String>>) object;
			ArrayList<String> data = new ArrayList<String>();
		
			for(Entry<String, ArrayList<String>> e : frameAux.entrySet()) {
				Object value = e.getValue();
				data.add(value.toString());
			}
		
			this.frame = new Frame(data.get(0));
			String values = null;
			if (data.size() > 2){
				this.frame.setParent(data.get(1));
				values = data.get(2);
			} else {
				values = data.get(1);
			}
			String[] parts = values.split(", \\{|\\[\\{|\\}|\\]");
			
			for (String s : parts){
				ArrayList<String> slotValues = new ArrayList<String>();
				if (s.contains("=")){
					String[] slot = s.split("=");
					if (slot[1].contains(",")){
						String[] vv = slot[1].split(", ");
						for (String slotValue : vv)
							slotValues.add(slotValue);
					} else {
						slotValues.add(slot[1]);
					}
					this.frame.addData(slot[0], slotValues);
				}
			}
			listOfFrames.add(this.frame);
		}	
		return listOfFrames;
	}
	
}
