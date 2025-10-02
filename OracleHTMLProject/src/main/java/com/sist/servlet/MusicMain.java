package com.sist.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MusicMain")
public class MusicMain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 브라우저로 형식 => 전송
		/*
		 * 	1. HTML => text/html
		 *  2. XML  => text/xml
		 *  3. JSON => text/plain *** VueJS
		 *  
		 *  => BufferedReader
		 *  request / response : OutputStream 
		 *    |			  |
		 *   요청		 응답 
		 *   			 -- 응답에 대한 모든 정보 
		 *   			 -- 사용자의 IP
		 *   --- 사용자가 보내준 모든 값을 가지고 있다 
		 *   
		 *   동작
		 *   1. init() => 초기화 (생성자 대신)
		 *   	 => web.xml등록된 데이터 읽기 
		 *   	 => 자동 로그인 (Cookie...)
		 *   2. service() : 사용자가 요청시 마다 호출 
		 *   	  = doGet()
		 *   	  = doPost()
		 *   3. destory() : 새로고침 / 화면이동 => 자동 메모리 회수 
		 *   	= 호출마다 초기화 
		 *   	= 단점 Ajax =>  React Vue
		 *   
		 *   -----------------------------------------------
		 *   MVC => Back / Front 
		 *   M : Model => java(VO,DAO,Manager,Service,Model)
		 *   V : View => JSP
		 *   C : Model+View => Servlet 
		 *   ---------------------------
		 *   
		 *   클라이언트 요청 ==== servlet ===== HTML변환 후 전송
		 *   	브라우저 
		 *   ------------------------------------tomcat
		 *   HttpServletRequest  : 클라이언트 요청 정보
		 *   HttpServletResponse : 서버 응답 
		 *   					   HTML / XML /JSON 
		 *   doPost/doGet : 요청에 처리 
		 *   
		 *   서블릿 찾기 => doGet / doPost 
		 *   	  
		 *   @WebServlet("/MusicMain")
		 *   http://localhost:8080/OracleHTMLProject/MusicMain
		 *   
		 *   1. 브라우저에서 서버 연결 
		 *   2. 데이터 전송
		 *   3. Servlet 받는다 doGet/doPost
		 *   4. 처리후에 => HTML을 브라우저로 전송
		 *   5. 브라우저 화면에 출력 
		 *   
		 *   out.println("<html>")
		 *   => 보완 => out.println을 생략 => JSP
		 */
		//1. 응답 형식
		response.setContentType("text/html;charset=UTF-8");
		// 누구에게 전송
		PrintWriter out=response.getWriter();
		/*
		 * 	 54page
		 * 	 HTML 구조 
		 * 	 <!DOCTYPE html> : html5버전을 읽어 온다 
		 * 	 ---------------
		 * 	 <html> // 문서의 시작
		 * 	   <head>
		 * 		 화면 출력 (X)
		 * 		 설정 파일 
		 * 		 CSS / JavaScript 파일 읽기 => 파일마다 공통 
		 * 		 ---- 내부 (파일안에서만 사용)
		 * 		 CSS 설정 
		 * 		 JavaScript 설정 
		 * 	   </head>
		 * 	   <body>
		 * 		 실제 화면에 출력하는 태그 
		 * 	   </body>
		 * 	 </html> // 문서의 끝
		 */
		out.println("<html>");
		out.println("<head>");
		// 외부 CSS
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println("<style type=text/css>");
		out.println(".container{margin-top:50px}");
		out.println(".row{margin:0px auto;width:960px}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>버튼 종류</h1>");
		// ==> 모든 태그에 적용이 가능
		out.println("<a href=# class=\"btn btn-sm btn-info\">이전</a>");
		out.println("<a href=# class=\"btn btn-sm btn-info\">다음</a>");
		out.println("<p>");
		// btn-lg btn-sm btn-xs
		// btn-danger btn-info btn-success btn-warning
		// btn-primary btn-default 
		out.println("<input type=button class=\"btn-sm btn-danger\" value=Danger>");
		out.println("<input type=button class=\"btn-sm btn-info\" value=Info>");
		out.println("<input type=button class=\"btn-sm btn-success\" value=Success>");
		out.println("<input type=button class=\"btn-sm btn-warning\" value=Warning>");
		out.println("<input type=button class=\"btn-sm btn-primary\" value=primary>");
		
		out.println("<input type=button class=\"btn-lg btn-danger\" value=Danger>");
		out.println("<input type=button class=\"btn-lg btn-info\" value=Info>");
		out.println("<input type=button class=\"btn-lg btn-success\" value=Success>");
		out.println("<input type=button class=\"btn-lg btn-warning\" value=Warning>");
		out.println("<input type=button class=\"btn-lg btn-primary\" value=primary>");
		
		out.println("<input type=button class=\"btn-xs btn-danger\" value=Danger>");
		out.println("<input type=button class=\"btn-xs btn-info\" value=Info>");
		out.println("<input type=button class=\"btn-xs btn-success\" value=Success>");
		out.println("<input type=button class=\"btn-xs btn-warning\" value=Warning>");
		out.println("<input type=button class=\"btn-xs btn-primary\" value=primary>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
