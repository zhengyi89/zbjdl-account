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
				<div class="panel-heading">财物管理工作台</div>
				<div class="panel-body">
					<form class="cmxform form-horizontal" method="get" id="godownForma" name="godownForma">
						<div class="form-group">
							<label class="col-lg-2 control-label">客户名称:</label>
							<div class="col-lg-3">
								<label class="control-label">${dto.systemName}</label>
							</div>
							<label class="col-lg-2 control-label">客户编码:</label>
							<div class="col-lg-3">
								<label class="control-label">${dto.systemCode}</label>
							</div>
						</div>
						
						 <%-- <div class="form-group">
							<label class="col-lg-2 control-label">服务开始时间</label>
							<div class="col-lg-3">
								<label class="control-label">
					            	${dto.serverStartDate}
								</label>
					         </div>
							<label class="col-lg-2 control-label">创建时间</label>
							<div class="col-lg-3">
								<label class="control-label">
					            	${dto.createTime}
								</label>
					         </div>
						 </div> --%>
					  </form>
				</div>
			</div>
			<!-- <div class="form-group">
				<div class="panel-table align_center">
					<a onclick="javascript:history.back(-1);">
						<button class="btn btn-primary  ml_20" type="button">返回</button>
					</a>
				</div>
			</div> -->
		</div>
	</div>
	
    <script type="text/javascript">
    
    </script>
  </body>
</html>