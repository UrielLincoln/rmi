package com.trabalhosistemas.models;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import lombok.Data;


public class Membro{
	
	boolean lider = false;
	private int id;
	private int posicao;
	
	public Membro(int i) {
		this.id = id;
	}

	public int getID() {
		return this.id;
	}

	public int getPosicao() {
		return this.posicao;
	}
	
	public void  setPosicao(int posicao) {
		this.posicao = posicao;
	}
	
	public boolean eLider() {
		if(lider == true) {
			return true;
		}
		else 
			return false;
	}
	
}

