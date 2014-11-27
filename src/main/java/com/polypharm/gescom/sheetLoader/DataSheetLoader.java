package com.polypharm.gescom.sheetLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataSheetLoader {
	
	@Autowired
	private RecrutementProspectLoader recrutementProspectLoader;
	@Autowired
	private VulgarisationProduitLoader vulgarisationProduitLoader;
	@Autowired
	private SuiviStockLoader suiviStockLoader;
	@Autowired
	private VeilleConcurentielleLoader veilleConcurentielleLoader;
	@Autowired
	private DossierCreanceLoader dossierCreanceLoader;
	@Autowired
	private LivraisonLoader livraisonLoader;
	@Autowired
	private VeilleConcurentielleDistributeurLoader vcdistributeurLoader;
	@Autowired
	private ProjetCommandeLoader commandeLoader;
	
	public InputStream loadFile(){
		
		String dataSheetFile = "polypharm.xls";
		InputStream stream = DataSheetLoader.class.getResourceAsStream("/" + dataSheetFile);
		return stream;
	}
	
	public void loadDataSheet(InputStream dataStream){
		
		try {
				HSSFWorkbook workbook = new HSSFWorkbook(dataStream);
				updateRecrutementProspect(workbook);
				updateVulgarisationProduit(workbook);
				updateSuiviStock(workbook);
				updateVeilleConcurentielle(workbook);
				updateDossierCreance(workbook);
				updateLivraison(workbook);
				updateVeilleConcurentielleDistributeur(workbook);
				updateProjetCommande(workbook);
				
				IOUtils.closeQuietly(dataStream);
	
		} catch (IOException e) {
			throw new IllegalStateException(e);
		} finally {
			IOUtils.closeQuietly(dataStream);
		}
		
	}
	
	
	public void updateRecrutementProspect(HSSFWorkbook workbook){
		HSSFSheet sheet = workbook.getSheet("RecrutementProspect");
		if(sheet==null) return;
		
		Iterator<Row> rowIterator = sheet.rowIterator();
		rowIterator.next();
		
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			recrutementProspectLoader.update(row);
		}		
	}
	
	public void updateVulgarisationProduit(HSSFWorkbook workbook){
		HSSFSheet sheet = workbook.getSheet("VulgarisationProduit");
		if(sheet==null) return;
		
		Iterator<Row> rowIterator = sheet.rowIterator();
		rowIterator.next();
	
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			vulgarisationProduitLoader.update(row);
		}		
	}
	
	public void updateSuiviStock(HSSFWorkbook workbook){
		HSSFSheet sheet = workbook.getSheet("SuiviStock");
		if(sheet==null) return;
		
		Iterator<Row> rowIterator = sheet.rowIterator();
		rowIterator.next();
		
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			suiviStockLoader.update(row);
		}		
	}
	
	public void updateVeilleConcurentielle(HSSFWorkbook workbook){
		HSSFSheet sheet = workbook.getSheet("VeilleConcurrentielleProduit");
		if(sheet==null) return;
		
		Iterator<Row> rowIterator = sheet.rowIterator();
		rowIterator.next();
		
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			veilleConcurentielleLoader.update(row);
		}		
	}
	
	public void updateDossierCreance(HSSFWorkbook workbook){
		HSSFSheet sheet = workbook.getSheet("DossierCreance");
		if(sheet==null) return;
		
		Iterator<Row> rowIterator = sheet.rowIterator();
		rowIterator.next();
		
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			dossierCreanceLoader.update(row);
		}		
	}
	
	public void updateLivraison(HSSFWorkbook workbook){
		HSSFSheet sheet = workbook.getSheet("Livraison");
		if(sheet==null) return;
		
		Iterator<Row> rowIterator = sheet.rowIterator();
		rowIterator.next();

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			livraisonLoader.update(row);
		}		
	}
	
	public void updateVeilleConcurentielleDistributeur(HSSFWorkbook workbook){
		HSSFSheet sheet = workbook.getSheet("VielleConcurentielleDistributeur");
		if(sheet==null) return;
		
		Iterator<Row> rowIterator = sheet.rowIterator();
		rowIterator.next();
		
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			vcdistributeurLoader.update(row);
		}		
	}
	
	public void updateProjetCommande(HSSFWorkbook workbook){
		HSSFSheet sheet = workbook.getSheet("ProjetCommande");
		if(sheet==null) return;
		
		Iterator<Row> rowIterator = sheet.rowIterator();
		rowIterator.next();
		
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			commandeLoader.update(row);
		}		
	}

}
