<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
		<meta charset="UTF-8"/>
		<title>Admin2.0</title>
		<meta name="renderer" content="webkit|ie-comp|ie-stand"/>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
		<meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
		<meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" href="css/reset.css"/>
    <link rel="stylesheet" href="lib/mCustomScrollbar/jquery.mCustomScrollbar.css"/>
  </head>
  <body>
    <!--顶部开始-->
    <div class="content_top">
      <span class="logo">LOGO</span>
      <a class="quit">退出</a>
      <p class="user">您好，用户名~</p>
    </div>
    <!--顶部结束-->
    <!--导航开始-->
    <div id="content_menu" class="left-nav content_menu">
        <ul>
          <li>
            <a href="javascript:;"><i class="layui-icon">&#xe600;</i><cite>基础维护</cite><i class="layui-icon nav_right">&#xe61a;</i></a>
        		<ul class="sub-menu">
              <li><a _href="OrganizationList.html"><i class="layui-icon">&#xe602;</i><cite>机构管理</cite></a></li>
              <li><a _href="ProductList.html"><i class="layui-icon">&#xe602;</i><cite>产品管理</cite></a></li>
              <li><a _href=""><i class="layui-icon">&#xe602;</i><cite>用户管理</cite></a></li>
              <li><a _href=""><i class="layui-icon">&#xe602;</i><cite>规则维护</cite></a></li>
            </ul>
      		</li>
          <li>
            <a href="javascript:;"><i class="layui-icon">&#xe60a;</i><cite>订单维护</cite><i class="layui-icon nav_right">&#xe61a;</i></a>
        		<ul class="sub-menu">
              <li><a _href=""><i class="layui-icon">&#xe602;</i><cite>订单管理</cite></a></li>
            </ul>
      		</li>
        </ul>
      </div>
		</div>
    <!--导航结束-->
    <!--主体开始-->
    <div class="page_content">
			<div class="layui-tab" lay-filter="xbs_tab" lay-allowclose="false">
  			<ul class="layui-tab-title"><li>我的桌面</li></ul>
  			<div class="layui-tab-content">
    			<div class="layui-tab-item layui-show">
    			     <iframe src='welcome.html' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
    			</div>
  			</div>
			</div>
      <span id="left_open" class="left_open layui-icon">&#xe603;</span>
		</div>
    <div class="page_content_bg"></div>
    <!--主体结束-->
    <!--底部开始-->
    <div class="content_bottom">Copyright &copy;2017 admin v2.0 All Rights Reserved</div>
    <!--底部结束-->
    <script type="text/javascript" src="js/jquery.1.9.1.min.js"></script>
    <script type="text/javascript" src="lib/mCustomScrollbar/jquery.mCustomScrollbar.js"></script>
    <script type="text/javascript" src="lib/layui/layui.js"></script>
    <script type="text/javascript" src="js/reset.js"></script>
  </body>
</html>
