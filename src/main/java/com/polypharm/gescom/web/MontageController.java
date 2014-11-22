package com.polypharm.gescom.web;
import com.polypharm.gescom.domain.Montage;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/montages")
@Controller
@RooWebScaffold(path = "montages", formBackingObject = Montage.class)
public class MontageController {
}
