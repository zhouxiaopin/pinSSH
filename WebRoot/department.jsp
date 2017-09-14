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
<form id="department" method="post">
    <table style="margin: 0 auto;">
        <tbody>
        <td colspan="2">
            <input name="departmentId" type="hidden"/>
        </td>
            <c:choose>
                <c:when test="${oprt == 'add'}">
                    <tr>
                        <th><label>部门编号:</label></th>
                        <td> <input name="departmentNo" class="easyui-validatebox" type="text" data-options="required:true" /></td>
                    </tr>
                    <tr>
                        <th><label >部门名称:</label></th>
                        <td><input name="departmentName" class="easyui-validatebox" type="text"/></td>
                    </tr>
                    <tr>
                        <th><label>部门电话:</label></th>
                        <td><input name="departmentPhone" class="easyui-validatebox" type="text" data-options="validType:'phone'" /></td>
                    </tr>
                    <tr>
                        <th><label>部门状态:</label></th>
                        <td><input name="status" class="easyui-validatebox" type="text" data-options="validType:'phone'" /></td>
                    </tr>
                </c:when>
                <c:when test="${oprt == 'update'}">
                    <tr>
                        <th><label >部门编号:</label></th>
                        <td> <input name="departmentNo" class="easyui-validatebox" type="text" data-options="required:true" /></td>
                    </tr>
                    <tr>
                        <th><label >部门名称:</label></th>
                        <td><input name="departmentName" class="easyui-validatebox" type="text"/></td>
                    </tr>
                    <tr>
                        <th><label >部门电话:</label></th>
                        <td><input name="departmentPhone" class="easyui-validatebox" type="text" data-options="validType:'phone'" /></td>
                    </tr>
                    <tr>
                        <th><label >部门状态:</label></th>
                        <td><input name="status" class="easyui-validatebox" type="text" data-options="validType:'phone'" /></td>
                    </tr>
                </c:when>
                <c:when test="${oprt == 'queryDesc'}">
                    <tr>
                        <th><label >部门编号:</label></th>
                        <td> <input name="departmentNo" class="easyui-validatebox" type="text" data-options="required:true" /></td>
                    </tr>
                    <tr>
                        <th><label >部门名称:</label></th>
                        <td><input name="departmentName" class="easyui-validatebox" type="text"/></td>
                    </tr>
                    <tr>
                        <th><label >部门电话:</label></th>
                        <td><input name="departmentPhone" class="easyui-validatebox" type="text" data-options="validType:'phone'" /></td>
                    </tr>
                    <tr>
                        <th><label >部门状态:</label></th>
                        <td><input name="status" class="easyui-validatebox" type="text" data-options="validType:'phone'" /></td>
                    </tr>
                    <tr>
                        <th><label >创建时间:</label></th>
                        <td><input name="createTime" class="easyui-validatebox" type="text" data-options="validType:'time'" /></td>
                    </tr>
                </c:when>
            </c:choose>
            <tr>
                <td colspan="2" style="text-align: center;padding-top: 5px">
                    <a href="javascript:void(0)" id="submitForm" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">确定</a>
                    <a href="javascript:void(0)" id="resetForm" class="easyui-linkbutton" data-options="iconCls:'icon-undo'">重置</a>
                </td>
            </tr>
        </tbody>
    </table>
</form>
<script type="text/javascript">

    $(function () {
        $('#department').form({
            url:'${pageContext.request.contextPath}/department/${oprt}.action',
            onSubmit: function(param){
//                $.messager.progress();	// 显示进度条
                // do some check
                // return false to prevent submit;
                var isValid = $(this).form('validate');
                if (!isValid){
//                    $.messager.progress('close');	// 如果表单是无效的则隐藏进度条
                }
                return isValid;	// 返回false终止表单提交
            },
            success:function(data){
                data = JSON.parse(data);
                if(true === data.status){
                    $.messager.alert('提示',data.msg,'info');
                }else {
                    $.messager.alert('提示',data.msg,'error');
                }

                //alert(data);
//                $.messager.progress('close');	// 如果提交成功则隐藏进度条
            }
        });
        $('#submitForm').on('click',function () {
            $('#department').form('submit');
        });
        $('#resetForm').on('click',function () {
            $('#department').form('reset');
        });

    });

</script>
</body>
</html>
