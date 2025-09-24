package com.sist.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;

@WebServlet("/BoardList")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// text/xml(XML) , text/plain(JSON)
		// 출력 => 메모리 출력 => 해당 브라우저에서 읽어 간다
		PrintWriter out=response.getWriter();
		// DAO 객체 생성 
		BoardDAO dao=BoardDAO.newInstance();
		// 사용자가 보내준 값을 받는다 => request
		// BoardList?page=2
		/*
		 * 	 BoardList => null
		 * 	 BoardList?page= ""
		 */
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		List<BoardDTO> list=dao.boardListData(curpage);
		// 총페이지 
		int totalpage=dao.boardTotalPage();
		// 전송
		out.write("<html>");
		out.write("<head>");
		out.write("<link rel=stylesheet href=\"css/table.css\">");
		out.write("<style type=text/css>");
		out.write("h1 {text-align:center}");
		out.write("table{margin:0px auto}");
		out.write("</style>");
		out.write("</head>");
		out.write("<body>");
		
		out.write("<h1>자유게시판</h1>");
		out.write("<table id=table_content width=600>");
		out.write("<tr>");
		out.write("<td>");
		out.write("<a href=\"BoardInsert\">새글</a>");
		out.write("</td>");
		out.write("</tr>");
		out.write("</table>");
		out.write("<table id=table_content width=600>");
		out.write("<tr>");
		out.write("<th width=10%>번호</th>");
		out.write("<th width=45%>제목</th>");
		out.write("<th width=15%>이름</th>");
		out.write("<th width=20%>작성일</th>");
		out.write("<th width=10%>조회수</th>");
		out.write("</tr>");
		for(BoardDTO vo:list)
		{
			out.write("<tr class=dataTr>");
			out.write("<td width=10% align=center>"+vo.getNo()+"</td>");
			out.write("<td width=45%>"+vo.getSubject()+"</td>");
			out.write("<td width=15% align=center>"+vo.getName()+"</td>");
			out.write("<td width=20% align=center>"+vo.getDbday()+"</td>");
			out.write("<td width=10% align=center>"+vo.getHit()+"</td>");
			out.write("</tr>");
		}
		
		out.write("</table>");
		
		// 페이지
		out.write("<table id=table_content width=600>");
		out.write("<tr>");
		out.write("<td align=right>");
		out.write("<a href=\"BoardList?page="+(curpage>1?curpage-1:curpage)+"\">이전</a>");
		out.write(curpage+" page / "+totalpage+" pages&nbsp;");
		out.write("<a href=\"BoardList?page="+(curpage<totalpage?curpage+1:curpage)+"\">다음</a>");
		out.write("</td>");
		out.write("</tr>");
		out.write("</table>");
		
		out.write("</body>");
		out.write("</html>");
	}

}
