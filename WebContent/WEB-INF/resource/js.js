
layui.use('layer', function () {
    var layer = layui.layer;

});

layui.use('element', function () {
    var element = layui.element();
});
layui.use('form', function () {
    var form = layui.form(); //只有执行了这一步，部分表单元素才会修饰成功

    //……
});
layui.use('upload', function () {
    layui.upload({
        url: '/test/upload.json'
        //, elem: '#test' //指定原始元素，默认直接查找class="layui-upload-file"
        , method: 'post' //上传接口的http类型
        , success: function (res) {
            //LAY_demo_upload.src = res.url;
        }
    });
});

