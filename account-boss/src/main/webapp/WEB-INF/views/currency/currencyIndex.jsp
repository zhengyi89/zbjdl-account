<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.zbjdl.common.utils.config.TextResource" %>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>外币核算</title>
<script language="javascript" type="text/javascript" src="${resourcePath}/DatePicker/WdatePicker.js"></script>
 <%pageContext.setAttribute("_textResource", new TextResource()); %>
</head>
<body>
	<!-- begin -->
    <%pageContext.setAttribute("_textResource", new TextResource()); %>
	<div id="content_2" class="content_wrapper">
		<div class="content_main">
			<div class="panel panel-default">
				<div class="panel-heading">查询结果</div>
				<div class="panel-body">
					<div class="panel-table">
						<a href="${pageContext.request.contextPath}/currency/edit/index">
							<button class="btn btn-primary submit" type="button">
								新 增<span class="content_blank_10"></span><span class="glyphicon glyphicon-plus"></span>
							</button>
						</a>
						&nbsp;&nbsp;&nbsp;&nbsp;折算方式：原币*汇率=本位币
						<q:table queryService="queryService" queryKey="queryCurrencyList" formId="godownForma"
							class="table table-striped table-bordered" pageSize="20">
							<q:nodata>无符合条件的记录</q:nodata>
							<q:param name="systemCode" value="${SESSION_ACCOUNTINFO.systemCode}" />
							<q:column title="序号" value="${_rowstatus.globalIndex}" with="10％" />
				            <q:column title="编码" value="${currency_code}" width="20%" />
				            <q:column title="名称" value="${currency_name}" width="20%" />
				            <q:column title="汇率" value="${exchange_rate}" width="20%" />
				            <q:column title="创建时间"  width="20%" >
				            	<fmt:formatDate value="${create_time}" pattern="yyyy-MM-dd HH:mm:ss " />
				            </q:column>
				            <q:column title="状态" width="10%" >
							  	${status}
							</q:column>
				            <q:column title="操作" escapeHtml="false" width="20%">
				            	<a class="pink" onclick="window.location.href='${ctx}/currency/edit/index?id=${id}'">编辑</a>
							    &nbsp;
				   			    <a class="pink" onclick="window.location.href='${ctx}/currency/delete?id=${id}'">删除</a>
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
