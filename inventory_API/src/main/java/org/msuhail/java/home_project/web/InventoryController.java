package org.msuhail.java.home_project.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.msuhail.java.home_project.DAO.Inventory_DAO;
import org.msuhail.java.home_project.service.Inventory_Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class InventoryController {

@RequestMapping(value = "/Inventory.htm", method = RequestMethod.GET)
public ModelAndView Inventory() throws JsonGenerationException, JsonMappingException, IOException {
		ModelAndView LoginView = new ModelAndView("Register");
		
	
		ObjectMapper mapper = new ObjectMapper();
		String inventory_list=mapper.writeValueAsString(Inventory_Service.GetAllInventory());
		
		LoginView.addObject("HelloWorld",inventory_list);
		return LoginView;

	}

}
