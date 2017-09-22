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
        <form id="sysMenuForm" method="post">
            <table style="margin: 0 auto;">
                <tbody>
                <td colspan="2">
                    <label id="retMsg" style="display:block;text-align: center;color: #FF0000">${retMsg}</label>
                    <input name="sysMenuId" value="${obj.sysMenuId}" type="hidden"/>
                </td>
                <c:choose>
                    <c:when test="${oprt == 'add'}">
                        <tr>
                            <th><label>菜单编号:</label></th>
                            <td> <input name="sysMenuNo" missingMessage="菜单编号不能为空" value="${obj.sysMenuNo}" class="easyui-textbox easyui-validatebox" type="text" data-options="required:true" /></td>
                        </tr>
                        <tr>
                            <th><label >菜单名称:</label></th>
                            <td><input name="sysMenuName" value="${obj.sysMenuName}" class="easyui-textbox easyui-validatebox" type="text"/></td>
                        </tr>
                        <tr>
                            <th><label >url:</label></th>
                            <td><input name="url" value="${obj.url}" class="easyui-textbox easyui-validatebox" type="text"/></td>
                        </tr>
                        <tr>
                            <th><label >菜单父编号:</label></th>
                            <td><input name="parentNo" value="${obj.parentNo}" class="easyui-textbox easyui-validatebox" type="text"/></td>
                        </tr>
                        <tr>
                            <th><label >菜单级别:</label></th>
                            <td><input name="levelCode" value="${obj.levelCode}" class="easyui-textbox easyui-validatebox" type="text"/></td>
                        </tr>
                        <tr>
                            <th><label >使用状态:</label></th>
                            <td><input name="useStatus" value="${obj.useStatus}" class="easyui-textbox easyui-validatebox" type="text"/></td>
                        </tr>
                    </c:when>

                </c:choose>
                <tr>
                    <td colspan="2" style="text-align: center;padding-top: 5px">
                        <a id="submitForm" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确定</a>
                        <a id="resetForm" class="easyui-linkbutton" data-options="iconCls:'icon-undo'">重置</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </form>

        <script type="text/javascript">
            $(function () {
                if("${oprt }" == "queryDetail"){
                    $("#sysMenuForm").find(":input").attr("disabled",true);
                    $("#sysMenuForm").find("a").attr("disabled",true);
                }

                $('#sysMenuForm').form({
                    url:'${pageContext.request.contextPath}/sysMenu/${oprt}.action',
                    onSubmit: function(param){
                        var isValid = $(this).form('validate');
                        if (!isValid){
                            $('#retMsg').html("表单校验不通过");
                        }
                        return isValid;	// 返回false终止表单提交
                    },
                    success:function(data){
                        data = JSON.parse(data);
                        $('#retMsg').html(data.msg);
                    }
                });
                $('#submitForm').on('click',function () {
                    if ($(this).linkbutton('options').disabled == false) {
                        $('#sysMenuForm').form('submit');
                    }
                });
                $('#resetForm').on('click',function () {
                    if ($(this).linkbutton('options').disabled == false) {
                        $('#sysMenuForm').form('reset');
                    }
                });

            });

        </script>
    </c:otherwise>
</c:choose>

</body>
</html>
