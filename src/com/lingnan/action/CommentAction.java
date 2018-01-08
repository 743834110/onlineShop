package com.lingnan.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lingnan.entity.Comment;
import com.lingnan.entity.NewsDetail;
import com.lingnan.service.CommentService;

public class CommentAction extends BaseAction{
	
	
	@Autowired
	private CommentService service;
	
	private Integer newsId;
	private List<Comment> comments;
	private Comment comment;
	/**
	 * 根据新闻的id查找相关评论
	 * @return
	 */
	public String loadCommentByNewsId(){
		System.out.println(this.newsId);
		this.comments = this.service.loadCommentByNewsId(newsId);
		System.out.println(this.comments.size());
		return SUCCESS;
	}
	
	/**
	 * 添加新闻评论
	 * @return
	 */
	public String addComment(){
		System.out.println("添加评论");
		NewsDetail detail = new NewsDetail();
		detail.setId(newsId);
		this.comment.setNewsDetail(detail);
		this.comment.setCreatedate(new Date());
		this.service.addComment(comment);
		return SUCCESS;
	}
	
	public Integer getNewsId() {
		return newsId;
	}
	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	

}
