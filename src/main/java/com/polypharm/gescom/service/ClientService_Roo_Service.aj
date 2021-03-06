// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.polypharm.gescom.service;

import com.polypharm.gescom.domain.Client;
import com.polypharm.gescom.service.ClientService;
import java.util.List;

privileged aspect ClientService_Roo_Service {
    
    public abstract long ClientService.countAllClients();    
    public abstract void ClientService.deleteClient(Client client);    
    public abstract Client ClientService.findClient(Long id);    
    public abstract List<Client> ClientService.findAllClients();    
    public abstract List<Client> ClientService.findClientEntries(int firstResult, int maxResults);    
    public abstract void ClientService.saveClient(Client client);    
    public abstract Client ClientService.updateClient(Client client);    
}
