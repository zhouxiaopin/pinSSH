<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@ include file="/WEB-INF/jsp/frame/common/resInclude.jsp"%>
    <title>系统资源管理</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="系统资源管理">
    <style type="text/css">

    </style>
</head>
<body>
<c:choose>
    <c:when test="${oprt == 'query'}">
        <jsp:include page="sysMenuQuery.jsp"/>
    </c:when>
    <c:otherwise>
    </c:otherwise>
</c:choose>

</body>
</html>
