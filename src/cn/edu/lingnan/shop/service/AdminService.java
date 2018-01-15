package cn.edu.lingnan.shop.service;

import java.util.List;

import cn.edu.lingnan.shop.pojo.CheckComments;
import cn.edu.lingnan.shop.pojo.CheckUser;
import cn.edu.lingnan.shop.pojo.Comments;
import cn.edu.lingnan.shop.pojo.Product;
import cn.edu.lingnan.shop.pojo.User;

public interface AdminService {
	
	/***
	 * 管理员登录
	 * @param yu
	 * @return
	 */
	
	public User login(User admin);
	
	public List<User> findAllCommonUser();
	public List<Product> findAllSellProduct();
	public List<Product> findAllNoSellProduct();
	public List<CheckUser> getAllCheckUser();
	public CheckUser findCheckUserById(long id);
	public void updateCheckUser(CheckUser checkUser);
	
	public List<Comments> findAllComments();
	public Comments findCommentsById(long id);
	public void updateComments(Comments comments);
	public CheckComments findCheckCommentsByCommentsid(long id);
	public void updateCheckComments(CheckComments checkComments);
	
}
