package com.polypharm.gescom.sheetLoader;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polypharm.gescom.domain.Produit;
import com.polypharm.gescom.domain.VeilleConcurrentielleProduit;
import com.polypharm.gescom.repository.ProduitRepository;
import com.polypharm.gescom.service.VeilleConcurrentielleProduitService;

@Service
public class VeilleConcurentielleLoader {

	@Autowired
	private VeilleConcurrentielleProduitService concurrentielleProduitService;
	@Autowired
	private ProduitRepository produitRepository;
	
	public void update(Row row){
		
		VeilleConcurrentielleProduit vCproduit = new VeilleConcurrentielleProduit();
		
		Cell cell = row.getCell(0);
		if(cell != null && StringUtils.isNotBlank(cell.getStringCellValue())){
			
			//find by name
			List<Produit> findByNom = produitRepository.findByNom(cell.getStringCellValue().trim());
			if(findByNom != null && findByNom.size() > 0){
				vCproduit.setProduit(findByNom.get(0));
			}else{
				//find by code
				List<Produit> findByCode = produitRepository.findByCode(cell.getStringCellValue().trim());
				if(findByCode != null && findByCode.size() > 0){
					vCproduit.setProduit(findByCode.get(0));
				}
			}		
		}else{
			return;
		}
		
		cell = row.getCell(1);
		if (cell != null){
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			BigDecimal decimal = new BigDecimal(cell.getNumericCellValue());
			vCproduit.setPrixDeVente(decimal);
		}
		
		cell = row .getCell(2);
		if(cell != null && StringUtils.isNotBlank(cell.getStringCellValue())){
			vCproduit.setDistributeurPrincipal(cell.getStringCellValue().trim());
		}
		
		cell = row.getCell(3);
		if (cell != null){
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			BigDecimal decimal = new BigDecimal(cell.getNumericCellValue());
			vCproduit.setNiveauStockProduitChezConcurent(decimal);
		}
		
		concurrentielleProduitService.saveVeilleConcurrentielleProduit(vCproduit);
	}
}
