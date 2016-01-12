<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu=(e.pid==0)?string("商品属性","商品参数")>
	<form method="post" theme="simple">
				<input type="hidden" value="${e.pid!""}" name="pid" />
				<table class="table table-bordered">
					<tr>
						<td style="text-align: right;">
							商品分类
						</td>
						<td>
							<input type="hidden" id="catalogID2" value="${e.catalogID!""}"/>
							<select onchange="catalogChange(this)" name="catalogID" id="catalogSelect">
								<option value="0"></option>
								<#list catalogs as item>
									<option pid="0" value="${item.id!""}"><font color='red'>${item.name!""}</font></option>
									<#if item.children??>
										<#list item.children as item>
											<option value="${item.id!""}">&nbsp;&nbsp;&nbsp;&nbsp;${item.name!""}</option>
										</#list>
									</#if>
								</#list>
							</select>
							(请选择子目录查询。)
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<button method="selectList" class="btn btn-primary" onclick="selectList(this)">
								<i class="icon-search icon-white"></i> 查询
							</button>
							<a href="toAdd?pid=${e.pid!""}" class="btn btn-success">
								<i class="icon-plus-sign icon-white"></i> 添加
							</a>
							<button method="deletes" class="btn btn-danger" onclick="return submitIDs(this,'确定删除选择的记录?');">
								<i class="icon-remove-sign icon-white"></i> 删除
							</button>
							
							<#if e.pid==0>
								<span class="badge badge-important">商品属性列表</span>
							<#else>
								<span class="badge badge-info">商品参数列表</span>
							</#if>
							
							
							<div style="float: right;vertical-align: middle;bottom: 0px;top: 10px;">
								<#include "/manage/system/pager.ftl"/>
							</div>
						</td>
					</tr>
				</table>
				
				<table class="table table-bordered  table-hover">
					<tr style="background-color: #dff0d8">
						<th width="20"><input type="checkbox" id="firstCheckbox" /></th>
						<th style="display: none;">编号</th>
						<th nowrap="nowrap">名称</th>
						<th >子项</th>
						<th nowrap="nowrap">所属类别</th>
						<th nowrap="nowrap">顺序</th>
						<th nowrap="nowrap">操作</th>
					</tr>
					<#list pager.list as item>
						<tr>
							<td><input type="checkbox" name="ids"
								value="${item.id!""}" /></td>
							<td style="display: none;">&nbsp;${item.id!""}</td>
							<td nowrap="nowrap">&nbsp;${item.name!""}</td>
							<td>&nbsp;
								<#if item.attrList??>
									<#list item.attrList as ac>
										${(ac_index!=0)?string(",","")}${ac.name} 
									</#list>
								</#if>
							</td>
							<td nowrap="nowrap">&nbsp;${item.catalogName!""}</td>
							<td nowrap="nowrap">&nbsp;${item.order1!""}</td>
							<td nowrap="nowrap"><a href="toEdit?id=${item.id!""}">编辑</a></td>
						</tr>
					</#list>
					<tr>
						<td colspan="7" style="text-align: center;">
							<#include "/manage/system/pager.ftl"/>
						</td>
					</tr>
				</table>

	</form>
	
<script type="text/javascript">
	$(function() {
		selectDefaultCatalog();
	});
	
	function selectDefaultCatalog(){
		var _catalogID = $("#catalogID2").val();
		if(_catalogID!='' && _catalogID>0){
			$("#catalogSelect").attr("value",_catalogID);
		}
	}
</script>
</@page.pageBase>