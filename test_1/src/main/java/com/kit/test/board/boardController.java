package com.kit.test.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kit.test.comm.SearchVO;

@Controller
public class boardController {

    @Autowired
    private boardService boardSvc;
    
    // 리스트
    @RequestMapping(value = "/boardList")
   	public String boardList(SearchVO searchVO, ModelMap modelMap) throws Exception {

    	searchVO.pageCalculate( boardSvc.selectBoardCount(searchVO) ); 

    	List<?> listview   = boardSvc.selectBoardList(searchVO);
        
    	modelMap.addAttribute("listview", listview);
		modelMap.addAttribute("searchVO", searchVO);
        return "board/boardList";
    }
    
    // 글 쓰기 
    @RequestMapping(value = "/boardForm")
   	public String boardForm(HttpServletRequest request, ModelMap modelMap) throws Exception {
    	String brdno = request.getParameter("brdno");
    	if (brdno!=null) {
    		boardVO boardInfo = boardSvc.selectBoardOne(brdno);
        
    		modelMap.addAttribute("boardInfo", boardInfo);
    	}
    	
        return "board/boardForm";
    }
    
    @RequestMapping(value = "/boardSave")
   	public String boardSave(boardVO boardInfo) throws Exception {
    	
  		boardSvc.insertBoard(boardInfo);

        return "redirect:/boardList";
    }

    // 글 읽기
    @RequestMapping(value = "/boardRead")
   	public String boardSave(HttpServletRequest request, ModelMap modelMap) throws Exception {
    	
    	String brdno = request.getParameter("brdno");
    	
    	
    	boardSvc.updateBoardRead(brdno);
    	boardVO boardInfo = boardSvc.selectBoardOne(brdno);
        
    	modelMap.addAttribute("boardInfo", boardInfo);
    	
        return "board/boardRead";
    }
    
    // 글 삭제
    @RequestMapping(value = "/boardDelete")
   	public String boardDelete(HttpServletRequest request) throws Exception {
    	
    	String brdno = request.getParameter("brdno");
    	
    	boardSvc.deleteBoardOne(brdno);
        
        return "redirect:/boardList";
    }

}
