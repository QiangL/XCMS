<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="TemplateHeader.jsp"%>
<div class="layui-side layui-bg-black">
	<ul class="layui-nav layui-nav-tree layui-nav-side side" lay-filter="">
		<li class="layui-nav-item layui-nav-itemed">
		<a href="javascript:;">账户管理</a>
			<dl class="layui-nav-child">
				<dd class="layui-this">
					<a href="javascript:switchToLook();">账户列表</a>
				</dd>
				<dd class="">
					<a href="javascript:switchToAdd();">新增账户</a>
				</dd>
			</dl>
		</li>
	</ul>
</div>


<div class="layui-layer-content content">
	<div class="look">
			<div class="layui-form-item search">
				<input type="text" id="searchInput"  name="search" class="search-input"
					placeholder="键入需要查找的完整账号ID" required value="" />
				<button id="accountSearch" class="layui-btn search-btn" lay-submit>查询</button>
			</div>

		<table class="layui-table" lay-even lay-skin="line">
			<colgroup>
				<col width="300" />
				<col width="500" />
				<col />
			</colgroup>
			<thead>
				<tr>
					<th>id</th>
					<th>公司名</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="tbody">
			</tbody>
		</table>
		<div class="layui-layer-page" id="list-page"></div>
	</div>
	<div class="add display-none">
		<form action="oprator/addAccount" method="POST"
			class="layui-form">
			<div class="layui-form-item">
				<label class="layui-form-label" for="add-id">账户ID</label>
				<div class="layui-input-block">
					<input type="text" id="add-id" name="id" placeholder="账户ID"
						required="true" class="layui-input" value="">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="add-company-id" class="layui-form-label">公司ID</label>
				<div class="layui-input-block">
					<input type="text" id="add-company-id" name="companyId"
						placeholder="公司ID，7位数字" required class="layui-input" value="" >
				</div>
			</div>
			<div class="layui-form-item">
				<label for="add-password" class="layui-form-label">账户密码</label>
				<div class="layui-input-block">
					<input type="password" id="add-password" name="password"
					placeholder="长度6~16"	required class="layui-input" value="">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="add-password2" class="layui-form-label">确认密码</label>
				<div class="layui-input-block">
					<input type="password" id="add-password2" name="password2" placeholder="重复输入账户密码，长度6~16"
						required class="layui-input" value="">
				</div>
			</div>
			
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="add">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>		
	</div>
	<div class="update display-none">
		<form action="oprator/updateAccount" method="POST"
			class="layui-form">
			<div class="layui-form-item">
				<label class="layui-form-label" for="update-id">账户ID</label>
				<div class="layui-input-block">
					<input type="text" id="update-id" name="id" placeholder="账户ID"
						required="true" class="layui-input" value="" readonly="readonly">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="update-company-id" class="layui-form-label">公司ID</label>
				<div class="layui-input-block">
					<input type="text" id="update-company-id" name="companyId"
						placeholder="公司ID，7位数字" required class="layui-input" value="" readonly="readonly">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="update-password" class="layui-form-label">账户密码</label>
				<div class="layui-input-block">
					<input type="password" id="update-password" name="password" placeholder="长度6~16"
						required class="layui-input" value="">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="update-password2" class="layui-form-label">确认密码</label>
				<div class="layui-input-block">
					<input type="password" id="update-password2" name="password2" placeholder="重复输入账户密码,长度6~16"
						required class="layui-input" value="">
				</div>
			</div>
			
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="update">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>		
	</div>
</div>

<%@include file="templateContent.jsp"%>
<script type="text/javascript" src="resource/opratorAccount.js"></script>
<script type="text/javascript" src="resource/accountCheck.js"></script>
<script type="text/javascript">
	var tr = $('<tr><td name="id"></td><td name="companyName"></td><td><input type="button" value="修改" class="layui-btn update-btn" /><input type="button" value="删除" class="layui-btn del-btn"/><input name="companyId" type="hidden" value=""></td></tr>');
	flushPage(1);
	$('#accountSearch').click(function(){
		if($('#searchInput').val()!=''){
			search($('#searchInput').val());
		}else{
			flushPage(1);
		}
	});
</script>

<%@include file="TemplateFooter.jsp"%>
