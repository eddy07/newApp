// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.polypharm.gescom.service;

import com.polypharm.gescom.domain.VeilleConcurrentielleProduit;
import com.polypharm.gescom.repository.VeilleConcurentielleProduitRepository;
import com.polypharm.gescom.service.VeilleConcurrentielleProduitServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

privileged aspect VeilleConcurrentielleProduitServiceImpl_Roo_Service {
    
    declare @type: VeilleConcurrentielleProduitServiceImpl: @Service;
    
    declare @type: VeilleConcurrentielleProduitServiceImpl: @Transactional;
    
    @Autowired
    VeilleConcurentielleProduitRepository VeilleConcurrentielleProduitServiceImpl.veilleConcurentielleProduitRepository;
    
    public long VeilleConcurrentielleProduitServiceImpl.countAllVeilleConcurrentielleProduits() {
        return veilleConcurentielleProduitRepository.count();
    }
    
    public void VeilleConcurrentielleProduitServiceImpl.deleteVeilleConcurrentielleProduit(VeilleConcurrentielleProduit veilleConcurrentielleProduit) {
        veilleConcurentielleProduitRepository.delete(veilleConcurrentielleProduit);
    }
    
    public VeilleConcurrentielleProduit VeilleConcurrentielleProduitServiceImpl.findVeilleConcurrentielleProduit(Long id) {
        return veilleConcurentielleProduitRepository.findOne(id);
    }
    
    public List<VeilleConcurrentielleProduit> VeilleConcurrentielleProduitServiceImpl.findAllVeilleConcurrentielleProduits() {
        return veilleConcurentielleProduitRepository.findAll();
    }
    
    public List<VeilleConcurrentielleProduit> VeilleConcurrentielleProduitServiceImpl.findVeilleConcurrentielleProduitEntries(int firstResult, int maxResults) {
        return veilleConcurentielleProduitRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }
    
    public void VeilleConcurrentielleProduitServiceImpl.saveVeilleConcurrentielleProduit(VeilleConcurrentielleProduit veilleConcurrentielleProduit) {
        veilleConcurentielleProduitRepository.save(veilleConcurrentielleProduit);
    }
    
    public VeilleConcurrentielleProduit VeilleConcurrentielleProduitServiceImpl.updateVeilleConcurrentielleProduit(VeilleConcurrentielleProduit veilleConcurrentielleProduit) {
        return veilleConcurentielleProduitRepository.save(veilleConcurrentielleProduit);
    }
    
}
