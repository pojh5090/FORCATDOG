package com.kh.forcatdog.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.forcatdog.board.model.dao.BoardDAO;
import com.kh.forcatdog.board.model.vo.Board;
import com.kh.forcatdog.board.model.vo.Comment;
import com.kh.forcatdog.common.PageInfo;

@Service("bService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO bDAO;
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int getBoardListCount() {
		return bDAO.getBoardListCount(sqlSession);
	}

	@Override
	public List<Board> selectBoardList(PageInfo pi) {
		return bDAO.selectBoardList(sqlSession, pi);
	}

	@Override
	public int insertBoard(Board b) {
		return bDAO.insertBoard(sqlSession, b);
	}
	
	@Override
	public int updateBcount(int bNum) {
		return bDAO.updateBoardCount(sqlSession, bNum);
	}
	
	@Override
	public Board selectBoard(int bNum) {
		Board b = bDAO.selectBoard(sqlSession, bNum);		
		return b;
	}
	
	@Override
	public int updateFileCount(int fileId) {
		return bDAO.updateFileCount(sqlSession, fileId);
	}

	@Override
	public int updateBoard(HashMap<String, Object> map, Board b) {
		int result = bDAO.deleteExFile(sqlSession, map);
		result +=  bDAO.updateBoard(sqlSession, b);
		return result;
	}

	@Override
	public Board selectUpdateBoard(int bNum) {
		return bDAO.selectBoard(sqlSession, bNum);
	}

	@Override
	public int insertComment(Comment c) {
		return bDAO.insertComment(sqlSession, c);
	}

	@Override
	public List<Comment> selectComment(int bNum) {
		return bDAO.selectComment(sqlSession, bNum);
	}

	@Override
	public int deleteComment(int cNum) {
		return bDAO.deleteComment(sqlSession, cNum);
	}

	@Override
	public int deleteBoard(int bnum) {
		return bDAO.deleteBoard(sqlSession, bnum);
	}
	
	@Override
	public int updateComment(Comment c) {
		return bDAO.updateComment(sqlSession, c);
	}

	@Override
	public int ReplyComment(Comment c) {
		return bDAO.replyComment(sqlSession, c);
	}

	@Override
	public int getSearchListCount(HashMap<String, String> map) {
		return bDAO.getSearchCount(sqlSession, map);
	}

	@Override
	public List<Board> searchBoardList(PageInfo pi, HashMap<String, String> map) {
		return bDAO.searchBoardList(sqlSession, pi, map);
	}

	@Override
	public List<Board> allSearchBoard(String word) {
		return bDAO.allSearchBoard(sqlSession, word);
	}
	
	@Override
	public ArrayList<Board> selectMBoardList() {
		return bDAO.selectMBoardList(sqlSession);
	}

	@Override
	public List<Board> selectManagerBoardList(PageInfo pi) {
		return bDAO.selectManagerBoardList(sqlSession, pi);
	}

	@Override
	public int getManagerBoardListCount() {
		return bDAO.getManagerBoardListCount(sqlSession);
	}
}
