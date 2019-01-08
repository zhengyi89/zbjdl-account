<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.errorTxt{
	font-size: 16px;
	color: #e00505;
	height: 50px;
	line-height: 20px;
	margin-top: 15px;
}
.error {
	color: red;
	line-height: 34px;
	margin: 0px !important;
}
.repaybox{display:inline-block;min-width:100px;}
.repaytext{font-weight:normal!important;padding-left:5px;padding-right:5px;}
</style>
<title>客户管理</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/company/companyCheck.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/BusinessCode.js"></script>
<script language="javascript" type="text/javascript" src="${resourcePath}/jqueryValidation/jquery.validate.min.js"></script>
<script language="javascript" type="text/javascript" src="${resourcePath}/jqueryValidation/messages_zh.js"></script>
<script language="javascript" type="text/javascript" src="${resourcePath}/jqueryValidation/additional-methods.js"></script>
<script language="javascript" type="text/javascript" src="${ctx}/static/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap-datetimepicker/js/bootstrap-datetimepicker.zh-CN.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css"/>
<script type="text/javascript" src="${resourcePath}/DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div id="content_2" class="content_wrapper">
		<div class="content_main">
			<div class="panel panel-default">
				<div class="panel-heading">客户编辑</div>
				<div class="panel-body">
					<form method="post" id="godownForma" name="godownForma"
						action="${pageContext.request.contextPath}/company/save" class="cmxform form-horizontal">
						<div class="form-group">
							<input type="hidden" value="${dto.id}" id="id" name="id"> 
							<label for="inputPassword3" class="col-lg-2 control-label">客户名称:</label>
							<div class="col-lg-3">
								<input type="text" class="form-control" value="${dto.companyName}" id="companyName" name="companyName" />
							</div>
							<label for="inputPassword3" class="col-lg-2 control-label">客户地址:</label>
							<div class="col-lg-3">
								<input type="text" class="form-control" value="${dto.companyAddress}" id="companyAddress" name="companyAddress" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">客户电话:</label>
							<div class="col-lg-3">
								<input type="text" class="form-control" value="${dto.companyMobile}" id="companyMobile" name="companyMobile" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">合同开始时间:</label>
							<div class="col-lg-3">
								<div class="input-group">
									<input id="datePicker" name="serveBeginDate" type="text" class="form-control" placeholder="" aria-describedby="basic-addon2" onclick="WdatePicker()">
				                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                </div>
							</div>
							<label for="inputPassword3" class="col-lg-2 control-label">合同结束时间:</label>
							<div class="col-lg-3">
								<div class="input-group">
									<input id="datePicker" name="serveEndDate" type="text" class="form-control" placeholder="" aria-describedby="basic-addon2" onclick="WdatePicker()">
				                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
				                </div>
							</div>
						</div>
					</form>
					<div class="errorTxt align_center col-lg-12" id="display_error_info_div"></div>
					<div class="form-group">
						<div class="col-lg-12 align_center">
							<button class="btn btn-primary submit" type="submit" onclick="document.getElementById('godownForma').submit('godownForma');">保存</button>
							<a href="${pageContext.request.contextPath}/company/index">
								<button class="btn btn-default button ml_20" type="button">返回</button>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			
		})
		$('.form_datetime').datetimepicker({
	        format: 'yyyy-mm',
	        autoclose: true,
	        todayBtn: true,
	        startView: 'year',
	        minView:'year',
	        maxView:'decade',
	        language:  'zh-CN',
    });
	</script>
</body>
</html>