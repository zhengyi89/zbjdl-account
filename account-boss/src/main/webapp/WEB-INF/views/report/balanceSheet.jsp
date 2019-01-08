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
	                <td>货币资金</td><td>1</td><td id="11">${dto["1001"].closingBalance.add(dto["1002"].closingBalance).add(dto["1012"].closingBalance)  }</td><td id="12">${dto["1001"].yearOpeningBalance.add(dto["1002"].yearOpeningBalance).add(dto["1012"].yearOpeningBalance) }</td>
	                <td>短期借款</td><td>32</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>短期投资</td><td>2</td><td id="21">${dto["1101"].closingBalance  }</td><td></td>
	                <td>应付票据</td><td>33</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>应收票据</td><td>3</td><td></td><td></td>
	                <td>应付票据</td><td>34</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>应收账款</td><td>4</td><td></td><td></td>
	                <td>应付账款</td><td>35</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>预付账款</td><td>5</td><td></td><td></td>
	                <td>预收账款</td><td>36</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>应收股利</td><td>6</td><td></td><td></td>
	                <td>应付职工薪酬</td><td>37</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>应收利息</td><td>7</td><td></td><td></td>
	                <td>应交税费</td><td>38</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>其他应收款</td><td>8</td><td></td><td></td>
	                <td>应付利息</td><td>39</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>存货</td><td>9</td><td></td><td></td>
	                <td>应付股利</td><td>40</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>一年内到期的非流动</td><td>10</td><td></td><td></td>
	                <td>其他应付款</td><td>41</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>其他流动资产</td><td>11</td><td></td><td></td>
	                <td>一年内到期的非流动负</td><td>42</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>   流动资产合计</td><td>12</td><td></td><td></td>
	                <td>   其他流动负债</td><td>43</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>非流动资产：</td><td></td><td></td><td></td>
	                <td>流动负债合计</td><td>44</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>可供出售金融资产</td><td>13</td><td></td><td></td>
	                <td>非流动负债：</td><td></td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>持有至到期投资</td><td>14</td><td></td><td></td>
	                <td>长期借款</td><td>45</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>长期应收款</td><td>15</td><td></td><td></td>
	                <td>应付债券</td><td>46</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>长期股权投资</td><td>16</td><td></td><td></td>
	                <td>长期应付款</td><td>47</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>投资性房地产</td><td>17</td><td></td><td></td>
	                <td>专项应付款</td><td>48</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>固定资产</td><td>18</td><td></td><td></td>
	                <td>预计负债</td><td>49</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>在建工程</td><td>19</td><td></td><td></td>
	                <td>递延所得税负债</td><td>50</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>工程物资</td><td>20</td><td></td><td></td>
	                <td>其他非流动负债</td><td>51</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>固定资产清理</td><td>21</td><td></td><td></td>
	                <td>  非流动负债合计</td><td>52</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>生产性生物资产</td><td>22</td><td></td><td></td>
	                <td>   负债合计</td><td>53</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>油气资产</td><td>23</td><td></td><td></td>
	                <td>所有者权益（或股东权益）：</td><td></td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>无形资产</td><td>24</td><td></td><td></td>
	                <td>实收资本（或股本）</td><td>54</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>开发支出</td><td>25</td><td></td><td></td>
	                <td>资本公积</td><td>55</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>商誉</td><td>26</td><td></td><td></td>
	                <td>减：库存股</td><td>56</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>长期待摊费用</td><td>27</td><td></td><td></td>
	                <td>盈余公积</td><td>57</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>递延所得税资产</td><td>28</td><td></td><td></td>
	                <td>未分配利润</td><td>58</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>其他非流动资产</td><td>29</td><td></td><td></td>
	                <td></td><td></td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>   非流动资产合计</td><td>30</td><td></td><td></td>
	                <td>   所有者权益（或股东权益）合计</td><td>59</td><td></td><td></td>
	              </tr>
	              <tr>
	                <td>   资产总计</td><td>31</td><td></td><td></td>
	                <td>   负债和所有者权益</td><td>60</td><td></td><td></td>
	              </tr>
	            </tbody>
	          </table>
        </div>
		</div>
	</div>
	<script type="text/javascript">
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
