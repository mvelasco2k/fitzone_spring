/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gm.fitzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import gm.fitzone.model.Client;

/**
 *
 * @author Mateo Velasco
 */
public interface ClientRepository extends JpaRepository<Client, Integer>{
    
}
