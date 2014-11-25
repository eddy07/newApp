package com.polypharm.gescom.sheetLoader;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polypharm.gescom.domain.Client;
import com.polypharm.gescom.domain.Produit;
import com.polypharm.gescom.domain.VulgarisationProduit;
import com.polypharm.gescom.repository.ClientRepository;
import com.polypharm.gescom.repository.ProduitRepository;
import com.polypharm.gescom.service.VulgarisationProduitService;


@Service
public class VulgarisationProduitLoader {
	
	@Autowired
	VulgarisationProduitService vProduitService;
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	ClientRepository clientRepository;
	
	public void update(Row row){
		
		VulgarisationProduit vProduit = new VulgarisationProduit();
		
		Cell cell = row.getCell(0);
		if(cell != null && StringUtils.isNotBlank(cell.getStringCellValue())){
			
			//find by name
			List<Produit> findByNom = produitRepository.findByNom(cell.getStringCellValue().trim());
			if(findByNom != null && findByNom.size() > 0){
				vProduit.setProduitVulgarise(findByNom.get(0));
			}else{
				//find by code
				List<Produit> findByCode = produitRepository.findByCode(cell.getStringCellValue().trim());
				if(findByCode != null && findByCode.size() > 0){
					vProduit.setProduitVulgarise(findByCode.get(0));
				}
			}		
		}else{
			return;
		}
		
		cell = row.getCell(1);
		if(cell != null && StringUtils.isNotBlank(cell.getStringCellValue())){
			
			//find by name
			List<Client> findByNom = clientRepository.findByNom(cell.getStringCellValue().trim());
			if(findByNom != null && findByNom.size() > 0){
				vProduit.setClient(findByNom.get(0));
			}else{
				//find by code
				List<Client> findByCode = clientRepository.findByCode(cell.getStringCellValue().trim());
				if(findByCode != null && findByCode.size() > 0){
					vProduit.setClient(findByCode.get(0));
				}
			}		
		}else{
			return;
		}
		
		cell = row .getCell(2);
		if(cell != null && StringUtils.isNotBlank(cell.getStringCellValue())){
			vProduit.setNomInterlocuteur(cell.getStringCellValue().trim());
		}
		
		cell = row .getCell(3);
		if (cell != null){
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			BigDecimal decimal = new BigDecimal(cell.getNumericCellValue());
			vProduit.setTelInterlocuteur(decimal.toString());
		}
		
		cell = row .getCell(4);
		if(cell != null && cell.getDateCellValue() != null){		
			//Date dateFormat = DateUtil.StringToDateFormat(cell.getStringCellValue().trim());
			vProduit.setDateVulgarisation(cell.getDateCellValue());
		}
		
		vProduitService.saveVulgarisationProduit(vProduit);
	}

}
