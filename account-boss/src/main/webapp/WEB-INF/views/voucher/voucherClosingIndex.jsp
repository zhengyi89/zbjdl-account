<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.zbjdl.common.utils.config.TextResource"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>凭证列表</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/BusinessCode.js"></script>
<script type="text/javascript" src="${resourcePath}/DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div id="content_2" class="content_wrapper">
		<div class="content_main">
			<div class="panel panel-default">
				<div class="panel-heading">内容筛选</div>
				<div class="panel-body">
					<form class="cmxform form-horizontal" action="${pageContext.request.contextPath}/voucher/closingIndex" 
						method="get" id="godownForma" name="godownForma">
					</form>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">查询结果</div>
				<div class="panel-body">
					<div class="panel-table">
						<q:table queryService="queryService" queryKey="queryClosingVoucherList" formId="godownForma"
							class="table table-striped table-bordered" pageSize="40" showExpButton="true" contextUrl="${ctx}/bussinessCode/exportExcel">
							<q:nodata>无符合条件的记录</q:nodata>
							<q:column title="序号" value="${_rowstatus.globalIndex}" with="10％" />
				            <q:column title="模版名称" value="${template_name}" width="20%" />
				           
				            <q:column title="操作" escapeHtml="false" width="20%">
							    <a class="pink" onclick="window.location.href='${ctx}/voucher/useTemplate?id=${id}'">生成凭证</a>
							</q:column>
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
