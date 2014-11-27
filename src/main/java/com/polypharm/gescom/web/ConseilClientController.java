package com.polypharm.gescom.web;
import com.polypharm.gescom.domain.ConseilClient;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/conseilclients")
@Controller
@RooWebScaffold(path = "conseilclients", formBackingObject = ConseilClient.class)
public class ConseilClientController {
}
