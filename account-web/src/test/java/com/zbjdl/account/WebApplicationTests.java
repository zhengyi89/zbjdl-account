package com.zbjdl.account;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSON;
import com.zbjdl.account.dto.AssetDeprecitionInfoDto;
import com.zbjdl.account.dto.AssetInfoDto;
import com.zbjdl.account.dto.TaxInfoDto;
import com.zbjdl.account.dto.VoucherSubDetailDto;
import com.zbjdl.account.dto.request.DetailAccountReportReqDto;
import com.zbjdl.account.dto.request.FindPreDeprecitionInfoReqDto;
import com.zbjdl.account.dto.request.VoucherInfoSaveReqDto;
import com.zbjdl.account.enumtype.AssetEnum;
import com.zbjdl.account.service.AssetClassInfoService;
import com.zbjdl.account.service.AssetDeprecitionInfoService;
import com.zbjdl.account.service.AssetInfoService;
import com.zbjdl.account.service.TaxInfoService;
import com.zbjdl.account.service.VoucherInfoService;
import com.zbjdl.account.service.VoucherSubInfoService;
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
	
	@Autowired
	VoucherSubInfoService voucherSubInfoService;
	
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
		FindPreDeprecitionInfoReqDto reqDto = new FindPreDeprecitionInfoReqDto();
		reqDto.setDeprecitionMonth("2019-02");
		reqDto.setSystemCode("000015");
		reqDto.setCostType(AssetEnum.COST_TYPE_DEPRECITION.getCode());
		List<AssetDeprecitionInfoDto>  deprecitionList = assetDeprecitionInfoService.findPreDeprecition(reqDto);
		for (AssetDeprecitionInfoDto assetDeprecitionInfoDto : deprecitionList) {
			System.out.println("----------"+JSON.toJSONString(assetDeprecitionInfoDto));
		}
	}
	
	@Test
	public void productAddTest(){
		Integer aa = voucherInfoService.selectDefaultSerialNum("111","2");
		System.out.println("--------"+aa);
	}
	@Test
	public void idGenerateTest(){
		String syscode = idGenerateService.generateSequence("ACCOUNT_SYSTEM_CODE", "%06d");
		System.out.println("-----------"+syscode);
	}
	
	
	@Test
	public void testVoucher(){
		DetailAccountReportReqDto reqDto = new DetailAccountReportReqDto();
		reqDto.setAssistCode("gys001");
		reqDto.setSubjectCode("2202");
		reqDto.setSystemCode("000015");
		reqDto.setStartdate("2019-01");
		reqDto.setAccountMonth("2019-01");
		List<VoucherSubDetailDto> list = voucherSubInfoService.findListByParamOrder(reqDto);
		for (VoucherSubDetailDto voucherSubDetailDto : list) {
			System.out.println("-----"+JSON.toJSONString(voucherSubDetailDto));
		}
	}
	
}
