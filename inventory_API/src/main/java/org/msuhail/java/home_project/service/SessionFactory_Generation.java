package org.msuhail.java.home_project.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;
@Service
public class SessionFactory_Generation implements InitializingBean {
@Autowired	
private SessionFactory sessionFactory;
private static SessionFactory sessionFactory_dummy;

public static SessionFactory returnSessionFactory(){
	return sessionFactory_dummy;
}


public void afterPropertiesSet() throws Exception {
	sessionFactory_dummy=sessionFactory;
	
}

}
