<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.zbjdl.common.utils.config.TextResource"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>科目期初</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/BusinessCode.js"></script>
<script type="text/javascript" src="${resourcePath}/DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div id="content_2" class="content_wrapper">
	
		<div class="" >
			<div class="jumbotron">
		        <h1>尚未检查</h1>
		        <p>对要结账的期间做个检查吧-_- &nbsp;&nbsp;&nbsp; 
		        	<button type="button" id="checkButton"  class="btn btn-lg btn-info" onclick="check()">一键检查</button>
		        	<button type="button" id="settleButton" style="display:none" class="btn btn-lg btn-info" onclick="settle()">结账</button>
		        </p>
		      </div>
		</div>
		
		
		<div class="panel panel-danger">
            <div class="panel-heading">
              <h3 class="panel-title"><strong>异常项</strong> 尚未检查</h3>
            </div>
            <div class="panel-body"> 1.凭证漏审 </div>
            <div class="panel-body"> 2.结转损益 </div>
            <div class="panel-body"> 3.资产负债表 </div>
            <div class="panel-body"> 4.凭证断号 </div>
            <div class="panel-body"> 5.计提固定资产折旧 </div>
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
		function check(){
			$.ajax({
				type : 'GET',
				url : '${pageContext.request.contextPath}/accountSettle/check',
				async: false,
				success : function(data) {
					if(data.code=='0000'){
						$("#checkButton").attr("style","display:none");
						$("#settleButton").attr("style","");
					}else{
						
					}
				}
			});
		}
		
		function settle(){
			$.ajax({
				type : 'GET',
				url : '${pageContext.request.contextPath}/accountSettle/settle',
				async: false,
				success : function(data) {
					if(data.code=='0000'){
						$("#checkButton").attr("style","display:none");
						$("#settleButton").attr("style","");
					}else{
						
					}
				}
			});
		}
	
	
  </script>
</body>
</html>
