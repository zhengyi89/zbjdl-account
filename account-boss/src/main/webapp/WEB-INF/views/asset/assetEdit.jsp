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
				<div class="panel-heading">固定资产</div>
				<div class="panel-body">
					<form method="post" id="godownForma" name="godownForma"
						action="${pageContext.request.contextPath}/asset/save" class="cmxform form-horizontal">
						<input type="hidden" value="${dto.id}" id="id" name="id"> 
						<input type="hidden" value="DEPRECITION" id="costType" name="costType"> 
						<div class="assets-add-header"><span>基本信息</span><span class="assets-add-voucher">无</span><span class="assets-add-voucher">固定资产凭证:</span></div>
						
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">资产编码:</label>
							<div class="col-lg-3">
								<input type="text" class="form-control" value="${dto.assetCode}" id="assetCode" name="assetCode" />
							</div>
							<label for="inputPassword3" class="col-lg-2 control-label">资产名称:</label>
							<div class="col-lg-3">
								<input type="text" class="form-control" value="${dto.assetName}" id="assetName" name="assetName" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">资产类别:</label>
							<div class="col-lg-3">
								<select class="form-control" id="assetClassCode" name="assetClassCode"  onchange="selectAssetClass();">
									<option></option>
									<c:forEach items="${assetClassList}" var="assetClass">
										<option value="${assetClass.assetClassCode}" <c:if test="${assetClass.assetClassCode == dto.assetClassCode }">selected</c:if>>${assetClass.assetClassName }</option>
									</c:forEach>
								</select>
						   </div>
							<label for="inputPassword3" class="col-lg-2 control-label">使用部门:</label>
							<div class="col-lg-3">
								<select class="form-control" id="assistCode" name="assistCode">
									<option></option>
									<c:forEach items="${departmentList}" var="department">
										<option value="${department.assistCode}" <c:if test="${department.assistCode == dto.assistCode }">selected</c:if>>${department.assistName }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">增加日期:</label>
							<div class="col-lg-3">
								<input type="text" name="beginDate" id="beginDate" class="form-control input_left"  onclick="WdatePicker()"  onchange="computeOpening()"
								value = "<fmt:formatDate value="${dto.beginDate}" dateStyle="default" />"/>
							</div>
						</div>
						
						<div class="assets-add-header"><span>核算信息</span></div>
						
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
						   <label for="inputPassword3" class="col-lg-2 control-label">累计折旧科目:</label>
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
							<label for="inputPassword3" class="col-lg-2 control-label">支付对应科目:</label>
							<div class="col-lg-3">
								<select class="form-control" id="subjectCode3" name="subjectCode3">
									<option></option>
									<c:forEach items="${subjectList}" var="subject">
										<option value="${subject.subjectCode}" <c:if test="${subject.subjectCode == dto.subjectCode3 }">selected</c:if>>${subject.subjectName }</option>
									</c:forEach>
								</select>
						   </div>
						   <label for="inputPassword3" class="col-lg-2 control-label">折旧费用科目:</label>
							<div class="col-lg-3">
								<select class="form-control" id="subjectCode4" name="subjectCode4">
									<option></option>
									<c:forEach items="${subjectList}" var="subject">
										<option value="${subject.subjectCode}" <c:if test="${subject.subjectCode == dto.subjectCode4 }">selected</c:if>>${subject.subjectName }</option>
									</c:forEach>
								</select>
						   </div>
						</div>
						
						
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">税金对应科目:</label>
							<div class="col-lg-3">
								<select class="form-control" id="subjectCode5" name="subjectCode5">
									<option></option>
									<c:forEach items="${subjectList}" var="subject">
										<option value="${subject.subjectCode}" <c:if test="${subject.subjectCode == dto.subjectCode5 }">selected</c:if>>${subject.subjectName }</option>
									</c:forEach>
								</select>
						   </div>
						   <label for="inputPassword3" class="col-lg-2 control-label">对应税金金额:</label>
						   <div class="col-lg-3">
								<input type="text" class="form-control" value="" id="" name="" />
							</div>
						</div>
						
						
						
						<div class="assets-add-header"><span>折旧资料</span></div>
						<div class="form-group">
						   <label for="inputPassword3" class="col-lg-2 control-label">原值:</label>
						   <div class="col-lg-3">
								<input type="text" class="form-control" value="${dto.initialWorth}" id="initialWorth" name="initialWorth" />
						   </div>
						   <label for="inputPassword3" class="col-lg-2 control-label">预计使用期限:</label>
						   <div class="col-lg-3">
								<input type="text" class="form-control" value="${dto.useAge}" id="useAge" name="useAge" />
						   </div>
						</div>
						
						<div class="form-group">
						   <label for="inputPassword3" class="col-lg-2 control-label">折旧方法:</label>
						   <div class="col-lg-3">
								<select class="form-control" id="deprecitionType" name="deprecitionType">
									<option value="1" class="select">平均年限法</option>
									<option value="2" class="select">不计提折旧</option>
								</select>
						   </div>
						   <label for="inputPassword3" class="col-lg-2 control-label">预计净残值:</label>
						   <div class="col-lg-3">
								<input type="text" class="form-control" value="${dto.netSalvage}" id="netSalvage" name="netSalvage" />
							</div>
						</div>
						
						<div class="form-group">
						   <label for="inputPassword3" class="col-lg-2 control-label">月折旧额:</label>
						    <div class="col-lg-3">
								<input type="text" class="form-control" value="${dto.monthLossAmount}" id="monthLossAmount" name="monthLossAmount" readonly/>
							</div>
							<label for="inputPassword3" class="col-lg-2 control-label">计提折旧:</label>
							<div class="col-lg-3">
								<input type="radio" name="taxpayerType" value="0" checked="checked">按原值和预计使用期限计提折旧<p>
              					<input type="radio" name="taxpayerType" value="1">按净值和剩余使用期限计提折旧
							</div>
						</div>
						
						<div class="assets-add-header"><span>入帐前开始使用</span></div>
						
						<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">开始使用日期:</label>
							<div class="col-lg-3">
								<input type="text" name="beginUseDate" id="beginUseDate" class="form-control input_left"  onclick="WdatePicker()" 
									value = "<fmt:formatDate value="${dto.beginUseDate}" dateStyle="default"/>"  onchange="computeOpening()"/>
							</div>
						   	<label for="inputPassword3" class="col-lg-2 control-label">已折旧期数:</label>
						   	<div class="col-lg-3">
								<input type="text" class="form-control" value="${dto.hasUseAge}" id="hasUseAge" name="hasUseAge" readonly/>
						   	</div>
						</div>
						
						<div class="form-group">
						   	<label for="inputPassword3" class="col-lg-2 control-label">期初累计折旧:</label>
						    <div class="col-lg-3">
								<input type="text" class="form-control" value="${dto.useAmount}" id="useAmount" name="useAmount" readonly/>
							</div>
							<label for="inputPassword3" class="col-lg-2 control-label">期初净值:</label>
						    <div class="col-lg-3">
								<input type="text" class="form-control" value="${dto.assetWorth}" id="assetWorth" name="assetWorth" readonly/>
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
			$(":radio").click(function(){
				 console.log("..." + $(this).val());
				 if($(this).val()==0){
					$("#hasUseAge").attr('readonly','readonly');
					$("#assetWorth").attr('readonly','readonly');
					$("#useAmount").attr('readonly','readonly');
					computeOpening();
					
				 }else{
					$("#hasUseAge").removeAttr('readonly');
					$("#assetWorth").removeAttr('readonly');
					$("#useAmount").removeAttr('readonly');
				 }
			});
		})
		
		$("#initialWorth").bind("input propertychange",function(event){
			computeCost();
		});
		
		$("#netSalvage").bind("input propertychange",function(event){
			computeCost();
		});
		
		$("#useAge").bind("input propertychange",function(event){
			computeCost();
		});
		
		// 计算月折旧额
		function computeCost(){
			var v_asset_worth = $("#initialWorth").val();
			var v_net_salvage = $("#netSalvage").val();
			var v_use_age = $("#useAge").val();
			
			if(v_asset_worth!='' && v_net_salvage!='' && v_use_age!=''){
				// 月折旧额＝（原值－预计净残值）／预计使用期限
				var v_amount = (v_asset_worth-v_net_salvage)/v_use_age;
				$("#monthLossAmount").val(v_amount.toFixed(2));
			}else{
				$("#monthLossAmount").val('');
			}
			computeOpening();
		}
		
		// 计算
		function computeOpening(){
			var v_month_lost = $("#monthLossAmount").val();
			var v_start_use_date = $("#beginUseDate").val();
			var v_begin_date = $("#beginDate").val();
			var v_initial_worth = $("#initialWorth").val();
			var v_net_salvage = $("#netSalvage").val();
			
			if(v_start_use_date!='' && v_month_lost!='' && v_begin_date!=''){
				// 已折旧期数
				v_start_use_date = stringToDate(v_start_use_date);
				v_begin_date = stringToDate(v_begin_date);
				var v_month = getIntervalMonth(v_start_use_date, v_begin_date);
				console.log("dep----"+v_month);
				var v_opening_dep = v_month_lost*v_month;
				var v_opening_amount= v_initial_worth - v_opening_dep-v_net_salvage;
				$("#hasUseAge").val(v_month);
				$("#useAmount").val(v_opening_dep);
				$("#assetWorth").val(v_opening_amount);
			}else{
				$("#hasUseAge").val('');
				$("#assetWorth").val('');
				$("#useAmount").val('');
			}
		}
		
		function selectAssetClass(){
			var v_class = $("#assetClassCode option:selected").val();
			console.log("templateName+"+v_class)
			$.ajax({
				type : 'POST',
				url : '${pageContext.request.contextPath}/assetClass/selectByCode',
				data:'deprecitionType=DEPRECITION&assetClassCode='+v_class,
				async: false,
				success : function(data) {
					console.log("--------+"+data.assetClassCode)
					//console.log(data);
					$("#subjectCode1").val(data.subjectCode1);
					$("#subjectCode2").val(data.subjectCode2);
					$("#useAge").val(data.useAge);
				}
			});
		}
		
		
		function getIntervalMonth(startDate,endDate){
	        var startMonth = startDate.getMonth();
	        var endMonth = endDate.getMonth();
	        var intervalMonth = (endDate.getFullYear()*12+endMonth) - (startDate.getFullYear()*12+startMonth);
	        return intervalMonth;
		}
		
		function stringToDate(dateStr){
		     var separator="-";
		     var dateArr = dateStr.split(separator);
		     var year = parseInt(dateArr[0]);
		     var month;
		     //处理月份为04这样的情况                         
		     if(dateArr[1].indexOf("0") == 0){
		         month = parseInt(dateArr[1].substring(1));
		     }else{
		          month = parseInt(dateArr[1]);
		     }
		     var date = new Date(year,month -1,1);
		     return date;
		 }
	
	</script>
</body>
</html>