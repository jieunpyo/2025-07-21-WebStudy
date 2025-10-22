<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
/*
 * 	 이벤트
 	   = onclick : 버튼 / 이미지
 	   = onmouseover : 모든 태그에 적용
 	   = onmouseout : 모든 태그에 적용
 	   = onkeydown / onkeyup
 	   = onchange : <select>
 */
window.onload=()=>{
	// 등록
	let img=document.querySelector('img')
	img.onmouseover=function(){
		img.style.opacity=0.3
	}
	img.onmouseout=function(){
		img.style.opacity=1
	}
	let btn=document.querySelector('button')
	btn.onclick=function(){
		alert("버튼 클릭")
	}
}
</script>
</head>
<body>
 <h1>고전적 이벤트 처리</h1>
 <img src="mm2.gif" width=200 height="250">
 <p>
 <button>클릭</button>
</body>
</html>