package com.harry.spring.struts2.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application Lifecycle Listener implementation class springContextListenner
 *
 */
public class springContextListenner implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public springContextListenner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	//获取Spring配置文件的名称
    	ServletContext servletContext = sce.getServletContext();
    	String config = servletContext.getInitParameter("configLocation");
    	
        //1. 创建IOC 容器
    	ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
    	
    	//2. 把IOC 容器放在ServletContext的一个属性中
    	servletContext.setAttribute("ApplicationContext", ctx);
    }
	
}
