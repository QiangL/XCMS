<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="TemplateHeader.jsp"%>
<div class="layui-side layui-bg-black">
	<ul class="layui-nav layui-nav-tree layui-nav-side side" lay-filter="">
		<li class="layui-nav-item layui-nav-itemed"><a
			href="javascript:;">车辆管理</a>
			<dl class="layui-nav-child">
				<dd>
					<a href="javascript:switchToExamAdd()">审核增加</a>
				</dd>
				<dd>
					<a href="javascript:switchToExamDel()">审核删除</a>
				</dd>
				<dd>
					<a href="javascript:switchToAdd()">新增</a>
				</dd>
				<dd class="layui-this">
					<a href="javascript:switchToLook()">查看</a>
				</dd>
			</dl></li>
	</ul>
</div>


<div class="layui-layer-content content">
	<div class="examAdd display-none">
		<table class="layui-table" lay-even lay-skin="line">
			<colgroup>
				<col width="65" />
				<col width="100" />
				<col width="100" />
				<col width="150" />
				<col width="60" />
				<col width="60" />
				<col width="100" />
				<col />
			</colgroup>
			<thead>
				<tr>
					<th>id</th>
					<th>照片</th>
					<th>车牌号</th>
					<th>车型</th>
					<th>颜色</th>
					<th>排量</th>
					<th>所属合作伙伴</th>
					<th>操作</th>
				</tr>

			</thead>
			<tbody class="tbody">
			</tbody>
		</table>
		<div class="layui-layer-page" id="examAdd-page"></div>
	</div>
	<div class="examDel display-none">
		<table class="layui-table" lay-even lay-skin="line">
			<colgroup>
				<col width="65" />
				<col width="100" />
				<col width="100" />
				<col width="150" />
				<col width="60" />
				<col width="60" />
				<col width="100" />
				<col />
			</colgroup>
			<thead>
				<tr>
					<th>id</th>
					<th>照片</th>
					<th>车牌号</th>
					<th>车型</th>
					<th>颜色</th>
					<th>排量</th>
					<th>所属合作伙伴</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="tbody">
			</tbody>
		</table>
		<div class="layui-layer-page" id="examDel-page"></div>
	</div>
	<div class="add  display-none">
		<form action="oprator/addCar" method="POST" class="layui-form">
			<div class="layui-form-item">
				<label class="layui-form-label" for="add-id">车辆ID</label>
				<div class="layui-input-block">
					<input type="text" id="add-id" name="id" placeholder="车辆ID，12位"
						required="true" class="layui-input" value="">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="add-number" class="layui-form-label">车牌号</label>
				<div class="layui-input-block">
					<input type="text" id="add-number" name="number"
						placeholder="输入车牌号,7位" required class="layui-input" value="">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="add-color" class="layui-form-label">车辆颜色</label>
				<div class="layui-input-block">
					<input type="text" id="add-color" name="color" placeholder="输入车辆颜色"
						required class="layui-input" value="">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="add-model" class="layui-form-label">车型</label>
				<div class="layui-input-block">
					<input type="text" id="add-model" name="model" placeholder="输入车型"
						required class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="add-displacement" class="layui-form-label">排量</label>
				<div class="layui-input-block">
					<input type="text" id="add-displacement" name="displacement"
						placeholder="输入排量" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="add-companyId" class="layui-form-label">所属公司</label>
				<div class="layui-input-block">
					<select name="companyId" lay-verify="">
						<option value="">请选择一个公司</option>
						<c:forEach var="company" items="${companyList }">
							<option value="${company.id }">${company.name }</option>
						</c:forEach>
					</select>
					<!-- <input type="text" id="add-companyId" name="companyId"
						placeholder="输入所属公司ID" required class="layui-input" value=""> -->
				</div>
			</div>
			<div class="layui-form-item">
				<label for="add-image" class="layui-form-label">车辆照片</label>
				<div class="layui-input-block">
					<div class="upload">
						<input type="hidden" id="add-imagePath" name="imagePath"
							value="https://avatars1.githubusercontent.com/u/16045257?v=3&s=460" />
						<img id="add-image"
							src="https://avatars1.githubusercontent.com/u/16045257?v=3&s=460">
						<div class="upbar">
							<input name="file" id="add-image-input" class="layui-upload-file"
								type="file">
						</div>
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn car-form-btn" lay-submit lay-filter="add">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
	</div>

	<div class="look">
		<form action="searchDriver" method="POST" class="layui-form">
			<div class="layui-form-item search">
				<input type="text" name="search" class="search-input"
					placeholder="键入需要查找的车辆ID" required value="" />
				<button class="layui-btn search-btn" lay-submit>查询</button>
			</div>
		</form>

		<table class="layui-table" lay-even lay-skin="line">
			<colgroup>
				<col width="65" />
				<col width="100" />
				<col width="100" />
				<col width="150" />
				<col width="60" />
				<col width="60" />
				<col width="100" />
				<col />
			</colgroup>
			<thead>
				<tr>
					<th>id</th>
					<th>照片</th>
					<th>车牌号</th>
					<th>车型</th>
					<th>颜色</th>
					<th>排量</th>
					<th>所属合作伙伴</th>
					<th>操作</th>
				</tr>

			</thead>
			<tbody class="tbody">
			</tbody>
		</table>
		<div class="layui-layer-page" id="look-page"></div>
	</div>
	<div class="update display-none">
		<form action="oprator/updateCar" method="POST" class="layui-form">
			<div class="layui-form-item">
				<label class="layui-form-label" for="update-id">车辆ID</label>
				<div class="layui-input-block">
					<input type="text" id="update-id" name="id" placeholder="车辆ID"
						required="true" class="layui-input" value="" readonly="readonly">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="update-number" class="layui-form-label">车牌号</label>
				<div class="layui-input-block">
					<input type="text" id="update-number" name="number"
						placeholder="输入车牌号" required class="layui-input" value="">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="update-color" class="layui-form-label">车辆颜色</label>
				<div class="layui-input-block">
					<input type="text" id="update-color" name="color"
						placeholder="输入车辆颜色" required class="layui-input" value="">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="update-model" class="layui-form-label">车型</label>
				<div class="layui-input-block">
					<input type="text" id="update-model" name="model"
						placeholder="输入车型" required class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="update-displacement" class="layui-form-label">排量</label>
				<div class="layui-input-block">
					<input type="text" id="update-displacement" name="displacement"
						placeholder="输入排量" required class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="update-companyId" class="layui-form-label">所属公司</label>
				<div class="layui-input-block">
					<select name="companyId" lay-verify="">
						<option value="">请选择一个公司</option>
						<c:forEach var="company" items="${companyList }">
							<option value="${company.id }">${company.name }</option>
						</c:forEach>
					</select>
					<!-- <input type="text" id="update-companyId" name="companyId"
						placeholder="输入所属公司ID" required class="layui-input" value=""> -->
				</div>
			</div>
			<div class="layui-form-item">
				<label for="update-image" class="layui-form-label">车辆照片</label>
				<div class="layui-input-block">
					<div class="upload">
						<input type="hidden" id="update-imagePath" name="imagePath"
							value="https://avatars1.githubusercontent.com/u/16045257?v=3&s=460" />
						<img id="update-image"
							src="https://avatars1.githubusercontent.com/u/16045257?v=3&s=460">
						<div class="upbar">
							<input name="file" id="update-image-input"
								class="layui-upload-file" type="file">
						</div>
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="update">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
	</div>
</div>

<%@include file="templateContent.jsp"%>
<%-- 
<input id="OpratorNotExamAddCarPageNum" type="hidden" value="${OpratorNotExamAddCarPageNum/8 }"/>
<input id="OpratorNotExamDelCarPageNum" type="hidden" value="${OpratorNotExamDelCarPageNum/8 }"/>
<input id="OpratorCarPageNum" type="hidden"  value="${OpratorCarPageNum/8 }"/>
 --%>
<script type="text/javascript" src="resource/opratorCar.js"></script>
<script type="text/javascript" src="resource/carCheck.js"></script>
<script type="text/javascript">
	var examAddTr = $('<tr><td name="id"></td><td><img name="image" class="" src="https://avatars1.githubusercontent.com/u/16045257?v=3&s=460" alt=""></td><td name="number"></td><td name="model"></td><td name="color"></td><td name="displacement"></td><td name="company"></td><td><input type="button" value="同意增加" class="layui-btn exam-btn" /><input type="button" value="不同意" class="layui-btn disagree-btn" /><input type="hidden" name="companyId" value=""></td></tr>');
	var examDelTr = $('<tr><td name="id"></td><td><img name="image" class="" src="https://avatars1.githubusercontent.com/u/16045257?v=3&s=460" alt=""></td><td name="number"></td><td name="model"></td><td name="color"></td><td name="displacement"></td><td name="company"></td><td><input type="button" value="同意删除" class="layui-btn exam-btn" /><input type="button" value="不同意" class="layui-btn disagree-btn" /><input type="hidden" name="companyId" value=""></td></tr>');
	var tr = $('<tr><td name="id"></td><td><img name="image" class="" src="https://avatars1.githubusercontent.com/u/16045257?v=3&s=460" alt=""></td><td name="number"></td><td name="model"></td><td name="color"></td><td name="displacement"></td><td name="company"></td><td><input type="button" value="修改" class="layui-btn update-btn" /><input type="button" value="删除" class="layui-btn del-btn"/><input name="companyId" type="hidden" value=""></td></tr>');
</script>

<%@include file="TemplateFooter.jsp"%>
