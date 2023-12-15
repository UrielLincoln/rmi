package com.trabalhosistemas.models;

import org.springframework.stereotype.Service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ReplicationServer extends UnicastRemoteObject implements ReplicationInterface {
    private boolean liderAtivo = true;
    private List<Membro> membros;
    private int id;
    
    ClienteSQL cliente = new ClienteSQL();
    

    protected ReplicationServer() throws RemoteException {
        super();
        this.membros = new ArrayList<Membro>();
    }

    public String sayHello() throws RemoteException {
        return "Hello from RMI service!";
    }
    
    
    @Override
    public void sendDataToReplicas(String data, int senderId) throws RemoteException {
        if (!liderAtivo) {
            System.out.println("O líder está inativo. Iniciando eleição...");
            this.cliente.realizarEleicao();
            return;
        }

        System.out.println("Dados recebidos de " + senderId + ": " + data);
        // Lógica de replicação aqui
    }

    

    public void sinalizarLiderInativo() {
        liderAtivo = false;
    }

    
    //Main para executar o codigo
    public static void main(String[] args) {
    	
    	
        try {
            startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void startServer() throws RemoteException {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            ReplicationServer server = new ReplicationServer();
            registry.rebind("ReplicationServer", server);
            System.out.println("Servidor RMI pronto para receber dados...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
	public void sendDataToReplicas(String data) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
}