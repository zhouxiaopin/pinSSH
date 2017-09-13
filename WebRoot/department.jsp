<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@ include file="/zcp/common/jsp/resInclude.jsp"%>
    <title>部门管理</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="部门管理">
    <style type="text/css">

    </style>
</head>
<body>
<form id="ff" method="post">
    <table style="margin: 0 auto;">
        <tbody>
        <tr>
            <th><label for="name">姓名:</label></th>
            <td> <input id="name" class="easyui-validatebox" type="text" name="name" data-options="required:true" /></td>
        </tr>
        <tr>
            <th><label for="email">邮箱:</label></th>
            <td> <input id="email" class="easyui-validatebox" type="text" name="email" data-options="validType:'email'" /></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center;padding-top: 5px">
                <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确定</a>
                <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-undo'">重置</a>
            </td>
        </tr>
        </tbody>
    </table>
</form>

</body>
</html>
