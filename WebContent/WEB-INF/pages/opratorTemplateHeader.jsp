<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html lang="zh-cn">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="resource/layui/css/layui.css" rel="stylesheet" />
    <link rel="stylesheet" href="resource/style.css" />
	<script type="text/javascript" src="resource/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="resource/layui/layui.js"></script>
    <script type="text/javascript" src="resource/js.js"></script>
    <title>欢迎使用</title>
</head>

<body>
    <div class="layui-layout layui-layout-admin">
        <div class="layui-side layui-bg-black">
            <ul class="layui-nav layui-nav-tree layui-nav-side side" lay-filter="">
                <li class="layui-nav-item layui-nav-itemed"><a href="javascript:;">司机管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="">审核</a></dd>
                        <dd><a href="">新增</a></dd>
                        <dd><a href="">查看</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
        <div class="layui-header header">
            <ul class="layui-nav" lay-filter="">
                <li class="layui-nav-item">滴滴合作伙伴运营管理信息系统</li>
                <li class="layui-nav-item layui-this">
                    <a href="">司机管理</a>
                </li>
                <li class="layui-nav-item">
                    <a href="">汽车管理</a>
                </li>
                <li class="layui-nav-item">
                    <a href="">合作伙伴管理</a>
                </li>
                <li class="layui-nav-item">
                    <a href="">分账管理</a>
                </li>
                <li class="layui-nav-item" style="float:right;"><a href="">用户</a>
                    <dl class="layui-nav-child">
                        <dd><a href="">账户修改</a></dd>
                        <dd><a href="">登出</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">&nbsp;</a></li>
            </ul>
        </div>


        