package com.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test1
 */
@WebServlet("/test/1")
public class Test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
		public void init() throws ServletException {
//		              최초로 한번 실행됨
			System.out.println("Test1 클래스 init() 호출");
		}
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TEst1 클래스 service() 호출");
//		요청이 들어올때의 문자를 UTF-8로 변환
		request.setCharacterEncoding("UTF-8");
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("phone"));
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>테스트1</title></head><body>");
		out.print("<h1>테스트1 서블릿 호출</h1>");
		out.print("</body></html>");
	}
	
	@Override
	public void destroy() {
//		            서버가 닫히기전에 실행
		System.out.println("Test1클래스 destory() 호출");
	}
	
}
