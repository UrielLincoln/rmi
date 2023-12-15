package com.trabalhosistemas.models;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ReplicationInterface extends Remote {
    void sendDataToReplicas(String data) throws RemoteException;

	void sendDataToReplicas(String data, int senderId) throws RemoteException;

	boolean verificarLider(int i) throws RemoteException; 
    
}
