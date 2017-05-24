package com.cunity.platform.view;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

// 将HelloView放入IOC容器中
@Component
public class HelloView implements View{

	@Override
	public String getContentType() {
		return "text/html";
	}

	@Override
	public void render(Map<String, ?> arg0, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		resp.getWriter().print("Hello View," + new Date());
	}

}
