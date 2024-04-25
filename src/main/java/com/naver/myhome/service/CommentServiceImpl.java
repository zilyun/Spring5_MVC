package com.naver.myhome.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.myhome.aop.LogAdvice;
import com.naver.myhome.domain.Comment;
import com.naver.myhome.mybatis.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {

	private LogAdvice log;
	private CommentMapper dao;
	
	@Autowired
	public CommentServiceImpl(CommentMapper dao, LogAdvice log) {
		this.dao = dao;
		this.log = log;
	}
	
	@Override
	public int getListCount(int board_num) {
		log.beforeLog();
		return dao.getListCount(board_num);
	}

	@Override
	public int commentsInsert(Comment c) {
		log.beforeLog();
		return dao.commentsInsert(c);
	}

	@Override
	public List<Comment> getCommentList(int board_num, int page) {
		log.beforeLog();
		int startrow = 1;
		int endrow   = page * 3;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("board_num", board_num);
		map.put("start", startrow);
		map.put("end", endrow);
		
		return dao.getCommentList(map);
	}

	@Override
	public int commentsUpdate(Comment co) {
		log.beforeLog();
		return dao.commentsUpdate(co);
	}
	
	@Override
	public int commentsDelete(int num) {
		log.beforeLog();
		return dao.commentsDelete(num);
	}

}
