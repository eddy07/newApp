// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.polypharm.gescom.web;

import com.polypharm.gescom.domain.ConseilClient;
import com.polypharm.gescom.service.ClientService;
import com.polypharm.gescom.service.ConseilClientService;
import com.polypharm.gescom.web.ConseilClientController;
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

privileged aspect ConseilClientController_Roo_Controller {
    
    @Autowired
    ConseilClientService ConseilClientController.conseilClientService;
    
    @Autowired
    ClientService ConseilClientController.clientService;
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String ConseilClientController.create(@Valid ConseilClient conseilClient, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, conseilClient);
            return "conseilclients/create";
        }
        uiModel.asMap().clear();
        conseilClientService.saveConseilClient(conseilClient);
        return "redirect:/conseilclients/" + encodeUrlPathSegment(conseilClient.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String ConseilClientController.createForm(Model uiModel) {
        populateEditForm(uiModel, new ConseilClient());
        return "conseilclients/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String ConseilClientController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("conseilclient", conseilClientService.findConseilClient(id));
        uiModel.addAttribute("itemId", id);
        return "conseilclients/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String ConseilClientController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("conseilclients", ConseilClient.findConseilClientEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) conseilClientService.countAllConseilClients() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("conseilclients", ConseilClient.findAllConseilClients(sortFieldName, sortOrder));
        }
        return "conseilclients/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String ConseilClientController.update(@Valid ConseilClient conseilClient, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, conseilClient);
            return "conseilclients/update";
        }
        uiModel.asMap().clear();
        conseilClientService.updateConseilClient(conseilClient);
        return "redirect:/conseilclients/" + encodeUrlPathSegment(conseilClient.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String ConseilClientController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, conseilClientService.findConseilClient(id));
        return "conseilclients/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String ConseilClientController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        ConseilClient conseilClient = conseilClientService.findConseilClient(id);
        conseilClientService.deleteConseilClient(conseilClient);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/conseilclients";
    }
    
    void ConseilClientController.populateEditForm(Model uiModel, ConseilClient conseilClient) {
        uiModel.addAttribute("conseilClient", conseilClient);
        uiModel.addAttribute("clients", clientService.findAllClients());
    }
    
    String ConseilClientController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
