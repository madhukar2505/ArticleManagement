package com.article.manage.controller;

import javax.jws.HandlerChain;
import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginContrller {
	
	
	@RequestMapping(value="am/login" ,method = RequestMethod.GET )
	public ModelAndView login(ModelAndView modelAndView , ServletRequest req){
		
		modelAndView.setViewName("login");
		return modelAndView;
		
	}

}
