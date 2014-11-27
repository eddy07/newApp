// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.polypharm.gescom.domain;

import com.polypharm.gescom.domain.VCDistributeurConcurent;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect VCDistributeurConcurent_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager VCDistributeurConcurent.entityManager;
    
    public static final List<String> VCDistributeurConcurent.fieldNames4OrderClauseFilter = java.util.Arrays.asList("nomDistributeur", "localisation", "produitsDistribues");
    
    public static final EntityManager VCDistributeurConcurent.entityManager() {
        EntityManager em = new VCDistributeurConcurent().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long VCDistributeurConcurent.countVCDistributeurConcurents() {
        return entityManager().createQuery("SELECT COUNT(o) FROM VCDistributeurConcurent o", Long.class).getSingleResult();
    }
    
    public static List<VCDistributeurConcurent> VCDistributeurConcurent.findAllVCDistributeurConcurents() {
        return entityManager().createQuery("SELECT o FROM VCDistributeurConcurent o", VCDistributeurConcurent.class).getResultList();
    }
    
    public static List<VCDistributeurConcurent> VCDistributeurConcurent.findAllVCDistributeurConcurents(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM VCDistributeurConcurent o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, VCDistributeurConcurent.class).getResultList();
    }
    
    public static VCDistributeurConcurent VCDistributeurConcurent.findVCDistributeurConcurent(Long id) {
        if (id == null) return null;
        return entityManager().find(VCDistributeurConcurent.class, id);
    }
    
    public static List<VCDistributeurConcurent> VCDistributeurConcurent.findVCDistributeurConcurentEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM VCDistributeurConcurent o", VCDistributeurConcurent.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<VCDistributeurConcurent> VCDistributeurConcurent.findVCDistributeurConcurentEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM VCDistributeurConcurent o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, VCDistributeurConcurent.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void VCDistributeurConcurent.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void VCDistributeurConcurent.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            VCDistributeurConcurent attached = VCDistributeurConcurent.findVCDistributeurConcurent(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void VCDistributeurConcurent.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void VCDistributeurConcurent.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public VCDistributeurConcurent VCDistributeurConcurent.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        VCDistributeurConcurent merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
