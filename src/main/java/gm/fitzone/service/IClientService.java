/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gm.fitzone.service;

import gm.fitzone.model.Client;
import java.util.List;

/**
 *
 * @author Mateo Velasco
 */
public interface IClientService {
    public List<Client> listClients();
    public Client findClientById(Integer id);
    public void saveClient(Client client);
    public void deleteClient(Client client);
}
