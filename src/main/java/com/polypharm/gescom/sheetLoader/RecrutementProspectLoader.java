package com.polypharm.gescom.sheetLoader;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polypharm.gescom.domain.RecrutementProspect;
import com.polypharm.gescom.service.RecrutementProspectService;

@Service
public class RecrutementProspectLoader {
	
	@Autowired
	RecrutementProspectService prospectService;
	
	public void update(Row row){
		
		RecrutementProspect recruProspect = new RecrutementProspect();
		
		Cell cell = row .getCell(0);
		if(cell != null && StringUtils.isNotBlank(cell.getStringCellValue())){
			recruProspect.setDenominationProspect(cell.getStringCellValue().trim());
		}else{
			return;
		}
		
		cell = row .getCell(1);
		if(cell != null && StringUtils.isNotBlank(cell.getStringCellValue())){
			//recruProspect.setInterlocuteurs(cell.getStringCellValue().trim());
		}
		
		cell = row .getCell(2);
		if(cell != null && StringUtils.isNotBlank(cell.getStringCellValue())){
			recruProspect.setFctionInterlocuteur(cell.getStringCellValue().trim());
		}
		
		cell = row .getCell(3);
		if (cell != null){
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			BigDecimal decimal = new BigDecimal(cell.getNumericCellValue());
			recruProspect.setTelephone(decimal.toString());
		}

		
		cell = row .getCell(4);
		if(cell != null && StringUtils.isNotBlank(cell.getStringCellValue())){
			recruProspect.setEmail(cell.getStringCellValue().trim());
		}
		
		cell = row .getCell(5);
		if(cell != null && StringUtils.isNotBlank(cell.getStringCellValue())){
			recruProspect.setBoitePostale(cell.getStringCellValue().trim());
		}
		
		cell = row .getCell(6);
		if(cell != null && StringUtils.isNotBlank(cell.getStringCellValue())){
			recruProspect.setLocalisation(cell.getStringCellValue().trim());
		}
		
		cell = row .getCell(7);
		if(cell != null && cell.getDateCellValue() != null){
			
			//Date dateFormat = DateUtil.StringToDateFormat(cell.getStringCellValue().trim());
			recruProspect.setDateRecrutement(cell.getDateCellValue());
		}
		
		prospectService.saveRecrutementProspect(recruProspect);
		
	}
}
