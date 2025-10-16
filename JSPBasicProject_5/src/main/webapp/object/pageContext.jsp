<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	   1. 내장객체 얻기 
	   	  request : getRequest()
	   	  response : getResponse()
	   	  			 getOut() , getSession()
	   	  			 getException() getPage()
	   	  	request.getParameter()
	   	  	pageContext.getRequest().getParamter()
	   2. 웹 흐름 제어 
	   	  => 화면을 이동 / 다른 JSP포함 
	   	  	 --------	-----------
	   	  	 forward()	 include()
	   	  	 	|			|
	   	  	 	-------------
	   	  	 		  |
	   	  	 	   request 공유
	   	  	 => JSP액션 태그
	   	  	 <jsp:forward> <jsp:include>
	   3. 클래스 : PageContext
	   
	   = <%@ include file="a.jsp"%> => 정적
	   = pageContext.include("a.jsp"); =>동적
	   
	   a.jsp
	    <%
	       int a=100;
	    %>
	    <html>
	    <body>
	      <h1><%=a%></h1>
	      <%include file="b.jsp"%>
	      <%
	      	  pageContext.include("b.jsp")
	      %>
	    </body>
	    </html>
	    
	  b.jsp
	  	<%
	  		int a=1000;
	  	%>
	  	<html>
	  	<body>
	  	  <h1><%=a%></h1>
	  	</body>
	  	</html>
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>