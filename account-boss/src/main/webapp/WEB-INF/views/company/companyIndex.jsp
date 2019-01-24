<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.zbjdl.common.utils.config.TextResource" %>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>我的客户</title>
<script language="javascript" type="text/javascript" src="${resourcePath}/DatePicker/WdatePicker.js"></script>
</head>
<body>
	<!-- begin -->
    <%pageContext.setAttribute("_textResource", new TextResource()); %>
	<div id="content_2" class="content_wrapper">
		<div class="content_main">
			<div class="panel panel-default">
				<div class="panel-heading">内容筛选</div>
				<div class="panel-body">
				<form id="changeStatusForm" action="" method="post">
			      <input type="hidden" id="id" name="id" value=""/>
				</form>
				<form class="cmxform form-horizontal" action="${ctx}/company/index" method="get"
						method="get" id="companyForm" name="companyForm">
						<!-- 第一组查询条件 -->
						<div class="form-group">
							<label class="control-label col-lg-2">客户名称</label>
							<div class="col-lg-3">
								<input class="form-control" id="companyName" name="companyName" ></input>
							</div>
							
							<!-- <label for="status" class="control-label col-lg-2">客户状态</label>
							<div class="col-lg-3">
								<input class="form-control" id="status" name="status" ></input>
							</div> -->
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
						<a href="${pageContext.request.contextPath}/company/edit/index">
							<button class="btn btn-primary submit" type="button">新 增<span class="content_blank_10"></span><span class="glyphicon glyphicon-plus"></span>
							</button>
						</a>
						<!-- querytag -->
						<q:table queryService="queryService"
							queryKey="queryCompanyList" formId="godownForma"
							class="table table-striped table-bordered" pageSize="20">
							<q:nodata>无符合条件的记录</q:nodata>
							<q:column title="序号" value="${_rowstatus.globalIndex}" with="10％" />
				            <q:column title="公司名称" value="${company_name}" width="20%" />
				            <q:column title="公司地址" value="${company_address}" width="20%" />
				            <q:column title="公司电话" value="${company_mobile}" width="20%" />
				            <q:column title="公司电话" value="${company_mobile}" width="20%" />
				            <q:column title="合同时间"  width="20%" >
				            	<fmt:formatDate value="${serve_begin_date}" pattern="yyyy/MM/dd" />-
				            	<fmt:formatDate value="${serve_end_date}" pattern="yyyy/MM/dd" />
				            </q:column>
				            <q:column title="状态" width="10%" >
							  	${_textResource.getSysText('ACCOUNT_COMPANY_STATUS', status)}
							</q:column>
							<q:column title="创建人" value="${creator_name}" width="20%" />
							<q:column title="代帐会计" value="${accountant_name}" width="20%" />
				            <q:column title="操作" escapeHtml="false" width="20%">
				            	<c:if test="${status == 'CREATE'}">
				   			    	<a class="pink" onclick="window.location.href='${ctx}/company/edit/index?id=${id}'">编辑</a>
				   			    	&nbsp;
				   			    	<a class="pink" onclick="window.location.href='${ctx}/company/assign/index?id=${id}'">分配</a>
				   			    	 &nbsp;
				   			    </c:if>
				   			    <c:if test="${status != 'CREATE'}">
				   			    	<a class="pink" onclick="window.location.href='${ctx}/system/console?companyId=${id}&belongSystem=-9992002&_menuId=70&_firstMenuId=-2002'">查看</a>
				   			    </c:if>
				   			    
							</q:column>
						</q:table>
					</div>
					
				</div>
			</div>
		</div>
	</div>
  </script>
</body>
</html>
