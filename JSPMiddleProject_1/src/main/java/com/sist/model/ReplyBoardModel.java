package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.*;
import com.sist.vo.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.sist.dao.*;
@Controller
public class ReplyBoardModel {
  @RequestMapping("board/list.do")
  public String board_list(HttpServletRequest request,
		  HttpServletResponse response)
  {
	  String page=request.getParameter("page");
	  // HttpServletRequest는 사용하지 않는다 
	  // 스프링 board_list(int page)
	  // 스프링 board_insert(BoardVO vo)
	  if(page==null)
		  page="1";
	  int curpage=Integer.parseInt(page);
	  List<ReplyBoardVO> list=
			  ReplyBoardDAO.boardListData((curpage-1)*10);
	  int count=ReplyBoardDAO.boardTotalPage();
	  int totalpage=(int)(Math.ceil(count/10.0));
	  count=count-((curpage*10)-10);
	  request.setAttribute("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	  request.setAttribute("count", count);
	  request.setAttribute("list", list);
	  request.setAttribute("curpage", curpage);
	  request.setAttribute("totalpage", totalpage);
	  request.setAttribute("main_jsp", "../replyboard/list.jsp");
	  return "../main/main.jsp";
  }
}
