package com.polypharm.gescom.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@RooJavaBean
@RooToString
@RooJpaEntity
public class Client {

    /**
     */
    private String nom;

    /**
     */
    private String telephone;

    /**
     */
    private String numeroCarteContribuable;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date expirationCarteContribuable;

    /**
     */
    private String regimeFiscal;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date expirationPatente;

    /**
     */
    private String localisation;

    /**
     */
    private Boolean colleterTva;

    /**
     */
    private String numAttestationNonRedevance;

    /**
     */
    private String numAttestationSoumissionCNPS;
    
    private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
