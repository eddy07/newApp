package com.polypharm.gescom.web;
import com.polypharm.gescom.domain.Produit;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/produits")
@Controller
@RooWebScaffold(path = "produits", formBackingObject = Produit.class)
public class ProduitController {
}
