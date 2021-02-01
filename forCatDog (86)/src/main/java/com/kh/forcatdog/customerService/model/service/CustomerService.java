package com.kh.forcatdog.customerService.model.service;

import java.util.ArrayList;
import java.util.List;

import com.kh.forcatdog.common.PageInfo;
import com.kh.forcatdog.customerService.model.vo.Notice;
import com.kh.forcatdog.customerService.model.vo.OperationGuide;
import com.kh.forcatdog.customerService.model.vo.QuestionNAnswer;

public interface CustomerService {

	int getListCount();

	ArrayList<Notice> selectList(PageInfo pi);

	ArrayList<OperationGuide> selectOList();

	int getQListCount(String userId);

	ArrayList<QuestionNAnswer> selectQList(PageInfo pi, String userId);

	int insertNotice(Notice n);

	Notice selectNotice(int nNum);

	int deleteNotice(int nNum);

	Notice updateNoticeForm(int nNum);

	int updateNotice(Notice n);

	OperationGuide updateOperationGuideForm(int opNum);

	int insertOperationGuide(OperationGuide og);

	QuestionNAnswer selectQuestion(int qNum);

	int updateQuestion(QuestionNAnswer qna);

	int insertQuestion(QuestionNAnswer qna);

	int deleteQuestion(int qNum);

	int operationGuideUpdate(OperationGuide og);

	int deleteOperationGuide(int opNum);

	int insertAnswer(QuestionNAnswer qna);

	ArrayList<QuestionNAnswer> selectQuestionList(PageInfo pi);

	int getAQListCount();
	
	ArrayList<Notice> selectMainNoticeList();
	
	ArrayList<Notice> selectMnoticeList(PageInfo pi1);

	ArrayList<OperationGuide> selectMoperationList(PageInfo pi2);

	OperationGuide Operationselect(int opNum);

	int getNoticeCount();

	int getOperationCount();

	List<QuestionNAnswer> selectAnswer(int qNum);
}
