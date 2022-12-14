package com.study.servlet.form;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/api/form/1")
public class FormApi1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get요청옴");
		/*
		 * System.out.println(request.getParameter("name"));
		 * System.out.println(request.getParameter("phone"));
		 * System.out.println(request.getParameter("email"));
		 * System.out.println(request.getParameter("address"));
		 * System.out.println(request.getParameter("password"));
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post요청옴");
//		키값은 name
//		get요청때는 안해줘도 되는데 post요청에서는 utf-8로 인코딩을 해줘야 함
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=utf8");
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("phone"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("address"));
		System.out.println(request.getParameter("password"));
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
//		getParameter는 String(문자열)타입이기때문에 숫자로 사용하고싶다면 문자열로 변환을 해줘야함.
		
		response.getWriter().print("name: " + name);
		response.getWriter().print("phone: " + phone);
		response.getWriter().print("email: " + email);
		response.getWriter().print("address: " + address);
		response.getWriter().print("password: " + password);

		
	}

}
