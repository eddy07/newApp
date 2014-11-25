package com.polypharm.gescom.sheetLoader;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polypharm.gescom.domain.Client;
import com.polypharm.gescom.domain.DossierCreance;
import com.polypharm.gescom.repository.ClientRepository;
import com.polypharm.gescom.service.DossierCreanceService;

@Service
public class DossierCreanceLoader {
	
	@Autowired
	private DossierCreanceService creanceService;
	@Autowired
	private ClientRepository clientRepository;
	
	public void update(Row row){
		
		DossierCreance dossierCreance = new DossierCreance();
		
		Cell cell = row.getCell(0);	
		
		if (cell != null){
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			BigDecimal decimal = new BigDecimal(cell.getNumericCellValue());
			dossierCreance.setNumBonCommande(decimal.toString());
		}else{
			return;
		}
		
	    cell = row.getCell(1);	
		if (cell != null){
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			BigDecimal decimal = new BigDecimal(cell.getNumericCellValue());
			dossierCreance.setNumBonLivraison(decimal.toString());
		}else{
			return;
		}
		
		cell = row.getCell(2);	
		if (cell != null){
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			BigDecimal decimal = new BigDecimal(cell.getNumericCellValue());
			dossierCreance.setNumFacture(decimal.toString());
		}else{
			return;
		}
		
		cell = row.getCell(3);	
		if(cell != null && StringUtils.isNotBlank(cell.getStringCellValue())){
			dossierCreance.setNatureGarantie(cell.getStringCellValue().trim());
		}
		
		cell = row.getCell(4);
		if (cell != null){
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			BigDecimal decimal = new BigDecimal(cell.getNumericCellValue());
			dossierCreance.setNumContratCreance(decimal.toString());
		}else{
			return;
		}
		
		cell = row .getCell(6);
		if(cell != null && cell.getDateCellValue() != null){
			
			dossierCreance.setDateEchance(cell.getDateCellValue());
		}
		
		cell = row .getCell(5);
		if(cell != null && cell.getDateCellValue() != null){
			
			dossierCreance.setDateEmission(cell.getDateCellValue());
		}
		
		cell = row.getCell(7);
		if(cell != null && StringUtils.isNotBlank(cell.getStringCellValue())){
			
			//find by name
			List<Client> findByNom = clientRepository.findByNom(cell.getStringCellValue().trim());
			if(findByNom != null && findByNom.size() > 0){
				dossierCreance.setClient(findByNom.get(0));
			}else{
				//find by code
				List<Client> findByCode = clientRepository.findByCode(cell.getStringCellValue().trim());
				if(findByCode != null && findByCode.size() > 0){
					dossierCreance.setClient(findByCode.get(0));
				}
			}		
		}else{
			return;
		}
		
		creanceService.saveDossierCreance(dossierCreance);
	}

}
