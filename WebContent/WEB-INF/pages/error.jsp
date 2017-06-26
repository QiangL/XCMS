<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%=basePath %>"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="resource/layui/css/layui.css" rel="stylesheet">
    <link rel="stylesheet" href="resource/style.css" />
<title>不好意思，出错了</title>
</head>
<body>
<div class="layui-layout layui-layout-admin">
	    <div class="layui-header header">
	        <ul class="layui-nav" lay-filter="">
	            <li class="layui-nav-item"><a href="">合作伙伴管理信息系统</a></li>
				<li class="layui-nav-item layui-this"><a href="">出错了</a></li>
	        </ul>
	    </div>
    </div>
    <div class="layui-layer-content login">
        <fieldset class="layui-elem-field">
            <legend>出错了</legend>
            <div class="layui-field-box">
            不好意思，刚刚的操作出现了错误，请稍后重新操作
            </div>
        </fieldset>
        </div>
    <script type="text/javascript" src="resource/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="resource/layui/layui.js"></script>
    <script tpye="text/javascript">
        layui.use('element', function () {
            var element = layui.element();

        });
    </script>
</body>
</html>