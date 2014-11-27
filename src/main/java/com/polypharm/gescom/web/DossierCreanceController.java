package com.polypharm.gescom.web;
import com.polypharm.gescom.domain.DossierCreance;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/dossiercreances")
@Controller
@RooWebScaffold(path = "dossiercreances", formBackingObject = DossierCreance.class)
public class DossierCreanceController {
}
