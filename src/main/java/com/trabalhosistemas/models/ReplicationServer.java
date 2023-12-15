package com.trabalhosistemas.models;

import org.springframework.stereotype.Service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

@Service
public class ReplicationServer extends UnicastRemoteObject implements ReplicationInterface {
    private boolean liderAtivo = true;

    protected ReplicationServer() throws RemoteException {
        super();
    }

    public String sayHello() throws RemoteException {
        return "Hello from RMI service!";
    }
    
    
    @Override
    public void sendDataToReplicas(String data, int senderId) throws RemoteException {
        if (!liderAtivo) {
            System.out.println("O líder está inativo. Iniciando eleição...");
            realizarEleicao();
            return;
        }

        System.out.println("Dados recebidos de " + senderId + ": " + data);
        // Lógica de replicação aqui
    }

    private void realizarEleicao() {
        // Lógica para iniciar uma eleição e eleger um novo líder
        // Você pode usar um algoritmo de eleição, como o algoritmo de Bully ou outro de sua escolha
        // Após a eleição, atualize o líder ativo
        liderAtivo = true;
        System.out.println("Nova eleição concluída. Novo líder ativo.");
    }

    public void sinalizarLiderInativo() {
        liderAtivo = false;
    }

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

	@Override
	public boolean verificarLider(int i) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
}