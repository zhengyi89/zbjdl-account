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
						
						<table class="table table-bordered" id="tab">
					      <thead>
					        <tr>
					          <th width="5%"></th>
					          <th width="15%">摘要</th>
					          <th width="20%">会计科目</th>
					          <th width="35%">辅助核算</th>
					          <th width="10%">借方金额</th>
					          <th width="10%">贷方金额</th>
					        </tr>
					      </thead>
					      <tbody>
					        <tr>
					          <th scope="row">合计:</th>
					          <td></td>
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
		var index = 0;
		$(function(){
			// 如果是新增页面
			if(${empty id }){
				addRow(index++);
				addRow(index++);
				addRow(index++);
				addRow(index++);
			}
			
			if(${not empty dto1.voucherSubInfoDtos }){
				console.log(${dto1.voucherSubInfoDtos.size()});
			}
			
			for(var i = 0; i < ${dto1.voucherSubInfoDtos.size()}; i++){
				console.log('---'+i);
			}
			if(${not empty dto1.voucherSubInfoDtos[0].assistCode }){
				selectSubject(0);
				$("#assistCode0").val('${dto.voucherSubInfoDtos[0].assistCode }');
			}
			
		})
		
		//删除行;(obj代表连接对象)
	    function del(obj){
	  		obj.parentNode.parentNode.remove();
	  		/* save(); */
	    }
		
	    function add(obj){
	    	index++;
	    	var rows = obj.parentNode.parentNode.rowIndex;
	  		console.log('----'+rows+'----index:'+index);
	  		addRow(rows);
	    }
		
	    
	    function addRow(rows){
	        var html = '<tr><td><a class="" onclick="del(this)">－</a><a class="" onclick="add(this)">＋</a><input type="hidden" class="form-control" value="${dto.voucherSubInfoDtos['+index+'].id}" id="id'+index+
	        '" name="voucherSubInfoDtos['+index+'].id" /><input type="hidden" class="form-control" value="${dto.voucherSubInfoDtos['+index+'].balanceDirect}" id="balanceDirect'+index+'" name="voucherSubInfoDtos['+index+'].balanceDirect" /></td>'+
	        '<td><input type="text" class="form-control" value="${dto.voucherSubInfoDtos['+index+'].summary}" id="summary'+index+'" name="voucherSubInfoDtos['+index+'].summary" /></td>'+
	        '<td><select class="form-control Winstar-input120" id="subjectCode'+index+'" name="voucherSubInfoDtos['+index+'].subjectCode"><option></option>'+
	        '<c:forEach items="${subjectList}" var="subject"><option value="${subject.subjectCode}" <c:if test="${!subject.lastLevel }">disabled</c:if> '+
	        '<c:if test="${subject.subjectCode == dto.voucherSubInfoDtos['+index+'].subjectCode }">selected</c:if>>${subject.subjectCode } ${subject.subjectName }</option></c:forEach>'+
	        '</select></td><td><div class="form-group"><label class="col-lg-4 control-label" id="assistName'+index+'"></label><div class="col-lg-8"><select class="form-control"id="assistCode'+index+'" name="voucherSubInfoDtos['+index+'].assistCode" readonly>'+
	        '</select></div></div></td><td><input type="text" class="form-control" value="${dto.voucherSubInfoDtos['+index+'].debitAmount}" id="debitAmount'+index+
	        '" name="voucherSubInfoDtos['+index+'].debitAmount" /></td><td><input type="text" class="form-control" value="${dto.voucherSubInfoDtos['+index+'].creditAmount}" id="creditAmount'+index+'" name="voucherSubInfoDtos['+index+'].creditAmount" /></td></tr>';
	    	addTr(rows, html);
	    	setEditable(index);
	    }
	    
	    /**
	     * 为table指定行添加一行
	     *
	     * tab 表id
	     * row 行数，如：0->第一行 1->第二行 -2->倒数第二行 -1->最后一行
	     * trHtml 添加行的html代码
	     *
	     */
	    function addTr(row, trHtml){
	       //获取table最后一行 $("#tab tr:last")
	       //获取table第一行 $("#tab tr").eq(0)
	       //获取table倒数第二行 $("#tab tr").eq(-2)
	       var $tr=$("#tab tr").eq(row);
	       if($tr.size()==0){
	          alert("指定的table id或行数不存在！");
	          return;
	       }
	       $tr.after(trHtml);
	    }
		
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
		
		function setEditable(index){
			$('#subjectCode'+index).editableSelect(
			     {
			       bg_iframe: true,
			       onSelect: function(list_item) {},
			       case_sensitive: false, // If set to true, the user has to type in an exact
			       items_then_scroll: 10 ,// If there are more than 10 items, display a scrollbar
			       isFilter:true //If set to true, the item will be filtered according to the matching criteria.
			     }
			 );
		}
			
	</script>
</body>
</html>