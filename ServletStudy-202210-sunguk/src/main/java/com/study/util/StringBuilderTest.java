package com.study.util;

public class StringBuilderTest {

	public static void main(String[] args) {
//		stringbuilder 사용하는 이유
		String str = "문자열1";
		str += "문자열2";
		str = str.replaceAll("문자열2", "문자열3");
//		기존의 문자를 찾아서 뒤에 있는 문자로 바꿔라
		
		System.out.println(str);
		
		StringBuilder builder = new StringBuilder(32); // 비동기식
		StringBuffer buffer = new StringBuffer(); // 동기식

	}

}
