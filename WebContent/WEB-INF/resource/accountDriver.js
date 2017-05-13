var layer, element, form , upload , laypage;
layui.use(['layer', 'element', 'form', 'upload', 'laypage',],
		function () {
		layer = layui.layer, element = layui.element, form = layui.form, upload = layui.upload, laypage = layui.laypage;
		showDriverPage(1);
		upload({
			url: 'upload'
			, elem: '#add-image-input'
			// //指定原始元素，默认直接查找class="layui-upload-file"
			, method: 'post' // 上传接口的http类型
			, success: function (res) {
				$("#add-image").attr("src", res.date.src);
				$("#add-imagePath").val(res.date.src);
			}
		});
		upload({
			url: 'upload'
			, elem: '#update-image-input'
			// //指定原始元素，默认直接查找class="layui-upload-file"
			, method: 'post' // 上传接口的http类型
			, success: function (res) {
				$("#update-image").attr("src", res.date.src);
				$("#update-imagePath").val(res.date.src);
			}
		});
	});
/*
// 审核 driver
function examAddDriver(e) {
	var $tr = $(e.target.parentElement.parentElement);
	var driverId = $tr.find("td[name=id]").text();
	console.log(driverId);
	$(e.target).addClass('layui-btn-disabled');
	$.post("oprator/examAddDriver", {
		driverId: driverId
	}, function (date) {
		if (date.code == 1) {
			layer.open({
				title: '提交成功',
				shadeClose: true,
				offset: '100px',
				content: '该司机审核成功'
			});
			$tr.hide("slow");
		} else {
			layer.open({
				title: '提交失败',
				shadeClose: true,
				offset: '100px',
				content: '不好意思，刚刚的操作失败了'
			});
		}
	}, 'json');
}
function examDelDriver(e) {
	var $tr = $(e.target.parentElement.parentElement);
	var driverId = $tr.find("td[name=id]").text();
	console.log(driverId);
	$(e.target).addClass('layui-btn-disabled');
	$.post("oprator/examDelDriver", {
		driverId: driverId
	}, function (date) {
		if (date.code == 1) {
			layer.open({
				title: '提交成功',
				shadeClose: true,
				offset: '100px',
				content: '该司机审核成功'
			});
			$tr.hide("slow");
		} else {
			layer.open({
				title: '提交失败',
				shadeClose: true,
				offset: '100px',
				content: '不好意思，刚刚的操作失败了'
			});
		}
	}, 'json');
}
function showNotExamDelDriverPage(page){
	var pageNumber;
	$.get("oprator/notExamDelDriverPageNum",
			function(date){
		pageNumber=date;
	});
	$.get("oprator/showNotExamDelDriver?count=" + page
			, function (date) {
			addToTableExamDel(date);
			layui.use(['layer', 'laypage',],function(){
				layui.laypage({
					cont: 'examDel-page'
					,curr: page
					, pages: Math.ceil(pageNumber/8) // 得到总页数
					, jump: function (obj, first) {
						if(!first){
							showNotExamDelDriverPage(obj.curr);
						}
					}
				});
			});
			}
			, 'json'
		);
}
function showNotExamAddDriverPage(page){
	var pageNumber;
	$.get("oprator/notExamAddDriverPageNum",
			function(date){
		pageNumber=date;
	});
	$.get("oprator/showNotExamAddDriver?count=" + page
			, function (date) {
			addToTableExamAdd(date);
			layui.use(['layer', 'laypage',],function(){
				layui.laypage({
					cont: 'examAdd-page'
					,curr: page
					, pages: Math.ceil(pageNumber/8) // 得到总页数
					, jump: function (obj, first) {
						if(!first){
							showNotExamAddDriverPage(obj.curr);
						}
					}
				});
			});
			}
			, 'json'
		);
}
//异步加载需审核driver
function addToTableExamAdd(driverList) {
	var thead = $(".examAdd .tbody");
	thead.empty();
	addToTable(driverList, thead, examAddTr);
	$(".examAdd .exam-btn").click(examAddDriver);
}
function addToTableExamDel(driverList) {
	var thead = $(".examDel .tbody");
	thead.empty();
	addToTable(driverList, thead, examDelTr);
	$(".examDel .exam-btn").click(examDelDriver);
}
*/
function deleteDriver(e) {
	var $tr = $(e.target.parentElement.parentElement);
	var driverId = $tr.find("td[name=id]").text();
	console.log(driverId);
	$(e.target).addClass('layui-btn-disabled');
	$.post("account/deleteDriver"
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
	update.find("#update-bind-carId").val(tChild.get(6).innerText);
	var gender = tChild.get(3).innerText;
	if(gender=="女"){
		update.find("input[type=radio][value=female]").next().find("i").click()
	}
	console.log(tChild.get(1));
	var imagePath=tChild.get(1).childNodes[0].src;
	update.find("#update-imagePath").val(imagePath);
	update.find("#update-image").attr("src",imagePath);
	update.find("#update-age").val(tChild.get(4).innerText);
	update.find("#update-companyId").val(tChild.find("input[type=hidden][name=companyId]").val());
	$(".look").addClass("display-none");
	update.removeClass("display-none");		
}

// 异步加载driver
function addToTableLook(driverList) {
	var thead = $(".look .tbody");
	thead.empty();
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
			+ driver.imagePath + '>';
		tChild.get(2).innerText = driver.name;
		tChild.get(3).innerText = driver.gender;
		tChild.get(4).innerText = driver.age;
		tChild.get(5).innerText = driver.number;
		if(driver.carNumber){
			tChild.get(6).innerText = driver.carNumber;
		}
		
		
		
		tChild.get(7).innerText = driver.companyName;
		if(driver.isExam==1){
			tChild.get(8).innerText ='正常状态司机'; 
		}else{
			if(driver.isExam== 0){
				tChild.get(8).innerText ='新增状态司机';
			}else if(driver.isExam== -1){
				tChild.get(8).innerText ='删除状态司机';
			}
			tChild.find('.update-btn').addClass('layui-btn-disabled');
			tChild.find('.del-btn').addClass('layui-btn-disabled');
		}
		
		
		
		tChild.find("input[type=hidden][name=companyId]").val(driver.companyId);
		thead.append(trTemp);
	}
	thead.css("display", "");
}
function showDriverPage(page) {
	var pageNumber;
	$.get("account/driverPageNum",
			function(date){
		pageNumber=date;
	});
	$.get("account/showDriver?count=" + page
		, function (date) {
			addToTableLook(date);
			layui.use(['layer', 'laypage',],function(){
				layui.laypage({
				cont: 'look-page'
				,curr: page
				, pages: Math.ceil(pageNumber/8) // 得到总页数
				, jump: function (obj, first) {
					if(!first){
						showDriverPage(obj.curr);
					}
				}
			});
			});
		}
		, 'json'
	);
}


// 左侧需要用的切换方法
function switchToExamAdd() {
	$(".examAdd").removeClass("display-none");
	$(".examDel").addClass("display-none");
	$(".add").addClass("display-none");
	$(".look").addClass("display-none");
	$(".update").addClass("display-none");
	showNotExamAddDriverPage(1);
}
function switchToExamDel() {
	$(".examDel").removeClass("display-none");
	$(".examAdd").addClass("display-none");
	$(".add").addClass("display-none");
	$(".look").addClass("display-none");
	$(".update").addClass("display-none");
	showNotExamDelDriverPage(1);
}
function switchToAdd() {
	$(".examAdd").addClass("display-none");
	$(".examDel").addClass("display-none");
	$(".add").removeClass("display-none");
	$(".look").addClass("display-none");
	$(".update").addClass("display-none");
}
function switchToLook() {
	$(".examAdd").addClass("display-none");
	$(".examDel").addClass("display-none");
	$(".add").addClass("display-none");
	$(".look").removeClass("display-none");
	$(".update").addClass("display-none");
	showDriverPage(1);
}
