layui.use([ 'layer', 'element', 'form', 'laypage', ], function() {
	var layer = layui.layer, element = layui.element, form = layui.form,
			upload = layui.upload, laypage = layui.laypage;
});
function flushPage(page){
	showPage('oprator/OpratorCompanyPageNum','oprator/showCompany?count=','look-page',page,addToTable,flushPage);
}
function addToTable(companyList){
	var tbody=$(".look tbody");
	tbody.css("display","none");
	tbody.empty();
	for(var i in companyList){
		var company=companyList[i];
		var trTemp=tr.clone();
		var tChild=trTemp.children();
		tChild.get(0).innerText=company.id;
		tChild.get(1).innerText=company.name;
		tChild.get(2).innerText=company.owner;
		tChild.get(3).innerText=company.tel;
		tChild.get(4).innerText=company.email;
		tChild.get(5).innerText=company.publicAccount;
		tbody.append(trTemp);
	}
	$(".look tbody .update-btn").click(updateClick);
	$(".look tbody .del-btn").click(delClick);
	tbody.css("display","");
}
function updateClick(e){
	var $tr = $(e.target.parentElement.parentElement);
	var tChild=$tr.children();
	var companyId=$tr.children().get(0).innerText;
	console.log(companyId);
	var update=$(".update");
	update.find("#update-id").val(tChild.get(0).innerText);
	update.find("#update-name").val(tChild.get(1).innerText);
	update.find("#update-owner").val(tChild.get(2).innerText);
	update.find("#update-tel").val(tChild.get(3).innerText);
	update.find("#update-email").val(tChild.get(4).innerText);
	update.find("#update-publicAccount").val(tChild.get(5).innerText);
	$(".look").addClass("display-none");
	update.removeClass("display-none");
}
function delClick(e){
	var $tr = $(e.target.parentElement.parentElement);
	var companyId=$tr.children().get(0).innerText;
	console.log(companyId);
	$(e.target).addClass('layui-btn-disabled');
	$.post("oprator/deleteCompany", {
		companyId: companyId
	}, function (date) {
		layui.use('layer',function(){
			var layer=layui.layer;
			if (date.code == 1) {
				layer.open({
					title: '提交成功',
					shadeClose: true,
					offset: '100px',
					content: '该公司删除成功'
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
		});
		
	}, 'json');
	
}
function showPage(pageNumberURL,listURL,pageDiv,page,func,callbackFunc) {
	var pageNumber;
	$.get(pageNumberURL, function(date) {
		pageNumber = date;
	})
	$.get(listURL+page, function(date) {
		func(date);
		layui.use([ 'layer', 'laypage', ], function() {
			layui.laypage({
				cont : pageDiv,
				curr: page,
				pages : Math.ceil(pageNumber/8) // 得到总页数
				,
				jump : function(obj, first) {
					if(!first){
						callbackFunc(obj.curr);
					}
				}
			});
		});
	}, 'json');
}
function switchToAdd(){
	$(".update").addClass("display-none");
	$(".look").addClass("display-none");
	$(".add").removeClass("display-none");
}
function switchToLook(){
	$(".look").removeClass("display-none");
	$(".update").addClass("display-none");
	$(".add").addClass("display-none");
	flushPage(1);
}



