package com.polypharm.gescom.web;
import com.polypharm.gescom.domain.FormationUtilisateur;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/formationutilisateurs")
@Controller
@RooWebScaffold(path = "formationutilisateurs", formBackingObject = FormationUtilisateur.class)
public class FormationUtilisateurController {
}
