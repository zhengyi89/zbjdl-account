<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.zbjdl.common.utils.config.TextResource" %>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>辅助核算余额表</title>
<script language="javascript" type="text/javascript" src="${resourcePath}/DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div id="content_2" class="content_wrapper">
		<div class="content_main">
			<div class="panel panel-default">
				<div class="panel-heading">内容筛选</div>
				<div class="panel-body">
					<form class="cmxform form-horizontal" action="${ctx}/report/assistAccountBalance" method="get"
						method="get" id="companyForm" name="companyForm">
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
								<div class="input-group">
									<input class="form-control form_datetime" type="text" id="startdate" name="startdate" readonly="readonly">
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			                    </div>
							</div>
							<label class="col-lg-2 control-label">会计期间（结束）</label>
							<div class="col-lg-3">
								<div class="input-group">
									<input class="form-control form_datetime" type="text" id="enddate" name="enddate" readonly="readonly">
				                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			                    </div>
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
						<q:table queryService="queryService" queryKey="queryAssistAccountBalance" formId="godownForma"
							class="table table-striped table-bordered" pageSize="20">
							<q:nodata>无符合条件的记录</q:nodata>
							<q:param name="systemCode" value="${SESSION_ACCOUNTINFO.systemCode}" />
				            <q:column title="客户" value="${account_period}" width="20%" />
				            <q:column title="期初余额(借方)" value="${serial_num}" width="20%" />
				            <q:column title="期初余额(贷方)" value="${summary}" width="20%" />
				            <q:column title="本期发生额(借方)" value="${amount}" width="20%" />
				            <q:column title="本期发生额(贷方)" value="${amount}" width="20%" />
				            <q:column title="期末余额(借方)" value="${balance_direct}" width="20%" />
				            <q:column title="期末余额(贷方)" value="" width="20%" />
						</q:table>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
  	</script>
</body>
</html>