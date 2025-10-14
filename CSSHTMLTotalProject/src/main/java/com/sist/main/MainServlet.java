package com.sist.main;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 연결 => 자바 => 브라우저 (어떤형식 => 전송)
		// text/html text/xml text/plain 
		response.setContentType("text/html;charset=UTF-8");
		// HTML이 있는 메모리 주소를 확인 
		PrintWriter out=response.getWriter();
		// out 메모리 => 저장 => 브라우저에서 읽기 한다 
		// TCP => 소켓 => 데이터 통로를 이용해서 보낸다 
		// 1. 사용자가 보내준 데이터 읽기  
		/*
		 * 	 String getParameter() : 단일값
		 * 	 String[] getParameterValues() : 다중값
		 * 			  -------------------- checkbox
		 * 	 ?page=1
		 * <div class="card-grid">
    <div class="card">
      <img src="https://recipe1.ezmember.co.kr/cache/recipe/2025/09/29/ba02b75b59fb9ba7c348242ae790b2931_m.jpg">
      <div class="card-content">
       <h3>자색양파피클(ft.고기랑)</h3>
       <p>자색양파 1망 사왔어요. 보기에도 어여쁜 식재료, 무엇을 만들까요</p>
      </div>
    </div>
		 */
		 String page=request.getParameter("page");
		 if(page==null)
			 page="1";
		 int curpage=Integer.parseInt(page);
		 int start=(curpage*12)-12;
		 List<FoodVO> list=FoodDAO.foodListData(start);
		 int totalpage=FoodDAO.foodTotalPage();
		 out.println("<html>");
		 out.println("<head>");
		 out.println("<link rel=stylesheet href=\"css/image.css\">");
		 out.println("<style type=text/css>");
		 out.println(".pagnation{text-align:center}");
		 out.println("a {text-decoration:none;color:black}");
		 out.println("a:hover{text-decoration:underline;color:green}");
		 out.println("</style>");
		 out.println("</head>");
		 out.println("<body>");
		 out.println("<div class=\"card-grid\">");
		 /*
		  *  http://localhost/CSSHTMLTotalProject/FoodDetail?fno=1
		  * 												 ----- tomcat => request
		  *  ----------------------------------------------- URL
		  * 				 ------------------------------- URI
		  *  -----------------
		  * 	서버 정보 : 프로토콜 / IP / PORT => 80
		  */
		 for(FoodVO vo:list)
		 {
			 out.println("<a href=FoodDetail?fno="+vo.getFno()+">");
			 out.println("<div class=\"card\">");
			 out.println("<img src="+vo.getPoster()+">");
			 out.println("<div class=\"card-content\">");
			 out.println("<h3>"+vo.getName()+"</h3>");
			 out.println("<p>"+vo.getType()+"</p>");
			 out.println("</div>");
			 out.println("</div>");
			 out.println("</a>");
		 }
		 out.println("</div>");
		 out.println("<div style=\"height:30px\"></div>");
		 out.println("<div class=pagnation>");
		 out.println("<a href=MainServlet?page="+(curpage>1?curpage-1:curpage)+">이전</a>");
		 out.println(curpage+" page / "+totalpage+" pages");
		 out.println("<a href=MainServlet?page="+(curpage<totalpage?curpage+1:curpage)+">다음</a>");
		 out.println("</div>");
		 out.println("</body>");
		 out.println("</html>");
		 
	}

}
