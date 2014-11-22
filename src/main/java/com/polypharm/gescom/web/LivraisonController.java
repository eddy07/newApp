package com.polypharm.gescom.web;
import com.polypharm.gescom.domain.Livraison;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/livraisons")
@Controller
@RooWebScaffold(path = "livraisons", formBackingObject = Livraison.class)
public class LivraisonController {
}
