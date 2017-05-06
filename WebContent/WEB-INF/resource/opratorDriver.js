function examDriver(e) {
    var $tr = $(e.target.parentElement.parentElement);
    var driverId = $tr.find("td[name=id]").text();
    console.log(driverId);
    $(e.target).addClass('layui-btn-disabled');
    $.post(
        "examDriver",
        { driverId: driverId },
        function (date) {
            if (date.code == 1) {
                layui.use('layer', function () {
                    var layer = layui.layer;
                    layer.open({
                        title: '提交成功'
                        , shadeClose: true
                        , content: '该司机审核成功'
                    });
                });
                $tr.hide("slow");
            } else {
                layui.use('layer', function () {
                    var layer = layui.layer;
                    layer.open({
                        title: '提交失败'
                        , shadeClose: true
                        , content: '不好意思，刚刚的操作失败了'
                    });
                });
            }
        },
        'json'
    );
}
function lookForDriver() {
    var $tr = $(e.target.parentElement.parentElement);
    var id = $tr.find("td[name=id]").text();
    $.get(
        "getDriver",
        function (date) {



            layer.open({
                type: 1
                , title: '提交成功'
                , content: $(".update")
            });
        },
        'json'
    )
}
function addToTableExam(driverList) {
	var thead=$(".exam .tbody");
    addToTable(driverList,thead,examTr);
    $(".exam-btn").click(examDriver);
}
function addToTableLook(driverList){
	var thead=$(".look .tbody");
    addToTable(driverList,thead,tr);
    // two button click listener
    
}
function addToTable(driverList,thead,tr){
	thead.css("display", "none");
	for (var i in driverList) {
        var driver = driverList[i];
        var trTemp = tr.clone();
        var tChild = trTemp.children();
        tChild.get(0).innerText = driver.id;
        tChild.get(1).innerHTML = '<img src=' + driver.image + '/>';
        tChild.get(2).innerText = driver.name;
        tChild.get(3).innerText = driver.gender;
        tChild.get(4).innerText = driver.age;
        tChild.get(5).innerText = driver.number;
        tChild.get(6).innerText = driver.companyName;
        thead.append(trTemp);
    }
	thead.css("display", "");
}
