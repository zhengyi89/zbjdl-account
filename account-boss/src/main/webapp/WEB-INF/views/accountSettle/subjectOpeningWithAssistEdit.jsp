<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${resourcePath}/bootstrap/bootstrap.min.css" rel="stylesheet">
<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="${resourcePath}/bootstrap/bootstrap.min.js"></script>
<style type="text/css">
    table.table input{ /*可输入区域样式*/
width:100%;
height: 100%;
  
 
border:none; /* 输入框不要边框 */
font-family:Arial;
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
						action="${pageContext.request.contextPath}/accountSettle/save" class="cmxform form-horizontal">
						<table class="table" border="1" id="tableid">
						    <thead>
							    <tr>
							        <th>${_textResource.getSysText('ACCOUNT_ASSIST_TYPE', subject.assistAccount)}</th>
							        <th>方向</th>
							        <th>期初金额</th>
							        <th>本年累积借方金额</th>
							        <th>本年累积贷方金额</th>
							        <th>年初金额</th>
							        <th>操作</th>
							    </tr>
						    </thead>
						    <tbody>
								<c:forEach items="${items}" var="item">
								    <tr>
								    	<td>
								    		<select>
								    			<c:forEach items="${assistList}" var="assist">
								    				<option value="${assist.assistCode}" <c:if test="${assist.assistCode == item.assistCode }">selected</c:if>>${assist.assistCode } ${assist.assistName }</option>
								    			</c:forEach>
						    				</select>
			            				</td>
			            				<td>
			            					${_textResource.getSysText('ACCOUNT_BALANCE_DIRECT', subject.balanceDirect)}
			            				</td>
			            				<td>
			            					<input type="text" name="openingBalance" value="${item.openingBalance.value}"/>
			            				</td>
			            				<td>
			            					<input type="text" name="debitAmount" value="${item.debitAmount.value}"/>
			            				</td>
			            				<td>
			            					<input type="text" name="creditAmount" value="${item.creditAmount.value}"/>
			            				</td>
			            				<td>
			            					${item.yearOpeningBalance.value}
		            					</td>
		            					<td>	
		            						<a class="pink" onclick="deleteRow(this)">删除</a>
			            				</td>
			            			</tr>
			            		</c:forEach>
						    </tbody>
						</table>
						<button onclick="fun();return false;">增加一行</button>
						<!-- <button onclick="del();return false;">删除一行</button>	 -->							
					</form>
					<div class="errorTxt align_center col-lg-12" id="display_error_info_div"></div>
					<div class="form-group">
						<div class="col-lg-12 align_center">
							<button class="btn btn-primary submit" type="submit" onclick="save();">保存</button>
							<!-- <button class="btn btn-primary submit" type="submit" onclick="document.getElementById('godownForma').submit('godownForma');">生成凭证</button> -->
							<button class="btn btn-default button ml_20" type="button"  onclick="history.go(-1)">返回</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	
	 	var i = 1;
	    $(".td").each(function(){
	        $(this).html(i++);
	    })
	 
	 
	    function fun(){
	        $(".table").append('<tr> <td><select><c:forEach items="${assistList}" var="assist"><option value="${assist.assistCode}">${assist.assistCode } ${assist.assistName }</option></c:forEach></select></td> '+
	        		'<td>${_textResource.getSysText("ACCOUNT_BALANCE_DIRECT", subject.balanceDirect)}</td><td><input type="text" name="openingBalance" /></td> <td><input type="text" name="debitAmount" /></td> <td><input type="text" id="creditAmount" name="creditAmount" /></td> <td></td> <td><a class="pink" onclick="window.location.href=${ctx}/assistAccount/edit/index?id=${id}">删除</a></td> </tr>');
	    }
	 
	  	//删除行;(obj代表连接对象)
	    function deleteRow(obj){
	  		obj.parentNode.parentNode.remove();
	  		save();
	    }
	    
	    
	    function save(){
	    	var trs = $("#tableid").find("tr:not(:first)");
	    	
	        var jsonT = '{"id":${dto.id},"subjectId":${dto.subjectId},"accountSettleInfoSaveReqDto":[';
	        trs.each(function (index,ele) {
	        	var v_opening_balance = $(ele).find("input:eq(0)").val();
	        	if(v_opening_balance==null || v_opening_balance ==''){
	        		v_opening_balance = 0;
	        	}
	        	var v_debit_amount = $(ele).find("input:eq(1)").val();
	        	if(v_debit_amount==null || v_debit_amount ==''){
	        		v_debit_amount = 0;
	        	}
	        	var v_credit_amount = $(ele).find("input:eq(2)").val();
	        	if(v_credit_amount==null || v_credit_amount ==''){
	        		v_credit_amount = 0;
	        	}
	            jsonT += '{"assistCode":"' + $(ele).find("select").val() + '","openingBalance":' + v_opening_balance + ',"debitAmount":' 
	            	+ v_debit_amount + ',"creditAmount":' + v_credit_amount + '},';
	        });
            jsonT= jsonT.substr(0, jsonT.length - 1);
            jsonT += "]}";

            console.log(jsonT); 
            $.ajax({
                type: 'post',
                url: '${ctx}/accountSettle/saveWithAssist',
                data: jsonT,
                dataType:'json',
                contentType:'application/json',
                success: function (data) {
                	window.location.reload();
                }
            }); 
	    }
	</script>
</body>
</html>