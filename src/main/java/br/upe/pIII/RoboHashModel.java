package br.upe.pIII;

import java.io.Serializable;

public class RoboHashModel implements Serializable {
	
	private String nome;
	private String avatar;
	
	private RoboHashModel(String nome, String avatar) {
		this.nome = nome;
		this.avatar = avatar;
	}
	
	public RoboHashModel() { }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
}
