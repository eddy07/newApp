// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.polypharm.gescom.web;

import com.polypharm.gescom.domain.VCDistributeurConcurent;
import com.polypharm.gescom.service.ProduitService;
import com.polypharm.gescom.service.VCDistributeurConcurentService;
import com.polypharm.gescom.web.VCDistributeurConcurentController;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect VCDistributeurConcurentController_Roo_Controller {
    
    @Autowired
    VCDistributeurConcurentService VCDistributeurConcurentController.vCDistributeurConcurentService;
    
    @Autowired
    ProduitService VCDistributeurConcurentController.produitService;
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String VCDistributeurConcurentController.create(@Valid VCDistributeurConcurent VCDistributeurConcurent_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, VCDistributeurConcurent_);
            return "vcdistributeurconcurents/create";
        }
        uiModel.asMap().clear();
        vCDistributeurConcurentService.saveVCDistributeurConcurent(VCDistributeurConcurent_);
        return "redirect:/vcdistributeurconcurents/" + encodeUrlPathSegment(VCDistributeurConcurent_.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String VCDistributeurConcurentController.createForm(Model uiModel) {
        populateEditForm(uiModel, new VCDistributeurConcurent());
        return "vcdistributeurconcurents/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String VCDistributeurConcurentController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("vcdistributeurconcurent_", vCDistributeurConcurentService.findVCDistributeurConcurent(id));
        uiModel.addAttribute("itemId", id);
        return "vcdistributeurconcurents/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String VCDistributeurConcurentController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("vcdistributeurconcurents", vCDistributeurConcurentService.findVCDistributeurConcurentEntries(firstResult, sizeNo));
            float nrOfPages = (float) vCDistributeurConcurentService.countAllVCDistributeurConcurents() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("vcdistributeurconcurents", vCDistributeurConcurentService.findAllVCDistributeurConcurents());
        }
        return "vcdistributeurconcurents/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String VCDistributeurConcurentController.update(@Valid VCDistributeurConcurent VCDistributeurConcurent_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, VCDistributeurConcurent_);
            return "vcdistributeurconcurents/update";
        }
        uiModel.asMap().clear();
        vCDistributeurConcurentService.updateVCDistributeurConcurent(VCDistributeurConcurent_);
        return "redirect:/vcdistributeurconcurents/" + encodeUrlPathSegment(VCDistributeurConcurent_.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String VCDistributeurConcurentController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, vCDistributeurConcurentService.findVCDistributeurConcurent(id));
        return "vcdistributeurconcurents/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String VCDistributeurConcurentController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        VCDistributeurConcurent VCDistributeurConcurent_ = vCDistributeurConcurentService.findVCDistributeurConcurent(id);
        vCDistributeurConcurentService.deleteVCDistributeurConcurent(VCDistributeurConcurent_);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/vcdistributeurconcurents";
    }
    
    void VCDistributeurConcurentController.populateEditForm(Model uiModel, VCDistributeurConcurent VCDistributeurConcurent_) {
        uiModel.addAttribute("VCDistributeurConcurent_", VCDistributeurConcurent_);
        uiModel.addAttribute("produits", produitService.findAllProduits());
    }
    
    String VCDistributeurConcurentController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}