package com.kh.forcatdog.catdog.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.forcatdog.catdog.model.dao.CatdogDAO;
import com.kh.forcatdog.catdog.model.vo.Catdog;
import com.kh.forcatdog.catdog.model.vo.PageInfo;

@Service("ccService")
public class CatdogServiceImpl implements CatdogService {
	
	@Autowired
	private CatdogDAO ccDAO;
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int getDogListCount() {
		return ccDAO.getDogListCount(sqlSession);
	}
	
	@Override
	public int getCatListCount() {
		return ccDAO.getCatListCount(sqlSession);
	}

	@Override
	public List<Catdog> selectDogList(PageInfo pi) {
		return ccDAO.selectDogList(sqlSession, pi);
	}
	
	@Override
	public List<Catdog> selectCatList(PageInfo pi) {
		return ccDAO.selectCatList(sqlSession, pi);
	}
	
	@Override
	public int insertCatdog(Catdog cd) {
		int result = ccDAO.insertCatdog(sqlSession, cd);
		
		if(cd.getFileList() != null && cd.getFileList().size() > 0) {
			result += ccDAO.insertCatdogFile(sqlSession, cd);
		}
		
		return result;
	}

	@Override
	public Catdog selectCatdog(int cdNum) {
		
		Catdog cd = ccDAO.selectCatdog(sqlSession, cdNum);

		return cd;
	}
	
	@Override
	public Catdog selectUpdateCatdog(int cdNum) {
		return ccDAO.selectCatdog(sqlSession, cdNum);
	}

	@Override
	public int updateCatdog(HashMap<String, Object> map, Catdog cd) {
		int result = ccDAO.deleteExFile(sqlSession, map);
		result +=  ccDAO.updateCatdog(sqlSession, cd);
		if(cd.getFileList() != null && cd.getFileList().size() > 0) {
			result += ccDAO.updateCatdogFile(sqlSession, cd);
		}
		return result;
	}

	@Override
	public ArrayList<String> selectCate() {
		return (ArrayList<String>) ccDAO.selectCate(sqlSession);
	}

	@Override
	public ArrayList<String> selectCate2() {
		return (ArrayList<String>) ccDAO.selectCate2(sqlSession);
	}
	
	@Override
	public int catdogDelete(int cdNum) {
		return ccDAO.deleteCatdog(sqlSession, cdNum);
	}

	@Override
	public List<Catdog> searchDog(PageInfo pi, String word) {
		return ccDAO.searchDog(sqlSession, pi, word);
	}
	
	@Override
	public List<Catdog> searchCat(PageInfo pi, String word) {
		return ccDAO.searchCat(sqlSession, pi, word);
	}

	@Override
	public int getDogSearchListCount(String word) {
		return ccDAO.getDogSearchListCount(sqlSession, word);
	}

	@Override
	public int getCatSearchListCount(String word) {
		return ccDAO.getCatSearchListCount(sqlSession, word);
	}

	@Override
	public List<Catdog> allSearchDog(String word) {
		return ccDAO.allSearchDog(sqlSession, word);
	}

	@Override
	public List<Catdog> allSearchCat(String word) {
		return ccDAO.allSearchCat(sqlSession, word);
	}
	
	@Override
	public ArrayList<Catdog> selectMainDogList() {
		return ccDAO.selectMainDogList(sqlSession);
	}

	@Override
	public ArrayList<Catdog> selectMainCatList() {
		return ccDAO.selectMainCatList(sqlSession);
	}

	@Override
	public int getCatDogListCount() {
		return ccDAO.getCatDogListCount(sqlSession);
	}

	@Override
	public ArrayList<Catdog> selectCatDogList(PageInfo pi) {
		return ccDAO.selectCatDogList(sqlSession, pi);
	}
}
