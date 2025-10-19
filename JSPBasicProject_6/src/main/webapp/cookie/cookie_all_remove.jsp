<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	 Cookie : 생성후 사용
	 => 내장 객체는 서블릿 변환후 바로 생성된 객체 
	 Cookie사용 (저장)
	 1. 생성
	 	Cookie cook=new Cookie(키 , 값)
	 						  -------- String : 문자열만 저장이 가능
	 						  => 최대 저장 : 4kb
	 2. 기간 설정 
	 	cook.setMaxAge(1/1000) => 하루 : 60*60*24
	 3. 서버에서 브라우저로 전송 
	 	response.addCookie(cook)
	 Cookie읽기
	 1. 쿠키 전체 읽기
	 	Cookie[] cookies=request.getCookies()
	 2. 제어
	 	키 읽기 : cookie[0].getName()
	 	값 읽기 : cookie[0].getValue()
	 	삭제 : cookie[0].setMaxAge(0) 
	 		  => response.addCookie(cookie[0])
	 => 사용처 : 최근 방문 / 장바구니 
	 	보안 => ID관련 사용자 관련 => 세션 
 --%>
<%
	Cookie[] cookies=request.getCookies();
	if(cookies!=null)
	{
		for(int i=0;i<cookies.length;i++)
		{
			if(cookies[i].getName().startsWith("food_"))
			{
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
		}
	}
	response.sendRedirect("food_list.jsp");
%>