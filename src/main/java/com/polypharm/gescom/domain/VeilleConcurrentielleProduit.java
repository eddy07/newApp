package com.polypharm.gescom.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class VeilleConcurrentielleProduit {

    /**
     */
    @ManyToOne
    private Produit produit;

    /**
     */
    private BigDecimal prixDeVente;

    /**
     */
    private String distributeurPrincipal;

    /**
     */
    private BigDecimal niveauStockProduitChezConcurent;
}
