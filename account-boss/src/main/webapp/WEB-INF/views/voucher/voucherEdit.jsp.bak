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
.loadingCover{position:fixed;top:0px;left:0px;bottom:0px;right:0px;background:#000;opacity:0.6;filter:alpha(opacity=60);z-index:1101;}
.loadingImg img{position:fixed;top:40%;left:50%;margin-top:-1.5rem;margin-left:-1.5rem;width:3rem;z-index:1102;}
.loadingImg p{position:fixed;top:40%;left:50%;margin-top:3rem;margin-left:-12rem;width:24rem;color:#fff;text-align:center;line-height:2rem;font-size:1.25rem;z-index:1103;}
.vnone{display:none;}
.vhidden{visibility:hidden;height:0px;}
.fl{float:left;}
.fr{float:right;}
</style>
<title>录入凭证</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/BusinessCode.js"></script>
<script language="javascript" type="text/javascript" src="${resourcePath}/jqueryValidation/jquery.validate.min.js"></script>
<script language="javascript" type="text/javascript" src="${resourcePath}/jqueryValidation/messages_zh.js"></script>
<script language="javascript" type="text/javascript" src="${resourcePath}/jqueryValidation/additional-methods.js"></script>
<script type="text/javascript" src="${resourcePath}/DatePicker/WdatePicker.js"></script>
<script src="${ctx}/static/js/voucher/voucher.js" ></script>
<link  rel="stylesheet"  type="text/css"  href="${ctx}/static/cs/jquery.editable-select.css"/>
</head>
<body>
	<div id="content_2" class="content_wrapper">
		<div class="content_main">
			<div class="panel panel-default">
				<div class="panel-heading">记账凭证</div>
				<div class="panel-body">
					<!-- 加载中 -->
		  	<div id="loading" class="vnone">
		  		<div class="loadingCover">
		  				<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">模版名称:</label>
							<div class="col-lg-3">
								<input type="text" class="form-control" id="templateName1" name="templateName1" />
							</div>
						</div>
		  				<div class="form-group">
							<label for="inputPassword3" class="col-lg-2 control-label">保存金额:</label>
							<div class="col-lg-3">
								<input type="radio" name="saveAmount1" value="1" onclick="check(this)">
							</div>
						</div>
		  				<div class="form-group">
						<div class="col-lg-12 align_center">
							<button class="btn btn-primary submit" onclick="saveVoucherTemplate();">保存</button>
							<button class="btn btn-default button ml_20" onclick="cancel()">返回</button>
						</div>
					</div>
						
		  		</div>
		  	</div>
					<form method="post" id="godownForma" name="godownForma"
						action="${pageContext.request.contextPath}/voucher/save" class="cmxform form-horizontal">
						<div class="form-group">
							<input type="hidden" value="${dto.id}" id="id" name="id"> 
							
							<input type="hidden" value="" id="templateName" name="templateName"> 
							<input type="hidden" value="" id="saveAmount" name="saveAmount"> 
							
							<label class="col-lg-2 control-label">凭证字 记</label>
							<div class="col-lg-1">
								<input type="text" class="form-control" value="${dto.serialNum}" id="serialNum" name="serialNum" />
							</div> 
							<label class="col-lg-1 control-label"  style="text-align:left">号</label>
								
							<label for="inputPassword3" class="col-lg-1 control-label">日期</label>
							<div class="col-lg-3">
								<input type="text" name="accountPeriod" id="accountPeriod" class="form-control input_left"  onclick="WdatePicker()" value = "<fmt:formatDate value="${dto.accountPeriod}" dateStyle="default" />"/>
							</div>
							
							<label class="col-lg-2 control-label">附单据</label>
							<div class="col-lg-1">
								<input type="text" class="form-control" value="${dto.voucherPapers}" id="voucherPapers" name="voucherPapers" />
							</div> 
							<label class="col-lg-1 control-label" style="text-align:left">张</label>
						</div>
						<input type="hidden" class="form-control" value="${dto.voucherSubInfoDtos[0].id}" id="id0" name="voucherSubInfoDtos[0].id" />
						<input type="hidden" class="form-control" value="${dto.voucherSubInfoDtos[1].id}" id="id1" name="voucherSubInfoDtos[1].id" />
						<input type="hidden" class="form-control" value="${dto.voucherSubInfoDtos[2].id}" id="id2" name="voucherSubInfoDtos[2].id" />
						<input type="hidden" class="form-control" value="${dto.voucherSubInfoDtos[3].id}" id="id3" name="voucherSubInfoDtos[3].id" />
						<input type="hidden" class="form-control" value="${dto.voucherSubInfoDtos[4].id}" id="id4" name="voucherSubInfoDtos[4].id" />
						<input type="hidden" class="form-control" value="${dto.voucherSubInfoDtos[5].id}" id="id5" name="voucherSubInfoDtos[5].id" />
						
						
						<input type="hidden" class="form-control" value="${dto.voucherSubInfoDtos[0].balanceDirect}" id="balanceDirect0" name="voucherSubInfoDtos[0].balanceDirect" />
						<input type="hidden" class="form-control" value="${dto.voucherSubInfoDtos[1].balanceDirect}" id="balanceDirect1" name="voucherSubInfoDtos[1].balanceDirect" />
						<input type="hidden" class="form-control" value="${dto.voucherSubInfoDtos[2].balanceDirect}" id="balanceDirect2" name="voucherSubInfoDtos[2].balanceDirect" />
						<input type="hidden" class="form-control" value="${dto.voucherSubInfoDtos[3].balanceDirect}" id="balanceDirect3" name="voucherSubInfoDtos[3].balanceDirect" />
						<input type="hidden" class="form-control" value="${dto.voucherSubInfoDtos[4].balanceDirect}" id="balanceDirect4" name="voucherSubInfoDtos[4].balanceDirect" />
						<input type="hidden" class="form-control" value="${dto.voucherSubInfoDtos[5].balanceDirect}" id="balanceDirect5" name="voucherSubInfoDtos[5].balanceDirect" />
						<table class="table table-bordered">
					      <thead>
					        <tr>
					          <th width="15%">摘要</th>
					          <th width="20%">会计科目</th>
					          <th width="35%">辅助核算</th>
					          <th width="10%">借方金额</th>
					          <th width="10%">贷方金额</th>
					        </tr>
					      </thead>
					      <tbody>
					        <tr>
					          <td><input type="text" class="form-control" value="${dto.voucherSubInfoDtos[0].summary}" id="summary0" name="voucherSubInfoDtos[0].summary" /></td>
					          <td>
								<select class="form-control Winstar-input120" id="subjectCode0" name="voucherSubInfoDtos[0].subjectCode">
									<option></option>
									<c:forEach items="${subjectList}" var="subject">
										<option value="${subject.subjectCode}" title="0"  id="0" <c:if test="${!subject.lastLevel }">disabled</c:if> <c:if test="${subject.subjectCode == dto.voucherSubInfoDtos[0].subjectCode }">selected</c:if>>${subject.subjectCode } ${subject.subjectName }</option>
									</c:forEach>
								</select>
					          </td>
					          <td>
					          	<div class="form-group">
									<label class="col-lg-4 control-label" id="assistName0"></label>
									<div class="col-lg-8">
										<select class="form-control"id="assistCode0" name="voucherSubInfoDtos[0].assistCode" readonly>
										</select>
									</div>
									
								</div>
					          </td>
					          <td><input type="text" class="form-control" value="${dto.voucherSubInfoDtos[0].debitAmount}" id="debitAmount0" name="voucherSubInfoDtos[0].debitAmount" /></td>
					          <td><input type="text" class="form-control" value="${dto.voucherSubInfoDtos[0].creditAmount}" id="creditAmount0" name="voucherSubInfoDtos[0].creditAmount" /></td>
					        </tr>
					        <tr>
					          <td><input type="text" class="form-control" value="${dto.voucherSubInfoDtos[1].summary}" id="summary1" name="voucherSubInfoDtos[1].summary" /></td>
					          <td>
								<select class="form-control" id="subjectCode1" name="voucherSubInfoDtos[1].subjectCode">
									<option></option>
									<c:forEach items="${subjectList}" var="subject">
										<option value="${subject.subjectCode}" title="1" id="1"  <c:if test="${!subject.lastLevel }">disabled</c:if> <c:if test="${subject.subjectCode == dto.voucherSubInfoDtos[1].subjectCode }">selected</c:if>>${subject.subjectCode } ${subject.subjectName }</option>
									</c:forEach>
								</select>
					          </td>
					          <td>
					          	<div class="form-group">
									<label class="col-lg-4 control-label" id="assistName1"></label>
									<div class="col-lg-8">
										<select class="form-control" id="assistCode1" name="voucherSubInfoDtos[1].assistCode" readonly>
										</select>
									</div>
									
								</div>
					          </td>
					          <td><input type="text" class="form-control" value="${dto.voucherSubInfoDtos[1].debitAmount}" id="debitAmount1" name="voucherSubInfoDtos[1].debitAmount" /></td>
					          <td><input type="text" class="form-control" value="${dto.voucherSubInfoDtos[1].creditAmount}" id="creditAmount1" name="voucherSubInfoDtos[1].creditAmount" /></td>
					        </tr>
					        <tr>
					          <td><input type="text" class="form-control" value="${dto.voucherSubInfoDtos[2].summary}" id="summary2" name="voucherSubInfoDtos[2].summary" /></td>
					           <td>
								<select class="form-control" id="subjectCode2" name="voucherSubInfoDtos[2].subjectCode">
									<option></option>
									<c:forEach items="${subjectList}" var="subject">
										<option value="${subject.subjectCode}" <c:if test="${!subject.lastLevel }">disabled</c:if> <c:if test="${subject.subjectCode == dto.voucherSubInfoDtos[2].subjectCode }">selected</c:if>>${subject.subjectCode } ${subject.subjectName }</option>
									</c:forEach>
								</select>
					          </td>
					          <td>
					          	<div class="form-group">
									<label class="col-lg-4 control-label" id="assistName2"></label>
									<div class="col-lg-8">
										<select class="form-control" id="assistCode2" name="voucherSubInfoDtos[2].assistCode" readonly>
										</select>
									</div>
									
								</div>
					          </td>
					          <td><input type="text" class="form-control" value="${dto.voucherSubInfoDtos[2].debitAmount}" id="debitAmount2" name="voucherSubInfoDtos[2].debitAmount" /></td>
					          <td><input type="text" class="form-control" value="${dto.voucherSubInfoDtos[2].creditAmount}" id="creditAmount2" name="voucherSubInfoDtos[2].creditAmount" /></td>
					        </tr>
					        <tr>
					          <td><input type="text" class="form-control" value="${dto.voucherSubInfoDtos[3].summary}" id="summary3" name="voucherSubInfoDtos[3].summary" /></td>
					           <td>
								<select class="form-control" id="subjectCode3" name="voucherSubInfoDtos[3].subjectCode">
									<option></option>
									<c:forEach items="${subjectList}" var="subject">
										<option value="${subject.subjectCode}" <c:if test="${!subject.lastLevel }">disabled</c:if> <c:if test="${subject.subjectCode == dto.voucherSubInfoDtos[3].subjectCode }">selected</c:if>>${subject.subjectCode } ${subject.subjectName }</option>
									</c:forEach>
								</select>
					          </td>
					          <td>
					          	<div class="form-group">
									<label class="col-lg-4 control-label" id="assistName3"></label>
									<div class="col-lg-8">
										<select class="form-control" id="assistCode3" name="voucherSubInfoDtos[3].assistCode" readonly>
										</select>
									</div>
									
								</div>
					          </td>
					          <td><input type="text" class="form-control" value="${dto.voucherSubInfoDtos[3].debitAmount}" id="debitAmount3" name="voucherSubInfoDtos[3].debitAmount" /></td>
					          <td><input type="text" class="form-control" value="${dto.voucherSubInfoDtos[3].creditAmount}" id="creditAmount3" name="voucherSubInfoDtos[3].creditAmount" /></td>
					        </tr>
					        <tr>
					          <td><input type="text" class="form-control" value="${dto.voucherSubInfoDtos[4].summary}" id="summary4" name="voucherSubInfoDtos[4].summary" /></td>
					           <td>
								<select class="form-control" id="subjectCode4" name="voucherSubInfoDtos[4].subjectCode">
									<option></option>
									<c:forEach items="${subjectList}" var="subject">
										<option value="${subject.subjectCode}" <c:if test="${!subject.lastLevel }">disabled</c:if> <c:if test="${subject.subjectCode == dto.voucherSubInfoDtos[4].subjectCode }">selected</c:if>>${subject.subjectCode } ${subject.subjectName }</option>
									</c:forEach>
								</select>
					          </td>
					          <td>
					          	<div class="form-group">
									<label class="col-lg-4 control-label" id="assistName4"></label>
									<div class="col-lg-8">
										<select class="form-control" id="assistCode4" name="voucherSubInfoDtos[4].assistCode" readonly>
										</select>
									</div>
									
								</div>
					          </td>
					          <td><input type="text" class="form-control" value="${dto.voucherSubInfoDtos[4].debitAmount}" id="debitAmount4" name="voucherSubInfoDtos[4].debitAmount" /></td>
					          <td><input type="text" class="form-control" value="${dto.voucherSubInfoDtos[4].creditAmount}" id="creditAmount4" name="voucherSubInfoDtos[4].creditAmount" /></td>
					        </tr>
					        <tr>
					          <td><input type="text" class="form-control" value="${dto.voucherSubInfoDtos[5].summary}" id="summary5" name="voucherSubInfoDtos[5].summary" /></td>
					           <td>
								<select class="form-control" id="subjectCode5" name="voucherSubInfoDtos[5].subjectCode">
									<option></option>
									<c:forEach items="${subjectList}" var="subject">
										<option value="${subject.subjectCode}" <c:if test="${!subject.lastLevel }">disabled</c:if> <c:if test="${subject.subjectCode == dto.voucherSubInfoDtos[5].subjectCode }">selected</c:if>>${subject.subjectCode } ${subject.subjectName }</option>
									</c:forEach>
								</select>
					          </td>
					          <td>
					          	<div class="form-group">
									<label class="col-lg-4 control-label" id="assistName5"></label>
									<div class="col-lg-8">
										<select class="form-control" id="assistCode5" name="voucherSubInfoDtos[5].assistCode" readonly>
										</select>
									</div>
									
								</div>
					          </td>
					          <td><input type="text" class="form-control" value="${dto.voucherSubInfoDtos[5].debitAmount}" id="debitAmount5" name="voucherSubInfoDtos[5].debitAmount" /></td>
					          <td><input type="text" class="form-control" value="${dto.voucherSubInfoDtos[5].creditAmount}" id="creditAmount5" name="voucherSubInfoDtos[5].creditAmount" /></td>
					        </tr>
					        <tr>
					          <th scope="row">合计:</th>
					          <td></td>
					          <td></td>
					          <td></td>
					          <td></td>
					        </tr>
					      </tbody>
					    </table>
					</form>
					<div class="form-group">
						<div class="col-lg-12 align_center">
							<button class="btn btn-primary submit" type="submit" onclick="document.getElementById('godownForma').submit('godownForma');">保存</button>
							<a href="${pageContext.request.contextPath}/voucher/index">
								<button class="btn btn-default button ml_20" type="button">返回</button>
							</a>
							<button class="btn btn-primary submit" type="submit" onclick="saveTip();">保存凭证模版</button>
							<button class="btn btn-primary submit" type="submit" onclick="useTemplate();">使用凭证模版</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			if(${not empty dto.voucherSubInfoDtos[0].assistCode }){
				selectSubject(0);
				$("#assistCode0").val('${dto.voucherSubInfoDtos[0].assistCode }');
			}
			if(${not empty dto.voucherSubInfoDtos[1].assistCode }){
				selectSubject(1);
				$("#assistCode1").val('${dto.voucherSubInfoDtos[1].assistCode }');
			}
			if(${not empty dto.voucherSubInfoDtos[2].assistCode }){
				selectSubject(2);
				$("#assistCode2").val('${dto.voucherSubInfoDtos[2].assistCode }');
			}
			if(${not empty dto.voucherSubInfoDtos[3].assistCode }){
				selectSubject(3);
				$("#assistCode3").val('${dto.voucherSubInfoDtos[3].assistCode }');
			}
			if(${not empty dto.voucherSubInfoDtos[4].assistCode }){
				selectSubject(4);
				$("#assistCode4").val('${dto.voucherSubInfoDtos[4].assistCode }');
			}
			if(${not empty dto.voucherSubInfoDtos[5].assistCode }){
				selectSubject(5);
				$("#assistCode5").val('${dto.voucherSubInfoDtos[5].assistCode }');
			}
			
		})
		
		function cancel(){
			$("#loading").hide();
		}
		
		function saveTip(){
			$("#loading").show();
		}
		
		function useTemplate(){
			 window.location.href="${pageContext.request.contextPath}/voucher/templateIndex"; 
		}
		
		
		function saveVoucherTemplate(){
			var v_tn = $("#templateName1").val();
			var v_sa = $('input:radio:checked').val();
			console.log("templateName+"+v_sa)
			$("#templateName").val(v_tn);
			$("#saveAmount").val(v_sa);
			console.log("templateName+"+$("#saveAmount").val());
			$.ajax({
				type : 'POST',
				url : '${pageContext.request.contextPath}/voucher/saveTemplate',
				data:$('#godownForma').serialize(),
				async: false,
				success : function(data) {
					window.location.reload();
				}
			});
		}
		
		var tempradio= null;
		function check(checkedRadio){
		 if(tempradio== checkedRadio){
	            tempradio.checked=false;
	            tempradio=null;
	        }
	        else{
	            tempradio= checkedRadio;
	        }
	    }
		
		function selectSubject(index){
			$("#assistCode"+index).empty();
			$("#assistCode"+index).attr("readonly", true);
			$("#balanceDirect"+index).val(null);
			$("#assistName"+index).html("");
			var subjectCode=$("#subjectCode"+index).val();
			console.log('subjectCode---'+subjectCode);
			if(subjectCode == ''){
				return;
			}
			$.ajax({
				async: false,
				type : 'POST',
				url : '${pageContext.request.contextPath}/subject/selectByCode?subjectCode='+subjectCode,
				success : function(data) {
					console.log(data.subjectName);
					console.log('assistAccount--'+data.assistAccount);
					$("#balanceDirect"+index).val(data.balanceDirect);
					var v_assistAccountName = data.assistAccountName;
					if(data.assistAccount!='' && data.assistAccount!=null){
						$.ajax({
							async: false,
							type : 'POST',
							url : '${pageContext.request.contextPath}/assistAccount/findByType?assistType='+data.assistAccount,
							success : function(data) {
								if(data != null){
									$("#assistName"+index).html(v_assistAccountName);
									//根据id查找对象，
								    var obj=document.getElementById('assistCode'+index);
									obj.options.length=0;
									$("#assistCode"+index).attr("readonly", false);
									obj.options.add(new Option("",""));
									$.each(data, function(index, item){
									   	console.log('assistName--'+item.assistName);
									    //添加一个选项
									    obj.options.add(new Option(item.assistName,item.assistCode)); //这个兼容IE与firefox
									});
								}
							}
						});
					}
				}
			});
		}
		
		$('#subjectCode0').editableSelect(
		     {
		       bg_iframe: true,
		       onSelect: function(list_item) {},
		       case_sensitive: false, // If set to true, the user has to type in an exact
		       items_then_scroll: 10 ,// If there are more than 10 items, display a scrollbar
		       isFilter:true //If set to true, the item will be filtered according to the matching criteria.
		     }
		 );
			
		$('#subjectCode1').editableSelect(
		     {
		       bg_iframe: true,
		       onSelect: function(list_item) {},
		       case_sensitive: false, // If set to true, the user has to type in an exact
		       items_then_scroll: 10 ,// If there are more than 10 items, display a scrollbar
		       isFilter:true //If set to true, the item will be filtered according to the matching criteria.
		     }
		 );
			
		$('#subjectCode2').editableSelect(
		     {
		       bg_iframe: true,
		       onSelect: function(list_item) {},
		       case_sensitive: false, // If set to true, the user has to type in an exact
		       items_then_scroll: 10 ,// If there are more than 10 items, display a scrollbar
		       isFilter:true //If set to true, the item will be filtered according to the matching criteria.
		     }
		 );
			
		$('#subjectCode3').editableSelect(
		     {
		       bg_iframe: true,
		       onSelect: function(list_item) {},
		       case_sensitive: false, // If set to true, the user has to type in an exact
		       items_then_scroll: 10 ,// If there are more than 10 items, display a scrollbar
		       isFilter:true //If set to true, the item will be filtered according to the matching criteria.
		     }
		 );
			
		$('#subjectCode4').editableSelect(
		     {
		       bg_iframe: true,
		       onSelect: function(list_item) {},
		       case_sensitive: false, // If set to true, the user has to type in an exact
		       items_then_scroll: 10 ,// If there are more than 10 items, display a scrollbar
		       isFilter:true //If set to true, the item will be filtered according to the matching criteria.
		     }
		 );
			
		$('#subjectCode5').editableSelect(
		     {
		       bg_iframe: true,
		       onSelect: function(list_item) {},
		       case_sensitive: false, // If set to true, the user has to type in an exact
		       items_then_scroll: 10 ,// If there are more than 10 items, display a scrollbar
		       isFilter:true //If set to true, the item will be filtered according to the matching criteria.
		     }
		 );
			
	</script>
</body>
</html>