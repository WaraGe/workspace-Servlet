package com.study.servlet.account;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.domain.User;
import com.study.service.AccountService;
import com.study.util.DTO;

@WebServlet("/auth/login")
public class LoginApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> loginUser = DTO.getParams(request);
		AccountService accountService = AccountService.getInstance();
		
		User user = accountService.loadUserByUsername(loginUser.get("username"));
		
		if(user == null) {
			System.out.println("아이디 틀림");
			//error_login -> script : 사용자 정보를 확인해주세요. history.back(); 뒤로가기 - 로그인창으로 돌려줌
			
			return;
		}
		if (!accountService.checkPassword(user, loginUser.get("password"))) {
			System.out.println("비밀번호 틀림!");
			//error_login -> script : 사용자 정보를 확인해주세요. history.back(); 뒤로가기 - 로그인창으로 돌려줌
			
			return;
		}
		
		// 로그인 성공
		
		
//		System.out.println(DTO.getParams(request)); //parameter를 map으로 바꿔줌 (dto)
		
//		Map<String, String> dataMap = new HashMap<>();
//		Set<String> ketSet = request.getParameterMap().keySet();
//		ketSet.forEach (key -> {
//			dataMap.put(key, request.getParameter(key));
//		});
//		
//		System.out.println(dataMap);
		
		
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		
//		response.getWriter().print("username: " + username);
//		response.getWriter().print("password: " + password);
//		
//		System.out.println("ID: " + username);
//		System.out.println("PASS: " + password);
	}

}
