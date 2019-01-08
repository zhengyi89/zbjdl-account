<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.zbjdl.common.utils.config.TextResource" %>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>资产类别</title>
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
						<a href="${pageContext.request.contextPath}/assetClass/edit/index">
							<button class="btn btn-primary submit" type="button">
								新 增<span class="content_blank_10"></span><span class="glyphicon glyphicon-plus"></span>
							</button>
						</a>
						<q:table queryService="queryService" queryKey="queryAssetClassList" formId="godownForma"
							class="table table-striped table-bordered" pageSize="20">
							<q:nodata>无符合条件的记录</q:nodata>
							<q:param name="systemCode" value="${SESSION_ACCOUNTINFO.systemCode}" />
				            <q:column title="类别编号" value="${asset_class_code}" width="20%" />
				            <q:column title="类别名称" value="${asset_class_name}" width="20%" />
				            <q:column title="折旧方法" value="${deprecition_type}" width="20%" />
				            <q:column title="预计使用期限" value="${use_age}" width="20%" />
				            <q:column title="固定资产科目" value="${subject_code1}" width="20%" />
				            <q:column title="累计折旧科目" value="${subject_code2}" width="20%" />
				            <q:column title="创建时间"  width="20%" >
				            	<fmt:formatDate value="${create_time}" pattern="yyyy-MM-dd HH:mm:ss " />
				            </q:column>
				            <q:column title="状态" width="10%" >
							  	${status}
							</q:column>
				            <q:column title="操作" escapeHtml="false" width="20%">
				            	<a class="pink" onclick="window.location.href='${ctx}/assetClass/edit/index?id=${id}'">编辑</a>
							    &nbsp;
				   			    <a class="pink" onclick="window.location.href='${ctx}/assetClass/delete?id=${id}'">删除</a>
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
