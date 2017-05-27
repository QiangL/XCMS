<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="TemplateHeader.jsp"%>
<div class="layui-side layui-bg-black">
	<ul class="layui-nav layui-nav-tree layui-nav-side side" lay-filter="">
		<li class="layui-nav-item layui-nav-itemed"><a
			href="javascript:;">合作伙伴管理</a>
			<dl class="layui-nav-child">
				<dd>
					<a href="javascript:switchToAdd()">新增</a>
				</dd>
				<dd class="layui-this">
					<a href="javascript:switchToLook()">查看</a>
				</dd>
			</dl></li>
	</ul>
</div>


<div class="layui-layer-content content">
	<div class="add  display-none">
		<form action="oprator/addCompany" method="POST"
			class="layui-form">
			<div class="layui-form-item">
				<label class="layui-form-label" for="add-id">公司ID</label>
				<div class="layui-input-block">
					<input type="text" id="add-id" name="id" placeholder="输入公司ID，长度7位"
						required="true" class="layui-input" value="">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="add-name" class="layui-form-label">公司名</label>
				<div class="layui-input-block">
					<input type="text" id="add-name" name="name" placeholder="输入公司名"
						required class="layui-input" value="">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="add-owner" class="layui-form-label">负责人</label>
				<div class="layui-input-block">
					<input type="text" id="add-owner" name="owner" placeholder="输入负责人姓名"
						required class="layui-input" value="">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="add-tel" class="layui-form-label">联系电话</label>
				<div class="layui-input-block">
					<input type="text" id="add-tel" name="tel"
						placeholder="输入公司联系电话，11位数字" required class="layui-input" value="">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="add-email" class="layui-form-label">E-Mail</label>
				<div class="layui-input-block">
					<input type="text" id="add-email" name="email"
						placeholder="输入公司E-Mail" required class="layui-input" value="">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="add-publicAccount" class="layui-form-label">对公账户</label>
				<div class="layui-input-block">
					<input type="text" id="add-publicAccount" name="publicAccount"
						placeholder="输入公司对公账户" required class="layui-input" value="">
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

	<div class="look">
			<div class="layui-form-item search">
				<input type="text" id="searchInput" name="search" class="search-input"
					placeholder="键入需要查找的公司ID" required value="" />
				<button id="companySearch" class="layui-btn search-btn" lay-submit>查询</button>
			</div>

		<table class="layui-table" lay-even lay-skin="line">
			<colgroup>
				<col width="65" />
				<col width="200" />
				<col width="100" />
				<col width="100" />
				<col width="100" />
				<col width="100" />
				<col />
			</colgroup>
			<thead>
				<tr>
					<th>id</th>
					<th>公司名</th>
					<th>负责人</th>
					<th>联系电话</th>
					<th>E-Mail</th>
					<th>对公账户</th>
					<th>操作</th>
				</tr>

			</thead>
			<tbody class="tbody">
			</tbody>
		</table>
		<div class="layui-layer-page" id="look-page"></div>
	</div>
	<div class="update  display-none">
		<form action="oprator/updateCompany" method="POST"
			class="layui-form">
			<div class="layui-form-item">
				<label class="layui-form-label" for="update-id">公司ID</label>
				<div class="layui-input-block">
					<input type="text" id="update-id" name="id" placeholder="输入公司ID"
						required="true" class="layui-input" value="" readonly="readonly">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="update-name" class="layui-form-label">公司名</label>
				<div class="layui-input-block">
					<input type="text" id="update-name" name="name" placeholder="输入公司名"
						required class="layui-input" value="">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="update-owner" class="layui-form-label">负责人</label>
				<div class="layui-input-block">
					<input type="text" id="update-owner" name="owner" placeholder="输入负责人姓名"
						required class="layui-input" value="">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="update-tel" class="layui-form-label">联系电话</label>
				<div class="layui-input-block">
					<input type="text" id="update-tel" name="tel"
						placeholder="输入公司联系电话" required class="layui-input" value="">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="update-email" class="layui-form-label">E-Mail</label>
				<div class="layui-input-block">
					<input type="text" id="update-email" name="email"
						placeholder="输入公司E-Mail" required class="layui-input" value="">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="update-publicAccount" class="layui-form-label">对公账户</label>
				<div class="layui-input-block">
					<input type="text" id="update-publicAccount" name="publicAccount"
						placeholder="输入公司对公账户" required class="layui-input" value="">
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
<script type="text/javascript" src="resource/opratorCompany.js"></script>
<script type="text/javascript" src="resource/companyCheck.js"></script>
<script type="text/javascript">
	var tr = $('<tr><td name="id"></td><td name="name"></td><td name="owner"></td><td name="tel"></td><td name="email"></td><td name="publicAccount"></td><td><input type="button" value="修改" class="layui-btn update-btn" /><input type="button" value="删除" class="layui-btn del-btn"/><input name="companyId" type="hidden" value=""></td></tr>');
	flushPage(1);
	$('#companySearch').click(function(){
		if($('#searchInput').val()!=''){
			search($('#searchInput').val());
		}else{
			flushPage(1);
		}
	});
</script>

<%@include file="TemplateFooter.jsp"%>
