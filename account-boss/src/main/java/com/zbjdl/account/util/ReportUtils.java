package com.zbjdl.account.util;

import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.zbjdl.account.dto.AccountSettleWithSubjectInfoDto;
import com.zbjdl.account.dto.response.CashFlowStatementRespDto;
import com.zbjdl.common.amount.Amount;

public class ReportUtils {

	public static ModelAndView cashFlowStatementSmall(Map<String, AccountSettleWithSubjectInfoDto> map) {
		Amount a5001c = map.get("5001").getCreditAmount();
		Amount a1122c = map.get("1122").getCreditAmount();
		Amount a1121c = map.get("1121").getCreditAmount();
		Amount a2203c = map.get("2203").getCreditAmount();
		Amount a222101c = map.get("222101").getCreditAmount();
		Amount a5301c = map.get("5301").getCreditAmount();
		Amount a5051c = map.get("5051").getCreditAmount();
		Amount a1101c = map.get("1101").getCreditAmount();
		Amount a1501c = map.get("1501").getCreditAmount();
		Amount a1511c = map.get("1511").getCreditAmount();
		Amount a5111c = map.get("5111").getCreditAmount();
		Amount a1131c = map.get("1131").getCreditAmount();
		Amount a1132c = map.get("1132").getCreditAmount();
		Amount a1606c = map.get("1606").getCreditAmount();
		Amount a1621c = map.get("1621").getCreditAmount();
		Amount a1701c = map.get("1701").getCreditAmount();
		Amount a2001c = map.get("2001").getCreditAmount();
		Amount a2501c = map.get("2501").getCreditAmount();
		Amount a3001c = map.get("3001").getCreditAmount();
		Amount a3002c = map.get("3002").getCreditAmount();

		Amount a1403d = map.get("1403").getDebitAmount();
		Amount a1405d = map.get("1405").getDebitAmount();
		Amount a5401d = map.get("5401").getDebitAmount();
		Amount a5402d = map.get("5402").getDebitAmount();
		Amount a5403d = map.get("5403").getDebitAmount();
		Amount a2201d = map.get("2201").getDebitAmount();
		Amount a2202d = map.get("2202").getDebitAmount();
		Amount a1123d = map.get("1123").getDebitAmount();
		Amount a2221d = map.get("2221").getDebitAmount();
		Amount a222101d = map.get("222101").getDebitAmount();
		Amount a2211d = map.get("2211").getDebitAmount();
		Amount a560207d = map.get("560207").getDebitAmount();
		Amount a5711d = map.get("5711").getDebitAmount();
		Amount a5602d = map.get("5602").getDebitAmount();
		Amount a560206d = map.get("560206").getDebitAmount();
		Amount a560208d = map.get("560208").getDebitAmount();
		Amount a560212d = map.get("560212").getDebitAmount();
		Amount a1101d = map.get("1101").getDebitAmount();
		Amount a1501d = map.get("1501").getDebitAmount();
		Amount a1511d = map.get("1511").getDebitAmount();
		Amount a1601d = map.get("1601").getDebitAmount();
		Amount a1701d = map.get("1701").getDebitAmount();
		Amount a1604d = map.get("1604").getDebitAmount();
		Amount a1621d = map.get("1621").getDebitAmount();
		Amount a2001d = map.get("2001").getDebitAmount();
		Amount a2501d = map.get("2501").getDebitAmount();
		Amount a560306d = map.get("560306").getDebitAmount();
		Amount a2231d = map.get("2231").getDebitAmount();
		Amount a2232d = map.get("2232").getDebitAmount();

		/*
		 * 以下是本年累计
		 */
		Amount y5001c = map.get("5001").getYearCreditAmount();
		Amount y1122c = map.get("1122").getYearCreditAmount();
		Amount y1121c = map.get("1121").getYearCreditAmount();
		Amount y2203c = map.get("2203").getYearCreditAmount();
		Amount y222101c = map.get("222101").getYearCreditAmount();
		Amount y5301c = map.get("5301").getYearCreditAmount();
		Amount y5051c = map.get("5051").getYearCreditAmount();
		Amount y1101c = map.get("1101").getYearCreditAmount();
		Amount y1501c = map.get("1501").getYearCreditAmount();
		Amount y1511c = map.get("1511").getYearCreditAmount();
		Amount y5111c = map.get("5111").getYearCreditAmount();
		Amount y1131c = map.get("1131").getYearCreditAmount();
		Amount y1132c = map.get("1132").getYearCreditAmount();
		Amount y1606c = map.get("1606").getYearCreditAmount();
		Amount y1621c = map.get("1621").getYearCreditAmount();
		Amount y1701c = map.get("1701").getYearCreditAmount();
		Amount y2001c = map.get("2001").getYearCreditAmount();
		Amount y2501c = map.get("2501").getYearCreditAmount();
		Amount y3001c = map.get("3001").getYearCreditAmount();
		Amount y3002c = map.get("3002").getYearCreditAmount();

		Amount y1403d = map.get("1403").getYearDebitAmount();
		Amount y1405d = map.get("1405").getYearDebitAmount();
		Amount y5401d = map.get("5401").getYearDebitAmount();
		Amount y5402d = map.get("5402").getYearDebitAmount();
		Amount y5403d = map.get("5403").getYearDebitAmount();
		Amount y2201d = map.get("2201").getYearDebitAmount();
		Amount y2202d = map.get("2202").getYearDebitAmount();
		Amount y1123d = map.get("1123").getYearDebitAmount();
		Amount y2221d = map.get("2221").getYearDebitAmount();
		Amount y222101d = map.get("222101").getYearDebitAmount();
		Amount y2211d = map.get("2211").getYearDebitAmount();
		Amount y560207d = map.get("560207").getYearDebitAmount();
		Amount y5711d = map.get("5711").getYearDebitAmount();
		Amount y5602d = map.get("5602").getYearDebitAmount();
		Amount y560206d = map.get("560206").getYearDebitAmount();
		Amount y560208d = map.get("560208").getYearDebitAmount();
		Amount y560212d = map.get("560212").getYearDebitAmount();
		Amount y1101d = map.get("1101").getYearDebitAmount();
		Amount y1501d = map.get("1501").getYearDebitAmount();
		Amount y1511d = map.get("1511").getYearDebitAmount();
		Amount y1601d = map.get("1601").getYearDebitAmount();
		Amount y1701d = map.get("1701").getYearDebitAmount();
		Amount y1604d = map.get("1604").getYearDebitAmount();
		Amount y1621d = map.get("1621").getYearDebitAmount();
		Amount y2001d = map.get("2001").getYearDebitAmount();
		Amount y2501d = map.get("2501").getYearDebitAmount();
		Amount y560306d = map.get("560306").getYearDebitAmount();
		Amount y2231d = map.get("2231").getYearDebitAmount();
		Amount y2232d = map.get("2232").getYearDebitAmount();

		CashFlowStatementRespDto dto1 = new CashFlowStatementRespDto();
		dto1.setSumAmount(a5001c.add(a1121c).add(a1122c).add(a2203c).add(a222101c));
		dto1.setSumYearAmount(y5001c.add(y1121c).add(y1122c).add(y2203c).add(y222101c));

		CashFlowStatementRespDto dto2 = new CashFlowStatementRespDto();
		dto2.setSumAmount(a5301c.add(a5051c));
		dto2.setSumYearAmount(y5301c.add(y5051c));

		CashFlowStatementRespDto dto3 = new CashFlowStatementRespDto();
		dto3.setSumAmount(a1403d.add(a1405d).add(a5401d).add(a5402d).add(a2201d).add(a2202d).add(a1123d).add(a222101d));
		dto3.setSumYearAmount(y1403d.add(y1405d).add(y5401d).add(y5402d).add(y2201d).add(y2202d).add(y1123d).add(y222101d));

		CashFlowStatementRespDto dto4 = new CashFlowStatementRespDto();
		dto4.setSumAmount(a2211d.add(a560207d));
		dto4.setSumYearAmount(y2211d.add(y560207d));

		CashFlowStatementRespDto dto5 = new CashFlowStatementRespDto();
		dto5.setSumAmount(a2221d.subtract(a222101d).add(a5403d));
		dto5.setSumYearAmount(y2221d.subtract(y222101d).add(y5403d));

		CashFlowStatementRespDto dto6 = new CashFlowStatementRespDto();
		dto6.setSumAmount(a5711d.add(a5602d).subtract(a560206d).subtract(a560208d).subtract(a560212d));
		dto6.setSumYearAmount(y5711d.add(y5602d).subtract(y560206d).subtract(y560208d).subtract(y560212d));

		CashFlowStatementRespDto dto7 = new CashFlowStatementRespDto();
		dto7.setSumAmount(dto1.getSumAmount().add(dto2.getSumAmount()).subtract(dto3.getSumAmount()).subtract(dto4.getSumAmount())
				.subtract(dto5.getSumAmount()).subtract(dto6.getSumAmount()));
		dto7.setSumYearAmount(dto1.getSumYearAmount().add(dto2.getSumYearAmount()).subtract(dto3.getSumYearAmount())
				.subtract(dto4.getSumYearAmount()).subtract(dto5.getSumYearAmount()).subtract(dto6.getSumYearAmount()));

		CashFlowStatementRespDto dto8 = new CashFlowStatementRespDto();
		dto8.setSumAmount(a1101c.add(a1501c).add(a1511c));
		dto8.setSumYearAmount(y1101c.add(y1501c).add(y1511c));

		CashFlowStatementRespDto dto9 = new CashFlowStatementRespDto();
		dto9.setSumAmount(a5111c.add(a1131c).add(a1132c));
		dto9.setSumYearAmount(y5111c.add(y1131c).add(y1132c));

		CashFlowStatementRespDto dto10 = new CashFlowStatementRespDto();
		dto10.setSumAmount(a1606c.add(a1701c).add(a1621c));
		dto10.setSumYearAmount(y1606c.add(y1701c).add(y1621c));

		CashFlowStatementRespDto dto11 = new CashFlowStatementRespDto();
		dto11.setSumAmount(a1101d.add(a1501d).add(a1511d));
		dto11.setSumYearAmount(y1101d.add(y1501d).add(y1511d));

		CashFlowStatementRespDto dto12 = new CashFlowStatementRespDto();
		dto12.setSumAmount(a1601d.add(a1701d).add(a1604d).add(a1621d));
		dto12.setSumYearAmount(y1601d.add(y1701d).add(y1604d).add(y1621d));

		CashFlowStatementRespDto dto13 = new CashFlowStatementRespDto();
		dto13.setSumAmount(dto8.getSumAmount().add(dto9.getSumAmount()).add(dto10.getSumAmount()).subtract(dto11.getSumAmount())
				.subtract(dto12.getSumAmount()));
		dto13.setSumYearAmount(dto8.getSumYearAmount().add(dto9.getSumYearAmount()).add(dto10.getSumYearAmount())
				.subtract(dto11.getSumYearAmount()).subtract(dto12.getSumYearAmount()));

		CashFlowStatementRespDto dto14 = new CashFlowStatementRespDto();
		dto14.setSumAmount(a2001c.add(a2501c));
		dto14.setSumYearAmount(y2001c.add(y2501c));

		CashFlowStatementRespDto dto15 = new CashFlowStatementRespDto();
		dto15.setSumAmount(a3001c.add(a3002c));
		dto15.setSumYearAmount(y3001c.add(y3002c));

		CashFlowStatementRespDto dto16 = new CashFlowStatementRespDto();
		dto16.setSumAmount(a2001d.add(a2501d));
		dto16.setSumYearAmount(y2001d.add(y2501d));

		CashFlowStatementRespDto dto17 = new CashFlowStatementRespDto();
		dto17.setSumAmount(a560306d.add(a2231d));
		dto17.setSumYearAmount(y560306d.add(y2231d));

		CashFlowStatementRespDto dto18 = new CashFlowStatementRespDto();
		dto18.setSumAmount(a2232d);
		dto18.setSumYearAmount(y2232d);

		CashFlowStatementRespDto dto19 = new CashFlowStatementRespDto();
		dto19.setSumAmount(dto14.getSumAmount().add(dto15.getSumAmount()).subtract(dto16.getSumAmount()).subtract(dto17.getSumAmount())
				.subtract(dto18.getSumAmount()));
		dto19.setSumYearAmount(dto14.getSumYearAmount().add(dto15.getSumYearAmount()).subtract(dto16.getSumYearAmount())
				.subtract(dto17.getSumYearAmount()).subtract(dto18.getSumYearAmount()));

		CashFlowStatementRespDto dto20 = new CashFlowStatementRespDto();
		dto20.setSumAmount(dto7.getSumAmount().add(dto13.getSumAmount()).add(dto19.getSumAmount()));
		dto20.setSumYearAmount(dto7.getSumYearAmount().add(dto13.getSumYearAmount()).add(dto19.getSumYearAmount()));

		CashFlowStatementRespDto dto21 = new CashFlowStatementRespDto();
		dto21.setSumAmount(map.get("1001").getOpeningBalance().add(map.get("1002").getOpeningBalance())
				.add(map.get("1012").getOpeningBalance()));
		dto21.setSumYearAmount(map.get("1001").getYearOpeningBalance().add(map.get("1002").getYearOpeningBalance())
				.add(map.get("1012").getYearOpeningBalance()));

		CashFlowStatementRespDto dto22 = new CashFlowStatementRespDto();
		dto22.setSumAmount(dto20.getSumAmount().add(dto21.getSumAmount()));
		dto22.setSumYearAmount(dto20.getSumYearAmount().add(dto21.getSumYearAmount()));

		ModelAndView mav = new ModelAndView("report/cashFlowStatementSmall");
		mav.addObject("dto1", dto1);
		mav.addObject("dto2", dto2);
		mav.addObject("dto3", dto3);
		mav.addObject("dto4", dto4);
		mav.addObject("dto5", dto5);
		mav.addObject("dto6", dto6);
		mav.addObject("dto7", dto7);
		mav.addObject("dto8", dto8);
		mav.addObject("dto9", dto9);
		mav.addObject("dto10", dto10);
		mav.addObject("dto11", dto11);
		mav.addObject("dto12", dto12);
		mav.addObject("dto13", dto13);
		mav.addObject("dto14", dto14);
		mav.addObject("dto15", dto15);
		mav.addObject("dto16", dto16);
		mav.addObject("dto17", dto17);
		mav.addObject("dto18", dto18);
		mav.addObject("dto19", dto19);
		mav.addObject("dto20", dto20);
		mav.addObject("dto21", dto21);
		mav.addObject("dto22", dto22);

		return mav;
	}

	public static ModelAndView cashFlowStatementGeneral(Map<String, AccountSettleWithSubjectInfoDto> map) {

		Amount a22210105 = map.get("22210105").getSumAmount();

		Amount a6001c = map.get("6001").getCreditAmount();
		Amount a1122c = map.get("1122").getCreditAmount();
		Amount a1121c = map.get("1121").getCreditAmount();
		Amount a2203c = map.get("2203").getCreditAmount();
		Amount a22210102c = map.get("22210102").getCreditAmount();
		Amount a22210101c = map.get("22210101").getCreditAmount();
		Amount a6403c = map.get("6403").getCreditAmount();
		Amount a6301c = map.get("6301").getCreditAmount();
		Amount a6051c = map.get("6051").getCreditAmount();
		Amount a1403c = map.get("1403").getCreditAmount();
		Amount a1405c = map.get("1405").getCreditAmount();
		Amount a1101c = map.get("1101").getCreditAmount();
		Amount a1501c = map.get("1501").getCreditAmount();
		Amount a1503c = map.get("1503").getCreditAmount();
		Amount a1521c = map.get("1521").getCreditAmount();
		Amount a1511c = map.get("1511").getCreditAmount();
		Amount a2001c = map.get("2001").getCreditAmount();
		Amount a6111c = map.get("6111").getCreditAmount();
		Amount a1131c = map.get("1131").getCreditAmount();
		Amount a1132c = map.get("1132").getCreditAmount();
		Amount a1606c = map.get("1606").getCreditAmount();
		Amount a1701c = map.get("1701").getCreditAmount();
		Amount a4001c = map.get("4001").getCreditAmount();
		Amount a4002c = map.get("4002").getCreditAmount();
		Amount a2501c = map.get("2501").getCreditAmount();
		Amount a2502c = map.get("2502").getCreditAmount();
		Amount a2101c = map.get("2101").getCreditAmount();

		Amount a1621c = map.get("1621").getCreditAmount();

		Amount a6001d = map.get("6001").getDebitAmount();
		Amount a1403d = map.get("1403").getDebitAmount();
		Amount a1405d = map.get("1405").getDebitAmount();
		Amount a22210101d = map.get("22210101").getDebitAmount();
		Amount a2201d = map.get("2201").getDebitAmount();
		Amount a2202d = map.get("2202").getDebitAmount();
		Amount a1123d = map.get("1123").getDebitAmount();
		Amount a6401d = map.get("6401").getDebitAmount();
		Amount a6402d = map.get("6402").getDebitAmount();
		Amount a2211d = map.get("2211").getDebitAmount();
		Amount a2221d = map.get("2221").getDebitAmount();
		Amount a6403d = map.get("6403").getDebitAmount();
		Amount a6711d = map.get("6711").getDebitAmount();
		Amount a660206d = map.get("660206").getDebitAmount();
		Amount a660208d = map.get("660208").getDebitAmount();
		Amount a660212d = map.get("660212").getDebitAmount();
		Amount a1601d = map.get("1601").getDebitAmount();
		Amount a1701d = map.get("1701").getDebitAmount();
		Amount a1604d = map.get("1604").getDebitAmount();
		Amount a1101d = map.get("1101").getDebitAmount();
		Amount a1501d = map.get("1501").getDebitAmount();
		Amount a1503d = map.get("1503").getDebitAmount();
		Amount a1511d = map.get("1511").getDebitAmount();
		Amount a1521d = map.get("1521").getDebitAmount();
		Amount a2001d = map.get("2001").getDebitAmount();
		Amount a2101d = map.get("2101").getDebitAmount();
		Amount a2501d = map.get("2501").getDebitAmount();
		Amount a2502d = map.get("2502").getDebitAmount();
		Amount a2231d = map.get("2231").getDebitAmount();
		Amount a2232d = map.get("2232").getDebitAmount();
		Amount a4104d = map.get("4104").getDebitAmount();
		Amount a660306d = map.get("660306").getDebitAmount();

		CashFlowStatementRespDto dto1 = new CashFlowStatementRespDto();
		dto1.setSumAmount(a6001c.add(a1121c).add(a1122c).add(a2203c).add(a22210102c).subtract(a6001d));

		CashFlowStatementRespDto dto2 = new CashFlowStatementRespDto();
		dto2.setSumAmount(a22210105.add(a6403c));

		CashFlowStatementRespDto dto3 = new CashFlowStatementRespDto();
		dto3.setSumAmount(a6301c.add(a6051c));

		CashFlowStatementRespDto dto4 = new CashFlowStatementRespDto();
		dto4.setSumAmount(dto1.getSumAmount().add(dto2.getSumAmount()).add(dto3.getSumAmount()));
		CashFlowStatementRespDto dto5 = new CashFlowStatementRespDto();
		dto5.setSumAmount(a1403d.add(a1405d).add(a22210101d).add(a6401d).add(a6402d).add(a2201d).add(a2202d).add(a1123d).subtract(a1403c)
				.subtract(a1405c).subtract(a22210101c));

		CashFlowStatementRespDto dto6 = new CashFlowStatementRespDto();
		dto6.setSumAmount(a2211d);
		CashFlowStatementRespDto dto7 = new CashFlowStatementRespDto();
		dto7.setSumAmount(a2221d.subtract(a22210101d).add(a6403d));

		CashFlowStatementRespDto dto8 = new CashFlowStatementRespDto();
		dto8.setSumAmount(a6711d.add(a660206d).add(a660208d).add(a660212d));

		CashFlowStatementRespDto dto9 = new CashFlowStatementRespDto();
		dto9.setSumAmount(dto5.getSumAmount().add(dto6.getSumAmount()).add(dto7.getSumAmount()).add(dto8.getSumAmount()));
		CashFlowStatementRespDto dto10 = new CashFlowStatementRespDto();
		dto10.setSumAmount(dto4.getSumAmount().subtract(dto9.getSumAmount()));

		CashFlowStatementRespDto dto11 = new CashFlowStatementRespDto();
		dto11.setSumAmount(a1101c.add(a1501c).add(a1503c).add(a1511c).add(a1521c).add(a2001c));

		CashFlowStatementRespDto dto12 = new CashFlowStatementRespDto();
		dto12.setSumAmount(a6111c.add(a1131c).add(a1132c));

		CashFlowStatementRespDto dto13 = new CashFlowStatementRespDto();
		dto13.setSumAmount(a1606c.add(a1701c).add(a1621c));

		CashFlowStatementRespDto dto14 = new CashFlowStatementRespDto();
		dto14.setSumAmount(new Amount());
		CashFlowStatementRespDto dto15 = new CashFlowStatementRespDto();
		dto15.setSumAmount(new Amount());
		CashFlowStatementRespDto dto16 = new CashFlowStatementRespDto();
		dto16.setSumAmount(dto11.getSumAmount().add(dto12.getSumAmount()).add(dto13.getSumAmount()).add(dto14.getSumAmount())
				.add(dto15.getSumAmount()));

		CashFlowStatementRespDto dto17 = new CashFlowStatementRespDto();
		dto17.setSumAmount(a1601d.add(a1701d).add(a1604d));
		CashFlowStatementRespDto dto18 = new CashFlowStatementRespDto();
		dto18.setSumAmount(a1101d.add(a1501d).add(a1503d).add(a1511d).add(a1521d));

		CashFlowStatementRespDto dto19 = new CashFlowStatementRespDto();
		dto19.setSumAmount(new Amount());
		CashFlowStatementRespDto dto20 = new CashFlowStatementRespDto();
		dto20.setSumAmount(new Amount());
		CashFlowStatementRespDto dto21 = new CashFlowStatementRespDto();
		dto21.setSumAmount(dto17.getSumAmount().add(dto18.getSumAmount()).add(dto19.getSumAmount()).add(dto20.getSumAmount()));
		CashFlowStatementRespDto dto22 = new CashFlowStatementRespDto();
		dto22.setSumAmount(dto16.getSumAmount().subtract(dto21.getSumAmount()));
		CashFlowStatementRespDto dto23 = new CashFlowStatementRespDto();
		dto23.setSumAmount(a4001c.add(a4002c));
		CashFlowStatementRespDto dto24 = new CashFlowStatementRespDto();
		dto24.setSumAmount(a2001c.add(a2501c).add(a2502c).add(a2101c));
		CashFlowStatementRespDto dto25 = new CashFlowStatementRespDto();
		dto25.setSumAmount(new Amount());
		CashFlowStatementRespDto dto26 = new CashFlowStatementRespDto();
		dto26.setSumAmount(dto23.getSumAmount().add(dto24.getSumAmount()).add(dto25.getSumAmount()));

		CashFlowStatementRespDto dto27 = new CashFlowStatementRespDto();
		dto27.setSumAmount(a2201d.add(a2501d).add(a2502d).add(a2101d));

		CashFlowStatementRespDto dto28 = new CashFlowStatementRespDto();
		dto28.setSumAmount(a2232d.add(a2231d).add(a4104d).add(a660306d));

		CashFlowStatementRespDto dto29 = new CashFlowStatementRespDto();
		dto29.setSumAmount(new Amount());
		CashFlowStatementRespDto dto30 = new CashFlowStatementRespDto();
		dto30.setSumAmount(dto27.getSumAmount().add(dto28.getSumAmount()).add(dto29.getSumAmount()));

		CashFlowStatementRespDto dto31 = new CashFlowStatementRespDto();
		dto31.setSumAmount(dto26.getSumAmount().subtract(dto30.getSumAmount()));
		CashFlowStatementRespDto dto32 = new CashFlowStatementRespDto();
		dto32.setSumAmount(new Amount());
		CashFlowStatementRespDto dto33 = new CashFlowStatementRespDto();
		dto33.setSumAmount(dto10.getSumAmount().add(dto22.getSumAmount()).add(dto31.getSumAmount()));
		CashFlowStatementRespDto dto34 = new CashFlowStatementRespDto();
		dto34.setSumAmount(map.get("1001").getOpeningBalance().add(map.get("1002").getOpeningBalance())
				.add(map.get("1012").getOpeningBalance()));
		CashFlowStatementRespDto dto35 = new CashFlowStatementRespDto();
		dto35.setSumAmount(dto33.getSumAmount().add(dto34.getSumAmount()));

		ModelAndView mav = new ModelAndView("report/cashFlowStatementGeneral");
		mav.addObject("dto1", dto1);
		mav.addObject("dto2", dto2);
		mav.addObject("dto3", dto3);
		mav.addObject("dto4", dto4);
		mav.addObject("dto5", dto5);
		mav.addObject("dto6", dto6);
		mav.addObject("dto7", dto7);
		mav.addObject("dto8", dto8);
		mav.addObject("dto9", dto9);
		mav.addObject("dto10", dto10);
		mav.addObject("dto11", dto11);
		mav.addObject("dto12", dto12);
		mav.addObject("dto13", dto13);
		mav.addObject("dto14", dto14);
		mav.addObject("dto15", dto15);
		mav.addObject("dto16", dto16);
		mav.addObject("dto17", dto17);
		mav.addObject("dto18", dto18);
		mav.addObject("dto19", dto19);
		mav.addObject("dto20", dto20);
		mav.addObject("dto21", dto21);
		mav.addObject("dto22", dto22);
		mav.addObject("dto23", dto23);
		mav.addObject("dto24", dto24);
		mav.addObject("dto25", dto25);
		mav.addObject("dto26", dto26);
		mav.addObject("dto27", dto27);
		mav.addObject("dto28", dto28);
		mav.addObject("dto29", dto29);
		mav.addObject("dto30", dto30);
		mav.addObject("dto31", dto31);
		mav.addObject("dto32", dto32);
		mav.addObject("dto33", dto33);
		mav.addObject("dto34", dto34);
		mav.addObject("dto35", dto35);
		return mav;
	}

}
