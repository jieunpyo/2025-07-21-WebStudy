<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row {
  margin: 0px auto;
  width:960px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
</script>
</head>
<body>
   <div class="container">
    <div class="row">
     <table class="table">
      <tr>
        <td width=40% class="text-center" rowspan="8">
         <table class="table">
          <tr>
           <td colspan=7>
             <img src="${vo.poster }" style="width: 420px;height: 300px"
              id="mainImg"
             >
           </td>
          </tr>
          <tr>
          </tr>
         </table>
        </td>
        <td colspan="2">
          <h3>${vo.title }&nbsp;<span style="color:orange"></span></h3>
        </td>
      </tr>
      <tr>
       <td width=10% style="color:gray">가수명</td>
       <td width=50%>${vo.singer }</td>
      </tr>
      <tr>
       <td width=10% style="color:gray">앨범명</td>
       <td width=50%>${vo.album }</td>
      </tr>
     </table>
     <table class="table">
      <tr>
        <td class="text-right">
         <a href="#" class="btn btn-xs btn-danger">좋아요</a>
         <a href="#" class="btn btn-xs btn-warning">찜하기</a>
         <a href="#" class="btn btn-xs btn-info">예약</a>
         <a href="../main/main.do?page=${curpage }" class="btn btn-xs btn-success">목록</a>
        </td>
      </tr>
     </table>
    </div>
    <div class="row text-center" style="margin-top: 10px">
     <div id="map" style="width:100%;height:350px;"></div>
    </div>
	 
    </div>
   </div>
</body>
</html>