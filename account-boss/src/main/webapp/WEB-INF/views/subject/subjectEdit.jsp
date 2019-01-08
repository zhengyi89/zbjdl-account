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
<title>辅助核算</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/BusinessCode.js"></script>
<script language="javascript" type="text/javascript" src="${resourcePath}/jqueryValidation/jquery.validate.min.js"></script>
<script language="javascript" type="text/javascript" src="${resourcePath}/jqueryValidation/messages_zh.js"></script>
<script language="javascript" type="text/javascript" src="${resourcePath}/jqueryValidation/additional-methods.js"></script>
<script type="text/javascript" src="${resourcePath}/DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div id="content_2" class="content_wrapper">
		<div class="content_main">
			<div class="panel panel-default">
				<div class="panel-heading">会计科目编辑</div>
				<div class="panel-body">
					<form method="post" id="godownForma" name="godownForma"
						action="${pageContext.request.contextPath}/subject/save" class="cmxform form-horizontal">
						<div class="form-group">
							<input type="hidden" value="${dto.id}" id="id" name="id"> 
							<label for="inputPassword3" class="col-lg-2 control-label">上级科目:</label>
							<div class="col-lg-3">
								<input type="text" class="form-control" value="${dto.parentCode}" id="parentCode" name="parentCode" readonly/>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">科目编号:</label>
							<div class="col-lg-3">
								<input type="text" class="form-control" value="${dto.subjectCode}" id="subjectCode" name="subjectCode" <c:if test="${not empty dto.id}">readonly</c:if> />
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">科目名称:</label>
							<div class="col-lg-3">
								<input type="text" class="form-control" value="${dto.subjectName}" id="subjectName" name="subjectName" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">科目类别:</label>
							<div class="col-lg-3">
								<select class="form-control" id="basicSubject" name="basicSubject">
									<script type="text/javascript">
										BusinessCode.getSysConfigCode("ACCOUNT_SUBJECT_TYPE ", "basicSubject", "${dto.basicSubject}");
									</script>
								</select>
						   </div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">余额方向:</label>
							<div class="col-lg-3">
								<select class="form-control" id="balanceDirect" name="balanceDirect">
									<script type="text/javascript">
										BusinessCode.getSysConfigCode("ACCOUNT_BALANCE_DIRECT", "balanceDirect", "${dto.balanceDirect}");
									</script>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">辅助核算:</label>
							<div class="col-lg-3">
								<select class="form-control" id="assistAccount" name="assistAccount">
									<script type="text/javascript">
										BusinessCode.getSysConfigCode("ACCOUNT_ASSIST_TYPE", "assistAccount", "${dto.assistAccount}");
									</script>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">数量:</label>
							<div class="col-lg-3">
								<input type="text" class="form-control" value="${dto.accountUnit}" id="accountUnit" name="accountUnit" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">外币:</label>
							<div class="col-lg-3">
								<input type="text" class="form-control" value="${dto.currencyCode}" id="currencyCode" name="currencyCode" />
							</div>
						</div>
						<%-- <div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">先进流量分配:</label>
							<div class="col-lg-3">
								<input type="text" class="form-control" value="${dto.balanceDirect}" id="balanceDirect" name="balanceDirect" />
							</div>
						</div> --%>
					</form>
					<div class="errorTxt align_center col-lg-12" id="display_error_info_div"></div>
					<div class="form-group">
						<div class="col-lg-12 align_center">
							<button class="btn btn-primary submit" type="submit" onclick="document.getElementById('godownForma').submit('godownForma');">保存</button>
							<a href="${pageContext.request.contextPath}/subject/index">
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
	</script>
</body>
</html>