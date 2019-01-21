<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.zbjdl.common.utils.config.TextResource" %>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>利润表</title>
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
	                <td>一、营业收入</td><td>1</td>
	                <td id="11">${dto["6001"].yearCreditAmount.add(dto["6051"].yearCreditAmount).add(dto["6011"].yearCreditAmount).add(dto["6021"].yearCreditAmount).add(dto["6031"].yearCreditAmount).add(dto["6041"].yearCreditAmount) }</td>
	                <td id="12">${dto["6001"].creditAmount.add(dto["6051"].creditAmount).add(dto["6011"].yearCreditAmount).add(dto["6021"].yearCreditAmount).add(dto["6031"].yearCreditAmount).add(dto["6041"].yearCreditAmount)  }</td>
	              </tr>
	              <tr>
	                <td>减：营业成本</td><td>2</td>
	                <td id="21">${dto["6401"].sumYearAmount.add(dto["6402"].sumYearAmount).add(dto["6411"].sumYearAmount).add(dto["6421"].sumYearAmount)  }</td>
	                <td id="22">${dto["6401"].sumAmount.add(dto["6402"].sumAmount).add(dto["6411"].sumYearAmount).add(dto["6421"].sumYearAmount) }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">税金及附加</span></td><td>3</td><td id="31">${dto["6403"].sumYearAmount }</td><td id="32">${dto["6403"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">销售费用</span></td><td>4</td><td id="41">${dto["6601"].sumYearAmount }</td><td id="42">${dto["6601"].sumAmount }</td>
	              </tr>
	              
	              <tr>
	                <td><span style="padding-left: 10%">管理费用</span></td><td>5</td><td  id="51">${dto["6602"].sumYearAmount.add(dto["6604"].sumYearAmount) }</td><td  id="52">${dto["6602"].sumAmount.add(dto["6604"].sumYearAmount) }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">财务费用</span></td><td>6</td><td  id="61">${dto["6603"].sumYearAmount.add(dto["6061"].sumYearAmount) }</td><td  id="62">${dto["6603"].sumAmount.add(dto["6061"].sumYearAmount) }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">资产减值损失</span></td><td>7</td><td  id="71">${dto["6701"].sumYearAmount }</td><td  id="72">${dto["6701"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td>加：公允价值变动收益（损失以-填列）</td><td>8</td><td id="81">${dto["6101"].sumYearAmount }</td><td id="82">${dto["6101"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td>投资收益（损失以-填列）</td><td>9</td>
	                <td id="91">${dto["6111"].sumYearAmount.add(dto["6201"].sumYearAmount).add(dto["6202"].sumYearAmount).add(dto["6203"].sumYearAmount).subtract(dto["6501"].sumYearAmount).subtract(dto["6502"].sumYearAmount).subtract(dto["6511"].sumYearAmount).subtract(dto["6521"].sumYearAmount).subtract(dto["6531"].sumYearAmount).subtract(dto["6541"].sumYearAmount).subtract(dto["6542"].sumYearAmount) }</td>
	                <td id="92">${dto["6111"].sumYearAmount.add(dto["6201"].sumYearAmount).add(dto["6202"].sumYearAmount).add(dto["6203"].sumYearAmount).subtract(dto["6501"].sumYearAmount).subtract(dto["6502"].sumYearAmount).subtract(dto["6511"].sumYearAmount).subtract(dto["6521"].sumYearAmount).subtract(dto["6531"].sumYearAmount).subtract(dto["6541"].sumYearAmount).subtract(dto["6542"].sumYearAmount) }</td>
	              </tr>
	              <tr>
	                <td>其中：对联营企业和合营企业的投资收益</td><td>10</td><td id="101"></td><td id="102"></td>
	              </tr>
	              <tr>
	                <td>二、营业利润（亏损以“-”号填列）</td><td>11</td><td id="111"></td><td id="112"></td>
	              </tr>
	              <tr>
	                <td>加：营业外收入</td><td>12</td><td id="121">${dto["6301"].sumYearAmount }</td><td id="122">${dto["6301"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td>减：营业外支出</td><td>13</td><td id="131">${dto["6711"].sumYearAmount }</td><td id="132">${dto["6711"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 20%">其中：非流动资产处置损失</span></td><td>14</td><td id="142"></td><td id="142"></td>
	              </tr>
	              <tr>
	                <td>三、利润总额（亏损总额以“-”号填列）</td><td>15</td><td id="151"></td><td id="152"></td>
	              </tr>
	              <tr>
	                <td>减：所得税费用</td><td>16</td><td id="161">${dto["6801"].sumYearAmount }</td><td id="162">${dto["6801"].sumAmount }</td>
	              </tr>
	              <tr>
	                <td>四、净利润（净亏损以“-”号填列）</td><td>17</td><td id="171"></td><td id="172"></td>
	              </tr>
	              <tr>
	                <td>五、每股收益：</td><td>18</td><td id="181"></td><td id="182"></td>
	              </tr>
	              <tr>
	                <td>（一）基本每股收益</td><td>19</td><td id="191"></td><td id="192"></td>
	              </tr>
	              <tr>
	                <td>（二）稀释每股收益</td><td>20</td><td id="201"></td><td id="202"></td>
	              </tr>
	            </tbody>
	          </table>
        </div>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		
		var v_111 = Number($("#11").text())-Number($("#21").text())-Number($("#31").text())-Number($("#41").text())-Number($("#51").text())-Number($("#61").text())-Number($("#71").text())+Number($("#81").text())+Number($("#91").text());
		var v_151 = v_111.toFixed(2) + Number($("#121").text()) -Number($("#131").text());
		var v_171 = v_151.toFixed(2) - Number($("#161").text());
		$("#111").text(v_111.toFixed(2));
		$("#151").text(v_151.toFixed(2));
		$("#171").text(v_171.toFixed(2));
		
		
		
		var v_112 = Number($("#12").text())-Number($("#22").text())-Number($("#32").text())-Number($("#42").text())-Number($("#52").text())-Number($("#62").text())-Number($("#72").text())+Number($("#82").text())+Number($("#92").text());
		var v_152 = v_112.toFixed(2) + Number($("#122").text()) -Number($("#132").text());
		var v_172 = v_152.toFixed(2) - Number($("#162").text());
		$("#112").text(v_112.toFixed(2));
		$("#152").text(v_152.toFixed(2));
		$("#172").text(v_172.toFixed(2));
	})
	
	
  	</script>
</body>
</html>
