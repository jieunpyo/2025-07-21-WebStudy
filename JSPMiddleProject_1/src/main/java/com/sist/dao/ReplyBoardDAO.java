package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.*;
import com.sist.commons.*;
public class ReplyBoardDAO {
   private static SqlSessionFactory ssf;
   static
   {
	   ssf=CreateSqlSessionFactory.getSsf();
   }
   /*
    * 	<select id="boardListData" resultType="ReplyBoardVO"
   parameterType="int"
  >
  	<!-- 
  			group_tab : 간격조절 
  			  AAAAA
  			  	=> BBBBB 1
  			  	  => CCCCC 2
  			group_id : 답변을 모아둔것 
  			  AAAAA 1
  			  	=> BBBBB 1
  			  	  => CCCCCC 1
  			  	=> DDDD 1
  			  EEEE 2
  			   => KKKK 2
  			group_step
  			  AAAAA 0
  			  	=> BBBBB 1
  			  	  => CCCCCC 2
  			  	=> DDDD 3
  			  	
  			AAAAAA			  1	 0
  			  
  			  => BBBBBB		  1	 2
  			  
  			  	=> CCCCCCC	  1	 2
  			  => DDDDDD		  1	 3
  			  
  			  	
  	 -->
    SELECT no,subject,name,
    	   TO_CHAR(regdate,'YYYY-MM-DD') as dbday,
    	   hit,group_tab
    FROM replyboard
    ORDER BY group_id DESC,group_step ASC
    OFFSET #{start} ROWS NEXT 10 ROWS ONLY 
    
  </select>
  <select id="boardTotalPage" resultType="int">
   SELECT CEIL(COUNT(*)/10.0)
   FROM replyboard
  </select>
    */
   public static List<ReplyBoardVO> boardListData(int start)
   {
	   SqlSession session=ssf.openSession(); // 오라클 연결 
	   List<ReplyBoardVO> list=session.selectList("boardListData",start);
	   session.close(); // 오라클 종료 
	   return list;
   }
   
   public static int boardTotalPage()
   {
	   SqlSession session=ssf.openSession(); // 오라클 연결 
	   int total=session.selectOne("boardTotalPage");
	   session.close(); // 오라클 종료 
	   return total;
   }
}
