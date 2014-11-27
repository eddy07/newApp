package com.polypharm.gescom.web;
import com.polypharm.gescom.domain.RecrutementProspect;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/recrutementprospects")
@Controller
@RooWebScaffold(path = "recrutementprospects", formBackingObject = RecrutementProspect.class)
public class RecrutementProspectController {
}
