// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.polypharm.gescom.repository;

import com.polypharm.gescom.domain.ProjetCommande;
import com.polypharm.gescom.repository.ProjetCommandeRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

privileged aspect ProjetCommandeRepository_Roo_Jpa_Repository {
    
    declare parents: ProjetCommandeRepository extends JpaRepository<ProjetCommande, Long>;
    
    declare parents: ProjetCommandeRepository extends JpaSpecificationExecutor<ProjetCommande>;
    
    declare @type: ProjetCommandeRepository: @Repository;
    
}
