<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.zbjdl.common.utils.config.TextResource"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>科目期初</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/BusinessCode.js"></script>
<script type="text/javascript" src="${resourcePath}/DatePicker/WdatePicker.js"></script>
<style>
    div.selectBox{display:none;position:fixed;top:30%;left:30%;width:45%;height:250px;border:1px ;background-color:white;z-index:1002}
    div.shelter{display:none;position:fixed;top:0px;left:0px;width:100%;height:100%;background-color:black;opacity:0.6;z-index:1001}
</style>
</head>
<body>
	<div id="content_2" class="content_wrapper">
		<div class="content_main">
			<div class="panel panel-default">
				<div class="panel-heading">内容筛选</div>
				<div class="panel-body">
				<form class="cmxform form-horizontal" action="${pageContext.request.contextPath}/accountSettle/openingIndex" 
					method="get" id="godownForma" name="godownForma">
					<div class="form-group">
							<label class="col-lg-2 control-label">科目类别</label>
							<div class="col-lg-3">
								<select class="form-control" id="basicSubject" name="basicSubject">
									<script type="text/javascript">
										BusinessCode.getSysConfigCode("ACCOUNT_SUBJECT_TYPE ", "basicSubject", "$!{query.basicSubject}");
									</script>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-lg-12 align_center">
								<button class="btn btn-primary submit ml_20" type="submit">查 询</button>
								<button class="btn btn-primary submit ml_20" type="button" onclick="BusinessCode.clearAllInput('godownForma');">清空</button>
							</div>
						</div>
				</form>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">查询结果</div>
				<div class="panel-body">
					<div class="panel-table">
						<button class="btn btn-primary ml_20" onclick="trialBalance();">
							试算平衡
						</button>
						<button class="btn btn-default ml_20" type="submit">
							导入
						</button>
						<%-- <q:table queryService="queryService" queryKey="querySubjectList" formId="godownForma"
							class="table table-striped table-bordered" pageSize="100" showExpButton="true" contextUrl="${ctx}/bussinessCode/exportExcel"> --%>
						<q:table queryService="queryService" queryKey="querySubjectOpeningIndex" formId="godownForma"
							class="table table-striped table-bordered" pageSize="40" showExpButton="true" contextUrl="${ctx}/bussinessCode/exportExcel">
							<q:nodata>无符合条件的记录</q:nodata>
							<q:param name="systemCode" value="${SESSION_ACCOUNTINFO.systemCode}" />
							<q:param name="accountMonth" value="${SESSION_ACCOUNTINFO.startMonth}" />
				            <q:column title="科目编码" value="${subject_code}" width="20%" dataIndex="subject_code"/>
				            <q:column title="名称" value="${subject_name}" width="20%" dataIndex="subject_name"/>
				            <q:column title="方向" value="${_textResource.getSysText('ACCOUNT_BALANCE_DIRECT', balance_direct)}" width="10%" dataIndex="balance_direct" showValueIndex="ACCOUNT_BALANCE_DIRECT"/>
				            <q:column title="辅助核算" value="${assist_account}" width="10%" dataIndex="assist_account"/>
				            <q:column title="期初余额（金额）" value="${opening_balance }" width="20%" />
				            <q:column title="本年累积借方（金额）" value="${year_debit_amount }" width="20%" />
				            <q:column title="本年累积贷方（金额）" value="${year_credit_amount }" width="20%" />
				            <q:column title="年初余额（金额）" value="${year_opening_balance }" width="20%" />
				            <q:column title="操作" escapeHtml="false" width="20%">
				            	<c:if test="${last_level }">
				            		<a class="pink" onclick="window.location.href='${ctx}/accountSettle/subjectOpeningEdit/index?subjectId=${subject_id }&id=${id}&assistAccount=${assist_account }'">设置</a>
				            	</c:if>
				            	
							</q:column>
						</q:table>
					</div>
					
				</div>
			</div>
			<div id="selectBox" class="selectBox">
		        <h3>试算平衡：</h3>
		        <div id="succDiv" class="alert alert-success" role="alert">
			        恭喜您，录入的初始余额平衡！
			    </div>
			    <div id="errDiv" class="alert alert-danger" role="alert">
			    	您录入的初始余额不平衡！
			    </div>
			    <div class="col-md-9">
		          <table class="table">
		            <thead>
		              <tr>
		                <th>项目</th>
		        		<th>借方金额</th>
		        		<th>贷方金额</th>
		        		<th>差额</th>
		              </tr>
		            </thead>
		            <tbody>
		              <tr>
		                <td>期初余额️</td>
		        		<td id="sumDebitOpeningAmount"></td>
		        		<td id="sumCreditOpeningAmount"></td>
		        		<td id="diff"></td>
		              </tr>
		              <tr>
		                <td>本年累积发生额</td>
		        		<td id="sumYearDebitAmount"></td>
		        		<td id="sumYearCreditAmount"></td>
		        		<td id="diffYear"></td>
		              </tr>
		            </tbody>
		          </table>
		        </div>
		    </div>
		    <div id="shelter" class="shelter" onclick="cancel()"></div>
		</div>
	</div>
	<!--  end -->
	<script type="text/javascript">
		function trialBalance(){
			$.ajax({
				type : 'GET',
				url : '${pageContext.request.contextPath}/accountSettle/trialBalance',
				async: false,
				success : function(data) {
					if(data.code=='0000'){
						//console.log('result:'+data.sumDebitAmount.value);
						var v_diff = data.sumCreditOpeningAmount.value-data.sumDebitOpeningAmount.value;
						var v_diffYear = data.sumYearCreditAmount.value-data.sumYearDebitAmount.value;
						$("#sumCreditOpeningAmount").html(data.sumCreditOpeningAmount.value);
						$("#sumDebitOpeningAmount").html(data.sumDebitOpeningAmount.value);
						$("#diff").html(v_diff);
						$("#sumYearCreditAmount").html(data.sumYearCreditAmount.value);
						$("#sumYearDebitAmount").html(data.sumYearDebitAmount.value);
						$("#diffYear").html(v_diffYear);
						if(v_diff==0 && v_diffYear==0){
							$("#errDiv").attr("hidden","true");
							$("#succDiv").removeAttr("hidden");
						}else{
							$("#succDiv").attr("hidden","true");
							$("#errDiv").removeAttr("hidden");
						}
						showSelectBox();
					}else{
						
					}
				}
			});
		}
		
		function showSelectBox() {
            document.getElementById("selectBox").style.display = "block";
            document.getElementById("shelter").style.display = "block";
        }
        function cancel() {
            document.getElementById("selectBox").style.display = "none";
            document.getElementById("shelter").style.display = "none";
        }
	
  	</script>
</body>
</html>
