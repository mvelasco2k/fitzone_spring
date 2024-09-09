/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gm.fitzone.service;

import gm.fitzone.model.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import gm.fitzone.repository.ClientRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mateo Velasco
 */
@Service
public class ClientService implements IClientService
{
    @Autowired
    private ClientRepository clientRepository;  
    
    @Override
    public List<Client> listClients() {
        List<Client> clients = clientRepository.findAll();
        return clients;
    }

    @Override
    public Client findClientById(Integer id) {
        Client c = clientRepository.findById(id).orElse(null);
        return c;
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }
    
}
