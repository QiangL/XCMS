<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="TemplateHeader.jsp"%>
<div class="layui-side layui-bg-black">
	<ul class="layui-nav layui-nav-tree layui-nav-side side" lay-filter="">
		<li class="layui-nav-item layui-nav-itemed">
		<a href="javascript:;">分账管理</a>
			<dl class="layui-nav-child">
				<dd class="layui-this">
					<a href="javascript:switchToList();">账单列表</a>
				</dd>
				<dd class="">
					<a href="javascript:switchToHistory();">历史账单</a>
				</dd>
			</dl>
		</li>
	</ul>
</div>


<div class="layui-layer-content content">
	<div class="list">
		<form action="searchDriver" method="POST" class="layui-form">
			<div class="layui-form-item search">
				<input type="text" name="search" class="search-input"
					placeholder="键入需要查找的公司ID" required value="" />
				<button class="layui-btn search-btn" lay-submit>查询</button>
			</div>
		</form>

		<table class="layui-table" lay-even lay-skin="line">
			<colgroup>
				<col width="50" />
				<col width="150" />
				<col width="80" />
				<col width="100" />
				<col width="50" />
				<col width="120" />
				<col />
			</colgroup>
			<thead>
				<tr>
					<th>结算id</th>
					<th>公司名</th>
					<th>年月</th>
					<th>本月应付金额</th>
					<th>公司对公账户</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="tbody">
			</tbody>
		</table>
		<div class="layui-layer-page" id="list-page"></div>
	</div>
	<div class="history display-none">
		<table class="layui-table" lay-even lay-skin="line">
			<colgroup>
				<col width="100" />
				<col width="200" />
				<col width="100" />
				<col width="150" />
				<col width="200" />
				<col witdh="150" />
			</colgroup>
			<thead>
				<tr>
					<th>结算id</th>
					<th>公司名</th>
					<th>年月</th>
					<th>应付金额</th>
					<th>公司对公账户</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="tbody">
			</tbody>
		</table>
		<div class="layui-layer-page" id="history-page"></div>
	</div>
	
</div>
<div class="detail display-none">
		<table class="layui-table" lay-even lay-skin="line">
			<colgroup>
				<col width="100" />
				<col width="150" />
				<col width="100" />
				<col width="100" />
				<col width="100" />
				<col width="100" />
				<col />
			</colgroup>
			<thead>
				<tr>
					<th>司机id</th>
					<th>订单数量</th>
					<th>计费时长</th>
					<th>流水</th>
					<th>低星率</th>
					<th>服务分</th>
					<th>等级</th>
				</tr>
			</thead>
			<tbody class="tbody">
			</tbody>
		</table>
		<div class="layui-layer-page" id="detail-page"></div>
		
	</div>

<%@include file="templateContent.jsp"%>
<script type="text/javascript" src="resource/opratorFinance.js"></script>
<script type="text/javascript">
	var listTr = $('<tr><td name="id"></td><td name="name"></td><td name="date"></td><td name="money"></td><td name="publicAccount"></td><td name="financeStatus"></td><td><input type="button" value="确认支付" class="layui-btn remit-btn" /><input type="button" value="驳回修改" class="layui-btn reject-btn" /><input type="button" value="详情" class="layui-btn detail-btn"/><input name="companyId" type="hidden" value=""></td></tr>');
	var historyTr = $('<tr><td name="id"></td><td name="name"></td><td name="date"></td><td name="money"></td><td name="publicAccount"></td><td><input type="button" value="详情" class="layui-btn detail-btn"/><input name="companyId" type="hidden" value=""></td></tr>');
	var detailTr=$('<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>');
	flushListPage(1);
</script>

<%@include file="TemplateFooter.jsp"%>
