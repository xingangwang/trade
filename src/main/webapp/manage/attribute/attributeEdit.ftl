<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu=(e.pid==0)?string("商品属性","商品参数") jsFiles=["manage/attribute/attributeEdit.js"]>
<style>
	.leftTD_css{
		width: 100px;
		text-align: right;
	}
	#insertOrUpdateMsg{
		border: 0px solid #aaa;margin: 0px;position: fixed;top: 0;width: 100%;
		background-color: #d1d1d1;display: none;height: 30px;z-index: 9999;font-size: 18px;color: red;
	}
</style>
	<input type="hidden" value="${e.catalogID!""}" id="catalogID"/>
	<form action="${basepath}/manage/attribute" theme="simple" id="form">
		<input type="hidden" value="${e.pid!""}" name="pid" />
		<table class="table table-bordered">
			<tr style="background-color: #dff0d8">
				<td colspan="2" style="background-color: #dff0d8;text-align: center;">
					<strong>属性编辑</strong>
					<#if e.pid==0>
						<span class="badge badge-important">商品属性</span>&nbsp;<strong>
					<#else>
						<span class="badge badge-success">商品参数</span>&nbsp;<strong>
					</#if>
				</td>
			</tr>
			<tr style="display: none;">
				<td><input type="hidden" value="${e.id!""}" name="id"/></td>
			</tr>
			<tr>
				<td class="leftTD_css">分类目录</td>
				<td style="text-align: left;">
					<!-- 
					<input id="cc" class="easyui-combotree" name="catalogID" value="${e.catalogID!""}"
					data-options="url:'<%=request.getContextPath() %>/manage/catalog/catalog/getRootWithTreegrid?type=p',method:'get',required:false"
					>
				(注意：只能选择子目录。)
					 -->
				
					<select onchange="catalogChange(this)" name="catalogID" id="catalogSelect" data-rule="required;select;remote[uniqueCatalog, id]">
						<option></option>
						<#list catalogs as item>
							<option pid="0" value="${item.id!""}"><font color='red'>${item.name!""}</font></option>
							<#if item.children??>
								<#list item.children as item>
									<option value="${item.id!""}">&nbsp;&nbsp;&nbsp;&nbsp;${item.name!""}</option>
								</#list>
							</#if>
						</#list>
					</select><br>(请选择子类别)
				</td>
			</tr>
			<tr>
				<td class="leftTD_css">名称</td>
				<td style="text-align: left;"><input type="text"  value="${e.name!""}" name="name"  data-rule="required;name;length[1~20];"
						id="name" /></td>
			</tr>
			<tr>
				<td class="leftTD_css">顺序</td>
				<td style="text-align: left;">
					<input type="text"  value="${e.order1!""}" name="order"
						id="order1" data-rule="required;integer;length[1~5];" />
				</td>
			</tr>
			<tr style="background-color: #dff0d8">
				<td>
					<input type="button" onclick="addAttribute();" value="增加属性" class="btn btn-warning"/>
				</td>
				<td style="text-align: center;">
					<#if e.id??>
                        <button method="insert" class="btn btn-success">
                            <i class="icon-ok icon-white"></i> 保存
                        </button>
					<#else>
                        <button method="insert" class="btn btn-success">
                            <i class="icon-ok icon-white"></i> 新增
                        </button>
					</#if>
				</td>
			</tr>
			<#if e.attrList?exists>
				<#list e.attrList as item>
					<tr class="pclass">
						<td class="leftTD_css">名称</td>
						<td style="text-align: left;">
							<input type="text"  name="attrList[${item_index}].name"  value="${item.name}" data-rule="required;length[1~20];"/>
							<input type="hidden"  name="attrList[${item_index}].id"  value="${item.id}" />
							<span style="margin-left:150px;"></span>显示顺序：
							<input type="text"  name="attrList[${item_index}].order1" number="y" value="${item.order1}" size="5" maxlength="5"
								data-rule="required;integer;length[1~5];" />
						</td>
					</tr>
				</#list>
			<#else>
				<tr class="pclass">
					<td class="leftTD_css">名称</td>
					<td style="text-align: left;">
						<input type="text"  name="attrList[0].name"  value="" data-rule="required;length[1~20];"/>
						<input type="hidden"  name="attrList[0].id"  value="" />
						<span style="margin-left:150px;"></span>显示顺序：
						<input type="text"  name="attrList[0].order1" number="y" value="" size="5" maxlength="5"
							data-rule="required;integer;length[1~5];" />
					</td>
				</tr>
			</#if>
		</table>
	</form>
	<table style="display:none;">
			<tr id="cloneTR" class="pclass">
				<td class="leftTD_css">名称</td>
				<td style="text-align: left;">
					<input type="text"  name="attrName"  placeholder="请输入属性名称" data-rule="required;length[1~20];"/>
					<input type="hidden"  name="attrId" value="" />
					<span style="margin-left:150px;"></span> 显示顺序：
					<input type="text"  name="attrOrder" number="y" placeholder="请输入属性显示的顺序" value="" size="5" maxlength="5"
						data-rule="required;integer;length[1~5];"/>
				</td>
			</tr>
	<table>
	
</@page.pageBase>