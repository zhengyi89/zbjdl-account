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
	                <td><span style="padding-left: 10%">货币资金</span></td><td>1</td>
	                <td id="11">${dto["1001"].closingBalance.add(dto["1002"].closingBalance).add(dto["1003"].closingBalance).add(dto["1011"].closingBalance).add(dto["1012"].closingBalance).add(dto["1021"].closingBalance).add(dto["1031"].closingBalance).add(dto["1032"].closingBalance).add(dto["1301"].closingBalance).add(dto["1302"].closingBalance)  }</td>
	                <td id="12">${dto["1001"].yearOpeningBalance.add(dto["1002"].yearOpeningBalance).add(dto["1003"].yearOpeningBalance).add(dto["1011"].yearOpeningBalance).add(dto["1012"].yearOpeningBalance).add(dto["1021"].yearOpeningBalance).add(dto["1031"].yearOpeningBalance).add(dto["1032"].yearOpeningBalance).add(dto["1301"].yearOpeningBalance).add(dto["1302"].yearOpeningBalance)  }</td>
	                <td><span style="padding-left: 10%">短期借款</span></td><td>32</td>
	                <td id="311">${dto["2001"].closingBalance.add(dto["1303"].closingBalance).subtract(dto["1304"].closingBalance)  }</td>
	                <td id="312">${dto["2001"].yearOpeningBalance.add(dto["1303"].yearOpeningBalance).subtract(dto["1304"].yearOpeningBalance)  }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">交易性金融资产</span></td><td>2</td><td id="21">${dto["1101"].closingBalance.add(dto["1111"].closingBalance)  }</td><td id="22">${dto["1101"].yearOpeningBalance.add(dto["1111"].yearOpeningBalance)   }</td>
	                <td><span style="padding-left: 10%">交易性金融负债</span></td><td>33</td><td id="331">${dto["2101"].closingBalance  }</td><td id="332">${dto["2101"].yearOpeningBalance  }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">应收票据</span></td><td>3</td><td id="31">${dto["1121"].closingBalance  }</td><td id="32">${dto["1121"].yearOpeningBalance  }</td>
	                <td><span style="padding-left: 10%">应付票据</span></td><td>34</td><td id="341">${dto["2201"].closingBalance  }</td><td id="342">${dto["2201"].yearOpeningBalance  }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">应收账款</span></td><td>4</td>
	                <td id="41">${dto["1122"].closingBalance.add(dto["1201"].closingBalance).add(dto["1211"].closingBalance).add(dto["1212"].closingBalance).subtract(dto["1231"].closingBalance) }</td>
	                <td id="42">${dto["1122"].yearOpeningBalance.add(dto["1201"].yearOpeningBalance).add(dto["1211"].yearOpeningBalance).add(dto["1212"].yearOpeningBalance).subtract(dto["1231"].yearOpeningBalance)  }</td>
	                <td><span style="padding-left: 10%">应付账款</span></td><td>35</td><td id="351">${dto["2202"].closingBalance  }</td><td id="352">${dto["2202"].yearOpeningBalance  }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">预付账款</span></td><td>5</td><td id="51">${dto["1123"].closingBalance  }</td><td id="52">${dto["1123"].yearOpeningBalance  }</td>
	                <td><span style="padding-left: 10%">预收账款</span></td><td>36</td><td id="361">${dto["2203"].closingBalance  }</td><td id="362">${dto["2203"].yearOpeningBalance  }</td>
	              </tr>
	              <tr>
	              	<td><span style="padding-left: 10%">应收利息</span></td><td>6</td><td id="61">${dto["1132"].closingBalance  }</td><td id="62">${dto["1132"].yearOpeningBalance  }</td>
	               	<td><span style="padding-left: 10%">应付职工薪酬</span></td><td>37</td><td id="371">${dto["2211"].closingBalance  }</td><td id="372">${dto["2211"].yearOpeningBalance  }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">应收股利</span></td><td>7</td><td id="71">${dto["1131"].closingBalance  }</td><td id="72">${dto["1131"].yearOpeningBalance  }</td>
	                <td><span style="padding-left: 10%">应交税费</span></td><td>38</td><td id="381">${dto["2221"].closingBalance  }</td><td id="382">${dto["2221"].yearOpeningBalance  }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">其他应收款</span></td><td>8</td><td id="81">${dto["1221"].closingBalance  }</td><td id="82">${dto["1221"].yearOpeningBalance  }</td>
	                <td><span style="padding-left: 10%">应付利息</span></td><td>39</td><td id="391">${dto["2231"].closingBalance  }</td><td id="392">${dto["2231"].yearOpeningBalance  }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">存货</span></td><td>9</td>
	                <td id="91">${dto["1401"].closingBalance.add(dto["1402"].closingBalance).add(dto["1403"].closingBalance).add(dto["1404"].closingBalance).add(dto["1405"].closingBalance).add(dto["1406"].closingBalance).subtract(dto["1407"].closingBalance).add(dto["1408"].closingBalance).add(dto["1411"].closingBalance).add(dto["1421"].closingBalance).subtract(dto["1471"].closingBalance).add(dto["1901"].closingBalance).add(dto["5001"].closingBalance).add(dto["5401"].closingBalance).add(dto["5101"].closingBalance).add(dto["5201"].closingBalance).subtract(dto["5402"].closingBalance).add(dto["5403"].closingBalance) }</td>
	                <td id="92">${dto["1401"].yearOpeningBalance.add(dto["1402"].yearOpeningBalance).add(dto["1403"].yearOpeningBalance).add(dto["1404"].yearOpeningBalance).add(dto["1405"].yearOpeningBalance).add(dto["1406"].yearOpeningBalance).subtract(dto["1407"].yearOpeningBalance).add(dto["1408"].yearOpeningBalance).add(dto["1411"].yearOpeningBalance).add(dto["1421"].yearOpeningBalance).subtract(dto["1471"].yearOpeningBalance).add(dto["1901"].yearOpeningBalance).add(dto["5001"].yearOpeningBalance).add(dto["5401"].yearOpeningBalance).add(dto["5101"].yearOpeningBalance).add(dto["5201"].yearOpeningBalance).subtract(dto["5402"].yearOpeningBalance).add(dto["5403"].yearOpeningBalance) }</td>
	                <td><span style="padding-left: 10%">应付股利</span></td><td>40</td><td id="401">${dto["2232"].closingBalance  }</td><td id="402">${dto["2232"].yearOpeningBalance  }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">一年内到期的非流动资</span></td><td>10</td><td id="101"></td><td id="102"></td>
	                <td><span style="padding-left: 10%">其他应付款</span></td><td>41</td><td id="411">${dto["2241"].closingBalance  }</td><td id="412">${dto["2241"].yearOpeningBalance  }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">其他流动资产</span></td><td>11</td>
	                <td id="111">${dto["1311"].closingBalance.add(dto["1321"].closingBalance).add(dto["1431"].closingBalance).add(dto["1441"].closingBalance).add(dto["1451"].closingBalance).add(dto["1461"].closingBalance)  }</td>
	                <td id="112">${dto["1311"].yearOpeningBalance.add(dto["1321"].yearOpeningBalance).add(dto["1431"].yearOpeningBalance).add(dto["1441"].yearOpeningBalance).add(dto["1451"].yearOpeningBalance).add(dto["1461"].yearOpeningBalance)  }</td>
	                <td><span style="padding-left: 10%">一年内到期的非流动</span></td><td>42</td><td id="421"></td><td id="422"></td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 20%">流动资产合计</span></td><td>12</td><td id="121"></td><td id="122"></td>
	                <td><span style="padding-left: 10%">其他流动负债</span></td><td>43</td>
	                <td id="431">${dto["2002"].closingBalance.add(dto["2003"].closingBalance).add(dto["2004"].closingBalance).add(dto["2011"].closingBalance).add(dto["2012"].closingBalance).add(dto["2021"].closingBalance).add(dto["2111"].closingBalance).add(dto["2251"].closingBalance).add(dto["2261"].closingBalance).add(dto["2311"].closingBalance).add(dto["2312"].closingBalance).add(dto["2313"].closingBalance).add(dto["2314"].closingBalance).add(dto["2401"].closingBalance).add(dto["2601"].closingBalance).add(dto["2602"].closingBalance).add(dto["2611"].closingBalance).add(dto["2621"].closingBalance)  }</td>
	                <td id="432">${dto["2002"].yearOpeningBalance.add(dto["2003"].yearOpeningBalance).add(dto["2004"].yearOpeningBalance).add(dto["2011"].yearOpeningBalance).add(dto["2012"].yearOpeningBalance).add(dto["2021"].yearOpeningBalance).add(dto["2111"].yearOpeningBalance).add(dto["2251"].yearOpeningBalance).add(dto["2261"].yearOpeningBalance).add(dto["2311"].yearOpeningBalance).add(dto["2312"].yearOpeningBalance).add(dto["2313"].yearOpeningBalance).add(dto["2314"].yearOpeningBalance).add(dto["2401"].yearOpeningBalance).add(dto["2601"].yearOpeningBalance).add(dto["2602"].yearOpeningBalance).add(dto["2611"].yearOpeningBalance).add(dto["2621"].yearOpeningBalance)  }</td>
	              </tr>
	              <tr>
	                <td>非流动资产：</td><td></td><td></td><td></td>
	                <td><span style="padding-left: 20%">流动负债合计</span></td><td>44</td><td id="441"></td><td id="442"></td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">可供出售金融资产</span></td><td>13</td><td id="131">${dto["1503"].closingBalance }</td><td id="132">${dto["1503"].yearOpeningBalance }</td>
	                <td>非流动负债：</td><td></td><td></td><td></td>
	              </tr>
	              
	              <tr>
	                <td><span style="padding-left: 10%">持有至到期投资</span></td><td>14</td><td id="141">${dto["1501"].closingBalance.subtract(dto["1502"].closingBalance) }</td><td id="142">${dto["1501"].yearOpeningBalance.subtract(dto["1502"].yearOpeningBalance) }</td>
	                <td><span style="padding-left: 10%">长期借款</span></td><td>45</td><td id="451">${dto["2501"].closingBalance }</td><td id="452">${dto["2501"].yearOpeningBalance }</td>
	              </tr>
	              
	              
	              <tr>
	                <td><span style="padding-left: 10%">长期应收款</span></td><td>15</td><td id="151">${dto["1531"].closingBalance }</td><td id="152">${dto["1531"].yearOpeningBalance }</td>
	                <td><span style="padding-left: 10%">应付债券</span></td><td>46</td><td id="461">${dto["2502"].closingBalance }</td><td id="462">${dto["2502"].yearOpeningBalance }</td>
	              </tr>
	              
	              
	              <tr>
	              	<td><span style="padding-left: 10%">长期股权投资</span></td><td>16</td><td id="161">${dto["1511"].closingBalance.subtract(dto["1512"].closingBalance) }</td><td id="162">${dto["1511"].yearOpeningBalance.subtract(dto["1512"].yearOpeningBalance) }</td>
	                <td><span style="padding-left: 10%">长期应付款</span></td><td>47</td><td id="471">${dto["2711"].closingBalance }</td><td id="472">${dto["2711"].yearOpeningBalance }</td>
	              </tr>
	              <tr>
	              	<td><span style="padding-left: 10%">投资性房地产</span></td><td>17</td><td id="171">${dto["1511"].closingBalance }</td><td id="172">${dto["1511"].yearOpeningBalance }</td>
	                <td><span style="padding-left: 10%">专项应付款</span></td><td>48</td><td id="481">${dto["2701"].closingBalance }</td><td id="482">${dto["2701"].yearOpeningBalance }</td>
	              </tr>
	              
	              <tr>
	                <td><span style="padding-left: 10%">固定资产</span></td><td>18</td><td id="181">${dto["1601"].closingBalance.subtract(dto["1602"].closingBalance).subtract(dto["1603"].closingBalance) }</td><td id="182">${dto["1601"].yearOpeningBalance.subtract(dto["1602"].yearOpeningBalance).subtract(dto["1603"].yearOpeningBalance) }</td>
	             	<td><span style="padding-left: 10%">预计负债</span></td><td>49</td><td id="491">${dto["2801"].closingBalance }</td><td id="492">${dto["2801"].yearOpeningBalance }</td>
	              </tr>
	              
	              <tr>
	                <td><span style="padding-left: 10%">在建工程</span></td><td>19</td><td id="191">${dto["1604"].closingBalance }</td><td id="192">${dto["1604"].yearOpeningBalance }</td>
	                <td><span style="padding-left: 10%">递延所得税负债</span></td><td>50</td><td id="501">${dto["2901"].closingBalance }</td><td id="502">${dto["2901"].yearOpeningBalance }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">工程物资</span></td><td>20</td><td id="201">${dto["1605"].closingBalance }</td><td id="202">${dto["1605"].yearOpeningBalance }</td>
	                <td><span style="padding-left: 10%">其他非流动负债</span></td><td>51</td><td id="511">${dto["2702"].closingBalance }</td><td id="512">${dto["2702"].yearOpeningBalance }</td>
	              </tr>
	              
	              <tr>
	                <td><span style="padding-left: 10%">固定资产清理</span></td><td>21</td><td id="211">${dto["1606"].closingBalance }</td><td id="212">${dto["1606"].yearOpeningBalance }</td>
	                <td><span style="padding-left: 20%">非流动负债合计</span></td><td>52</td><td id="521"></td><td id="522"></td>
	              </tr>
	              
	              <tr>
	                <td><span style="padding-left: 10%">生产性生物资产</span></td><td>22</td><td id="221">${dto["1621"].closingBalance.subtract(dto["1622"].closingBalance)  }</td><td id="222">${dto["1621"].yearOpeningBalance.subtract(dto["1622"].yearOpeningBalance)  }</td>
	             	<td><span style="padding-left: 20%">负债合计</span></td><td>53</td><td id="531"></td><td id="532"></td>
	              </tr>
	              
	              <tr>
	                <td><span style="padding-left: 10%">油气资产</span></td><td>23</td><td id="231">${dto["1631"].closingBalance.subtract(dto["1632"].closingBalance)  }</td><td id="232">${dto["1631"].yearOpeningBalance.subtract(dto["1632"].yearOpeningBalance)  }</td>
	                <td>所有者权益（或股东权益）：</td><td></td><td></td><td></td>
	              </tr>
	               <tr>
	                <td><span style="padding-left: 10%">无形资产</span></td><td>24</td><td id="241">${dto["1701"].closingBalance.subtract(dto["1702"].closingBalance).subtract(dto["1703"].closingBalance)  }</td><td id="242">${dto["1701"].yearOpeningBalance.subtract(dto["1702"].yearOpeningBalance).subtract(dto["1703"].yearOpeningBalance)  }</td>
	                <td><span style="padding-left: 10%">实收资本（或股本）</span></td><td>54</td><td id="541">${dto["4001"].closingBalance }</td><td id="542">${dto["4001"].yearOpeningBalance }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">开发支出</span></td><td>25</td><td id="251">${dto["5301"].closingBalance }</td><td id="252">${dto["5301"].yearOpeningBalance }</td>
	                <td><span style="padding-left: 10%">资本公积</span></td><td>55</td><td id="551">${dto["4002"].closingBalance }</td><td id="552">${dto["4002"].yearOpeningBalance }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">商誉</span></td><td>26</td><td id="261">${dto["1711"].closingBalance }</td><td id="262">${dto["1711"].yearOpeningBalance }</td>
	                <td><span style="padding-left: 10%">减：库存股</span></td><td>56</td><td id="561">${dto["4201"].closingBalance }</td><td id="562">${dto["4201"].yearOpeningBalance }</td>
	              </tr>
	              
	               <tr>
	                <td><span style="padding-left: 10%">长期待摊费用</span></td><td>27</td><td id="271">${dto["1801"].closingBalance }</td><td id="272">${dto["1801"].yearOpeningBalance }</td>
	                <td><span style="padding-left: 10%">盈余公积</span></td><td>57</td><td id="571">${dto["4101"].closingBalance }</td><td id="572">${dto["4101"].yearOpeningBalance }</td>
	              </tr>
	              <tr>
	                <td><span style="padding-left: 10%">递延所得税资产</span></td><td>28</td><td id="281">${dto["1811"].closingBalance }</td><td id="282">${dto["1811"].yearOpeningBalance }</td>
	                <td><span style="padding-left: 10%">未分配利润</span></td><td>58</td><td id="581">${dto["4103"].closingBalance.add(dto["4104"].closingBalance).add(dto["4102"].closingBalance)  }</td><td id="582">${dto["4103"].yearOpeningBalance.add(dto["4104"].yearOpeningBalance).add(dto["4102"].yearOpeningBalance)  }</td>
	              </tr>
	              
	              
	              <tr>
	                <td><span style="padding-left: 10%">其他非流动资产</span></td><td>29</td>
	                <td id="291">${dto["1532"].closingBalance.add(dto["1541"].closingBalance).add(dto["1611"].closingBalance).add(dto["1623"].closingBalance).add(dto["1821"].closingBalance)  }</td>
	                <td id="292">${dto["1532"].yearOpeningBalance.add(dto["1541"].yearOpeningBalance).add(dto["1611"].yearOpeningBalance).add(dto["1623"].yearOpeningBalance).add(dto["1821"].yearOpeningBalance)  }</td>
	                <td></td><td></td><td></td><td></td>
	              </tr>
	              
	              <tr>
	                <td><span style="padding-left: 20%">非流动资产合计</span></td><td>30</td><td id="301"></td><td id="302"></td>
	                <td><span style="padding-left: 20%">所有者权益（或股东权益）合计</span></td><td>59</td><td id="591"></td><td id="592"></td>
	              </tr>
	               <tr>
	                <td><span style="padding-left: 20%">资产总计</span></td><td>31</td><td id="311"></td><td id="312"></td>
	                <td><span style="padding-left: 20%">负债和所有者权益</span></td><td>60</td><td id="601"></td><td id="602"></td>
	              </tr>
	              
	            </tbody>
	          </table>
        </div>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		var v_121 = Number($("#11").text())+Number($("#21").text())+Number($("#31").text())+Number($("#41").text())+Number($("#51").text())
			+Number($("#61").text())+Number($("#71").text())+Number($("#81").text())+Number($("#91").text())+Number($("#111").text());
		var v_301 = Number($("#131").text())+Number($("#141").text())+Number($("#151").text())+Number($("#161").text())+Number($("#171").text())
			+Number($("#181").text())-Number($("#191").text())+Number($("#201").text())+Number($("#211").text())+Number($("#221").text())+Number($("#231").text())
			+Number($("#241").text())+Number($("#251").text())+Number($("#261").text())+Number($("#271").text())+Number($("#281").text())+Number($("#291").text());
		var v_311 = v_121+v_301;
		var v_441 = Number($("#321").text())+Number($("#331").text())+Number($("#341").text())+Number($("#351").text())+Number($("#361").text())
		+Number($("#371").text())+Number($("#381").text())+Number($("#391").text())+Number($("#401").text())+Number($("#411").text())+Number($("#421").text())+Number($("#431").text());
		var v_521 = Number($("#451").text())+Number($("#461").text())+Number($("#471").text())+Number($("#481").text())+Number($("#491").text())+Number($("#501").text())+Number($("#511").text());
		var v_531 = v_441+v_521;
		$("#121").text(v_121.toFixed(2));
		$("#301").text(v_301.toFixed(2));
		$("#311").text(v_311.toFixed(2));
		$("#411").text(v_411.toFixed(2));
		$("#521").text(v_521.toFixed(2));
		$("#531").text(v_531.toFixed(2));
		
		var v_122 = Number($("#12").text())+Number($("#22").text())+Number($("#32").text())+Number($("#42").text())+Number($("#52").text())
			+Number($("#62").text())+Number($("#72").text())+Number($("#82").text())+Number($("#92").text())+Number($("#112").text());
		var v_302 = Number($("#132").text())+Number($("#142").text())+Number($("#152").text())+Number($("#162").text())+Number($("#172").text())
			+Number($("#182").text())-Number($("#192").text())+Number($("#202").text())+Number($("#212").text())+Number($("#222").text())+Number($("#232").text())
			+Number($("#242").text())+Number($("#252").text())+Number($("#262").text())+Number($("#272").text())+Number($("#282").text())+Number($("#292").text());
		var v_312 = v_122+v_302;
		var v_442 = Number($("#322").text())+Number($("#332").text())+Number($("#342").text())+Number($("#352").text())+Number($("#362").text())
		+Number($("#372").text())+Number($("#382").text())+Number($("#392").text())+Number($("#402").text())+Number($("#412").text())+Number($("#422").text())+Number($("#432").text());
		var v_522 = Number($("#452").text())+Number($("#462").text())+Number($("#472").text())+Number($("#482").text())+Number($("#492").text())+Number($("#502").text())+Number($("#512").text());
		var v_532 = v_442+v_522;
		$("#122").text(v_122.toFixed(2));
		$("#302").text(v_302.toFixed(2));
		$("#312").text(v_312.toFixed(2));
		$("#412").text(v_412.toFixed(2));
		$("#522").text(v_522.toFixed(2));
		$("#532").text(v_532.toFixed(2));
	})
  	</script>
</body>
</html>
