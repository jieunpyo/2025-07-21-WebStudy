package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Controller
public class MusicModel {
  @RequestMapping("music/detail.do")
  public String music_detail(HttpServletRequest request,
		  HttpServletResponse response)
  {
	  // 사용자가 보낸 데이터 받기  ?no &page
	  String no=request.getParameter("no");
	  String curpage=request.getParameter("page");
	  // 상세보기 데이터 
	  MusicVO vo=MusicDAO.musicDetailData(Integer.parseInt(no));
	  
	  request.setAttribute("curpage", curpage);
	  request.setAttribute("vo", vo);
	  
	  request.setAttribute("main_jsp", "../music/detail.jsp");
	  return "../main/main.jsp";
  }
  @RequestMapping("music/list.do")
  public String music_list(HttpServletRequest request,
		  HttpServletResponse response)
  {
		  //1.사용자가 요청한 데이터 받기 
		  String page=request.getParameter("page");
		  if(page==null)
			  page="1";
		  int curpage=Integer.parseInt(page);
		  Map map=new HashMap();
		  int rowSize=12;
		  int start=(rowSize*curpage)-(rowSize-1);
		  int end=rowSize*curpage;
		  map.put("start", start);
		  map.put("end", end);
		  List<MusicVO> list=MusicDAO.musicListData(map);
		  int totalpage=MusicDAO.musicTotalPage();
		  
		  // 블록별 처리 
		  final int BLOCK=10;
		  int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		  int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		  
		  if(endPage>totalpage)
		  {
			  endPage=totalpage;
		  }
		  
		  // 데이터 전송 
		  request.setAttribute("list", list);//${list}
		  request.setAttribute("curpage", curpage);//${curpage}
		  request.setAttribute("totalpage", totalpage);
		  request.setAttribute("startPage", startPage);
		  request.setAttribute("endPage", endPage);
		  //include => 설정파일 
	  request.setAttribute("main_jsp","../music/list.jsp");
	  return "../main/main.jsp";
  }
  @RequestMapping("music/type.do")
  public String music_type(HttpServletRequest request,
		  HttpServletResponse response)
  {
	  
	  request.setAttribute("main_jsp","../music/type.jsp");
	  return "../main/main.jsp";
  }
  @RequestMapping("music/find.do")
  public String music_find(HttpServletRequest request,
		  HttpServletResponse response)
  {
	  
	  request.setAttribute("main_jsp","../music/find.jsp");
	  return "../main/main.jsp";
  }
}