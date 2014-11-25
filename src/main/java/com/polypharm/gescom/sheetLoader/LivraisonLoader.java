package com.polypharm.gescom.sheetLoader;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polypharm.gescom.domain.Client;
import com.polypharm.gescom.domain.Livraison;
import com.polypharm.gescom.repository.ClientRepository;
import com.polypharm.gescom.service.LivraisonService;

@Service
public class LivraisonLoader {
	
	@Autowired
	private LivraisonService livraisonService;
	@Autowired
	private ClientRepository clientRepository;
	
	public void update(Row row){
		
		Livraison livraison = new Livraison();
		
		Cell cell = row.getCell(0);
		if (cell != null){
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			BigDecimal decimal = new BigDecimal(cell.getNumericCellValue());
			livraison.setNumeroBodereauLivraison(decimal.toString());
		}else{
			return;
		}
		
		cell = row.getCell(1);
		if(cell != null && StringUtils.isNotBlank(cell.getStringCellValue())){
			
			//find by name
			List<Client> findByNom = clientRepository.findByNom(cell.getStringCellValue().trim());
			if(findByNom != null && findByNom.size() > 0){
				livraison.setClient(findByNom.get(0));
			}else{
				//find by code
				List<Client> findByCode = clientRepository.findByCode(cell.getStringCellValue().trim());
				if(findByCode != null && findByCode.size() > 0){
					livraison.setClient(findByCode.get(0));
				}
			}		
		}else{
			return;
		}
		
		cell = row .getCell(2);
		if(cell != null && StringUtils.isNotBlank(cell.getStringCellValue())){	
			livraison.setDureLivraison(cell.getStringCellValue().trim());
		}else{
			return;
		}
		
		livraisonService.saveLivraison(livraison);
	}

}
