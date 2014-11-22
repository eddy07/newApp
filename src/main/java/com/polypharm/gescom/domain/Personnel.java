package com.polypharm.gescom.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Personnel {

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
}
