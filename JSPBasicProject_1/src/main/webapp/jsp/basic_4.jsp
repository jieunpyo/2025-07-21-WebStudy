<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
   113page JSP 기초
   ---------------- HTML + Java => 구분 
   1. 주석 
   2. 스크립트릿 : <% %> => 일반 자바 (main)
   				<%
   					자바 문법을 적용 => 문장 종료하면 ;을 사용한다 
   					주석 
   					  //
   					  /*
   					  */
   					  
   				%>
   3. 표현식 : <%= %> => 데이터 출력 => out.println()
   			  out.println(안에 출력할 내용)
   4. 선언식 : <%! %> => 메소드,전역변수 설정 => 사용빈도가 거의 없다 
   			 <%!
   			 	int a=100;
   			 	int add()
   			 	{
   			 	}
   			 %>
   	=> 브라우저에서 java는 일반 문자열이다 
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="table.css">
<style type="text/css">
.table {
  margin: 0px auto;
}
</style>
</head>
<body>
  <h1>스크립트릿 사용법 &lt;% %&gt;</h1>
  <table class="table" width="800">
   <thead>
   	 <tr>
   	  <%
   	  	 for(int i=2;i<=9;i++)
   	  	 {
   	  %>
   	   		<th><%=i+"단" %></th>
   	  <%
   	  	 }
   	  %>
   </thead>
   <tbody>
   	  <%
   	  	 for(int i=1;i<=9;i++)
   	  	 {
   	  %>
   	  		 <tr>
   	  <%
   	  		 for(int j=2;j<=9;j++)
   	  		 {
   	  %>
   	  			  <td align=center>
   	  			   <%= j+"*"+i+"="+j*i %>
   	  			  </td>
   	  <%
   	  		 }
   	  %>
   	  		</tr>
   	  <%
   	  	 }
   	  %>
   </tbody>
  </table>
</body>
</html>








