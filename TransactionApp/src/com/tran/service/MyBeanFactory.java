package com.tran.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBeanFactory {

	static ApplicationContext ctx;
		static
	    {
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		}
public static ApplicationContext getAppContext()
{
return ctx;	
}
}
