package com.harry.spring.struts2.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.harry.spring.struts2.bean.Person;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. 从application域对象中得到IOC容器的应用
		ServletContext servletContext = getServletContext();
		ApplicationContext ctx = (ApplicationContext) servletContext.getAttribute("ApplicationContext"); 
		
		//2.从IOC容器中得到需要的bean
		Person person = ctx.getBean(Person.class);
		person.hello();
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	

}
