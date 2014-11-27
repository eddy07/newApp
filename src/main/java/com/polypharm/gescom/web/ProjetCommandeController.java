package com.polypharm.gescom.web;
import com.polypharm.gescom.domain.ProjetCommande;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/projetcommandes")
@Controller
@RooWebScaffold(path = "projetcommandes", formBackingObject = ProjetCommande.class)
public class ProjetCommandeController {
}
