<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@ include file="./resInclude.jsp"%>
    <title>系统出错</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="系统出错">
    <style type="text/css">

        /*#error{background-image:url(../images/error.png);width:430px;height:240px;text-align:left;}*/
        #error{
            background-image:url(${pageContext.request.contextPath}/ticc/common/images/error.png);
            width:430px;
            height:240px;
            margin: 150px auto;
        }
        #error p{
            font-size:12px;
            padding-top: 112px;
            color:#333;
            margin-left:120px;
            width:265px;
            line-height:22px
        }

    </style>
<body>
    <div id="error" >
        <p>
            请求路径错误
        </p>
    </div>
</body>
</html>

