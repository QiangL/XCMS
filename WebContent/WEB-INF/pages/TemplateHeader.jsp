<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% %>
<!DOCTYPE>
<html lang="zh-cn">

<head>
    <meta charset="UTF-8">
    <base href="<%=basePath %>"/>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="resource/layui/css/layui.css" />
    <link rel="stylesheet" href="resource/style.css" />
    <title>欢迎使用</title>
</head>

<body>
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header header">
            <ul class="layui-nav" lay-filter="">
                <li class="layui-nav-item">
                	<a href="">合作伙伴运营管理信息系统</a>
                </li>
                <li class="layui-nav-item">
                    <a href="${role }/driver">司机管理</a>
                </li>
                <li class="layui-nav-item">
                    <a href="${role }/car">车辆管理</a>
                </li>
                <c:if test='${role=="oprator" }'>
                <li class="layui-nav-item">
                    <a href="${role }/company">合作伙伴管理</a>
                </li>
                <li class="layui-nav-item">
                    <a href="${role }/account">账户管理</a>
                </li>
                </c:if>
                <li class="layui-nav-item">
                    <a href="${role }/finance">分账管理</a>
                </li>
                <li class="layui-nav-item" style="float:right;">
                	<a href="">${user }</a>
                    <dl class="layui-nav-child">
                    <c:if test='${role=="oprator" }'>
                        <dd><a href="oprator/user">账户修改</a></dd>
                     </c:if>   
                        <dd><a href="logout">登出</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">&nbsp;</a></li>
            </ul>
        </div>


        