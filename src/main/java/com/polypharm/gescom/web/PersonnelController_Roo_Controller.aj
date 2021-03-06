// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.polypharm.gescom.web;

import com.polypharm.gescom.domain.Personnel;
import com.polypharm.gescom.domain.RoleName;
import com.polypharm.gescom.service.AgenceService;
import com.polypharm.gescom.service.PersonnelService;
import com.polypharm.gescom.web.PersonnelController;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
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

privileged aspect PersonnelController_Roo_Controller {
    
    @Autowired
    PersonnelService PersonnelController.personnelService;
    
    @Autowired
    AgenceService PersonnelController.agenceService;
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String PersonnelController.create(@Valid Personnel personnel, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, personnel);
            return "personnels/create";
        }
        uiModel.asMap().clear();
        personnelService.savePersonnel(personnel);
        return "redirect:/personnels/" + encodeUrlPathSegment(personnel.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String PersonnelController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Personnel());
        return "personnels/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String PersonnelController.show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("personnel", personnelService.findPersonnel(id));
        uiModel.addAttribute("itemId", id);
        return "personnels/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String PersonnelController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("personnels", Personnel.findPersonnelEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) personnelService.countAllPersonnels() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("personnels", Personnel.findAllPersonnels(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "personnels/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String PersonnelController.update(@Valid Personnel personnel, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, personnel);
            return "personnels/update";
        }
        uiModel.asMap().clear();
        personnelService.updatePersonnel(personnel);
        return "redirect:/personnels/" + encodeUrlPathSegment(personnel.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String PersonnelController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, personnelService.findPersonnel(id));
        return "personnels/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String PersonnelController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Personnel personnel = personnelService.findPersonnel(id);
        personnelService.deletePersonnel(personnel);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/personnels";
    }
    
    void PersonnelController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("personnel_accountexpiration_date_format", "dd-MM-yyyy");
        uiModel.addAttribute("personnel_credentialexpiration_date_format", "dd-MM-yyyy");
    }
    
    void PersonnelController.populateEditForm(Model uiModel, Personnel personnel) {
        uiModel.addAttribute("personnel", personnel);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("agences", agenceService.findAllAgences());
        uiModel.addAttribute("rolenames", Arrays.asList(RoleName.values()));
    }
    
    String PersonnelController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
