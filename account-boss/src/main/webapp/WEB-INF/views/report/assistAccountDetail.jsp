<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.zbjdl.common.utils.config.TextResource" %>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>辅助核算明细表</title>
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
				<div class="panel-body">
					<form class="cmxform form-horizontal" action="${ctx}/report/assistAccountDetail" method="get"
						method="get" id="companyForm" name="companyForm">
						<!-- 第一组查询条件 -->
						<div class="form-group">
							<label class="control-label col-lg-2">会计科目</label>
							<div class="col-lg-3">
								<select class="form-control" id="subjectCode" name="subjectCode">
									<c:forEach items="${subjectList}" var="subject">
										<option value="${subject.subjectCode}" <c:if test="${!subject.lastLevel }">disabled</c:if> <c:if test="${subject.subjectCode == subjectCode }">selected</c:if>>
											${subject.subjectCode } ${subject.subjectName }
										</option>
									</c:forEach>
								</select>
							</div>
							<label class="control-label col-lg-2">客户</label>
							<div class="col-lg-3">
								<select class="form-control" id="assistCode" name="assistCode">
									<option value="">所有</option>
									<c:forEach items="${assistList}" var="assist">
										<option value="${assist.assistCode}" <c:if test="${assist.assistCode == assistCode }">selected</c:if>>
											${assist.assistCode } ${assist.assistName }
										</option>
									</c:forEach>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-lg-2">会计期间（起始）</label>
							<div class="col-lg-3">
								<select class="form-control" id="startdate" name="startdate">
									<c:forEach items="${dateMap}" var="date">
										<option value="${date.key}" <c:if test="${date.key == startdate }">selected</c:if>>
											${date.value } 
										</option>
									</c:forEach>
								</select>
							</div>
							
							<label class="col-lg-2 control-label">会计期间（结束）</label>
							<div class="col-lg-3">
								<select class="form-control" id="enddate" name="enddate">
									<c:forEach items="${dateMap}" var="date">
										<option value="${date.key}" <c:if test="${date.key == startdate }">selected</c:if>>
											${date.value } 
										</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-11 align_center">
								<a onclick="document.getElementById('companyForm').submit();">
									<button class="btn btn-primary submit ml_20" type="submit">查 询</button>
								</a>
								<a onclick="clearAllInput('companyForm');">
									<button class="btn btn-default button" type="button">清 除</button>
								</a>
							</div>
						</div>
					</form>
				</div>
			</div>
			
			<div class="panel panel-default">
				<div class="panel-heading">查询结果</div>
				<div class="panel-body">
					<div class="panel-table">
						<q:table id="tab" queryService="queryService" queryKey="queryAssistAccountDetail" formId="godownForma"
							class="table table-striped table-bordered" pageSize="20">
							<q:nodata>无符合条件的记录</q:nodata>
							<q:param name="systemCode" value="${SESSION_ACCOUNTINFO.systemCode}" />
				            <q:column title="日期" value="${account_period}" width="20%" />
				            <q:column title="凭证" value="记-${serial_num}" width="20%" />
				            <q:column title="摘要" value="${summary}" width="20%" />
				            <q:column title="借方" value="${debit_amount}" width="20%" />
				            <q:column title="贷方" value="${credit_amount}" width="20%" />
				            <q:column title="方向" value="${_textResource.getSysText('ACCOUNT_BALANCE_DIRECT', balance_direct)}" width="20%" />
				            <q:column title="实际发生额" value="${amount}" width="20%" hidden=""/>
				            <q:column title="余额" value="" width="20%" /> 
						</q:table>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	
	
	$(function(){
		
		var v_opening_amount = ${openingBalance};
		console.log('-------'+v_opening_amount);
		var v_amount;
		
		$('#tab tr').each(function(i){ // 遍历 tr
			$(this).children('td').each(function(j){  // 遍历 tr 的各个 td
				//console.log("第"+(i+1)+"行，第"+(j+1)+"个td的值："+$(this).text()+"。");
				
				if(j==6){
					v_amount = $(this).text();
				}
				if(j==7){
					v_opening_amount = v_opening_amount-v_amount;
					$(this).text(v_opening_amount.toFixed(2))
					
				}
			});
		});
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
