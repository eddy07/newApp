// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.polypharm.gescom.repository;

import com.polypharm.gescom.domain.VCDistributeurConcurent;
import com.polypharm.gescom.repository.VCDistributeurRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

privileged aspect VCDistributeurRepository_Roo_Jpa_Repository {
    
    declare parents: VCDistributeurRepository extends JpaRepository<VCDistributeurConcurent, Long>;
    
    declare parents: VCDistributeurRepository extends JpaSpecificationExecutor<VCDistributeurConcurent>;
    
    declare @type: VCDistributeurRepository: @Repository;
    
}