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
<title>创建帐套</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/company/companyCheck.js"></script>
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
				<div class="panel-heading">创建帐套</div>
				<div class="panel-body">
					<form method="post" id="godownForma" name="godownForma"
						action="${pageContext.request.contextPath}/system/createSetBook" class="cmxform form-horizontal">
						<input type="hidden" value="${dto.id}" id="companyId" name="companyId"> 
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">帐套名称:</label>
							<div class="col-lg-3">
								<input type="text" class="form-control" value="${dto.companyName}" id="systemName" name="systemName" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">帐套启用时间:</label>
							<div class="col-lg-3">
								<input type="text" name="serverStartDate" id="serverStartDate" class="form-control input_left"  onclick="WdatePicker()" value =""/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">会计制度:</label>
							<div class="col-lg-3">
								<select class="form-control" id="accountType" name="accountType">
									<script type="text/javascript">
										BusinessCode.getSysConfigCode("ACCOUNT_ACCOUNT_TYPE", "accountType", "");
									</script>
								</select>
						   </div>
						</div>
						
						<div class="form-group"> 
							<label for="inputPassword3" class="col-lg-2 control-label">所属行业:</label>
							<div class="col-lg-3">
								<select class="form-control" id="industryType" name="industryType">
									<script type="text/javascript">
										BusinessCode.getSysConfigCode("ACCOUNT_INDUSTRY_TYPE", "industryType", "");
									</script>
								</select>
						   </div>
						</div>
						
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">纳税人类型:</label>
							<div class="col-lg-3">
								<input type="radio" name="taxpayerType" value="SMALL" checked="checked">小规模纳税人&nbsp;&nbsp;&nbsp;
              					<input type="radio" name="taxpayerType" value="GENERAL">一般纳税人&nbsp;
							</div>
						</div>
						
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">其他:</label>
							<div class="col-lg-3">
								<input type="checkbox" name="commonSubjectInit" value="1" checked />
								预置期间费用明细科目
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
	</script>
</body>
</html>