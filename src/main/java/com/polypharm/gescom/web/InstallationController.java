package com.polypharm.gescom.web;
import com.polypharm.gescom.domain.Installation;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/installations")
@Controller
@RooWebScaffold(path = "installations", formBackingObject = Installation.class)
public class InstallationController {
}
