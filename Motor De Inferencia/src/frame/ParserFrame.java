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
	private InputStream input;
	
	public ParserFrame(String path) throws FileNotFoundException{
		this.input = new FileInputStream(new File(path));
	}
	
	public Object ReadFile(){
		
		Yaml yaml = new Yaml();
		
		Object object = yaml.load(this.input);
		
		return object;
	}
	
	public Frame createFrame(){
		
		HashMap<String,ArrayList<String>> frameAux = (HashMap<String, ArrayList<String>>) this.ReadFile();
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
		
		return this.frame;
	}
	
}
