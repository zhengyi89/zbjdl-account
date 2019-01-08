<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.zbjdl.common.utils.config.TextResource" %>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>总账</title>
<script language="javascript" type="text/javascript" src="${resourcePath}/DatePicker/WdatePicker.js"></script>

</head>
<body>
	<div id="content_2" class="content_wrapper">
		<div class="content_main">
			<div class="panel panel-default">
				<div class="panel-heading">内容筛选</div>
				<div class="panel-body">
					<form class="cmxform form-horizontal" action="${ctx}/company/index" method="get"
						method="get" id="companyForm" name="companyForm">
						<!-- 第一组查询条件 -->
						<div class="form-group">
							<label class="control-label col-lg-2">会计科目</label>
							<div class="col-lg-3">
								<input class="form-control" id="companyName" name="companyName" ></input>
							</div>
							
							<label for="customerType" class="control-label col-lg-2">会计期间（起始）</label>
							<div class="col-lg-4">
									<div class="input-group">
								<input id="datePicker" name="startdate" type="text" class="form-control" placeholder="" aria-describedby="basic-addon2" onclick="WdatePicker()">
				                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                    </div>
							</div>
							<label class="col-lg-2 control-label">会计期间（结束）</label>
							<div class="col-lg-4">
									<div class="input-group">
								<input id="datePicker" name="enddate" type="text" class="form-control" placeholder="" aria-describedby="basic-addon2" onclick="WdatePicker()">
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
						<q:table queryService="queryService" queryKey="queryCashFlowDetail" formId="godownForma"
							class="table table-striped table-bordered" pageSize="20">
							<q:nodata>无符合条件的记录</q:nodata>
							<q:param name="systemCode" value="${SESSION_ACCOUNTINFO.systemCode}" />
				            <q:column title="日期" value="${account_period}" width="20%" />
				            <q:column title="凭证" value="记-${serial_num}" width="20%" />
				            <q:column title="摘要" value="${summary}" width="20%" />
				            <q:column title="借方" value="${amount}" width="20%" />
				            <q:column title="贷方" value="${amount}" width="20%" />
				            <q:column title="方向" value="${balance_direct}" width="20%" />
				            <q:column title="余额" value="" width="20%" />
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
