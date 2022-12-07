package com.study.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.study.util.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
class a {
	private String phonenum1;
	private String phonenum2;
	private String phonenum3;
}


@WebServlet("/api/ajax4")
public class Ajax4Api extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String JsonData = request.getParameter("data");
		Map<String, Object> dataMap = gson.fromJson(JsonData, Map.class);
		/*
		 * List<String> phoneNumbers = new ArrayList<>();
		 * 
		 * dataMap.forEach((key, value) -> { if(value.getClass() == String.class) {
		 * phoneNumbers.add((String)value); }
		 * 
		 * });
		 */
		
		response.setContentType("application/json; charset=utf8");
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		
		PrintWriter out = response.getWriter();
		
		StringBuilder stringBuilder = new StringBuilder(); // 문자열을 만들어주는 빌더
		
		dataMap.forEach((key, value) -> { 
			stringBuilder.append(value);
			stringBuilder.append("-");	  
		});
		
		stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()); 
		// 123-5678-9123 delete로 -위치를 잡아서 지워줌 subString과 같음 앞부터 ~ 뒤까지
        // 마지막인덱스 -1, 
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("responseData", stringBuilder.toString());
		
		out.print(jsonObject.toString());
	}

}