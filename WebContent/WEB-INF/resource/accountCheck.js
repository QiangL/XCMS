layui.use('form', function () {
    var form = layui.form();

    //监听提交
    form.on('submit(update)', checkAccount);
    form.on('submit(add)', checkAccount);
});
function errAlert(msg) {
    layui.use('layer', function () {
        var layer = layui.layer;
        layer.msg(msg);
    });
}
function checkAccount(data){
    var field=data.field;
    if(field.id==''){
        errAlert('请填写ID');
        return false;
    }
    if(field.companyId==''){
        errAlert('请填写公司ID');
        return false;
    }
    if(field.password.length<6 ||field.password.length>16){
        errAlert('密码长度不符');
        return false;
    }
    if(field.password!=field.password2){
        errAlert('两次密码输入不同');
        return false;
    }
    alert("验证通过，提交后跳转");
    return true;
}