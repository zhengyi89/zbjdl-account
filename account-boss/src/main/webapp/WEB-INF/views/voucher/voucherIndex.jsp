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
							<label class="col-lg-2 control-label">状态</label>
							<div class="col-lg-3">
								<select class="form-control" id="status" name="status">
									<option value="">全部</option>
									<option value="NORMAL">未审核</option>
									<option value="AUDITED">已审核</option>
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
						<button class="btn btn-primary submit" type="button" onclick="audit(1);">
							审 核<span class="content_blank_10"></span><span class="glyphicon glyphicon-plus"></span>
						</button>
						<button class="btn btn-primary submit" type="button" onclick="audit(0);">
							反审核<span class="content_blank_10"></span><span class="glyphicon glyphicon-plus"></span>
						</button>
						<q:table queryService="queryService" queryKey="queryVoucherList" formId="godownForma"
							class="table table-striped table-bordered" pageSize="30" showExpButton="true" contextUrl="${ctx}/bussinessCode/exportExcel">
							<q:nodata>无符合条件的记录</q:nodata>
							<q:param name="systemCode" value="${SESSION_ACCOUNTINFO.systemCode}" />
							<q:param name="accountMonth" value="${SESSION_ACCOUNTINFO.accountMonth}" />
							<q:column width="3%" escapeHtml="false">
								<q:title><a href="javaScript:;" onclick="checkAll(); id='check'">全选</a></q:title>
								<input type="checkbox" name="checkbox" id="checkboxId" value="${id }">
							</q:column>
				            <q:column title="日期" value="${account_period}" width="20%" dataIndex="account_period"/>
				            <q:column title="凭证字号" value="${serial_num}" width="20%" dataIndex="serial_num"/>
				            <q:column title="摘要" value="${summary}" width="20%" dataIndex="summary" />
				            <q:column title="科目" value="${subject_name}" width="20%" dataIndex="subject_name"/>
				            <q:column title="制单人" value="${creator_name}" width="20%" dataIndex="creator_name"/>
				            <q:column title="审核人" value="${auditor_name}" width="20%" dataIndex="auditor_name"/>
				           
				            <q:column title="操作" escapeHtml="false" width="20%">
							   
							    <c:if test="${status == 'NORMAL'}">
							    	<a class="pink" onclick="window.location.href='${ctx}/voucher/edit/index?id=${id}'">编辑</a>
							    	&nbsp;
							    	<a class="pink" onclick="window.location.href='${ctx}/voucher/operate?id=${id}&operate=AUDIT'">审核</a>
							    </c:if>
							    
							     <c:if test="${status == 'AUDITED'}">
							     	<a class="pink" onclick="window.location.href='${ctx}/voucher/edit/index?id=${id}'">查看</a>
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
	var index = "0";//全选和全不的标识
	function checkAll() {
		var boxes = document.getElementsByName("checkbox");
		if (index == "0") {
			for (i = 0; i < boxes.length; i++) {
				boxes[i].checked = true;
			}
			index = "1";
		} else {
			for (i = 0; i < boxes.length; i++) {
				boxes[i].checked = false;
			}
			index = "0";
		}
	}
	
	// v_flag 1:审核 0:反审核
	function audit(v_flag){
		var boxes = document.getElementsByName("checkbox");
		var checkIds = '';
		for (i = 0; i < boxes.length; i++) {
			if(boxes[i].checked){
				console.log('---i--'+boxes[i].value+',');
				checkIds = checkIds+boxes[i].value+',';
			}
		}
		console.log(checkIds);
		
		$.ajax({
			type : 'POST',
			url : '${pageContext.request.contextPath}/voucher/batchAudit?ids='+checkIds+'&flag='+v_flag,
			async: false,
			success : function(data) {
				if(v_flag){
					alert('审核通过');
				}else{
					alert('反审核成功');
				}
				
				window.location.reload();
			}
		}); 
	}
	
    $(function(){
      
    });
  </script>
</body>
</html>
