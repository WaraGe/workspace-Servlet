package com.study.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test/page/1")
public class Test1Page extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Dispatcher : 요청이 들어왔을때 해당 페이지로 html을 응답을 해줌
//		forward한다는것은 서블릿 - doget요청이 들어 왔을때 html팡리에 request,response 정보를 넘기겠다는 의미 응답까지 이어줌
		request.getRequestDispatcher("/WEB-INF/test1.html").forward(request, response);
		
		
	}

}
