<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@ include file="../common/jsp/resInclude.jsp"%>
    <title>营运后台管理系统</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="营运后台管理系统">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/zcp/common/css/style.css" type="text/css" />
    <style rel="stylesheet" type="text/css">
        #container {width: 100%;height: 100%;}
    </style>
</head>
<body id="container" class="easyui-layout" >
    <%-- 顶部 --%>
    <div data-options="region:'north'" style="height:100px;">
        <jsp:include page="../layout1/top.jsp" flush="true"/>
    </div>
    <%-- 左边 --%>
    <div data-options="region:'west',title:'功能菜单',split:true" style="width:200px;">
        <jsp:include page="../layout1/left.jsp" flush="true"/>
    </div>
    <%-- 中间 --%>
    <div data-options="region:'center'" style="background:#eee;width:100%">
        <jsp:include page="../layout1/main.jsp" flush="true"/>
    </div>
    <%--底部--%>
    <div data-options="region:'south'">
        <jsp:include page="../layout1/bottom.jsp" flush="true"/>
    </div>
</body>
</html>
