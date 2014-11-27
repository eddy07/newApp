package com.polypharm.gescom.web;
import com.polypharm.gescom.domain.Agence;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/agences")
@Controller
@RooWebScaffold(path = "agences", formBackingObject = Agence.class)
public class AgenceController {
}
