// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.polypharm.gescom.domain;

import com.polypharm.gescom.domain.Agence;
import com.polypharm.gescom.domain.Personnel;
import com.polypharm.gescom.domain.RoleName;
import java.util.Date;

privileged aspect Personnel_Roo_JavaBean {
    
    public String Personnel.getNom() {
        return this.nom;
    }
    
    public void Personnel.setNom(String nom) {
        this.nom = nom;
    }
    
    public String Personnel.getNomConnection() {
        return this.nomConnection;
    }
    
    public void Personnel.setNomConnection(String nomConnection) {
        this.nomConnection = nomConnection;
    }
    
    public String Personnel.getMotDePass() {
        return this.motDePass;
    }
    
    public void Personnel.setMotDePass(String motDePass) {
        this.motDePass = motDePass;
    }
    
    public String Personnel.getNomComplet() {
        return this.nomComplet;
    }
    
    public void Personnel.setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    
    public String Personnel.getTelephone() {
        return this.telephone;
    }
    
    public void Personnel.setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public String Personnel.getEmail() {
        return this.email;
    }
    
    public void Personnel.setEmail(String email) {
        this.email = email;
    }
    
    public RoleName Personnel.getRoleName() {
        return this.roleName;
    }
    
    public void Personnel.setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
    
    public Agence Personnel.getAgence() {
        return this.agence;
    }
    
    public void Personnel.setAgence(Agence agence) {
        this.agence = agence;
    }
    
    public Boolean Personnel.getDisableLogin() {
        return this.disableLogin;
    }
    
    public void Personnel.setDisableLogin(Boolean disableLogin) {
        this.disableLogin = disableLogin;
    }
    
    public Date Personnel.getAccountExpiration() {
        return this.accountExpiration;
    }
    
    public void Personnel.setAccountExpiration(Date accountExpiration) {
        this.accountExpiration = accountExpiration;
    }
    
    public Date Personnel.getCredentialExpiration() {
        return this.credentialExpiration;
    }
    
    public void Personnel.setCredentialExpiration(Date credentialExpiration) {
        this.credentialExpiration = credentialExpiration;
    }
    
    public Boolean Personnel.getAccountLocked() {
        return this.accountLocked;
    }
    
    public void Personnel.setAccountLocked(Boolean accountLocked) {
        this.accountLocked = accountLocked;
    }
    
}
