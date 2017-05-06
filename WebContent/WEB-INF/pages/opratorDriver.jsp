<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="opratorTemplateHeader.jsp" %>
        <div class="layui-side layui-bg-black">
            <ul class="layui-nav layui-nav-tree layui-nav-side side" lay-filter="">
                <li class="layui-nav-item layui-nav-itemed"><a href="javascript:;">司机管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:switchToExam()">审核</a></dd>
                        <dd><a href="javascript:switchToAdd()">新增</a></dd>
                        <dd><a href="javascript:switchToLook()">查看</a></dd>
                    </dl>
                </li>
            </ul>
        </div>


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
                    <thead>
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
                    <tbody class="tbody">
                    </tbody>
                </table>
                <div class="layui-layer-page" id="exam-page"></div>
            </div>
            <div class="add display-none">
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
                        <label for="add-companyId" class="layui-form-label">所属公司ID</label>
                        <div class="layui-input-block">
                            <input type="text" id="add-companyId" name="companyId" placeholder="输入所属公司ID" required class="layui-input" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="add-image" class="layui-form-label">司机头像</label>
                        <div class="layui-input-block">
                            <div class="upload">
                                <img id="add-image" name="imagePath" src="https://avatars1.githubusercontent.com/u/16045257?v=3&s=460">
                                <div class="upbar">
                                    <input name="file" class="layui-upload-file"  type="file">
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
            <div class="update display-none">
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
                        <label for="update-companyId" class="layui-form-label">所属公司ID</label>
                        <div class="layui-input-block">
                            <input type="text" id="update-companyId" name="companyId" placeholder="输入所属公司ID" required class="layui-input" value="">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label for="update-image" class="layui-form-label">司机头像</label>
                        <div class="layui-input-block">
                            <div class="upload">
                                <img id="update-image" name="imagePath" src="https://avatars1.githubusercontent.com/u/16045257?v=3&s=460">
                                <div class="upbar">
                                    <input name="file" class="layui-upload-file" type="file">
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
			<div class="look display-none">
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
                    <thead>
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
                    <tbody class="tbody">
                    </tbody>
                </table>
                <div class="layui-layer-page" id="look-page"></div>
            </div>
        </div>
        
 <%@include file="templateContent.jsp" %>
<script type="text/javascript" src="../resource/opratorDriver.js"></script>
    <script type="text/javascript">
    var examTr=$('<tr><td name="id"></td><td><img name="image" class="" src="https://avatars1.githubusercontent.com/u/16045257?v=3&s=460" alt=""></td><td name="name"></td><td name="gender"></td><td name="age"></td><td name="number"></td><td name="company"></td><td><input type="button" value="审核" class="layui-btn exam-btn" /></td></tr>');
    var tr = $('<tr><td name="id"></td><td><img name="image" class="" src="https://avatars1.githubusercontent.com/u/16045257?v=3&s=460" alt=""></td><td name="name"></td><td name="gender"></td><td name="age"></td><td name="number"></td><td name="company"></td><td><input type="button" value="修改" class="layui-btn update-btn" /><input type="button" value="删除" class="layui-btn del-btn" /></td></tr>');
        $(document).ready(function () {
            /* $.get(
                "showNotExamDriver?count=1"
                ,addToTableExam
                , "json"
            ) */
        });
        layui.use('upload', function () {
            layui.upload({
                url: '../upload'
                //, elem: '#test' //指定原始元素，默认直接查找class="layui-upload-file"
                , method: 'post' //上传接口的http类型
                , success: function (res) {
                    console.log(res.src);
                    
                    $("#add-image").attr("src",res.date.src);
                }
            });
        });
        
    </script>
    
 <%@include file="opratorTemplateFooter.jsp" %>
