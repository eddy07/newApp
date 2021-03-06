// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.polypharm.gescom.service;

import com.polypharm.gescom.domain.Produit;
import com.polypharm.gescom.service.ProduitService;
import java.util.List;

privileged aspect ProduitService_Roo_Service {
    
    public abstract long ProduitService.countAllProduits();    
    public abstract void ProduitService.deleteProduit(Produit produit);    
    public abstract Produit ProduitService.findProduit(Long id);    
    public abstract List<Produit> ProduitService.findAllProduits();    
    public abstract List<Produit> ProduitService.findProduitEntries(int firstResult, int maxResults);    
    public abstract void ProduitService.saveProduit(Produit produit);    
    public abstract Produit ProduitService.updateProduit(Produit produit);    
}
