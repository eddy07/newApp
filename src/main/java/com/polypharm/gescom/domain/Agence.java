package com.polypharm.gescom.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Agence {

    /**
     */
    private String nom;

    /**
     */
    private String description;
    
    public Agence() {
	}

	public Agence(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}
    
}
