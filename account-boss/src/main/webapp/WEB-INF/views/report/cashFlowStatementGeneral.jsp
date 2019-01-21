<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.zbjdl.common.utils.config.TextResource" %>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>现金流量表</title>
<script language="javascript" type="text/javascript" src="${ctx}/static/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap-datetimepicker/js/bootstrap-datetimepicker.zh-CN.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css"/>
</head>
<body>
	<div id="content_2" class="content_wrapper">
		<div class="content_main">
			<div class="panel panel-default">
				<div class="panel-heading">内容筛选</div>
			</div>
			
			<div class="col-md-12" style="background-color: #fff;">
	          <table class="table table-bordered" >
	            <thead>
	              <tr>
	                <th>项目</th>
	                <th>行次</th>
	                <th>本年累积余额</th>
	                <th>本期金额</th>
	              </tr>
	            </thead>
	            <tbody>
	              <tr>
	                <td>一、经营活动产生的现金流量：</td><td></td><td></td><td></td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">销售商品、提供劳务收到的现金</span></td><td>1</td>
	                <td>${dto1.sumYearAmount}</td>
	                <td>${dto1.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">支付的税费返回</span></td><td>2</td>
	                <td>${dto2.sumYearAmount}</td>
	                <td>${dto2.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">收到其他与经营活动有关的现金</span></td><td>3</td>
	                <td>${dto3.sumYearAmount}</td>
	                <td>${dto3.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">经营活动现金流入小计</span></td><td>4</td>
	                <td>${dto4.sumYearAmount}</td>
	                <td>${dto4.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">购买商品、接受劳务支付的现金</span></td><td>5</td>
	               	<td>${dto5.sumYearAmount}</td>
	                <td>${dto5.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">支付给职工以及为职工支付的现金</span></td><td>6</td>
	                <td>${dto6.sumYearAmount}</td>
	                <td>${dto6.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">支付的各项税费</span></td><td>7</td>
	                <td>${dto7.sumYearAmount}</td>
	                <td>${dto7.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">支付其他与经营活动有关的现金</span></td><td>8</td>
	                <td>${dto8.sumYearAmount}</td>
	                <td>${dto8.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">经营活动现金流出小计</span></td><td>9</td>
	                <td>${dto9.sumYearAmount}</td>
	                <td>${dto9.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">经营活动产生的现金流量净额</span></td><td>10</td>
	                <td>${dto10.sumYearAmount}</td>
	                <td>${dto10.sumAmount }</td>
	              </tr>
	              <tr>
	                <td>二、投资活动产生的现金流量：</td><td></td><td></td><td></td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">收回投资收到的现金</span></td><td>11</td>
	                <td>${dto11.sumYearAmount}</td>
	                <td>${dto11.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">取得投资收益收到的现金</span></td><td>12</td>
	                <td>${dto12.sumYearAmount}</td>
	                <td>${dto12.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">处置固定资产、无形资产和其他长期资产收回的现金净额</span></td><td>13</td>
	                <td>${dto13.sumYearAmount}</td>
	                <td>${dto13.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">处置子公司及其他营业单位收到的现金净额</span></td><td>14</td>
	                <td>${dto14.sumYearAmount}</td>
	                <td>${dto14.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">收到其他与投资活动有关的现金</span></td><td>15</td>
	                <td>${dto15.sumYearAmount}</td>
	                <td>${dto15.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">投资活动现金流入小计</span></td><td>16</td>
	                <td>${dto16.sumYearAmount}</td>
	                <td>${dto16.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">购建固定资产、无形资产和其他长期资产支付的现金</span></td><td>17</td>
	                <td>${dto17.sumYearAmount}</td>
	                <td>${dto17.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">投资支付的现金</span></td><td>18</td>
	                <td>${dto18.sumYearAmount}</td>
	                <td>${dto18.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">取得子公司及其他营业单位支付的现金净额</span></td><td>19</td>
	                <td>${dto19.sumYearAmount}</td>
	                <td>${dto19.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">支付其他与投资活动有关的现金</span></td><td>20</td>
	                <td>${dto20.sumYearAmount}</td>
	                <td>${dto20.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">投资活动现金流出小计</span></td><td>21</td>
	                <td>${dto21.sumYearAmount}</td>
	                <td>${dto21.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">投资活动产生的现金流量净额</span></td><td>22</td>
	                <td>${dto22.sumYearAmount}</td>
	                <td>${dto22.sumAmount }</td>
	              </tr>
	              <tr>
	                <td>三、筹资活动产生的现金流量：</td><td></td><td></td><td></td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">吸收投资收到的现金</span></td><td>23</td>
	                <td>${dto23.sumYearAmount}</td>
	                <td>${dto23.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">取得借款收到的现金</span></td><td>24</td>
	                <td>${dto24.sumYearAmount}</td>
	                <td>${dto24.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">收到其他与筹资活动有关的现金</span></td><td>25</td>
	                <td>${dto25.sumYearAmount}</td>
	                <td>${dto25.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">筹资活动现金流入小计</span></td><td>26</td>
	                <td>${dto26.sumYearAmount}</td>
	                <td>${dto26.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">偿还债务支付的现金</span></td><td>27</td>
	                <td>${dto27.sumYearAmount}</td>
	                <td>${dto27.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">分配股利、利润或偿付利息支付的现金</span></td><td>28</td>
	                <td>${dto28.sumYearAmount}</td>
	                <td>${dto28.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">支付其他与筹资活动有关的现金</span></td><td>29</td>
	                <td>${dto29.sumYearAmount}</td>
	                <td>${dto29.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">筹资活动现金流出小计</span></td><td>30</td>
	                <td>${dto30.sumYearAmount}</td>
	                <td>${dto30.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">筹资活动产生的现金流量净额</span></td><td>31</td>
	                <td>${dto31.sumYearAmount}</td>
	                <td>${dto31.sumAmount }</td>
	              </tr>
	              <tr>
	                <td>四、汇率变动对现金及现金等价物的影响</td><td>32</td>
	                <td>${dto32.sumYearAmount}</td>
	                <td>${dto32.sumAmount }</td>
	              </tr>
	              <tr>
	                <td>五、现金入现金等价物净增加额</td><td>33</td>
	                <td>${dto33.sumYearAmount}</td>
	                <td>${dto33.sumAmount }</td>
	              </tr>
	              <tr>
	                <td>加：期初现金及现金等价物余额</td><td>34</td>
	                <td>${dto34.sumYearAmount}</td>
	                <td>${dto34.sumAmount }</td>
	              </tr>
	              <tr>
	                <td>六、期末现金及现金等价物余额</td><td>35</td>
	                <td>${dto35.sumYearAmount}</td>
	                <td>${dto35.sumAmount }</td>
	              </tr>
	            </tbody>
	          </table>
        </div>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		
	})
	
  	</script>
</body>
</html>
