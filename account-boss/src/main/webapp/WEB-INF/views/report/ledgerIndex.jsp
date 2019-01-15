<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.zbjdl.common.utils.config.TextResource" %>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>总账</title>
<script language="javascript" type="text/javascript" src="${ctx}/static/js/common.js"></script>
<script src="${ctx}/static/js/jquery.js" ></script>
<script src="${ctx}/static/js/jquery.editable-select.js" ></script>
<link  rel="stylesheet"  type="text/css"  href="${ctx}/static/cs/jquery.editable-select.css"/>
</head>
<body>
	<div id="content_2" class="content_wrapper">
		<div class="content_main">
			<div class="panel panel-default">
				<div class="panel-heading">内容筛选</div>
				<div class="panel-body">
					<form class="cmxform form-horizontal" action="${ctx}/report/ledger" method="get"
						method="get" id="companyForm" name="companyForm">
						<!-- 第一组查询条件 -->
						<div class="form-group">
							<label class="control-label col-lg-2">会计科目</label>
							<div class="col-lg-3">
								<select   class = "form-control Winstar-input120"  id="subjectCode" name="subjectCode">
									<c:forEach items="${subjectList}" var="subject">
										<option value="${subject.subjectCode}" <c:if test="${!subject.lastLevel }">disabled</c:if> <c:if test="${subject.subjectCode == subjectCode }">selected</c:if>>${subject.subjectCode } ${subject.subjectName }</option>
									</c:forEach>
								</select>
							</div> 
						</div>
						<div class="form-group">
							<label class="control-label col-lg-2">会计期间（起始）</label>
							<div class="col-lg-3">
								<select class="form-control" id="startdate" name="startdate">
									<c:forEach items="${dateMap}" var="date">
										<option value="${date.key}" <c:if test="${date.key == startdate }">selected</c:if>>
											${date.value } 
										</option>
									</c:forEach>
								</select>
							</div>
							
							<label class="col-lg-2 control-label">会计期间（结束）</label>
							<div class="col-lg-3">
								<select class="form-control" id="enddate" name="enddate">
									<c:forEach items="${dateMap}" var="date">
										<option value="${date.key}" <c:if test="${date.key == startdate }">selected</c:if>>
											${date.value } 
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
				<div class="panel-heading">查询结果</div>
				<div class="panel-body">
					<div class="panel-table">
						<q:table queryService="queryService" queryKey="queryLedgerIndex" formId="godownForma"
							class="table table-striped table-bordered" pageSize="20">
							<q:nodata>无符合条件的记录</q:nodata>
							<q:param name="systemCode" value="${SESSION_ACCOUNTINFO.systemCode}" />
				            <q:column title="日期" value="${account_month}" width="20%" />
				            <q:column title="方向" value="${_textResource.getSysText('ACCOUNT_BALANCE_DIRECT', balance_direct)}" width="20%" />
				            <q:column title="借方(本期合计)" value="${sum_debit_amount}" width="20%" />
				            <q:column title="贷方(本期合计)" value="${sum_credit_amount }" width="20%" />
				            <q:column title="余额" value="${remain_amount }" width="20%" />
				             <q:column title="借方(本年合计)" value="${year_debit_amount}" width="20%" />
				            <q:column title="贷方(本年合计)" value="${year_credit_amount}" width="20%" />
						</q:table>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$('#subjectCode').editableSelect(
		     {
		    	 
		       bg_iframe: true,
		       onSelect: function(list_item) {
		         // 'this' is a reference to the instance of EditableSelect
		         // object, so you have full access to everything there
		        // $('#ddd2').val(this.text.val());
		       },
		       case_sensitive: false, // If set to true, the user has to type in an exact
		                              // match for the item to get highlighted
		       items_then_scroll: 10 ,// If there are more than 10 items, display a scrollbar
		       isFilter:true //If set to true, the item will be filtered according to the matching criteria.
		     }
		 );
		
		
		function onclick(){
			 $('#subjectCode_sele').select();
		}
		
	
  	</script>
</body>
</html>
