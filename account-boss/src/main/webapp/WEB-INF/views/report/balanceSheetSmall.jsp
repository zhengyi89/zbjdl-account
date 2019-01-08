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
</head>
<body>
	<div id="content_2" class="content_wrapper">
		<div class="content_main">
			<div class="panel panel-default">
				<div class="panel-heading">内容筛选</div>
			</div>
			
			<div class="col-md-12" style="background-color: #fff;">
	          <table class="table table-bordered" >
	            <thead>
	              <tr>
	                <th>资产</th>
	                <th>行次</th>
	                <th>期末余额</th>
	                <th>年初余额</th>
	                <th>负债和所有者（或股东）权益</th>
	                <th>行次</th>
	                <th>期末余额</th>
	                <th>年初余额</th>
	              </tr>
	            </thead>
	            <tbody>
	              <tr>
	                <td>流动资产：</td> <td></td> <td></td> <td></td>
	                <td>流动负债：</td> <td></td> <td></td> <td></td>
	              </tr>
	               <tr>
	                <td><span style="padding-left: 10%">货币资金</span></td><td>1</td><td id="11">${dto["1001"].closingBalance.add(dto["1002"].closingBalance).add(dto["1012"].closingBalance)  }</td><td id="12">${dto["1001"].yearOpeningBalance.add(dto["1002"].yearOpeningBalance).add(dto["1012"].yearOpeningBalance) }</td>
	                <td><span style="padding-left: 10%">短期借款</span></td><td>31</td><td id="311">${dto["2001"].closingBalance  }</td><td id="312">${dto["2001"].yearOpeningBalance  }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">短期投资</span></td><td>2</td><td id="21">${dto["1101"].closingBalance  }</td><td id="22">${dto["1101"].yearOpeningBalance  }</td>
	                <td><span style="padding-left: 10%">应付票据</span></td><td>32</td><td id="321">${dto["2201"].closingBalance  }</td><td id="322">${dto["2201"].yearOpeningBalance  }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">应收票据</span></td><td>3</td><td id="31">${dto["1121"].closingBalance  }</td><td id="32">${dto["1121"].yearOpeningBalance  }</td>
	                <td><span style="padding-left: 10%">应付账款</span></td><td>33</td><td id="331">${dto["2202"].closingBalance  }</td><td id="332">${dto["2202"].yearOpeningBalance  }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">应收账款</span></td><td>4</td><td id="41">${dto["1122"].closingBalance  }</td><td id="42">${dto["1122"].yearOpeningBalance  }</td>
	                <td><span style="padding-left: 10%">预收账款</span></td><td>34</td><td id="341">${dto["2203"].closingBalance  }</td><td id="342">${dto["2203"].yearOpeningBalance  }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">预付账款</span></td><td>5</td><td id="51">${dto["1123"].closingBalance  }</td><td id="52">${dto["1123"].yearOpeningBalance  }</td>
	                <td><span style="padding-left: 10%">应付职工薪酬</span></td><td>35</td><td id="351">${dto["2211"].closingBalance  }</td><td id="352">${dto["2211"].yearOpeningBalance  }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">应收股利</span></td><td>6</td><td id="61">${dto["1131"].closingBalance  }</td><td id="62">${dto["1131"].yearOpeningBalance  }</td>
	                <td><span style="padding-left: 10%">应交税费</span></td><td>36</td><td id="361">${dto["2221"].closingBalance  }</td><td id="362">${dto["2221"].yearOpeningBalance  }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">应收利息</span></td><td>7</td><td id="71">${dto["1132"].closingBalance  }</td><td id="72">${dto["1132"].yearOpeningBalance  }</td>
	                <td><span style="padding-left: 10%">应付利息</span></td><td>37</td><td id="371">${dto["2231"].closingBalance  }</td><td id="372">${dto["2231"].yearOpeningBalance  }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">其他应收款</span></td><td>8</td><td id="81">${dto["1221"].closingBalance  }</td><td id="82">${dto["1221"].yearOpeningBalance  }</td>
	                <td><span style="padding-left: 10%">应付利润</span></td><td>38</td><td id="381">${dto["2232"].closingBalance  }</td><td id="382">${dto["2232"].yearOpeningBalance  }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">存货</span></td><td>9</td><td id="91">${dto["1401"].closingBalance  }</td><td id="92">${dto["1401"].yearOpeningBalance  }</td>
	                <td><span style="padding-left: 10%">其他应付款</span></td><td>39</td><td id="391">${dto["2241"].closingBalance  }</td><td id="392">${dto["2241"].yearOpeningBalance  }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">其中：原材料</span></td><td>10</td><td id="101">${dto["1403"].closingBalance  }</td><td id="102">${dto["1403"].yearOpeningBalance  }</td>
	                <td><span style="padding-left: 10%">其他流动负债</span></td><td>40</td><td id="401">${dto["2251"].closingBalance  }</td><td id="402">${dto["2251"].yearOpeningBalance  }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">在产品</span></td><td>11</td><td id="111">${dto["4401"].closingBalance  }</td><td id="112">${dto["4401"].yearOpeningBalance  }</td>
	                <td><span style="padding-left: 20%">流动负债合计</span></td><td>41</td><td id="411"></td><td id="412"></td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 20%">库存商品</span></td><td>12</td><td id="121">${dto["1405"].closingBalance.add(dto["1407"].closingBalance)  }</td><td id="122">${dto["1405"].yearOpeningBalance.add(dto["1407"].yearOpeningBalance)  }</td>
	                <td>非流动负债：</td><td></td><td></td><td></td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">周转材料</span></td><td>13</td><td id="131">${dto["1411"].closingBalance }</td><td id="132">${dto["1411"].yearOpeningBalance }</td>
	                <td><span style="padding-left: 10%">长期借款</span></td><td>42</td><td id="421">${dto["2501"].closingBalance }</td><td id="422">${dto["2501"].yearOpeningBalance }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">其他流动资产</span></td><td>14</td><td id="141">${dto["1901"].closingBalance }</td><td id="142">${dto["1901"].yearOpeningBalance }</td>
	                <td><span style="padding-left: 10%">长期应付款</span></td><td>43</td><td id="431">${dto["2701"].closingBalance }</td><td id="432">${dto["2701"].yearOpeningBalance }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 20%">流动资产合计</span></td><td>15</td><td id="151"></td><td id="152"></td>
	                <td><span style="padding-left: 10%">递延收益</span></td><td>44</td><td id="441">${dto["2401"].closingBalance }</td><td id="442">${dto["2401"].yearOpeningBalance }</td>
	              </tr>
	              <tr>
	                <td>非流动资产：</td><td></td><td></td><td></td>
	                <td><span style="padding-left: 10%">其他非流动负债</span></td><td>45</td><td id="451">0</td><td id="2">0</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">长期债券投资</span></td><td>16</td><td id="161">${dto["1501"].closingBalance }</td><td id="162">${dto["1501"].yearOpeningBalance }</td>
	                <td><span style="padding-left: 20%">非流动负债合计</span></td><td>46</td><td id="461"></td><td id="462"></td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">长期股权投资</span></td><td>17</td><td id="171">${dto["1511"].closingBalance }</td><td id="172">${dto["1511"].yearOpeningBalance }</td>
	                <td><span style="padding-left: 20%">负债合计</span></td><td>47</td><td id="471"></td><td id="472"></td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">固定资产原价</span></td><td>18</td><td id="181">${dto["1601"].closingBalance }</td><td id="182">${dto["1601"].yearOpeningBalance }</td>
	             	<td></td><td></td><td></td><td></td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">减：累计折旧</span></td><td>19</td><td id="191">${dto["1602"].closingBalance }</td><td id="192">${dto["1602"].yearOpeningBalance }</td>
	              	<td></td><td></td><td></td><td></td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">固定资产账面价值</span></td><td>20</td><td id="201"></td><td id="202"></td>
	                <td></td><td></td><td></td><td></td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">在建工程</span></td><td>21</td><td id="211">${dto["1604"].closingBalance }</td><td id="212">${dto["1604"].yearOpeningBalance }</td>
	                <td></td><td></td><td></td><td></td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">工程物资</span></td><td>22</td><td id="221">${dto["1605"].closingBalance }</td><td id="222">${dto["1605"].yearOpeningBalance }</td>
	                <td></td><td></td><td></td><td></td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">固定资产清理</span></td><td>23</td><td id="231">${dto["1606"].closingBalance }</td><td id="232">${dto["1606"].yearOpeningBalance }</td>
	                <td></td><td></td><td></td><td></td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">生产性生物资产</span></td><td>24</td><td id="241">${dto["1621"].closingBalance.subtract(dto["1622"].closingBalance)  }</td><td id="242">${dto["1621"].yearOpeningBalance.subtract(dto["1622"].yearOpeningBalance)  }</td>
	                <td>所有者权益（或股东权益）：</td><td></td><td></td><td></td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">无形资产</span></td><td>25</td><td id="251">${dto["1701"].closingBalance.subtract(dto["1702"].closingBalance)  }</td><td id="252">${dto["1701"].yearOpeningBalance.subtract(dto["1702"].yearOpeningBalance)  }</td>
	                <td><span style="padding-left: 10%">实收资本（或股本）</span></td><td>48</td><td id="481">${dto["3001"].closingBalance }</td><td id="482">${dto["3001"].yearOpeningBalance }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">开发支出</span></td><td>26</td><td id="261">${dto["4301"].closingBalance }</td><td id="262">${dto["4301"].yearOpeningBalance }</td>
	                <td><span style="padding-left: 10%">资本公积</span></td><td>49</td><td id="491">${dto["3002"].closingBalance }</td><td id="492">${dto["3002"].yearOpeningBalance }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">长期待摊费用</span></td><td>27</td><td id="271">${dto["1801"].closingBalance }</td><td id="272">${dto["1801"].yearOpeningBalance }</td>
	                <td><span style="padding-left: 10%">盈余公积</span></td><td>50</td><td id="501">${dto["3101"].closingBalance }</td><td id="502">${dto["3101"].yearOpeningBalance }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">其他非流动资产</span></td><td>28</td><td id="281">0</td><td id="282">0</td>
	                <td><span style="padding-left: 10%">未分配利润</span></td><td>51</td><td id="511">${dto["3103"].closingBalance.add(dto["3104"].closingBalance)  }</td><td id="512">${dto["3103"].yearOpeningBalance.add(dto["3104"].yearOpeningBalance)  }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 20%">非流动资产合计</span></td><td>29</td><td id="291"></td><td id="292"></td>
	                <td><span style="padding-left: 20%">所有者权益（或股东权益）合计</span></td><td>52</td><td id="521"></td><td id="522"></td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 20%">资产总计</span></td><td>30</td><td id="301"></td><td id="302"></td>
	                <td><span style="padding-left: 20%">负债和所有者权益</span></td><td>53</td><td id="531"></td><td id="532"></td>
	              </tr>
	            </tbody>
	          </table>
        </div>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		
		var v_151 = Number($("#11").text())+Number($("#21").text())+Number($("#31").text())+Number($("#41").text())+Number($("#51").text())
		+Number($("#61").text())+Number($("#71").text())+Number($("#81").text())+Number($("#91").text())+Number($("#111").text())
		+Number($("#121").text())+Number($("#131").text())+Number($("#141").text());
		var v_201 = Number($("#161").text())+Number($("#171").text())+Number($("#181").text())-Number($("#191").text());
		var v_291 = v_201+Number($("#211").text())+Number($("#221").text())+Number($("#231").text())+Number($("#241").text())+Number($("#251").text())
		+Number($("#261").text())+Number($("#271").text())+Number($("#281").text());
		var v_301 = v_151+v_291;
		var v_411 = Number($("#311").text())+Number($("#321").text())+Number($("#331").text())+Number($("#341").text())+Number($("#351").text())+Number($("#361").text())
		+Number($("#371").text())+Number($("#381").text())+Number($("#391").text())+Number($("#401").text())
		var v_461 = Number($("#421").text())+Number($("#431").text())+Number($("#441").text())+Number($("#451").text());
		var v_471 = v_411+v_461;
		var v_521 = Number($("#481").text())+Number($("#491").text())+Number($("#501").text())+Number($("#511").text());
		var v_531 = v_471+v_521;
		$("#151").text(v_151.toFixed(2));
		$("#201").text(v_201.toFixed(2));
		$("#291").text(v_291.toFixed(2));
		$("#301").text(v_301.toFixed(2));
		$("#411").text(v_411);
		$("#461").text(v_461);
		$("#471").text(v_471);
		$("#521").text(v_521);
		$("#531").text(v_531);
		
		
		var v_152 = Number($("#12").text())+Number($("#22").text())+Number($("#32").text())+Number($("#42").text())+Number($("#52").text())
			+Number($("#62").text())+Number($("#72").text())+Number($("#82").text())+Number($("#92").text())+Number($("#112").text())
			+Number($("#122").text())+Number($("#132").text())+Number($("#142").text());
		var v_202 = Number($("#162").text())+Number($("#171").text())+Number($("#182").text())-Number($("#192").text());
		var v_292 = v_202+Number($("#212").text())+Number($("#222").text())+Number($("#232").text())+Number($("#242").text())+Number($("#252").text())
			+Number($("#262").text())+Number($("#272").text())+Number($("#282").text());
		var v_302 = v_152+v_292;
		var v_412 = Number($("#312").text())+Number($("#322").text())+Number($("#332").text())+Number($("#342").text())+Number($("#352").text())+Number($("#362").text())
			+Number($("#372").text())+Number($("#382").text())+Number($("#392").text())+Number($("#402").text())
		var v_462 = Number($("#422").text())+Number($("#432").text())+Number($("#442").text())+Number($("#452").text());
		var v_472 = v_412+v_462;
		var v_522 = Number($("#482").text())+Number($("#492").text())+Number($("#502").text())+Number($("#512").text());
		var v_532 = v_472+v_522;
		$("#152").text(v_152.toFixed(2));
		$("#202").text(v_202.toFixed(2));
		$("#292").text(v_292.toFixed(2));
		$("#302").text(v_302.toFixed(2));
		$("#412").text(v_412.toFixed(2));
		$("#462").text(v_462.toFixed(2));
		$("#472").text(v_472.toFixed(2));
		$("#522").text(v_522.toFixed(2));
		$("#532").text(v_532.toFixed(2));
	})
	$('.form_datetime').datetimepicker({
        format: 'yyyy-mm',
        autoclose: true,
        todayBtn: true,
        startView: 'year',
        minView:'year',
        maxView:'decade',
        language:  'zh-CN',
    });
  	</script>
</body>
</html>
