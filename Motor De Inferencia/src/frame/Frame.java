package frame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Frame {

	private String name;
	private String parent;
	private HashMap<String, ArrayList<String>> data;
	
	public Frame(String name){
		this.parent = "";
		this.name = name;
		this.data = new HashMap<String,  ArrayList<String>>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}
	
	public void addData(String key, ArrayList<String> value){
		this.data.put(key, value);
	}
	
	public void print(){
		
		System.out.println("name: " + this.getName());
		if (!this.parent.equals(""))
			System.out.print("parent: " + this.getParent() + '\n');
		System.out.print("data: " + '\n');
		for(Entry<String, ArrayList<String>> e : this.data.entrySet()) {
	    	   System.out.println("\t-" + e.getKey() + ": " + e.getValue().toString());
	    }
	}

	public HashMap<String,  ArrayList<String>> getData() {
		return this.data;
	}

}
