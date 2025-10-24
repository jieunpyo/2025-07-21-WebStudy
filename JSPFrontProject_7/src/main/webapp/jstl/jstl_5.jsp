<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%--
	변수 선언 : <c:set>
			  var : 변수명
			  value : 값설정
			  => request.setAttributo() => 변경
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h2>자바</h2>
  <%
  	 int sum=0;
  	 for(int i=1;i<=10;i++)
  	 {
  		 sum+=i;
  	 }
  %>
  <%= "1~10까지의 총합:"+sum %>
  <h2>JSTL</h2>
  <c:set var="sum" value="0"/>
  <c:forEach var="i" begin="1" end="10">
    <c:set var="sum" value="${sum+i }"/>
  </c:forEach>
  1~10까지의 총합:${sum}
  <%--
    JSTL => XML 형식 
    쌍으로 만든다 : 여는 태그/닫는 태그가 동일 
    			----------------
    			<> </> 
    			=> 단독태그 <태그/>
    			   <c:set />
    			=> 태그가 완성 (표준화)
    반드시 속성값에는 ""
    대소문 구분 (태그 , 속성)
    사용자정의 태그/속성은 사용이 불가능 
    import => <%@ taglib ~>
    					 시작태그 => prefix="c"
    					 		  ----------- 사용자 지정
    					 uri="jakarta.tags.core"
    					 uri="jakarta.tags.format"
    					 uri="jakarta.tags.functions"
 	-------------------------------------------------- tomcat 10이상
    uri="http://java.sun.com/jsp/jstl/core
    uri="http://java.sun.com/jsp/jstl/format"
    uri="http://java.sun.com/jsp/jstl/functions"
   --%>
</body>
</html>