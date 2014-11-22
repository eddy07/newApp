package com.polypharm.gescom.web;
import com.polypharm.gescom.domain.AssistanceCommerciale;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/assistancecommerciales")
@Controller
@RooWebScaffold(path = "assistancecommerciales", formBackingObject = AssistanceCommerciale.class)
public class AssistanceCommercialeController {
}
