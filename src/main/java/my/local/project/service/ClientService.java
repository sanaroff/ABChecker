/**
 * Copyright (C) 2022, 1C
 */
package my.local.project.service;

import my.local.project.model.Client;
import my.local.project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hermezzis
 *
 */

@Service
public class ClientService {

	private final ClientRepository clientRepository;

	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public List<Client> findAllClients(){
		return clientRepository.findAll();
	}

	public Client findClientByID(Long ID) {
		 return clientRepository.findById(ID).get();
	}

	public Client saveClient(Client client){
		return clientRepository.save(client);
	}

	public void deleteClient(Client client){
		clientRepository.delete(client);
	}

	public void deleteClient(Long ID) {
		clientRepository.deleteById(ID);
	}

	//public List<IAbonement> findAllAbonements(Client client) {
		//return Collections.emptyList();
	//}
}
