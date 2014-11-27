package com.polypharm.gescom.web;
import com.polypharm.gescom.domain.SuiviStock;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/suivistocks")
@Controller
@RooWebScaffold(path = "suivistocks", formBackingObject = SuiviStock.class)
public class SuiviStockController {
}
