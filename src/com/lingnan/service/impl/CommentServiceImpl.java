package com.lingnan.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingnan.dao.CommentDao;
import com.lingnan.entity.Comment;
import com.lingnan.service.CommentService;

@Transactional
@Service
public class CommentServiceImpl implements CommentService{


	@Autowired
	private CommentDao commentDao;
	
	public List<Comment> loadCommentByNewsId(Integer newsId) {
		return this.commentDao.getListByHQL("from Comment where newsDetail.id = ?", newsId);
	}

	@Override
	public void addComment(Comment comment) {
		this.commentDao.save(comment);
	}

}
