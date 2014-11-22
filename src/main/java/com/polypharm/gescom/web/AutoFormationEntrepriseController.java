package com.polypharm.gescom.web;
import com.polypharm.gescom.domain.AutoFormationEntreprise;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/autoformationentreprises")
@Controller
@RooWebScaffold(path = "autoformationentreprises", formBackingObject = AutoFormationEntreprise.class)
public class AutoFormationEntrepriseController {
}
