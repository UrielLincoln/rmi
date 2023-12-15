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

@Entity(name = "membros")
public class Membro{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int posicao;
	

	public Long getID() {
		return this.id;
	}

	public int getPosicao() {
		return this.posicao;
	}
	
}