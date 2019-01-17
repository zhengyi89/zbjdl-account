<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.zbjdl.common.utils.config.TextResource"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>期末结账</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/BusinessCode.js"></script>
<script type="text/javascript" src="${resourcePath}/DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div id="content_2" class="content_wrapper">
	
		<div class="" >
			<div class="jumbotron" style="padding-top: 4px;padding-bottom: 4px;">
		        <h1>尚未检查</h1>
		        <p>对要结账的期间做个检查吧-_- &nbsp;&nbsp;&nbsp; 
		        	<button type="button" id="checkButton"  class="btn btn-lg btn-info" onclick="check()">一键检查</button>
		        	<button type="button" id="settleButton" style="display:none" class="btn btn-lg btn-info" onclick="settle()">结账</button>
		        	<span id="succ" hidden style="color:RED">已结账</span>
		        </p>
		      </div>
		</div>
		
		
		<div class="panel panel-danger">
            <div class="panel-heading">
              <h3 class="panel-title"><strong>异常项</strong> 尚未检查</h3>
            </div>
            <div class="panel-body"> 1.凭证漏审 <span style="margin-left: 80%" id="voucherAuditFlag"></span></div>
            <div class="panel-body"> 2.结转损益 <span style="margin-left: 80%" id="profitLossFlag"></span> </div>
            <div class="panel-body"> 3.资产负债表 <span style="margin-left: 80%" id="balanceSheetFlag"></span> </div>
            <div class="panel-body"> 4.凭证断号  <span style="margin-left: 80%" id="vocherSerialNumFlag"></span></div>
            <div class="panel-body"> 5.计提固定资产折旧  <span style="margin-left: 75%" id="deprecitionFlag"></span></div>
          </div>
		
		
		<div class="panel panel-warning">
            <div class="panel-heading">
              <h3 class="panel-title"><strong>风险项</strong> 尚未检查</h3>
            </div>
            <div class="panel-body"> 1.往来挂账 </div>
            <div class="panel-body"> 2.库存现金 </div>
            <div class="panel-body"> 3.银行存款 </div>
            <div class="panel-body"> 4.原材料 </div>
            <div class="panel-body"> 5.库存商品 </div>
            <div class="panel-body"> 6.长期待摊费用 </div>
          </div>
      	
		
	</div>
	<!--  end -->
	<script type="text/javascript">
	
		$(function(){
			if(${SESSION_ACCOUNTINFO.accountStatus}){
				$("#checkButton").attr("style","display:none");
				$("#settleButton").attr("style","display:none");
				$("#succ").removeAttr("hidden");
			}
		})
	
		function check(){
			$.ajax({
				type : 'GET',
				url : '${pageContext.request.contextPath}/accountSettle/check',
				async: false,
				success : function(data) {
					console.log("===="+data.code);
					if(data.code=='0000'){
						$("#checkButton").attr("style","display:none");
						$("#settleButton").attr("style","");
						$('h1').html("检查成功");
					}else{
						$('h1').html("检查失败");
					}
					showResult(data);
				}
			});
		}
		
		function showResult(data){
			if(!data.vocherSerialNumFlag){
				$("#vocherSerialNumFlag").text("有断号");
			}else{
				$("#vocherSerialNumFlag").text("无断号");
			}
			if(!data.voucherAuditFlag){
				$("#voucherAuditFlag").text("有漏审");
			}else{
				$("#voucherAuditFlag").text("无漏审");
			}
			if(!data.balanceSheetFlag){
				$("#balanceSheetFlag").text("不平衡");
			}else{
				$("#balanceSheetFlag").text("平衡");
			}
			if(!data.deprecitionFlag){
				$("#deprecitionFlag").text("未计提");
			}else{
				$("#deprecitionFlag").text("已计提");
			}
			if(!data.profitLossFlag){
				$("#profitLossFlag").text("未结转");
			}else{
				$("#profitLossFlag").text("已结转");
			}
			
		}
		
		function settle(){
			$.ajax({
				type : 'GET',
				url : '${pageContext.request.contextPath}/accountSettle/settle',
				async: false,
				success : function(data) {
					if(data.code=='0000'){
						$("#checkButton").attr("style","display:none");
						$("#settleButton").attr("style","display:none");
						$("#succ").removeAttr("hidden");
					}
				}
			});
		}
	
	
  </script>
</body>
</html>
