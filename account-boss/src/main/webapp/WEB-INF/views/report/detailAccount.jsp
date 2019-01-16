<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.zbjdl.common.utils.config.TextResource" %>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>总账</title>
<script language="javascript" type="text/javascript" src="${ctx}/static/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap-datetimepicker/js/bootstrap-datetimepicker.zh-CN.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css"/>
<script src="${ctx}/static/js/jquery.js" ></script>
<script src="${ctx}/static/js/jquery.editable-select.js" ></script>
<link  rel="stylesheet"  type="text/css"  href="${ctx}/static/cs/jquery.editable-select.css"/>
 <%pageContext.setAttribute("_textResource", new TextResource()); %>
</head>
<body>
    <%pageContext.setAttribute("_textResource", new TextResource()); %>
	<div id="content_2" class="content_wrapper">
		<div class="content_main">
			<div class="panel panel-default">
				<div class="panel-heading">内容筛选</div>
				<div class="panel-body">
					<form class="cmxform form-horizontal" action="${ctx}/report/detailAccount" method="get"
						method="get" id="companyForm" name="companyForm">
						<!-- 第一组查询条件 -->
						<div class="form-group">
							<label class="control-label col-lg-2">会计科目</label>
							<div class="col-lg-3">
								<select   class = "form-control Winstar-input120"  id="subjectCode" name="subjectCode" onchange="selectSubject()">
									<c:forEach items="${subjectList}" var="subject">
										<option value="${subject.subjectCode}" <c:if test="${!subject.lastLevel }">disabled</c:if> <c:if test="${subject.subjectCode == subjectCode }">selected</c:if>>${subject.subjectCode } ${subject.subjectName }</option>
									</c:forEach>
								</select>
							</div> 
							
							<label class="control-label col-lg-2" id="assistName"></label>
							<div class="col-lg-3" id="assistDiv" hidden=true>
								<select class="form-control" id="assistCode" name="assistCode">
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-lg-2">会计期间（起始）</label>
							<div class="col-lg-3">
								<select class="form-control" id="startdate" name="startdate">
									<c:forEach items="${SESSION_ACCOUNTINFO.dateSet}" var="date">
										<option value="${date}" <c:if test="${date == startdate}">selected</c:if>>
											${date } 
										</option>
									</c:forEach>
								</select>
							</div>
							
							<label class="col-lg-2 control-label">会计期间（结束）</label>
							<div class="col-lg-3">
								<select class="form-control" id="enddate" name="enddate">
									<c:forEach items="${SESSION_ACCOUNTINFO.dateSet}" var="date">
										<option value="${date}" <c:if test="${date == enddate }">selected</c:if>>
											${date } 
										</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-11 align_center">
								<a onclick="document.getElementById('companyForm').submit();">
									<button class="btn btn-primary submit ml_20" type="submit">查 询</button>
								</a>
								<a onclick="clearAllInput('companyForm');">
									<button class="btn btn-default button" type="button">清 除</button>
								</a>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="panel-table">
						<table id="tab" class="table table-striped table-bordered">
							<tbody>
								<tr>
									<th width="15%"> 
										<span>期间</span>
									</th>
									<th width="10%"> 
										<span>凭证</span>
									</th>
									<th width="20%"> 
										<span>摘要</span>
									</th>
									<th width="15%"> 
										<span>借方</span>
									</th>
									<th width="15%"> 
										<span>贷方</span>
									</th>
									<th width="10%"> 
										<span>方向</span>
									</th>
									<th width="15%"> 
										<span>余额</span>
									</th>
								</tr>
								<c:forEach items="${resultList}" var="item">
									<tr class="">
										<td width=""><span>${item.accountMonth }</span></td>
										<td width=""><span>
											<a>
												<c:if test="${not empty item.serialNum }">记－</c:if>${item.serialNum }
											</a>
										</span></td>
										<td width=""><span>${item.summary }</span></td>
										<td width=""><span>${item.debitAmount }</span></td>
										<td width=""><span>${item.creditAmount }</span></td>
										<td width=""><span>${_textResource.getSysText('ACCOUNT_BALANCE_DIRECT', subject.balanceDirect)}</span></td>
										<td width="">${item.remainAmount }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		selectSubject();
		$("#assistCode").val('${assistCode }');
	})
	
	
	$('#subjectCode').editableSelect(
	     {
	       bg_iframe: true,
	       onSelect: function(list_item) {
	    	   console.log('-----'+this.text.val());
	    	   selectSubject();
	       },
	       case_sensitive: false,
	       items_then_scroll: 10 ,
	       isFilter:true 
	     }
	 );
	
	function selectSubject(){
			$("#assistCode").empty();
			$("#assistDiv").attr("hidden", true);
			$("#assistName").html("");
			var subjectCode=$("#subjectCode").val();
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
					if(data.assistAccount!='' && data.assistAccount!=null){
						var v_assistAccountName = data.assistAccountName;
						$("#assistName").html(v_assistAccountName);
						$("#assistCode").attr("hidden", false);
						$("#assistDiv").attr("hidden", false);
						$.ajax({
							async: false,
							type : 'POST',
							url : '${pageContext.request.contextPath}/assistAccount/findByType?assistType='+data.assistAccount,
							success : function(data) {
								if(data != null){
									//根据id查找对象，
								    var obj=document.getElementById('assistCode');
									obj.options.length=0;
									obj.options.add(new Option("全部",""));
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
  </script>
</body>
</html>
