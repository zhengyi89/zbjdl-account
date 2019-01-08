<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<html lang="zh-CN">
<head>
<title>代帐分配</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<style type="text/css">
.line32 {
	line-height: 32px;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/BusinessCode.js"></script>
<script language="javascript" type="text/javascript" src="${resourcePath}/jqueryValidation/jquery.validate.min.js"></script>
<script language="javascript" type="text/javascript" src="${resourcePath}/jqueryValidation/messages_zh.js"></script>
<script language="javascript" type="text/javascript" src="${resourcePath}/jqueryValidation/additional-methods.js"></script>

<script type="text/javascript">

	function isNull(value) {
		if (value == null) {
			return "";
		} else {
			return value;
		}
	}
	
	function assign() {
		var v_id = $('#id').val();
		var v_accountantId = $('#accountantId').val();
		var v_accountantName = $("#accountantName").val();
		if(v_accountantId == ''){
			alert("请选择代帐会计");
			return false;
		}
		$.ajax({
			type : 'POST',
			url : '${pageContext.request.contextPath}/company/assign',
			dataType : "json",
			data:{id:v_id,accountantId:v_accountantId,accountantName:v_accountantName},
			success : function(data) {
				console.log('1111111111');
				alert("分配完成");
				window.location="${pageContext.request.contextPath}/company/index";
			}
		});
	}
	
	function setAccName(){
		var opt=$("#accountantId option:selected").text();
		console.log('opt---'+opt);
		$("#accountantName").val(opt);
	}
</script>
</head>
<body>
	<div id="content_2" class="content_wrapper">
		<div class="content_main">
			<div class="panel panel-default">
				<div class="panel-heading">代帐分配</div>
				<div class="panel-body">
					<form class="cmxform form-horizontal" method="post"
						id="godownForma" name="godownForma" action="">
						<input type="hidden" name="id" id="id" value="${dto.id}">
						<input type="hidden" name="accountantName" id="accountantName" value="">
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-3 control-label">客户名称:</label>
							<div class="col-lg-9">
								<label class="control-label">${dto.companyName}</label>
							</div>
						</div>
						<!-- <div class="form-group">
							<label for="inputPassword3" class="col-lg-3 control-label">审批结论:</label>
							<div class="col-lg-9">
							<input type="radio" name="auditFlag" value="2" checked="checked">审批通过&nbsp;&nbsp;&nbsp;
              				<input type="radio" name="auditFlag" value="1">审批拒绝&nbsp;
							</div>
						</div> -->
						
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-3 control-label">选择代帐会计:</label>
							<div class="col-lg-3 align_center">
							<select class="form-control" id="accountantId" name="accountantId" onchange="setAccName()">
								<option></option>
								<c:forEach items="${users}" var="user">
									<option value="${user.userId}">${user.loginName }</option>
								</c:forEach>
							</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-6 align_center">
								<button id="bpass" type="button" class="btn btn-primary submit btn-lg ml_20" 
									data-toggle="modal" data-target="#myModal_3" onclick="assign();">分 配</button>
								<a class="btn btn-primary submit btn-lg ml_20" type="button" href="javascript:window.history.go(-1);">返 回</a>
							</div>
						</div>
					</form>
				</div>
			</div>

		</div>
	</div>
</body>
</html>
