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
  	// 해당 음식종류 찾기
	  String cno=request.getParameter("cno");
	  // DAO로 전송 
	  String page=request.getParameter("page");
	  if(page==null)
		  page="1";
	  if(cno==null)
		  cno="1";
	  
	  int curpage=Integer.parseInt(page);// 현재 페이지 
	  Map map=new HashMap();
	  int rowSize=12;
	  int start=(curpage-1)*rowSize; // OFFSET  => 0
	  								 // InlineView => 1
	  map.put("start", start);
	  map.put("cno", cno);
	  
	  // 데이터를 읽어 온다 
	  List<MusicVO> list=MusicDAO.musicTypeListData(map);
	  int totalpage=MusicDAO.musicTypeTotalPage(Integer.parseInt(cno));
	  
	  // 블록별 페이지 나누기 
	  /*
	   *   1. 현재페이지 (curpage)
	   *   	   1~10 ===> 1 유지
	   *   	   11~20 => 11 유지 
	   *   
	   *   	   ---------------
	   *   	   1~10 ==> 10유지 
	   *   	   11~20 ==> 20유지
	   */
	  final int BLOCK=10;
	  int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	  int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	  if(endPage>totalpage)
		  	endPage=totalpage;
	  // JSP에 출력할 데이터를 전송 request.setAttribute
	  // 목록 : list / 페이지:curpage/totalpage/startPage/endPage
	  request.setAttribute("list", list);//${list}
	  request.setAttribute("curpage", curpage);//${curpage}
	  request.setAttribute("totalpage", totalpage);
	  request.setAttribute("startPage", startPage);
	  request.setAttribute("endPage", endPage);
	  request.setAttribute("cno", cno);
	  request.setAttribute("main_jsp","../music/type.jsp");
	  return "../main/main.jsp";
  }

  @RequestMapping("music/find.do")
  public String music_find(HttpServletRequest request,
		  HttpServletResponse response)
  {
	  String column=request.getParameter("column");
	  String ss=request.getParameter("ss");
	  if(ss==null)
		  ss="아이유";
	  if(column==null)
		  column="singer";
	  Map map=new HashMap();
	  map.put("ss", ss);
	  map.put("column", column);
	  List<MusicVO> list=MusicDAO.musicFindListData(map);
	  request.setAttribute("list", list);
	  request.setAttribute("main_jsp","../music/find.jsp");
	  return "../main/main.jsp";
  }
}