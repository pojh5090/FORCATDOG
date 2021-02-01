package com.kh.forcatdog.catdog.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kh.forcatdog.catdog.model.vo.Catdog;
import com.kh.forcatdog.catdog.model.vo.PageInfo;

public interface CatdogService {

	int getDogListCount();
	
	int getCatListCount();

	List<Catdog> selectDogList(PageInfo pi);
	
	List<Catdog> selectCatList(PageInfo pi);

	int insertCatdog(Catdog cd);

	Catdog selectCatdog(int cdNum);
	
	int updateCatdog(HashMap<String, Object> map, Catdog cd);
	
	Catdog selectUpdateCatdog(int cdNum);

	ArrayList<String> selectCate();

	ArrayList<String> selectCate2();
	
	int catdogDelete(int cdNum);

	List<Catdog> searchDog(PageInfo pi, String word);

	List<Catdog> searchCat(PageInfo pi, String word);

	int getDogSearchListCount(String word);

	int getCatSearchListCount(String word);

	List<Catdog> allSearchDog(String word);

	List<Catdog> allSearchCat(String word);
	
	ArrayList<Catdog> selectMainDogList();

	ArrayList<Catdog> selectMainCatList();

	int getCatDogListCount();

	ArrayList<Catdog> selectCatDogList(PageInfo pi);

}
