package com.polypharm.gescom.web;
import com.polypharm.gescom.domain.Personnel;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/personnels")
@Controller
@RooWebScaffold(path = "personnels", formBackingObject = Personnel.class)
public class PersonnelController {
}
