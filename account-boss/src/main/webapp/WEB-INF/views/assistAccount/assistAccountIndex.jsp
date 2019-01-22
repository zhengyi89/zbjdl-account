<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.zbjdl.common.utils.config.TextResource" %>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>辅助核算</title>
<script language="javascript" type="text/javascript" src="${resourcePath}/DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div id="content_2" class="content_wrapper">
		<div class="content_main">
			<!-- <div class="panel panel-default">
				<div class="panel-heading">内容筛选</div>
				<div class="panel-body">
				<form id="changeStatusForm" action="" method="post">
			      <input type="hidden" id="id" name="id" value=""/>
				</form>
				
				</div>
			</div> -->
			<div class="panel panel-default">
				<div class="panel-heading">查询结果</div>
				<div class="panel-body">
					<div class="panel-table">
						<a href="${pageContext.request.contextPath}/assistAccount/edit/index">
							<button class="btn btn-primary submit" type="button">
								新 增<span class="content_blank_10"></span><span class="glyphicon glyphicon-plus"></span>
							</button>
						</a>
						<q:table queryService="queryService" queryKey="queryAssistAccountList" formId="godownForma"
							class="table table-striped table-bordered" pageSize="40" showExpButton="true" contextUrl="${ctx}/bussinessCode/exportExcel">
							<q:nodata>无符合条件的记录</q:nodata>
							<q:param name="systemCode" value="${SESSION_ACCOUNTINFO.systemCode}" />
				            <q:column title="编码" value="${assist_code}" width="20%" dataIndex="assist_code"/>
				            <q:column title="名称" value="${assist_name}" width="20%" dataIndex="assist_name"/>
				            <q:column title="类别" value="${_textResource.getSysText('ACCOUNT_ASSIST_TYPE', assist_type)}" width="20%" dataIndex="assist_type" showValueIndex="ACCOUNT_ASSIST_TYPE"/>
				            <q:column title="企业税号" value="${tax_num}" width="20%" dataIndex="tax_num"/>
				            <q:column title="创建时间"  width="20%" dataIndex="create_time">
				            	<fmt:formatDate value="${create_time}" pattern="yyyy-MM-dd HH:mm:ss"/>
				            </q:column>
				            <q:column title="状态" width="10%" dataIndex="status" showValueIndex="ACCOUNT_DATA_STATUS">
							  	${_textResource.getSysText('ACCOUNT_DATA_STATUS', status)}
							</q:column>
				            <q:column title="操作" escapeHtml="false" width="20%">
				            	<a class="pink" onclick="window.location.href='${ctx}/assistAccount/edit/index?id=${id}'">编辑</a>
							    &nbsp;
				   			    <a class="pink" onclick="changeStatus(${id}, 'DELETE')">删除</a>
							</q:column>
						</q:table>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<!--  end -->
	<script type="text/javascript">
		function changeStatus(id, status){
	   		var mymessage=confirm("此操作将永久删除该记录, 是否继续?");
			if(mymessage==true) {  
				window.location.href='${ctx}/assistAccount/operate?id='+id+'&status='+status;
			}
	   	}
  </script>
</body>
</html>
