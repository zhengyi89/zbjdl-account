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

.assets-add-header {
    border-bottom: 1px solid #bfcbd9;
    font-weight: 700;
    height: 32px;
    line-height: 32px;
    margin-bottom: 20px;
}
.assets-add-voucher {
    float: right;
}
</style>
<title>固定资产</title>
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
				<div class="panel-heading">科目期初</div>
				<div class="panel-body">
					<form method="post" id="godownForma" name="godownForma"
						action="${pageContext.request.contextPath}/accountSettle/saveSubjectOpening" class="cmxform form-horizontal">
						<input type="hidden" value="${dto.id}" id="id" name="id"> 
						<input type="hidden" value="${dto.subjectId}" id="subjectId" name="subjectId"> 
						<input type="hidden" value="DEPRECITION" id="costType" name="costType"> 
						<div class="assets-add-header"><span>科目期初</span><span class="assets-add-voucher">无</span><span class="assets-add-voucher">固定资产凭证:</span></div>
						
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">期初余额:</label>
							<div class="col-lg-2">
								<input type="text" class="form-control" value="${dto.openingBalance}" id="openingBalance" name="openingBalance" />
							</div>
							<label for="inputPassword3" class="col-lg-2 control-label">本年累积借方:</label>
							<div class="col-lg-2">
								<input type="text" class="form-control" value="${dto.yearDebitAmount}" id="yearDebitAmount" name="yearDebitAmount" />
							</div>
							<label for="inputPassword3" class="col-lg-2 control-label">本年累积贷方:</label>
							<div class="col-lg-2">
								<input type="text" class="form-control" value="${dto.yearCreditAmount}" id="yearCreditAmount" name="yearCreditAmount" />
							</div>
						</div>
											
					</form>
					<div class="errorTxt align_center col-lg-12" id="display_error_info_div"></div>
					<div class="form-group">
						<div class="col-lg-12 align_center">
							<button class="btn btn-primary submit" type="submit" onclick="document.getElementById('godownForma').submit('godownForma');">保存</button>
							<!-- <button class="btn btn-primary submit" type="submit" onclick="document.getElementById('godownForma').submit('godownForma');">生成凭证</button> -->
							<button class="btn btn-default button ml_20" type="button"  onclick="history.go(-1)">返回</button>
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