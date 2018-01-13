package cn.edu.lingnan.shop.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.lingnan.shop.pojo.Comments;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.service.CommentService;

/**
 * 评论action
 * 负责评论和用户和商品的交互有关的数据控制
 */
public class CommentAction extends BaseAction {

	@Autowired
	private CommentService commentService;
	
	private List<Comments> commentsList;
	
	private List<Comments> userCommentsList;
	
	private int id;
	
	//评价管理
	public String toComments(){
		userCommentsList = new ArrayList<>();
		User user = (User) this.session.get("user");
		commentsList = commentService.findAllComments();
		for (Comments comment : commentsList) {
			System.out.println(comment.getContent());
			if(comment.getUser().getId() == user.getId()){
				System.out.println("ssssssssssss");
				userCommentsList.add(comment);
			}
		}
		return SUCCESS;
	}
	
	//普通用户删除评论
	public String deleteComment(){
		Comments comment = commentService.getCommentById((long) id);
		commentService.deleteComments(comment);
		return SUCCESS;
	}
	
	public List<Comments> getCommentsList() {
		return commentsList;
	}

	public void setCommentsList(List<Comments> commentsList) {
		this.commentsList = commentsList;
	}

	public List<Comments> getUserCommentsList() {
		return userCommentsList;
	}

	public void setUserCommentsList(List<Comments> userCommentsList) {
		this.userCommentsList = userCommentsList;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
