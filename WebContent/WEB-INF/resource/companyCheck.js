layui.use('form', function () {
    var form = layui.form();

    //监听提交
    form.on('submit(update)', checkCompany);
    form.on('submit(add)', checkCompany);
});
function errAlert(msg) {
    layui.use('layer', function () {
        var layer = layui.layer;
        layer.msg(msg);
    });
}
function checkCompany(data){
    var field=data.field;
    var telNumberReg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
    var emailReg=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/ ;
    if(field.id.length!=7){
    	errAlert('ID长度不符');
        return false;
    }
    if(!telNumberReg.test(field.tel)){
        errAlert('电话号长度或格式不符');
        return false;
    }
    if(!emailReg.test(field.email)){
        errAlert('邮箱格式不符');
        return false;
    }
    
    alert("验证通过，提交后跳转");
    
    return true;
}