package com.polypharm.gescom.repository;
import com.polypharm.gescom.domain.Produit;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Produit.class)
public interface ProduitRepository {
}
