package com.kit.test.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.test.comm.SearchVO;

@Service
public class boardService {

	@Autowired
	private SqlSessionTemplate sqlSession;	
		
    public Integer selectBoardCount(SearchVO param) throws Exception {
    	int resInt=0;
    	if (sqlSession.selectOne("selectBoardCount", param) != null) {
    		resInt = sqlSession.selectOne("selectBoardCount", param);
    	}
		return resInt;
    }
    public List<?> selectBoardList(SearchVO param) throws Exception { 
		return sqlSession.selectList("selectBoardList", param);
    }
    
    public void insertBoard(boardVO param) throws Exception {
    	if (param.getBrdno()==null || "".equals(param.getBrdno()))
    		 sqlSession.insert("insertBoard", param);
    	else sqlSession.update("updateBoard", param);
    }
 
    public boardVO selectBoardOne(String param) throws Exception {
		return sqlSession.selectOne("selectBoardOne", param);
    }
    
    public void updateBoardRead(String param) throws Exception {
		sqlSession.insert("updateBoardRead", param);
    }
    
    public void deleteBoardOne(String param) throws Exception {
		sqlSession.delete("deleteBoardOne", param);
    }
    
}
