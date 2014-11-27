package com.polypharm.gescom.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class ProjetCommande {

    /**
     */
    private String objetProjet;

    /**
     */
    private String referencePROFORMA;

    /**
     */
    private String referenceBonCommande;

    /**
     */
    @ManyToOne
    private Client clientConcerne;

    /**
     */
    private String interlocuteurPrincipal;
}
