<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>会计科目</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/BusinessCode.js"></script>
<script type="text/javascript" src="${resourcePath}/DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div id="content_2" class="content_wrapper">
		<div class="content_main">
			<div class="panel panel-default">
				<div class="panel-heading">内容筛选</div>
				<div class="panel-body">
					<form class="cmxform form-horizontal" action="${pageContext.request.contextPath}/subject/index" 
						method="get" id="godownForma" name="godownForma">
						<div class="form-group">
							<label class="col-lg-2 control-label">科目类别</label>
							<div class="col-lg-3">
								<select class="form-control" id="basicSubject" name="basicSubject">
									<script type="text/javascript">
										BusinessCode.getSysConfigCode("ACCOUNT_SUBJECT_TYPE ", "basicSubject", "$!{query.basicSubject}");
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
						<%-- <q:table queryService="queryService" queryKey="querySubjectList" formId="godownForma"
							class="table table-striped table-bordered" pageSize="100" showExpButton="true" contextUrl="${ctx}/bussinessCode/exportExcel"> --%>
							
						<q:table queryService="queryService" queryKey="querySubjectList" formId="godownForma"
							class="table table-striped table-bordered" pageSize="40" showExpButton="true" contextUrl="${ctx}/bussinessCode/exportExcel">
							<q:nodata>无符合条件的记录</q:nodata>
							<q:param name="systemCode" value="${SESSION_ACCOUNTINFO.systemCode}" />
				            <q:column title="编码" value="${subject_code}" width="20%" dataIndex="subject_code"/>
				            <q:column title="名称" value="${subject_name}" width="20%" dataIndex="subject_name"/>
				            <q:column title="方向" value="${_textResource.getSysText('ACCOUNT_BALANCE_DIRECT', balance_direct)}" width="20%" dataIndex="balance_direct" showValueIndex="ACCOUNT_BALANCE_DIRECT"/>
				            <q:column title="辅助核算" value="${_textResource.getSysText('ACCOUNT_ASSIST_TYPE', assist_account)}" width="20%" />
				            <q:column title="数量" value="${account_unit}" width="20%" />
				            <q:column title="外币" value="${currency_code}" width="20%" />
				            <q:column title="创建时间"  width="20%" >
				            	<fmt:formatDate value="${create_time}" pattern="yyyy-MM-dd HH:mm:ss " />
				            </q:column>
				            <q:column title="状态" width="10%" >
							  	${_textResource.getSysText('ACCOUNT_DATA_STATUS', status)}
							</q:column>
				            <q:column title="操作" escapeHtml="false" width="20%">
				            	<a class="pink" onclick="window.location.href='${ctx}/subject/edit/index?method=ADD&id=${id}'">新增</a>
							    &nbsp;
							    <a class="pink" onclick="window.location.href='${ctx}/subject/edit/index?method=UPDATE&id=${id}'">修改</a>
							    &nbsp;
							    <c:if test="${status == 'NORMAL' }">
							    	<a class="pink" onclick="changeStatus(${id}, 'DISABLE')">停用</a>
							    </c:if>
				            	<c:if test="${status == 'DISABLE' }">
							    	<a class="pink" onclick="changeStatus(${id}, 'NORMAL')">启用</a>
							    </c:if>
							    &nbsp;
				   			    <a class="pink" onclick="changeStatus(${id}, 'DELETE')">删除</a>
							</q:column>
						</q:table>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<!--  end -->
	<script type="text/javascript">
	   	function changeStatus(id, status){
	   		var operate;
	   		if(status == 'DISABLE'){
	   			operate = '停用';
	   		}else if(status == 'NORMAL'){
	   			opreate = '启用';
	   		}else {
	   			opreate = '删除';
	   		}
	   		var mymessage=confirm("此操作将 "+opreate+" 该科目, 是否继续?");
			if(mymessage==true) {  
				window.location.href='${ctx}/subject/operate?id='+id+'&status='+status;
			}
	   	}
  </script>
</body>
</html>
