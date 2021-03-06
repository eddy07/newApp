// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.polypharm.gescom.service;

import com.polypharm.gescom.domain.Installation;
import com.polypharm.gescom.repository.InstallationRepository;
import com.polypharm.gescom.service.InstallationServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

privileged aspect InstallationServiceImpl_Roo_Service {
    
    declare @type: InstallationServiceImpl: @Service;
    
    declare @type: InstallationServiceImpl: @Transactional;
    
    @Autowired
    InstallationRepository InstallationServiceImpl.installationRepository;
    
    public long InstallationServiceImpl.countAllInstallations() {
        return installationRepository.count();
    }
    
    public void InstallationServiceImpl.deleteInstallation(Installation installation) {
        installationRepository.delete(installation);
    }
    
    public Installation InstallationServiceImpl.findInstallation(Long id) {
        return installationRepository.findOne(id);
    }
    
    public List<Installation> InstallationServiceImpl.findAllInstallations() {
        return installationRepository.findAll();
    }
    
    public List<Installation> InstallationServiceImpl.findInstallationEntries(int firstResult, int maxResults) {
        return installationRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }
    
    public void InstallationServiceImpl.saveInstallation(Installation installation) {
        installationRepository.save(installation);
    }
    
    public Installation InstallationServiceImpl.updateInstallation(Installation installation) {
        return installationRepository.save(installation);
    }
    
}
