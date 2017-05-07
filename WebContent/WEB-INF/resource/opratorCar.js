var layer, element, form, upload, laypage;
layui.use([ 'layer', 'element', 'form', 'upload', 'laypage', ], function() {
	layer = layui.layer, element = layui.element, form = layui.form,
			upload = layui.upload, laypage = layui.laypage;
	showCarPage(1);
	upload({
		url : 'upload',
		elem : '#add-image-input'
		// //指定原始元素，默认直接查找class="layui-upload-file"
		,
		method : 'post' // 上传接口的http类型
		,
		success : function(res) {
			$("#add-image").attr("src", res.date.src);
			$("#add-imagePath").val(res.date.src);
		}
	});
	upload({
		url : 'upload',
		elem : '#update-image-input'
		// //指定原始元素，默认直接查找class="layui-upload-file"
		,
		method : 'post' // 上传接口的http类型
		,
		success : function(res) {
			$("#update-image").attr("src", res.date.src);
			$("#update-imagePath").val(res.date.src);
		}
	});

});
function showNotExamAddCar(page){
	var pageNumber;
	$.get("oprator/OpratorNotExamAddCarPageNum",function(date){pageNumber=date;});
	$.get("oprator/showNotExamAddCar?count="+page,function(date){
		addToTableExamAdd(date);
		layui.use([ 'layer', 'laypage', ], function() {
			layui.laypage({
				cont : 'examAdd-page',
				curr: page,
				pages : Math.ceil(pageNumber/8) // 得到总页数
				,
				jump : function(obj, first) {
					if(!first){
						showNotExamAddCar(obj.curr);
					}
				}
			});
		});
	},'json');
}

function showNotExamDelCar(page){
	var pageNumber;
	$.get("oprator/OpratorNotExamDelCarPageNum", function(date) {
		pageNumber = date;
	})
	$.get("oprator/showNotExamDelCar?count="+page,function(date){
		addToTableExamDel(date);
		layui.use([ 'layer', 'laypage', ], function() {
			layui.laypage({
				cont : 'examDel-page',
				curr: page,
				pages : Math.ceil(pageNumber/8) // 得到总页数
				,
				jump : function(obj, first) {
					if(!first){
						showNotExamDelCar(obj.curr);
					}
				}
			});
	},'json');

});
}
function showCarPage(page) {
	var pageNumber;
	$.get("oprator/OpratorCarPageNum", function(date) {
		pageNumber = date;
	})
	$.get("oprator/showCar?count="+page, function(date) {
		addToTableLook(date);
		layui.use([ 'layer', 'laypage', ], function() {
			layui.laypage({
				cont : 'look-page',
				curr: page,
				pages : Math.ceil(pageNumber/8) // 得到总页数
				,
				jump : function(obj, first) {
					if(!first){
						showCarPage(obj.curr);
					}
				}
			});
		});
	}, 'json')
}
// 审核 driver
function examAddCar(e) {
	var $tr = $(e.target.parentElement.parentElement);
	var carId = $tr.find("td[name=id]").text();
	console.log(carId);
	$(e.target).addClass('layui-btn-disabled');
	$.post("oprator/examAddCar", {
		carId : carId
	}, function(date) {
		if (date.code == 1) {
			layer.open({
				title : '提交成功',
				shadeClose : true,
				offset : '100px',
				content : '该车辆审核成功'
			});
			$tr.hide("slow");
		} else {
			layer.open({
				title : '提交失败',
				shadeClose : true,
				offset : '100px',
				content : '不好意思，刚刚的操作失败了'
			});
		}
	}, 'json');
}
function examDelCar(e) {
	var $tr = $(e.target.parentElement.parentElement);
	var carId = $tr.find("td[name=id]").text();
	console.log(carId);
	$(e.target).addClass('layui-btn-disabled');
	$.post("oprator/examDelCar", {
		carId : carId
	}, function(date) {
		if (date.code == 1) {
			layer.open({
				title : '提交成功',
				shadeClose : true,
				offset : '100px',
				content : '该车辆审核成功'
			});
			$tr.hide("slow");
		} else {
			layer.open({
				title : '提交失败',
				shadeClose : true,
				offset : '100px',
				content : '不好意思，刚刚的操作失败了'
			});
		}
	}, 'json');
}
function deleteCar(e) {
	var $tr = $(e.target.parentElement.parentElement);
	var carId = $tr.find("td[name=id]").text();
	console.log(carId);
	$(e.target).addClass('layui-btn-disabled');
	$.post("oprator/deleteCar", {
		carId : carId
	}, function(date) {
		if (date.code == 1) {
			layer.open({
				title : '删除成功',
				shadeClose : true,
				offset : '100px',
				content : '该车辆删除成功'
			});
			$tr.hide("slow");
		} else {
			layer.open({
				title : '删除失败',
				shadeClose : true,
				offset : '100px',
				content : '不好意思，刚刚的操作失败了'
			});
		}
	}, 'json');
}
// 修改driver
function updateCar(e) {
	var tr = $(e.target.parentElement.parentElement);
	var tChild = tr.children();
	var update = $(".update");
	update.find("#update-id").val(tChild.get(0).innerText);
	update.find("#update-number").val(tChild.get(2).innerText);
	update.find("#update-model").val(tChild.get(3).innerText);
	update.find("#update-color").val(tChild.get(4).innerText)
	var gender = tChild.get(3).innerText;
	// TODO 这里因为使用了layui美化了单选框，所以不能设置checked，这是问题！
	/*
	 * if(gender=="男"){
	 * update.find("input[name=gender][value=male]").attr("checked","1"); }else{
	 * update.find("input[name=gender][value=female]").attr("checked","1"); }
	 */
	var imagePath = tChild.get(1).childNodes[0].src;
	update.find("#update-imagePath").val(imagePath);
	update.find("#update-image").attr("src", imagePath);
	update.find("#update-displacement").val(tChild.get(5).innerText);
	update.find("#update-companyId").val(
			tChild.find("input[type=hidden][name=companyId]").val());
	$(".look").addClass("display-none");
	update.removeClass("display-none");
}
// 异步加载需审核driver
function addToTableExamAdd(carList) {
	var thead = $(".examAdd .tbody");
	thead.empty();
	addToTable(carList, thead, examAddTr);
	$(".examAdd .exam-btn").click(examAddCar);
}
function addToTableExamDel(carList) {
	var thead = $(".examDel .tbody");
	thead.empty();
	addToTable(carList, thead, examDelTr);
	$(".examDel .exam-btn").click(examDelCar);
}
// 异步加载driver
function addToTableLook(carList) {
	var thead = $(".look .tbody");
	thead.empty();
	addToTable(carList, thead, tr);
	// two button click listener
	$(".del-btn").click(deleteCar);
	$(".update-btn").click(updateCar);
}
function addToTable(carList, thead, tr) {
	thead.css("display", "none");
	for ( var i in carList) {
		var car = carList[i];
		var trTemp = tr.clone();
		var tChild = trTemp.children();
		tChild.get(0).innerText = car.id;
		tChild.get(1).innerHTML = '<img src=' + car.image + '/>';
		tChild.get(2).innerText = car.number;
		tChild.get(3).innerText = car.model;
		tChild.get(4).innerText = car.color;
		tChild.get(5).innerText = car.displacement;
		tChild.get(6).innerText = car.companyName;
		tChild.find("input[type=hidden][name=companyId]").val(car.companyId);
		thead.append(trTemp);
	}
	thead.css("display", "");
}
// 左侧需要用的切换方法
function switchToExamAdd() {
	$(".examAdd").removeClass("display-none");
	$(".examDel").addClass("display-none");
	$(".add").addClass("display-none");
	$(".look").addClass("display-none");
	$(".update").addClass("display-none");
	showNotExamAddCar(1);
}
function switchToExamDel() {
	$(".examDel").removeClass("display-none");
	$(".examAdd").addClass("display-none");
	$(".add").addClass("display-none");
	$(".look").addClass("display-none");
	$(".update").addClass("display-none");
	showNotExamDelCar(1);
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
	showCarPage(1);
}
