<#macro htmlBase title="" jsFiles=[] cssFiles=[] staticJsFiles=[] staticCssFiles=[] checkLogin=true>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <#assign non_responsive2>y</#assign>
    <#assign responsive>${Session["responsive"]!""}</#assign>
    <#if responsive == "y">
        <#assign non_responsive2>n</#assign>
    <#elseif systemSetting().openResponsive == "n">
        <#assign non_responsive2>y</#assign>
    <#else >
        <#assign non_responsive2>n</#assign>
    </#if>
    <script>
    	window.jns || (jns = {});
        jns.basepath = "${basepath}";
        jns.staticpath = "${staticpath}";
        var ossRootPath = "${ossRootPath}";
        var non_responsive2 = "${non_responsive2}";
        
        <#if checkLogin && !currentUser()??>
        	top.location = "${basepath}/manage/user/logout";
        </#if>
        	 
        <#if currentUser()?? >
            var login = true;
        	var currentUser = "${currentUser().username}";
        <#else >
        	var login = false;
        	var currentUser = "";
        </#if>
    </script>
    <#if non_responsive2 != "y">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </#if>
    <meta name="description" content="${systemSetting().description}"/>
    <meta name="keywords" content="${systemSetting().keywords}"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${systemSetting().title!"选我吧后台管理系统"}</title>
    <#--<link rel="shortcut icon" type="image/x-icon" href="${systemSetting().shortcuticon}">-->
    <link rel="stylesheet" href="${staticpath}/zTree3.5/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <#--<link rel="stylesheet" href="${staticpath}/bootstrap/css/bootstrap.min.css"  type="text/css">-->
    <link rel="stylesheet" href="${staticpath}/bootstrap3.0.0/css/bootstrap.min.css"  type="text/css">
    <#--<link rel="stylesheet" href="${staticpath}/css/base.css"  type="text/css">-->
    <#--<link rel="stylesheet" href="${staticpath}/bootstrap3.0.0/css/docs.css"  type="text/css">-->
    <link rel="stylesheet" href="${staticpath}/jquery-jquery-ui/themes/base/jquery.ui.all.css">
    <link rel="stylesheet" href="${staticpath}/validator-0.7.0/jquery.validator.css" />

<#--<script type="text/javascript" src="${staticpath}/js/jquery-1.9.1.min.js"></script>--> 
    <script type="text/javascript" src="${staticpath}/js/jquery-1.9.1.js"></script> 
    <script type="text/javascript" src="${staticpath}/zTree3.5/js/jquery.ztree.all-3.5.min.js"></script>

    <script type="text/javascript" src="${staticpath}/js/jquery.blockUI.js"></script>
    <script type="text/javascript" src="${staticpath}/bootstrap3.0.0/js/bootstrap.min.js"></script>
    <!-- sb admin -->
    <link rel="stylesheet" href="${staticpath}/sb-admin/css/sb-admin-2.css" />
    <script src="${staticpath}/sb-admin/js/sb-admin-2.js" ></script>

    <link href="${staticpath}/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <#--<script src="${staticpath}/jquery-jquery-ui/jquery-1.5.1.js"></script>-->
    <script src="${staticpath}/jquery-jquery-ui/ui/jquery.ui.core.js"></script>
    <script src="${staticpath}/jquery-jquery-ui/ui/jquery.ui.widget.js"></script>
    <script src="${staticpath}/jquery-jquery-ui/ui/jquery.ui.tabs.js"></script>
    <!-- jquery validator -->
    <script type="text/javascript" src="${staticpath}/validator-0.7.0/src/jquery.validator.js"></script>
    <script type="text/javascript" src="${staticpath}/validator-0.7.0/local/zh_CN.js"></script>

    <script type="text/javascript" src="${staticpath}/My97DatePicker/WdatePicker.js"></script>

    <link rel="stylesheet" href="${staticpath}/kindeditor-4.1.10/themes/default/default.css" />
    <script charset="utf-8" src="${staticpath}/kindeditor-4.1.10/kindeditor-min.js"></script>
    <#--<script charset="utf-8" src="${staticpath}/kindeditor-4.1.10/kindeditor.js"></script>-->
    <script charset="utf-8" src="${staticpath}/kindeditor-4.1.10/lang/zh_CN.js"></script>

    <!-- datatables -->
    <link rel="stylesheet" href="${staticpath}/datatables/css/jquery.dataTables.css" />
    <script charset="utf-8" src="${staticpath}/datatables/js/jquery.dataTables.js"></script>
    <link rel="stylesheet" href="${staticpath}/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" />
    <script charset="utf-8" src="${staticpath}/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.js"></script>

    <!-- metisMenu -->
    <link href="${staticpath}/metisMenu/metisMenu.min.css" rel="stylesheet">
    <script src="${staticpath}/metisMenu/metisMenu.min.js"></script>
    <#--<link rel="stylesheet" href="${staticpath}/datatables-responsive/css/dataTables.responsive.css" />-->
    <#--<script charset="utf-8" src="${staticpath}/datatables-responsive/js/dataTables.responsive.js"></script>-->
    <script type="text/javascript" src="${basepath}/manage/manage.js"></script>
    <#list staticJsFiles as jsFile>
        <script src="${staticpath}/${jsFile}"></script>
    </#list>
    <#list staticCssFiles as cssFile>
        <link rel="stylesheet" href="${staticpath}/${cssFile}" />
    </#list>

    <#list jsFiles as jsFile>
        <script src="${basepath}/${jsFile}"></script>
    </#list>
    <#list cssFiles as cssFile>
        <link rel="stylesheet" href="${basepath}/manage/${cssFile}" />
    </#list>
</head>
<#nested />
</html>
</#macro>
