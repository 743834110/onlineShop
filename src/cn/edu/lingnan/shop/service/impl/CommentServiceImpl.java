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

}
