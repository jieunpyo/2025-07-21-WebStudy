package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
/*
 *   2 => ibatis => opensource 
 *   3 => mybatis => google에 인수 
 */
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import com.sist.vo.*;
public class EmpDAO {
   private static SqlSessionFactory ssf;
   static
   {
	   // XML에 등록된 데이터 읽기 => XML(파싱)
	   try
	   {
		   Reader reader=Resources.getResourceAsReader("Config.xml");
		   ssf=new SqlSessionFactoryBuilder().build(reader);
	   }catch(Exception ex) {}
   }
   // 기능 설정 
   public static List<EmpVO> empListData()
   {
	   SqlSession session=ssf.openSession();// getConnection()
	   List<EmpVO> list=session.selectList("empListData");
	   session.close();// 반환 => disConnection()
	   return list;
   }
   //			 resultType			 parameterType
   public static EmpVO empDetailData(int empno)
   {
	   SqlSession session=ssf.openSession();// getConnection()
	   EmpVO vo=session.selectOne("empDetailData",empno);
	   session.close();// 반환 => disConnection()
	   return vo;
   }
}