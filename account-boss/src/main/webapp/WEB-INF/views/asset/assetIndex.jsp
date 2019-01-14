<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.zbjdl.common.utils.config.TextResource" %>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>固定资产</title>
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
				<div class="panel-heading">固定资产列表</div>
				<div class="panel-body">
					<div class="panel-table">
						<a href="${pageContext.request.contextPath}/asset/edit/index?costType=DEPRECITION">
							<button class="btn btn-primary submit" type="button">
								新 增<span class="content_blank_10"></span><span class="glyphicon glyphicon-plus"></span>
							</button>
						</a>
						<q:table queryService="queryService" queryKey="queryAssetList" formId="godownForma"
							class="table table-striped table-bordered" pageSize="20">
							<q:nodata>无符合条件的记录</q:nodata>
							<q:param name="systemCode" value="${SESSION_ACCOUNTINFO.systemCode}" />
							<q:param name="costType" value="DEPRECITION" />
				            <q:column title="资产编号" value="${asset_code}" width="20%" />
				            <q:column title="资产名称" value="${asset_name}" width="20%" />
				            <q:column title="资产类别" value="${asset_class_name}" width="20%" />
				            <q:column title="部门" value="${assist_name}" width="20%" />
				            <q:column title="预计使用期限" value="${use_age}" width="20%" />
				            <q:column title="开始使用日期"  width="20%" >
				            	<fmt:formatDate value="${begin_use_date}" pattern="yyyy-MM-dd" />
				            </q:column>
				            <q:column title="增加日期"  width="20%" >
				            	<fmt:formatDate value="${begin_date}" pattern="yyyy-MM-dd" />
				            </q:column>
				            <q:column title="资产原值" value="${initial_worth}" width="20%" />
				            <q:column title="残值" value="${net_salvage}" width="20%" />
				            <q:column title="月折旧额" value="${month_loss_amount}" width="20%" />
				            <q:column title="已折旧期数" value="${has_use_age}" width="20%" />
				            <q:column title="期末净值" value="${asset_worth}" width="20%" />
				            <%-- <q:column title="期末净值" value="${use_age}" width="20%" /> --%>
				            <q:column title="状态" width="10%" >
							  	${status}
							</q:column>
							<q:column title="记账凭证" value="${tax_num}" width="20%" />
				            <q:column title="操作" escapeHtml="false" width="20%">
				            	<%-- <a class="pink" onclick="window.location.href='${ctx}/asset/edit/index?costType=DEPRECITION&id=${id}'">编辑</a>
							    &nbsp; --%>
				            	<a class="pink" onclick="window.location.href='${ctx}/asset/edit/index?id=${id}'">详细</a>
							    &nbsp;
				   			    <a class="pink" onclick="window.location.href='${ctx}/asset/delete?id=${id}'">禁用</a>
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
