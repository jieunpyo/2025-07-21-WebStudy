package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Controller
public class FoodModel {
  @RequestMapping("food/detail.do")
  public String food_detail(HttpServletRequest request,
		  HttpServletResponse response)
  {
	  // 사용자가 보낸 데이터 받기  ?fno &page
	  String fno=request.getParameter("fno");
	  String curpage=request.getParameter("page");
	  // 상세보기 데이터 
	  FoodVO vo=FoodDAO.foodDetailData(Integer.parseInt(fno));
	  
	  request.setAttribute("curpage", curpage);
	  request.setAttribute("vo", vo);
	  
	  request.setAttribute("main_jsp", "../food/detail.jsp");
	  return "../main/main.jsp";
  }
  @RequestMapping("food/type.do")
  public String food_type(HttpServletRequest request,
		  HttpServletResponse response)
  {
	  
	  request.setAttribute("main_jsp","../food/type.jsp");
	  return "../main/main.jsp";
  }
  @RequestMapping("food/find.do")
  public String food_find(HttpServletRequest request,
		  HttpServletResponse response)
  {
	  
	  request.setAttribute("main_jsp","../food/find.jsp");
	  return "../main/main.jsp";
  }
}