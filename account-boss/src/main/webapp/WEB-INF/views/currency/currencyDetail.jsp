<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.zbjdl.common.utils.config.TextResource" %>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>八戒财物管理平台</title>
</head>
  <body>
	<!-- begin -->
    <%pageContext.setAttribute("_textResource", new TextResource()); %>
	<div id="content_2" class="content_wrapper">
		<div class="content_main">
			<div class="panel panel-default">
				<div class="panel-heading">客户详情</div>
				<div class="panel-body">
					<form class="cmxform form-horizontal" method="get" id="godownForma" name="godownForma">
						<div class="form-group">
							<label class="col-lg-2 control-label">客户名称:</label>
							<div class="col-lg-3">
								<label class="control-label">${dto.companyName}</label>
							</div>
							<label class="col-lg-2 control-label">客户地址:</label>
							<div class="col-lg-3">
								<label class="control-label">${dto.companyAddress}</label>
							</div>
						</div>
						
						<%--  <div class="form-group">
							<label class="col-lg-2 control-label">外部客户代码:</label>
							<div class="col-lg-3">
								 <label class="control-label">
								 	${dto.outerProductCode}
								 </label>
							</div>
							<label class="col-lg-2 control-label">还款方式</label>
							<div class="col-lg-3 ">
								 <label class="control-label">
								 	${dto.repaymentType}
								 </label>
					         </div>
						 </div> --%>
						
						 <div class="form-group">
							<label class="col-lg-2 control-label">创建时间</label>
							<div class="col-lg-3">
								<label class="control-label">
					            	<fmt:formatDate value="${dto.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
								</label>
					         </div>
					        <label class="col-lg-2 control-label">最后修改时间</label>
							<div class="col-lg-3">
								<label class="control-label">
					            	<fmt:formatDate value="${dto.lastUpdateTime}" pattern="yyyy-MM-dd HH:mm:ss" />
								</label>
					         </div>
						 </div>
					  </form>
				</div>
			</div>
			<div class="form-group">
				<div class="panel-table align_center">
					<a onclick="javascript:history.back(-1);">
						<button class="btn btn-primary  ml_20" type="button">返回</button>
					</a>
				</div>
			</div>
		</div>
	</div>
	
    <script type="text/javascript">
    
    </script>
  </body>
</html>