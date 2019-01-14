<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.zbjdl.common.utils.config.TextResource" %>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>费用摊销</title>
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
						<a href="${pageContext.request.contextPath}/asset/edit/index?costType=EXPENSE">
							<button class="btn btn-primary submit" type="button">
								新 增<span class="content_blank_10"></span><span class="glyphicon glyphicon-plus"></span>
							</button>
						</a>
						<q:table queryService="queryService" queryKey="queryAssetList" formId="godownForma"
							class="table table-striped table-bordered" pageSize="20">
							<q:nodata>无符合条件的记录</q:nodata>
							<q:param name="systemCode" value="${SESSION_ACCOUNTINFO.systemCode}" />
							<q:param name="costType" value="EXPENSE" />
				            <q:column title="费用编号" value="${asset_code}" width="20%" />
				            <q:column title="费用名称" value="${asset_name}" width="20%" />
				            <q:column title="资产类别" value="${asset_class_name}" width="20%" />
				             <q:column title="增加日期"  width="20%" >
				            	<fmt:formatDate value="${begin_date}" pattern="yyyy-MM-dd" />
				            </q:column>
				            <q:column title="待摊销费用金额" value="${initial_worth}" width="20%" />
				            <q:column title="分摊期限" value="${use_age}" width="20%" />
				            <q:column title="月分摊金额" value="${month_loss_amount}" width="20%" />
				            <q:column title="已分摊期数" value="${has_use_age }" width="20%" />
				            <q:column title="期末余额" value="${asset_worth }" width="20%" />
				            <q:column title="状态" width="10%" >
							  	${status}
							</q:column>
							<q:column title="记账凭证" value="${tax_num}" width="20%" />
				            <q:column title="操作" escapeHtml="false" width="20%">
				            	<a class="pink" onclick="window.location.href='${ctx}/asset/detail?costType=EXPENSE&id=${id}'">详细</a>
							    &nbsp;
				   			    <a class="pink" onclick="window.location.href='${ctx}/asset/delete?id=${id}'">停用</a>
							    &nbsp;
				   			    <a class="pink" onclick="window.location.href='${ctx}/asset/delete?id=${id}'">删除</a>
							</q:column>
						</q:table>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<!--  end -->
	<script type="text/javascript">
	function clearAllInput(formId){
		var form = document.getElementById(formId);
		$(':input', form).not(':button, :submit, :reset, :hidden, :disabled').val('').removeAttr('checked').removeAttr('selected');
	};
   
    $(function(){
      
    });
  </script>
</body>
</html>
