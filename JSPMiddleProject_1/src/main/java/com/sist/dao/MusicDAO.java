package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.commons.*;
import com.sist.vo.*;
public class MusicDAO {
   private static SqlSessionFactory ssf;
   static
   {
	   ssf=CreateSqlSessionFactory.getSsf();
   }
   
   /*
    * 	<select id="musicListData" resultType="MusicVO" parameterType="hashmap">
		  SELECT no,title,poster,num 
	      FROM (SELECT no,title,poster,rownum as num
	      FROM (SELECT no,title,poster 
	      FROM genie_music ORDER BY no))
	      WHERE num BETWEEN #{start} AND #{end}
		</select>
    */
   public static List<MusicVO> musicListData(Map map)
   {
	   SqlSession session=ssf.openSession();
	   List<MusicVO> list=session.selectList("musicListData",map);
	   session.close();
	   return list;
   }
   
   /*
    *   <select id="musicTotalPage" resultType="int">
	      SELECT CEIL(COUNT(*)/12.0) 
	      FROM genie_music
	    </select>
    */
   public static int musicTotalPage()
   {
	   SqlSession session=ssf.openSession();
	   int total=session.selectOne("musicTotalPage");
	   session.close();
	   return total;
   }
   /*
    * <!-- 상세보기 : 조회수 증가 -->
	  <update id="hitIncrement" parameterType="int">
	   UPDATE genie_music SET
	   hit=hit+1
	   WHERE no=#{no}
	  </update>
	    <select id="musicDetailData" resultType="MusicVO" 
		  parameterType="int">
		   SELECT * FROM genie_music
		   WHERE no=#{no}
		</select>
    */
   public static MusicVO musicDetailData(int no)
   {
	   SqlSession session=ssf.openSession();
	  
	   MusicVO vo=session.selectOne("musicDetailData", no);
	   session.close();
	   return vo;
   }
}