package com.trabalhosistemas.models;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IClienteSQL extends Remote {
    ArrayList<Membro> mensagem() throws RemoteException;
    void inserir() throws RemoteException;
    Membro verificarLider(Long id);
}