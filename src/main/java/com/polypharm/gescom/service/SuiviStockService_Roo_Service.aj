// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.polypharm.gescom.service;

import com.polypharm.gescom.domain.SuiviStock;
import com.polypharm.gescom.service.SuiviStockService;
import java.util.List;

privileged aspect SuiviStockService_Roo_Service {
    
    public abstract long SuiviStockService.countAllSuiviStocks();    
    public abstract void SuiviStockService.deleteSuiviStock(SuiviStock suiviStock);    
    public abstract SuiviStock SuiviStockService.findSuiviStock(Long id);    
    public abstract List<SuiviStock> SuiviStockService.findAllSuiviStocks();    
    public abstract List<SuiviStock> SuiviStockService.findSuiviStockEntries(int firstResult, int maxResults);    
    public abstract void SuiviStockService.saveSuiviStock(SuiviStock suiviStock);    
    public abstract SuiviStock SuiviStockService.updateSuiviStock(SuiviStock suiviStock);    
}