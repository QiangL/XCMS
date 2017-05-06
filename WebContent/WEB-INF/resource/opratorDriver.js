layui.use(['layer', 'element', 'form', 'upload', 'laypage',],
	function () {
		var layer = layui.layer, element = layui.element, form = layui.form, upload = layui.upload, laypage = layui.laypage;
		// loadNotExamPage(1);
		// loadPage(1);
		// function loadNotExamPage(page) {
		// 	$.get(
		// 		"oprator/showNotExamDriver?count=" + page
		// 		, function (date) {
		// 			console.log(date);
		// 			addToTableExam(date.date.driverList);
		// 			var number = date.date.notExamDriverNumber;
		// 			laypage({
		// 				cont: 'exam-page'
		// 				, pages: Math.ceil(number / 8) // 得到总页数
		// 				, jump: function (obj, first) {
		// 					if (!first) {
		// 						loadNotExamPage(obj.curr);
		// 					}
		// 					// var curr = obj.curr;
		// 					// $(".exam .tbody").empty();
		// 					// $.get("oprator/showNotExamDriver?count=" + curr,
		// 					// 	addToTableExam, "json")
		// 				}
		// 			});
		// 		}
		// 		, 'json'
		// 	)
		// }
		// function loadPage(page) {
		// 	$.get(
		// 		"oprator/showDriver?count=" + page
		// 		, function (date) {
		// 			addToTableLook(date.date.driverList);
		// 			var number = date.date.notExamDriverNumber;
		// 			laypage({
		// 				cont: 'look-page'
		// 				, pages: Math.ceil(number/8) // 得到总页数
		// 				, jump: function (obj, first) {
		// 					if(!first){
		// 						loadPage(obj.curr);
		// 					}
		// 					// var curr = obj.curr;
		// 					// $(".look .tbody").empty();
		// 					// $.get("oprator/showDriver?count=" + curr,
		// 					// 	addToTableLook, "json")
		// 				}
		// 			});
		// 		}
		// 		, 'json'
		// 	)
		// }
		laypage({
			cont: 'exam-page'
			, pages: Math.ceil($('#OpratorNotExamPageNum').val()) // 得到总页数
			, jump: function (obj, first) {
				var curr = obj.curr;
				$(".exam .tbody").empty();
				$.get("oprator/showNotExamDriver?count=" + curr,
					addToTableExam, "json")
			}
		});
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
		// 审核 driver
		function examDriver(e) {
			var $tr = $(e.target.parentElement.parentElement);
			var driverId = $tr.find("td[name=id]").text();
			console.log(driverId);
			$(e.target).addClass('layui-btn-disabled');
			$.post("oprator/examDriver", {
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
			$(".look").addClass("display-none");
			update.removeClass("display-none");		
		}
		// 异步加载需审核driver
		function addToTableExam(driverList) {
			var thead = $(".exam .tbody");
			addToTable(driverList, thead, examTr);
			$(".exam-btn").click(examDriver);
		}
		// 异步加载driver
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
		
	});

// 左侧需要用的切换方法
function switchToExam() {
	$(".exam").removeClass("display-none");
	$(".add").addClass("display-none");
	$(".look").addClass("display-none");
	$(".update").addClass("display-none");
}
function switchToAdd() {
	$(".exam").addClass("display-none");
	$(".add").removeClass("display-none");
	$(".look").addClass("display-none");
	$(".update").addClass("display-none");
}
function switchToLook() {
	$(".exam").addClass("display-none");
	$(".add").addClass("display-none");
	$(".look").removeClass("display-none");
	$(".update").addClass("display-none");
}
