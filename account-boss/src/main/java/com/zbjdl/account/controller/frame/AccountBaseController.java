package com.zbjdl.account.controller.frame;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbjdl.account.constant.DataConstants;
import com.zbjdl.account.dto.CurrentSystemDto;
import com.zbjdl.account.dto.SystemInfoDto;
import com.zbjdl.account.service.SystemInfoService;
import com.zbjdl.account.util.DateUtils;
import com.zbjdl.boss.admin.frame.BaseController;
import com.zbjdl.common.utils.BeanUtils;

public class AccountBaseController extends BaseController {
	
	@Autowired
	SystemInfoService systemInfoService;
	/**
	 * 从缓存获取当前会计系统参数
	 */
	protected CurrentSystemDto getCurrentSystemInfo() {
//		CurrentSystemDto currentSystemDto = new CurrentSystemDto();
//		SystemInfoDto systemInfoDto = systemInfoService.selectByCompanyId(16L);
//		BeanUtils.copyProperties(systemInfoDto, currentSystemDto);
//		currentSystemDto.setSystemId(systemInfoDto.getId());
//		currentSystemDto.setAccountMonth(DateUtils.DATE_MONTH_FORMAT.format(new Date()));
//		currentSystemDto.setStartMonth(DateUtils.DATE_MONTH_FORMAT.format(systemInfoDto.getServerStartDate()));
//		setCurrentSystemInfo(currentSystemDto);
//		
		
		return (CurrentSystemDto) super.request.getSession().getAttribute(DataConstants.SESSION_ACCOUNTINFO);
	}
	
	/**
	 * 设置当前会计系统参数
	 */
	protected void setCurrentSystemInfo(CurrentSystemDto currentSystemDto){
		super.request.getSession().setAttribute(DataConstants.SESSION_ACCOUNTINFO, currentSystemDto);
	}
	
	/**
	 * 从缓存获清除当前会计系统参数
	 */
	protected void deleteCurrentSystemInfo(){
		super.request.getSession().setAttribute(DataConstants.SESSION_ACCOUNTINFO, null);
	}
}
