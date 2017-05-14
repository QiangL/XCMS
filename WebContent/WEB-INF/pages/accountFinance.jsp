<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="TemplateHeader.jsp"%>
<div class="layui-side layui-bg-black">
	<ul class="layui-nav layui-nav-tree layui-nav-side side" lay-filter="">
		<li class="layui-nav-item layui-nav-itemed">
		<a href="javascript:;">分账管理</a>
			<dl class="layui-nav-child">
				<dd class="layui-this">
					<a href="javascript:switchToList();">未确认账单</a>
				</dd>
				<dd class="">
					<a href="javascript:switchToHistory();">历史账单</a>
				</dd>
				<dd class="">
					<a href="javascript:switchToReward();">司机奖励</a>
				</dd>
			</dl>
		</li>
	</ul>
</div>


<div class="layui-layer-content content">
	<div class="list">
		<table class="layui-table" lay-even lay-skin="line">
			<colgroup>
				<col width="30" />
				<col width="150" />
				<col width="100" />
				<col width="200" />
				<col width="150" />
				<col width="120"/>
				<col />
			</colgroup>
			<thead>
				<tr>
					<th>结算id</th>
					<th>公司名</th>
					<th>年月</th>
					<th>应付金额</th>
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
				<col width="150" />
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
	<div class="driverReward display-none">
		<div class="layui-form-item">
				<label for="driver-reward-a" class="layui-form-label">A档司机奖励比例</label>
				<div class="layui-input-block">
					<input type="number" id="driver-reward-a" placeholder="输入百分比 0~100" min=0 max=100 step=1 class="layui-input">%
				</div>
		</div>
		<div class="layui-form-item">
				<label for="driver-reward-b" class="layui-form-label">B档司机奖励比例</label>
				<div class="layui-input-block">
					<input type="number" id="driver-reward-b" placeholder="输入百分比 0~100" min=0 max=100 step=1  class="layui-input">%
				</div>
		</div>
		<div class="layui-form-item">
				<label for="driver-reward-c" class="layui-form-label">C档司机奖励比例</label>
				<div class="layui-input-block">
					<input type="number" id="driver-reward-c" placeholder="输入百分比  0~100" min=0 max=100 step=1  class="layui-input">%
				</div>
		</div>
		<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="reward">确认奖励</button>
				</div>
		</div>
	</div>
</div>

<%@include file="templateContent.jsp"%>
<script type="text/javascript" src="resource/accountFinance.js"></script>
<script type="text/javascript">
	var listTr = $('<tr><td name="id"></td><td name="name"></td><td name="date"></td><td name="money"></td><td name="publicAccount"></td><td name="financeStatus"></td><td><input type="button" value="确认" class="layui-btn confirm-btn" /><input type="button" value="详情" class="layui-btn detail-btn"/><input name="companyId" type="hidden" value=""></td></tr>');
	var historyTr = $('<tr><td name="id"></td><td name="name"></td><td name="date"></td><td name="money"></td><td name="publicAccount"></td><td name=""><input type="button" value="详情" class="layui-btn detail-btn"/><input name="companyId" type="hidden" value=""></td></tr>');
	var detailTr=$('<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>');
	var motifyInput='&nbsp;&nbsp;&nbsp;<input type="button" value="修改" class="layui-btn motify-btn"/>';
	flushListPage(1);
	layui.use('form', function () {
		var form = layui.form();

		//监听提交
		form.on('submit(reward)', clickReward);
	});
	function clickReward(e){
		localStorage.setItem('driver-reward-a',$('#driver-reward-a').val());
		localStorage.setItem('driver-reward-b',$('#driver-reward-b').val());
		localStorage.setItem('driver-reward-c',$('#driver-reward-c').val());
		layui.use('layer', function () {
			var layer = layui.layer;
			layer.msg('已保存奖励比例');
		});
	}
	$(document).ready(function(){
		$('#driver-reward-a').val(localStorage.getItem('driver-reward-a'));
		$('#driver-reward-b').val(localStorage.getItem('driver-reward-b'));
		$('#driver-reward-c').val(localStorage.getItem('driver-reward-c'));
	});
</script>
<<style>
.driverReward input{
	width:200px;
	display:inline;
}
.driverReward .layui-form-label{
	width:200px;
}
</style>

<%@include file="TemplateFooter.jsp"%>
