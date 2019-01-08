<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.zbjdl.common.utils.config.TextResource" %>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>折旧明细</title>
<script language="javascript" type="text/javascript" src="${resourcePath}/DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div id="content_2" class="content_wrapper">
		<div class="content_main">
			<div class="panel panel-default">
				<div class="panel-heading">内容筛选</div>
				<div class="panel-body">
				<form id="changeStatusForm" action="" method="post">
			      <input type="hidden" id="id" name="id" value=""/>
				</form>
				
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">查询结果</div>
				<div class="panel-body">
					<div class="panel-table">
						<a href="${pageContext.request.contextPath}/asset/edit/index?costType=DEPRECITION">
						</a>
						<q:table queryService="queryService" queryKey="queryAssetDeprecitionRecord" formId="godownForma"
							class="table table-striped table-bordered" pageSize="20">
							<q:nodata>无符合条件的记录</q:nodata>
							<q:param name="systemCode" value="${SESSION_ACCOUNTINFO.systemCode}" />
				            <q:column title="期数" value="${deprecition_month}" width="20%" />
				            <q:column title="类别" value="${asset_class_name}" width="20%" />
				            <q:column title="编码" value="${asset_code}" width="20%" />
				            <q:column title="名称" value="${asset_name}" width="20%" />
				            <q:column title="原值" value="${initial_worth}" width="20%" />
				            <q:column title="期末累积折旧" value="${initial_worth.subtract(closing_net_worth)}" width="20%" />
				            <q:column title="期末净值" value="${closing_net_worth}" width="20%" />
						</q:table>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<!--  end -->
	<script type="text/javascript">
    $(function(){
      
    });
  </script>
</body>
</html>
