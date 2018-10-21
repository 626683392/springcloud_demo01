package com.taoai77.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 服务过滤
 */
@Component
@Slf4j
public class MyFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		/*拿到请求对象*/
		HttpServletRequest request = ctx.getRequest();
		//拿到客户端的信息
		log.info(String.format("%s >>> %s", request.getRemoteAddr(), request.getRemotePort()));
		log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		//如果有token则不拦截
		Object accessToken = request.getParameter("token");
		if (accessToken != null) {
			return null;
		}
		//如果没有token则拦截
		log.warn("token is empty");
		ctx.setSendZuulResponse(false);
		//设置响应参数
		ctx.setResponseStatusCode(401);
		try {
			ctx.getResponse().getWriter().write("token is empty");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
