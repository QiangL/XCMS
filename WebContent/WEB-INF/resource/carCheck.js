layui.use('form', function () {
    var form = layui.form();

    //监听提交
    form.on('submit(update)', checkCar);
    form.on('submit(add)', checkCar);
});
function checkCar(data) {
    var field=data.field;

    if(field.id.length!=12){
        errAlert('ID长度不符');
        return false;
    }
    if(field.number.length!=7){
        errAlert('车牌号长度不符');
        return false;
    }
    if(field.model==''){
        errAlert('车型没有填写');
        return false;
    }

    if(field.companyId!=undefined && field.companyId==''){
        errAlert('请填写公司ID');
        return false;
    }
    if(field.imagePath==''){
        errAlert('请上传图片');
        return false;
    }

    return true;
}
function errAlert(msg) {
    layui.use('layer', function () {
        var layer = layui.layer;
        layer.msg(msg);
    });
}