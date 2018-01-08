package com.lingnan.service;

import java.util.List;

import com.lingnan.entity.Comment;

public interface CommentService {
	
	public List<Comment> loadCommentByNewsId(Integer newsId);
	
	public void addComment(Comment comment);
}
