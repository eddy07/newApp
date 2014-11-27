package com.polypharm.gescom.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class VulgarisationProduit {

    /**
     */
    @ManyToOne
    private Produit produitVulgarise;

    /**
     */
    @ManyToOne
    private Client client;

    /**
     */
    private String nomInterlocuteur;

    /**
     */
    private String telInterlocuteur;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dateVulgarisation;

    /**
     */
    @ManyToOne
    private Personnel auteur;
}
