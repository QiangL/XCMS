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
    if(field.color==''){
    	errAlert('颜色没有填写');
        return false;
    }
    if(field.displacement==''){
    	errAlert('排量没有填写');
        return false;
    }
    
    if(field.companyId!=undefined && field.companyId==''){
        errAlert('请选择公司');
        return false;
    }
    if(field.imagePath==''){
        errAlert('请上传图片');
        return false;
    }

    alert("验证通过，提交后跳转");
    
    return true;
}
function errAlert(msg) {
    layui.use('layer', function () {
        var layer = layui.layer;
        layer.msg(msg);
    });
}