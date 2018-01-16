package cn.edu.lingnan.shop.service;


import java.util.List;


import cn.edu.lingnan.shop.pojo.Comments;

public interface CommentService {
	

	public void addComment(Comments comment);

	//查全部评论数据
	public List<Comments> findAllComments();
	
	//删除评论数据
	public void deleteComments(Comments comment);
	
	//根据id查评论数据
	public Comments getCommentById(Long id);
	
	//查看评论的数量
	public Long getCommentCount();

}
