package com.polypharm.gescom.web;
import com.polypharm.gescom.domain.VeilleConcurrentielleProduit;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/veilleconcurrentielleproduits")
@Controller
@RooWebScaffold(path = "veilleconcurrentielleproduits", formBackingObject = VeilleConcurrentielleProduit.class)
public class VeilleConcurrentielleProduitController {
}
