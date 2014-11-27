package com.polypharm.gescom.sheetLoader;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polypharm.gescom.domain.Client;
import com.polypharm.gescom.domain.ProjetCommande;
import com.polypharm.gescom.repository.ClientRepository;
import com.polypharm.gescom.service.ProjetCommandeService;

@Service
public class ProjetCommandeLoader {
	
	@Autowired
	private ProjetCommandeService commandeService;
	@Autowired
	private ClientRepository clientRepository;
	
	public void update(Row row){
		
		ProjetCommande commande = new ProjetCommande();
		
		Cell cell = row.getCell(0);
		if(cell != null && StringUtils.isNotBlank(cell.getStringCellValue())){
			commande.setObjetProjet(cell.getStringCellValue().trim());
		}else{
			return;
		}
		
		cell = row.getCell(1);
		if (cell != null){
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			BigDecimal decimal = new BigDecimal(cell.getNumericCellValue());
			commande.setReferencePROFORMA(decimal.toString());
		}else{
			return;
		}
		
		cell = row.getCell(2);
		if (cell != null){
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			BigDecimal decimal = new BigDecimal(cell.getNumericCellValue());
			commande.setReferenceBonCommande(decimal.toString());
		}else{
			return;
		}
		
		cell = row.getCell(3);
		if(cell != null && StringUtils.isNotBlank(cell.getStringCellValue())){
			
			//find by name
			List<Client> findByNom = clientRepository.findByNom(cell.getStringCellValue().trim());
			if(findByNom != null && findByNom.size() > 0){
				commande.setClientConcerne(findByNom.get(0));
			}else{
				//find by code
				List<Client> findByCode = clientRepository.findByCode(cell.getStringCellValue().trim());
				if(findByCode != null && findByCode.size() > 0){
					commande.setClientConcerne(findByCode.get(0));
				}
			}		
		}else{
			return;
		}
		
	
		cell = row.getCell(4);
		if(cell != null && StringUtils.isNotBlank(cell.getStringCellValue())){
			commande.setInterlocuteurPrincipal(cell.getStringCellValue().trim());
		}

		commandeService.saveProjetCommande(commande);
	}

}
