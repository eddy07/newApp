package com.polypharm.gescom.domain;
import java.util.Date;

import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Personnel {

    private static Date accExp = DateUtils.addYears(new Date(), 50);
    /**
     */
    private String nom;

    /**
     */
    private String nomConnection;

    /**
     */
    private String motDePass;

    /**
     */
    private String nomComplet;

    /**
     */
    private String telephone;

    /**
     */
    private String email;

    /**
     */
    @Enumerated
    private RoleName roleName;

    /**
     */
    @ManyToOne
    private Agence agence;

    /**
     */
    private Boolean disableLogin = Boolean.FALSE;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date accountExpiration = accExp;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date credentialExpiration = accExp;

    /**
     */
    private Boolean accountLocked = Boolean.FALSE;
    
    public Personnel() {
    }

    public Personnel(String nom, String nomConnection, String motDePass, String nomComplet, String telephone, String email, RoleName roleName, Agence agence) {
        super();
        this.nom = nom;
        this.nomConnection = nomConnection;
        this.motDePass = motDePass;
        this.nomComplet = nomComplet;
        this.telephone = telephone;
        this.email = email;
        this.roleName = roleName;
        this.agence = agence;
    }

    public Personnel(String nom, String nomConnection, String motDePass, String nomComplet, RoleName roleName, Agence agence) {
        this(nom, nomConnection, motDePass, nomComplet, "", "", roleName, agence);
    }
    
    @PrePersist
    public void prePersist(){
    	motDePass = encodePassword(motDePass);
    }

    public String encodePassword(String password, String salt) {
        if (StringUtils.isEmpty(password) || salt == null) throw new NullPointerException("Neither password nor salt may not be null");
        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
        return md5PasswordEncoder.encodePassword(password, salt);
    }

    private final String getSalt() {
        return "ace6b4f53";
    }

    public boolean checkExistingPasword(String currentPassword) {
        String md5EncodedPassword = encodePassword(currentPassword);
        return StringUtils.equals(motDePass, md5EncodedPassword);
    }

    public String encodePassword(String input) {
        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
        md5PasswordEncoder.setEncodeHashAsBase64(false);
        return md5PasswordEncoder.encodePassword(input, getSalt());
    }

    public void changePassword(String password) {
        this.motDePass = encodePassword(password);
    }
}
