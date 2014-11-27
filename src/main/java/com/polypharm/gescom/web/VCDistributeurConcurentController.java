package com.polypharm.gescom.web;
import com.polypharm.gescom.domain.VCDistributeurConcurent;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vcdistributeurconcurents")
@Controller
@RooWebScaffold(path = "vcdistributeurconcurents", formBackingObject = VCDistributeurConcurent.class)
public class VCDistributeurConcurentController {
}
