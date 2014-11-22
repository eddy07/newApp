package com.polypharm.gescom.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Livraison {

    /**
     */
    private String numeroBodereauLivraison;

    /**
     */
    @ManyToOne
    private Client client;

    /**
     */
    private String dureLivraison;
}
