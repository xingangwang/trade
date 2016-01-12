<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="商品管理" jsFiles=["manage/product/productEdit.js"]>
<style>
#insertOrUpdateMsg{
border: 0px solid #aaa;margin: 0px;position: fixed;top: 0;width: 100%;
background-color: #d1d1d1;display: none;height: 30px;z-index: 9999;font-size: 18px;color: red;
}
</style>
<form action="${basepath}/manage/product" id="form" name="form" namespace="/manage" theme="simple" enctype="multipart/form-data" method="post">

	<div class="navbar navbar-inverse" >
		<div id="insertOrUpdateMsg">
			${insertOrUpdateMsg!""}
		</div>
	</div>
	
	<span id="pifeSpan" class="input-group-addon" style="display:none">${systemSetting().imageRootPath}</span>
	<input type="hidden" value="${e.id!""}" id="productID"/>
	<input type="hidden" value="${e.catalogID!""}" id="catalogID"/>

		<div style="text-align: center;">
			<div id="updateMsg"><font color='red'>${updateMsg!""}</font></div>
			<#if e.id??>
        		商品ID：<span class="badge badge-success">${e.id!""}</span>
                <#if e.activityID??>
           		 活动ID：<span class="badge badge-success">${e.activityID!""}</span>
                </#if>
                <button method="update" class="btn btn-success">
                    <i class="icon-ok icon-white"></i> 保存
                </button>

                <#if e.status??&&e.status!=2>
                    <button method="updateUpProduct?id=${e.id!""}" class="btn btn-warning" onclick="return confirm('确定上架商品吗?');">
                    	<i class="icon-arrow-up icon-white"></i> 上架
                    </button>
                <#else>
                    <button method="updateDownProduct?id=${e.id!""}" class="btn btn-warning" onclick="return confirm('确定下架商品吗?');">
                    	<i class="icon-arrow-down icon-white"></i> 下架
                    </button>
                </#if>

                <a class="btn btn-info" target="_blank" href="${basepath}/product/${e.id!""}.html">
                    <i class="icon-eye-open icon-white"></i>查看</a>
                <a target="_blank" href="${basepath}/freemarker/create?method=staticProductByID&id=${e.id!""}" class="btn btn-warning">
                    <i class="icon-refresh icon-white"></i>静态化</a>
            <#else>
                <button method="insert" class="btn btn-success">
                    <i class="icon-ok icon-white"></i> 新增
                </button>
			</#if>
			
<!-- 			<a href="selectList?init=y" class="btn btn-inverse">返回</a> -->
		</div>
		
		<div id="tabs">
			<ul>
				<li><a href="#tabs-1">基本信息</a></li>
				<li><a href="#tabs-2">商品介绍</a></li>
				<li><a href="#tabs-3">商品图片</a></li>
				<li><a href="#tabs-4">商品属性</a></li>
				<li><a href="#tabs-5">商品参数</a></li>
				<li><a href="#tabs-6">商品规格</a></li>
				<li><a href="#tabs-7">绑定商品赠品</a></li>
			</ul>
			<div id="tabs-1">
				<table class="table table-condensed">
							<tr style="display: none;">
								<td>id</td>
								<td><input type="hidden" value="${e.id!""}" name="id" label="id" id="id"/></td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td style="text-align: right;">名称</td>
								<td style="text-align: left;" colspan="3">
									<input type="text"  value="${e.name!""}" name="name"  data-rule="商品名称:required;name;length[0~44];" size="44" maxlength="44" style="width: 80%;"
										id="name" /></td>
							</tr>
							<tr>
								<td style="text-align: right;">所属子类别</td>
								<td colspan="1">
									<!-- 
									<input id="combotree22" name="catalogID" value="${e.catalogID!""}"
									class="easyui-combotree" data-options="url:'${basepath}/manage/catalog/catalog/getRootWithTreegrid?type=p',method:'get',required:false"
									></input>(请选择子类别)
									 -->
									
									<select onchange="catalogChange(this)" name="catalogID" id="catalogSelect" data-rule="类别:required;">
										<option></option>
                                        <#list catalogs as item>
                                            <option pid="0" value="${item.id!""}"><font color='red'>${item.name!""}</font></option>
                                            <#if item.children??>
                                                <#list item.children as item>
                                                    <option value="${item.id!""}">&nbsp;&nbsp;&nbsp;&nbsp;${item.name!""}</option>
                                                </#list>
                                            </#if>
                                        </#list>
									</select>
								</td>
								<td style="text-align: right;">单位</td>
								<td colspan="1">
                                    <#assign map = {'item':'件'}>
                                    <select id="unit" name="unit" class="input-medium">
                                        <#list map?keys as key>
                                            <option value="${key}" <#if e.unit?? && e.unit==key>selected="selected" </#if>>${map[key]}</option>
                                        </#list>
                                    </select>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;">简介</td>   
								<td style="text-align: left;" colspan="3">
									<textarea name="introduce" rows="3" cols="600" style="width:800px;" id="introduce"
									data-rule="商品简介;required;introduce;length[4~500];">${e.introduce!""}</textarea>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;">主图</td>   
								<td style="text-align: left;" colspan="3">
									<input type="button" id="setMainPic" value="浏览图片" class="btn btn-success"/>
									<input id="main_picture" type="text"  value="${e.picture!""}" name="picture" type="text" style="width: 600px;"
										data-rule="小图;required;maxPicture;"/>
									<a target="_blank" href="${systemSetting().imageRootPath}${e.picture!""}">
										<img style="max-width: 50px;max-height: 50px;" alt="" src="${systemSetting().imageRootPath}${e.picture!""}">
									</a>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;">定价</td>
								<td style="text-align: left;"><input type="text"  value="${e.price!""}" name="price" data-rule-price="[/^\d{0,8}\.{0,1}(\d{1,2})?$/, '必须为数字且最多两位小数']" data-rule="定价;required;price;" size="13" maxlength="13"
										id="price" /></td>
								<td style="text-align: right;">现价</td>
								<td style="text-align: left;"><input type="text"  value="${e.nowPrice!""}" name="nowPrice" data-rule-price="[/^\d{0,8}\.{0,1}(\d{1,2})?$/, '必须为数字且最多两位小数']" data-rule="现价;required;price;" size="13" maxlength="13"
										id="nowPrice" /></td>
							</tr>
							<tr>
								<td style="text-align: right;">所需积分</td>
								<td style="text-align: left;">
									<input type="text"  value="${e.score!""}" name="score" type="text"  id="score" maxlength="20" data-rule="销量;required;integer;score;"/>
								</td>
								<td style="text-align: right;"></td>
								<td style="text-align: left;">
								</td>
							</tr>
							<tr>
								<td style="text-align: right;">库存</td>
								<td style="text-align: left;"><input type="text"  value="${e.stock!""}" name="stock"  data-rule="库存;required;integer;stock;"
										id="stock" /></td>
								<td style="text-align: right;">销量</td>
								<td style="text-align: left;"><input type="text"  value="${e.sellcount!""}" name="sellcount"  data-rule="销量;required;integer;sellcount;"
										id="sellcount" /></td>
							</tr>
							<tr>
								<td style="text-align: right;">是否虚拟商品</td>
								<td style="text-align: left;">
                                    <#assign map = {'n':'否','y':'是'}>
                                    <select id="isVirtual" name="isVirtual" class="input-medium">
                                        <#list map?keys as key>
                                            <option value="${key}" <#if e.isVirtual?? && e.isVirtual==key>selected="selected"</#if>>${map[key]}</option>
                                        </#list>
                                    </select>
								</td>
								<td style="text-align: right;">是否新品</td>
								<td style="text-align: left;">
                                    <#assign map = {'n':'否','y':'是'}>
                                    <select id="isnew" name="isnew" class="input-medium">
                                        <#list map?keys as key>
                                            <option value="${key}" <#if e.isnew?? && e.isnew==key>selected="selected" </#if>>${map[key]}</option>
                                        </#list>
                                    </select>
								</td>
							</tr>
							
							<tr>
								<td style="text-align: right;">是否特价</td>
								<td style="text-align: left;">
                                    <#assign map = {'n':'否','y':'是'}>
                                    <select id="sale" name="sale" class="input-medium">
                                        <#list map?keys as key>
                                            <option value="${key}" <#if e.sale?? && e.sale==key>selected="selected" </#if>>${map[key]}</option>
                                        </#list>
                                    </select>
								</td>
								<td style="text-align: right;" nowrap="nowrap">送积分</td>
								<td style="text-align: left;" colspan="3">
									<input type="text"  value="${e.presentScore!""}" name="presentScore" type="text"  id="presentScore" maxlength="20" data-rule="销量;required;integer;presentScore;"/>
								</td>
							</tr>
							<tr>
								<td style="text-align: right;" nowrap="nowrap">页面标题</td>
								<td style="text-align: left;" colspan="3">
									<input type="text"  value="${e.title!""}" name="title" type="text"  maxlength="300" size="300" style="width: 80%;" />
								</td>
							</tr>
							<tr>
								<td style="text-align: right;" nowrap="nowrap">页面描述</td>
								<td style="text-align: left;" colspan="3">
									<input type="text"  value="${e.description!""}" name="description" type="text"  maxlength="300" size="300" style="width: 80%;" />
								</td>
							</tr>
							<tr>
								<td style="text-align: right;" nowrap="nowrap">页面关键字</td>
								<td style="text-align: left;" colspan="3">
									<input type="text"  value="${e.keywords!""}" name="keywords" type="text"  maxlength="300" size="300" style="width: 80%;" />
								</td>
							</tr>
							<tr>
								<td style="text-align: right;" nowrap="nowrap">其他信息</td>
								<td style="text-align: left;" colspan="3">
									录入人：<a style="text-decoration: underline;" target="_blank" href="${basepath}/manage/user/show?account=${e.createAccount!""}">${e.createAccount!""}</a>
									录入时间：${e.createtime!""}<br>
									最后修改人：<a style="text-decoration: underline;" target="_blank" href="${basepath}/manage/user/show?account=${e.updateAccount!""}">${e.updateAccount!""}</a>
									最后修改时间：${e.updatetime!""}
								</td>
							</tr>
						</table>
			</div>
			<div id="tabs-2">
				<textarea data-rule="商品介绍;required;productHTML;" id="productHTML" name="productHTML" style="width:100%;height:500px;visibility:hidden;">${e.productHTML!""}</textarea>
			</div>
			<div id="tabs-3">
				<div>
					<h4><div class="alert alert-info">图片列表</div></h4>
					<table id="img_table" class="table table-bordered">
						<tr>
							<td colspan="11">
								<button method="deleteImageByImgPaths" onclick="return deleteImageByImgPaths();"
											class="btn btn-primary">删除</button>
								<input type="button" id="addPic" value="添加" class="btn btn-success"/>
							</td>
						</tr>
						<tr style="background-color: #dff0d8">
							<th width="20"><input type="checkbox" id="firstCheckbox" /></th>
							<th>图片地址</th>
		<!-- 					<th>设为封面</th> -->
						</tr>
                        <#if e.imagesList??>
                            <#list e.imagesList as item>
                                <tr>
                                    <td><input type="checkbox" name="imagePaths" value="${item!""}" /></td>
                                    <td>
                                        <a href="${systemSetting().imageRootPath}${item!""}" target="_blank">
                                            <img style="max-width: 100px;max-height: 100px;" alt="" src="${systemSetting().imageRootPath}${item!""}">
                                        </a>
                                    </td>
                                </tr>
                            </#list>
                        </#if>
					</table>
				</div>
				<br>
			</div>
			
			<!-- 商品属性 -->
			<div id="tabs-4">
				<table class="table table-bordered">
                    <#if e.attrList??>
                        <#list e.attrList as attr>
                            <tr>
                                <td nowrap="nowrap" style="text-align: right;">${attr.name!""}</td>
                                <td>
                                    <select id="attrSelectIds" name="attrSelectIds">
                                        <option value="">--请选择--</option>
                                        <#list attr.attrList as item>
                                            <option value="${item.id!""}" <#if attr.selectedID==item.id?eval>selected="selected" </#if>>${item.name!""}</option>
                                        </#list>
                                    </select>
                                </td>
                            </tr>
                        </#list>
                    </#if>
				</table>
			</div>
			
			<!-- 商品参数 -->
			<div id="tabs-5">
				<table class="table">
                    <#if e.parameterList?? >
                        <#list e.parameterList as param>
                            <tr>
                                <th style="display: none;"><input type="hidden" value="${param.id!""}" name="param.id"/></th>
                                <th style="text-align: right;">${param.name!""}</th>
                                <th><input type="text"  value="${param.parameterValue!""}" name="parameterValue" /></th>
                            </tr>
                        </#list>
                    </#if>
				</table>
			</div>
			
			<!-- 商品规格 -->
			<div id="tabs-6">
				<table class="table">
					<tr>
						<th style="display: none;">id</th>
						<th>尺寸</th>
						<th>颜色</th>
						<th>规格库存数</th>
						<th>价格</th>
						<th>是否显示</th>
					</tr>
					<#if e.specList??>
                        <#list e.specList as item>
							<tr>
								<th style="display: none;"><input type="hidden" value="${item.id!""}" name="specList[${item_index}].id"/></th>
								<th><input type="text"  value="${e.specList[item_index].specSize!""}" name="specList[${item_index}].specSize"  class="search-query input-small"/></th>
								<th><input type="text"  value="${e.specList[item_index].specColor!""}" name="specList[${item_index}].specColor"  class="search-query input-small"/></th>
								<th><input type="text"  value="${e.specList[item_index].specStock!""}" name="specList[${item_index}].specStock"  class="search-query input-small"/></th>
								<th><input type="text"  value="${e.specList[item_index].specPrice!""}" name="specList[${item_index}].specPrice"  class="search-query input-small"/></th>
								<th>
                                    <#assign map = {'n':'不显示','y':'显示'}>
                                    <select id="e_spec_specStatus" name="specList[${item_index}].specStatus" class="search-query input-medium">
                                        <#list map?keys as key>
                                            <option value="${key}" <#if item.specStatus?? && item.specStatus==key>selected="selected" </#if>>${map[key]}</option>
                                        </#list>
                                    </select>
                                </th>
							</tr>
                        </#list>
					<#else>
                        <#list [1,2] as item>
							<tr>
								<th style="display: none;"><input type="hidden" value="${e.id!""}" name="specList[${item_index}].id"/></th>
								<th><input type="text" name="specList[${item_index}].specColor"  class="search-query input-small"/></th>
								<th><input type="text" name="specList[${item_index}].specSize"  class="search-query input-small"/></th>
								<th><input type="text" name="specList[${item_index}].specStock"  class="search-query input-small"/></th>
								<th><input type="text" name="specList[${item_index}].specPrice"  class="search-query input-small"/></th>
								<th>
                                    <#assign map = {'n':'不显示','y':'显示'}>
                                    <select id="e_spec_specStatus" name="specList[${item_index}].specStatus" class="search-query input-medium">
                                        <#list map?keys as key>
                                            <option value="${key}">${map[key]}</option>
                                        </#list>
                                    </select>
                                </th>
							</tr>
                        </#list>
					</#if>
				</table>
			</div>
			
			<div id="tabs-7">
				商品赠品:
                    <select name="giftID">
                        <option></option>
                        <#if giftList??>
                            <#list giftList as item>
                                <option value="${item.id}">${item.giftName!""}</option>
                            </#list>
                        </#if>
                    </select>
			</div>
			
		</div>
</form>
<div id="imgTemp" style="display:none;">
	<table>
		<tr>
		    <td><input type="checkbox" name="imagePathsToDelete" value="" /></td>
		    <td>
		        <a href="" target="_blank">
		            <img style="max-width: 100px;max-height: 100px;" alt="" src="">
		            <input type="hidden" name="imagesList" value=""/>
		        </a>
		    </td>
		</tr>
	</table>
</div>
</@page.pageBase>