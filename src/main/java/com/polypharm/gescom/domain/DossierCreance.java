package com.polypharm.gescom.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class DossierCreance {

    /**
     */
    private String numBonCommande;

    /**
     */
    private String numBonLivraison;

    /**
     */
    private String numFacture;

    /**
     */
    private String natureGarantie;

    /**
     */
    private String numContratCreance;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dateEmission;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dateEchance;

    /**
     */
    @ManyToOne
    private Client client;

    /**
     */
    @ManyToOne
    private Personnel auteur;
}
