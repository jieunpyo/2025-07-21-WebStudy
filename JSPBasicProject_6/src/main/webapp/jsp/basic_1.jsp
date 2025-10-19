<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
      JSP의 내장 객체
      = request : 클라이언트의 요청 정보 
      = response : 브라우저로 전송할 응답정보 / 화면 이동 
      = pageContext : 웹 흐름 제어 
                      include / forward 
                                | request를 유지하면서 화면 유지
                                | MVC구조에서 주로 사용 
      = out 
        JspWriter 
        출력메모리 관리 (출력버퍼)
        주요 메소드 
        ========
        out.println() = <%= %>
        out.getBufferSize() : 총버퍼 크기 => 8kb
        out.getRemaining() : 남아 있는 버퍼 
        출력 : HTML이 출력을 다하지 않는다 
              buffer를 증가 
              <%@ page buffer="16kb" autoFlush="true"%>
        => 버퍼를 지운다 : flush() => auto
        => 화면 이동 / 새로 고침 => 버퍼를 비운후 다시 HTML을 채운다
                                초기화가 된다 
      = application : 서버 관리 => getRealPath()
      = config : web.xml 
      = page : this 
      = exception : try~catch => 자바/HTML분리 
                                  |    |
                                Model  View  => MV
                                 |      |
                                 --------
                                     |
                                   연결 : Controller
      = session / cookie 
      ----------------------- 기본 
        HTTP의 기본 stateless : 무상태 (데이터)
                              ----- 상태 유지
              |
             저장 => 클라이언트(브라우저) : cookie 
                    => 단점 : 데이터 노출 (보안) 
                       = 최근 방문 / 자동 로그인 / 장바구니 
                       = 문자열로만 저장이 가능 
                       = 4kb
                       = 공유 
                 => 서버에 저장  : session
                    => 장점 : 서버에서 관리 => 보안 
                       Object 단위로 저장이 가능 (ArrayList)
                    => 단점 : 접속자마다 따로 저장 (공유(X))
                    => 로그인시 => 사용자 정보 저장 
           상태 : 무조건 데이터 관리 
           | 모든 프로그램은 데이터 관리 : Spring / Vue / React
         ---------------------------------------
                      쿠키           세션 
         ---------------------------------------
         저장위치      클라이언트        서버 
         저장형태      문자열          서버메모리 (객체단위)
         보안성        낮다            높다 
                                    브라우저 종료 / 로그아웃 => 소멸
         지속시간      브라우저 종류후에도 유지 
                     설정이 가능 setMaxAge(60*60*24)
         속도         빠름(클라이언트)   다소 늦다 (서버 접근 필요)
         주요 용도     사용자 편의       사용자 인증 / 상태 관리
         
         -----------------------------------------------
         1. HTTP 기본 (요청 == 응답 => 연결 종료)
            | 필요한 데이터 저장할 수 있는 기억장치가 필요 
            | cookie / session => 면접 단골 
                |        |
                        접속한 서버에 저장 
               본인 컴퓨터에 저장  
               ** 세션이 보안이 더 강하다 (로그인 정보 관리) 
               ** 쿠키는 장바구니/최신방문 : 단순 상태 유지
                    
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 출력버퍼 크기:<%= out.getBufferSize() %><br>
 남아 있는 버퍼:<%= out.getRemaining() %><br>
 현재 사용중인 버퍼: 
      <% 
          int size=out.getBufferSize()-out.getRemaining();
    	  out.println(size);
      %>
</body>
</html>