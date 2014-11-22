// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.polypharm.gescom.service;

import com.polypharm.gescom.domain.Client;
import com.polypharm.gescom.repository.ClientRepository;
import com.polypharm.gescom.service.ClientServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ClientServiceImpl_Roo_Service {
    
    declare @type: ClientServiceImpl: @Service;
    
    declare @type: ClientServiceImpl: @Transactional;
    
    @Autowired
    ClientRepository ClientServiceImpl.clientRepository;
    
    public long ClientServiceImpl.countAllClients() {
        return clientRepository.count();
    }
    
    public void ClientServiceImpl.deleteClient(Client client) {
        clientRepository.delete(client);
    }
    
    public Client ClientServiceImpl.findClient(Long id) {
        return clientRepository.findOne(id);
    }
    
    public List<Client> ClientServiceImpl.findAllClients() {
        return clientRepository.findAll();
    }
    
    public List<Client> ClientServiceImpl.findClientEntries(int firstResult, int maxResults) {
        return clientRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }
    
    public void ClientServiceImpl.saveClient(Client client) {
        clientRepository.save(client);
    }
    
    public Client ClientServiceImpl.updateClient(Client client) {
        return clientRepository.save(client);
    }
    
}