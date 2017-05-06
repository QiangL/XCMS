<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="layui-side layui-bg-black">
	<ul class="layui-nav layui-nav-tree layui-nav-side side" lay-filter="">
		<li class="layui-nav-item layui-nav-itemed"><a
			href="javascript:;">司机管理</a>
			<dl class="layui-nav-child">
				<dd>
					<a href="javascript:switchToExam()">审核</a>
				</dd>
				<dd>
					<a href="javascript:switchToAdd()">新增</a>
				</dd>
				<dd>
					<a href="javascript:switchToLook()">查看</a>
				</dd>
			</dl></li>
	</ul>
</div>