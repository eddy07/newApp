package com.polypharm.gescom.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.polypharm.gescom.sheetLoader.DataSheetLoader;

@RequestMapping("/espace")
@Controller
public class HomeController {
	
	@Autowired
	private DataSheetLoader dataSheetLoader;
	
	@RequestMapping(value="/{espace}")
	public String espace(@PathVariable("espace") String espace){
		System.out.print(espace);
		return ""+espace;
	}


		
}