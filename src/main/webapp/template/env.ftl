<#global basepath= (!request.getContextPath()?? || request.getContextPath()?length=0)?string("/",request.getContextPath()) />
<#global staticpath="${basepath}/resource" />
<#global ossRootPath="${systemSetting().imageRootPath}" />