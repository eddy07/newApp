package com.polypharm.gescom.sheetLoader;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polypharm.gescom.domain.Produit;
import com.polypharm.gescom.domain.VCDistributeurConcurent;
import com.polypharm.gescom.repository.ProduitRepository;
import com.polypharm.gescom.service.VCDistributeurConcurentService;

@Service
public class VeilleConcurentielleDistributeurLoader {
	@Autowired
	private VCDistributeurConcurentService concurentService;
	@Autowired
	private ProduitRepository produitRepository;
	
	public void update(Row row){
		
		VCDistributeurConcurent vcDistributeurConcurent = new VCDistributeurConcurent();
		
		Cell cell = row.getCell(0);
		if(cell != null && StringUtils.isNotBlank(cell.getStringCellValue())){
			vcDistributeurConcurent.setNomDistributeur(cell.getStringCellValue().trim());
		}else{
			return;
		}
		
		cell = row.getCell(1);
		if(cell != null && StringUtils.isNotBlank(cell.getStringCellValue())){
			vcDistributeurConcurent.setLocalisation(cell.getStringCellValue().trim());
		}
		
		cell = row.getCell(2);
		if(cell != null && StringUtils.isNotBlank(cell.getStringCellValue())){
			
			String[] split = StringUtils.split(cell.getStringCellValue().trim(), ",");
			
			for(String pd:split){
				
				//find by name
				List<Produit> findByNom = produitRepository.findByNom(pd);
				if(findByNom != null && findByNom.size() > 0){
					vcDistributeurConcurent.getProduitsDistribues().add((findByNom.get(0)));
				}else{
					//find by code
					List<Produit> findByCode = produitRepository.findByCode(pd);
					if(findByCode != null && findByCode.size() > 0){
						vcDistributeurConcurent.getProduitsDistribues().add((findByCode.get(0)));
					}
				}					
			}
					
		}else{
			return;
		}
		
		concurentService.saveVCDistributeurConcurent(vcDistributeurConcurent);
	}

}
