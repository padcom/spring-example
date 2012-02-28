package org.example.spring.web;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.spring.Formatter;
import org.springframework.web.servlet.FrameworkServlet;

@WebServlet(name="example-servlet", urlPatterns = { "/*" })
public class ExampleServlet extends FrameworkServlet {
	private static final long serialVersionUID = -7545592821826019495L;

	private Formatter formatter;

	@Override
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		out.print(formatter.format("<h1>%s</h1>", "Hello, world!"));
	}
	
	@Override
	public String getContextConfigLocation() {
		return "/WEB-INF/applicationContext.xml";
	}
	
	@Override
	protected void initFrameworkServlet() throws ServletException {
		formatter = getWebApplicationContext().getBean(Formatter.class);
	}
}
