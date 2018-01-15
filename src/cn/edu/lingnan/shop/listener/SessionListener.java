package cn.edu.lingnan.shop.listener;

import java.io.Serializable;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cn.edu.lingnan.shop.pojo.Tally;
import cn.edu.lingnan.shop.utils.ServiceUtils;

public class SessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		ServiceUtils serviceUtils = ServiceUtils.getInstance();
		Tally tally = serviceUtils.getTally();
		if (tally == null){
			tally = new Tally(1L, 1L);
			Serializable id =  serviceUtils.saveTally(tally);
			tally.setId((Date) id);
		}
		else{
			tally.setCurrentaccess(tally.getCurrentaccess() + 1);
			tally.setTotalaccess(tally.getTotalaccess() + 1);
			serviceUtils.mergeTally(tally);
		}

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		ServiceUtils serviceUtils = ServiceUtils.getInstance();
		Tally tally = serviceUtils.getTally();
		tally.setCurrentaccess(tally.getCurrentaccess() - 1);
		serviceUtils.mergeTally(tally);
	}
	
}
