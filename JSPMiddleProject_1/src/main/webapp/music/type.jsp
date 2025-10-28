<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row {
  margin: 0px auto;
  width: 960px;
}
p {
   overflow: hidden;
   white-space: nowrap;
   text-overflow: ellipsis;
}
</style>
</head>
<body>
  <div class="container">
   <div class="row text-center">
    <a href="../music/type.do?cno=1" class="btn btn-sm btn-danger">TOP100</a>
    <a href="../music/type.do?cno=2" class="btn btn-sm btn-success">POP</a>
    <a href="../music/type.do?cno=3" class="btn btn-sm btn-primary">POP</a>
    <a href="../music/type.do?cno=4" class="btn btn-sm btn-warning">OST</a>
    <a href="../music/type.do?cno=5" class="btn btn-sm btn-info">트롯</a>
    <a href="../music/type.do?cno=6" class="btn btn-sm btn-danger">JAZZ</a>
    <a href="../music/type.do?cno=7" class="btn btn-sm btn-success">CLASSIC</a>
   </div>
   <div style="height: 20px"></div>
   <div class="row">
   <%--
      for(MusicVO vo:list)
      {
   --%>
    <c:forEach var="vo" items="${list }">
      <div class="col-md-3">
	    <div class="thumbnail">
	      <a href="../music/detail.do?fno=${vo.no }&page=${curpage}">
	        <img src="${vo.poster }" style="width:230px;height: 150px">
	        <div class="caption">
	          <p>${vo.title }</p>
	        </div>
	      </a>
	    </div>
	  </div>
	</c:forEach>
   </div>
   <div class="row text-center" style="margin-top: 10px">
     <ul class="pagination">
      <%--
        if(startPage>1)
        {
        
       --%>
      <c:if test="${startPage>1 }">
        <li><a href="../music/type.do?page=${startPage-1 }&cno=${cno}">&lt;</a></li>
      </c:if>
      <%--
        for(int i=startPage;i<=endPage;i++)
      --%>
      <c:forEach var="i" begin="${startPage }" end="${endPage }">
       <li ${i==curpage?"class=active":""}><a href="../music/type.do?page=${i }&cno=${cno}">${i }</a></li>
      </c:forEach>
      <%--
        if(endPage<totalpage)
       --%>
      <c:if test="${endPage<totalpage }">
       <li><a href="../music/type.do?page=${endPage+1 }&cno=${cno}">&gt;</a></li>
      </c:if>
     </ul>
   </div>
  </div>
</body>
</html>