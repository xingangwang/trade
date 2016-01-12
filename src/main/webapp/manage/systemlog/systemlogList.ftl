<#import "/manage/tpl/pageBase.ftl" as page>
<@page.pageBase currentMenu="日志管理">
<#--<style type="text/css">-->
<#--.titleCss {-->
	<#--background-color: #e6e6e6;-->
	<#--border: solid 1px #e6e6e6;-->
	<#--position: relative;-->
	<#--margin: -1px 0 0 0;-->
	<#--line-height: 32px;-->
	<#--text-align: left;-->
<#--}-->

<#--.aCss {-->
	<#--overflow: hidden;-->
	<#--word-break: keep-all;-->
	<#--white-space: nowrap;-->
	<#--text-overflow: ellipsis;-->
	<#--text-align: left;-->
	<#--font-size: 12px;-->
<#--}-->

<#--.liCss {-->
	<#--white-space: nowrap;-->
	<#--text-overflow: ellipsis;-->
	<#--overflow: hidden;-->
	<#--height: 30px;-->
	<#--text-align: left;-->
	<#--margin-left: 10px;-->
	<#--margin-right: 10px;-->
<#--}-->
<#--</style>-->
	<form action="${basepath}/manage/systemlog" method="post" theme="simple">
				<table class="table table-bordered">
					<tr>
						<td style="text-align: right;">是否异登录</td>
						<td style="text-align: left;">
							<#assign y_n = {'':"全部",'y':'是','n':'否'}>
                            <select id="diffAreaLogin" name="diffAreaLogin">
							<#list y_n?keys as key>
                                <option value="${key}" <#if e.diffAreaLogin?? && e.diffAreaLogin==key>selected="selected" </#if>>${y_n[key]}</option>
							</#list>
                            </select>
						</td>
						<td>登录账号</td>
						<td><input type="text" value="${e.account!""}" class="input-medium search-query" name="account"/></td>
					</tr>
				</table>
				
				<table class="table table-bordered">
					<tr>
						<td colspan="16">
<!-- 								<i class="icon-search icon-white"></i> 查询 -->

							<button method="selectList" class="btn btn-primary" onclick="selectList(this)">
								<i class="icon-search icon-white"></i> 查询
							</button>
							
							<div style="float: right;vertical-align: middle;bottom: 0px;top: 10px;">
								<#include "/manage/system/pager.ftl" />
							</div>
						</td>
					</tr>
				</table>
				<table class="table table-bordered">
					<tr style="background-color: #dff0d8">
						<th width="20"><input type="checkbox" id="firstCheckbox" /></th>
						<th style="display: none;">编号</th>
						<th >标题</th>
						<th >账号</th>
<!-- 						<th >类型</th> -->
						<th >登录时间</th>
						<th >登录IP</th>
						<th >登录位置</th>
						<th >是否异地登录</th>
<!-- 						<th >操作</th> -->
					</tr>
					<#list pager.list as item>
						<tr>
							<td><input type="checkbox" name="ids"
								value="${item.id!""}"/></td>
							<td style="display: none;">&nbsp;${item.id!""}</td>
							<td>&nbsp;${item.title!""}</td>
							<td>&nbsp;${item.account!""}</td>
<#--<%-- 							<td>&nbsp;<s:property value="type" /></td> --%>-->
							<td>&nbsp;${item.logintime!""}</td>
							<td>&nbsp;${item.loginIP!""}</td>
							<td>&nbsp;${item.loginArea!""}</td>
							<td>&nbsp;
								<#if diffAreaLogin?? && diffAreaLogin=="y">是<#else>否 </#if>
							</td>
						</tr>
					</#list>
					<tr>
						<td colspan="17" style="text-align: center;">
							<#include "/manage/system/pager.ftl" /></td>
					</tr>
				</table>
	</form>
</@page.pageBase>