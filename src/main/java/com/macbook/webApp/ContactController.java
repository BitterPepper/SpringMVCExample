package com.macbook.webApp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/contacts")
@Controller
public class ContactController {
	private final Logger logger = LoggerFactory.getLogger(Controller.class);
	private ContactService contactService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String list(Model uiModel){
		logger.info("Listing contacts");
		
		List<Contact> contacts = contactService.findAll();
		uiModel.addAttribute("contacts", contacts);		
		logger.info("№ of contacts: " + contacts.size());
		
		return "contacts/list";
	}
	
	@Autowired
	public void setContactService(ContactService contactService){
		this.contactService = contactService;
	}
}
