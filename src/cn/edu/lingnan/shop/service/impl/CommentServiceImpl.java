package cn.edu.lingnan.shop.service.impl;

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
	private CommentsDao commentDao;
	@Override
	public void addComment(Comments comment) {
		this.commentDao.save(comment);
	}

}
