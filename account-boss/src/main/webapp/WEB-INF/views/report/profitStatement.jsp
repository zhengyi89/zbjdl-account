<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.zbjdl.common.utils.config.TextResource" %>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>总账</title>
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
	                <td>一、营业收入</td><td>1</td><td id="11">${dto["5001"].sumYearAmount.add(dto["5051"].sumYearAmount)  }</td><td id="12">${dto["5001"].sumAmount.add(dto["5051"].sumAmount)  }</td>
	              </tr>
	              <tr>
	                <td>减：营业成本</td><td>2</td><td id="21">${dto["5401"].sumYearAmount.add(dto["5402"].sumYearAmount)  }</td><td id="22">${dto["5401"].sumAmount.add(dto["5402"].sumAmount)  }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">营业税金及附加</span></td><td>3</td><td id="31">${dto["5403"].sumYearAmount }</td><td id="32">${dto["5403"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">其中：消费税</span></td><td>4</td><td id="41">${dto["540301"].sumYearAmount }</td><td id="42">${dto["540301"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 20%">营业税</span></td><td>5</td><td>${dto["540302"].sumYearAmount }</td><td>${dto["540302"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 20%">城市维护建设税</span></td><td>6</td><td>${dto["540303"].sumYearAmount }</td><td>${dto["540303"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 20%">资源税</span></td><td>7</td><td>${dto["540304"].sumYearAmount }</td><td>${dto["540304"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 20%">土地增值税</span></td><td>8</td><td>${dto["540305"].sumYearAmount }</td><td>${dto["540305"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 20%">城镇土地使用税、房产税、车船税、印花税</span></td><td>9</td><td>${dto["540306"].sumYearAmount.add(dto["540307"].sumYearAmount).add(dto["540308"].sumYearAmount).add(dto["540309"].sumYearAmount) }</td><td>${dto["540306"].sumAmount.add(dto["540307"].sumAmount).add(dto["540308"].sumAmount).add(dto["540309"].sumAmount) }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 20%">教育费附加、矿产资源、排污费</span></td><td>10</td><td>${dto["540310"].sumYearAmount.add(dto["540311"].sumYearAmount).add(dto["540312"].sumYearAmount) }</td><td>${dto["540310"].sumAmount.add(dto["540311"].sumAmount).add(dto["540312"].sumAmount) }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">销售费用</span></td><td>11</td><td id="111">${dto["5601"].sumYearAmount }</td><td id="112">${dto["5601"].sumAmount }</td>
	              </tr>
	              
	              <tr>
	                <td><span style="padding-left: 10%">其中：商品维修费</span></td><td>12</td><td>${dto["560102"].sumYearAmount }</td><td>${dto["560102"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 20%">广告费和业务宣传费</span></td><td>13</td><td>${dto["560107"].sumYearAmount }</td><td>${dto["560107"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">管理费用</span></td><td>14</td><td  id="141">${dto["5602"].sumYearAmount }</td><td  id="142">${dto["5602"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">其中：开办费</span></td><td>15</td><td>${dto["560201"].sumYearAmount }</td><td>${dto["560201"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 20%">业务招待费</span></td><td>16</td><td>${dto["560208"].sumYearAmount }</td><td>${dto["560208"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 20%">研究费用</span></td><td>17</td><td>${dto["560209"].sumYearAmount }</td><td>${dto["560209"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">财务费用</span></td><td>18</td><td  id="181">${dto["5603"].sumYearAmount }</td><td  id="182">${dto["5603"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">其中：利息费用（收入以“-”号填列）</span></td><td>19</td><td>${dto["560301"].sumYearAmount.add(dto["560305"].sumYearAmount).add(dto["560306"].sumYearAmount) }</td><td>${dto["560301"].sumAmount.add(dto["560305"].sumAmount).add(dto["560306"].sumAmount) }</td>
	              </tr>
	              <tr>
	                <td>加：投资收益（损失以“-”号填列）</td><td>20</td><td id="201">${dto["5111"].sumYearAmount }</td><td id="202">${dto["5111"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td>二、营业利润（亏损以“-”号填列）</td><td>21</td><td id="211">${dto["5301"].sumYearAmount }</td><td id="212">${dto["5301"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td>加：营业外收入</td><td>22</td><td id="221">${dto["5301"].sumYearAmount }</td><td id="222">${dto["5301"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">其中：政府补助</span></td><td>23</td><td>${dto["530102"].sumYearAmount }</td><td>${dto["530102"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td>减：营业外支出</td><td>24</td><td id="241">${dto["5711"].sumYearAmount }</td><td id="242">${dto["5711"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 20%">其中：坏账损失</span></td><td>25</td><td>${dto["571103"].sumYearAmount }</td><td>${dto["571103"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 20%">无法收回的长期债券投资损失</span></td><td>26</td><td>${dto["571104"].sumYearAmount }</td><td>${dto["571104"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 20%">无法收回的长期股权投资损失</span></td><td>27</td><td>${dto["571105"].sumYearAmount }</td><td>${dto["571105"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 20%">自然灾害等不可抗力因素造成的损失</span></td><td>28</td><td>${dto["5711"].sumYearAmount }</td><td>${dto["5711"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 20%">税收滞纳金</span></td><td>29</td><td>${dto["571106"].sumYearAmount }</td><td>${dto["571106"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td>三、利润总额（亏损总额以“-”号填列）</td><td>30</td><td id="301">${dto["571107"].sumYearAmount }</td><td id="302">${dto["571107"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td>减：所得税费用</td><td>31</td><td id="311">${dto["5801"].sumYearAmount }</td><td id="312">${dto["5801"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td>四、净利润（净亏损以“-”号填列）</td><td>32</td><td id="321"></td><td id="322"></td>
	              </tr>
	              
	            </tbody>
	          </table>
        </div>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		
		var v_211 = Number($("#11").text())-Number($("#21").text())-Number($("#31").text())-Number($("#111").text())-Number($("#141").text())-Number($("#181").text())+Number($("#201").text());
		$("#211").text(v_211.toFixed(2));
		var v_212 = Number($("#12").text())-Number($("#22").text())-Number($("#32").text())-Number($("#112").text())-Number($("#142").text())-Number($("#182").text())+Number($("#202").text());
		$("#212").text(v_212.toFixed(2));
		
		var v_301 = Number($("#211").text())+Number($("#221").text())-Number($("#241").text());
		var v_302 = Number($("#212").text())+Number($("#222").text())-Number($("#242").text());
		$("#301").text(v_301.toFixed(2));
		$("#302").text(v_302.toFixed(2));
		
		$("#321").text(Number($("#301").text())-Number($("#311").text()));
		$("#322").text(Number($("#302").text())-Number($("#312").text()));
		
	})
	
	
	
	$('.form_datetime').datetimepicker({
        format: 'yyyy-mm',
        autoclose: true,
        todayBtn: true,
        startView: 'year',
        minView:'year',
        maxView:'decade',
        language:  'zh-CN',
    });
  	</script>
</body>
</html>
