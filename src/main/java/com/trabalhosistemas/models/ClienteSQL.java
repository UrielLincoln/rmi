package com.trabalhosistemas.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.sql.JDBCType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClienteSQL implements IClienteSQL {

    @Autowired
    private JpaRepository membroRepository;

	@Override
	public void inserir() throws RemoteException {
		// TODO Auto-generated method stub
		Membro membro = new Membro();
		membroRepository.save(membro);
	}


    @Override
    public ArrayList<Membro> mensagem() {
        return null; // Implemente conforme necessário
    }


	@Override
	public Membro verificarLider(Long id){
		Optional<Membro> optionalMembro = membroRepository.findById(id);
        return optionalMembro.orElse(null);
	}
	

}