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
				<div class="panel-heading">基础参数</div>
				<div class="panel-body">
					<form class="cmxform form-horizontal" method="get" id="godownForma" name="godownForma">
						<div class="form-group">
							<label class="col-lg-2 control-label">账套名称：</label>
							<div class="col-lg-2">
								<label class="control-label">${dto.systemName}</label>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-lg-2 control-label">启用年月：</label>
							<div class="col-lg-2">
								<label class="control-label"><fmt:formatDate value="${dto.serverStartDate}" pattern="yyyy-MM" /></label>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-lg-2 control-label">会计制度：</label>
							<div class="col-lg-2">
								<label class="control-label">${_textResource.getSysText('ACCOUNT_ACCOUNT_TYPE', dto.accountType)}</label>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-lg-2 control-label">所属行业：</label>
							<div class="col-lg-2">
								<label class="control-label">${_textResource.getSysText('ACCOUNT_INDUSTRY_TYPE', dto.industryType)}</label>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-lg-2 control-label">纳税人认定类型：</label>
							<div class="col-lg-2">
								<label class="control-label">${_textResource.getSysText('ACCOUNT_TAXPAYER_TYPE', dto.taxpayerType)}</label>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-lg-2 control-label">本位币：</label>
							<div class="col-lg-2">
								<label class="control-label">${dto.standardCoin}</label>
							</div>
						</div>
						
						 <div class="form-group">
							<label class="col-lg-2 control-label">创建时间</label>
							<div class="col-lg-3">
								<label class="control-label">
					            	<fmt:formatDate value="${dto.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
								</label>
					         </div>
						 </div>
						 
						 <div class="form-group">
							<label class="col-lg-2 control-label">其他：</label>
							<div class="col-lg-2">
								<c:if test="${dto.commonSubjectInit}">
									<label class="control-label">预置期间费用明细科目</label>
								</c:if>
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