package com.study.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.study.util.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
class Phonenum {
	private String phonenum1;
	private String phonenum2;
	private String phonenum3;
}


@WebServlet("/api/ajax3")
public class Ajax3Api extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Map<String, String> map = DTO.getParams(request);
		String jsonData = request.getParameter("jsonData");
		System.out.println(jsonData);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		Map<String, Object> addressMap = gson.fromJson(jsonData, Map.class); // 그냥 gson데이터는 문자열이기 때문에 쓸수 없으므로 gson으로 변경해서 Map 사용
		
		Phonenum address = gson.fromJson(jsonData, Phonenum.class);
		
		System.out.println(addressMap.get("address1"));
	
		System.out.println(address);
		System.out.println(address.getPhonenum1());
		
		Phonenum address2 = Phonenum.builder()
				.phonenum1("010")
				.phonenum2("9988")
				.phonenum3("1916")
				.build();
		
		String responseJson = gson.toJson(address2);
		
		response.setContentType("text/plain; charset=utf8");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		out.print(responseJson);

		
		
	}

}
