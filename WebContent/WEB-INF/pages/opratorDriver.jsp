<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="opratorTemplateHeader.jsp" %>


        <div class="layui-layer-content content">
            <div class="exam">
                <table class="layui-table" lay-even lay-skin="line">
                    <colgroup>
                        <col width="65"/>
                        <col width="100" />
                        <col width="100" />
                        <col width="60" />
                        <col width="60" />
                        <col width="150" />
                        <col width="250" />
                        <col/>
                    </colgroup>
                    <thead class="thead">
                        <tr>
                            <th>id</th>
                            <th>照片</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>年龄</th>
                            <th>电话</th>
                            <th>所属合作伙伴</th>
                            <th>操作</th>
                        </tr>
                        
                    </thead>
                </table>
                <div class="layui-layer-page" id="exam-page"></div>
            </div>
            <div class="add">
                <form action="../opratorDriver/addDriver" method="POST" class="layui-form">
                    <div class="layui-form-item">
                        <label class="layui-form-label" for="add-id">司机ID</label>
                        <div class="layui-input-block">
                            <input type="text" id="add-id" name="id" placeholder="输入司机ID" required="true" class="layui-input" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="add-number" class="layui-form-label">司机手机号</label>
                        <div class="layui-input-block">
                            <input type="text" id="add-number" name="number" placeholder="输入司机手机号" required class="layui-input" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="add-name" class="layui-form-label">司机姓名</label>
                        <div class="layui-input-block">
                            <input type="text" id="add-name" name="name" placeholder="输入司机姓名" required class="layui-input" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="add-gender" class="layui-form-label">司机性别</label>
                        <div class="layui-input-block">
                            <input type="radio" name="gender" value="male" title="男" checked/>
                            <input type="radio" name="gender" value="female" title="女" />
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="add-age" class="layui-form-label">司机年龄</label>
                        <div class="layui-input-block">
                            <input type="number" id="add-age" name="age" max="70" min="18" value="25" placeholder="输入司机年龄" required class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="add-image" class="layui-form-label">司机头像</label>
                        <div class="layui-input-block">
                            <div class="upload">
                                <img id="add-upload" src="https://avatars1.githubusercontent.com/u/16045257?v=3&s=460">
                                <div class="upbar">
                                    <input name="add-image" class="layui-upload-file" id="image" type="file">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit lay-filter="*">立即提交</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="update">
                <form action="searchDriver" method="POST" class="layui-form">
                    <div class="layui-form-item search">
                        <input type="text" name="search" class="search-input" placeholder="键入需要查找的司机ID" required value="" />
                        <button class="layui-btn search-btn" lay-submit>查询</button>
                    </div>
                </form>
                <form action="updateDriver" method="POST" class="layui-form">
                    <div class="layui-form-item">
                        <label class="layui-form-label" for="update-id">司机ID</label>
                        <div class="layui-input-block">
                            <input type="text" id="update-id" name="id" placeholder="输入司机ID" required="true" class="layui-input" value="12" disabled>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="update-number" class="layui-form-label">司机手机号</label>
                        <div class="layui-input-block">
                            <input type="text" id="update-number" name="number" placeholder="输入司机手机号" required class="layui-input" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="update-name" class="layui-form-label">司机姓名</label>
                        <div class="layui-input-block">
                            <input type="text" id="update-name" name="name" placeholder="输入司机姓名" required class="layui-input" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="gender" class="layui-form-label">司机性别</label>
                        <div class="layui-input-block">
                            <input type="radio" name="gender" value="male" title="男" checked/>
                            <input type="radio" name="gender" value="female" title="女" />
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="update-age" class="layui-form-label">司机年龄</label>
                        <div class="layui-input-block">
                            <input type="number" id="update-age" name="age" max="70" min="18" value="25" placeholder="输入司机年龄" required class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="update-image" class="layui-form-label">司机头像</label>
                        <div class="layui-input-block">
                            <div class="upload">
                                <img id="update-upload" src="https://avatars1.githubusercontent.com/u/16045257?v=3&s=460">
                                <div class="upbar">
                                    <input name="update-image" class="layui-upload-file" id="image" type="file">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit lay-filter="*">立即提交</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </div>
			<div class="exam">
                <table class="layui-table" lay-even lay-skin="line">
                    <colgroup>
                        <col width="65"/>
                        <col width="100" />
                        <col width="100" />
                        <col width="60" />
                        <col width="60" />
                        <col width="150" />
                        <col width="250" />
                        <col/>
                    </colgroup>
                    <thead class="thead">
                        <tr>
                            <th>id</th>
                            <th>照片</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>年龄</th>
                            <th>电话</th>
                            <th>所属合作伙伴</th>
                            <th>操作</th>
                        </tr>
                        
                    </thead>
                </table>
                <div class="layui-layer-page" id="look-page"></div>
            </div>
        </div>


    <script type="text/javascript">
    var examTr=$('<tr><td name="id"></td><td><img name="image" class="" src="https://avatars1.githubusercontent.com/u/16045257?v=3&s=460" alt=""></td><td name="name"></td><td name="gender"></td><td name="age"></td><td name="number"></td><td name="company"></td><td><input type="button" value="审核" class="layui-btn exam-btn" /></td></tr>');
    var tr = $('<tr><td name="id"></td><td><img name="image" class="" src="https://avatars1.githubusercontent.com/u/16045257?v=3&s=460" alt=""></td><td name="name"></td><td name="gender"></td><td name="age"></td><td name="number"></td><td name="company"></td><td><input type="button" value="修改" class="layui-btn update-btn" /><input type="button" value="删除" class="layui-btn del-btn" /></td></tr>');
        layui.use(['laypage', 'layer'], function () {
            var laypage = layui.laypage
                , layer = layui.layer;
            laypage({
                cont: 'page'
                , pages: Math.ceil(10) //得到总页数
                , jump: function (obj) {
                    var curr = obj.curr;
                    console.log(curr);//page number
                    var tr = $('<tr><td name="id"></td><td><img name="image" class="" src="https://avatars1.githubusercontent.com/u/16045257?v=3&s=460" alt=""></td><td name="name"></td><td name="gender"></td><td name="age"></td><td name="number"></td><td name="company"></td><td><input type="button" value="修改" class="layui-btn update-btn" /><input type="button" value="删除" class="layui-btn del-btn" /></td></tr>');
                    $.get(
                        "http://localhost:8080/DiDiCMS/opratorDriver/showDriver?pageNumber="+curr,
                        function (driverList) {
                            $(".thead").css("display", "none");
                            for (var i in driverList) {
                                var driver = driverList[i];
                                var trTemp = tr.clone();
                                var tChild = trTemp.children();
                                tChild.get(0).innerText=driver.id;
                                tChild.get(1).innerHTML = '<img src=' + driver.image + '/>';
                                tChild.get(2).innerText = driver.name;
                                tChild.get(3).innerText = driver.gender;
                                tChild.get(4).innerText = driver.age;
                                tChild.get(5).innerText = driver.number;
                                tChild.get(6).innerText = driver.company;
                                console.log(trTemp);
                                $(".thead").append(trTemp);
                            }
                            $(".thead").css("display", "");
                        },
                        "json"
                    )
                }
            });
        });

        $(document).ready(function () {
            $.get(
                "oprator/showNotExamDriver?count=1"
                ,addToTableExam
                , "json"
            )
        });
    </script>
    
 <%@include file="opratorTemplateFooter.jsp" %>
