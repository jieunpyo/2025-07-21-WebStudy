package com.sist.controller;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
/*
 *   어노테이션 : Spring (XML+어노테이션) 
 *       1) 정의 : 자바코드의 부가정보 표시 
 *                => 구분자 (인덱스) 
 *                => if 추가하는 기능 
 *       2) 사용 
 *          ==> 클래스 구분 
 *          @class구분 =====> TYPE
 *          class A
 *          {
 *              @field ===> FIELD
 *              B b;
 *              @constructor ==== 생성자 CONSTRUCTOR
 *              public A(@parameter B b){} PARAMETER
 *              @method ==> METHOD
 *              public void display(){}
 *          }
 *          ---------------------------------------
 *          @Target :  구분자 
 *             = 생성자 / 멤버변수 / 클래스 / 매개변수 / 메소드
 *                                                | METHOD 
 *                                      | PARAMETER
 *                               | TYPE
 *                      | FIELD
 *               |CONSTURCTOR 
 *          @Retention : 유지 정책 
 *             = SOURCE : 소스코드에만 남아 있다 
 *                        컴파일시에 사라진다 
 *                        @Override
 *             = CLASS : 컴파일시에는 틀래스 파일에 남아 있다 
 *                       실행시에 제거
 *             = RUNTIME : 프로그램 종료시까지 남아 있다 
 *       => 어노테이션 이용 
 *          : 바로 밑에 있는 자원을 찾는다 
 *          
 *          @
 *          public void a()
 *          @
 *          public void b()
 *          
 *          
 *          ---------------------------
 *          한개의 기능 ==> 클래스 
 *          ------------------
 *          관련된 기능 ==> 클래스 : 메소드
 *            | 응집성   
 *          ------------------
 *          => 인터페이스 / 상속 => 처리가 가능 
 *             ------------- POJO
 *             
 *       => 메소드 
 *          void  ===> JSON
 *          String ===> 파일 (이동)
 *          ---------------------
 *          
 *          return "../main/main.jsp" => forward 
 *          return "redirect:main.do" => sendRedirect
 *          
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface Controller {
  
}