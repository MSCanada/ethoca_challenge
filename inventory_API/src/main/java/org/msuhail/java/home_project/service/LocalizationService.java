package org.msuhail.java.home_project.service;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LocalizationService {

	
public static String GetMessage(Locale loc){	
	ApplicationContext context=new ClassPathXmlApplicationContext("spring-persistence-context.xml");
	String englishMsg = context.getMessage("name.question",null, loc);
	return englishMsg;
	
}
}