layui.use('form', function () {
    var form = layui.form();

    //监听提交
    form.on('submit(update)', checkDriver);
    form.on('submit(add)', checkDriver);
});

function checkDriver(data) {
    var telNumberReg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
    var field = data.field;

    if (field.name == '' || field.name.length < 2 || field.name.length > 10) {
        errAlert("名字没有在2~10个字之间");
        return false;
    }
    if (field.id.length != 13) {
        errAlert('ID长度不符 要求13位');
        return false;
    }
    if (field.number.length != 11 || !telNumberReg.test(field.number)) {
        errAlert('电话号长度或格式不符');
        return false;
    }
    if (field.bindCarId != '' && field.bindCarId.length != 12) {
        errAlert('车辆ID长度不符，要求12位');
        return false;
    }
    if (field.companyId != undefined && field.companyId == '') {
        errAlert('公司ID不能为空');
        return false;
    }
    if (field.imagePath == '') {
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