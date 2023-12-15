package com.trabalhosistemas.models;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ReplicationClient {

    public static void main(String[] args) {
        String serverAddress = "localhost";
        String serverPort = "1099";
        String data = "Dados a serem replicados";

        try {
            ReplicationInterface replica = connectToReplica(serverAddress, serverPort);
            replica.sendDataToReplicas(data, 1);  // 1 é um exemplo de ID de sender
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ReplicationInterface connectToReplica(String serverAddress, String serverPort) throws Exception {
        Registry registry = LocateRegistry.getRegistry(serverAddress, Integer.parseInt(serverPort));
        ReplicationInterface replica = (ReplicationInterface) registry.lookup("ReplicationServer");

        // Verifica se o líder está ativo
        if (!replica.verificarLider(0)) {
            System.out.println("Líder inativo. Iniciando eleição...");
            // Adicione lógica para participar da eleição ou aguarde a eleição
        }

        return replica;
    }
}



