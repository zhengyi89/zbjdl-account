<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.zbjdl.common.utils.config.TextResource"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>凭证列表</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/BusinessCode.js"></script>
<script type="text/javascript" src="${resourcePath}/DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div id="content_2" class="content_wrapper">
		<div class="content_main">
			<div class="panel panel-default">
				<div class="panel-heading">内容筛选</div>
				<div class="panel-body">
					<form class="cmxform form-horizontal" action="${pageContext.request.contextPath}/voucher/index" 
						method="get" id="godownForma" name="godownForma">
						<div class="form-group">
							<label class="col-lg-2 control-label">科目类别</label>
							<div class="col-lg-3">
								<select class="form-control" id="basicVoucher" name="basicVoucher">
									<script type="text/javascript">
										BusinessCode.getSysConfigCode("ACCOUNT_SUBJECT_TYPE ", "basicVoucher", "$!{query.basicVoucher}");
									</script>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-lg-12 align_center">
								<button class="btn btn-primary submit ml_20" type="submit">查 询</button>
								<button class="btn btn-primary submit ml_20" type="button" onclick="BusinessCode.clearAllInput('godownForma');">清空</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">查询结果</div>
				<div class="panel-body">
					<div class="panel-table">
						<q:table queryService="queryService" queryKey="queryVoucherList" formId="godownForma"
							class="table table-striped table-bordered" pageSize="40" showExpButton="true" contextUrl="${ctx}/bussinessCode/exportExcel">
							<q:nodata>无符合条件的记录</q:nodata>
				            <q:column title="日期" value="${account_period}" width="20%" dataIndex="voucher_code"/>
				            <q:column title="凭证字号" value="${serial_num}" width="20%" dataIndex="voucher_name"/>
				            <q:column title="摘要" value="${summary}" width="20%" dataIndex="balance_direct" />
				            <q:column title="科目" value="${subject_name}" width="20%" />
				            <q:column title="借方金额" value="${debit_amount}" width="20%" />
				            <q:column title="贷方金额" value="${credit_amount}" width="20%" />
				            <q:column title="制单人" value="${creator_name}" width="20%" />
				            <q:column title="审核人" value="${auditor_name}" width="20%" />
				           
				            <q:column title="操作" escapeHtml="false" width="20%">
							   
							    <c:if test="${status == 'NORMAL'}">
							    	<a class="pink" onclick="window.location.href='${ctx}/voucher/edit/index?id=${id}'">编辑</a>
							    	&nbsp;
							    	<a class="pink" onclick="window.location.href='${ctx}/voucher/operate?id=${id}&operate=AUDIT'">审核</a>
							    </c:if>
							    
							     <c:if test="${status == 'AUDITED'}">
							     	<a class="pink" onclick="window.location.href='${ctx}/voucher/edit/index?id=${id}'">详细</a>
							    	&nbsp;
							    	<a class="pink" onclick="window.location.href='${ctx}/voucher/operate?id=${id}&operate=UNAUDIT'">反审核</a>
							     </c:if>
							    
							    &nbsp;
							</q:column>
						</q:table>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<!--  end -->
	<script type="text/javascript">
    $(function(){
      
    });
  </script>
</body>
</html>
