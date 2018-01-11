package cn.edu.lingnan.shop.utils;

import java.lang.reflect.Field;
import java.util.Collection;

import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.spi.SessionImplementor;



public class MyCriteria extends org.hibernate.internal.CriteriaImpl{

	
	/*�ѳ־ö���getName()����ȥ*/
	public MyCriteria(String entityOrClassName, SessionImplementor session) {
		super(entityOrClassName, session);
	}
	
	public <T> void add(T condition){
		if (condition != null){
			
			try{
				for (Field field: condition.getClass().getDeclaredFields()){
					field.setAccessible(true);
					Object value = field.get(condition);
					Class<?> type = field.getType();
					if (value == null)
						continue;
					if (type == String.class && value.equals(""))
						continue;
					if (value instanceof Collection)
						continue;
					if (field.getType() == String.class)
						this.add(Restrictions.like(field.getName(),"" + field.get(condition), MatchMode.ANYWHERE));
					else if (field.getName().equals("auctionendtime"))
						this.add(Restrictions.le(field.getName(), field.get(condition)));
					else
						this.add(Restrictions.ge(field.getName(), field.get(condition)));
					
				}
			}
			catch (Exception e){
				e.printStackTrace();
			}
			
		}
	}

}
