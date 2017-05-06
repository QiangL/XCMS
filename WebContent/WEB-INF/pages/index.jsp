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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="resource/layui/css/layui.css" rel="stylesheet">
    <link rel="stylesheet" href="resource/style.css" />
    <title>登陆</title>
</head>

<body>
<%=basePath %>
	<div class="layui-layout layui-layout-admin">
	    <div class="layui-header header">
	        <ul class="layui-nav" lay-filter="">
	            <li class="layui-nav-item"><a href="">滴滴合作伙伴管理信息系统</a></li>
				<li class="layui-nav-item layui-this"><a href="">登陆</a></li>
	        </ul>
	    </div>
    </div>
    <div class="layui-layer-content login">
        <fieldset class="layui-elem-field">
            <legend>登陆</legend>
            <div class="layui-field-box">
                <form action="login" method="POST" class="layui-form">
                    <div class="layui-form-item">
                        <label class="layui-form-label" for="id">用户名</label>
                        <div class="layui-input-block">
                            <input type="text" id="id" name="id" placeholder="输入用户名" required="true" class="layui-input" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label" for="password">密码</label>
                        <div class="layui-input-block">
                            <input type="password" id="password" name="password" placeholder="输入密码" required="true" class="layui-input" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">角色</label>
                        <div class="layui-input-block">
                            <input type="radio" name="role" value="oprator" title="滴滴工作人员">
                            <input type="radio" name="role" value="account" title="合作伙伴" checked>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit lay-filter="*">登陆</button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>

    </div>




    <script type="text/javascript" src="resource/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="resource/layui/layui.js"></script>
    <script tpye="text/javascript">
        layui.use('element', function () {
            var element = layui.element();

        });
        layui.use('form', function () {
            var form = layui.form(); //只有执行了这一步，部分表单元素才会修饰成功

            //……
        });
    </script>
</body>

</html>