layui.use([ 'layer', 'element', 'form', 'laypage', ], function() {
	var layer = layui.layer, element = layui.element, form = layui.form,
			upload = layui.upload, laypage = layui.laypage;
	
});
function flushListPage(page) {
    showPage('account/financePageNumber', 'account/showFinance?count=', 'list-page', page, addToTableList, flushListPage);
}
function flushHistoryPage(page) {
    showPage('account/historyFinancePageNumber', 'account/showHistoryFinance?count=', 'history-page', page, addToTableHistory, flushHistoryPage);
}
function addToTableList(financeList) {
    var tbody = $(".list tbody");
    tbody.css("display", "none");
    tbody.empty();
    for (var i in financeList) {
        var finance = financeList[i];
        var trTemp = listTr.clone();
        var tChild = trTemp.children();
        tChild.get(0).innerText = finance.id;
        tChild.get(1).innerText = finance.companyName;
        tChild.get(2).innerText = finance.date;
        
        tChild.get(3).innerHTML = finance.amount + motifyInput;
        tChild.get(4).innerText = finance.companyPublicAccount;
        tChild.find("input[name=companyId]").val(finance.companyId);
        tbody.append(trTemp);
    }
    $(".list tbody .confirm-btn").click(confirmClick);
    $(".list tbody .detail-btn").click(detailClick);
    $(".list tbody .motify-btn").click(motifyClick);
    tbody.css("display", "");
}
function addToTableHistory(financeList) {
    var tbody = $(".history tbody");
    tbody.css("display", "none");
    tbody.empty();
    for (var i in financeList) {
        var finance = financeList[i];
        var trTemp = historyTr.clone();
        var tChild = trTemp.children();
        tChild.get(0).innerText = finance.id;
        tChild.get(1).innerText = finance.companyName;
        tChild.get(2).innerText = finance.date;
        tChild.get(3).innerText = finance.amount;
        tChild.get(4).innerText = finance.companyPublicAccount;
        tChild.find("input[name=companyId]").val(finance.companyId);
        tbody.append(trTemp);
    }
    tbody.css("display", "");
}
function addToTableDetail(orderList) {
    var tbody = $(".detail tbody");
    tbody.css("display", "none");
    tbody.empty();
    for (var i in orderList) {
        var order = orderList[i];
        var trTemp = detailTr.clone();
        var tChild = trTemp.children();
        tChild.get(0).innerText = order.driverId;
        tChild.get(1).innerText = order.quantity;
        tChild.get(2).innerText = order.chargingTime.toFixed(2);
        tChild.get(3).innerText = order.transactionAmount.toFixed(2);
        tChild.get(4).innerText = order.badReview.toFixed(2);
        tChild.get(5).innerText = order.driverScore.toFixed(2);
        tChild.get(6).innerText = order.driverGrade;
        tbody.append(trTemp);
    }
    tbody.css("display", "");
}
function motifyClick(e) {
	var $tr = $(e.target.parentElement.parentElement);
    var companyId = $tr.children().find("input[name=companyId]").val();
    var money=$tr.find("td[name=money]").text();
    var financeId=$tr.find("td[name=id]").text();
    layui.use('layer', function () {
        var layer = layui.layer;
        layer.prompt({title: '输入修改金额,无需其他非数字字符',value: money},function(value, index, elem){
        	$.post("account/motifyAmount", {
        		financeId: financeId,
        		amount:value
        	}, function (date) {
        		if (date.code == 1) {
        			layer.open({
        				title: '提交成功',
        				shadeClose: true,
        				offset: '100px',
        				content: '金额修改成功'
        			});
        			$tr.find("td[name=money]").html(value+motifyInput);
        			$(".list tbody .motify-btn").click(motifyClick);
        		} else {
        			layer.open({
        				title: '提交失败',
        				shadeClose: true,
        				offset: '100px',
        				content: '不好意思，刚刚的操作失败了'
        			});
        		}
        	}, 'json');
    	    layer.close(index);
    	});
    });
    
}

function detailClick(e) {
    var $tr = $(e.target.parentElement.parentElement);
    var companyId = $tr.children().find("input[name=companyId]").val();
    $.get('account/showOrder?companyId='+companyId
        , function (date) {
            addToTableDetail(date);
            layui.use('layer', function () {
                var layer = layui.layer;
                layer.open({
                    type: 1,
                    area: ['800px', '500px'],
                    offset: '50px',
                    content: $('.detail')
                });
            });
        });
}

function confirmClick(e) {
    var $tr = $(e.target.parentElement.parentElement);
    var financeId = $tr.children().get(0).innerText;
    console.log(financeId);
    $(e.target).addClass('layui-btn-disabled');
    $.post("account/confirmFinance", {
        financeId: financeId
    }, function (date) {
        layui.use('layer', function () {
            var layer = layui.layer;
            if (date.code == 1) {
                layer.open({
                    title: '提交成功',
                    shadeClose: true,
                    offset: '100px',
                    content: '分账信息已提交'
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
function showPage(pageNumberURL, listURL, pageDiv, page, func, callbackFunc) {
    var pageNumber;
    $.get(pageNumberURL, function (date) {
        pageNumber = date;
    })
    $.get(listURL + page, function (date) {
        func(date);
        layui.use(['layer', 'laypage',], function () {
            layui.laypage({
                cont: pageDiv,
                curr: page,
                
                pages: Math.ceil(pageNumber / 8) // 得到总页数
                ,
                jump: function (obj, first) {
                    if (!first) {
                        callbackFunc(obj.curr);
                    }
                }
            });
        });
    }, 'json')
}
function switchToList() {
	$(".history").addClass("display-none");
	$(".detail").addClass("display-none");
	$(".list").removeClass("display-none");
	flushListPage(1);
}
function switchToHistory() {
	$(".history").removeClass("display-none");
	$(".detail").addClass("display-none");
	$(".list").addClass("display-none");
	flushHistoryPage(1);
}

