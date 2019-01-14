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
	                <td>${dto1.sumYearAmount}</td>
	                <td>${dto1.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">收到其他与经营活动有关的现金</span></td><td>2</td>
	                <td>${dto2.sumYearAmount}</td>
	                <td>${dto2.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">购买原材料、商品、接受劳务支付的现金</span></td><td>3</td>
	                <td>${dto3.sumYearAmount}</td>
	                <td>${dto3.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">支付的职工薪酬</span></td><td>4</td>
	                <td>${dto4.sumYearAmount}</td>
	                <td>${dto4.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">支付的税费</span></td><td>5</td>
	               	<td>${dto5.sumYearAmount}</td>
	                <td>${dto5.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">支付其他与经营活动有关的现金</span></td><td>6</td>
	                <td>${dto6.sumYearAmount}</td>
	                <td>${dto6.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">经营活动产生的现金流量净额</span></td><td>7</td>
	                <td>${dto7.sumYearAmount}</td>
	                <td>${dto7.sumAmount }</td>
	              </tr>
	              <tr>
	                <td>二、投资活动产生的现金流量：</td><td></td><td></td><td></td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">收回短期投资、长期债券投资和长期股权投资收到的现金</span></td><td>8</td>
	                <td>${dto8.sumYearAmount}</td>
	                <td>${dto8.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">取得投资收益收到的现金</span></td><td>9</td>
	                <td>${dto9.sumYearAmount}</td>
	                <td>${dto9.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">处置固定资产、无形资产和其他非流动资产收回的现金净额</span></td><td>10</td>
	                <td>${dto10.sumYearAmount}</td>
	                <td>${dto10.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">短期投资、长期债券投资和长期股权投资支付的现金</span></td><td>11</td>
	                <td>${dto11.sumYearAmount}</td>
	                <td>${dto11.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">购建固定资产、无形资产和其他非流动资产支付的现金</span></td><td>12</td>
	                <td>${dto12.sumYearAmount}</td>
	                <td>${dto12.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">投资活动产生的现金流量净额</span></td><td>13</td>
	                <td>${dto13.sumYearAmount}</td>
	                <td>${dto13.sumAmount }</td>
	              </tr>
	              <tr>
	                <td>三、筹资活动产生的现金流量：</td><td></td><td></td><td></td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">取得借款收到的现金</span></td><td>14</td>
	                <td>${dto14.sumYearAmount}</td>
	                <td>${dto14.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">吸收投资者投资收到的现金</span></td><td>15</td>
	                <td>${dto15.sumYearAmount}</td>
	                <td>${dto15.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">偿还借款本金支付的现金</span></td><td>16</td>
	                <td>${dto16.sumYearAmount}</td>
	                <td>${dto16.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">偿还借款利息支付的现金</span></td><td>17</td>
	                <td>${dto17.sumYearAmount}</td>
	                <td>${dto17.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">分配利润支付的现金</span></td><td>18</td>
	                <td>${dto18.sumYearAmount}</td>
	                <td>${dto18.sumAmount }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 4%">筹资活动产生的现金流量净额</span></td><td>19</td>
	                <td>${dto19.sumYearAmount}</td>
	                <td>${dto19.sumAmount }</td>
	              </tr>
	              <tr>
	                <td>四、现金净增加额</td><td>20</td>
	                <td>${dto20.sumYearAmount}</td>
	                <td>${dto20.sumAmount }</td>
	              </tr>
	              <tr>
	                <td>加：期初现金余额</td><td>21</td>
	                <td>${dto21.sumYearAmount}</td>
	                <td>${dto21.sumAmount }</td>
	              </tr>
	              <tr>
	                <td>五、期末现金余额</td><td>22</td>
	                <td>${dto22.sumYearAmount}</td>
	                <td>${dto22.sumAmount }</td>
	              </tr>
	            </tbody>
	          </table>
        </div>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		
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
