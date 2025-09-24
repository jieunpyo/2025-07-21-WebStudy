package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sist.vo.BoardDTO;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	// 변경 사항이 없다 
	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	/*
	 * 	   jdbc:업체명:@IP:port:데이터베이스명 
	 * 	   jdbc:mysql:@localhost:3306:mydb
	 * 
	 */
	// 각 user당 1개의 DAO를 사용이 가능 => 싱글턴 
	public static BoardDAO dao;
	
	// 드라이버 등록 
	public BoardDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ojdbc11 => oracle.jdbc.OracleDriver
		}catch(Exception ex) {}
	}
	// 싱글턴 => Spring :  등록한 모든 클래스 (싱글턴) 
	public static BoardDAO newInstance()
	{
		if(dao==null)
			dao=new BoardDAO();
		return dao;
	}
	
	// 연결
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex) {}
	}
	// 해제
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close(); // 송수신 
			if(conn!=null) conn.close(); // 전화 
		}catch(Exception ex) {}
	}
	
	// 기능
	// 목록 => 페이징
	public List<BoardDTO> boardListData(int page)
	{
		List<BoardDTO> list=new ArrayList<BoardDTO>();
		try
		{
			// 1. 연결 
			getConnection();
			// 2. SQL문장
			String sql="SELECT no,subject,name,TO_CHAR(regdate,'yyyy-mm-dd'),hit "
					  +"FROM web_board "
					  +"ORDER BY no DESC "
					  +"OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";
					  // LIMIT 1,10
			int rowSize=10;
			int start=(rowSize*page)-rowSize;
			ps=conn.prepareStatement(sql);
			ps.setInt(1, start);
			// 결과값 
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				BoardDTO vo=new BoardDTO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setDbday(rs.getString(4));
				vo.setHit(rs.getInt(5));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return list;
	}
	// 총페이지
	public int boardTotalPage()
	{
		int total=0;
		try
		{
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/10.0) "
					  +"FROM web_board";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return total;
	}
	// 새글 => INSERT
	// 상세보기 => 조회수 증가
	// 수정 => hidden 비밀번호 검색 
	// 삭제 => hidden
	// 검색 => 이름 / 제목 / 내용 
}
