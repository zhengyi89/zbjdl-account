package com.zbjdl.account.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zbjdl.account.constant.DataConstants;
import com.zbjdl.account.dto.CurrentSystemDto;

/**
 * 校验是否已经有系统参数的session信息
 * （在我的客户页面，点击记账，设置财务平台session后，才可以访问财物平台其他菜单）
 * 
 * @author zhengy
 * @date: 2018年11月23日 下午5:42:24
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {
	private Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("进入SessionInterceptor prehandle");
		try {
//			String requestURI = request.getRequestURI();
			CurrentSystemDto currentSystemDto = (CurrentSystemDto) request.getSession().getAttribute(DataConstants.SESSION_ACCOUNTINFO);

			if (currentSystemDto == null || currentSystemDto.getSystemId() == null) {
				logger.info("no session , redirect to company/index");
				response.sendRedirect(request.getContextPath() + "/company/index?type=account&belongSystem=-9992003&_menuId=61&_firstMenuId=-2003");
				return true;
			}
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
}
