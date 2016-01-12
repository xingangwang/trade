<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<#assign non_responsive2>y</#assign>
<#assign responsive_session2>${Session["responsive"]!""}</#assign>
<#if responsive_session2 == "y">
	<#assign non_responsive2>n</#assign>
<#elseif systemSetting().openResponsive == "n">
	<#assign non_responsive2>y</#assign>
<#else>
	<#assign non_responsive2>n</#assign>
</#if>
<#if non_responsive2 == "n">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</#if>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${systemSetting().title}</title>
<meta name="description" content="${systemSetting().description}" />
<meta name="keywords"  content="${systemSetting().keywords}" />
<link rel="shortcut icon" type="image/x-icon" href="${systemSetting().shortcuticon}">

