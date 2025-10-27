package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.commons.*;
import com.sist.vo.*;
public class FoodDAO {
   private static SqlSessionFactory ssf;
   static
   {
	   ssf=CreateSqlSessionFactory.getSsf();
   }
   
   /*
    *   <select id="foodListData" resultType="FoodVO" 
    *     parameterType="hashmap">
    *   SELECT fno,name,poster,num 
	    FROM (SELECT fno,name,poster,rownum as num
	    FROM (SELECT fno,name,poster 
	    FROM menupan_food ORDER BY fno))
	    WHERE num BETWEEN #{start} AND #{end}
	    
	    id = 메소드명 
    */
   public static List<FoodVO> foodListData(Map map)
   {
	   SqlSession session=ssf.openSession();
	   List<FoodVO> list=session.selectList("foodListData",map);
	   session.close();
	   return list;
   }
   
   /*
    *   <select id="foodTotalPage" resultType="int">
         SELECT CEIL(COUNT(*)/12.0) 
         FROM menupan_food
        </select>
    */
   public static int foodTotalPage()
   {
	   SqlSession session=ssf.openSession();
	   int total=session.selectOne("foodTotalPage");
	   session.close();
	   return total;
   }
   /*
    *   <!-- 상세보기 : 조회수 증가 -->
		  <update id="hitIncrement" parameterType="int">
		   UPDATE menupan_food SET
		   hit=hit+1
		   WHERE fno=#{fno}
		  </update>
		  <select id="foodDetailData" resultType="FoodVO" 
		  parameterType="int">
		   SELECT * FROM menupan_food
		   WHERE fno=#{fno}
		  </select>
		  
		  JSP => 요청 (form / a)
		   |
		  Mapper 
		   | 
		  DAO 
		   |
		  Model =====> JSP에서 출력 
    */
   public static FoodVO foodDetailData(int fno)
   {
	   SqlSession session=ssf.openSession();
	   session.update("hitIncrement",fno);
	   session.commit();
	   FoodVO vo=session.selectOne("foodDetailData", fno);
	   session.close();
	   return vo;
   }
}