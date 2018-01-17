package cn.edu.lingnan.shop.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.lingnan.shop.dao.CheckUserDao;
import cn.edu.lingnan.shop.dao.UserDao;
import cn.edu.lingnan.shop.pojo.CheckUser;
import cn.edu.lingnan.shop.pojo.User;
import cn.edu.lingnan.shop.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userdao;
	@Autowired
	private CheckUserDao checkUserDao;

	/**
	 * 用户注册
	 * @author yuan
	 * @param user
	 */
	@Override
	public void register(User user) {
		Date date = new Date();
		user.setRegisterdate(date);
		user.setType(1);
		userdao.save(user);
	}

	
	@Override
	public User login(User user) {
		List<User> list = userdao.find(user);
		if(list != null && list.size() > 0)
			return list.get(0);
		else return null;
	}

	/**
	 * 修改用户信息
	 * @author huang
	 * @param user
	 */
	@Override
	public int updateUser(User user) {
		userdao.update(user);
		return 0;
	}

	@Override
	public User getUserById(long id) {
		return userdao.findById(id);
	}

	@Override
	public User getUserByIdcardEmail(String idCard, String email) {
		List<Object> values = new ArrayList<>();
		String hql = "from User where 1=1";
		values.add(idCard);
		values.add(email);
		hql += " and idcard = ?";
		hql += " and email = ?";
		List<User> list = userdao.getListByHQL(hql, values.toArray());
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 保存一条申请卖家记录
	 * @author huang
	 * @param checkUser 记录对象
	 */
	@Override
	public void saveCheckUser(CheckUser checkUser) {
		checkUserDao.save(checkUser);
	}

	/**
	 * 检查用户有无申请
	 * @author huang
	 * @param id 用户Id
	 * @return CheckUser 对象
	 */
	@Override
	public CheckUser findCheckUserByUserid(long id) {
		String hql = "select c from CheckUser c where userid = ?";
		CheckUser checkUser = (CheckUser) checkUserDao.uniqueResult(hql, id);
		return checkUser;
	}


	@Override
	public Long getAllUserWithoutAdmin() {
		return (Long) this.userdao.uniqueResult("select count(id) from User where type < ?", 3);
	}
	
	
	
}
