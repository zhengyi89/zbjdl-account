package com.zbjdl.account;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSON;
import com.zbjdl.account.dto.AssetInfoDto;
import com.zbjdl.account.dto.TaxInfoDto;
import com.zbjdl.account.dto.request.VoucherInfoSaveReqDto;
import com.zbjdl.account.service.AssetClassInfoService;
import com.zbjdl.account.service.AssetDeprecitionInfoService;
import com.zbjdl.account.service.AssetInfoService;
import com.zbjdl.account.service.TaxInfoService;
import com.zbjdl.account.service.VoucherInfoService;
import com.zbjdl.common.utility.service.IdGenerateService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WebApplication.class)
@WebAppConfiguration
public class WebApplicationTests {
	
	
	@Autowired
	TaxInfoService taxInfoService;
	
	@Autowired
	AssetInfoService assetInfoService;
	
	@Autowired
	VoucherInfoService voucherInfoService;
	
	@Autowired
	IdGenerateService idGenerateService;
	
	@Autowired
	AssetClassInfoService assetClassInfoService;
	
	@Autowired
	AssetDeprecitionInfoService assetDeprecitionInfoService;
	
	@Test
	public void taxInfoAddTest(){
		AssetInfoDto assetInfoDto = new AssetInfoDto();
		assetInfoDto.setAssetClassCode("aaa");
		assetInfoDto = assetInfoService.saveOrUpdate(assetInfoDto);
		System.out.println("---------"+JSON.toJSONString(assetInfoDto));
	}

	@Test
	public void taxFindListTest(){
		TaxInfoDto taxInfo = new TaxInfoDto();
		taxInfo.setParentId("1111");
		List<TaxInfoDto> list = taxInfoService.findList(taxInfo);
		System.out.println("-----------1111111------"+JSON.toJSONString(list));
	}

	@Test
	public void assetInfoAddTest(){
		assetDeprecitionInfoService.doDeprecition("000011", "2019-02");
	}
	
	@Test
	public void productAddTest(){
//		VoucherInfoSaveReqDto voucherInfoSaveReqDto = new VoucherInfoSaveReqDto();
//		voucherInfoSaveReqDto.setSerialNum("1111");
//		voucherInfoService.saveOrUpdate(voucherInfoSaveReqDto);
//		System.out.println("---------------id--"+voucherInfoSaveReqDto.getId());
	}
	@Test
	public void idGenerateTest(){
		String syscode = idGenerateService.generateSequence("ACCOUNT_SYSTEM_CODE", "%06d");
		System.out.println("-----------"+syscode);
	}
	
	
}
