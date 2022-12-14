package com.study.servlet;
//ctrl + shift + o = 필요한 import 정리

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/req/1")
public class RequestPrams1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("ContextType: " + req.getContentType());
		System.out.println("localPort: " + req.getLocalPort());
		System.out.println("Method: " + req.getMethod());
		System.out.println("RequestURI: " + req.getRequestURI());
		System.out.println("QueryString: " + req.getQueryString());
		String test = req.getParameter("test");
		String name = req.getParameter("name");
//		System.out.println("Parameter test: " + req.getParameter("test"));
//		System.out.println("Parameter name: " + req.getParameter("name"));
		
//		응답할대의 인코딩을 변경하는 방법. UTF-8을 입력하지 않으면 한글이 깨져서 나옴
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain; charset=utf8");
		resp.getWriter().print("test: " + test);
		resp.getWriter().print("name: " + name);
		
//		url기준 ?기준으로 뒤는 모두 QueryString 
//		System.out.println("Parameter name: " + req.getParameter("name")); 주소창에서 명령때리는거는 무조건 get요청
		
	}
    
}