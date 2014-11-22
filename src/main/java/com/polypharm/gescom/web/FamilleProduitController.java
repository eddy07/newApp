package com.polypharm.gescom.web;
import com.polypharm.gescom.domain.FamilleProduit;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/familleproduits")
@Controller
@RooWebScaffold(path = "familleproduits", formBackingObject = FamilleProduit.class)
public class FamilleProduitController {
}
