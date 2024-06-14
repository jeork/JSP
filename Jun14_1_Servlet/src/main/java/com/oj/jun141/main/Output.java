package com.oj.jun141.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/Output")
public class Output extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		String filename = request.getParameter("filename");
		String title = request.getParameter("title");
		out.print("<html>");
		out.print("<head><meta charset=\"UTF-8\"><title>Insert title here</title></head>");
		out.print("<body>");
		out.printf("<h1>제목 : %s</h1>",title);
		out.printf("<img src='%s'>",filename);
		out.print("<br>");
		
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 기존(주황색) 방식으로 전송된 파라미터 한글 처리
		// request.setCharacterEncoding("UTF-8");
		
		// 기존(주황색) 방식으로 전송된 파라미터 읽기
		// String title = request.getParameter("title");
		
		response.setCharacterEncoding("UTF-8");
		
		// 파일이 업로드 될 서버상의 폴더의 절대경로
		String path = request.getServletContext().getRealPath("img");
		System.out.println(path);
		
		// 파일 업로드
		MultipartRequest mr  = new MultipartRequest(
				request, path,
				//허용할 파일의 최대크기
				10*1024*1024,
				// 요청 파라미터 인코딩 방식
				"UTF-8",
				// 사용자가 업로드한 파일명이 중복될때 처리
				// 중복시에 파일명 뒤에 숫자를 붙이게하는 방식
				new DefaultFileRenamePolicy());
		
		String title=mr.getParameter("title");
		// 업로드 한 파일명(중복처리된)
		String fileName = mr.getFilesystemName("filename");
		
		// DB에 파일명 저장할 때 => 용량을 상당히 여유있게 만들어야함
		// f_name varchar2(200char)
		
		// 그 이유는 : 톰캣이 한글로 된 파일명 인식 못함
		//	ㅋ.png => %2A.png(URL 인코딩이면 인식)
		fileName = URLEncoder.encode(fileName, "UTF-8");
		
		String fileName2 = mr.getFilesystemName("etc");
		fileName2 = URLEncoder.encode(fileName2,"UTF-8");
		fileName2 = fileName2.replace("+", " ");
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><meta charset=\"UTF-8\"><title>Insert title here</title></head>");
		out.print("<body>");
		
		out.printf("<h1>제목 : %s</h1>",title);
		out.printf("<h1>파일명 : %s</h1>",fileName);
		out.printf("<img src='img/%s'>",fileName); //상대 경로O
		out.printf("<h1>%s</h1>",fileName2);
		out.printf("<a href='img/%s'>다운</a>",fileName2);
			
		out.print("</body>");
		out.print("</html>");
	}
}