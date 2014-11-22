package com.polypharm.gescom.web;
import com.polypharm.gescom.domain.VulgarisationProduit;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vulgarisationproduits")
@Controller
@RooWebScaffold(path = "vulgarisationproduits", formBackingObject = VulgarisationProduit.class)
public class VulgarisationProduitController {
}
