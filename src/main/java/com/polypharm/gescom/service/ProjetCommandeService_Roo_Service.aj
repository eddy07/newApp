// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.polypharm.gescom.service;

import com.polypharm.gescom.domain.ProjetCommande;
import com.polypharm.gescom.service.ProjetCommandeService;
import java.util.List;

privileged aspect ProjetCommandeService_Roo_Service {
    
    public abstract long ProjetCommandeService.countAllProjetCommandes();    
    public abstract void ProjetCommandeService.deleteProjetCommande(ProjetCommande projetCommande);    
    public abstract ProjetCommande ProjetCommandeService.findProjetCommande(Long id);    
    public abstract List<ProjetCommande> ProjetCommandeService.findAllProjetCommandes();    
    public abstract List<ProjetCommande> ProjetCommandeService.findProjetCommandeEntries(int firstResult, int maxResults);    
    public abstract void ProjetCommandeService.saveProjetCommande(ProjetCommande projetCommande);    
    public abstract ProjetCommande ProjetCommandeService.updateProjetCommande(ProjetCommande projetCommande);    
}
