<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.zbjdl.common.utils.config.TextResource" %>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>科目余额表</title>
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
					<form class="cmxform form-horizontal" action="${ctx}/report/subjectBalance" method="get"
						method="get" id="companyForm" name="companyForm">
						<div class="form-group">
							<label class="control-label col-lg-2">会计期间（起始）</label>
							<div class="col-lg-3">
								<select class="form-control" id="startdate" name="startdate">
									<c:forEach items="${SESSION_ACCOUNTINFO.dateSet}" var="date">
										<option value="${date}" <c:if test="${date == startdate}">selected</c:if>>
											${date } 
										</option>
									</c:forEach>
								</select>
							</div>
							
							<label class="col-lg-2 control-label">会计期间（结束）</label>
							<div class="col-lg-3">
								<select class="form-control" id="enddate" name="enddate">
									<c:forEach items="${SESSION_ACCOUNTINFO.dateSet}" var="date">
										<option value="${date}" <c:if test="${date == enddate }">selected</c:if>>
											${date } 
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
						<q:table queryService="queryService" queryKey="querySubjectBalance" formId="godownForma"
							class="table table-striped table-bordered" pageSize="100" showExpButton="true" contextUrl="${ctx}/bussinessCode/exportExcel">
							<q:nodata>无符合条件的记录</q:nodata>
							<q:param name="systemCode" value="${SESSION_ACCOUNTINFO.systemCode}" />
				            <q:column title="科目编码" value="${subject_code}" width="20%" dataIndex="subject_code"/>
				            <q:column title="科目名称" value="${subject_name}" width="20%" dataIndex="subject_name"/>
				            <q:column title="借方（期初）" value="${opening_debit_amount}" width="20%" dataIndex="opening_debit_amount"/>
				            <q:column title="贷方（期初）" value="${opening_credit_amount}" width="20%" dataIndex="opening_credit_amount"/>
				            <q:column title="借方（本期发生额）" value="${debit_amount}" width="20%" dataIndex="debit_amount"/>
				            <q:column title="贷方（本期发生额）" value="${credit_amount}" width="20%" dataIndex="credit_amount"/>
				            <q:column title="借方（期末）" value="${closing_debit_amount}" width="20%" dataIndex="closing_debit_amount"/>
				            <q:column title="贷方（期末）" value="${closing_credit_amount}" width="20%" dataIndex="closing_credit_amount"/>
						</q:table>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			if(${!paramInit}){
				$('#companyForm').submit();
			}
		})
  	</script>
</body>
</html>
