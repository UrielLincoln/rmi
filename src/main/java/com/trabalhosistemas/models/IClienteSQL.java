package com.trabalhosistemas.models;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IClienteSQL extends Remote {
    ArrayList<Membro> mensagem() throws RemoteException;
    Membro verificarLider( );
	void inserir(int i) throws RemoteException;
}