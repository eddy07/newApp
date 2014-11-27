package com.polypharm.gescom.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaEntity
public class RecrutementProspect {

    /**
     */
    private String denominationProspect;

    /**
     */
    private String fctionInterlocuteur;

    /**
     */
    private String telephone;

    /**
     */
    private String email;

    /**
     */
    private String boitePostale;

    /**
     */
    private String localisation;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date dateRecrutement;

    /**
     */
    @ManyToOne
    private Personnel auteur;
}
