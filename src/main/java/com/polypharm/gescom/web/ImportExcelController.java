package com.polypharm.gescom.web;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.polypharm.gescom.sheetLoader.DataSheetLoader;

@RequestMapping("/import")
@Controller
public class ImportExcelController {
	
	@Autowired
	private DataSheetLoader dataSheetLoader;
	
	@RequestMapping(value="/excelfile", method = RequestMethod.POST)
	public String importExcelFile(@RequestParam("sheetFile") MultipartFile sheetFile){
		
		try {
			InputStream stream = sheetFile.getInputStream();
			dataSheetLoader.loadDataSheet(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "index";
	}

	@RequestMapping("/excelfile1")
	public String importExcelFile1(){
		
		InputStream stream = dataSheetLoader.loadFile();
		dataSheetLoader.loadDataSheet(stream);
		
		return "index";
	}
}
