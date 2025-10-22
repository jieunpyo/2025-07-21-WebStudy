package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.commons.*;
import com.sist.vo.*;
public class MemberDAO {
  private static SqlSessionFactory ssf;
  static
  {
	  ssf=CreateSqlSessionFactory.getSsf();
  }
  /*
   *   <!-- ID 체크 -->
		  <select id="memberIdCount" resultType="int" parameterType="string">
		    SELECT COUNT(*) FROM member
		    WHERE id=#{id}
		  </select>
		  <!-- 비밀번호 체크 -->
		  <select id="memberGetPassword" resultType="MemberVO" 
		   parameterType="string">
		   SELECT id,pwd,name
		   FROM member
		   WHERE id=#{id}
		  </select>
   */
  public static MemberVO memberLogin(String id,String pwd)
  {
	  MemberVO vo=new MemberVO();
	  SqlSession session=ssf.openSession();
	  // id 존재 여부 확인 
	  int count=session.selectOne("memberIdCount",id);
	  if(count==0)
	  {
		  vo.setMsg("NOID");
	  }
	  else
	  {
		  MemberVO dbVO=session.selectOne("memberGetPassword",id);
		  if(pwd.equals(dbVO.getPwd()))
		  {
			  // 로그인 
			  vo.setMsg("OK");
			  vo.setId(dbVO.getId());
			  vo.setName(dbVO.getName());
			  // session => id,name
		  }
		  else
		  {
			 // 비밀번호가 틀리다 
			  vo.setMsg("NOPWD");
		  }
	  }
	  session.close();
	  return vo;
  }
}