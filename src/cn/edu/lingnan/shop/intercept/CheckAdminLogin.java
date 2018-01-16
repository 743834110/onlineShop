package cn.edu.lingnan.shop.intercept;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckAdminLogin extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		
		if(!session.containsKey("admin")) {
			return "adminlogin";
		} else {
			return invocation.invoke();
		}
	}

}
