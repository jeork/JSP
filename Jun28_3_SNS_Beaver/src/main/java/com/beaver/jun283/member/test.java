package com.beaver.jun283.member;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class test {
	public static void main(String[] args) {
		try {
			String s = "인코딩 테스트";
			System.out.println("인코딩!");
			s = URLEncoder.encode(s, "UTF-8").replace("+", " ");
			System.out.println(s);
			System.out.println("디코딩!");
			s = URLDecoder.decode(s, "UTF-8");
			System.out.println(s);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
