package com.servlet;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LC")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@PostConstruct
	private void post() {
		System.out.println("--PostConstruct--");

	}
	@Override
	public void init() throws ServletException {
		System.out.println("--init--");
		super.init();
	}
	
	@Override
	public void destroy() {
		System.out.println("--destroy--");
		super.destroy();
	}
	@PreDestroy
	private void preD() {
		System.out.println("--preDestroy--");

	}
	
	
    public LifeCycle() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
