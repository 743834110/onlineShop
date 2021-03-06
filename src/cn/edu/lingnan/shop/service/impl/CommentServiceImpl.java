package cn.edu.lingnan.shop.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.lingnan.shop.dao.CommentsDao;
import cn.edu.lingnan.shop.pojo.Comments;
import cn.edu.lingnan.shop.service.CommentService;

@Transactional
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentsDao commentsDao;
	

	@Override
	public void addComment(Comments comment) {
		this.commentsDao.save(comment);
	}
	@Override
	public List<Comments> findAllComments() {
		return commentsDao.getListByHQL("from Comments");
	}

	@Override
	public void deleteComments(Comments comment) {
		commentsDao.delete(comment);
	}

	@Override
	public Comments getCommentById(Long id) {
		return commentsDao.findById(id);
	}
	@Override
	public Long getCommentCount() {
		return (Long) this.commentsDao.uniqueResult("select count(id) from Comments");
	}
	
	public Comments getCommentByOrderId(Long orderId) {
		return commentsDao.getByHQL("from Comments where orderId = ?", orderId);
	}
}
