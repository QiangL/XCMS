<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="driverTemplate.jsp"%>


<div class="layui-layer-content content">
<div class="look">
	<div class="layui-form-item search">
			<input type="text" name="search" class="search-input"
				placeholder="键入需要查找的司机ID" required value="" />
			<button class="layui-btn search-btn" lay-submit>查询</button>
		</div>
		<table class="layui-table" lay-even lay-skin="line">
			<colgroup>
				<col width="65" />
				<col width="100" />
				<col width="100" />
				<col width="60" />
				<col width="60" />
				<col width="150" />
				<col width="250" />
				<col />
			</colgroup>
			<thead>
				<tr>
					<th>id</th>
					<th>照片</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>电话</th>
					<th>所属合作伙伴</th>
					<th>操作</th>
				</tr>

			</thead>
			<tbody class="tbody">
			</tbody>
		</table>
		<div class="layui-layer-page" id="look-page"></div>
	</div>
	</div>
	<%@include file="../templateContent.jsp"%>
	<input type="hidden" id="OpratorDriverPageNum" value="${OpratorDriverPageNum/8 }"/>
	<script type="text/javascript">
	var tr = $('<tr><td name="id"></td><td><img name="image" class="" src="https://avatars1.githubusercontent.com/u/16045257?v=3&s=460" alt=""></td><td name="name"></td><td name="gender"></td><td name="age"></td><td name="number"></td><td name="company"></td><td><input type="button" value="修改" class="layui-btn update-btn" /><input type="button" value="删除" class="layui-btn del-btn"/><input name="companyId" type="hidden" value=""></td></tr>');
	layui.use(['layer', 'element', 'form', 'upload', 'laypage',],function(){
		var layer = layui.layer, element = layui.element, form = layui.form, upload = layui.upload, laypage = layui.laypage;
		laypage({
			cont: 'look-page'
			, pages: Math.ceil($('#OpratorDriverPageNum').val()) // 得到总页数
			, jump: function (obj, first) {
				var curr = obj.curr;
				$(".look .tbody").empty();
				$.get("oprator/showDriver?count=" + curr,
					addToTableLook, "json")
			}
		});
		function addToTableLook(driverList) {
			var thead = $(".look .tbody");
			addToTable(driverList, thead, tr);
			// two button click listener
			$(".del-btn").click(deleteDriver);
			$(".update-btn").click(updateDriver);
		}
		function addToTable(driverList, thead, tr) {
			thead.css("display", "none");
			for (var i in driverList) {
				var driver = driverList[i];
				var trTemp = tr.clone();
				var tChild = trTemp.children();
				tChild.get(0).innerText = driver.id;
				tChild.get(1).innerHTML = '<img src='
					+ driver.image + '/>';
				tChild.get(2).innerText = driver.name;
				tChild.get(3).innerText = driver.gender;
				tChild.get(4).innerText = driver.age;
				tChild.get(5).innerText = driver.number;
				tChild.get(6).innerText = driver.companyName;
				tChild.find("input[type=hidden][name=companyId]").val(driver.companyId);
				thead.append(trTemp);
			}
			thead.css("display", "");
		}
		function deleteDriver(e) {
			var $tr = $(e.target.parentElement.parentElement);
			var driverId = $tr.find("td[name=id]").text();
			console.log(driverId);
			$(e.target).addClass('layui-btn-disabled');
			$.post("deleteDriver"
				, { driverId: driverId }
				, function (date) {
					if (date.code == 1) {
						layer.open({
							title: '删除成功',
							shadeClose: true,
							offset: '100px',
							content: '该司机删除成功'
						});
						$tr.hide("slow");
					} else {
						layer.open({
							title: '删除失败',
							shadeClose: true,
							offset: '100px',
							content: '不好意思，刚刚的操作失败了'
						});
					}
				}, 'json');
		}
		// 修改driver
		function updateDriver(e) {
			var tr = $(e.target.parentElement.parentElement);
			var tChild = tr.children();
			var update = $(".update");
			update.find("#update-id").val(tChild.get(0).innerText);
			update.find("#update-number").val(tChild.get(5).innerText);
			update.find("#update-name").val(tChild.get(2).innerText);
			var gender = tChild.get(3).innerText;
			//TODO 这里因为使用了layui美化了单选框，所以不能设置checked，这是问题！
			/*if(gender=="男"){
				update.find("input[name=gender][value=male]").attr("checked","1");
			}else{
				update.find("input[name=gender][value=female]").attr("checked","1");
			}*/
			update.find("#update-age").val(tChild.get(4).innerText);
			update.find("#update-companyId").val(tChild.find("input[type=hidden][name=companyId]").val());

			laypageIndex = layer.open({
				type: 1,
				title: '修改司机',
				area: ['500px', '500px'],
				offset: '20px',
				content: update
			});
		}
	});
	</script>
