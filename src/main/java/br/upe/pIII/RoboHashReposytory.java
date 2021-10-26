package br.upe.pIII;

import java.util.Hashtable;
import java.util.Map;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

public class RoboHashReposytory {

	private Hashtable<Integer, String> robos = new Hashtable<>();
	private static RoboHashReposytory repository = null;
	
	public static RoboHashReposytory getRepository() {
		if (repository == null) {
			repository = new RoboHashReposytory();
		}
		return repository;
	}
	
	public Integer Insert(String nome) {
		this.robos.put(robos.size() + 1, nome);
		return this.robos.size();
	}
	
	public String Select(int id) {
		for(Map.Entry<Integer, String> Avatar : this.robos.entrySet()) {
			if(Avatar.getKey() == id) {
				return Avatar.getValue();
			}
		}
		
		return null;
	}
	
	
}
