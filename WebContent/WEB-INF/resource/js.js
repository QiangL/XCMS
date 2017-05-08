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
	}, 'json')
}


