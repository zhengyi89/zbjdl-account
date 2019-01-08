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
	                <td><span style="padding-left: 4%">销售产成品、商品、提供劳务收到的现金</span></td><td>1</td>
	                <td id="11">${dto["5001"].sumYearAmount.add(dto["1122"].sumYearAmount).add(dto["1121"].sumYearAmount).add(dto["2203"].sumYearAmount).add(dto["222101"].sumYearAmount) }</td>
	                <td id="12">${dto["5001"].sumAmount.add(dto["1122"].sumAmount).add(dto["1121"].sumAmount).add(dto["2203"].sumAmount).add(dto["222101"].sumAmount) }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">收到其他与经营活动有关的现金</span></td><td>2</td>
	                <td id="21">${dto["5301"].sumYearAmount.add(dto["5051"].sumYearAmount).add(dto["560305"].sumYearAmount).add(dto["1221"].sumYearAmount).add(dto["2241"].sumYearAmount) }</td>
	                <td id="22">${dto["5301"].sumAmount.add(dto["5051"].sumAmount).add(dto["560305"].sumAmount).add(dto["1221"].sumAmount).add(dto["2241"].sumAmount) }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">购买原材料、商品、接受劳务支付的现金</span></td><td>3</td>
	                <td id="31">${dto["1403"].sumYearAmount.add(dto["1405"].sumYearAmount).add(dto["5401"].sumYearAmount).add(dto["5402"].sumYearAmount).add(dto["2201"].sumYearAmount).add(dto["2202"].sumYearAmount).add(dto["1123"].sumYearAmount).add(dto["222101"].sumYearAmount) }</td>
	                <td id="32">${dto["1403"].sumAmount.add(dto["1405"].sumAmount).add(dto["5401"].sumAmount).add(dto["5402"].sumAmount).add(dto["2201"].sumAmount).add(dto["2202"].sumAmount).add(dto["1123"].sumAmount).add(dto["222101"].sumAmount) }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">支付的职工薪酬</span></td><td>4</td>
	                 <td id="41">${dto["2211"].sumYearAmount.add(dto["560207"].sumYearAmount) }</td>
	                 <td id="42">${dto["2211"].sumAmount.add(dto["560207"].sumAmount) }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">支付的税费</span></td><td>5</td>
	                 <td id="51">${dto["2221"].sumYearAmount.subtract(dto["222101"].sumYearAmount).add(dto["5403"].sumYearAmount) }</td>
	                 <td id="52">${dto["2221"].sumAmount.subtract(dto["222101"].sumAmount).add(dto["5403"].sumAmount) }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">支付其他与经营活动有关的现金</span></td><td>6</td>
	                <td id="61">${dto["5711"].sumYearAmount.add(dto["5602"].sumYearAmount).subtract(dto["560207"].sumYearAmount).add(dto["560306"].sumYearAmount).add(dto["1221"].sumYearAmount).add(dto["2241"].sumYearAmount) }</td>
	                <td id="62">${dto["5711"].sumAmount.add(dto["5602"].sumAmount).subtract(dto["560207"].sumAmount).add(dto["560306"].sumAmount).add(dto["1221"].sumAmount).add(dto["2241"].sumAmount) }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">经营活动产生的现金流量净额</span></td><td>7</td>
	                 <td id="71"></td>
	                 <td id="72"></td>
	              </tr>
	              <tr>
	                <td>二、投资活动产生的现金流量：</td><td></td><td></td><td></td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">收回短期投资、长期债券投资和长期股权投资收到的现金</span></td><td>8</td>
	                <td id="81">${dto["1101"].sumYearAmount.add(dto["1501"].sumYearAmount).add(dto["1511"].sumYearAmount) }</td>
	                <td id="82">${dto["1101"].sumAmount.add(dto["1501"].sumAmount).add(dto["1511"].sumAmount) }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">取得投资收益收到的现金</span></td><td>9</td>
	                <td id="91">${dto["5111"].sumYearAmount.add(dto["1131"].sumYearAmount).add(dto["1132"].sumYearAmount) }</td>
	                <td id="92">${dto["5111"].sumAmount.add(dto["1131"].sumAmount).add(dto["1132"].sumAmount) }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">处置固定资产、无形资产和其他非流动资产收回的现金净额</span></td><td>10</td>
	                <td id="101">${dto["1606"].sumYearAmount.add(dto["1701"].sumYearAmount).add(dto["1621"].sumYearAmount) }</td>
	                <td id="102">${dto["1606"].sumAmount.add(dto["1701"].sumAmount).add(dto["1621"].sumAmount) }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">短期投资、长期债券投资和长期股权投资支付的现金</span></td><td>11</td>
	                <td id="111">${dto["1101"].sumYearAmount.add(dto["1501"].sumYearAmount).add(dto["1511"].sumYearAmount) }</td>
	                <td id="112">${dto["1101"].sumAmount.add(dto["1501"].sumAmount).add(dto["1511"].sumAmount) }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">购建固定资产、无形资产和其他非流动资产支付的现金</span></td><td>12</td>
	                <td id="121">${dto["1601"].sumYearAmount.add(dto["1604"].sumYearAmount).add(dto["1621"].sumYearAmount) }</td>
	                <td id="122">${dto["1601"].sumAmount.add(dto["1604"].sumAmount).add(dto["1621"].sumAmount) }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">投资活动产生的现金流量净额</span></td><td>13</td><td id="131"></td><td id="132"></td>
	              </tr>
	              <tr>
	                <td>三、筹资活动产生的现金流量：</td><td></td><td></td><td></td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">取得借款收到的现金</span></td><td>14</td>
	                <td id="141">${dto["2001"].sumYearAmount.add(dto["2501"].sumYearAmount) }</td>
	                <td id="142">${dto["2001"].sumAmount.add(dto["2501"].sumAmount) }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">吸收投资者投资收到的现金</span></td><td>15</td>
	                <td id="151">${dto["3001"].sumYearAmount.add(dto["3002"].sumYearAmount) }</td>
	                <td id="152">${dto["3001"].sumAmount.add(dto["3002"].sumAmount) }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">偿还借款本金支付的现金</span></td><td>16</td>
	                <td id="161">${dto["2001"].sumYearAmount.add(dto["2501"].sumYearAmount) }</td>
	                <td id="162">${dto["2001"].sumAmount.add(dto["2501"].sumAmount) }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">偿还借款利息支付的现金</span></td><td>17</td>
	                <td id="171">${dto["560306"].sumYearAmount.add(dto["2231"].sumYearAmount) }</td>
	                <td id="172">${dto["560306"].sumAmount.add(dto["2231"].sumAmount) }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">分配利润支付的现金</span></td><td>18</td>
	                <td id="181">${dto["2232"].sumYearAmount }</td>
	                <td id="182">${dto["2232"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">筹资活动产生的现金流量净额</span></td><td>19</td><td id="191"></td><td id="192"></td>
	              </tr>
	              <tr>
	                <td>四、现金净增加额</td><td>20</td><td id="201"></td><td id="202"></td>
	              </tr>
	              <tr>
	                <td>加：期初现金余额</td><td>21</td>
	                <td id="211">${dto["1001"].sumYearAmount.add(dto["1002"].sumYearAmount) }</td>
	                <td id="212">${dto["1001"].sumAmount.add(dto["1002"].sumAmount) }</td>
	              </tr>
	              <tr>
	                <td>五、期末现金余额</td><td>22</td><td id="221"></td><td id="222"></td>
	              </tr>
	            </tbody>
	          </table>
        </div>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		var v_71 = Number($("#11").text())+Number($("#21").text())-Number($("#31").text())-Number($("#41").text())-Number($("#51").text())-Number($("#61").text());
		$("#71").text(v_71.toFixed(2));
		var v_131 = Number($("#81").text())+Number($("#91").text())+Number($("#101").text())-Number($("#111").text())-Number($("#121").text());
		$("#131").text(v_131.toFixed(2));
		var v_191 = Number($("#141").text())+Number($("#151").text())-Number($("#161").text())-Number($("#171").text())-Number($("#181").text());
		$("#191").text(v_191.toFixed(2));
		$("#221").text(Number($("#211").text())+Number($("#201").text()));
		
		
		var v_72 = Number($("#11").text())+Number($("#22").text())-Number($("#32").text())-Number($("#42").text())-Number($("#52").text())-Number($("#62").text());
		$("#72").text(v_72.toFixed(2));
		var v_132 = Number($("#82").text())+Number($("#92").text())+Number($("#102").text())-Number($("#112").text())-Number($("#122").text());
		$("#132").text(v_132.toFixed(2));
		var v_192 = Number($("#142").text())+Number($("#152").text())-Number($("#162").text())-Number($("#172").text())-Number($("#182").text());
		$("#192").text(v_192.toFixed(2));
		$("#222").text(Number($("#212").text())+Number($("#202").text()));
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
