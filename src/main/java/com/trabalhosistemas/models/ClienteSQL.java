package com.trabalhosistemas.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.sql.JDBCType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteSQL implements IClienteSQL {

    @Autowired
    private JpaRepository membroRepository;

    public List<Membro> membros = new ArrayList<Membro>();
    
    
	@Override
	public void inserir(int quantidade) throws RemoteException {
		for(int i=0; i<quantidade;i++) {
			Membro membro = new Membro(i);
			membro.setPosicao(i);
			membros.add(membro);
		}
		
	}

    @Override
    public ArrayList<Membro> mensagem() {
        return null; // Implemente conforme necessário
    }


    //Implementar alguma forma de achar o lider
	@Override
	public Membro verificarLider(){
		Membro membroeleito = null;
		for(Membro membro : membros) {
			if(membro.eLider()) 
				membroeleito = membro;
		}
		
		return membroeleito;
		
	}

	
	
	public void realizarEleicao() {
        System.out.println("Iniciando eleição...");
            if (verificarLider()==null) {
			    iniciarEleicao();
			}
            
    }

	
	//Implementar um metodo para eleger um lider
	private void iniciarEleicao() {
		// TODO Auto-generated method stub
		
	}

	

}