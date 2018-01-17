package cn.edu.lingnan.shop.utils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class TallyKeyGen implements IdentifierGenerator{

	private Date date = new Date();
	
	@Override
	public Serializable generate(SessionImplementor session, Object object)
			throws HibernateException {	
		return DateFormatUtils.format(date);
	}

}
