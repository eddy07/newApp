// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.polypharm.gescom.domain;

import com.polypharm.gescom.domain.ProjetCommande;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ProjetCommande_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager ProjetCommande.entityManager;
    
    public static final List<String> ProjetCommande.fieldNames4OrderClauseFilter = java.util.Arrays.asList("objetProjet", "referencePROFORMA", "referenceBonCommande", "clientConcerne", "interlocuteurPrincipal");
    
    public static final EntityManager ProjetCommande.entityManager() {
        EntityManager em = new ProjetCommande().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long ProjetCommande.countProjetCommandes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ProjetCommande o", Long.class).getSingleResult();
    }
    
    public static List<ProjetCommande> ProjetCommande.findAllProjetCommandes() {
        return entityManager().createQuery("SELECT o FROM ProjetCommande o", ProjetCommande.class).getResultList();
    }
    
    public static List<ProjetCommande> ProjetCommande.findAllProjetCommandes(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM ProjetCommande o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, ProjetCommande.class).getResultList();
    }
    
    public static ProjetCommande ProjetCommande.findProjetCommande(Long id) {
        if (id == null) return null;
        return entityManager().find(ProjetCommande.class, id);
    }
    
    public static List<ProjetCommande> ProjetCommande.findProjetCommandeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ProjetCommande o", ProjetCommande.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<ProjetCommande> ProjetCommande.findProjetCommandeEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM ProjetCommande o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, ProjetCommande.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void ProjetCommande.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void ProjetCommande.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            ProjetCommande attached = ProjetCommande.findProjetCommande(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void ProjetCommande.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void ProjetCommande.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public ProjetCommande ProjetCommande.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ProjetCommande merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
