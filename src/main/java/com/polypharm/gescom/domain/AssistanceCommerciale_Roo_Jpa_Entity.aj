// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.polypharm.gescom.domain;

import com.polypharm.gescom.domain.AssistanceCommerciale;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

privileged aspect AssistanceCommerciale_Roo_Jpa_Entity {
    
    declare @type: AssistanceCommerciale: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long AssistanceCommerciale.id;
    
    @Version
    @Column(name = "version")
    private Integer AssistanceCommerciale.version;
    
    public Long AssistanceCommerciale.getId() {
        return this.id;
    }
    
    public void AssistanceCommerciale.setId(Long id) {
        this.id = id;
    }
    
    public Integer AssistanceCommerciale.getVersion() {
        return this.version;
    }
    
    public void AssistanceCommerciale.setVersion(Integer version) {
        this.version = version;
    }
    
}