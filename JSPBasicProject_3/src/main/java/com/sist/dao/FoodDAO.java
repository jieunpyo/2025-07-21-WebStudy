package com.sist.dao;
import java.io.*;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.FoodVO;
public class FoodDAO {
  private static SqlSessionFactory ssf;
  static
  {
	  // XML 파싱
	  try
	  {
		  //1.xml 읽기
		  Reader reader=Resources.getResourceAsReader("Config.xml");
		  //src/main/java => classpath => 자동으로 인식 
		  //2. 파싱 (등록된 데이터 읽기)
		  ssf=new SqlSessionFactoryBuilder().build(reader);
		  // map에 저장 => id SQL => id(key) SQL문장(value)
		  /*
		   *   <select id="foodTotalPage" resultType="int" 
				  parameterType="string">
				   SELECT CEIL(COUNT(*)/20.0) 
				   FROM menupan_food
				   WHERE type LIKE '%'||#{type}||'%'
				 </select>
				 
				 태그의 id가 중복되면 안된다
		   */
	  }catch(Exception ex)
	  {
		  ex.printStackTrace();
	  }
  }
  // 기능
  // 1. 목록
  /*
   * 	 <select id="foodListData" resultType="FoodVO" 
		 parameterType="hashmap">
		   SELECT /*+ INDEX_ASC(menupan_food menuf_fno_pk) fno,poster,name,address,type
		   FROM menupan_food
		   WHERE type LIKE '%'||#{type}||'%'
		   OFFSET #{start} ROWS FETCH NEXT 20 ROWS ONLY;
		 </select>
   */
   public static List<FoodVO> foodListData(Map map)
   {
	   SqlSession session=ssf.openSession(); //getConnection()
	   List<FoodVO> list=session.selectList("foodListData",map);
	   session.close();
	   return list;
   }
   /*
    * 	  <select id="foodTotalPage" resultType="int" 
		  parameterType="string">
		   SELECT CEIL(COUNT(*)/20.0) 
		   FROM menupan_food
		   WHERE type LIKE '%'||#{type}||'%'
		 </select>
    */
   public static int foodTotalPage(String type)
   {
	   SqlSession session=ssf.openSession();
	   int total=session.selectOne("foodTotalPage",type);
	   session.close();
	   return total;
   }
   /*
    * 	 <select id="foodDetailData" resultType="FoodVO"
		   parameterType="int"
		   >
		    SELECT * FROM menupan_food
		    WHERE fno=#{fno}
		   </select>
    */
   public static FoodVO foodDetailData(int fno)
   {
	   SqlSession session=ssf.openSession();
	   FoodVO vo=session.selectOne("foodDetailData",fno);
	   session.close();
	   return vo;
   }
}
