package com.kh.forcatdog.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.forcatdog.board.model.vo.Board;
import com.kh.forcatdog.board.model.vo.Comment;
import com.kh.forcatdog.common.PageInfo;

@Repository("bDAO")
public class BoardDAO {

	public int getBoardListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("boardMapper.getBoardListCount");
	}

	public List<Board> selectBoardList(SqlSessionTemplate sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getItemLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getItemLimit());
		return sqlSession.selectList("boardMapper.selectBoardList", null, rowBounds);
	}

	public int insertBoard(SqlSessionTemplate sqlSession, Board b) {
		int result = sqlSession.insert("boardMapper.insertBoard", b);
		if(b.getFileList() != null && b.getFileList().size() > 0) {
			result += sqlSession.insert("boardMapper.insertBoardFile", b);
		}
		return result;
	}

	public Board selectBoard(SqlSessionTemplate sqlSession, int bNum) {
		return sqlSession.selectOne("boardMapper.selectBoard", bNum);
	}

	public int updateBoardCount(SqlSessionTemplate sqlSession, int bNum) {
		return sqlSession.update("boardMapper.updateBoardCount", bNum);
	}

	public int updateFileCount(SqlSessionTemplate sqlSession, int fileId) {
		return sqlSession.update("boardMapper.updateFileCount", fileId);
	}

	public int deleteExFile(SqlSessionTemplate sqlSession, HashMap<String, Object> map) {
		return sqlSession.update("boardMapper.deleteExFile", map);
	}

	public int updateBoard(SqlSessionTemplate sqlSession, Board b) {
		int result = sqlSession.insert("boardMapper.updateBoard", b);
		if(b.getFileList() != null && b.getFileList().size() > 0) {
			result += sqlSession.insert("boardMapper.updateBoardFile", b);
		}
		return result;
	}

	public int insertComment(SqlSessionTemplate sqlSession, Comment c) {
		return sqlSession.insert("boardMapper.insertComment", c);
	}

	public List<Comment> selectComment(SqlSessionTemplate sqlSession, int bNum) {
		return sqlSession.selectList("boardMapper.selectComment", bNum);
	}

	public int deleteComment(SqlSessionTemplate sqlSession, int cNum) {
		return sqlSession.update("boardMapper.deleteComment", cNum);
	}

	public int deleteBoard(SqlSessionTemplate sqlSession, int bnum) {
		return sqlSession.update("boardMapper.deleteBoard", bnum);
	}
	
	public int updateComment(SqlSessionTemplate sqlSession, Comment c) {
		return sqlSession.update("boardMapper.updateComment", c);
	}

	public int replyComment(SqlSessionTemplate sqlSession, Comment c) {
		return sqlSession.insert("boardMapper.insertComment", c);
	}

	public int getSearchCount(SqlSessionTemplate sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("boardMapper.getSearchCount", map);
	}

	public List<Board> searchBoardList(SqlSessionTemplate sqlSession, PageInfo pi, HashMap<String, String> map) {
		int offset = (pi.getCurrentPage() - 1) * pi.getItemLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getItemLimit());
		return sqlSession.selectList("boardMapper.searchBoardList", map, rowBounds);
	}

	public List<Board> allSearchBoard(SqlSessionTemplate sqlSession, String word) {
		return sqlSession.selectList("boardMapper.allSearchBoard", word);
	}
	
	public ArrayList<Board> selectMBoardList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("boardMapper.selectMBoardList");
	}

	public List<Board> selectManagerBoardList(SqlSessionTemplate sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getItemLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getItemLimit());
		return sqlSession.selectList("boardMapper.selectManagerBoardList", null, rowBounds);
	}

	public int getManagerBoardListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("boardMapper.getManagerBoardListCount");
	}

}
