package com.sist.dao;
// 1. XML을 읽어서 데이터를 저장 
// 경로 : src/java/main => classpath => 자동 인식  
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.FoodVO;

import java.io.*;
public class FoodDAO {
  private static SqlSessionFactory ssf; // xml
  static 
  {
	  // xml을 읽어라 
	  try
	  {
		  Reader reader=Resources.getResourceAsReader("Config.xml");
		  ssf=new SqlSessionFactoryBuilder().build(reader);
		  // XML 파싱 => 설정된 데이터를 읽는다 
	  }catch(Exception ex)
	  {
		  ex.printStackTrace();
	  }
  }
  /* 맛집 목록 */
  public static List<FoodVO> foodListData(int start)
  {
	  // 오라클 연결
	  SqlSession session=ssf.openSession();
	  // getConnection()
	  List<FoodVO> list=session.selectList("foodListData",start);
	  session.close();
	  // disConnection() // DBCP => 반환 
	  return list;
  }
  /*
   * 	<select id="foodTotalPage" resultType="int">
		    SELECT CEIL(COUNT(*)/12.0) FROM munupan_food
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
		  <update id="hitIncrement" parameterType="int" >
		    UPDATE menupan_food SET
		    hit=hit+1
		    WHERE fno=#{fno}
		  </update>
		  <select id="foodDetailData" resultType="FoodVO"
		  	 parameterType="int">
		  	 SELECT * FROM menupan_food
		  	 WHERE fno=#{fno}
		  </select>
   */
  public static FoodVO foodDetailData(int fno)
  {
	  SqlSession session=ssf.openSession(true);
	  session.update("hitIncrement",fno);// 동작하지 않는다 
	  FoodVO vo=session.selectOne("foodDetailData",fno);
	  session.close();
	  return vo;
  }
}
