package cn.edu.lingnan.shop.intercept;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckUserLogin extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		if(!session.containsKey("user")) {
			return "userlogin";
		} else {
			return invocation.invoke();
		}
	}

}
