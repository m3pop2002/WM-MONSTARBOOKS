package com.monstar.books.mypage.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.monstar.books.mypage.dao.MyProfileDao;

@Service
public class MyProfileDeleteService implements MyPageService {
	@Autowired
	private SqlSession sqlSession;
	
	public MyProfileDeleteService(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	//230828 [효슬] 마이페이지 프로필이미지 삭제 서비스 기능
	@Override
	public void execute(Model model) {
		System.out.println(">>>MyProfileDeleteService");

//		map변환
		Map<String, Object> map=model.asMap();
//		map에서 request추출
		HttpServletRequest request=
				(HttpServletRequest) map.get("request");

//      로그인 사용자 ID 세션에서 받아오기
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("id");
		System.out.println("id받아줘 :" + mid);
		//로그인프로세스 서비스 참조
//		httpSession.setAttribute("id", dto.getMid());
		
		
		MyProfileDao dao=sqlSession.getMapper(MyProfileDao.class);
		
//		String mid = request.getParameter("mid");

		dao.delete(mid);
			
	
	}// execute method
		
}// class 종료

