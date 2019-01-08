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
<title>固定资产类别</title>
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
				<div class="panel-heading">固定资产类别</div>
				<div class="panel-body">
					<form method="post" id="godownForma" name="godownForma"
						action="${pageContext.request.contextPath}/assetClass/save" class="cmxform form-horizontal">
						<div class="form-group">
							<input type="hidden" value="${dto.id}" id="id" name="id"> 
							<label for="inputPassword3" class="col-lg-2 control-label">类别编码:</label>
							<div class="col-lg-3">
								<input type="text" class="form-control" value="${dto.assetClassCode}" id="assetClassCode" name="assetClassCode" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">类别名称:</label>
							<div class="col-lg-3">
								<input type="text" class="form-control" value="${dto.assetClassName}" id="assetClassName" name="assetClassName" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">折旧方法:</label>
							<div class="col-lg-3">
								<select class="form-control" id="deprecitionType" name="deprecitionType">
									<script type="text/javascript">
										BusinessCode.getSysConfigCode("ACCOUNT_DEPRECITION_TYPE ", "deprecitionType", "${dto.deprecitionType}");
									</script>
								</select>
						   </div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">预计使用期限:</label>
							<div class="col-lg-3">
								<input type="text" class="form-control" value="${dto.useAge}" id="useAge" name="useAge" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">固定资产科目:</label>
							<div class="col-lg-3">
								<select class="form-control" id="subjectCode1" name="subjectCode1">
									<option></option>
									<c:forEach items="${subjectList}" var="subject">
										<option value="${subject.subjectCode}" <c:if test="${subject.subjectCode == dto.subjectCode1 }">selected</c:if>>${subject.subjectName }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">累积折旧科目:</label>
							<div class="col-lg-3">
								<select class="form-control" id="subjectCode2" name="subjectCode2">
									<option></option>
									<c:forEach items="${subjectList}" var="subject">
										<option value="${subject.subjectCode}" <c:if test="${subject.subjectCode == dto.subjectCode2 }">selected</c:if>>${subject.subjectName }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">备注:</label>
							<div class="col-lg-3">
								<input type="text" class="form-control" value="${dto.remark}" id="remark" name="remark" />
							</div>
						</div>
					</form>
					<div class="errorTxt align_center col-lg-12" id="display_error_info_div"></div>
					<div class="form-group">
						<div class="col-lg-12 align_center">
							<button class="btn btn-primary submit" type="submit" onclick="document.getElementById('godownForma').submit('godownForma');">保存</button>
							<a href="${pageContext.request.contextPath}/assetClass/index">
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