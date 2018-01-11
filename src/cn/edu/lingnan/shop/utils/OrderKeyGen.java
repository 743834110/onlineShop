package cn.edu.lingnan.shop.utils;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class OrderKeyGen implements IdentifierGenerator {

	public static Long preFix;
	
	@Override
	public Serializable generate(SessionImplementor arg0, Object arg1)
			throws HibernateException {
		   
	       return preFix; 
	}

}
